package com.honglinktech.zbgj.admin.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import com.honglinktech.zbgj.admin.common.Constants;
import com.honglinktech.zbgj.admin.common.UpyunUtils;

/**
 * user接口控制器
 */
@Controller
@RequestMapping("/upload")
public class UploadController extends BaseController {

    @RequestMapping(value = "/uploadFile", method = {RequestMethod.POST},
            consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    @ResponseBody
    public Map<String, Object> uploadFile(@RequestParam(required = false, value = "file") MultipartFile file) {
        if (file != null && !file.isEmpty()) {
            String fileName = "order/" + System.currentTimeMillis() + Constants.File_TYPE_PDF;
            String busStr = Constants.UPYUN_ROOT_PATH + fileName;
            boolean temp = UpyunUtils.getInstance().writeFile(fileName, file, true);
            if (temp) {
                Map<String, Object> resp = new HashMap<String, Object>();
                Map<String, Object> fileMap = new HashMap<String, Object>();
                fileMap.put("url", busStr);
                fileMap.put("size", (file.getSize()/1024)+" KB");
                resp.put("ResultInt", 0);
                resp.put("ResultString", "success");
                resp.put("result", fileMap);
                return resp;
            }
        }
        Map<String, Object> resp = new HashMap<String, Object>();
        resp.put("ResultInt", 1);
        resp.put("ResultString", "上传失败");
        return resp;
    }
    
    @RequestMapping(value = "/uploadImg", method = {RequestMethod.POST},
            consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    @ResponseBody
    public Map<String, Object> uploadImg(@RequestParam(required = false, value = "imgFile") MultipartFile imgFile) {
        if (imgFile != null && !imgFile.isEmpty()) {
            String fileName = "mall/product/" + System.currentTimeMillis() + Constants.IMAGES_TYPE_PNG;
            String busStr = Constants.UPYUN_ROOT_PATH + fileName;
            boolean temp = UpyunUtils.getInstance().writeFile(fileName, imgFile, true);
            if (temp) {
                Map<String, Object> resp = new HashMap<String, Object>();
                Map<String, Object> imgMap = new HashMap<String, Object>();
                imgMap.put("url", busStr);
                resp.put("ResultInt", 0);
                resp.put("ResultString", "success");
                resp.put("result", imgMap);
                return resp;
            }
        }
        Map<String, Object> resp = new HashMap<String, Object>();
        resp.put("ResultInt", 1);
        resp.put("ResultString", "上传失败");
        return resp;
    }


    @RequestMapping(value = "/ckeditor/uploadFile")
    public void uploadFile(@RequestParam("upload") MultipartFile multipartFile, HttpServletRequest request, HttpServletResponse response) {
        response.setContentType("text/html;charset=UTF-8");
//      response.setHeader("X-Frame-Options", "SAMEORIGIN");

        if (multipartFile != null && !multipartFile.isEmpty()) {
            String fileName = "mall/product/" + System.currentTimeMillis() + Constants.IMAGES_TYPE_PNG;
            String busStr = Constants.UPYUN_ROOT_PATH + fileName;
            boolean temp = UpyunUtils.getInstance().writeFile(fileName, multipartFile, true);

            String CKEditorFuncNum = request.getParameter("CKEditorFuncNum");
            PrintWriter out;
            String s = "<script type=\"text/javascript\">window.parent.CKEDITOR.tools.callFunction(" + CKEditorFuncNum + ", '" + busStr + "');</script>";
            try {
                out = response.getWriter();
                out.print(s);
                out.flush();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
