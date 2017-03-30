package org.struts.service;

import java.sql.*;

import javax.servlet.http.HttpSession;

import org.apache.struts2.ServletActionContext;
import org.struts.model.*;
import org.struts.utils.ConnectionPool;
public class UserRegisterService {
	 HttpSession session = ServletActionContext.getRequest().getSession();

	public boolean findByUserId(UserRegisterModel rm) {
		if (ConnectionPool.con != null) {
			try {
				System.out.println("checking if user present");
				PreparedStatement prepStatement = ConnectionPool.con.prepareStatement("select count(*) from user where emailId = ?");
				prepStatement.setString(1, rm.getEmail());

				ResultSet result = prepStatement.executeQuery();
				if (result != null) {
					while (result.next()) {
						if (result.getInt(1) == 1) {
							return true;
						}
					}
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return false;
	}
	public void registerIntoDataBase(UserRegisterModel rm)
	{
		 try
  		{
			 System.out.println("Inserting user in db");
  			if(ConnectionPool.con==null)
  			ConnectionPool.con=ConnectionPool.getConnection();
  			String query="INSERT INTO user(firstName,emailId,password,lastName,userId,phone,dateofbirth) VALUES (?, ?, ? ,?,?,?,?)";
  			PreparedStatement preparedStmt = ConnectionPool.con.prepareStatement(query);
  			preparedStmt.setString (1, rm.getFname());
  			preparedStmt.setString (2, rm.getEmail());
  			preparedStmt.setString (3, rm.getPassword());
  			preparedStmt.setString (4, rm.getLname());
  		    preparedStmt.setString (5, rm.getUserId());
  			preparedStmt.setString (6, rm.getPhone_no());
  			preparedStmt.setString (7, rm.getDob());
  			preparedStmt.execute();
  			}
		 catch (SQLException e1) {
				e1.printStackTrace();
			}
		 catch (Exception e1) {
				e1.printStackTrace();
		}
	}
	public void deleteUser(UserRegisterModel rm)
	{
		 try
  		{
			 System.out.println("delete user from db");
			  String user = session.getAttribute("user").toString();
			  System.out.println("delete user from db with userId=...."+user);
			  if(ConnectionPool.con==null)
  			ConnectionPool.con=ConnectionPool.getConnection();
  			String query="delete from user where emailId=?";
  			PreparedStatement preparedStmt = ConnectionPool.con.prepareStatement(query);
  			preparedStmt.setString (1, user);
  			preparedStmt.execute();
  			
  			System.out.println("User deleted.......");
  			}
		 catch (SQLException e1) {
				e1.printStackTrace();
			}
		 catch (Exception e1) {
				e1.printStackTrace();
		}
	}
	public void updateUser1(UserRegisterModel urm)
	{
		 try
  		{
			 System.out.println("Update user data in db");
			  String user = session.getAttribute("user").toString();
			  System.out.println("update data in db with userId=...."+user);
			  if(ConnectionPool.con==null)
  			ConnectionPool.con=ConnectionPool.getConnection();
  			String query="update user set firstName=?,lastName=?,password=?,dateofbirth=?,userId=?,phone=? where emailId=?";
  			PreparedStatement preparedStmt = ConnectionPool.con.prepareStatement(query);
  			System.out.println("first name value is"+urm.getFname());
  			preparedStmt.setString (1,urm.getFname() );
  			preparedStmt.setString (2, urm.getLname());
  			preparedStmt.setString (3, urm.getPassword());
  			preparedStmt.setString (4, urm.getDob());
  			preparedStmt.setString (5, urm.getUserId());
  			preparedStmt.setString (6, urm.getPhone_no());
  			preparedStmt.setString (7, user);
  			preparedStmt.execute();
  			
  			System.out.println("User Updated.....");
  			}
		 catch (SQLException e1) {
				e1.printStackTrace();
			}
		 catch (Exception e1) {
				e1.printStackTrace();
		}
	}
	
	public void updateUser(UserRegisterModel urm)
	{
		 try
  		{
			 System.out.println("delete user from db");
			  String user = session.getAttribute("user").toString();
			if(ConnectionPool.con==null)
	  			ConnectionPool.con=ConnectionPool.getConnection();
	  			String query="select firstName,lastName,password,dateofbirth,userId,phone from user where emailId=?";
	  			PreparedStatement preparedStmt = ConnectionPool.con.prepareStatement(query);
	  			preparedStmt.setString (1, user);
	  			ResultSet rs=preparedStmt.executeQuery();
	  			while(rs.next())
	  			{
	  				urm.setFname(rs.getString("firstName"));
	  				urm.setLname(rs.getString("lastName"));
	  				urm.setPassword(rs.getString("password"));
	  				urm.setDob(rs.getString("dateofbirth"));
	  				urm.setUserId(rs.getString("userId"));
	  				urm.setPhone_no(rs.getString("phone"));
	  				urm.setEmail(user);
	  				
	  			}
  			
  			System.out.println("User deleted.......");
  			}
		 catch (SQLException e1) {
				e1.printStackTrace();
			}
		 catch (Exception e1) {
				e1.printStackTrace();
		}
	}
	
}
