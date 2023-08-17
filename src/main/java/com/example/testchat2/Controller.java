package com.example.testchat2;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.URL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ResourceBundle;
import java.util.Scanner;

public class Controller implements Initializable {
    @FXML
    private TextField tfMessage;



    @FXML
    private TextArea vboxMessage2;
    private String message ;
    private Client client;


    @FXML
    protected void send(Socket socket) throws IOException {


        message = tfMessage.getText();
        vboxMessage2.setText(message);
        tfMessage.setText("");


        while (true){

            byte[] receive = new byte[1024];
            InputStream inputStream = socket.getInputStream();
            int b = inputStream.read(receive);
            String type = new String(receive, 0, b);
            System.out.println(type);

            byte[] send = message.getBytes();
            OutputStream outputStream = socket.getOutputStream();
            outputStream.write(send);

        }



    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        client = new Client();
    }



    private static void sendDataToServer (Socket socket,String message) throws IOException {


        byte[] send = message.getBytes();
        OutputStream outputStream = socket.getOutputStream();
        outputStream.write(send);



//        if ("exit".equalsIgnoreCase(message)){
//            socket.close();
//                serverSocket.close();
//            break;
//        }

    }

//    private static void receiveDataFromServer(Socket socket) throws IOException {
//        byte[] receive = new byte[1024];
//        InputStream inputStream = socket.getInputStream();
//        int b = inputStream.read(receive);
//        String type = new String(receive,0,b);
//        System.out.println(type);
////        clientSend(type);
//    }



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
