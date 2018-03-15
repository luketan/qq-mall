package com.honglinktech.zbgj.common;

import org.springframework.context.annotation.Configuration;

import java.math.BigDecimal;

/**
 * 常量类
 * Created by Administrator on 2016/1/22.
 */
@Configuration
public class Constants {

    public final static String CONFIG_FILE_PATH = "config.properties";
    public static final String IMAGE_FILE_PATH = "images.file.path";

    public final static String  SYSTEM_SET_CUSTOMER_CENTER = "customer_center";//客户中心
    public final static String  SYSTEM_SET_ABOUT_US = "about_us";//关于我们
    public final static String  SYSTEM_SET_CUSTOMER_TELEPHONE = "customer_telephone";//客服电话
    public final static String  SYSTEM_SET_JPUSH_PACK_RUNNING = "jpush_pack_running"; //即可推送
    
    //删除标志
    public final static byte DELETE_TYPE_ZERO = 0X00;//未删除
    public final static byte DELETE_TYPE_ONE = 0X01;//已删除
    
    //删除标志
    public final static int YES = 1;//未删除
    public final static int N0 = 0;//已删除
    
    //日志类型
    public final static int CHANGE_MONEY = 1;//金钱
    public final static int CHANGE_VIRTUAL_MONEY = 2;//虚拟钱
    public final static int CHANGE_POINT = 3;//积分
    
    //图片类型(1是商品图，2是商品评论图片,3是论坛图片,4是论坛图片,5意见反馈图)
    public final static int PIC_GOODS = 1;//
    public final static int PIC_GOODS_DIS = 2;//
    public final static int PIC_SOCIETY = 3;//
    public final static int PIC_SOCIETY_DIC = 4;//
    public final static int PIC_FEED_BACK = 5;//
    //图片地址类型
    public final static int PIC_URL_TYPE_HTTP=1;
    public final static int PIC_URL_TYPE_ABSOLUT=2;
    //用户收藏类型
    public final static int USER_KEEP_TYPE_GOODS=1;
    public final static int USER_KEEP_TYPE_DIS=2;
    //选中
    public final static int KEY_CHECKED=1;
    public final static int KEY_NO_CHECKED=0;
    //
    //
    //运费
    public final static BigDecimal POST_MONEY = new BigDecimal(8);
    public final static BigDecimal LOSE_POST_MONEY = new BigDecimal(0);
    
    //帖子状态
    public final static int SOCIETY_NOTE_STATUS_PENDING=1;
    public final static int SOCIETY_NOTE_STATUS_NORMAL=2;
    //帖子评论状态
    public final static int SOCIETY_DIS_STATUS_NORMAL=0;

    //CommonConfig key
    public final static String GROUP_HEAG_IMAGE_PAHT = "/data/services/douquapi/image";


    public static String goodsActivityTypeName(int type){
    	String typeName = "";
    	switch (type) {
		case 1:
			typeName = "打折";
			break;
		case 2:
			typeName = "包邮";
			break;
		case 3:
			typeName = "赠送";
			break;
		case 4:
			typeName = "满减";
			break;
		default:
			break;
		}
    	return typeName;
    }

}
