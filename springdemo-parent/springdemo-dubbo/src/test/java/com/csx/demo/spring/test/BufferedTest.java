package com.csx.demo.spring.test;


import java.io.*;

public class BufferedTest {

    public static void main(String[] args) throws Exception{

        FileReader reader = null;
        BufferedReader bufferedReader = null;
        try {
            reader = new FileReader("file.txt");
            bufferedReader = new BufferedReader(reader);
            System.out.println("codeing:"+reader.getEncoding());
            String line = bufferedReader.readLine();
            while (line!=null){
                System.out.println(line);
                line = bufferedReader.readLine();
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                if(bufferedReader!=null){
                    bufferedReader.close();
                }
                if(reader!=null){
                    reader.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            } finally {
            }
        }


        BufferedReader reader1 = new BufferedReader(new InputStreamReader(System.in));
        String ss = reader1.readLine();
        System.out.println("read line:"+ss);
    }

}
