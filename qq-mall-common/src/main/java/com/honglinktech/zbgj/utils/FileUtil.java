package com.honglinktech.zbgj.utils;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;

/**
 * Created by Dayong on 16/5/23.
 */
public final class FileUtil {

    private FileUtil() {
    }

    /**
     * Write file.
     *
     * @param in   the in
     * @param file the file
     * @throws IOException the io exception
     */
    public static void writeFile(InputStream in, File file) throws IOException {
        File parentFile = file.getParentFile();
        if (!parentFile.exists()) {
            parentFile.mkdirs();
        }
        FileOutputStream out = new FileOutputStream(file);
        try {
            int n;
            byte[] b = new byte[1024];
            while ((n = in.read(b)) != -1) {
                out.write(b, 0, n);
            }
        } catch (IOException e) {
            file.deleteOnExit();
        } finally {
            out.close();
            out.flush();
            in.close();
        }
    }
}
