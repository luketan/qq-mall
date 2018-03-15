package com.honglinktech.zbgj.utils;

import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/**
 * Created by shon on 1/20/16.
 */
public final class HashUtil {

    /**
     *
     */
    private static final int HEX = 0xFF;
    /**
     *
     */
    private static final int HEX_LENGTH = 16;
    /**
     *
     */
    private static final int FOUR_TIMES_HEX = 256;

    /**
     *
     */
    private HashUtil() {
    }

    /***
     * 返回32位小写的md5字符串
     *
     * @param str 原始字符串
     * @return md5字符串
     * @throws Exception 可能会抛出异常, 调用方需要捕获
     */
    public static String md5(String str) throws Exception {
        String md5 = null;
        try {
            MessageDigest md = MessageDigest.getInstance("MD5");
            byte[] barr = md.digest(str.getBytes());  //將 byte 陣列加密
            StringBuffer sb = new StringBuffer();  //將 byte 陣列轉成 16 進制
            for (int i = 0; i < barr.length; i++) {
                sb.append(byte2Hex(barr[i]));
            }
            md5 = sb.toString();
        } catch (Exception e) {
            throw e;
        }
        return md5;
    }


    /**
     * MD5 加密
     *
     * @param content 加密内容
     * @param solt    加盐内容
     * @return 加密后的字符
     * @throws NoSuchAlgorithmException     没有相关算法异常
     * @throws UnsupportedEncodingException 不支持的字符编码异常
     */
    public static String encryptMD5(String content, String solt) throws NoSuchAlgorithmException, UnsupportedEncodingException {
        MessageDigest messageDigest = null;
        try {
            String str = content + solt;
            messageDigest = MessageDigest.getInstance("MD5");
            messageDigest.reset();
            messageDigest.update(str.getBytes("UTF-8"));
        } catch (NoSuchAlgorithmException e) {
            throw e;
        } catch (UnsupportedEncodingException e) {
            throw e;
        }
        byte[] byteArray = messageDigest.digest();
        StringBuffer md5StrBuff = new StringBuffer();
        for (int i = 0; i < byteArray.length; i++) {
            if (Integer.toHexString(HEX & byteArray[i]).length() == 1) {
                md5StrBuff.append("0").append(Integer.toHexString(HEX & byteArray[i]));
            } else {
                md5StrBuff.append(Integer.toHexString(HEX & byteArray[i]));
            }
        }
        return md5StrBuff.toString();
    }

    /**
     * 2进制转16进制
     *
     * @param b 要转换的字节码
     * @return 16进制字符
     */
    public static String byte2Hex(byte b) {
        String[] h = {"0", "1", "2", "3", "4", "5", "6", "7", "8", "9", "a", "b", "c", "d", "e", "f"};
        int i = b;
        if (i < 0) {
            i += FOUR_TIMES_HEX;
        }
        return h[i / HEX_LENGTH] + h[i % HEX_LENGTH];
    }
}
