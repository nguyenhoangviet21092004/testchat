package com.example.testchat2;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;
import java.util.Scanner;

public class Client {
   private Socket clientSocket;

    public Client() {
        try {
            this.clientSocket = new Socket("localhost",1234);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    private static void sendDataToServer (Socket socket, String message) throws IOException {

        byte[] send = message.getBytes();
        OutputStream outputStream = socket.getOutputStream();
        outputStream.write(send);
    }

    private static void receiveDataFromServer(Socket socket) throws IOException {
        byte[] receive = new byte[1024];
        InputStream inputStream = socket.getInputStream();
        int b = inputStream.read(receive);
        String type = new String(receive,0,b);
        System.out.println(type);
    }


}
