package com.honglinktech.zbgj.enums;

/**
 * 订单状态枚举类
 */
public enum OrderStatusEnum {
	WaitPayment(1, "待付款", "您的订单已提交成功，请尽快支付，我们将尽快为你发货~"),
    WaitShip(2, "待发货", "请你稍等片刻，我们正在快马加鞭的为你配置商品，立即为你发货~"),
    Send(3, "待收货", "你的订单快递运输中，请留意快递小哥~"),
    Complete(4, "已完成", "您的订单已完成送货，非常感谢您的支持，欢迎下次继续光临~"),
    Cancel(9, "已取消", "您的订单已取消，欢迎下次继续光临~");
    

    private int code;
    private String name;
    private String desc;

    OrderStatusEnum(int code, String name, String desc) {
        this.code = code;
        this.name = name;
        this.desc = desc;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public static String getName(int code){
        for(OrderStatusEnum orderStatusEnum:OrderStatusEnum.values()){
            if(orderStatusEnum.getCode() == code){
                return orderStatusEnum.getName();
            }
        }
        return "";
    }
}
