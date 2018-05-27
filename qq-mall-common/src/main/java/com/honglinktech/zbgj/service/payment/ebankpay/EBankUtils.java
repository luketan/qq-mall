package com.honglinktech.zbgj.service.payment.ebankpay;

import com.honglinktech.zbgj.service.payment.alipay.Base64;
import org.apache.http.NameValuePair;
import org.apache.http.message.BasicNameValuePair;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;
import org.springframework.util.Base64Utils;
import org.xml.sax.InputSource;

import javax.xml.bind.DatatypeConverter;
import java.io.IOException;
import java.io.StringReader;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.security.KeyFactory;
import java.security.PrivateKey;
import java.security.PublicKey;
import java.security.spec.PKCS8EncodedKeySpec;
import java.security.spec.X509EncodedKeySpec;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

/**
 * Created by shon on 3/15/16.
 */
public class EBankUtils {
    static final Logger logger = LogManager.getLogger(EBankUtils.class);
    final static String DefaultEncoding = "GBK";


    public static String base64Encode(String s) {
        try {
            return Base64Utils.encodeToString(s.getBytes(EBankUtils.DefaultEncoding));
        } catch (UnsupportedEncodingException ex) {
            EBankUtils.logger.warn(ex);
            //return Base64Utils.encodeToString(s.getBytes());
            return null;
        }
    }

    public static String base64Decode(String s) {
        try {
            String decodeStr = new String(Base64Utils.decodeFromString(s));
            return new String(decodeStr.getBytes(EBankUtils.DefaultEncoding));
        } catch (IOException ex) {
            EBankUtils.logger.warn(ex);
            return null;
        }
    }

    public static String sign(String content, String pk) {

        try {
            byte[] decodeKey = Base64.decode(pk);
            //PKCS8EncodedKeySpec priPKCS8 = new PKCS8EncodedKeySpec(pk.getBytes());
            PKCS8EncodedKeySpec priPKCS8 = new PKCS8EncodedKeySpec(decodeKey);
            KeyFactory keyf = KeyFactory.getInstance("RSA");
            PrivateKey priKey = keyf.generatePrivate(priPKCS8);

            java.security.Signature signature = java.security.Signature.getInstance("MD5withRSA");

            signature.initSign(priKey);
            signature.update(content.getBytes(EBankUtils.DefaultEncoding));

            byte[] signed = signature.sign();

            return byteArrayToHex(signed);
            //return Base64.encode(signed);
        } catch (Exception e) {
            e.printStackTrace();
        }

        return null;
    }

    public static boolean verify(String content, String sign, String pubkey) {
        try {
            String decodeContent = base64Decode(content);
            String decodeSign = base64Decode(sign);
            byte[] data = hexStringToByteArray(decodeSign);
            //byte[] data = new BigInteger(decodeContent,16).toByteArray();

            KeyFactory keyFactory = KeyFactory.getInstance("RSA");
            byte[] encodedKey = Base64.decode(pubkey);
            PublicKey pubKey = keyFactory.generatePublic(new X509EncodedKeySpec(encodedKey));
            java.security.Signature signature = java.security.Signature.getInstance("MD5withRSA");
            signature.initVerify(pubKey);
            signature.update(decodeContent.getBytes(EBankUtils.DefaultEncoding));
            //signature.update(content.getBytes(EBankUtils.DefaultEncoding));
            //signature.update(data);

            //boolean bverify = signature.verify(decodeContent.getBytes(EBankUtils.DefaultEncoding));
            boolean bverify = signature.verify(data);
            return bverify;

        } catch (Exception e) {
            e.printStackTrace();
        }

        return false;
    }

    public static Map<String, Object> parseOrig(String orid) {
        try {
            List<NameValuePair> list = decodeXml(orid);
            Map<String, Object> result = new LinkedHashMap<String, Object>();
            for (NameValuePair nameValuePair : list) {
                result.put(nameValuePair.getName(), nameValuePair.getValue());
            }
            return result;

        } catch (Exception ex) {
            logger.error(ex, ex);
            return null;
        }
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
                String id = element.attribute("id").getValue();
                String value = element.attribute("value").getValue();

                list.add(new BasicNameValuePair(id, value));
                //list.add(new BasicNameValuePair(element.getName(), (String) element.getData()));
            }
        } catch (DocumentException e) {
            e.printStackTrace();
        }

        return list;
    }


    public static String base64AndUrlEncode(String input) {
        String base64 = EBankUtils.base64Encode(input);
        if (base64 == null)
            return null;

        try {
            return URLEncoder.encode(base64, "GBK");
        } catch (UnsupportedEncodingException e) {
            logger.warn(e.toString());
            return null;
        }
    }


    public static String byteArrayToHex(byte[] a) {
        StringBuilder sb = new StringBuilder(a.length * 2);
        for (byte b : a)
            sb.append(String.format("%02x", b & 0xff));
        return sb.toString();
    }

    public static byte[] hexToByteArray(String s) {
        return DatatypeConverter.parseHexBinary(s);
    }

    public static byte[] hexStringToByteArray(String s) {
        int len = s.length();
        byte[] data = new byte[len / 2];
        for (int i = 0; i < len; i += 2) {
            data[i / 2] = (byte) ((Character.digit(s.charAt(i), 16) << 4)
                    + Character.digit(s.charAt(i + 1), 16));
        }
        return data;
    }
}
