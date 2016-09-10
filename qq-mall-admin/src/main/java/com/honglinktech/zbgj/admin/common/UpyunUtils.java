package com.honglinktech.zbgj.admin.common;

import main.java.com.UpYun;
import org.apache.commons.fileupload.disk.DiskFileItem;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.commons.CommonsMultipartFile;

import java.io.File;
import java.io.IOException;

/**
 * Created by djb on 2016/3/8.
 */
public class UpyunUtils extends UpYun {

    private static UpyunUtils upyunUtils = null;

    private UpyunUtils(String bucketName, String userName, String password) {
        super(bucketName, userName, password);
    }

    public static UpyunUtils getInstance() {
        if (upyunUtils == null) {
            synchronized (UpyunUtils.class) {
                if (null == upyunUtils) {
                    upyunUtils = new UpyunUtils("honglink", "shoplogo", "hl987654");
                }
            }
        }
        return upyunUtils;
    }

    public boolean writeFile(String filePath, MultipartFile multipartFile, boolean auto) {
        try {
            CommonsMultipartFile cf = (CommonsMultipartFile) multipartFile;
            DiskFileItem fi = (DiskFileItem) cf.getFileItem();
            File file = fi.getStoreLocation();
            if (writeFile(filePath, file, auto)) {
                return true;
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return false;
    }

}
