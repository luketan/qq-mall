package com.honglinktech.zbgj.service.impl;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.TypeReference;
import com.alibaba.fastjson.parser.Feature;
import com.honglinktech.zbgj.common.Response;
import com.honglinktech.zbgj.common.Result;
import com.honglinktech.zbgj.dao.OrderDao;
import com.honglinktech.zbgj.entity.Order;
import com.honglinktech.zbgj.enums.OrderStatusEnum;
import com.honglinktech.zbgj.service.WxPayService;
import com.honglinktech.zbgj.service.payment.wechat.PayUtil;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * userService
 */
@Service("wxPayService")
public class WxPayImpl implements WxPayService {

    /**
     *
     */
    private final Logger logger = LogManager.getLogger(getClass());
    /**
     *
     */
    @Autowired
    private OrderDao orderDao;

    /**
     * 支付成功后的服务器回调url
     */
    @Value("${wechat.notifyUrl}")
    private String notifyUrl;
    /**
     * 签名方式，固定值
     */
    private static final String SIGNTYPE = "MD5";
    /**
     * 交易类型，小程序支付的固定值为JSAPI
     */
    private static final String TRADETYPE = "JSAPI";
    /**
     * 微信统一下单接口地址
     */
    private static final String PAYURL = "https://api.mch.weixin.qq.com/pay/unifiedorder";


    @Override
    public Response createWxPay(int userId, int mallId, String orderCode, String openId, String requestIp) throws Exception {


        logger.error("createWxPay-》appId:[" + mallSetting.getAppId() + "]----" + "appKey:[" + mallSetting.getAppKey() + "]----"
                + "mchId:[" + mallSetting.getAppMchId() + "]----notifyUrl[" + notifyUrl + "]");

        if (notifyUrl.indexOf("192.168.1") > -1) { //测试不作处理
            return Result.success();
        }

        Order order = orderDao.findByOrderCode(userId, orderCode);

        if (order.getStatus() != OrderStatusEnum.waitPayment.getCode()) {
            return Result.fail("订单状态错误！");
        }

       // int orderMoney = 1;
        int orderMoney = order.getRealTotalMoney().multiply(new BigDecimal(100)).intValue();
        //生成的随机字符串
        String nonceStr = PayUtil.getRandomStringByLength(32);
        //商品名称
        String body = "订单ID"+order.getCode();
        //获取客户端的ip地址
        String spbillCreateIp = requestIp;
//        openId = "oZyYf0TPy7i_zttPJUSkgaRg2F20";

        //组装参数，用户生成统一下单接口的签名
        Map<String, String> packageParams = new HashMap<>();
        packageParams.put("appid", mallSetting.getAppId());
        packageParams.put("sub_appid", mallSetting.getSubAppId());
        packageParams.put("body", "" + body);
        packageParams.put("mch_id", mallSetting.getAppMchId());
        packageParams.put("sub_mch_id", mallSetting.getAppSubMchId());
        packageParams.put("nonce_str", nonceStr);
        packageParams.put("notify_url", notifyUrl); //支付成功后的回调地址
        packageParams.put("out_trade_no", orderCode); //商户订单号"123456789"
        packageParams.put("total_fee", orderMoney + ""); //支付金额，这边需要转成字符串类型，否则后面的签名会失败
        packageParams.put("spbill_create_ip", spbillCreateIp);
        packageParams.put("trade_type", TRADETYPE); //支付方式
//        packageParams.put("openid", openId);
        packageParams.put("sub_openid", openId);

        String prestr = PayUtil.createLinkString(packageParams); // 把数组所有元素，按照“参数=参数值”的模式用“&”字符拼接成字符串
//        logger.info("prestr++++++   " + prestr);
        //MD5运算生成签名，这里是第一次签名，用于调用统一下单接口
        String mysign = PayUtil.sign(prestr, mallSetting.getAppKey(), "utf-8").toUpperCase();

//        logger.info("sing++++++   " + mysign);
        //拼接统一下单接口使用的xml数据，要将上一步生成的签名一起拼接进去
        String xml = "<xml>"
                + "<appid>" + mallSetting.getAppId() + "</appid>"
                + "<sub_appid>" + mallSetting.getSubAppId() + "</sub_appid>"
                + "<body><![CDATA[" + body + "]]></body>"
                + "<mch_id>" + mallSetting.getAppMchId() + "</mch_id>"
                + "<sub_mch_id>" + mallSetting.getAppSubMchId() + "</sub_mch_id>"
                + "<nonce_str>" + nonceStr + "</nonce_str>"
                + "<notify_url>" + notifyUrl + "</notify_url>"
//                + "<openid>" + openId + "</openid>"
                + "<sub_openid>" + openId + "</sub_openid>"
                + "<out_trade_no>" + orderCode + "</out_trade_no>"
                + "<spbill_create_ip>" + spbillCreateIp + "</spbill_create_ip>"
                + "<total_fee>" + orderMoney + "</total_fee>"
                + "<trade_type>" + TRADETYPE + "</trade_type>"
                + "<sign>" + mysign + "</sign>"
                + "</xml>";

        System.out.println("调试模式_统一下单接口 请求XML数据：" + xml);

        //调用统一下单接口，并接受返回的结果
        String result = PayUtil.httpRequest(PAYURL, "POST", xml);

        System.out.println("调试模式_统一下单接口 返回XML数据：" + result);

        // 将解析结果存储在HashMap中
        Map map = PayUtil.doXMLParse(result);

        String returnCode = (String) map.get("return_code"); //返回状态码
        String resultCode = (String) map.get("result_code"); //返回状态码

        Map<String, Object> response = new HashMap<String, Object>(); //返回给小程序端需要的参数
        if ("SUCCESS".equals(returnCode) && "SUCCESS".equals(resultCode)) {
            String prepayId = (String) map.get("prepay_id"); //返回的预付单信息
            response.put("nonceStr", nonceStr);
            response.put("package", "prepay_id=" + prepayId);
            Long timeStamp = System.currentTimeMillis() / 1000;
            response.put("timeStamp", timeStamp + ""); //这边要将返回的时间戳转化成字符串，不然小程序端调用wx.requestPayment方法会报签名错误
            //拼接签名需要的参数
            String stringSignTemp = "appId=" + mallSetting.getSubAppId() + "&nonceStr=" + nonceStr + "&package=prepay_id=" + prepayId + "&signType=" + SIGNTYPE + "&timeStamp=" + timeStamp;
            //再次签名，这个签名用于小程序端调用wx.requesetPayment方法
            String paySign = PayUtil.sign(stringSignTemp, mallSetting.getAppKey(), "utf-8").toUpperCase();

            response.put("paySign", paySign);
            response.put("appid", mallSetting.getSubAppId());

            return Result.resultSet(response);
        } else {
            String retMsg = "FAIL".equals(resultCode) ? map.get("err_code_des").toString() : map.get("return_msg").toString();
            return Result.fail(retMsg);
        }
    }

