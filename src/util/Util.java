package util;

import java.sql.Connection;


import java.sql.DriverManager;
import java.sql.SQLException;


public class Util {
	
	   static String ip = "localhost";
	    static int port = 3306;
	    static String database = "Warehouse&goods";
	    static String encoding = "UTF-8";
	    static String loginName = "root";
	    static String password = "123456";

	    
	    static {

	        try {
	            Class.forName("com.mysql.jdbc.Driver");
	        } catch (ClassNotFoundException e) {
	            e.printStackTrace();
	        }
	    }
	    
	    
	    
	    public static Connection getConnection() throws SQLException {
	     // String url = String.format("jdbc:mysql://%s:%d/%s?characterEncoding=%s", ip, port, database, encoding);
	    	String url = String.format("jdbc:mysql://localhost:3306/Warehouse&goods?characterEncoding=UTF-8", ip, port, database, encoding);
	      
	        return DriverManager.getConnection(url, loginName, password);
	    }

	    public static void main(String[] args) throws SQLException {
	        System.out.println(getConnection());
	        System.out.println("连接成功");

	    }
	    
	    
}
