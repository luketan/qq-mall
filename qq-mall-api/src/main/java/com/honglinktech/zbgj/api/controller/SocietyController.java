package com.honglinktech.zbgj.api.controller;


import com.honglinktech.zbgj.api.base.BaseApiController;
import com.honglinktech.zbgj.base.BaseException;
import com.honglinktech.zbgj.base.ExceptionEnum;
import com.honglinktech.zbgj.bean.*;
import com.honglinktech.zbgj.common.AppAgent;
import com.honglinktech.zbgj.common.Response;
import com.honglinktech.zbgj.common.Result;
import com.honglinktech.zbgj.entity.Module;
import com.honglinktech.zbgj.service.ModuleService;
import com.honglinktech.zbgj.service.SocietyService;
import com.honglinktech.zbgj.service.UserService;
import com.honglinktech.zbgj.vo.UserVO;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

/**
 * 社区管理
 * @author Administrator
 */
@RestController
@RequestMapping("/society/api")
public class SocietyController extends BaseApiController {
	private final Logger logger = LogManager.getLogger(getClass());
	@Resource
	private ModuleService moduleService;
	@Resource
	private SocietyService societyService;
	@Resource
	private UserService userService;
	/**
	 * 帖子首页
	 * @return
	 * @throws BaseException
	 */
	@RequestMapping(value="findSocietyHome",method={RequestMethod.POST})
	@ResponseBody
	public Response<Map<String,Object>> findHome(@RequestBody Map<String, String> map) throws BaseException{

		UserVO user = (UserVO) request.getAttribute("user");
		AppAgent agent = (AppAgent) request.getAttribute("agent");

		Map<String,Object> retMap = new HashMap<String, Object>();
		
		Map where = new HashMap();
		where.put("mainType", 2);
		List<Module> modules = moduleService.findByWhere(where);
		List<HomeBean> homeBeans = new LinkedList<HomeBean>();
		for(Module module:modules){
			homeBeans.add(new HomeBean(module));
		}
		retMap.put("homeSoc", homeBeans);
		//用户关注主题
		if(user != null){
			Response<List<SocietySubTypeBean>> resp = societyService.findUserSocSubBean(user.getId());
			retMap.put("userSoc", resp.getResult());
		}
		//推荐主题
		Response<List<SocietySubTypeBean>> respSocietySubAll = societyService.findRecSocSubBean(user != null?user.getId():null);
		List<SocietySubTypeBean> socList = respSocietySubAll.getResult();
		if(socList != null){
			retMap.put("recSoc", socList);
		}
		//推荐用户
		Response<List<UserVO>> respRecUser = userService.findRecUsers(user != null?user.getId():null);
		List<UserVO> userList = respRecUser.getResult();
		if(userList != null){
			retMap.put("recUser", userList);
		}
		
		return Result.resultSet(retMap); 
	}
	/**
	 * 推荐主题
	 * @param map
	 * @return
	 * @throws BaseException
	 */
	@RequestMapping(value="atteSocSub",method={RequestMethod.POST})
	@ResponseBody
	public Response<String> atteSocSub(@RequestBody Map<String, String> map) throws BaseException{

		UserVO user = (UserVO) request.getAttribute("user");
		AppAgent agent = (AppAgent) request.getAttribute("agent");

		if(!map.containsKey("atteSocSubId")){
			return Result.fail(ExceptionEnum.COMMON_PARAMETER_ERROR_NOT_NULL,"atteSocId");
		}
		if(!map.containsKey("type")){
			return Result.fail(ExceptionEnum.COMMON_PARAMETER_ERROR_NOT_NULL,"type");
		}
		String atteSocSubId = map.get("atteSocSubId");
		//0关注，1取消关注
		String type = map.get("type");
		
		Response<String> resp = societyService.atteSocSub(user!=null?user.getId():0, Integer.valueOf(atteSocSubId), Integer.valueOf(type));
		
		return resp;
	}
	/**
	 * 推荐用户
	 * @param map
	 * @return
	 * @throws BaseException
	 */
	@RequestMapping(value="atteUser",method={RequestMethod.POST})
	@ResponseBody
	public Response<String> atteUser(@RequestBody Map<String, String> map) throws BaseException{

		UserVO user = (UserVO) request.getAttribute("user");
		AppAgent agent = (AppAgent) request.getAttribute("agent");

		String atteUserId = map.get("atteUserId");
		//0关注，1取消关注
		String type = map.get("type");
		
		Response<String> resp = societyService.atteUser(user!=null?user.getId():null, Integer.valueOf(atteUserId), Integer.valueOf(type));
		
		return resp;
	}
	/**
	 * 查询所有帖子
	 * @param map
	 * @return
	 * @throws BaseException
	 */
	@RequestMapping(value="findSocietyNotes",method={RequestMethod.POST})
	@ResponseBody
	public Response<List<SocietyNoteBean>> findSocietyNotes(@RequestBody Map<String,String> map) throws BaseException{

		UserVO user = (UserVO) request.getAttribute("user");
		AppAgent agent = (AppAgent) request.getAttribute("agent");

		Integer userId = null;
		if(user != null){
			userId = user.getId();
		}
		int start = map.containsKey("start")?Integer.valueOf(map.get("start")):0;
		int rows = map.containsKey("rows")?Integer.valueOf(map.get("rows")):10;
		Map<String,Object> whereMap = new HashMap<String, Object>();
		whereMap.put("annIs", false);//非公共
		Response<List<SocietyNoteBean>> resp = societyService.findSocNotes(userId, start, rows, whereMap);
		return resp;
	}
	/**
	 * 查询关注用户的帖子
	 * @param map
	 * @return
	 * @throws BaseException
	 */
	@RequestMapping(value="findAtteSocietyNotes",method={RequestMethod.POST})
	@ResponseBody
	public Response<List<SocietyNoteBean>> findAtteSocietyNotes(@RequestBody Map<String,String> map) throws BaseException{

		UserVO user = (UserVO) request.getAttribute("user");
		AppAgent agent = (AppAgent) request.getAttribute("agent");

		Integer userId = null;
		if(user != null){
			userId = user.getId();
		}else{
			return Result.fail("请登录！");
		}

		int start = map.containsKey("start")?Integer.valueOf(map.get("start")):0;
		int rows = map.containsKey("rows")?Integer.valueOf(map.get("rows")):10;
		Map<String,Object> whereMap = new HashMap<String, Object>();
		whereMap.put("annIs", false);//非公告
		whereMap.put("atte", true);//关注用户
		Response<List<SocietyNoteBean>> resp = societyService.findSocNotes(userId, start, rows, whereMap);
		return resp;
	}
	/**
	 * 查询关注用户的帖子
	 * @param map
	 * @return
	 * @throws BaseException
	 */
	@RequestMapping(value="findFriendSocietyNotes",method={RequestMethod.POST})
	@ResponseBody
	public Response<List<SocietyNoteBean>> findFriendSocietyNotes(@RequestBody Map<String,String> map) throws BaseException{

		UserVO user = (UserVO) request.getAttribute("user");
		AppAgent agent = (AppAgent) request.getAttribute("agent");

		Integer userId = null;
		if(user != null){
			userId = user.getId();
		}else{
			return Result.fail("请登录！");
		}
		int start = map.containsKey("start")?Integer.valueOf(map.get("start")):0;
		int rows = map.containsKey("rows")?Integer.valueOf(map.get("rows")):10;
		Map<String,Object> whereMap = new HashMap<String, Object>();
		whereMap.put("annIs", false);//非公告
		whereMap.put("friend", true);//关注用户
		Response<List<SocietyNoteBean>> resp = societyService.findSocNotes(userId, start, rows, whereMap);
		return resp;
	}
	
