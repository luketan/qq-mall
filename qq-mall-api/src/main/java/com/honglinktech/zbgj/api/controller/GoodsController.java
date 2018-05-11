package com.honglinktech.zbgj.api.controller;


import com.honglinktech.zbgj.api.base.BaseApiController;
import com.honglinktech.zbgj.base.BaseException;
import com.honglinktech.zbgj.base.ExceptionEnum;
import com.honglinktech.zbgj.bean.GoodsBean;
import com.honglinktech.zbgj.bean.GoodsDisBean;
import com.honglinktech.zbgj.bean.GoodsDisCountBean;
import com.honglinktech.zbgj.bean.GoodsTypeBean;
import com.honglinktech.zbgj.common.AppAgent;
import com.honglinktech.zbgj.common.Response;
import com.honglinktech.zbgj.common.Result;
import com.honglinktech.zbgj.service.GoodsDisService;
import com.honglinktech.zbgj.service.GoodsService;
import com.honglinktech.zbgj.service.GoodsTypeService;
import com.honglinktech.zbgj.service.UserKeepService;
import com.honglinktech.zbgj.vo.UserVO;
import org.springframework.http.HttpHeaders;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RequestAttribute;
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
	@RequestMapping(value="findGoodsBeanById",method={RequestMethod.GET,RequestMethod.POST})
	@ResponseBody
	public Response<GoodsBean> findGoodsBeanById(@RequestBody Map<String, String> map,
			@RequestAttribute("user") UserVO user,
			@RequestAttribute("agent") AppAgent agent) throws BaseException{

		int userId = 0;
		if(user != null){
			userId = user.getId();
		}
		if(!map.containsKey("id")){
			return Result.fail(ExceptionEnum.COMMON_PARAMETER_ERROR_NOT_NULL,"id");
		}
		int index = map.containsKey("index")?Integer.valueOf(map.get("index")):1;
		int size = map.containsKey("size")?Integer.valueOf(map.get("size")):10;
		
		Response<GoodsBean> response = goodsService.findGoodsBeanById(Integer.valueOf(map.get("id")), userId, index, size);
		
		return response; 
	}
	
	/**
	 * 商品简单数据查询
	 * @param map
	 * @return
	 * @throws BaseException
	 */
	@RequestMapping(value="findGoodsSearchBeans",method={RequestMethod.GET,RequestMethod.POST})
	@ResponseBody
	public Response<List<GoodsBean>> findGoodsSearchBeans(@RequestBody Map<String, String> map) throws BaseException{
		Response<List<GoodsBean>> response = goodsService.findGoodsSearchBeans(map);
		return response; 
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
	public Response<List<GoodsTypeBean>> findGoodsTypeAll() throws BaseException{
		Response<List<GoodsTypeBean>> response = goodsTypeService.findGoodsTypeAll();
		return response; 
	}
	/**
	 * 商品类型
	 * @param map
	 * @return
	 * @throws BaseException
	 */
	@RequestMapping(value="findGoodsTypeBeanById",method={RequestMethod.GET,RequestMethod.POST})
	@ResponseBody
	public Response<GoodsTypeBean> findGoodsTypeBeanById(@RequestBody Map<String, String> map) throws BaseException{
		if(!map.containsKey("id")){
			return Result.fail(ExceptionEnum.COMMON_PARAMETER_ERROR_NOT_NULL,"id");
		}
		Response<GoodsTypeBean> response = goodsTypeService.findGoodsTypeBeanById(Integer.valueOf(map.get("id").toString()));
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
