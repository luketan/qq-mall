package com.honglinktech.zbgj.admin.controller;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.honglinktech.zbgj.bean.ItemFormat;
import com.honglinktech.zbgj.bean.NewProductBean;
import com.honglinktech.zbgj.bean.ProductItemBean;
import com.honglinktech.zbgj.bean.SpecificationBean;
import com.honglinktech.zbgj.common.ErrorCode;
import com.honglinktech.zbgj.common.Page;
import com.honglinktech.zbgj.common.old.Response;
import com.honglinktech.zbgj.common.old.Result;
import com.honglinktech.zbgj.entity.ProItemFormat;
import com.honglinktech.zbgj.entity.ProductItem;
import com.honglinktech.zbgj.entity.ProductItemCategory;
import com.honglinktech.zbgj.entity.ProductItemImages;
import com.honglinktech.zbgj.entity.Specification;
import com.honglinktech.zbgj.service.ProductItemService;
import com.honglinktech.zbgj.service.ProductService;

/**
 * 产品相关的接口控制器
 */
@Controller
@RequestMapping("/productItem")
public class ProductItemController extends BaseController {

    @Autowired
    private ProductService productService;
    
    @Autowired
    private ProductItemService productItemService;
    /**
     * 获取单品列表
     *
     * @return
     */
    @RequiresPermissions("productItem/search")
    @RequestMapping("/item")
    public String listItem(
    		@RequestParam(required = false, defaultValue = "") String productName, 
    		@RequestParam(required = false, defaultValue = "") String itemName, 
    		@RequestParam(required = false, defaultValue = "0") int saleType, 
    		@RequestParam(required = false) Boolean isSale, 
    		@RequestParam(required = false) Boolean isRecommend, 
    		@RequestParam(required = false, defaultValue = "1") int index, 
    		@RequestParam(required = false, defaultValue = "15") int size, 
    		Model model) {
		    	Map<String, Object> map = new HashMap<String, Object>();
		    	if(!StringUtils.isEmpty(productName)){
		    		map.put("productName", productName);
		    	}
		    	if(!StringUtils.isEmpty(itemName)){
		    		map.put("itemName", itemName);
		    	}
		    	if(isSale!=null){
		    		map.put("isSale", isSale);
		    	}
		    	if(isRecommend!=null){
		    		map.put("isRecommend", isRecommend);
		    	}
		    	if(saleType>0){
		    		map.put("saleType", saleType);
		    	}
		        Page<ProductItem> page = productItemService.findProductItemsPageByMap(map, index, size, "item.html?");
		        model.addAttribute("page", page);
		        model.addAttribute("productName",productName);
		        model.addAttribute("itemName",itemName);
		        model.addAttribute("isSale",isSale);
		        model.addAttribute("saleType",saleType);
		        return "item/list";
    }
    
    /**
     * 批量修改上线下线
     *
     * @return
     */
    @RequiresPermissions("productItem/update")
    @RequestMapping("/batchUpdateSale")
    @ResponseBody
    public Response<Integer> batchUpdateSale(
    		@RequestParam(required = false) Integer[] ids, //批量修改的ID
    		@RequestParam(required = false) Boolean saleVal, //修改值
    		Model model) {
    	System.out.println("ids:"+ids);
    	System.out.println("saleVal:"+saleVal);
	    	if(ids!=null && ids.length>0 && saleVal!=null){
	    		return productItemService.batchUpdateSale(ids,saleVal);
	    	}else{
	    		return Result.fail(ErrorCode.PARAMETER_TYPE_ERROR, "请选择修改的单品");
	    	}
    }

    /**
     * 添加单品
     *
     * @return
     */
    @RequiresPermissions("productItem/insert")
    @RequestMapping("/item/add")
    public String addItem(Model model) {
        Page<NewProductBean> resp = productService.findNewProductByPage(0, Integer.MAX_VALUE, "", null);
        Response<List<ProductItemCategory>> response = productItemService.findProductItemCategoryAll();
        model.addAttribute("newProducts", resp.getList());
        model.addAttribute("productItemCategorys", response.getResult());
        return "item/form";
    }

    /**
     * 修改单品
     *
     * @return
     */
    @RequiresPermissions("productItem/search")
    @RequestMapping(value = "/item/modify")
    public String modifyItem(@RequestParam Integer id,
    		@RequestParam(required = false, defaultValue = "") String message,
    		@RequestParam(required = false, defaultValue = "") String error, 
    		Model model) {
        Page<NewProductBean> resp = productService.findNewProductByPage(0, Integer.MAX_VALUE, "", null);
        model.addAttribute("newProducts", resp.getList());
        Response<List<ProductItemCategory>> response = productItemService.findProductItemCategoryAll();
        model.addAttribute("productItemCategorys", response.getResult());
        Response<ProductItemBean> item = productItemService.findProductItemById(id, null);
        model.addAttribute("item", item.getResult());
        if(!StringUtils.isEmpty(message)){
        	addMessage(model, message);
        }
        if(!StringUtils.isEmpty(error)){
        	addError(model, error);
        }
        return "item/form";
    }

