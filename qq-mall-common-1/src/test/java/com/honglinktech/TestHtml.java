package com.honglinktech;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URL;

import org.htmlparser.NodeFilter;
import org.htmlparser.Parser;
import org.htmlparser.filters.HasAttributeFilter;
import org.htmlparser.util.NodeList;

import com.honglinktech.zbgj.utils.HttpUtil;


/**
 * Created by djb on 2016/3/14.
 */
public class TestHtml {
    private static String ENCODE = "utf-8";

    private static void message(String szMsg) {
        try {
            System.out.println(new String(szMsg.getBytes(ENCODE), System.getProperty("file.encoding")));
        } catch (Exception e) {
        }
    }


    public static String openFile(String szFileName) {
        try {

            BufferedReader bis = new BufferedReader(new InputStreamReader(new FileInputStream(new File(szFileName)), ENCODE));
            String szContent = "";
            String szTemp;

            while ((szTemp = bis.readLine()) != null) {
                szContent += szTemp + "\n";
            }
            bis.close();
            return szContent;
        } catch (Exception e) {
            return "";
        }
    }

    public static String openUrl(String szFileName) {
        try {
            URL url = new URL(szFileName);// 创建URL对象
            InputStream is = url.openStream();// 获取url中的输入流
            BufferedReader bis = new BufferedReader(new InputStreamReader(is, ENCODE));// 指定编码格式，否则容易乱码
            String szContent = "";
            String szTemp;

            while ((szTemp = bis.readLine()) != null) {
                szContent += szTemp + "\n";
            }
            bis.close();
            return szContent;
        } catch (Exception e) {
            return "";
        }
    }

    public static void printNodeList(NodeList nodeList) {
        try {} catch (Exception e) {
            System.out.println(e.toString());
        }
        System.out.println("ddd");
    }


    public static void main(String[] args) {
        String url = "http://www.kuaidi100.com/chaxun?com=zhongtong&nu=376148643056";
        //  String url="http://m.kuaidi100.com/index_all.html?type=中通快递&postid=376148643056";
        String szContent = openUrl(url);
        // String szContent = openFile("D:/单号查询结果 - 快递100.html");

        try {

            String html = HttpUtil.sendGet(url);
            //Parser parser = new Parser((HttpURLConnection) (new URL("http://m.kuaidi100.com/result.jsp?nu=376148643056")).openConnection());
            Parser parser = Parser.createParser(szContent, ENCODE);
            //  Parser parser = new Parser(conn);
//            NodeIterator iteratort = parser.elements();
//            if (iteratort == null) {
//                System.out.println("kong");
//            }
//            while (iteratort.hasMoreNodes()) {
//                Node node = iteratort.nextNode();
//                System.out.println("+++" + node.getChildren().toHtml());
//            }

            NodeFilter filter = new HasAttributeFilter("class", "result-list");
            NodeList nodeList = parser.extractAllNodesThatMatch(filter);

            printNodeList(nodeList);

        } catch (Exception e) {
            System.out.println(e.toString());
        }
    }
}