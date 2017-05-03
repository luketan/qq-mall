package com.honglinktech.zbgj.utils;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.security.crypto.bcrypt.BCrypt;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/**
 * Created by shon on 2/24/16.
 */
public class HashPasswordUtils {
    static final Logger logger = LogManager.getLogger(HashPasswordUtils.class);

    static public boolean checkLoginPassword(String clientHashPwd, String storedHashPwd) {
        return commonCheckPassword(clientHashPwd, storedHashPwd);
    }

    static public boolean checkPayPassword(String clientHashPwd, String storedHashPwd) {
        return commonCheckPassword(clientHashPwd, storedHashPwd);
    }

    static private boolean commonCheckPassword(String clientHashPwd, String storedHashPwd) {
        if (clientHashPwd == null || clientHashPwd.isEmpty() || storedHashPwd == null || storedHashPwd.isEmpty()) {
            return false;
        }

        try {
            // 客户端做一次md5, 这边需要再做一次md5, 然后bcrypt
            String hash2ndPwd = hashMD5(clientHashPwd);
            if (hash2ndPwd == null || hash2ndPwd.isEmpty()) {
                HashPasswordUtils.logger.warn("hashMD5() return isEmpty string :" + clientHashPwd);
                return false;
            }

            return BCrypt.checkpw(hash2ndPwd, storedHashPwd);
        } catch (Exception ex) {
            HashPasswordUtils.logger.warn(ex);
            return false;
        }
    }

    static public String hashOldLoginPwdForStore(String hash2ndPwd) {
        try {
            String fast_salt = BCrypt.gensalt(4);
            return BCrypt.hashpw(hash2ndPwd, fast_salt);
        } catch (Exception ex) {
            return null;
        }
    }

    static public String hashOldPayPwdForStore(String hash2ndPwd) {
        try {
            String fast_salt = BCrypt.gensalt(6);
            return BCrypt.hashpw(hash2ndPwd, fast_salt);
        } catch (Exception ex) {
            return null;
        }
    }

    static public String hashLoginPwdForStore(String clientHashPwd) {
        return commonHashForStore(clientHashPwd, 4);
    }

    static public String hashPayPwdForStore(String clientHashPwd) {
        return commonHashForStore(clientHashPwd, 6);
    }

    static private String commonHashForStore(String clientHash, int digit) {
        try {
            String fast_salt = BCrypt.gensalt(digit);

            String hash2ndPwd = hashMD5(clientHash);
            if (hash2ndPwd == null || hash2ndPwd.isEmpty()) {
                HashPasswordUtils.logger.warn("hashMD5() return isEmpty string :" + clientHash);
                return null;
            }

            return BCrypt.hashpw(hash2ndPwd, fast_salt);
        } catch (Exception ex) {
            return null;
        }
    }

    static public boolean isLowercaseMD5Hash(String input) {
        if (input == null || input.isEmpty())
            return false;
        return input.matches("^[a-f0-9]{32}$");
    }

    static public String hashMD5(String input) {
        try {
            // 获得MD5摘要算法的 MessageDigest 对象
            MessageDigest mdInst = MessageDigest.getInstance("MD5");
            // 使用指定的字节更新摘要
            mdInst.update(input.getBytes());
            // 获得密文
            byte[] md = mdInst.digest();
            // 把密文转换成十六进制的字符串形式
            StringBuffer hexString = new StringBuffer();
            // 字节数组转换为 十六进制 数
            for (int i = 0; i < md.length; i++) {
                String shaHex = Integer.toHexString(md[i] & 0xFF);
                if (shaHex.length() < 2) {
                    hexString.append(0);
                }
                hexString.append(shaHex);
            }
            return hexString.toString();
        } catch (NoSuchAlgorithmException e) {
            HashPasswordUtils.logger.error(e);
            return null;
        }
    }
}