    /**
     * 保存单品
     * @return
     */
    @RequiresPermissions("productItem/insert")
    @RequestMapping(value = "/item/save", method = {RequestMethod.POST})
    public String saveItem(Model model,ProductItem productItem) {
    	
        //规格
    	String[] spIds = request.getParameterValues("spIds");
        String[] spNames = request.getParameterValues("spName");
        String[] spSpeTypes = request.getParameterValues("spSpeType");
        String[] spPrefixs = request.getParameterValues("spPrefix");
        String[] spStartValues = request.getParameterValues("spStartValue");
        String[] spEndValues = request.getParameterValues("spEndValue");
        String[] spUnitPrices = request.getParameterValues("spUnitPrice");
        String[] spSpeShowUnits = request.getParameterValues("spSpeShowUnit");
        String[] spSpeSelect = request.getParameterValues("spSpeSelect");
        
        List<Specification> spList = new ArrayList<Specification>();
        if (spNames != null) {
            for (int i = 0; i < spNames.length; i++) {
                Specification sp = new Specification();
                sp.setId(spIds!=null && !StringUtils.isEmpty(spIds[i])?Integer.valueOf(spIds[i]):null);
                sp.setName(spNames[i]);
                sp.setSpeType(!StringUtils.isEmpty(spSpeTypes[i]) ? Integer.valueOf(spSpeTypes[i]) : 1);
                sp.setPrefix(spPrefixs[i]);
                sp.setStartValue(!StringUtils.isEmpty(spStartValues[i])?new BigDecimal(spStartValues[i].trim()):new BigDecimal(0));
                sp.setEndValue(!StringUtils.isEmpty(spEndValues[i])?new BigDecimal(spEndValues[i].trim()):new BigDecimal(0));
                sp.setUnitPrice(!StringUtils.isEmpty(spUnitPrices[i])?new BigDecimal(spUnitPrices[i].trim()) : new BigDecimal(0));
                sp.setSpeShowUnit(spSpeShowUnits[i]);
                sp.setDeleteFlag(com.honglinktech.zbgj.common.Constants.DELETE_TYPE_ZERO);
                if ("1".equals(spSpeSelect[i]))
                    sp.setIsSelect(true);
                else
                    sp.setIsSelect(false);
                spList.add(sp);
            }
        }
        
        //轮播图片
        String[] images = request.getParameterValues("images");
//    	String[] sorts = request.getParameterValues("sorts");
        List<ProductItemImages> piList = new ArrayList<ProductItemImages>();
        if (images != null) {
            for (int i = 0; i < images.length; i++) {
                ProductItemImages pi = new ProductItemImages();
                pi.setImages(images[i]);
//	    		pi.setSort(Integer.valueOf(sorts[i]));
                pi.setDeleteFlag(com.honglinktech.zbgj.common.Constants.DELETE_TYPE_ZERO);
                piList.add(pi);
            }
        }
        
        //样式处理
        List<ProItemFormat> proItemFormatList = new ArrayList<ProItemFormat>();//样式
        String[] proItemFormatIds = request.getParameterValues("proItemFormatIds");
        if(proItemFormatIds!=null && proItemFormatIds.length>0){
        	 for(String proItemFormatId:proItemFormatIds){
             	if(!StringUtils.isEmpty(proItemFormatId)){
             		ProItemFormat proItemFormat = new ProItemFormat();
             		List<ItemFormat> itemFormatList = new ArrayList<ItemFormat>();
             		
             		int pfId = Integer.valueOf(proItemFormatId);
         			String proItemFormatName = request.getParameter("proItemFormatName"+proItemFormatId);
         			String needFee = request.getParameter("proItemFormatNeedFee"+proItemFormatId);
         			String[] formatIds = request.getParameterValues("formatIds"+pfId);
         			if(formatIds != null && formatIds.length > 0){
         				for(String fId:formatIds){
         					String formatName = request.getParameter("formatName"+fId);
         					String formatSelect = request.getParameter("formatSelect"+fId);
         					String formatFee = request.getParameter("formatFee"+fId);
         					String formatVipFee = request.getParameter("formatVipFee"+fId);
         					ItemFormat itemFormat = new ItemFormat();
         					itemFormat.setSelect(Boolean.valueOf(formatSelect));
         					itemFormat.setName(formatName);
         					itemFormat.setFee(new BigDecimal(StringUtils.isEmpty(formatFee)?"0":formatFee));
         					itemFormat.setVipFee(new BigDecimal(StringUtils.isEmpty(formatVipFee)?"0":formatVipFee));
         					itemFormatList.add(itemFormat);
             			}
         			}
         			proItemFormat.setId(pfId);
         			proItemFormat.setName(proItemFormatName);
         			proItemFormat.setNeedFee(Boolean.valueOf(needFee));
         			proItemFormat.setFormatList(itemFormatList);
         			proItemFormatList.add(proItemFormat);
             	}
             }
        }
       
        ObjectMapper objectMapper = new ObjectMapper();
        String formatJson="";
		try {
			formatJson = objectMapper.writeValueAsString(proItemFormatList);
			productItem.setFormat(formatJson);
		} catch (JsonProcessingException e) {
			e.printStackTrace();
			logger.error(e);
		}
		
		if(productItem.getFee()==null 
				|| StringUtils.isEmpty(productItem.getImage()) 
				|| StringUtils.isEmpty(productItem.getName())
				|| productItem.getCategoryId()==0){
			if(productItem.getFee()==null){
				addError(model, "工费不能为空");
			}else if(StringUtils.isEmpty(productItem.getImage())){
				addError(model, "主图不能为空");
			}else if(StringUtils.isEmpty(productItem.getName())){
				addError(model, "名称不能为空");
			}else if(productItem.getCategoryId()==0){
				addError(model, "请选择类型");
			}
			
			Page<NewProductBean> resp = productService.findNewProductByPage(0, Integer.MAX_VALUE, "", null);
	        model.addAttribute("newProducts", resp.getList());
	        Response<List<ProductItemCategory>> response = productItemService.findProductItemCategoryAll();
	        model.addAttribute("productItemCategorys", response.getResult());
			ProductItemBean proItemBean = new ProductItemBean(productItem);
			List<SpecificationBean> spBeanList=new ArrayList<SpecificationBean>();
			if(spList!=null){
				for(Specification sp:spList){
					spBeanList.add(new SpecificationBean(sp));
				}
			}
			proItemBean.setSpecificationList(spBeanList);
			proItemBean.setProItemFormatList(proItemFormatList);
			model.addAttribute("item", proItemBean);
			return "item/form";
		}
		
        if (productItem.getId() > 0) {
        	productItemService.updateProductItem(productItem, piList, spList);
            addMessage(model, "修改成功");
        } else {
            productItem.setDeleteFlag(com.honglinktech.zbgj.common.Constants.DELETE_TYPE_ZERO);
            productItemService.saveProductItem(productItem, piList, spList);
            addMessage(model, "保存成功");
        }
        return "redirect:modify.html?id="+productItem.getId();
    }

