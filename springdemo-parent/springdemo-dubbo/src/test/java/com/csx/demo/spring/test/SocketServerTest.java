package com.csx.demo.spring.test;

import java.io.InputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class SocketServerTest {

    public static void main(String[] args) throws Exception{
        ServerSocket serverSocket = new ServerSocket(10000);
        while (true){
            Socket socket = serverSocket.accept();
            OutputStream outputStream = socket.getOutputStream();
            System.out.println("buffer size:"+socket.getReceiveBufferSize());
            System.out.println("port:"+socket.getPort());
            System.out.println("local port:"+socket.getLocalPort());

            if(socket.isConnected()){
                InputStream is = socket.getInputStream();
                byte[] buff = new byte[1024];
                int hasRead = 0;
                while ((hasRead=is.read(buff))>0){
                    String xx = new String(buff,0,hasRead);
                    System.out.println(xx);
                }
                is.close();
                outputStream.write("chensongxia".getBytes());
            }
            outputStream.close();
            //socket.close();
        }
    }

}
