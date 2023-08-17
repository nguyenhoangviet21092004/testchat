package com.example.testchat2;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Connect {
    private String hostname = "localhost:3306" ;
    private String dbname = "Message";
    private String username = "root";
    private String password = "l";

    private String URL = "jdbc:mysql://" + hostname + "/" + dbname;

    public Connection connection(){
        Connection connection = null;
        try{
            connection = DriverManager.getConnection(URL,username,password);
            System.out.println("connected");

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return connection;

    }
    public static void main(String[] args) {
        Connect connect = new Connect();
        connect.connection();
    }
}
