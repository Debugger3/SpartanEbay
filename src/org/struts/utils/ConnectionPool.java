package org.struts.utils;
import java.sql.*;

import javax.servlet.http.HttpSession;

import org.apache.struts2.ServletActionContext;
public class ConnectionPool {

		public final static String JDBC_DRIVER = "com.mysql.jdbc.Driver";
		public final static String DB_URL = "jdbc:mysql://localhost/ooad_project";
		public final static String USER = "root";
		public final static String PASS = "root";
		public static Connection con=null;
		public static Connection getConnection()
		{
			if(con==null)
			{
				try {
					Class.forName("com.mysql.jdbc.Driver");
					con = DriverManager.getConnection(DB_URL, USER, PASS);
				} catch (ClassNotFoundException e) {
					e.printStackTrace();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
			return con;
		}
		
		public  static void closeConnection()
		{
			try {
				if(con!=null)
					con.close();
				System.out.println("Connection Closed Successfully");
				HttpSession session = ServletActionContext.getRequest().getSession(false);
		    	session.removeAttribute("logined");
		    	session.removeAttribute("context");
		    	session.removeAttribute("user");
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}
