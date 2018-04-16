package com.csx.demo.spring.test;

import java.io.*;

public class FileTest {

    public static void main(String[] args) throws Exception{

        FileOutputStream fos = null;
        try {
            //true:表示在原来文件基础上继续往下写
            fos = new FileOutputStream("file.txt",true);
            fos.write(("床前明月光" + System.lineSeparator()).getBytes());
            fos.write(("疑是地上霜" + System.lineSeparator()).getBytes());
            fos.write(("举头望明月" + System.lineSeparator()).getBytes());
            fos.write(("低头思故乡" + System.lineSeparator()).getBytes());
            fos.flush();
        } catch (IOException e) {
            System.out.println("创建文件失败...");
            e.printStackTrace();
        } finally {
            if (fos != null)
                try {
                    fos.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
        }

        FileInputStream fis = null;
        try {
            fis = new FileInputStream("file.txt");
            byte[] buff = new byte[1024];
            int hasRead = 0;
            while ((hasRead = fis.read(buff)) > 0) {
                String context = new String(buff, 0, hasRead);
                System.out.println(context);
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (fis!=null)
                try {
                    fis.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
        }

        InputStream is = new FileInputStream("file.txt");
        BufferedInputStream bis = new BufferedInputStream(is,1024);

        Reader reader = new FileReader("file.txt");
        BufferedReader bufferedReader = new BufferedReader(reader,1024);

    }
}
