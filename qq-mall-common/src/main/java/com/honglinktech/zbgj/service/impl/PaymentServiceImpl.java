package com.honglinktech.zbgj.service.impl;//package com.honglinktech.zbgj.service.impl;
//
//import com.honglinktech.zbgj.bean.PaymentBean;
//import com.honglinktech.zbgj.common.Constants;
//import com.honglinktech.zbgj.common.ErrorCode;
//import com.honglinktech.zbgj.common.ParameterConstant;
//import com.honglinktech.zbgj.common.Response;
//import com.honglinktech.zbgj.common.Result;
//import com.honglinktech.zbgj.common.SystemArgsCache;
//import com.honglinktech.zbgj.dao.OrderDao;
//import com.honglinktech.zbgj.dao.PaymentDao;
//import com.honglinktech.zbgj.entity.Order;
//import com.honglinktech.zbgj.entity.Payment;
//import com.honglinktech.zbgj.entity.UserWjsBalance;
//import com.honglinktech.zbgj.enums.OrderStatusEnum;
//import com.honglinktech.zbgj.message.entity.MessageAuthCode;
//import com.honglinktech.zbgj.message.enums.ShortMessageTemplateEnums;
//import com.honglinktech.zbgj.message.service.MessageService;
//import com.honglinktech.zbgj.message.service.WxQyService;
//import com.honglinktech.zbgj.service.CommonService;
//import com.honglinktech.zbgj.service.PaymentService;
//import com.honglinktech.zbgj.service.payment.alipay.AlipayNotify;
//import com.honglinktech.zbgj.service.payment.alipay.SignUtils;
//import com.honglinktech.zbgj.service.payment.ebankpay.EBankPayOrderOrig;
//import com.honglinktech.zbgj.service.payment.ebankpay.EBankUtils;
//import com.honglinktech.zbgj.service.payment.unionpay.UnionPayUtil;
//import com.honglinktech.zbgj.service.payment.wechat.WeiXinPayUtil;
//import com.honglinktech.zbgj.utils.VerifyUtil;
//import com.honglinktech.zbgjuser.entity.UserData;
//import com.honglinktech.zbgjuser.service.UserService;
//import org.apache.commons.httpclient.HttpStatus;
//import org.apache.http.HttpResponse;
//import org.apache.http.NameValuePair;
//import org.apache.http.client.methods.HttpPost;
//import org.apache.http.entity.StringEntity;
//import org.apache.http.impl.client.CloseableHttpClient;
//import org.apache.http.impl.client.HttpClients;
//import org.apache.http.message.BasicNameValuePair;
//import org.apache.http.util.EntityUtils;
//import org.apache.logging.log4j.LogManager;
//import org.apache.logging.log4j.Logger;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.beans.factory.annotation.Value;
//import org.springframework.dao.DataAccessException;
//import org.springframework.stereotype.Service;
//
//import javax.servlet.http.HttpServletRequest;
//import java.io.BufferedReader;
//import java.io.IOException;
//import java.io.InputStream;
//import java.io.InputStreamReader;
//import java.io.UnsupportedEncodingException;
//import java.math.BigDecimal;
//import java.net.URLEncoder;
//import java.nio.charset.Charset;
//import java.security.SecureRandom;
//import java.text.SimpleDateFormat;
//import java.util.Calendar;
//import java.util.Date;
//import java.util.Enumeration;
//import java.util.HashMap;
//import java.util.Iterator;
//import java.util.LinkedHashMap;
//import java.util.LinkedList;
//import java.util.List;
//import java.util.Map;
//
///**
// * Created by Dayong on 16/2/24.
// */
//@Service
//public class PaymentServiceImpl implements PaymentService {
//    private final Logger logger = LogManager.getLogger(getClass());
//
//    // ========================支付宝=======================//
//    // 商户PID
//    @Value("#{payment['alipay.partner.id']}")
//    private String alipayPartnerId;
//    // 商户收款账号
//    @Value("#{payment['alipay.seller.email']}")
//    private String alipaySellerEmail;
//    // 商户私钥，pkcs8格式
//    @Value("#{payment['alipay.rsa.private']}")
//    private String alipayRsaPrivate;
//    // 后台通知地址
//    @Value("#{payment['alipay.notify.url']}")
//    private String alipayNotifyUrl;
//    // ========================支付宝=======================//
//
//    // ========================微信=======================//
//    @Value("#{payment['wechat.app.id']}")
//    private String wechatAppId;
//    @Value("#{payment['wechat.mch.id']}")
//    private String wechatMchId;
//    @Value("#{payment['wechat.api.key']}")
//    private String wechatApiKey;
//    @Value("#{payment['wechat.notify.url']}")
//    private String wechatNotifyUrl;
//    @Value("#{payment['wechat.notify.url']}")
//    private String wechatOrderApi;// 微信统一下单地址
//    private String wechatTradeType = "APP";
//    // ========================微信=======================//
//
//    // ========================银联=======================//
//    @Value("#{payment['unionpay.mer.id']}")
//    private String unionpayMerId;
//    @Value("#{payment['unionpay.notify.url']}")
//    private String unionpayNotifyUrl;
//    // ========================银联=======================//
//
//    // ========================橙e付=======================//
//    @Value("#{payment['ebankpay.notify.url']}")
//    private String ebankpayNotifyUrl;
//    @Value("#{payment['ebankpay.master.id']}")
//    private String ebankpayMasterId;
//    @Value("#{payment['ebankpay.rsa.bankpubkey']}")
//    private String ebankpayRsaBankPubkey;
//    @Value("#{payment['ebankpay.rsa.prikey']}")
//    private String ebankpayRsaPrikey;
//    // ========================橙e付=======================//
//
//    private SimpleDateFormat txnSdf = new SimpleDateFormat("yyyyMMddHHmmss");
//
//    @Autowired
//    private OrderDao orderDao;
//    @Autowired
//    private PaymentDao paymentDao;
//
//    @Autowired
//    private UserService userService;
//    @Autowired
//    private CommonService commonService;
//    @Autowired
//    private MessageService messageService;
//    @Autowired
//    private WxQyService wxQyService;
//
//    @Override
//    public Response<PaymentBean> reviewPayment(String orderId) {
//        try {
//            if (orderId != null && !orderId.isEmpty()) {
//                Order order = orderDao.findByOrderId(orderId);
//                if (order != null) {
//                    Payment payment = paymentDao.findByOrderId(orderId);
//                    PaymentBean bean;
//                    if (payment != null) {
//                        bean = new PaymentBean(payment);
//                    } else {
//                        // 支付信息是会在管理员审核之后生成,如果支付信息为空则表明系统管理员还没审核订单
//                        bean = new PaymentBean();
//                    }
//                    UserData user = userService.findBasicUserDataById(order.getUserId());
//                    BigDecimal available = new BigDecimal("0.00");
//                    List<UserWjsBalance> userAllWjsBalance =
//                            commonService.getUserAllWjsBalance(user.getUcode());
//                    for (UserWjsBalance uwb : userAllWjsBalance) {
//                        available = available.add(new BigDecimal(uwb.getBalance()));
//                    }
//                    String paymentTips = SystemArgsCache.get(ParameterConstant.PAYMENT_REVIEW_TIPS);
//                    bean.setAvailable(available.toString());
//                    bean.setPaymentTips(paymentTips);
//                    return Result.resultSet(bean);
//                }
//            }
//            return Result.fail(ErrorCode.DATABASE_ERROR + "", "找不到该订单!");
//        } catch (DataAccessException e) {
//            logger.error(e.getMessage(), e);
//            return Result.fail(ErrorCode.SYSTEM_ERROR + "", "预览支付信息失败!");
//        }
//    }
//
//    @Override
//    public Response<String> sendMessage(String userCode) {
//        try {
//            UserData user = userService.findBasicUserDataByCode(userCode);
//            String smsCode = VerifyUtil.genRandomCode(6);
//            if (smsCode == null || smsCode.isEmpty()) {
//                return Result.fail(ErrorCode.DATABASE_ERROR, "生成验证码失败");
//            }
//
//            Map<String, Object> smsParams = new LinkedHashMap<String, Object>();
//            smsParams.put("RandNum", smsCode);
//            String phone = user.getPhone();
//            Response<Map<String, Object>> response = messageService
//                    .sendMessages(phone, "珠宝管家", ShortMessageTemplateEnums.PlatFormTransfer, smsParams);
//            if (response.getCode() != 0) {
//                return Result
//                    .fail(ErrorCode.DATABASE_ERROR, "发送短信失败");
//            }
//
//            MessageAuthCode messageAuthCode = new MessageAuthCode();
//            messageAuthCode.setMsgType(ShortMessageTemplateEnums.PayOfflineInform.getMsgType());
//            messageAuthCode.setPhoneNum(phone);
//            messageAuthCode.setRandom(smsCode);
//            Response<String> response1 =  messageService.recordVerifyCode(messageAuthCode);
//            if (response1.getCode() != 0) {
//                return Result
//                    .fail(ErrorCode.DATABASE_ERROR, "保存短信失败");
//            }
//            return Result.success();
//        } catch (Exception e) {
//            return Result.fail(ErrorCode.DATABASE_ERROR, "发送短信失败");
//        }
//    }
//
//    @Override
//    public Response<? extends Object> requestPayment(String id, int type, String code, String payPsw,
//                                                                                      String ip) {
//        if (id == null || id.isEmpty()) {
//            return Result.fail("订单编号不能为空!");
//        }
//        if (type < 1 || type > 6) {
//            return Result.fail("支付类型不能为空!");
//        }
//        try {
//            Order order = orderDao.findByOrderId(id);
//            if (order != null) {
//                Payment pay = paymentDao.findByOrderId(id);
//                pay.setMoneyPayType(type);
//                //String result;
//                Object result;
//                // 拼接字符串给前端调用支付平台
//                switch (type) {
//                    case Constants.PAY_TYPE_ALIPAY:
//                        // 请求支付宝支付（支付宝的单位为元）
//                        result = createAlipayPerpay(order, pay);
//                        break;
//                    case Constants.PAY_TYPE_WECHAT:
//                        // 请求微信支付(微信支付的单位为分)
//                        result = createWechatPerpay(order, pay, ip);
//                        break;
//                    case Constants.PAY_TYPE_UNIONPAY:
//                        // 请求银联支付(银联支付的单位为分)
//                        result = createUnionPerpay(order, pay);
//                        break;
//                    case Constants.PAY_TYPE_ORANGE:
//                        // TODO 使用橙E付支付(橙E付支付的单位暂时未知)
//                        result = createOrangePay(order, pay);
//                        break;
//                    case Constants.PAY_TYPE_OFFLINE:
//                        // 线下支付
//                        Response<String> offLinePay = createOffLinePay(order, code, payPsw);
//                        if (offLinePay.getCode() != 0) {
//                            return offLinePay;
//                        }
//                        result = "";
//                        break;
//                    default:
//                        return Result.fail("无法识别支付类型!");
//                }
//                if (null != result) {
//                    paymentDao.update(pay);
//                    order.setPayType(type);
//                    //order.setOrderStatus(OrderStatusEnum.Payment.getCode());
//                    orderDao.update(order);
//
//                    // 发送微信企业号提醒
//                    wxQyService.userTryPayNotify(order.getId(), order.getPayTypeName(), order.getUserName(), order.getTelephone());
//
//                    return Result.resultSet(result);
//                }
//            } else {
//                return Result.fail("找不到该订单!");
//            }
//        } catch (Exception e) {
//            logger.error(e.getMessage(), e);
//        }
//        return Result.fail("发起支付请求失败!");
//    }
//
//    /**
//     * 创建支付宝的支付请求
//     *
//     * @param order 订单
//     * @param pay
//     * @return
//     */
//    private String createAlipayPerpay(Order order, Payment pay) {
//        StringBuffer sb = new StringBuffer();
//        // 签约合作者身份ID
//        sb.append("partner=").append("\"").append(alipayPartnerId).append("\"");
//        // 签约卖家支付宝账号
//        sb.append("&seller_id=").append("\"").append(alipaySellerEmail).append("\"");
//        // 商户网站唯一订单号
//        sb.append("&out_trade_no=").append("\"").append(order.getId()).append("\"");
//        // 商品名称
//        sb.append("&subject=").append("\"").append(order.getSubject()).append("\"");
//        // 商品详情
//        sb.append("&body=").append("\"").append(order.getBody()).append("\"");
//        // 商品金额
//        sb.append("&total_fee=").append("\"").append(pay.getTotalFee().toString()).append("\"");
//        // 服务器异步通知页面路径
//        sb.append("&notify_url=").append("\"").append(alipayNotifyUrl).append("\"");
//        // 服务接口名称， 固定值
//        sb.append("&service=\"mobile.securitypay.pay\"");
//        // 支付类型， 固定值
//        sb.append("&payment_type=\"1\"");
//        // 参数编码， 固定值
//        sb.append("&_input_charset=\"utf-8\"");
//        // 设置未付款交易的超时时间
//        // 默认30分钟，一旦超时，该笔交易就会自动被关闭。
//        // 取值范围：1m～15d。
//        // m-分钟，h-小时，d-天，1c-当天（无论交易何时创建，都在0点关闭）。
//        // 该参数数值不接受小数点，如1.5h，可转换为90m。
//        sb.append("&it_b_pay=\"30m\"");
//        // extern_token为经过快登授权获取到的alipay_open_id,带上此参数用户将使用授权的账户进行支付
//        // sb.append("&extern_token=").append("\"").append(extern_token).append("\"";
//        // 支付宝处理完请求后，当前页面跳转到商户指定页面的路径，可空
//        sb.append("&return_url=\"m.alipay.com\"");
//        // 调用银行卡支付，需配置此参数，参与签名， 固定值 （需要签约《无线银行卡快捷支付》才能使用）
//        // sb.append("&paymethod=\"expressGateway\"";
//        // 对订单做RSA 签名
//        String sign = SignUtils.sign(sb.toString(), alipayRsaPrivate);
//        try {
//            // 仅需对sign 做URL编码
//            sign = URLEncoder.encode(sign, "UTF-8");
//        } catch (UnsupportedEncodingException e) {
//            logger.error(e.getMessage(), e);
//        }
//        // 完整的符合支付宝参数规范的订单信息
//        sb.append("&sign=\"").append(sign).append("\"&").append("sign_type=\"RSA\"");
//        return sb.toString();
//    }
//
//    /**
//     * 创建微信的支付请求
//     *
//     * @param order 订单对象
//     * @param pay
//     *@param ip    用户IP  @return
//     */
//    private String createWechatPerpay(Order order, Payment pay, String ip) {
//        List<NameValuePair> packageParams = new LinkedList<NameValuePair>();
//        // 生成预支付交易单，返回正确的预支付交易回话标识后再按扫码、JSAPI、APP等不同场景生成交易串调起支付。
//        // 公众账号ID
//        packageParams.add(new BasicNameValuePair("appid", wechatAppId));
//        // 商品描述
//        packageParams.add(new BasicNameValuePair("body", order.getSubject()));// GB2312
//        // 商户号
//        packageParams.add(new BasicNameValuePair("mch_id", wechatMchId));
//        // 随机字符串
//        packageParams.add(new BasicNameValuePair("nonce_str", WeiXinPayUtil.genNonceStr()));
//        // 回调通知地址
//        packageParams.add(new BasicNameValuePair("notify_url", wechatNotifyUrl));
//        // 商户订单号
//        packageParams.add(new BasicNameValuePair("out_trade_no", String.valueOf(order.getId())));
//        // 终端IP（用户IP）
//        packageParams.add(new BasicNameValuePair("spbill_create_ip", ip));
//        // 总金额(分)
//        packageParams.add(new BasicNameValuePair("total_fee", pay.getTotalFee().multiply(new BigDecimal(100)).toBigInteger().toString()));
//        // 交易类型
//        packageParams.add(new BasicNameValuePair("trade_type", wechatTradeType));
//
//        try {
//            // 签名
//            packageParams.add(new BasicNameValuePair("sign",
//                    WeiXinPayUtil.createSign(packageParams, wechatApiKey)));
//
//            String data = WeiXinPayUtil.encodeXml(packageParams);
//            HttpPost httpPost = new HttpPost(wechatOrderApi);
//            httpPost.setEntity(new StringEntity(data, "UTF-8"));
//            httpPost.setHeader("Accept", "application/json");
//            httpPost.setHeader("Content-type", "application/json");
//
//            CloseableHttpClient httpClient = HttpClients.createDefault();
//            HttpResponse resp;
//            resp = httpClient.execute(httpPost);
//            if (resp.getStatusLine().getStatusCode() != HttpStatus.SC_OK) {
//                return null;
//            } else {
//                byte[] data2 = EntityUtils.toByteArray(resp.getEntity());
//                List<NameValuePair> xml = WeiXinPayUtil.decodeXml(new String(data2));
//                String return_code = WeiXinPayUtil.getValue(xml, "return_code");
//                if (return_code.equalsIgnoreCase("SUCCESS")) {
//                    StringBuffer sb = new StringBuffer();
//                    sb.append(wechatMchId).append(";")
//                            .append(WeiXinPayUtil.getValue(xml, "prepay_id")).append(";")
//                            .append(wechatApiKey);
//                    return sb.toString();
//                } else {
//                    System.out.println("error:" + WeiXinPayUtil.getValue(xml, "return_msg"));
//                    return null;
//                }
//            }
//        } catch (IOException e) {
//            logger.error(e.getMessage(), e);
//        }
//        return null;
//    }
//
//    /**
//     * 银联支付推送给银联
//     *
//     * @param order 订单对象
//     * @param pay
//     * @return
//     */
//    private String createUnionPerpay(Order order, Payment pay) {
//        /**
//         * 组装请求报文
//         */
//        Map<String, String> data = new HashMap<String, String>();
//        // 版本号
//        data.put("version", "5.0.0");
//        // 字符集编码 默认"UTF-8"
//        data.put("encoding", "UTF-8");
//        // 签名方法 01 RSA
//        data.put("signMethod", "01");
//        // 交易类型 01-消费
//        data.put("txnType", "01");
//        // 交易子类型 01:自助消费 02:订购 03:分期付款
//        data.put("txnSubType", "01");
//        // 业务类型
//        data.put("bizType", "000201");
//        // 渠道类型，07-PC，08-手机
//        data.put("channelType", "08");
//        // 前台通知地址 ，控件接入方式无作用
//        // data.put("frontUrl", "http://dayong168.eicp.net/unionpayFront");
//        // 后台通知地址
//        data.put("backUrl", unionpayNotifyUrl);
//        // data.put("backUrl", "http://dayong168.eicp.net/unionpayBack");
//        // 接入类型，商户接入填0 0- 商户 ， 1： 收单， 2：平台商户
//        data.put("accessType", "0");
//        // 商户号码，请改成自己的商户号
//        data.put("merId", unionpayMerId);
//        // 商户订单号，8-40位数字字母
//        data.put("orderId", String.valueOf(order.getId()));
//        // 订单发送时间，取系统时间
//        data.put("txnTime", txnSdf.format(new Date()));
//        // 交易金额，单位分
//        String totalFee = pay.getPayFee().multiply(new BigDecimal(100)).toBigInteger().toString();
//        data.put("txnAmt", totalFee);
//        // 交易币种
//        data.put("currencyCode", "156");
//        // 请求方保留域，透传字段，查询、通知、对账文件中均会原样出现
//        // data.put("reqReserved", "透传信息");
//        // 订单描述，可不上送，上送时控件中会显示该信息
//        // data.put("orderDesc", "订单描述");
//
//        data = UnionPayUtil.signData(data);
//
//        // 交易请求url 从配置文件读取
//        /*String requestAppUrl = SDKConfig.getConfig().getAppRequestUrl();
//        System.out.println(requestAppUrl);
//        Map<String, String> resmap = UnionPayUtil.submitUrl(data, requestAppUrl);
//        System.out.println("请求报文=[" + data.toString() + "]");
//        System.out.println("应答报文=[" + resmap.toString() + "]");
//        // [{txnType=01, respCode=00, tn=201508191148371523528, merId=777290058116774, txnSubType=01, version=5.0.0, signMethod=01,
//        // certId=3474813271258769001041842579301293446, encoding=UTF-8, bizType=000201, respMsg=成功[0000000],
//        // signature=DscyXabTu7+D2fPpT1z5axvy7ts6cdFxUyNiA3VL+uAgayVctxCGx3mjvBE0vKDl4aEp42gNfBo+TDPS4+qA9PV6HtPOgDUkXLHNZLiHIcfqXYMJ7HsXBe7Hk8z9Xo4KevNmYeL6qWpXR1W/4sDWyErjy9Oj4L96Wuun4EncZdnpA+5c70fnFCvR2eBIvCbp5zpuLu8+1yediSOzF86aLHt/Yfyb4cVvkkxN75m6rjV7mjLt/AetvZS0SHTWCaP5mz0ZsS32MRtc2Euw3rBuNgyhtj8T5ysRSeuJDLtiIY/cht73aE4xTOA6bGZMOGNPhIim6LOhF6/DXb0803qGCg==,
//        // orderId=2015081911483711400, accessType=0, txnTime=20150819114837}]
//        String code = resmap.get("respCode");
//        System.out.println("【应答码：】" + code);
//        String tn = resmap.get("tn");
//        if (null != tn) {
//            return tn;
//        }*/
//        return null;
//    }
//
//    /**
//     * 创建橙E付支付
//     *
//     * @param order 订单对象
//     * @return
//     */
//    private Object createOrangePay(Order order, Payment payment) {
//        // TODO 处理橙E付支付
//
//        EBankPayOrderOrig orig = new EBankPayOrderOrig();
//
//        // 生成相关参数
//        Calendar calendar = Calendar.getInstance();
//        Date date = calendar.getTime();
//        SimpleDateFormat formatter = new SimpleDateFormat("yyyyMMddHHmmss");
//        String timestamp = formatter.format(date);  //时间
//        String datetamp = timestamp.substring(0, 8);  //日期
//        // 生成8位流水号
//        int ran = new SecureRandom().nextInt(99999999);
//        String no = String.format("%08d", ran);
//        //String timestamp = new SimpleDateFormat("yyyyMMdd").format(new Date());
//        //String payDate = new SimpleDateFormat("yyyyMMddHHmmss").format(new Date());
//        //String orderId = ebankpayMasterId + timestamp + no;
//        String orderId = ebankpayMasterId + datetamp + no;
//        String price = String.format("%.2f", payment.getTotalFee().toString());
//
//        // 生成橙e付 orderId
//        orig.setOrderId(orderId);
//        orig.setPayDate(timestamp);
//        orig.setMasterId(ebankpayMasterId);
//        orig.setDocNum("" + order.getId());
//        orig.setAmount(price);
//
//        // 生成原始数据
//        String strOrig = orig.genStr();
//        String sign = EBankUtils.sign(strOrig, ebankpayRsaPrikey);
//
//        // 编码处理
//        String encodeStrOrig = EBankUtils.base64AndUrlEncode(strOrig);
//        String encodeSign = EBankUtils.base64AndUrlEncode(sign);
//
//        if (strOrig == null || sign == null || encodeStrOrig == null || encodeSign == null) {
//            return null;
//        }
//
//        Map<String, Object> orderData = new LinkedHashMap<String, Object>();
//        orderData.put("orig", encodeStrOrig);
//        orderData.put("sign", encodeSign);
//        orderData.put("NOTIFYURL", ebankpayNotifyUrl);
//        orderData.put("MasterId", ebankpayMasterId);
//
//        logger.debug(orderData.toString());
//
//        return orderData;
//
//        /*
//        // 设置参数
//        Calendar calendar = Calendar.getInstance();
//        Date date = calendar.getTime();
//        SimpleDateFormat formatter = new SimpleDateFormat( "yyyyMMddHHmmss" );
//        String timestamp = formatter.format( date );  //时间
//        String datetamp = timestamp.substring(0, 8);  //日期
//        String no = String.format("%08d", order.getId());
//        String orderId = ebankpayMasterId + datetamp + no;
//        String price = String.format("%.2f", order.getTotalFee());
//
//
//        try {
//            PayclientInterfaceUtil payclientInterfaceUtil = new PayclientInterfaceUtil();
//            KeyedCollection signDataput = new KeyedCollection("signDataput");
//            KeyedCollection inputOrig = new KeyedCollection("inputOrig");
//
//            inputOrig.put("masterId", ebankpayMasterId);
//            inputOrig.put("orderId", orderId);
//            inputOrig.put("amount", price);
//            inputOrig.put("paydate", timestamp);
//            inputOrig.put("orderId", orderId);
//            inputOrig.put("currency","RMB");
//            inputOrig.put("validtime","15000000");
//            inputOrig.put("objectName",""+order.getId());
//            inputOrig.put("remark","honglinktech");
//
//            // 签名
//            signDataput = payclientInterfaceUtil.getSignData(inputOrig);
//
//
//
//        } catch (CsiiException e) {
//            e.printStackTrace();
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//        */
//
//    }
//
//    /**
//     * 创建线下支付
//     *
//     * @param order  订单对象
//     * @param code   短信验证码
//     * @param payPsw 支付密码
//     * @return
//     */
//    private Response<String> createOffLinePay(Order order, String code, String payPsw) {
//        if (code == null || code.isEmpty()) {
//            return Result.fail("短信验证码不能为空!");
//        }
//        if (payPsw == null || payPsw.isEmpty()) {
//            return Result.fail("支付密码不能为空!");
//        }
//        try {
//            UserData user = userService.findBasicUserDataById(order.getUserId());
//            if (user != null) {
//                if (code.equals("AbCdEf123456789")) {//验证码为这个的时候表明是用指纹进行支付
//                    //指纹支付的时候payPsw为前端传过来的设备ID
//                    // 处理指纹支付
//                    Integer result = userService.checkUserFingerPayByDeviceId(user.getUid(), payPsw);
//                    if (result == null || result != 0) {
//                        return Result
//                            .fail(ErrorCode.PARAMETER_TYPE_ERROR, "指纹不正确!");
//                    }
//                } else {// 处理短信和支付密码支付
//                    Response<String> smsResponse = messageService.verifyMessages(user.getPhone(), code,
//                                    ShortMessageTemplateEnums.PayOfflineInform, true);
//                    if (smsResponse.getCode() != 0) {
//                        return Result
//                            .fail(ErrorCode.PARAMETER_TYPE_ERROR, "短信验证码错误");
//                    }
//                }
//                return Result.success();
//            } else {
//                return Result
//                    .fail(ErrorCode.PARAMETER_TYPE_ERROR, "找不到该用户");
//            }
//        } catch (Exception e) {
//            logger.error(e.getMessage(), e);
//            return Result.fail(ErrorCode.SYSTEM_ERROR, "创建线下支付失败!");
//        }
//    }
//
//    @Override
//    public boolean handleAlipayNotify(HttpServletRequest request)
//            throws UnsupportedEncodingException {
//        // 获取支付宝POST过来反馈信息
//        Map<String, String> params = new HashMap<String, String>();
//        Map<String, String[]> requestParams = request.getParameterMap();
//        for (Iterator<String> iterator = requestParams.keySet().iterator(); iterator.hasNext(); ) {
//            String name = iterator.next();
//            String[] values = requestParams.get(name);
//            String valueStr = "";
//            int length = values.length;
//            for (int i = 0; i < length; i++) {
//                valueStr = (i == length - 1) ? valueStr + values[i] : valueStr + values[i] + ",";
//            }
//            // 乱码解决，这段代码在出现乱码时使用。如果mysign和sign不相等也可以使用这段代码转化
//            // valueStr = new String(valueStr.getBytes("ISO-8859-1"), "gbk");
//            params.put(name, valueStr);
//        }
//        logger.info(params.toString());
//        if (AlipayNotify.verify(params)) {// 验证成功
//            logger.info("支付宝通知验证成功");
//            Map<String, String> param = getAlipayParam(request);
//            boolean isSuccess = false;
//            // 即时到账普通版，那么这时的交易状态值为： TRADE_FINISHED
//            if (param.get("trade_status").equals("TRADE_FINISHED")) {
//                isSuccess = true;
//                // 判断该笔订单是否在商户网站中已经做过处理
//                // 如果没有做过处理，根据订单号（out_trade_no）在商户网站的订单系统中查到该笔订单的详细，并执行商户的业务程序
//                // 如果有做过处理，不执行商户的业务程序
//
//                // 注意：
//                // 退款日期超过可退款期限后（如三个月可退款），支付宝系统发送该交易状态通知
//                isSuccess = updateOrderStatus(param.get("out_trade_no"),
//                        Constants.PAY_TYPE_ALIPAY, param.get("buyer_email"), param.get("trade_no"),
//                        isSuccess);
//                if (!isSuccess) {
//                    // TODO 记录错误信息
//                }
//            }/*
//             * else if (param.get("trade_status").equals("TRADE_SUCCESS")) {// 即时到账高级版，此时的交易状态值就为：TRADE_SUCCESS。 isSuccess = true; // 判断该笔订单是否在商户网站中已经做过处理 //
//			 * 如果没有做过处理，根据订单号（out_trade_no）在商户网站的订单系统中查到该笔订单的详细，并执行商户的业务程序 // 如果有做过处理，不执行商户的业务程序
//			 *
//			 * // 注意： // 付款完成后，支付宝系统发送该交易状态通知 updateOrderStatus(param.get("out_trade_no"), Constants.PAY_TYPE_ALIPAY, param.get("buyer_email"), param.get("trade_no"), isSuccess); //
//			 */
//            return isSuccess;
//        } else {// 验证失败
//            logger.info("支付宝通知验证失败");
//            return false;
//        }
//    }
//
//    @Override
//    public boolean handleWeiXinNotify(HttpServletRequest request)
//            throws UnsupportedEncodingException {
//        try {
//            InputStream is = request.getInputStream();
//            InputStreamReader ir = new InputStreamReader(is, Charset.defaultCharset());
//            BufferedReader br = new BufferedReader(ir);
//            StringBuilder sb = new StringBuilder();
//            String str;
//            while ((str = br.readLine()) != null) {
//                sb.append(str);
//            }
//            List<NameValuePair> params = WeiXinPayUtil.decodeXml(sb.toString());
//            logger.info(params.toString());
//            String orderId = "";
//            String tradeNo = null;
//            String openId = null;
//            boolean isSuccess = false;
//            for (NameValuePair pair : params) {
//                if (pair.getName().equals("out_trade_no")) {
//                    orderId = pair.getValue();
//                }
//                if (pair.getName().equals("transaction_id")) {
//                    tradeNo = pair.getValue();
//                }
//                if (pair.getName().equals("openid")) {
//                    openId = pair.getValue();
//                }
//                if (pair.getName().equals("result_code")) {
//                    if (pair.getValue().equals("SUCCESS")) {
//                        isSuccess = true;
//                    }
//                }
//            }
//            updateOrderStatus(orderId, Constants.PAY_TYPE_WECHAT, openId, tradeNo, isSuccess);
//            br.close();
//            ir.close();
//            is.close();
//        } catch (IOException e) {
//            logger.error(e.getMessage(), e);
//        }
//        return true;
//    }
//
//    @Override
//    public boolean handleUnionpayNotify(HttpServletRequest request) {
//       /*
//       try {
//            LogUtil.writeLog("BackRcvResponse接收后台通知开始");
//            request.setCharacterEncoding("ISO-8859-1");
//            String encoding = request.getParameter(SDKConstants.param_encoding);
//            // 获取请求参数中所有的信息
//            Map<String, String> reqParam = getUnionpayParam(request);
//            // 打印请求报文
//            LogUtil.printRequestLog(reqParam);
//
//            Map<String, String> valideData = null;
//            if (null != reqParam && !reqParam.isEmpty()) {
//                Iterator<Map.Entry<String, String>> it = reqParam.entrySet().iterator();
//                valideData = new HashMap<String, String>(reqParam.size());
//                while (it.hasNext()) {
//                    Map.Entry<String, String> e = it.next();
//                    String key = e.getKey();
//                    String e.getValue();
//                    value = new String(value.getBytes("ISO-8859-1"), encoding);
//                    valideData.put(key, value);
//                }
//            }
//            logger.info(valideData.toString());
//            // 验证签名
//            if (SDKUtil.validate(valideData, encoding)) {
//                String resqCode = valideData.get("respCode");
//                boolean isSuccess = false;
//                if ("00".equals(resqCode)) {
//                    isSuccess = true;
//                }
//                updateOrderStatus(valideData.get("orderId"), Constants.PAY_TYPE_UNIONPAY, valideData.get("buyer_email"), valideData.get("trade_no"), isSuccess);
//                LogUtil.writeLog("验证签名结果[成功].");
//            } else {
//                LogUtil.writeLog("验证签名结果[失败].");
//            }
//            LogUtil.writeLog("BackRcvResponse接收后台通知结束");
//        } catch (UnsupportedEncodingException e) {
//            logger.error(e.getMessage(), e);
//        }*/
//        return false;
//    }
//
//    @Override
//    public boolean handleOrangeNotify(HttpServletRequest request) {
//        //TODO 在这里编写橙e付的通知代码
//
//        try {
//            // 记录收到的结果
//            Map<String, Object> ebankpayNotifyRequset = new LinkedHashMap<String, Object>();
//
//            // 记录请求参数
//            Map<String, String> typesafeRequestMap = new HashMap<String, String>();
//            Enumeration<?> requestParamNames = request.getParameterNames();
//            while (requestParamNames.hasMoreElements()) {
//                String requestParamName = (String) requestParamNames.nextElement();
//                String requestParamValue = request.getParameter(requestParamName);
//                typesafeRequestMap.put(requestParamName, requestParamValue);
//            }
//            ebankpayNotifyRequset.put("PARAMETERS", typesafeRequestMap);
//
//            // 打印到log
//            logger.info("ebankpay notify: " + ebankpayNotifyRequset.toString());
//
//            if (!typesafeRequestMap.containsKey("orig") || !typesafeRequestMap
//                    .containsKey("sign")) {
//                return false;
//            }
//
//            String orig = typesafeRequestMap.get("orig");
//            String sign = typesafeRequestMap.get("sign");
//
//            boolean checkSign = EBankUtils.verify(orig, sign, ebankpayRsaBankPubkey);
//            if (!checkSign) {
//                logger.error("ebankpay verify sign fail! orig=" + orig);
//                return false;
//            }
//
//            Map<String, Object> result = EBankUtils.parseOrig(EBankUtils.base64Decode(orig));
//            if (result == null) {
//                logger.error("EBankUtils.parseOrig return null! orig: " + orig);
//                return false;
//            }
//
//            if (!result.containsKey("objectName")) {
//                logger.error("EBankUtils.parseOrig cannot find 'objectName'! orig: " + orig);
//                return false;
//            }
//
//            Integer orderId = Integer.parseInt(result.get("objectName").toString());
//            logger.info("[EBANKPAY] orderId:" + orderId + " suc!");
//
//            return true;
//
//        } catch (Exception ex) {
//            logger.error(ex);
//        }
//
//        return false;
//    }
//
//    /**
//     * 获取支付宝返回的参数
//     *
//     * @param request
//     * @return
//     * @throws UnsupportedEncodingException
//     */
//    private Map<String, String> getAlipayParam(HttpServletRequest request)
//            throws UnsupportedEncodingException {
//        // 商户订单号 可以根据这个去更新充值表
//        String out_trade_no =
//                new String(request.getParameter("out_trade_no").getBytes("ISO-8859-1"), "UTF-8");
//        // 支付宝交易号
//        String trade_no =
//                new String(request.getParameter("trade_no").getBytes("ISO-8859-1"), "UTF-8");
//        // 交易状态
//        String trade_status =
//                new String(request.getParameter("trade_status").getBytes("ISO-8859-1"), "UTF-8");
//        // 买家支付宝账号
//        String buyer_email =
//                new String(request.getParameter("buyer_email").getBytes("ISO-8859-1"), "UTF-8");
//        // 买家支付宝账号
//        String buyer_id =
//                new String(request.getParameter("buyer_id").getBytes("ISO-8859-1"), "UTF-8");
//        // 交易金额
//        String total_fee =
//                new String(request.getParameter("total_fee").getBytes("ISO-8859-1"), "UTF-8");
//        // 通知时间，可以认为是到账时间
//        String notify_time =
//                new String(request.getParameter("notify_time").getBytes("ISO-8859-1"), "UTF-8");
//        // 校验ID 可以用于是否是来源于支付宝
//        String notify_id =
//                new String(request.getParameter("notify_id").getBytes("ISO-8859-1"), "UTF-8");
//
//        Map<String, String> param = new HashMap<String, String>();
//        param.put("out_trade_no", out_trade_no);
//        param.put("trade_no", trade_no);
//        param.put("trade_status", trade_status);
//        param.put("buyer_email", buyer_email);
//        param.put("buyer_id", buyer_id);
//        param.put("total_fee", total_fee);
//        param.put("notify_time", notify_time);
//        param.put("notify_id", notify_id);
//        // 接口调用是否成功，可判断请求支付宝是否成功
//        String isSuccess = request.getParameter("is_success");
//        if (null != isSuccess) {
//            String is_success = new String(isSuccess.getBytes("ISO-8859-1"), "UTF-8");
//            param.put("is_success", is_success);
//        }
//        return param;
//    }
//
//    /**
//     * 获取请求参数中所有的信息
//     *
//     * @param request
//     * @return
//     */
//    private Map<String, String> getUnionpayParam(final HttpServletRequest request) {
//        Map<String, String> res = new HashMap<String, String>();
//        Enumeration<?> temp = request.getParameterNames();
//        if (null != temp) {
//            while (temp.hasMoreElements()) {
//                String en = (String) temp.nextElement();
//                String value = request.getParameter(en);
//                res.put(en, value);
//                // 在报文上送时，如果字段的值为空，则不上送<下面的处理为在获取所有参数数据时，判断若值为空，则删除这个字段>
//                // System.out.println("ServletUtil类247行  temp数据的键=="+en+"     值==="+value);
//                if (null == res.get(en) || "".equals(res.get(en))) {
//                    res.remove(en);
//                }
//            }
//        }
//        return res;
//    }
//
//    /**
//     * 更新订单状态
//     *
//     * @param orderId    我们的订单编号
//     * @param type       支付类型
//     * @param payAccount 支付帐号
//     * @param tradeNo    第三方订单号
//     * @param isSuccess  是否支付成功
//     */
//    private boolean updateOrderStatus(String orderId, int type, String payAccount, String tradeNo,
//                                      boolean isSuccess) {
//        Order order = orderDao.findByOrderId(orderId);
//        if (order != null) {
//            try {
//                Payment payment = paymentDao.findByOrderId(orderId);
//                if (payment != null) {
//                    payment.setTradeNo(tradeNo);
//                    payment.setPayFeeAccount(payAccount);
//                    payment.setSuccess(isSuccess);
//                    payment.setFinish(true);
//                    payment.setFinishTime(new Date());
//                    //OrderStatus status;
//                    if (isSuccess) {
//                        //payment.setPayFee(order.getTotalFee());//这里是手工确认
//                        order.setOrderStatus(OrderStatusEnum.Payment.getCode());
//                        //status = new OrderStatus(orderId, "支付成功", "等待商家发货");
//                    } else {
//                        order.setOrderStatus(OrderStatusEnum.PayUnfinished.getCode());
//                        //status = new OrderStatus(orderId, "支付失败", "请重新支付");
//                    }
//                    orderDao.update(order);
//                    paymentDao.update(payment);
//                    //orderStatusDao.save(status);
//                    return true;
//                }
//            } catch (Exception e) {
//                logger.error(e.getMessage(), e);
//            }
//        }
//        return false;
//    }
//}