    @Override
    public String wxNotify(String notityXml) throws Exception {

        Map map = PayUtil.doXMLParse(notityXml);

        String resXmlCode = "";
        String resXmlMsg = "";
        String returnCode = (String) map.get("return_code");
        if ("SUCCESS".equals(returnCode)) {
            String orderCode = (String) map.get("out_trade_no");
            Order order = orderDao.findByOrderCode(null, orderCode);
            if (order == null) {
                resXmlCode = "FAIL";
                resXmlMsg = "签名验证错误";
                logger.error("WX_PAY_EXCEPTION: 没有找到订单，orderID:" + orderCode );
            } else {
                //通过mallID，获取appkey
                MallSetting mallSetting = mallSettingDao.findByMallId(order.getMallId());
                //验证签名是否正确
                String sign = (String) map.get("sign");
                map.remove("sign");
                if (PayUtil.verify(PayUtil.createLinkString(map), sign, mallSetting.getAppKey(), "utf-8")) {
                    /**此处添加自己的业务逻辑代码start**/
                    order.setStatus(OrderStatusEnum.PendingShip.getCode());
                    order.setPayStatus(OrderPayStatusEnum.PaySuccess.getCode());
                    orderDao.update(order);

                    //门店确认收款
                    List<OrderRelation> orderRelationList =  orderRelationDao.findByOrderId(order.getId());
                    List<OrderDetail> orderDetailList = orderDetailDao.findOrderDetailByOrderId(order.getId());
                    if (orderRelationList != null && orderRelationList.size() > 0) {
                        for (OrderRelation orderRelation:orderRelationList) {
                            BigDecimal skuPrice = new BigDecimal(0);
                            //计算价格
                            if (!StringUtils.isEmpty(orderRelation.getSkuIdList())) {
                                List<Integer> skuIdList = JSON.parseObject(orderRelation.getSkuIdList(), new TypeReference<List<Integer>>() { }, Feature.IgnoreNotMatch);
                                if (orderDetailList != null && orderDetailList.size() > 0
                                        && skuIdList != null && skuIdList.size() > 0) {
                                    for (OrderDetail od : orderDetailList) {
                                        if (od.getSkuId() != null) {
                                            if (skuIdList.indexOf(od.getSkuId()) > -1) {
                                                skuPrice = skuPrice.add(od.getCurrentPrice());
                                            }
                                        }
                                    }
                                }
                            }
                            skuPrice = skuPrice.setScale(2, BigDecimal.ROUND_HALF_UP);
                            CompanyMall companyMall = companyMallDao.findByMallId(order.getMallId());
                            CrmMember crmMember = null;
                            if(companyMall != null){
                                crmMember = crmMemberDao.findByMallUserId(order.getMallId(), companyMall.getCompanyCode());
                            }
                            zbgjCompanyApiService.gatherOrder(orderRelation.getMallId(), orderRelation.getShopCode(), orderRelation.getDocNum(), skuPrice.toString(), crmMember!=null?crmMember.getCompanyMemberCode():null);
                        }
                    }

                    /**此处添加自己的业务逻辑代码end**/
                    resXmlCode = "SUCCESS";
                    resXmlMsg = "OK";
                } else {
                    /**此处添加自己的业务逻辑代码start**/
//                    order.setStatus(OrderStatusEnum.PendingShip.getCode());
                    order.setPayStatus(OrderPayStatusEnum.PayFail.getCode());
                    order.setDesc("签名验证错误");
                    orderDao.update(order);
                    resXmlCode = "FAIL";
                    resXmlMsg = "签名验证错误";
                    logger.error("WX_PAY_EXCEPTION: 签名验证错误，orderID:" + orderCode);
                }
            }
        } else {
            resXmlCode = "FAIL";
            resXmlMsg = "报文为空";
        }
        String resXml = "<xml>" + "<return_code><![CDATA[" + resXmlCode + "]]></return_code>"
                + "<return_msg><![CDATA[" + resXmlMsg + "]]></return_msg>" + "</xml> ";
        return resXml;
    }


