package com.honglinktech.zbgj.admin.controller;

import java.lang.annotation.Annotation;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.google.gson.Gson;
import com.honglinktech.zbgj.annotation.FieldMeta;
import com.honglinktech.zbgj.base.BaseException;
import com.honglinktech.zbgj.base.BaseEntity;
import com.honglinktech.zbgj.base.BaseService;
import com.honglinktech.zbgj.base.ExceptionEnum;
import com.honglinktech.zbgj.base.ReturnInfo;
import com.honglinktech.zbgj.base.ReturnPageData;
import com.honglinktech.zbgj.dao.helper.QueryHelper;

@RestController
public abstract class CommonBaseController<T extends BaseEntity,E extends BaseService<T>> {
	private static Logger logger = Logger.getLogger(CommonBaseController.class);
	protected static final String SAVE = "save";
	protected static final String DELETE = "delete";
	protected static final String UPDATE = "update";
	@Resource
	protected HttpServletRequest request;
	@Resource
	protected HttpServletResponse response;
	
	protected abstract E getService();
	
	@ModelAttribute
	public void setArgs() {
		System.out.println("=============ModelAttribute===========");
	}
	
    /** 基于@ExceptionHandler异常处理 */
	@ResponseBody
    @ExceptionHandler
    public ReturnInfo exp(HttpServletRequest request,HttpServletResponse response, BaseException ex,Object handler) {
		
		logger.error("================baseException=============="+ex.getMessage()+"|"+ex.getExceptionEnum().getLogString());
		ex.printStackTrace();
        return new ReturnInfo(ex.getExceptionEnum());
    }
	@ResponseBody
    @ExceptionHandler
    public ReturnInfo exp(HttpServletRequest request,HttpServletResponse response, Exception ex,Object handler) {
		
		logger.error("==================未知======================"+UUID.randomUUID()+ex.getMessage());
		ex.printStackTrace();
        return new ReturnInfo(ExceptionEnum.COMMON_ERROE);
    }
	
	@RequestMapping(value="save",method={RequestMethod.GET,RequestMethod.POST})
	@ResponseBody
	public ReturnInfo save(@RequestBody T t) throws BaseException{
		checkParameter(t,SAVE);
		int result = getService().save(t);
		ReturnInfo ri = null;
		if(result>=0){
			ri = new ReturnInfo(ExceptionEnum.COMMON_SUCCESS);
		}else{
			ri = new ReturnInfo(ExceptionEnum.COMMON_ERROE);
		}
		return ri;
	}
	@RequestMapping(value="update",method={RequestMethod.GET,RequestMethod.POST})
	@ResponseBody
	public ReturnInfo update(@RequestBody T t) throws BaseException{
		checkParameter(t,UPDATE);
		int result = getService().update(t);
		ReturnInfo ri = null;
		if(result==1){
			ri = new ReturnInfo(ExceptionEnum.COMMON_SUCCESS);
		}else{
			ri = new ReturnInfo(ExceptionEnum.COMMON_ERROE);
		}
		return ri;
	}
	@RequestMapping(value="delete",method={RequestMethod.GET,RequestMethod.POST})
	@ResponseBody
	public ReturnInfo delete(@RequestBody T t) throws BaseException{
		checkParameter(t,DELETE);
		int result = getService().delete(t);
		ReturnInfo ri = null;
		if(result==1){
			ri = new ReturnInfo(ExceptionEnum.COMMON_SUCCESS);
		}else{
			ri = new ReturnInfo(ExceptionEnum.COMMON_ERROE);
		}
		return ri;
	}
	/*
	@RequestMapping(value="deleteAll",method={RequestMethod.GET,RequestMethod.POST})
	@ResponseBody
	public ReturnInfo deleteAll() throws BaseException{
		getService().deleteAll();
		ReturnInfo ri  = new ReturnInfo(ExceptionEnum.SUCCESS);
		return ri;
	}
	*/
	@RequestMapping(value="findById",method={RequestMethod.GET,RequestMethod.POST})
	@ResponseBody
	public ReturnInfo findById(@RequestBody T t) throws BaseException{
		List<T> list = getService().findByWhere(createWhereMap(t));
		return new ReturnInfo(ExceptionEnum.COMMON_SUCCESS,list.size()==1?list.get(0):null);
	}
	
	@RequestMapping(value="findAll",method={RequestMethod.GET,RequestMethod.POST})
	@ResponseBody
	public ReturnInfo findAll() throws BaseException{
		List<T> list = getService().findAll();
		return new ReturnInfo(ExceptionEnum.COMMON_SUCCESS,list);
	}
	
	@RequestMapping(value="findByPage",method={RequestMethod.GET,RequestMethod.POST})
	@ResponseBody
	public ReturnInfo findByPage(@RequestBody T t) throws BaseException{
		QueryHelper<T> qh = new QueryHelper<T>(t.getPageIndex(),t.getPageSize(),createWhereMap(t));
		QueryHelper<T> result = getService().findByQueryHelper(qh);
		
		return new ReturnInfo(ExceptionEnum.COMMON_SUCCESS,new ReturnPageData(t.getPageIndex(), t.getPageSize(), result.getTotalRow(), result.getResultList()));
	}
	
