package com.honglinktech.zbgj.admin.controller;

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

import com.honglinktech.zbgj.bean.NewProductBean;
import com.honglinktech.zbgj.bean.SupplierBean;
import com.honglinktech.zbgj.common.ErrorCode;
import com.honglinktech.zbgj.common.Page;
import com.honglinktech.zbgj.common.old.Response;
import com.honglinktech.zbgj.common.old.Result;
import com.honglinktech.zbgj.entity.NewProduct;
import com.honglinktech.zbgj.entity.NewProductImages;
import com.honglinktech.zbgj.entity.ProductCategory;
import com.honglinktech.zbgj.entity.ProductItemCategory;
import com.honglinktech.zbgj.entity.ProductSeries;
import com.honglinktech.zbgj.entity.ShipmentMode;
import com.honglinktech.zbgj.service.ProductItemService;
import com.honglinktech.zbgj.service.ProductService;
import com.honglinktech.zbgj.service.SupplierService;

/**
 * 产品相关的接口控制器
 */
@Controller
@RequestMapping("/product")
public class ProductController extends BaseController {

    @Autowired
    private ProductService productService;
    @Autowired
    private ProductItemService productItemService;
    @Autowired
    private SupplierService supplierService;
    
    /**
     * 获取产品列表
     * @return
     */
    @RequiresPermissions("product/search")
    @RequestMapping("/list")
    public String list(@RequestParam(required = false, defaultValue = "1") int index, 
    					@RequestParam(required = false, defaultValue = "15") int size, 
    					@RequestParam(required = false, defaultValue = "") String key,
    					@RequestParam(required = false, defaultValue = "") Integer sale, 
    					Model model) {
    	Map<String, Object> whereMap = new HashMap<String, Object>();
    	if(!StringUtils.isEmpty(key)){
    		whereMap.put("key",key);
    	}
    	if(sale!=null){
    		whereMap.put("sale",sale);
    	}
    	Page<NewProductBean> page = productService.findNewProductByPage(index, size, "list.html?key="+key+"&sale="+sale+"&", whereMap);
        model.addAttribute("page", page);
        model.addAttribute("key", key);
        model.addAttribute("sale", sale);
        return "product/list";
    }

    /**
     * 添加产品
     * @return
     */
    @RequiresPermissions("product/insert")
    @RequestMapping("/add")
    public String add(Model model) {
        Response<List<ProductSeries>> series = productService.findProductSeriesAll();
        model.addAttribute("series", series.getResult());
        Response<List<ProductCategory>> categories = productService.findProductCategoryAll();
        model.addAttribute("categories", categories.getResult());
        Response<List<SupplierBean>> respSupplierBean = supplierService.findSupplierByProductId(null);
    	model.addAttribute("supplierBeans", respSupplierBean.getResult());
        return "product/form";
    }

    /**
     * 修改产品
     *
     * @return
     */
    @RequiresPermissions("product/search")
    @RequestMapping(value = "/modify")
    public String modify(@RequestParam Integer id, Model model) {
        Response<NewProductBean> bean = productService.findNewProductBeanById(null, id);
        model.addAttribute("product", bean.getResult());
        Response<List<ProductSeries>> series = productService.findProductSeriesAll();
        model.addAttribute("series", series.getResult());
        Response<List<ProductCategory>> categories = productService.findProductCategoryAll();
        model.addAttribute("categories", categories.getResult());
        if(bean.getResult()!=null){
	        Response<List<SupplierBean>> respSupplierBean = supplierService.findSupplierByProductId(bean.getResult().getId());
	       	model.addAttribute("supplierBeans", respSupplierBean.getResult());
        }
       	
        return "product/form";
    }

