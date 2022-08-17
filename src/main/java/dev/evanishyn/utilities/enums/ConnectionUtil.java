package dev.evanishyn.utilities.enums;

import java.sql.Connection;
import java.sql.Driver;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionUtil {
    public static Connection createConnection(){
        try{
            Connection conn = DriverManager.getConnection(System.getenv("AZURE_PROJECT_ONE_DB"));
            return conn;
        }catch(SQLException e){
            e.printStackTrace();
            return null;
        }
    }
}
