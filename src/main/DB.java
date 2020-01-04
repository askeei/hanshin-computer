package main;

import java.sql.*;
import java.io.IOException;
import java.util.Vector;

public class DB {

	final static String server = "localhost:3306";
	final static String database = "hanshin";
	final static String userName = "root";
	final static String password = "onlyroot";

	private static Connection con  = null;
	
	public static Connection loadConnection() {
		try {
			Class.forName("com.mysql.jdbc.Driver");		
			con = DriverManager.getConnection("jdbc:mysql://" + server  + "/" + database,
					userName, password );
		} catch( Exception ex ) { 

			System.err.println("conn ����:" + ex.getMessage() );
			ex.printStackTrace();
		}	   
		return con;
	}
}