	@RequestMapping(value="findByPageNoCount",method={RequestMethod.GET,RequestMethod.POST})
	@ResponseBody
	public ReturnInfo findByPageNoCount(@RequestBody T t) throws BaseException{
		System.out.println("********************"+new Gson().toJson(t));
		QueryHelper<T> qh = new QueryHelper<T>(t.getPageIndex(),t.getPageSize(),createWhereMap(t));
		QueryHelper<T> result = getService().findByQueryHelperNoCount(qh);
		return new ReturnInfo(ExceptionEnum.COMMON_SUCCESS,result.getResultList());
	}
	
	@RequestMapping(value="findCount",method={RequestMethod.GET,RequestMethod.POST})
	@ResponseBody
	public ReturnInfo findCount(@RequestBody T t) throws BaseException{
		int count = getService().findCount(createWhereMap(t));
		return new ReturnInfo(ExceptionEnum.COMMON_SUCCESS,count);
	}
	
	@RequestMapping(value="fileUploadImg",method={RequestMethod.GET,RequestMethod.POST})
	@ResponseBody
	protected ReturnInfo fileUploadImg(@RequestBody MultipartFile file){
		
		Map<String, String> map = new HashMap<String, String>();
		map.put("imgUrl", "http://mallimg01.touchcdn.com/goods-gallery/14e6793976be8ee85e9ef438d7938e3f.jpg?imageView/2/w/416/interlace/1");
		return new ReturnInfo(ExceptionEnum.COMMON_SUCCESS,map);
	}
	
	
	protected Map<String, String[]> createWhereMap(T t) throws BaseException{
		Map<String, String[]> map = null;
		if(t != null){
			map = new HashMap<String, String[]>();
			Field[] fields = t.getClass().getDeclaredFields();
			try{
				for (int j = 0; j < fields.length; j++) {
				 	String name = fields[j].getName();
		            fields[j].setAccessible(true);
		            Object value = fields[j].get(t);
		            if(!StringUtils.isEmpty(value))
		            map.put(name, new String[]{String.valueOf(value)});
		        } 
			}catch (IllegalArgumentException|IllegalAccessException e) {
				throw new BaseException(e.getMessage());
			}
		}
		return map;
	}
	/**
	 * 检查保存、修改、删除方法的参数
	 * @param t
	 * @param operate SAVE,UPDATE,DELETE
	 * @throws BaseException 
	 */
	protected void checkParameter(T t,String operate) throws BaseException{
		if(t==null){
			throw new BaseException(ExceptionEnum.COMMON_PARAMETER_ERROR);
		}
		try{
			Field[] fields = t.getClass().getDeclaredFields();
			for (int i = 0; fields != null && i < fields.length; i++) {
				if(fields[i].isAnnotationPresent(FieldMeta.class)){
					fields[i].setAccessible(true); // 暴力反射 
					Object fieldValue =fields[i].get(t);
					Annotation p = fields[i].getAnnotation(FieldMeta.class);
					Method fieldNameMethod = p.getClass().getDeclaredMethod("fieldName", null); 
					String fieldName = String.valueOf(fieldNameMethod.invoke(p));
					Boolean primaryKey = null;
					Boolean allowNull = null;
					for (Method method : p.annotationType().getDeclaredMethods()) {
			            if (!method.isAccessible()) {
			                method.setAccessible(true);
			            }
			            Object invoke = method.invoke(p);
			            if(method.getName().equals("allowNull")){
			            	allowNull = (boolean)invoke;
			            }
			            if(method.getName().equals("primaryKey")){
			            	primaryKey = (boolean)invoke;
			            }
			            if(SAVE.equals(operate)){
			            	System.out.println(fieldName+"======"+primaryKey+"====="+allowNull);
			            	if(primaryKey!=null && primaryKey!=null && StringUtils.isEmpty(fieldValue) && !primaryKey && !allowNull){
			            		throw new BaseException(ExceptionEnum.COMMON_PARAMETER_ERROR_NOT_NULL,fieldName);
			            	}
			            }else if(UPDATE.equals(operate) || DELETE.equals(operate)){
			            	
		            		if(primaryKey!=null && primaryKey && StringUtils.isEmpty(fieldValue)){
		            			throw new BaseException(ExceptionEnum.COMMON_PARAMETER_ERROR_NOT_NULL,fieldName);
		            		}
			            }
			           /* if (invoke.getClass().isArray()) {
			                Object[] temp = (Object[]) invoke;
			                for (Object o : temp) {
			                    System.out.println(o);
			                }
			            }*/
			        }
					
					
					
			    }
			}
		} catch (IllegalAccessException|IllegalArgumentException|InvocationTargetException | NoSuchMethodException | SecurityException e) {
			e.printStackTrace();
			throw new BaseException(ExceptionEnum.COMMON_ERROE);
		} 
	}
	
	public static void main(String[] args) throws BaseException {
		
		/*BaseController<CAdmin, BaseService<CAdmin>> test = new BaseController<CAdmin, BaseService<CAdmin>>() {
			@Override
			protected BaseService<CAdmin> getService() {
				return new AdminService();
			}
		};
		test.checkParameter(new CAdmin(),SAVE);*/
	}
	
	
}  