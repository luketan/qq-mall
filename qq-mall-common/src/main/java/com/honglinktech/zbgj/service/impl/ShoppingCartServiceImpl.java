package com.honglinktech.zbgj.service.impl;

import com.alibaba.fastjson.JSON;
import com.honglinktech.zbgj.base.BaseException;
import com.honglinktech.zbgj.bean.ActivityBean;
import com.honglinktech.zbgj.bean.FormatSubBean;
import com.honglinktech.zbgj.dao.GoodsActivityDao;
import com.honglinktech.zbgj.vo.ShoppingCartVO;
import com.honglinktech.zbgj.bean.request.AddShoppingBean;
import com.honglinktech.zbgj.common.Response;
import com.honglinktech.zbgj.common.Result;
import com.honglinktech.zbgj.dao.FormatSubDao;
import com.honglinktech.zbgj.dao.ShoppingCartDao;
import com.honglinktech.zbgj.dao.ShoppingCartFormatDao;
import com.honglinktech.zbgj.entity.ShoppingCart;
import com.honglinktech.zbgj.entity.ShoppingCartFormat;
import com.honglinktech.zbgj.service.ShoppingCartService;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Component
public class ShoppingCartServiceImpl implements ShoppingCartService{
	
	@Resource
	private ShoppingCartDao shoppingCartDao;
	@Resource
	private ShoppingCartFormatDao shoppingCartFormatDao;
	@Resource
	private FormatSubDao formatSubDao;
	@Resource
	private GoodsActivityDao activityDao;


	/**
	 * App购物车查询
	 * @return
	 */
	@Override
	public List<ShoppingCartVO> findShoppingsByIds(Integer userId, List<Integer> ids) {

		if(ids == null || ids.size() == 0){
			return null;
		}
		List<ShoppingCartVO> shoppingCartVOs = shoppingCartDao.findShoppingCartsByIds(userId, ids);
		if(shoppingCartVOs != null){
			for(ShoppingCartVO sc: shoppingCartVOs){
				//规格处理
				List<FormatSubBean> formatSubBeans = formatSubDao.findFormatSubByShoppingId(sc.getId());
				sc.setFormatSubList(formatSubBeans);
				//规格价格处理
				if(formatSubBeans != null){
					for(FormatSubBean fsb:formatSubBeans){
						if(fsb.getNeedPrice()){
							BigDecimal price = sc.getPrice().add(fsb.getVipPrice());
							sc.setPrice(price);
						}
					}
				}

				//活动处理
				List<ActivityBean> activityList = activityDao.findActivityByGoodsId(sc.getGoodsId());
				sc.setActivityList(activityList);

			}
		}
		return shoppingCartVOs;
	}
	/**
	 * App购物车查询(分页可选)
	 * @param whereMap
	 * @return
	 */
	@Override
	public Response findShoppingsByMap(Map whereMap) {

		int start = whereMap.containsKey("start")?Integer.valueOf(whereMap.get("start").toString()):0;
		int rows = whereMap.containsKey("rows")?Integer.valueOf(whereMap.get("rows").toString()):10;

		whereMap.put("start", start);
		whereMap.put("rows", rows);

		List<ShoppingCartVO> shoppingCartVOs = shoppingCartDao.findShoppingCartsByMap(whereMap);
		System.out.println("==========shoppingCartVOs========="+JSON.toJSONString(shoppingCartVOs));
		if(shoppingCartVOs != null){
			for(ShoppingCartVO sc: shoppingCartVOs){
				//规格处理
				List<FormatSubBean> formatSubBeans = formatSubDao.findFormatSubByShoppingId(sc.getId());
				sc.setFormatSubList(formatSubBeans);
				//规格价格处理
				if(formatSubBeans != null){
					for(FormatSubBean fsb:formatSubBeans){
						if(fsb.getNeedPrice()){
							BigDecimal price = sc.getPrice().add(fsb.getVipPrice());
							sc.setPrice(price);
						}
					}
				}

				//活动处理
				List<ActivityBean> activityList = activityDao.findActivityByGoodsId(sc.getGoodsId());
				sc.setActivityList(activityList);

			}
		}
		Map retMap = new HashMap<>();
		retMap.put("shoppingCartVOs", shoppingCartVOs);
		return Result.resultSet(retMap);
	}

