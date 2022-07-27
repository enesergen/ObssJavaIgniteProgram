package com.example.servletwithdbexample.DbOperation;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;


public class DBConnector {
    private final static String url="jdbc:postgresql://localhost:5432/OBSSDemo";
    private final static String username="postgres";
    private final static String password="12345";

    public static Connection getConnection(){

        Connection connection=null;
        try {
            Class.forName("org.postgresql.Driver");
            connection=DriverManager.getConnection(url,username,password);
        }catch(SQLException exception){
            System.out.println(exception.getMessage());
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
        return connection;
    }

}