    /**
     * 添加产品
     *
     * @return
     */
    @RequiresPermissions("product/insert")
    @RequestMapping(value = "/save", method = {RequestMethod.POST})
    public String save(NewProduct product, Model model) {
    	if(product.getSale()==null){
    		product.setSale(false);
    	}
        String[] shipmentModeIds = request.getParameterValues("shipmentModeIds");//提货方式id
        String[] shipmentMode = request.getParameterValues("shipmentMode");//提货方式
        String[] contactPerson = request.getParameterValues("contactPerson");//自提联系人
        String[] contactPhone = request.getParameterValues("contactPhone");//自提联系号码
        String[] remarkDate = request.getParameterValues("remarkDate");//自提时间
        String[] description = request.getParameterValues("description");//自提地址
        
        String[] supplierIds = request.getParameterValues("supplierIds");//供应商ids

        //轮播图片处理
        String[] images = request.getParameterValues("images");//轮播图片
        
        List<NewProductImages> piList = new ArrayList<NewProductImages>();
        if (images != null) {
            for (int i = 0; i < images.length; i++) {
                NewProductImages pi = new NewProductImages();
                pi.setImages(images[i]);
                pi.setSort(i);
                pi.setDeleteFlag(com.honglinktech.zbgj.common.Constants.DELETE_TYPE_ZERO);
                piList.add(pi);
            }
        }

        //提货方式处理
        List<ShipmentMode> smList = new ArrayList<ShipmentMode>();
        if (shipmentMode != null) {
            for (int i = 0; i < shipmentMode.length; i++) {
                ShipmentMode sm = new ShipmentMode();
                if (Integer.valueOf(shipmentMode[i]) == 1) {
                    sm.setName("自提");
                } else if (Integer.valueOf(shipmentMode[i]) == 2) {
                    sm.setName("快递");
                }
                sm.setId(!StringUtils.isEmpty(shipmentModeIds[i])&& shipmentModeIds.length >= (i - 1) ? Integer.valueOf(shipmentModeIds[i]) : 0);
                sm.setShiType(Integer.valueOf(shipmentMode[i]));
                sm.setRelType(com.honglinktech.zbgj.common.Constants.SHIPMENT_MODE_REL_TYPE_NEW_PRODUCT);
                sm.setSort(0);
                sm.setDeleteFlag(com.honglinktech.zbgj.common.Constants.DELETE_TYPE_ZERO);
                sm.setContactPerson(contactPerson[i]);
                sm.setContactPhone(contactPhone[i]);
                sm.setRemarkDate(remarkDate[i]);
                sm.setCreateUserId(0);
                sm.setDescription(description[i]);
                smList.add(sm);

            }
        }
        
        if(StringUtils.isEmpty(product.getImage()) || StringUtils.isEmpty(product.getName())){
			if(StringUtils.isEmpty(product.getImage())){
				addError(model, "主图不能为空");
			}else if(StringUtils.isEmpty(product.getName())){
				addError(model, "名称不能为空");
			}
			
			Response<List<ProductSeries>> series = productService.findProductSeriesAll();
	        model.addAttribute("series", series.getResult());
	        Response<List<ProductCategory>> categories = productService.findProductCategoryAll();
	        model.addAttribute("categories", categories.getResult()); 
	        Response<List<SupplierBean>> respSupplierBean = supplierService.findSupplierByProductId(product.getId());
	       	model.addAttribute("supplierBeans", respSupplierBean.getResult());

	        NewProductBean newProBean = new NewProductBean(product);
			ArrayList<Map<String, Object>> imageList = new ArrayList<Map<String, Object>>();
			if(piList!=null){
				for(NewProductImages is:piList){
					Map<String, Object> imgs=new HashMap<String, Object>();
					imgs.put("imagesAddress", is.getImages());
					imageList.add(imgs);
				}
			}
			newProBean.setShipmentModeList(smList);
			newProBean.setImagesList(imageList);;
			model.addAttribute("product", newProBean);
			return "product/form";
		}
        
        //
        if (product.getId() != null && product.getId() > 0) {
        	Response<String> result = productService.updateNewProduct(product, piList, smList, supplierIds);
            if (result.getCode() != 0) {
                model.addAttribute("product", product);
                addError(model, "修改失败!");
                return "product/form";
            }else{
            	addMessage(model, "修改成功!");
            }
        } else {
            Response<String> result = productService.saveNewProduct(product, piList, smList, supplierIds);
            if (result.getCode() != 0) {
                model.addAttribute("product", product);
                addError(model, "添加失败!");
                return "product/form";
            }else{
            	addMessage(model, "添加成功!");
            }
        }
        return "redirect:modify.html?id="+product.getId();
    }

    /**
     * 删除产品
     *
     * @return
     */
    @RequiresPermissions("product/delete")
    @RequestMapping(value = "/delete", method = {RequestMethod.POST})
    public String delete(Integer id) {
        productService.deleteNewProduct(id);
        return "redirect:list.html";
    }