	@Override
	public Response<String> addShoppingCart(int userId, AddShoppingBean addShoppingBean) throws BaseException {
		//检查是否已经存在
		Map whereMap = new HashMap();
		whereMap.put("goodsId", addShoppingBean.getGoodsId());
		whereMap.put("userId", userId);
		List<ShoppingCart> shoppingCartList = shoppingCartDao.findByWhere(whereMap);
		String formatSubIdString = JSON.toJSONString(addShoppingBean.getFormatSubIds()).replace("]", ",]");
		System.out.println("formatSubIdString:"+formatSubIdString);
		if(shoppingCartList!=null && shoppingCartList.size()>0){
			for(int i=0;i<shoppingCartList.size();i++){
				ShoppingCart sc = shoppingCartList.get(i);
				Map scfWhereMap = new HashMap();
				scfWhereMap.put("shoppingCartId",sc.getId());
				System.out.println("===addShoppingCart.scfWhereMap==="+JSON.toJSONString(scfWhereMap));
				List<ShoppingCartFormat> scfList = shoppingCartFormatDao.findByWhere(scfWhereMap);
				if(scfList!=null && scfList.size()>0 && addShoppingBean.getFormatSubIds()!=null && addShoppingBean.getFormatSubIds().length>0){
					int flag = 0;
					for(int j=0; j<scfList.size(); j++){
						System.out.println(scfList.get(j).getFormatSubId()+"===addShoppingCart==="+formatSubIdString);
						if(formatSubIdString.indexOf(scfList.get(j).getFormatSubId()+"")>0){//添加
							flag++;
						}else{
							break;
						}
					}
					//修改
					if(flag==scfList.size()){
						updateShoppingCart(userId, sc.getId(), sc.getNum()+addShoppingBean.getNum(), 1, null);
						return Result.success("添加购物车成功！");
					}
				}
			}
		}
		//添加
		ShoppingCart tshoppingCart = new ShoppingCart();
		tshoppingCart.setUserId(userId);
		tshoppingCart.setGoodsId(addShoppingBean.getGoodsId());
		tshoppingCart.setNum(addShoppingBean.getNum());
		int result = shoppingCartDao.insert(tshoppingCart);
		if(addShoppingBean.getFormatSubIds()!=null && addShoppingBean.getFormatSubIds().length>0){
			List<ShoppingCartFormat> scfList = new ArrayList<ShoppingCartFormat>();
			for(int i=0;i<addShoppingBean.getFormatSubIds().length;i++){
				ShoppingCartFormat shoppingCartFormat = new ShoppingCartFormat();
				shoppingCartFormat.setFormatSubId(addShoppingBean.getFormatSubIds()[i]);
				shoppingCartFormat.setShoppingCartId(tshoppingCart.getId());
				scfList.add(shoppingCartFormat);
			}
			shoppingCartFormatDao.saveBatch(scfList);
		}
		
		if(result>0){
			return Result.success("添加购物车成功！");
		}else{
			return Result.success("添加购物车失败！");
		}
	}

	/**
	 * 删除购物车
	 * @param userId
	 * @param id
	 * @return
	 * @throws BaseException
	 */
	@Override
	public Response<String> deleteShoppingCart(Integer userId, Integer id) throws BaseException {
		int result = shoppingCartDao.deleteByIdAndUserId(userId, id);
		if(result>0){
			return Result.success("删除购物车成功！");
		}else{
			return Result.success("删除购物车失败！");
		}
	}

	@Override
	public Response<String> deleteInvalid(Integer userId) {
		int result = shoppingCartDao.deleteInvalid(userId);
		if(result>0){
			return Result.success("清除失效的商品成功！");
		}else{
			return Result.success("清除失效的商品失败！");
		}
	}

	/**
	 * 修改购物车的数量与选中
	 * @param userId
	 * @param id
	 * @param num
	 * @param checkbox
	 * @param checkAll
	 * @return
	 */
	@Override
	public Response<String> updateShoppingCart(Integer userId, Integer id,
			Integer num, Integer checkbox, Boolean checkAll) {
		if(checkAll == null){
			ShoppingCart shoppingCart = new ShoppingCart();
			shoppingCart.setId(id);
			shoppingCart.setNum(num);
			shoppingCart.setCheckbox(checkbox);
			shoppingCart.setUserId(userId);
			int result = shoppingCartDao.updateShoppingCart(shoppingCart);
			if(result>0){
				return Result.success("修改购物车成功！");
			}else{
				return Result.success("修改购物车失败！");
			}
		}else{
			int result = shoppingCartDao.updateShoppingCartChckboxAll(userId, checkAll);
			if(result>0){
				return Result.success("修改购物车成功！");
			}else{
				return Result.success("修改购物车失败！");
			}
		}
	}

}