	/**
	 * 查询附近用户的帖子
	 * @param map
	 * @return
	 * @throws BaseException
	 */
	@RequestMapping(value="findNearbySocietyNotes",method={RequestMethod.POST})
	@ResponseBody
	public Response<List<SocietyNoteBean>> findNearbySocietyNotes(@RequestBody Map<String,String> map) throws BaseException{

		UserVO user = (UserVO) request.getAttribute("user");
		AppAgent agent = (AppAgent) request.getAttribute("agent");

		Integer userId = null;
		if(user != null){
			userId = user.getId();
		}else{
			return Result.fail("请登录！");
		}
		int start = map.containsKey("start")?Integer.valueOf(map.get("start")):0;
		int rows = map.containsKey("rows")?Integer.valueOf(map.get("rows")):10;
		Map<String,Object> whereMap = new HashMap<String, Object>();
		whereMap.put("annIs", false);//非公告
		Response<List<SocietyNoteBean>> resp = societyService.findSocNotes(userId, start, rows, whereMap);
		return resp;
	}
	
	/**
	 * 查询所有的主题
	 * @return
	 * @throws BaseException
	 */
	@RequestMapping(value="findAllSocTypes",method={RequestMethod.POST})
	@ResponseBody
	public Response<List<SocietyTypeBean>> findAllSocTypes(@RequestBody Map<String,String> map) throws BaseException{

		UserVO user = (UserVO) request.getAttribute("user");

		Integer userId = null;
		if(user != null){
			userId = user.getId();
		}
		
		Response<List<SocietyTypeBean>> resp = societyService.findAllSocTypes(userId);
		
		return resp;
	}
	/**
	 * 查询主题by id
	 * @return
	 * @throws BaseException
	 */
	@RequestMapping(value="findSocSubById",method={RequestMethod.POST})
	@ResponseBody
	public Response<Map<String,Object>> findSocSubById(@RequestBody Map<String,String> map) throws BaseException{

		if(!map.containsKey("subId")){
			return Result.fail(ExceptionEnum.COMMON_PARAMETER_ERROR_NOT_NULL,"subId");
		}
		
		Response<SocietySubTypeBean> resp = societyService.findSocSubBeanById(Integer.valueOf(map.get("subId").toString()));
		
		Map<String,Object> whereMap = new HashMap<String, Object>();
		whereMap.put("annIs", true);//查询公告
		whereMap.put("subId", map.get("subId"));//查询公告
		Response<List<SocietyNoteBean>> respSN = societyService.findSocNotes(null,1, 10, whereMap);
		
		Map<String, Object> retMap = new HashMap<String, Object>();
		retMap.put("societySub", resp.getResult());
		retMap.put("societyNote", respSN.getResult());
		return Result.resultSet(retMap);
	}
	/**
	 * 查询主题的帖子
	 * @param map
	 * @return
	 * @throws BaseException
	 */
	@RequestMapping(value="findSocietyNotesBySubId",method={RequestMethod.POST})
	@ResponseBody
	public Response<List<SocietyNoteBean>> findSocietyNotesBySubId(@RequestBody Map<String,String> map) throws BaseException{

		UserVO user = (UserVO) request.getAttribute("user");
		Integer userId = null;
		if(user != null){
			userId = user.getId();
		}
		
		if(!map.containsKey("subId")){
			return Result.fail(ExceptionEnum.COMMON_PARAMETER_ERROR_NOT_NULL,"subId");
		}

		int start = map.containsKey("start")?Integer.valueOf(map.get("start")):0;
		int rows = map.containsKey("rows")?Integer.valueOf(map.get("rows")):10;
		Map<String,Object> whereMap = new HashMap<String, Object>();
		whereMap.put("annIs", false);//非公告
		whereMap.put("subId", map.get("subId"));//关注用户
		Response<List<SocietyNoteBean>> resp = societyService.findSocNotes(userId, start, rows, whereMap);
		return resp;
	}
	/**
	 * 查询主题的帖子
	 * @param map
	 * @return
	 * @throws BaseException
	 */
	@RequestMapping(value="findSocietyNoteInfoById",method={RequestMethod.POST})
	@ResponseBody
	public Response<SocietyNoteBean> findSocietyNoteInfoById(@RequestBody Map<String,String> map) throws BaseException{

		UserVO user = (UserVO) request.getAttribute("user");

		Integer userId = null;
		if(user != null){
			userId = user.getId();
		}
		
		if(!map.containsKey("id")){
			return Result.fail(ExceptionEnum.COMMON_PARAMETER_ERROR_NOT_NULL,"id");
		}
		
		Boolean socSubInfo = false;
		if(map.containsKey("socSubInfo")){
			socSubInfo = Boolean.valueOf(map.get("socSubInfo"));
		}
		
		Response<SocietyNoteBean> resp = societyService.findSocNoteById(userId, Integer.valueOf(map.get("id")), socSubInfo);
		return resp;
	}
	/**
	 * 帖子点赞
	 * @param map
	 * @return
	 * @throws BaseException
	 */
	@RequestMapping(value="socNotePlayingReward",method={RequestMethod.POST})
	@ResponseBody
	public Response<Boolean> socNotePlayingReward(@RequestBody Map<String,String> map) throws BaseException{
		logger.info("=================socNotePlayingReward====================");
		UserVO user = (UserVO) request.getAttribute("user");

		if(!map.containsKey("socNoteId")){
			return Result.fail(ExceptionEnum.COMMON_PARAMETER_ERROR_NOT_NULL,"socNoteId");
		}
		if(!map.containsKey("recUserId")){
			return Result.fail(ExceptionEnum.COMMON_PARAMETER_ERROR_NOT_NULL,"recUserId");
		}
		if(!map.containsKey("value")){
			return Result.fail(ExceptionEnum.COMMON_PARAMETER_ERROR_NOT_NULL,"value");
		}
		
		int userId = user.getId();
		int recUserId = Integer.valueOf(map.get("recUserId"));
		int socNoteId = Integer.valueOf(map.get("socNoteId"));
		int value = Integer.valueOf(map.get("value"));
		
		Response<Boolean> resp = societyService.socNotePlayingReward(userId, recUserId, value, socNoteId);
		return resp;
	}
	/**
	 * 帖子点赞
	 * @param map
	 * @return
	 * @throws BaseException
	 */
	@RequestMapping(value="likeSocNote",method={RequestMethod.GET,RequestMethod.POST})
	@ResponseBody
	public Response<Boolean> likeSocNote(@RequestBody Map<String,String> map) throws BaseException{

		UserVO user = (UserVO) request.getAttribute("user");

		if(!map.containsKey("socNoteId")){
			return Result.fail(ExceptionEnum.COMMON_PARAMETER_ERROR_NOT_NULL,"socNoteId");
		}
		if(!map.containsKey("like")){
			return Result.fail(ExceptionEnum.COMMON_PARAMETER_ERROR_NOT_NULL,"like");
		}
		
		int userId = user.getId();
		boolean like = Boolean.valueOf(map.get("like"));
		int socNoteId = Integer.valueOf(map.get("socNoteId"));
		
		Response<Boolean> resp = societyService.updateSocNotelike(userId, socNoteId, like);
		return resp;
	}
	/**
	 * 评论点赞
	 * @param map
	 * @return
	 * @throws BaseException
	 */
	@RequestMapping(value="likeSocDis",method={RequestMethod.GET,RequestMethod.POST})
	@ResponseBody
	public Response<Boolean> likeSocDis(@RequestBody Map<String,String> map) throws BaseException{
		logger.debug("=================likeSocDis====================");

		UserVO user = (UserVO) request.getAttribute("user");

		if(!map.containsKey("socDisId")){
			return Result.fail(ExceptionEnum.COMMON_PARAMETER_ERROR_NOT_NULL,"socNoteId");
		}
		if(!map.containsKey("like")){
			return Result.fail(ExceptionEnum.COMMON_PARAMETER_ERROR_NOT_NULL,"like");
		}
		
		int userId = user.getId();
		boolean like = Boolean.valueOf(map.get("like"));
		int socDisId = Integer.valueOf(map.get("socDisId"));
		
		Response<Boolean> resp = societyService.updateSocDislike(userId, socDisId, like);
		return resp;
	}
	/**
	 * 查询主题的帖子
	 * @param map
	 * @return
	 * @throws BaseException
	 */
	@RequestMapping(value="findSocietyNoteRewards",method={RequestMethod.GET,RequestMethod.POST})
	@ResponseBody
	public Response<List<SocietyNoteRewardBean>> findSocietyNoteRewards(@RequestBody Map<String,String> map) throws BaseException{

		UserVO user = (UserVO) request.getAttribute("user");

		Integer userId = null;
		if(user != null){
			userId = user.getId();
		}
		
		if(!map.containsKey("socNoteId")){
			return Result.fail(ExceptionEnum.COMMON_PARAMETER_ERROR_NOT_NULL,"socNoteId");
		}
		int start = map.containsKey("start")?Integer.valueOf(map.get("start")):0;
		int rows = map.containsKey("rows")?Integer.valueOf(map.get("rows")):10;
		
		Response<List<SocietyNoteRewardBean>> resp = societyService.findSocietyNoteRewards(userId, Integer.valueOf(map.get("socNoteId")), start, rows);
		return resp;
	}
	/**
	 * 查询帖子评论通过帖子Id
	 * @param map
	 * @return
	 * @throws BaseException
	 */
	@RequestMapping(value="findSocietyDisBySocNoteId",method={RequestMethod.GET,RequestMethod.POST})
	@ResponseBody
	public Response<List<SocietyDisBean>> findSocietyDisBySocNoteId(@RequestBody Map<String,String> map) throws BaseException{

		UserVO user = (UserVO) request.getAttribute("user");
		Integer userId = null;
		if(user != null){
			userId = user.getId();
		}

		if(!map.containsKey("socNoteId")){
			return Result.fail(ExceptionEnum.COMMON_PARAMETER_ERROR_NOT_NULL,"socNoteId");
		}
		int socNoteId = Integer.valueOf(map.get("socNoteId"));
		int start = map.containsKey("start")?Integer.valueOf(map.get("start")):0;
		int rows = map.containsKey("rows")?Integer.valueOf(map.get("rows")):10;
		Map<String,Object> whereMap = new HashMap<String, Object>();
		Response<List<SocietyDisBean>> resp = societyService.findSocietyDisBySocNoteId(socNoteId, userId, start, rows, whereMap);
		return resp;
	}
}
