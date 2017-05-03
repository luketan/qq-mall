package com.honglinktech.zbgj.service.self;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Component;

import com.alibaba.fastjson.JSON;
import com.honglinktech.zbgj.base.BaseException;
import com.honglinktech.zbgj.bean.FormatSubBean;
import com.honglinktech.zbgj.bean.ShoppingCartBean;
import com.honglinktech.zbgj.bean.request.AddShoppingBean;
import com.honglinktech.zbgj.common.Response;
import com.honglinktech.zbgj.common.Result;
import com.honglinktech.zbgj.dao.TShoppingCartDao;
import com.honglinktech.zbgj.dao.TShoppingCartFormatDao;
import com.honglinktech.zbgj.dao.self.FormatSubDao;
import com.honglinktech.zbgj.dao.self.ShoppingCartBeanDao;
import com.honglinktech.zbgj.entity.TShoppingCart;
import com.honglinktech.zbgj.entity.TShoppingCartFormat;
import com.honglinktech.zbgj.service.TShoppingCartService;

@Component
public class ShoppingCartService extends TShoppingCartService {
	
	@Resource
	private TShoppingCartDao shoppingCartDao;
	@Resource
	private TShoppingCartFormatDao tshoppingCartFormatDao;
	@Resource
	private ShoppingCartBeanDao shoppingCartBeanDao;
	@Resource
	private FormatSubDao formatSubDao;
	/**
	 * App购物车查询(分页可选)
	 * @param whereMap
	 * @return
	 */
	public Response<List<ShoppingCartBean>> findShoppingBeansByMap(Map<String,Object> whereMap) {
		List<ShoppingCartBean> shoppingCartBeans = shoppingCartBeanDao.findShoppingCartBeansByMap(whereMap);
		if(shoppingCartBeans != null){
			for(ShoppingCartBean sc:shoppingCartBeans){
				List<FormatSubBean> formatSubBeans = formatSubDao.findFormatSubByShoppingId(sc.getId());
				sc.setFormatSubBeanList(formatSubBeans);
			}
		}
		return Result.resultSet(shoppingCartBeans);
	}
	
	/**
	 * App购物车查询(分页可选)
	 * @param whereMap
	 * @return
	 */
	public Response<List<ShoppingCartBean>> findShoppingBeansGoodsInfoByMap(Map<String,Object> whereMap) {
		List<ShoppingCartBean> shoppingCartBeans = shoppingCartBeanDao.findShoppingCartBeansGoodsInfoByMap(whereMap);
		if(shoppingCartBeans != null){
			for(ShoppingCartBean sc:shoppingCartBeans){
				List<FormatSubBean> formatSubBeans = formatSubDao.findFormatSubByShoppingId(sc.getId());
				sc.setFormatSubBeanList(formatSubBeans);
				//规格价格处理
				if(formatSubBeans != null){
					for(FormatSubBean fsb:formatSubBeans){
						if(fsb.getNeedPrice()){
							sc.setPrice(fsb.getPrice());
						}
					}
				}
			}
		}
		return Result.resultSet(shoppingCartBeans);
	}


	public Response<String> addShoppingCart(int userId, AddShoppingBean addShoppingBean) throws BaseException {
		//检查是否已经存在
		Map<String,String[]> whereMap = new HashMap<String, String[]>();
		whereMap.put(TShoppingCart.DBMaping.goodsId.name(), new String[]{addShoppingBean.getGoodsId()+""});
		whereMap.put(TShoppingCart.DBMaping.userId.name(), new String[]{userId+""});
		List<TShoppingCart> tshoppingCartList = shoppingCartDao.findByWhere(whereMap);
		String formatSubIdString = JSON.toJSONString(addShoppingBean.getFormatSubIds()).replace("]", ",]");
		System.out.println("formatSubIdString:"+formatSubIdString);
		if(tshoppingCartList!=null && tshoppingCartList.size()>0){
			for(int i=0;i<tshoppingCartList.size();i++){
				TShoppingCart sc = tshoppingCartList.get(i);
				Map<String,String[]> scfWhereMap = new HashMap<String, String[]>();
				scfWhereMap.put(TShoppingCartFormat.DBMaping.shoppingCartId.name(), new String[]{sc.getId()+","});
				List<TShoppingCartFormat> scfList = tshoppingCartFormatDao.findByWhere(scfWhereMap);
				if(scfList!=null && scfList.size()>0 && addShoppingBean.getFormatSubIds()!=null && addShoppingBean.getFormatSubIds().length>0){
					int flag = 0;
					for(int j=0; j<scfList.size(); j++){
						System.out.println(scfList.get(j).getFormatSubId()+"======"+formatSubIdString);
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
		TShoppingCart tshoppingCart = new TShoppingCart();
		tshoppingCart.setUserId(userId);
		tshoppingCart.setGoodsId(addShoppingBean.getGoodsId());
		tshoppingCart.setNum(addShoppingBean.getNum());
		int result = shoppingCartDao.save(tshoppingCart);
		if(addShoppingBean.getFormatSubIds()!=null && addShoppingBean.getFormatSubIds().length>0){
			List<TShoppingCartFormat> scfList = new ArrayList<TShoppingCartFormat>();
			for(int i=0;i<addShoppingBean.getFormatSubIds().length;i++){
				TShoppingCartFormat shoppingCartFormat = new TShoppingCartFormat();
				shoppingCartFormat.setFormatSubId(addShoppingBean.getFormatSubIds()[i]);
				shoppingCartFormat.setShoppingCartId(result);
				scfList.add(shoppingCartFormat);
			}
			tshoppingCartFormatDao.saveBatch(scfList);
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
	public Response<String> deleteShoppingCart(Integer userId, Integer id) throws BaseException {
		TShoppingCart sc = new TShoppingCart();
		sc.setId(id);
		sc.setUserId(userId);
		int result = shoppingCartDao.delete(sc);
		TShoppingCartFormat scf = new TShoppingCartFormat();
		scf.setShoppingCartId(id);
		tshoppingCartFormatDao.delete(scf);
		if(result>0){
			return Result.success("删除购物车成功！");
		}else{
			return Result.success("删除购物车失败！");
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
	public Response<String> updateShoppingCart(Integer userId, Integer id,
			Integer num, Integer checkbox, Boolean checkAll) {
		if(checkAll == null){
			TShoppingCart tshoppingCart = new TShoppingCart();
			tshoppingCart.setId(id);
			tshoppingCart.setNum(num);
			tshoppingCart.setCheckbox(checkbox);
			int result = shoppingCartBeanDao.updateShoppingCart(userId, tshoppingCart);
			if(result>0){
				return Result.success("修改购物车成功！");
			}else{
				return Result.success("修改购物车失败！");
			}
		}else{
			int result = shoppingCartBeanDao.updateShoppingCartChckboxAll(userId, checkAll);
			if(result>0){
				return Result.success("修改购物车成功！");
			}else{
				return Result.success("修改购物车失败！");
			}
		}
		
	}

	
}
