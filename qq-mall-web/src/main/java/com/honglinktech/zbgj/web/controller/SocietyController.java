package com.honglinktech.zbgj.web.controller;


import com.honglinktech.zbgj.base.BaseException;
import com.honglinktech.zbgj.base.ExceptionEnum;
import com.honglinktech.zbgj.bean.HomeBean;
import com.honglinktech.zbgj.bean.SocietyDisBean;
import com.honglinktech.zbgj.bean.SocietyNoteBean;
import com.honglinktech.zbgj.bean.SocietyNoteRewardBean;
import com.honglinktech.zbgj.bean.SocietySubTypeBean;
import com.honglinktech.zbgj.bean.SocietyTypeBean;
import com.honglinktech.zbgj.bean.UserBean;
import com.honglinktech.zbgj.common.Response;
import com.honglinktech.zbgj.common.Result;
import com.honglinktech.zbgj.entity.Module;
import com.honglinktech.zbgj.service.ModuleService;
import com.honglinktech.zbgj.service.SocietyService;
import com.honglinktech.zbgj.service.UserService;
import com.honglinktech.zbgj.vo.UserVO;
import com.honglinktech.zbgj.web.base.BaseApiController;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.springframework.http.HttpHeaders;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

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
	 * @param headers
	 * @return
	 * @throws BaseException
	 */
	@RequestMapping(value="findSocietyHome",method={RequestMethod.GET,RequestMethod.POST})
	@ResponseBody
	public Response<Map<String,Object>> findHome(@RequestHeader HttpHeaders headers) throws BaseException{
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
		String userCode =  headers.getFirst("userId");
		if(!StringUtils.isEmpty(userCode)){
			Response<List<SocietySubTypeBean>> resp = societyService.findUserSocSubBean(Integer.valueOf(userCode));
			retMap.put("userSoc", resp.getResult());
		}
		//推荐主题
		Response<List<SocietySubTypeBean>> respSocietySubAll = societyService.findRecSocSubBean(!StringUtils.isEmpty(userCode)?Integer.valueOf(userCode):null);
		List<SocietySubTypeBean> socList = respSocietySubAll.getResult();
		if(socList != null){
			retMap.put("recSoc", socList);
		}
		//推荐用户
		Response<List<UserVO>> respRecUser = userService.findRecUsers(!StringUtils.isEmpty(userCode)?Integer.valueOf(userCode):null);
		List<UserVO> userList = respRecUser.getResult();
		if(userList != null){
			retMap.put("recUser", userList);
		}
		
		return Result.resultSet(retMap); 
	}
	/**
	 * 推荐主题
	 * @param headers
	 * @param map
	 * @return
	 * @throws BaseException
	 */
	@RequestMapping(value="atteSocSub",method={RequestMethod.GET,RequestMethod.POST})
	@ResponseBody
	public Response<String> atteSocSub(@RequestHeader HttpHeaders headers, @RequestBody Map<String, String> map) throws BaseException{

		String userCode =  headers.getFirst("userId");
		if(StringUtils.isEmpty(userCode) || Integer.valueOf(userCode)==0){
			return Result.fail(ExceptionEnum.COMMON_USER_CODE_NOT_EMPTY);
		}
		if(!map.containsKey("atteSocSubId")){
			return Result.fail(ExceptionEnum.COMMON_PARAMETER_ERROR_NOT_NULL,"atteSocId");
		}
		if(!map.containsKey("type")){
			return Result.fail(ExceptionEnum.COMMON_PARAMETER_ERROR_NOT_NULL,"type");
		}
		String atteSocSubId = map.get("atteSocSubId");
		//0关注，1取消关注
		String type = map.get("type");
		
		Response<String> resp = societyService.atteSocSub(Integer.valueOf(userCode), Integer.valueOf(atteSocSubId), Integer.valueOf(type));
		
		return resp;
	}
	/**
	 * 推荐用户
	 * @param headers
	 * @param map
	 * @return
	 * @throws BaseException
	 */
	@RequestMapping(value="atteUser",method={RequestMethod.GET,RequestMethod.POST})
	@ResponseBody
	public Response<String> atteUser(@RequestHeader HttpHeaders headers, @RequestBody Map<String, String> map) throws BaseException{

		String userCode =  headers.getFirst("userId");
		if(StringUtils.isEmpty(userCode) || Integer.valueOf(userCode)==0){
			return Result.fail(ExceptionEnum.COMMON_USER_CODE_NOT_EMPTY);
		}
		String atteUserId = map.get("atteUserId");
		//0关注，1取消关注
		String type = map.get("type");
		
		Response<String> resp = societyService.atteUser(Integer.valueOf(userCode), Integer.valueOf(atteUserId), Integer.valueOf(type));
		
		return resp;
	}
	/**
	 * 查询所有帖子
	 * @param map
	 * @param headers
	 * @return
	 * @throws BaseException
	 */
	@RequestMapping(value="findSocietyNotes",method={RequestMethod.GET,RequestMethod.POST})
	@ResponseBody
	public Response<List<SocietyNoteBean>> findSocietyNotes(@RequestBody Map<String,String> map, @RequestHeader HttpHeaders headers) throws BaseException{

		String userCode =  headers.getFirst("userId");
		Integer userId = null;
		if(!StringUtils.isEmpty(userCode)){
			userId = Integer.valueOf(userCode);
		}
		int index = map.containsKey("index")?Integer.valueOf(map.get("index")):1;
		int size = map.containsKey("size")?Integer.valueOf(map.get("size")):10;
		Map<String,Object> whereMap = new HashMap<String, Object>();
		whereMap.put("annIs", false);//非公共
		Response<List<SocietyNoteBean>> resp = societyService.findSocNotes(userId, index, size, whereMap);
		return resp;
	}
	/**
	 * 查询关注用户的帖子
	 * @param map
	 * @param headers
	 * @return
	 * @throws BaseException
	 */
	@RequestMapping(value="findAtteSocietyNotes",method={RequestMethod.GET,RequestMethod.POST})
	@ResponseBody
	public Response<List<SocietyNoteBean>> findAtteSocietyNotes(@RequestBody Map<String,String> map, @RequestHeader HttpHeaders headers) throws BaseException{

		String userCode =  headers.getFirst("userId");
		Integer userId = null;
		if(!StringUtils.isEmpty(userCode)){
			userId = Integer.valueOf(userCode);
		}else{
			return Result.success("请登录！");
		}
		int index = map.containsKey("index")?Integer.valueOf(map.get("index")):1;
		int size = map.containsKey("size")?Integer.valueOf(map.get("size")):10;
		Map<String,Object> whereMap = new HashMap<String, Object>();
		whereMap.put("annIs", false);//非公告
		whereMap.put("atte", true);//关注用户
		Response<List<SocietyNoteBean>> resp = societyService.findSocNotes(userId,index, size, whereMap);
		return resp;
	}
	/**
	 * 查询关注用户的帖子
	 * @param map
	 * @param headers
	 * @return
	 * @throws BaseException
	 */
	@RequestMapping(value="findFriendSocietyNotes",method={RequestMethod.GET,RequestMethod.POST})
	@ResponseBody
	public Response<List<SocietyNoteBean>> findFriendSocietyNotes(@RequestBody Map<String,String> map, @RequestHeader HttpHeaders headers) throws BaseException{

		String userCode =  headers.getFirst("userId");
		Integer userId = null;
		if(!StringUtils.isEmpty(userCode)){
			userId = Integer.valueOf(userCode);
		}else{
			return Result.success("请登录！");
		}
		int index = map.containsKey("index")?Integer.valueOf(map.get("index")):1;
		int size = map.containsKey("size")?Integer.valueOf(map.get("size")):10;
		Map<String,Object> whereMap = new HashMap<String, Object>();
		whereMap.put("annIs", false);//非公告
		whereMap.put("friend", true);//关注用户
		Response<List<SocietyNoteBean>> resp = societyService.findSocNotes(userId,index, size, whereMap);
		return resp;
	}
	
	/**
	 * 查询附近用户的帖子
	 * @param map
	 * @param headers
	 * @return
	 * @throws BaseException
	 */
	@RequestMapping(value="findNearbySocietyNotes",method={RequestMethod.GET,RequestMethod.POST})
	@ResponseBody
	public Response<List<SocietyNoteBean>> findNearbySocietyNotes(@RequestBody Map<String,String> map, @RequestHeader HttpHeaders headers) throws BaseException{

		String userCode =  headers.getFirst("userId");
		Integer userId = null;
		if(!StringUtils.isEmpty(userCode)){
			userId = Integer.valueOf(userCode);
		}else{
			return Result.success("请登录！");
		}
		int index = map.containsKey("index")?Integer.valueOf(map.get("index")):1;
		int size = map.containsKey("size")?Integer.valueOf(map.get("size")):10;
		Map<String,Object> whereMap = new HashMap<String, Object>();
		whereMap.put("annIs", false);//非公告
		Response<List<SocietyNoteBean>> resp = societyService.findSocNotes(userId,index, size, whereMap);
		return resp;
	}
	
	/**
	 * 查询所有的主题
	 * @param headers
	 * @return
	 * @throws BaseException
	 */
	@RequestMapping(value="findAllSocTypes",method={RequestMethod.GET,RequestMethod.POST})
	@ResponseBody
	public Response<List<SocietyTypeBean>> findAllSocTypes(@RequestHeader HttpHeaders headers) throws BaseException{

		String userCode =  headers.getFirst("userId");
		Integer userId = null;
		if(!StringUtils.isEmpty(userCode)){
			userId = Integer.valueOf(userCode);
		}
		
		Response<List<SocietyTypeBean>> resp = societyService.findAllSocTypes(userId);
		
		return resp;
	}
	/**
	 * 查询主题by id
	 * @param headers
	 * @return
	 * @throws BaseException
	 */
	@RequestMapping(value="findSocSubById",method={RequestMethod.GET,RequestMethod.POST})
	@ResponseBody
	public Response<Map<String,Object>> findSocSubById(@RequestBody Map<String,String> map,@RequestHeader HttpHeaders headers) throws BaseException{

//		String userCode =  headers.getFirst("userId");
//		Integer userId = null;
//		if(!StringUtils.isEmpty(userCode)){
//			userId = Integer.valueOf(userCode);
//		}
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
	 * @param headers
	 * @return
	 * @throws BaseException
	 */
	@RequestMapping(value="findSocietyNotesBySubId",method={RequestMethod.GET,RequestMethod.POST})
	@ResponseBody
	public Response<List<SocietyNoteBean>> findSocietyNotesBySubId(@RequestBody Map<String,String> map, @RequestHeader HttpHeaders headers) throws BaseException{

		String userCode =  headers.getFirst("userId");
		Integer userId = null;
		if(!StringUtils.isEmpty(userCode)){
			userId = Integer.valueOf(userCode);
		}
		
		if(!map.containsKey("subId")){
			return Result.fail(ExceptionEnum.COMMON_PARAMETER_ERROR_NOT_NULL,"subId");
		}
		
		int index = map.containsKey("index")?Integer.valueOf(map.get("index")):1;
		int size = map.containsKey("size")?Integer.valueOf(map.get("size")):10;
		Map<String,Object> whereMap = new HashMap<String, Object>();
		whereMap.put("annIs", false);//非公告
		whereMap.put("subId", map.get("subId"));//关注用户
		Response<List<SocietyNoteBean>> resp = societyService.findSocNotes(userId, index, size, whereMap);
		return resp;
	}
	/**
	 * 查询主题的帖子
	 * @param map
	 * @param headers
	 * @return
	 * @throws BaseException
	 */
	@RequestMapping(value="findSocietyNoteInfoById",method={RequestMethod.GET,RequestMethod.POST})
	@ResponseBody
	public Response<SocietyNoteBean> findSocietyNoteInfoById(@RequestBody Map<String,String> map, @RequestHeader HttpHeaders headers) throws BaseException{

		String userCode =  headers.getFirst("userId");
		Integer userId = null;
		if(!StringUtils.isEmpty(userCode)){
			userId = Integer.valueOf(userCode);
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
	 * @param headers
	 * @return
	 * @throws BaseException
	 */
	@RequestMapping(value="socNotePlayingReward",method={RequestMethod.GET,RequestMethod.POST})
	@ResponseBody
	public Response<Boolean> socNotePlayingReward(@RequestBody Map<String,String> map, @RequestHeader HttpHeaders headers) throws BaseException{
		logger.info("=================socNotePlayingReward====================");
		String userCode =  headers.getFirst("userId");
		if(StringUtils.isEmpty(userCode) || Integer.valueOf(userCode)==0){
			return Result.fail(ExceptionEnum.COMMON_USER_CODE_NOT_EMPTY);
		}
		if(!map.containsKey("socNoteId")){
			return Result.fail(ExceptionEnum.COMMON_PARAMETER_ERROR_NOT_NULL,"socNoteId");
		}
		if(!map.containsKey("recUserId")){
			return Result.fail(ExceptionEnum.COMMON_PARAMETER_ERROR_NOT_NULL,"recUserId");
		}
		if(!map.containsKey("value")){
			return Result.fail(ExceptionEnum.COMMON_PARAMETER_ERROR_NOT_NULL,"value");
		}
		
		int userId = Integer.valueOf(userCode);
		int recUserId = Integer.valueOf(map.get("recUserId"));
		int socNoteId = Integer.valueOf(map.get("socNoteId"));
		int value = Integer.valueOf(map.get("value"));
		
		Response<Boolean> resp = societyService.socNotePlayingReward(userId, recUserId, value, socNoteId);
		return resp;
	}
	/**
	 * 帖子点赞
	 * @param map
	 * @param headers
	 * @return
	 * @throws BaseException
	 */
	@RequestMapping(value="likeSocNote",method={RequestMethod.GET,RequestMethod.POST})
	@ResponseBody
	public Response<Boolean> likeSocNote(@RequestBody Map<String,String> map, @RequestHeader HttpHeaders headers) throws BaseException{
		System.out.println("()()()()()"+logger);
		logger.debug("=================likeSocNote====================");
		logger.warn("============warn");
		logger.info("============info");
		String userCode =  headers.getFirst("userId");
		if(StringUtils.isEmpty(userCode) || Integer.valueOf(userCode)==0){
			return Result.fail(ExceptionEnum.COMMON_USER_CODE_NOT_EMPTY);
		}
		if(!map.containsKey("socNoteId")){
			return Result.fail(ExceptionEnum.COMMON_PARAMETER_ERROR_NOT_NULL,"socNoteId");
		}
		if(!map.containsKey("like")){
			return Result.fail(ExceptionEnum.COMMON_PARAMETER_ERROR_NOT_NULL,"like");
		}
		
		int userId = Integer.valueOf(userCode);
		boolean like = Boolean.valueOf(map.get("like"));
		int socNoteId = Integer.valueOf(map.get("socNoteId"));
		
		Response<Boolean> resp = societyService.updateSocNotelike(userId, socNoteId, like);
		return resp;
	}
	/**
	 * 评论点赞
	 * @param map
	 * @param headers
	 * @return
	 * @throws BaseException
	 */
	@RequestMapping(value="likeSocDis",method={RequestMethod.GET,RequestMethod.POST})
	@ResponseBody
	public Response<Boolean> likeSocDis(@RequestBody Map<String,String> map, @RequestHeader HttpHeaders headers) throws BaseException{
		logger.debug("=================likeSocDis====================");
		String userCode =  headers.getFirst("userId");
		if(StringUtils.isEmpty(userCode) || Integer.valueOf(userCode)==0){
			return Result.fail(ExceptionEnum.COMMON_USER_CODE_NOT_EMPTY);
		}
		if(!map.containsKey("socDisId")){
			return Result.fail(ExceptionEnum.COMMON_PARAMETER_ERROR_NOT_NULL,"socNoteId");
		}
		if(!map.containsKey("like")){
			return Result.fail(ExceptionEnum.COMMON_PARAMETER_ERROR_NOT_NULL,"like");
		}
		
		int userId = Integer.valueOf(userCode);
		boolean like = Boolean.valueOf(map.get("like"));
		int socDisId = Integer.valueOf(map.get("socDisId"));
		
		Response<Boolean> resp = societyService.updateSocDislike(userId, socDisId, like);
		return resp;
	}
	/**
	 * 查询主题的帖子
	 * @param map
	 * @param headers
	 * @return
	 * @throws BaseException
	 */
	@RequestMapping(value="findSocietyNoteRewards",method={RequestMethod.GET,RequestMethod.POST})
	@ResponseBody
	public Response<List<SocietyNoteRewardBean>> findSocietyNoteRewards(@RequestBody Map<String,String> map, @RequestHeader HttpHeaders headers) throws BaseException{

		String userCode =  headers.getFirst("userId");
		Integer userId = null;
		if(!StringUtils.isEmpty(userCode)){
			userId = Integer.valueOf(userCode);
		}
		
		if(!map.containsKey("socNoteId")){
			return Result.fail(ExceptionEnum.COMMON_PARAMETER_ERROR_NOT_NULL,"socNoteId");
		}
		int index = map.containsKey("index")?Integer.valueOf(map.get("index")):1;
		int size = map.containsKey("size")?Integer.valueOf(map.get("size")):10;
		
		Response<List<SocietyNoteRewardBean>> resp = societyService.findSocietyNoteRewards(userId, Integer.valueOf(map.get("socNoteId")), index, size);
		return resp;
	}
	/**
	 * 查询帖子评论通过帖子Id
	 * @param map
	 * @param headers
	 * @return
	 * @throws BaseException
	 */
	@RequestMapping(value="findSocietyDisBySocNoteId",method={RequestMethod.GET,RequestMethod.POST})
	@ResponseBody
	public Response<List<SocietyDisBean>> findSocietyDisBySocNoteId(@RequestBody Map<String,String> map, @RequestHeader HttpHeaders headers) throws BaseException{

		String userCode =  headers.getFirst("userId");
		Integer userId = null;
		if(!StringUtils.isEmpty(userCode)){
			userId = Integer.valueOf(userCode);
		}
		
		if(!map.containsKey("socNoteId")){
			return Result.fail(ExceptionEnum.COMMON_PARAMETER_ERROR_NOT_NULL,"socNoteId");
		}
		int socNoteId = Integer.valueOf(map.get("socNoteId"));
		int index = map.containsKey("index")?Integer.valueOf(map.get("index")):1;
		int size = map.containsKey("size")?Integer.valueOf(map.get("size")):10;
		Map<String,Object> whereMap = new HashMap<String, Object>();
		Response<List<SocietyDisBean>> resp = societyService.findSocietyDisBySocNoteId(socNoteId, userId, index, size, whereMap);
		return resp;
	}
}