    /**
     * 批量修改上线下线
     *
     * @return
     */
    @RequiresPermissions("product/update")
    @RequestMapping("/batchUpdateSale")
    @ResponseBody
    public Response<Integer> batchUpdateSale(
    		@RequestParam(required = false) Integer[] ids, //批量修改的ID
    		@RequestParam(required = false) Boolean saleVal, //修改值
    		Model model) {
    	System.out.println("ids:"+ids);
    	System.out.println("saleVal:"+saleVal);
	    	if(ids!=null && ids.length>0 && saleVal!=null){
	    		return productService.batchUpdateProSale(ids,saleVal);
	    	}else{
	    		return Result.fail(ErrorCode.PARAMETER_TYPE_ERROR, "请选择修改的单品");
	    	}
    }

    /**
     * 获取产品类别列表
     *
     * @return
     */
    @RequiresPermissions("product/category")
    @RequestMapping("/category")
    public String listCategory(@RequestParam(required = false, defaultValue = "1") int index, @RequestParam(required = false, defaultValue = "15") int size, Model model) {
        int start = (index - 1) * size;
        Page<ProductCategory> page = productService.findPageProductCategory(start, size, "category.html?");
        model.addAttribute("page", page);
        return "category/list";
    }

    /**
     * 添加产品类别
     *
     * @return
     */
    @RequiresPermissions("product/category:insert")
    @RequestMapping("/category/add")
    public String addCategory(Model model) {
        return "category/form";
    }

    /**
     * 修改产品类别
     *
     * @return
     */
    @RequiresPermissions("product/category:update")
    @RequestMapping(value = "/category/modify")
    public String modifyCategory(@RequestParam Integer id, Model model) {
        Response<ProductCategory> category = productService.findProductCategoryById(id);
        model.addAttribute("category", category.getResult());
        return "category/form";
    }

    /**
     * 保存产品类别
     *
     * @return
     */
    @RequiresPermissions("product/category:insert")
    @RequestMapping(value = "/category/save", method = {RequestMethod.POST})
    public String saveCategory(Integer id, String name, Integer sort, Model model) {
        ProductCategory category = new ProductCategory();
        category.setName(name);
        category.setSort(sort);
        if (id != null) {
            category.setId(id);
            productService.updateProductCategory(category);
            addMessage(model, "修改成功");
        } else {
            productService.saveProductCategory(category);
            addMessage(model, "添加成功");
        }
        return "redirect:../category.html";
    }

    /**
     * 删除产品类别
     *
     * @return
     */
    @RequiresPermissions("product/category:delete")
    @RequestMapping(value = "/category/delete", method = {RequestMethod.POST})
    public String deleteCategory(Integer id, Model model) {
        productService.deleteProductCategory(id);
        addMessage(model, "删除成功");
        return "redirect:../category.html";
    }

    /**
     * 获取产品系列列表
     *
     * @return
     */
    @RequiresPermissions("product/series:search")
    @RequestMapping("/series")
    public String listSeries(@RequestParam(required = false, defaultValue = "1") int index, @RequestParam(required = false, defaultValue = "15") int size, Model model) {
        int start = (index - 1) * size;
        Page<ProductSeries> page = productService.findPageProductSeries(start, size, "series.html?");
        model.addAttribute("page", page);
        return "series/list";
    }

    /**
     * 添加产品系列
     *
     * @return
     */
    @RequiresPermissions("product/series:insert")
    @RequestMapping("/series/add")
    public String addSeries(Model model) {

        return "series/form";
    }

    /**
     * 修改产品系列
     *
     * @return
     */
    @RequiresPermissions("product/series:search")
    @RequestMapping("/series/modify")
    public String modifySeries(@RequestParam Integer id, Model model) {
        Response<ProductSeries> category = productService.findProductSeriesById(id);
        model.addAttribute("series", category.getResult());
        return "series/form";
    }

    /**
     * 保存产品系列
     *
     * @return
     */
    @RequiresPermissions("product/series:insert")
    @RequestMapping(value = "/series/save", method = {RequestMethod.POST})
    public String saveSeries(Integer id, String name, Integer sort, Model model) {
        ProductSeries series = new ProductSeries();
        series.setName(name);
        series.setSort(sort);
        if (id != null) {
            series.setId(id);
            productService.updateProductSeries(series);
            addMessage(model, "修改成功");
        } else {
            productService.saveProductSeries(series);
            addMessage(model, "保存成功");
        }
        return "redirect:../series.html";
    }

    /**
     * 删除产品系列
     *
     * @return
     */
    @RequiresPermissions("product/series:delete")
    @RequestMapping(value = "/series/delete", method = {RequestMethod.POST})
    public String deleteSeries(Integer id, Model model) {
        productService.deleteProductSeries(id);
        addMessage(model, "删除成功");
        return "redirect:../series.html";
    }
    
}