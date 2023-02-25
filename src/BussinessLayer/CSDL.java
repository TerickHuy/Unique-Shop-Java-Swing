/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BussinessLayer;

import java.sql.*;

/**
 *
 * @author petpkpro123
 */
public class CSDL {

    private static Connection conn;
    public static Connection Connect() {
        String DATABASE_URL = "jdbc:mysql://localhost:3306/SHOPBANHANG";
        String DATABASE_USERNAME = "root";
        String DATABASE_PASSWORD = "";

        try {
            conn = DriverManager.getConnection(DATABASE_URL, DATABASE_USERNAME, DATABASE_PASSWORD);
            System.out.println("Kết nối thành công");           
        } catch (Exception e) {
            System.out.println("Lỗi kết nối CDSL: " + e.getMessage());
            e.printStackTrace();
        }
        return conn;
    }
    
//    private static Connection conn;
//    public static Connection connect(){
//    try{
//        Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
//        String url = "jdbc:sqlserver://PC33:1433;databaseName=SHOPBANHANG";
//        conn = DriverManager.getConnection(url,"sa","sa");
//    }catch(Exception e){
//        e.printStackTrace();
//    }
//    return conn;
//    }
}
