package com.honglinktech.zbgj.bean;

import java.util.List;

import com.google.gson.Gson;
import com.honglinktech.zbgj.entity.Module;

@SuppressWarnings("unused")
public class HomeBean {
	private int type;
	private String title;
	private String url;
	private Result results;
	
	public HomeBean(){}
	
	public HomeBean(Module module){
		this.title = module.getTitle();
		this.type = module.getType();
		this.url = module.getUrl();
		Gson gson = new Gson();
		this.results = gson.fromJson(module.getContent(), Result.class);
	
	}
	public int getType() {
		return type;
	}

	public void setType(int type) {
		this.type = type;
	}
	
	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}


	public String getUrl() {
		return url;
	}


	public void setUrl(String url) {
		this.url = url;
	}
	
	public Result getResults() {
		return results;
	}
	
	public void setResults(Result results) {
		this.results = results;
	}
	
	public static void main(String[] args) {
		HomeBean homeBean = new HomeBean();
		String json = "{subs:[[{imgUrl:\"img/main/39dc41f96634710a4c5c69e250b54257.jpg\",url:\"#/tab/main_societyItem?id=10\"},"+
		              "{imgUrl:\"img/main/a77f88d71a0ac277230d067da1be2b7e.jpg\",url:\"#/tab/main_goodsItem?id=10015\"},"+
		              "],[{imgUrl:\"img/main/c0941c32bab2a063fd94ce1fcd710e89.jpg\",url:\"#/tab/main_goodsItem?id=10016\"},"+
		              "{imgUrl:\"img/main/9298f2101fb7d8423ea1d7443ebac2d1.jpg\",url:\"#/tab/main_goodsItem?id=10017\"},"+
		              "{imgUrl:\"img/main/96c858c99f4b116e9c85aabc7a0baa3e.jpg\",url:\"#/tab/main_goodsItem?id=10018\"},"+
		              "{imgUrl:\"img/main/9bcce5cd870e95734441caf6d210a2ee.jpg\",url:\"#/tab/main_goodsItem?id=10019\"}]]}";
		Gson gson = new Gson();
		Result result = gson.fromJson(json, Result.class);
		System.out.println("+++++++++++"+result.getSubs());
	}
	
	private class Result{
		private List<ResultItem> imgs;
		private List<List<ResultItem>> subs;
		public List<ResultItem> getImgs() {
			return imgs;
		}
		public void setImgs(List<ResultItem> imgs) {
			this.imgs = imgs;
		}
		public List<List<ResultItem>> getSubs() {
			return subs;
		}
		public void setSubs(List<List<ResultItem>> subs) {
			this.subs = subs;
		}
	}
	
	private class ResultItem{
		private String ico;//图标
		private String clazz;//样式
		private String imgUrl;//图片
		private String color;//颜色
		private String url;
		private String title;
		private String itemTitle;
		private String itemDesc;
		private String col;
		public String getImgUrl() {
			return imgUrl;
		}
		public void setImgUrl(String imgUrl) {
			this.imgUrl = imgUrl;
		}
		public String getUrl() {
			return url;
		}
		public void setUrl(String url) {
			this.url = url;
		}
		public String getTitle() {
			return title;
		}
		public void setTitle(String title) {
			this.title = title;
		}
		public String getItemTitle() {
			return itemTitle;
		}
		public void setItemTitle(String itemTitle) {
			this.itemTitle = itemTitle;
		}
		public String getItemDesc() {
			return itemDesc;
		}
		public void setItemDesc(String itemDesc) {
			this.itemDesc = itemDesc;
		}
		public String getCol() {
			return col;
		}
		public void setCol(String col) {
			this.col = col;
		}
		public String getIco() {
			return ico;
		}
		public void setIco(String ico) {
			this.ico = ico;
		}
		public String getClazz() {
			return clazz;
		}
		public void setClazz(String clazz) {
			this.clazz = clazz;
		}
		public String getColor() {
			return color;
		}
		public void setColor(String color) {
			this.color = color;
		}
		
	}
}
