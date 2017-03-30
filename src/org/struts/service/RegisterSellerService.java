package org.struts.service;

import java.sql.*;

import javax.servlet.http.HttpSession;

import org.apache.struts2.ServletActionContext;
import org.struts.model.*;
import org.struts.utils.ConnectionPool;
public class RegisterSellerService {
	 HttpSession session = ServletActionContext.getRequest().getSession();

	public boolean findBySellerId(RegisterModel rm) {
		if (ConnectionPool.con != null) {
			try {
				PreparedStatement prepStatement = ConnectionPool.con.prepareStatement("select count(*) from seller where seller_id = ?");
				prepStatement.setString(1, rm.getSellerId());

				ResultSet result = prepStatement.executeQuery();
				if (result != null) {
					while (result.next()) {
						if (result.getInt(1) == 1) {
							System.out.println("bbcudbuwbew"+result.getInt(1));
							return true;
						}
					}
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		System.out.println("bbcudbuwbew  outside");

		return false;
	}
	public void registerIntoDataBase(RegisterModel rm)
	{
		 try
  		{
  			if(ConnectionPool.con==null)
  			ConnectionPool.con=ConnectionPool.getConnection();
  			String query="INSERT INTO seller(name,shipping_address,seller_id,password,emailid,contactnumber,natureofbusiness,categoryofproducts) VALUES (?, ?, ? ,?, ?, ?, ? ,?)";
  			PreparedStatement preparedStmt = ConnectionPool.con.prepareStatement(query);
  			preparedStmt.setString (1, rm.getSellerName());
  			preparedStmt.setString (2, rm.getSellerAdd());
  			preparedStmt.setString (3, rm.getSellerId());
  			preparedStmt.setString (4, rm.getPass());
  			preparedStmt.setString (5, rm.getEmail());

  			preparedStmt.setString (6, rm.getContact());
  			preparedStmt.setString (7, rm.getNature());
  			preparedStmt.setString (8, rm.getCatProduct());

  			
  			
  			System.out.println("sellerId from service method"+rm.getSellerId()+" password "+rm.getPass());
  			preparedStmt.execute();
  			
  			
  			
  			query="INSERT INTO seller004(name,shipping_address,seller_id,password,emailid,contactnumber,natureofbusiness,categoryofproducts) VALUES (?, ?, ? ,?, ?, ?, ? ,?)";
  			preparedStmt = ConnectionPool.con.prepareStatement(query);
  			preparedStmt.setString (1, rm.getSellerName());
  			preparedStmt.setString (2, rm.getSellerAdd());
  			preparedStmt.setString (3, rm.getSellerId());
  			preparedStmt.setString (4, rm.getPass());
  			preparedStmt.setString (5, rm.getEmail());

  			preparedStmt.setString (6, rm.getContact());
  			preparedStmt.setString (7, rm.getNature());
  			preparedStmt.setString (8, rm.getCatProduct());

  			
  			
  			System.out.println("sellerId from service method"+rm.getSellerId()+" password "+rm.getPass());
  			preparedStmt.execute();

  			
  			}
		 catch (SQLException e1) {
				e1.printStackTrace();
			}
		 catch (Exception e1) {
				e1.printStackTrace();
		}
	}
	public void deleteSeller(RegisterModel rm)
	{
		 try
  		{
			 System.out.println("delete seller from db");
			  String user = session.getAttribute("user").toString();
			  System.out.println("delete user from db with userId=...."+user);
			  if(ConnectionPool.con==null)
  			ConnectionPool.con=ConnectionPool.getConnection();
  			String query="delete from seller where seller_id=?";
  			PreparedStatement preparedStmt = ConnectionPool.con.prepareStatement(query);
  			preparedStmt.setString (1, user);
  			preparedStmt.execute();
  			
  			
  			
  			query="delete from seller004 where seller_id=?";
  			preparedStmt = ConnectionPool.con.prepareStatement(query);
  			preparedStmt.setString (1, user);
  			preparedStmt.execute();
  			System.out.println("Seller deleted.......");
  			}
		 catch (SQLException e1) {
				e1.printStackTrace();
			}
		 catch (Exception e1) {
				e1.printStackTrace();
		}
	}
	public void updateSeller1(RegisterModel rm)
	{
		 try
  		{
			 System.out.println("Update user data in db");
			  String user = session.getAttribute("user").toString();
			  System.out.println("update data in db with userId=...."+user);
			  if(ConnectionPool.con==null)
  			ConnectionPool.con=ConnectionPool.getConnection();
  			String query="update seller set name=?,password=?,shipping_address=?,emailid=?,contactnumber=?,natureofbusiness=? where seller_id=?";
  			PreparedStatement preparedStmt = ConnectionPool.con.prepareStatement(query);
  			System.out.println("first name value is"+rm.getSellerName());
  			preparedStmt.setString (1,rm.getSellerName() );
  			preparedStmt.setString (2, rm.getPass());
  			preparedStmt.setString (3, rm.getSellerAdd());
  			preparedStmt.setString (4, rm.getEmail());
  			preparedStmt.setString (5, rm.getContact());
  			preparedStmt.setString (6, rm.getNature());
  			preparedStmt.setString (7, user);
  			preparedStmt.execute();
  			
  			
  			
  			query="update seller004 set name=?,password=?,shipping_address=?,emailid=?,contactnumber=?,natureofbusiness=? where seller_id=?";
  			preparedStmt = ConnectionPool.con.prepareStatement(query);
  			System.out.println("first name value is"+rm.getSellerName());
  			preparedStmt.setString (1,rm.getSellerName() );
  			preparedStmt.setString (2, rm.getPass());
  			preparedStmt.setString (3, rm.getSellerAdd());
  			preparedStmt.setString (4, rm.getEmail());
  			preparedStmt.setString (5, rm.getContact());
  			preparedStmt.setString (6, rm.getNature());
  			preparedStmt.setString (7, user);
  			preparedStmt.execute();
  			
  			
  			
  			
  			System.out.println("Seller Updated.....");
  			}
		 catch (SQLException e1) {
				e1.printStackTrace();
			}
		 catch (Exception e1) {
				e1.printStackTrace();
		}
	}
	
	public void updateSeller(RegisterModel rsm)
	{
		 try
  		{
			 System.out.println("delete user from db");
			  String user = session.getAttribute("user").toString();
			  if(ConnectionPool.con==null)
  			ConnectionPool.con=ConnectionPool.getConnection();
  			String query="select name,password,shipping_address,emailid,contactnumber,natureofbusiness from seller where seller_id=?";
  			PreparedStatement preparedStmt = ConnectionPool.con.prepareStatement(query);
  			preparedStmt.setString (1, user);
  			ResultSet rs=preparedStmt.executeQuery();
  			while(rs.next())
  			{	System.out.println("seller name is..."+rs.getString("name"));
  				rsm.setSellerName(rs.getString("name"));
  				rsm.setPass(rs.getString("password"));
  				rsm.setSellerAdd(rs.getString("shipping_address"));
  				rsm.setEmail(rs.getString("emailid"));
  				rsm.setContact(rs.getString("contactnumber"));
  				rsm.setNature(rs.getString("natureofbusiness"));
  				rsm.setSellerId(user);
  				
  			}
  			
//  			System.out.println("User deleted.......");
			}
		 catch (SQLException e1) {
				e1.printStackTrace();
			}
		 catch (Exception e1) {
				e1.printStackTrace();
		}
	}
	
}