    /**
     * 删除单品
     *
     * @return
     */
    @RequiresPermissions("productItem/delete")
    @RequestMapping(value = "/item/delete", method = {RequestMethod.POST})
    public String deleteItem(Integer id,Model model) {
    	productItemService.deleteProductItem(id);
        addMessage(model, "删除成功");
        return "redirect:../item.html";
    }
        
    /**
     * 获取单品类别列表
     * @return
     */
    @RequiresPermissions("productItem/category:search")
    @RequestMapping("/item/category")
    public String itemCategoryList(@RequestParam(required = false, defaultValue = "1") int index, @RequestParam(required = false, defaultValue = "15") int size, Model model) {
        Page<ProductItemCategory> page = productItemService.findAllProductItemCategory(index, size, "/product/item/category?");
        model.addAttribute("page", page);
        return "item/category/list";
    }
    /**
     * 添加单品类别
     * @return
     */
    @RequiresPermissions("productItem/category:insert")
    @RequestMapping("/item/category/add")
    public String itemCategoryAdd(Model model) {
        return "item/category/form";
    }
    /**
     * 修改单品类别
     * @return
     */
    @RequiresPermissions("productItem/category:search")
    @RequestMapping("/item/category/modify")
    public String itemCategoryModify(@RequestParam Integer id, Model model) {
    	Response<ProductItemCategory>  respone = productItemService.findProductItemCategoryById(id);
    	model.addAttribute("productItemCategory",respone.getResult());
        return "item/category/form";
    }
    /**
     * 保存或者修改单品
     * @return
     */
    @RequiresPermissions("productItem/category:insert")
    @RequestMapping("/item/category/save")
    public String itemCategorySave(ProductItemCategory proItemCate, Model model) {
    	Response<String>  respone = productItemService.saveOrUpdateProductItemCategory(proItemCate);
    	if(respone.getCode()==0){
    		addMessage(model, respone.getMsg());
    	}else{
    		addError(model, respone.getMsg());
    	}
    	
    	return "redirect:../category/modify.html?id="+proItemCate.getId();
    }
    /**
     * 删除单品类别
     * @return
     */
    @RequiresPermissions("productItem/category:delete")
    @RequestMapping("/item/category/delete")
    public String itemCategoryDelete(@RequestParam Integer id, Model model) {
    	Response<String>  respone = productItemService.deleteProductItemCategory(id);
    	if(respone.getCode()==0){
    		addMessage(model, respone.getMsg());
    	}else{
    		addError(model, respone.getMsg());
    	}
    	return "redirect:../category.html";
    }
    
    /**
     * ajax删除产品规格
     *
     * @return
     */
    @RequiresPermissions("productItem/update")
    @RequestMapping(value = "/item/deleteSpe", method = {RequestMethod.POST})
    @ResponseBody
    public Response<String> deleteSpe(Integer id, Model model) {
    	Response<String> respone = productItemService.deleteSpecification(id);
    	if(respone.getCode()==0){
    		addMessage(model, respone.getMsg());
    	}else{
    		addError(model, respone.getMsg());
    	}
        return respone;
    }
}