    @Override
    public String wxNotifyTest(int orderId) throws Exception {

        //门店确认收款
        //门店确认收款
        Order order = orderDao.findByOrderCode(null, "201809251548106186");
        List<OrderRelation> orderRelationList =  orderRelationDao.findByOrderId(292);
        List<OrderDetail> orderDetailList = orderDetailDao.findOrderDetailByOrderId(292);
        if (orderRelationList != null && orderRelationList.size() > 0) {
            for (OrderRelation orderRelation:orderRelationList) {
                BigDecimal skuPrice = new BigDecimal(0);
                //计算价格
                if (!StringUtils.isEmpty(orderRelation.getSkuIdList())) {
                    List<Integer> skuIdList = JSON.parseObject(orderRelation.getSkuIdList(), new TypeReference<List<Integer>>() { }, Feature.IgnoreNotMatch);
                    if (orderDetailList != null && orderDetailList.size() > 0
                            && skuIdList != null && skuIdList.size() > 0) {
                        for (OrderDetail od : orderDetailList) {
                            if (od.getSkuId() != null) {
                                logger.info(JSON.toJSONString(skuIdList)+"===wxNotifyTest------------"+od.getSkuId());
                                if (skuIdList.indexOf(od.getSkuId()) > -1) {
                                    skuPrice = skuPrice.add(od.getCurrentPrice());
                                }
                            }
                        }
                        logger.info("===wxNotifyTest.skuPrice------------"+skuPrice);
                    }
                }
                logger.info("===wxNotifyTest.skuPrice------------"+skuPrice);
                skuPrice = skuPrice.setScale(2, BigDecimal.ROUND_HALF_UP);
                CompanyMall companyMall = companyMallDao.findByMallId(order.getMallId());
                CrmMember crmMember = null;
                if(companyMall != null){
                    crmMember = crmMemberDao.findByMallUserId(order.getMallId(), companyMall.getCompanyCode());
                }
                logger.info("wxNotifyTest.skuPrice------------mallId:"+orderRelation.getMallId()
                        +"\nShopCode:"+orderRelation.getShopCode()
                        +"\nDocNum:"+orderRelation.getDocNum()
                        +"\nskuPrice:"+skuPrice.toString()
                        +"\ncrmMember:"+(crmMember!=null?crmMember.getCompanyMemberCode():null));
                zbgjCompanyApiService.gatherOrder(orderRelation.getMallId(), orderRelation.getShopCode(), orderRelation.getDocNum(), skuPrice.toString(), crmMember!=null?crmMember.getCompanyMemberCode():null);
            }
        }

        return null;
    }
    /*<xml>
    <appid><![CDATA[wxd673003a72114833]]></appid>
    <bank_type><![CDATA[CFT]]></bank_type>
    <cash_fee><![CDATA[1]]></cash_fee>
    <fee_type><![CDATA[CNY]]></fee_type>
    <is_subscribe><![CDATA[Y]]></is_subscribe>
    <mch_id><![CDATA[1491531562]]></mch_id>
    <nonce_str><![CDATA[m2i6lkknlu9bvlook9w7jvhlfa5g22qy]]></nonce_str>
    <openid><![CDATA[ou-xut1_i09Dd4eNoXRz5WuuNSrg]]></openid>
    <out_trade_no><![CDATA[201801081641105270]]></out_trade_no>
    <result_code><![CDATA[SUCCESS]]></result_code>
    <return_code><![CDATA[SUCCESS]]></return_code>
    <sign><![CDATA[EBD5F2B1BD25E35D0A18B63FB0048EB0]]></sign>
    <sub_appid><![CDATA[wxce789d61b8c2c9c9]]></sub_appid>
    <sub_is_subscribe><![CDATA[N]]></sub_is_subscribe>
    <sub_mch_id><![CDATA[1495763992]]></sub_mch_id>
    <sub_openid><![CDATA[oZyYf0TPy7i_zttPJUSkgaRg2F20]]></sub_openid>
    <time_end><![CDATA[20180108172742]]></time_end>
    <total_fee>1</total_fee>
    <trade_type><![CDATA[JSAPI]]></trade_type>
    <transaction_id><![CDATA[4200000059201801080498295490]]></transaction_id>
    </xml>*/
}
