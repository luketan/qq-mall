package com.honglinktech.zbgj.api.controller;


import com.alibaba.fastjson.JSON;
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
import org.springframework.web.bind.annotation.*;

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
	 * 商品评论统计
	 * @param map
	 * @return
	 * @throws BaseException
	 */
	@RequestMapping(value="findBySearch",method={RequestMethod.POST})
	@ResponseBody
	public Response<List<GoodsVO>> findBySearch(@RequestBody Map map) throws BaseException{

		UserVO user = (UserVO) request.getAttribute("user");
		AppAgent agent = (AppAgent) request.getAttribute("agent");
		int userId = 0;
		if (user != null) {
			userId = user.getId();
			map.put("userId", userId);
		}
		int start = map.containsKey("start")?Integer.valueOf(map.get("start").toString()):0;
		int rows = map.containsKey("rows")?Integer.valueOf(map.get("rows").toString()):10;
		map.put("start", start);
		map.put("rows", rows);
		List<GoodsVO> goodsVOs = goodsService.findGoodsVOByWhere(map);

		return Result.resultSet(goodsVOs);
	}

	/**
	 * App通过ID获取goods
	 * @return
	 * @throws BaseException
	 */
	@RequestMapping(value="findGoodsById",method={RequestMethod.POST})
	@ResponseBody
	public Response findGoodsById(@RequestBody Map<String, String> map){
		try {
			if (!map.containsKey("id")) {
				return Result.fail(ExceptionEnum.COMMON_PARAMETER_ERROR_NOT_NULL, "id");
			}

			UserVO user = (UserVO) request.getAttribute("user");
			AppAgent agent = (AppAgent) request.getAttribute("agent");
			logger.info("========findGoodsById=========="+ JSON.toJSONString(user));
			Integer userId = null;
			if (user != null) {
				userId = user.getId();
			}

			Response response = goodsService.findGoodsVOById(Integer.valueOf(map.get("id")), userId);

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

			List<GoodsVO> goodsVOs = goodsService.findGoodsVOByWhere(map);
			return Result.resultSet(goodsVOs);
		}catch (Exception e){
			logger.error(e, e);
			return Result.fail("获取失败，请重试！");
		}
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
