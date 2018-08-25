package com.honglinktech.zbgj.api.controller;


import com.honglinktech.zbgj.api.base.BaseApiController;
import com.honglinktech.zbgj.base.BaseException;
import com.honglinktech.zbgj.base.ExceptionEnum;
import com.honglinktech.zbgj.bean.GoodsDisBean;
import com.honglinktech.zbgj.bean.GoodsDisCountBean;
import com.honglinktech.zbgj.common.AppAgent;
import com.honglinktech.zbgj.common.Response;
import com.honglinktech.zbgj.common.Result;
import com.honglinktech.zbgj.service.GoodsDisService;
import com.honglinktech.zbgj.service.GoodsService;
import com.honglinktech.zbgj.service.GoodsTypeService;
import com.honglinktech.zbgj.service.UserKeepService;
import com.honglinktech.zbgj.vo.GoodsTypeVO;
import com.honglinktech.zbgj.vo.GoodsVO;
import com.honglinktech.zbgj.vo.UserVO;
import org.springframework.http.HttpHeaders;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/goods/api")
public class GoodsController extends BaseApiController {
	@Resource
	private GoodsService goodsService;
	@Resource
	private GoodsTypeService goodsTypeService;
	@Resource
	private GoodsDisService goodsDisService;
	@Resource
	private UserKeepService userKeepService;
	/**
	 * App通过ID获取goodsBean
	 * @return
	 * @throws BaseException
	 */
	@RequestMapping(value="findGoodsById",method={RequestMethod.POST})
	@ResponseBody
	public Response<GoodsVO> findGoodsById(@RequestBody Map<String, String> map){
		try {
			if (!map.containsKey("id")) {
				return Result.fail(ExceptionEnum.COMMON_PARAMETER_ERROR_NOT_NULL, "id");
			}

			UserVO user = (UserVO) request.getAttribute("user");
			AppAgent agent = (AppAgent) request.getAttribute("agent");
			int userId = 0;
			if (user != null) {
				userId = user.getId();
			}

			int start = map.containsKey("start")?Integer.valueOf(map.get("start")):0;
			int rows = map.containsKey("rows")?Integer.valueOf(map.get("rows")):10;

			Response<GoodsVO> response = goodsService.findGoodsVOById(Integer.valueOf(map.get("id")), userId, start, rows);

			return response;
		}catch (Exception e){
			logger.error(e, e);
			return Result.fail("获取商品信息失败");
		}
	}
	
	/**
	 * 商品简单数据查询
	 * @param map
	 * @return
	 * @throws BaseException
	 */
	@RequestMapping(value="findGoodsList",method={RequestMethod.GET,RequestMethod.POST})
	@ResponseBody
	public Response<List<GoodsVO>> findGoodsSearchBeans(@RequestBody Map<String, String> map){

		try {
			int start = map.containsKey("start") ? Integer.valueOf(map.get("start")) : 0;
			int rows = map.containsKey("rows") ? Integer.valueOf(map.get("rows")) : 10;

			Response<List<GoodsVO>> response = goodsService.findGoodsVOByWhere(map);
			return response;
		}catch (Exception e){
			logger.error(e, e);
			return Result.fail("获取失败，请重试！");
		}
	}
	
	/**
	 * 商品收藏
	 * @param map
	 * @return
	 * @throws BaseException
	 */
	@RequestMapping(value="updateGoodsKeep",method={RequestMethod.GET,RequestMethod.POST})
	@ResponseBody
	public Response<String> updateGoodsKeep(@RequestHeader HttpHeaders headers,@RequestBody Map<String, String> map) throws BaseException{
		
		String userCode = headers.getFirst("userId");
	    if(StringUtils.isEmpty(userCode) || Integer.valueOf(userCode)==0){
			return Result.fail(ExceptionEnum.COMMON_USER_CODE_NOT_EMPTY);
		}
	    String goodsId = map.get("id");
	    if(StringUtils.isEmpty(goodsId) || Integer.valueOf(goodsId)==0){
			return Result.fail(ExceptionEnum.COMMON_PARAMETER_ERROR,"goodsId");
		}
	    String keep = map.get("keep");
	    if(StringUtils.isEmpty(keep)){
			return Result.fail(ExceptionEnum.COMMON_PARAMETER_ERROR,"keep");
		}
	    
		Response<String> response = userKeepService.updateGoodsKeep(Integer.valueOf(userCode),Integer.valueOf(goodsId),Boolean.valueOf(keep));
		return response; 
	}
	
	
	/**
	 * 商品类型所有
	 * @return
	 * @throws BaseException
	 */
	@RequestMapping(value="findGoodsTypeAll",method={RequestMethod.GET,RequestMethod.POST})
	@ResponseBody
	public Response<List<GoodsTypeVO>> findGoodsTypeAll() throws BaseException{
		Response<List<GoodsTypeVO>> response = goodsTypeService.findGoodsTypeVOAll();
		return response; 
	}
	/**
	 * 商品类型
	 * @param map
	 * @return
	 * @throws BaseException
	 */
	@RequestMapping(value="findGoodsTypeById",method={RequestMethod.GET,RequestMethod.POST})
	@ResponseBody
	public Response<GoodsTypeVO> findGoodsTypeById(@RequestBody Map<String, String> map) throws BaseException{
		if(!map.containsKey("id")){
			return Result.fail(ExceptionEnum.COMMON_PARAMETER_ERROR_NOT_NULL,"id");
		}
		Response<GoodsTypeVO> response = goodsTypeService.findGoodsTypeVOById(Integer.valueOf(map.get("id").toString()));
		return response; 
	}
	
	
	/**
	 * 商品评论统计
	 * @param map
	 * @return
	 * @throws BaseException
	 */
	@RequestMapping(value="findGoodsDisCountBeanByGoodsId",method={RequestMethod.GET,RequestMethod.POST})
	@ResponseBody
	public Response<GoodsDisCountBean> findGoodsDisCountBeanByGoodsId(@RequestBody Map<String, String> map) throws BaseException{
		if(!map.containsKey("goodsId")){
			return Result.fail(ExceptionEnum.COMMON_PARAMETER_ERROR_NOT_NULL,"goodsId");
		}
		Response<GoodsDisCountBean>  response = goodsDisService.findGoodsDisCount(Integer.valueOf(map.get("goodsId").toString()));
		return response; 
	}
	
	/**
	 * 商品评论统计
	 * @param map
	 * @return
	 * @throws BaseException
	 */
	@RequestMapping(value="findGoodsDisByPage",method={RequestMethod.GET,RequestMethod.POST})
	@ResponseBody
	public Response<List<GoodsDisBean>> findGoodsDisByPage(@RequestBody Map<String, String> map) throws BaseException{
		if(!map.containsKey("goodsId")){
			return Result.fail(ExceptionEnum.COMMON_PARAMETER_ERROR_NOT_NULL,"goodsId");
		}
		
		Response<List<GoodsDisBean>>  response = goodsDisService.findGoodsDisByPage(map);
		
		return response; 
	}
	
	
}
