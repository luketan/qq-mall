package com.honglinktech.zbgj.service.payment.wechat;

import org.apache.http.NameValuePair;
import org.apache.http.message.BasicNameValuePair;
import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;
import org.xml.sax.InputSource;

import java.io.StringReader;
import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Random;

/**
 * 名称： 基础参数<br>
 * 功能： 提供基础数据<br>
 * 版本： 5.0<br>
 * 日期： 2014-07<br>
 * 作者： 中国银联ACP团队<br>
 * 版权： 中国银联<br>
 * 说明：以下代码只是为了方便商户测试而提供的样例代码，商户可以根据自己需要，按照技术文档编写。该代码仅供参考。<br>
 */
public class WeiXinPayUtil {
    public static String encodeXml(List<NameValuePair> list) {
        StringBuilder sb = new StringBuilder();
        sb.append("<xml>");
        for (int i = 0; i < list.size(); i++) {
            sb.append("<" + list.get(i).getName() + ">").append(list.get(i).getValue()).append("</" + list.get(i).getName() + ">");
        }
        sb.append("</xml>");
        return sb.toString();
    }

    public static List<NameValuePair> decodeXml(String content) {
        List<NameValuePair> list = new LinkedList<NameValuePair>();
        // content =
        // "<xml>   <return_code><![CDATA[SUCCESS]]></return_code>   <return_msg><![CDATA[OK]]></return_msg>   <appid><![CDATA[wx2421b1c4370ec43b]]></appid>   <mch_id><![CDATA[10000100]]></mch_id>   <nonce_str><![CDATA[IITRi8Iabbblz1Jc]]></nonce_str>   <sign><![CDATA[7921E432F65EB8ED0CE9755F0E86D72F]]></sign>   <result_code><![CDATA[SUCCESS]]></result_code>   <prepay_id><![CDATA[wx201411101639507cbf6ffd8b0779950874]]></prepay_id>   <trade_type><![CDATA[JSAPI]]></trade_type></xml>";

        try {
            StringReader read = new StringReader(content);
            InputSource source = new InputSource(read);
            SAXReader reader = new SAXReader();

            Document document = reader.read(source);
            List<Object> rowList = document.getRootElement().elements();

            for (Iterator<Object> iter = rowList.iterator(); iter.hasNext(); ) {
                Element element = (Element) iter.next();
                list.add(new BasicNameValuePair(element.getName(), (String) element.getData()));
            }
        } catch (DocumentException e) {
            e.printStackTrace();
        }

        return list;
    }

    public static String weixinMD5(byte[] buffer) {
        char hexDigits[] = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'a', 'b', 'c', 'd', 'e', 'f'};
        try {
            MessageDigest mdTemp = MessageDigest.getInstance("MD5");
            mdTemp.update(buffer);
            byte[] md = mdTemp.digest();
            int j = md.length;
            char str[] = new char[j * 2];
            int k = 0;
            for (int i = 0; i < j; i++) {
                byte byte0 = md[i];
                str[k++] = hexDigits[byte0 >>> 4 & 0xf];
                str[k++] = hexDigits[byte0 & 0xf];
            }
            return new String(str);
        } catch (Exception e) {
            return null;
        }
    }

    public static String createSign(List<NameValuePair> list, String wechatApiKey) throws UnsupportedEncodingException {
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i < list.size(); i++) {
            stringBuilder.append(list.get(i).getName()).append("=").append(list.get(i).getValue()).append("&");
        }

        stringBuilder.append("key").append("=").append(wechatApiKey);
        return weixinMD5(stringBuilder.toString().getBytes()).toUpperCase();
    }

    public static String getValue(List<NameValuePair> list, String name) {
        for (NameValuePair pair : list) {
            if (pair.getName().equalsIgnoreCase(name)) {
                return pair.getValue();
            }
        }

        return "";
    }

    public static String genNonceStr() {
        Random random = new Random();
        return weixinMD5(String.valueOf(random.nextInt(10000)).getBytes());
    }

    public static String genOutTradNo(String orderId) {
        return weixinMD5(orderId.getBytes());
    }
}