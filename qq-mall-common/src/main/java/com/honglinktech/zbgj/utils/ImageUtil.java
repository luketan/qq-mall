package com.honglinktech.zbgj.utils;

import main.java.com.UpYun;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.geom.AffineTransform;
import java.awt.image.AffineTransformOp;
import java.awt.image.BufferedImage;
import java.io.*;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

/**
 * 该类是图片处理类
 * Created by djb on 2016/2/24.
 */
public final class ImageUtil {
    /**
     * 图片格式：png
     */
    private static final String PICTRUE_FORMATE_PNG = "png";


    private ImageUtil() {
    }

    /**
     * 图片合成 最多合成九张
     *
     * @param paths    图片URL地址
     * @param filePath
     * @param outPath
     * @param outName
     * @return 返回服务器图片地址
     * @throws IOException
     */
    public static String getCombinationOfhead(List<String> paths, String filePath, String outPath, String outName)
            throws IOException {
        List<BufferedImage> bufferedImages = new ArrayList<BufferedImage>(4);
        // 压缩图片所有的图片生成尺寸同意的 为 50x50
        int count = 0;
        for (int i = 0; i < paths.size(); i++) {
            String fileName = paths.get(i).substring(paths.get(i).lastIndexOf("/"));
            // String filePath = "E:";
            if (saveUrlAs(paths.get(i), filePath + fileName)) {
                count++;
                bufferedImages.add(ImageUtil.resize2(filePath + fileName, 50, 50, true));
            }
            if (count == 3) {
                break;
            }
        }
        int width = 112; // 这是画板的宽高

        int height = 112; // 这是画板的高度

        // BufferedImage.TYPE_INT_RGB可以自己定义可查看API

        BufferedImage outImage = new BufferedImage(width, height,
                BufferedImage.TYPE_INT_RGB);

        // 生成画布
        Graphics g = outImage.getGraphics();

        Graphics2D g2d = (Graphics2D) g;

        // 设置背景色
        g2d.setBackground(new Color(231, 231, 231));

        // 通过使用当前绘图表面的背景色进行填充来清除指定的矩形。
        g2d.clearRect(0, 0, width, height);

        // 开始拼凑 根据图片的数量判断该生成那种样式的组合头像目前为4中
        int j = 1;
        if (bufferedImages != null && bufferedImages.size() > 0) {

            for (int i = 1; i <= bufferedImages.size(); i++) {
                if (bufferedImages.size() == 4) {
                    if (i <= 2) {
                        g2d.drawImage(bufferedImages.get(i - 1), 50 * i + 4 * i
                                - 50, 4, null);
                    } else {
                        g2d.drawImage(bufferedImages.get(i - 1), 50 * j + 4 * j
                                - 50, 58, null);
                        j++;
                    }
                } else if (bufferedImages.size() == 3) {
                    if (i <= 1) {

                        g2d.drawImage(bufferedImages.get(i - 1), 31, 4, null);

                    } else {

                        g2d.drawImage(bufferedImages.get(i - 1), 50 * j + 4 * j
                                - 50, 58, null);

                        j++;
                    }

                } else if (bufferedImages.size() == 2) {

                    g2d.drawImage(bufferedImages.get(i - 1), 50 * i + 4 * i - 50,
                            31, null);

                } else if (bufferedImages.size() == 1) {

                    g2d.drawImage(bufferedImages.get(i - 1), 31, 31, null);

                }

                // 需要改变颜色的话在这里绘上颜色。可能会用到AlphaComposite类
            }
            String outFilePath = outPath + outName + "." + PICTRUE_FORMATE_PNG;
            File f = new File(outFilePath);
            ImageIO.write(outImage, PICTRUE_FORMATE_PNG, f);


            String upyunPath = "http://resources.honglinktech.com";
            UpYun upyun = new UpYun("honglink", "shoplogo", "hl987654");
            String outFileName = "/group/" + outName + "." + PICTRUE_FORMATE_PNG;
            if (upyun.writeFile(outFileName, f, true)) {
                return upyunPath + outFileName;
            }
        }
        return null;
    }

    /**
     * 图片缩放
     *
     * @param filePath 图片路径
     * @param height   高度
     * @param width    宽度
     * @param bb       比例不对时是否需要补白
     */
    public static BufferedImage resize2(String filePath, int height, int width,
                                        boolean bb) {
        try {
            double ratio = 0; // 缩放比例
            File f = new File(filePath);
            BufferedImage bi = ImageIO.read(f);
            Image itemp = bi.getScaledInstance(width, height,
                    Image.SCALE_SMOOTH);
            // 计算比例
            if ((bi.getHeight() > height) || (bi.getWidth() > width)) {
                if (bi.getHeight() > bi.getWidth()) {
                    ratio = (new Integer(height)).doubleValue()
                            / bi.getHeight();
                } else {
                    ratio = (new Integer(width)).doubleValue() / bi.getWidth();
                }
                AffineTransformOp op = new AffineTransformOp(
                        AffineTransform.getScaleInstance(ratio, ratio), null);
                itemp = op.filter(bi, null);
            }
            if (bb) {
                // copyimg(filePath, "D:\\img");
                BufferedImage image = new BufferedImage(width, height,
                        BufferedImage.TYPE_INT_RGB);
                Graphics2D g = image.createGraphics();
                g.setColor(Color.white);
                g.fillRect(0, 0, width, height);
                if (width == itemp.getWidth(null))
                    g.drawImage(itemp, 0, (height - itemp.getHeight(null)) / 2,
                            itemp.getWidth(null), itemp.getHeight(null),
                            Color.white, null);
                else
                    g.drawImage(itemp, (width - itemp.getWidth(null)) / 2, 0,
                            itemp.getWidth(null), itemp.getHeight(null),
                            Color.white, null);
                g.dispose();
                itemp = image;
            }
            return (BufferedImage) itemp;
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }


    public static boolean saveUrlAs(String fileUrl, String savePath)/*fileUrl网络资源地址*/ {

        try {
            URL url = new URL(fileUrl);/*将网络资源地址传给,即赋值给url*/
            /*此为联系获得网络资源的固定格式用法，以便后面的in变量获得url截取网络资源的输入流*/
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();
            DataInputStream in = new DataInputStream(connection.getInputStream());
            /*此处也可用BufferedInputStream与BufferedOutputStream*/
            DataOutputStream out = new DataOutputStream(new FileOutputStream(savePath));
            /*将参数savePath，即将截取的图片的存储在本地地址赋值给out输出流所指定的地址*/
            byte[] buffer = new byte[4096];
            int count = 0;
            while ((count = in.read(buffer)) > 0)/*将输入流以字节的形式读取并写入buffer中*/ {
                out.write(buffer, 0, count);
            }
            out.close();/*后面三行为关闭输入输出流以及网络资源的固定格式*/
            in.close();
            connection.disconnect();
            return true;/*网络资源截取并存储本地成功返回true*/

        } catch (Exception e) {
            System.out.println(e + fileUrl + savePath);
            return false;
        }
    }

}