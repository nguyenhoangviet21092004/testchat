package com.example.testchat2;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class Sever {
    private ServerSocket serverSocket ;
    private Socket socket;

    public Sever() {
        try {
            this.serverSocket = new ServerSocket(1234);
            System.out.println("Waiting for connection from client");
            this.socket = serverSocket.accept();
            System.out.println("Connected");


        } catch (IOException e) {
            throw new RuntimeException(e);
        }


    }

    public   void sendDataToClient(String message) throws IOException {

        byte[] send = message.getBytes();
        OutputStream outputStream = socket.getOutputStream();
        outputStream.write(send);

    }

    public void receiveDataFromServer() throws IOException {

        byte[] receive = new byte[1024];
        InputStream inputStream = socket.getInputStream();
        int b =  inputStream.read(receive);
        String type = new String(receive,0,b);
        System.out.println(type);

    }

//    private static void serverSend(String message){
//
//        Connect connect = new Connect();
//        Connection connection = connect.connection();
//
//
//        String query = "insert into message(message,name) values (?,?) ";
//
//        PreparedStatement preparedStatement = null;
//        try{
//            preparedStatement = connection.prepareStatement(query);
//            preparedStatement.setString(1,message);
//            preparedStatement.setString(2,"Server");
//            int row = preparedStatement.executeUpdate();
//            if (row!=0){
//                System.out.println("complete");
//            }
//            connection.close();
//        } catch (SQLException e) {
//            throw new RuntimeException(e);
//        }
//
//    }
//
//
//    private static  void clientSend(String type){
//        Connect connect = new Connect();
//        Connection connection = connect.connection();
//
//
//        String query = "insert into message(message,name) values (?,?) ";
//
//        PreparedStatement preparedStatement = null;
//        try{
//            preparedStatement = connection.prepareStatement(query);
//            preparedStatement.setString(1,type);
//            preparedStatement.setString(2,"Client");
//            int row = preparedStatement.executeUpdate();
//            if (row!=0){
//                System.out.println("complete");
//            }
//            connection.close();
//        } catch (SQLException e) {
//            throw new RuntimeException(e);
//        }
//
//    }




}
