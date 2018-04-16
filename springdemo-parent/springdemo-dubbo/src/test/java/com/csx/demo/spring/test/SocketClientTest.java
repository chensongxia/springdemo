package com.csx.demo.spring.test;

import java.io.OutputStream;
import java.net.Socket;


public class SocketClientTest {

    public static void main(String[] args) throws Exception{
        Socket client = new Socket("127.0.0.1",10000);
        OutputStream outputStream = client.getOutputStream();
        outputStream.write("haha你是谁".getBytes());
        outputStream.close();
        client.close();
    }

}
