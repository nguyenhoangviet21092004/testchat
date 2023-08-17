package com.example.testchat2;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.URL;
import java.util.ResourceBundle;

public class HelloController implements Initializable {

    @FXML
    private TextField tfMessage;


    @FXML
    private TextArea vboxMessage2;
    private String message;

    private String a;

    private int port= 9999;
    private Sever sever;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        sever = new Sever();
    }
    @FXML
    protected void send() throws IOException {
        sever.sendDataToClient(message);
        sever.receiveDataFromServer();
    }

}