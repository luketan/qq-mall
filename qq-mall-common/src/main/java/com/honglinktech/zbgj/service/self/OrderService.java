package com.honglinktech.zbgj.service.self;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.honglinktech.zbgj.base.BaseException;
import com.honglinktech.zbgj.base.ExceptionEnum;
import com.honglinktech.zbgj.bean.OrderBean;
import com.honglinktech.zbgj.common.Response;
import com.honglinktech.zbgj.common.Result;
import com.honglinktech.zbgj.dao.TOrderDao;
import com.honglinktech.zbgj.dao.TOrderItemDao;
import com.honglinktech.zbgj.dao.TPostDetailDao;
import com.honglinktech.zbgj.dao.TUserAddressDao;
import com.honglinktech.zbgj.dao.helper.QueryHelper;
import com.honglinktech.zbgj.entity.TOrder;
import com.honglinktech.zbgj.entity.TOrderItem;
import com.honglinktech.zbgj.entity.TPostDetail;
import com.honglinktech.zbgj.entity.TUserAddress;
import com.honglinktech.zbgj.service.TOrderService;

@Component
public class OrderService extends TOrderService {

	@Autowired
	private TOrderDao torderDao;
	@Autowired
	private TOrderItemDao torderItemDao;
	@Autowired
	private TUserAddressDao tuserAddressDao;
	@Autowired
	private TPostDetailDao tpostDetailDao;
	

	public Response<List<OrderBean>> appFindOrderBeanList(Integer userId, Integer index, Integer size) throws BaseException{

		if(userId == null || userId.intValue()<=0){
			return Result.fail(ExceptionEnum.COMMON_PARAMETER_ERROR, "错误的请求！","userId",String.valueOf(userId));
		}
		Map<String, String[]> whereMap = new HashMap<String, String[]>();
		whereMap.put(TOrder.DBMaping.userId.name(), new String[]{String.valueOf(userId)});
		whereMap.put(TOrder.DBMaping.deleteFlag.name(), new String[]{String.valueOf("0")});
		QueryHelper<TOrder> qh = new QueryHelper<TOrder>(whereMap);
		qh.setIndex(index);
		qh.setSize(size);
		Map<String, String> orderByMap = new HashMap<String, String>();
		orderByMap.put(TOrder.DBMaping.status.getDbName(),"asc");
		qh.setOrderBy(orderByMap);
		QueryHelper<TOrder> restQh = torderDao.findByQueryHelper(qh);
		
		List<OrderBean> orderBeanList = new ArrayList<OrderBean>();
		if(restQh.getResultList()!=null){
			for(TOrder torder:restQh.getResultList()){
				OrderBean orderBean = new OrderBean(torder);
				Map<String, String[]> orderItemWhere = new HashMap<String, String[]>();
				orderItemWhere.put(TOrderItem.DBMaping.orderId.name(), new String[]{String.valueOf(orderBean.getId())});
				List<TOrderItem> torderItems = torderItemDao.findByWhere(orderItemWhere);
				orderBean.setOrderItemList(torderItems);
				orderBeanList.add(orderBean);
			}
		}
		
		return Result.resultSet(orderBeanList);
	}

	public Response<OrderBean> appFindOrderBeanById(Integer userId,Integer id) {
		if(userId == null || userId.intValue()<=0){
			return Result.fail(ExceptionEnum.COMMON_PARAMETER_ERROR, "错误的请求！","userId",String.valueOf(userId));
		}
		if(id == null || id.intValue()<=0){
			return Result.fail(ExceptionEnum.COMMON_PARAMETER_ERROR, "错误的请求！","orderId",String.valueOf(id));
		}
		Map<String, String[]> whereMap = new HashMap<String, String[]>();
		whereMap.put(TOrder.DBMaping.userId.name(), new String[]{String.valueOf(userId)});
		whereMap.put(TOrder.DBMaping.id.name(), new String[]{String.valueOf(id)});

		TOrder torder = torderDao.findById(id);
		if(torder.getUserId().intValue() != userId.intValue()){
			return Result.fail(ExceptionEnum.COMMON_ERROE, "错误的请求！",torder.getUserId()+"!="+userId);
		}
		
		OrderBean orderBean = new OrderBean(torder);
		Map<String, String[]> orderItemWhere = new HashMap<String, String[]>();
		orderItemWhere.put(TOrderItem.DBMaping.orderId.name(), new String[]{String.valueOf(orderBean.getId())});
		List<TOrderItem> torderItems = torderItemDao.findByWhere(orderItemWhere);
		orderBean.setOrderItemList(torderItems);
		
		TUserAddress tuserAddress = tuserAddressDao.findById(orderBean.getAddressId());
		orderBean.setTuserAddress(tuserAddress);
		
		//TODO 活动，购物券，红包处理
		return Result.resultSet(orderBean);
	}

	public Response<List<TPostDetail>> findPostDetail(String postCode) {
		Map<String, String[]> whereMap = new HashMap<String, String[]>();
		whereMap.put(TPostDetail.DBMaping.postCode.name(), new String[]{postCode});
		List<TPostDetail> postDetailList = tpostDetailDao.findByWhere(whereMap);
		return Result.resultSet(postDetailList);
	}
}
