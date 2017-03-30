package org.struts.service;

import java.sql.Blob;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;

import javax.servlet.http.HttpSession;

import org.apache.struts2.ServletActionContext;
import org.apache.tomcat.util.codec.binary.Base64;
import org.struts.model.OrderModel;
import org.struts.utils.ConnectionPool;

public class OrderService {
	public boolean listOrder(OrderModel om)
	{
		try{
			if(ConnectionPool.con==null)
				ConnectionPool.con=ConnectionPool.getConnection();
			HttpSession session = ServletActionContext.getRequest().getSession();
			String uType=session.getAttribute("type").toString();
			//System.out.println(" session value is "+session.getAttribute("user"));
			if(session.getAttribute("user")==null || session.getAttribute("user").equals(""))
				return false;
			String date = "yyyy-MM-dd"; 
			Calendar calendar = Calendar.getInstance();     
			SimpleDateFormat dateFormat = new SimpleDateFormat(date);       
			//System.out.println("Today Date = "+dateFormat.format(calendar.getTime()));
			//System.out.println("difference of date "+dateFormat.format(calendar.getTime())-2015-03-01'<=30);
			//String query="SELECT * from orders where userId=? and datediff(CURDATE(),orderDate)<=90";
			String query="SELECT o.orderId,i.itemId,i.item_name,i.item_desc,i.image,o.sellerId,o.quantity," +
					"o.status,o.orderDate,o.paymentId,o.orderFlag,o.price,o.address,o.rateFlag " +
					"from orders o,item i " +
					"where o.userId=?  and  orderFlag='B'" +
					" and i.itemId=o.itemId";
  			PreparedStatement preparedStmt = ConnectionPool.con.prepareStatement(query);
  			preparedStmt.setString(1, (String)session.getAttribute("user"));
  			//preparedStmt.setString(2, (String)session.getAttribute("user"));
			ResultSet rs = preparedStmt.executeQuery();
			OrderModel o;
			om.setOrderList(new ArrayList<OrderModel>());
			while (rs.next()) {
				System.out.println("here   ");
				o=new OrderModel();
				//System.out.println("inserting in Track my order");
				o.setOrderId(rs.getString("orderId"));
				//o.setUserId(rs.getString("userName"));
				Blob pic=rs.getBlob("image");
				if(pic!=null)
				{
				int blobLength = (int) pic.length();	
				o.setImage64encode(new Base64().encodeToString(pic.getBytes(1, blobLength)));
				}
				o.setItemId(rs.getString("itemId"));
				o.setItemDesc(rs.getString("item_desc"));
				o.setSellerId(rs.getString("sellerId"));
				o.setQuantity(rs.getString("quantity"));
				o.setItemName(rs.getString("item_name"));
				o.setStatus(rs.getString("status"));
				o.setOrderDate(rs.getString("orderDate"));
				o.setPaymentId(rs.getString("paymentId"));
				o.setOrderFlag(rs.getString("orderFlag"));
				o.setPrice(rs.getString("price"));
				o.setAddress(rs.getString("address"));
				o.setRateFlag(rs.getString("rateFlag"));
				//om.setAddress(rs.getString("address"));
				o.setStatusList(new ArrayList<String>());
				//System.out.println("userType--------->"+uType);
				
				

				if(rs.getString("status").equals("Approved")  || rs.getString("status").equals("Payment Successful"))
				{
					o.getStatusList().add("Approved");
					o.getStatusList().add("Delivered");
				}
				else if(rs.getString("status").equals("Delivered"))
				{
					o.getStatusList().add("Delivered");
					o.getStatusList().add("Received");
				}
				else 
				{
					
					o.getStatusList().add("Received");
				}
				
				System.out.println("i am here!!!!!!!!"+o.getSellerId());
				
				double rating=1.00,roundoff=1.0;
				//rating
				String q1="Select sellerrating from seller where seller_id=?";
	        	PreparedStatement prepS1 = ConnectionPool.con.prepareStatement(q1);
	        	prepS1.setString(1, o.getSellerId());
	        	ResultSet rs1 = prepS1.executeQuery();
	        	if(rs1.next())
	        	{
	        		System.out.println("inside new code....");
	        		rating = rs1.getDouble("sellerrating");
	        		//roundoff = Math.round((rating*10)/10);
	        		System.out.println("rating till now"+rating+"and new rating roundoff is");
	        	}
	        	o.setRating(rating);
				om.getOrderList().add(o);
				
			}
		}
			 catch (SQLException e1) {
					e1.printStackTrace();
					return false;
				}
			 catch (Exception e1) {
					e1.printStackTrace();
					return false;
			}
		
		 System.out.println("om size"+om.getOrderList().size());
		return true;	
	}
	
	public boolean listOrder1(OrderModel om)
	{
		try{
			if(ConnectionPool.con==null)
				ConnectionPool.con=ConnectionPool.getConnection();
			HttpSession session = ServletActionContext.getRequest().getSession();
			String uType=session.getAttribute("type").toString();
			System.out.println(" session value is1111 "+session.getAttribute("user"));
			if(session.getAttribute("user")==null || session.getAttribute("user").equals(""))
				return false;
			String date = "yyyy-MM-dd"; 
			Calendar calendar = Calendar.getInstance();     
			SimpleDateFormat dateFormat = new SimpleDateFormat(date);       
			System.out.println("Today Date = "+dateFormat.format(calendar.getTime()));
			//System.out.println("difference of date "+dateFormat.format(calendar.getTime())-2015-03-01'<=30);
			//String query="SELECT * from orders where userId=? and datediff(CURDATE(),orderDate)<=90";
			String query;
			if(uType.equals("seller"))
			query="SELECT o.orderId,i.itemId,i.item_name,i.item_desc,i.image,o.sellerId,o.quantity," +
					"o.status,o.orderDate,o.paymentId,o.orderFlag,o.price,o.address " +
					"from orders o,item i " +
					"where sellerId =? and  orderFlag='B'" +
					" and i.itemId=o.itemId";
			else
			query="SELECT o.orderId,i.itemId,i.item_name,i.item_desc,i.image,o.sellerId,o.quantity," +
					"o.status,o.orderDate,o.paymentId,o.orderFlag,o.price,o.address " +
					"from orders o,item i " +
					"where userId =? and  orderFlag='B'" +
					" and i.itemId=o.itemId";
  			PreparedStatement preparedStmt = ConnectionPool.con.prepareStatement(query);
  			preparedStmt.setString(1, (String)session.getAttribute("user"));
  			//preparedStmt.setString(2, (String)session.getAttribute("user"));
			ResultSet rs = preparedStmt.executeQuery();
			OrderModel o;
			om.setOrderList(new ArrayList<OrderModel>());
			while (rs.next()) {
				o=new OrderModel();
				System.out.println("inserting in Track my order");
				o.setOrderId(rs.getString("orderId"));
				//o.setUserId(rs.getString("userName"));
				Blob pic=rs.getBlob("image");
				if(pic!=null)
				{
				int blobLength = (int) pic.length();	
				o.setImage64encode(new Base64().encodeToString(pic.getBytes(1, blobLength)));
				}
				o.setItemId(rs.getString("itemId"));
				o.setItemDesc(rs.getString("item_desc"));
				o.setSellerId(rs.getString("sellerId"));
				o.setQuantity(rs.getString("quantity"));
				o.setItemName(rs.getString("item_name"));
				o.setStatus(rs.getString("status"));
				o.setOrderDate(rs.getString("orderDate"));
				o.setPaymentId(rs.getString("paymentId"));
				o.setOrderFlag(rs.getString("orderFlag"));
				o.setPrice(rs.getString("price"));
				o.setAddress(rs.getString("address"));
				//om.setAddress(rs.getString("address"));
				o.setStatusList(new ArrayList<String>());
				System.out.println("userType--------->"+uType);
				
				

				if(rs.getString("status").equals("Approved")  || rs.getString("status").equals("Payment Successful"))
				{
					System.out.println("i m here");
					o.getStatusList().add("Approved");
					if(uType.equals("seller"))
						o.getStatusList().add("Delivered");
				}
				else if(rs.getString("status").equals("Delivered"))
				{
					o.getStatusList().add("Delivered");
					if(uType.equals("user"))
						o.getStatusList().add("Received");
				}
				else 
				{
					o.getStatusList().add("Received");
				}
				om.getOrderList().add(o);
				
			}
		}
			 catch (SQLException e1) {
					e1.printStackTrace();
					return false;
				}
			 catch (Exception e1) {
					e1.printStackTrace();
					return false;
			}
		
		 System.out.println("om size"+om.getOrderList().size());
		return true;	
	}
	
	public boolean changeRating(double rating ,String sellerid,String itemId,String orderId)
	{
		double rating_old=rating;
		int count=0;
		HttpSession session = ServletActionContext.getRequest().getSession();
		try
		{
		 
		 String user=session.getAttribute("user").toString();
		 String q1="Select sellerrating,ratingCount from seller where seller_id=?";
 		 System.out.println("Hiiiiii priyanka seller id is"+sellerid);
 			PreparedStatement prepS1 = ConnectionPool.con.prepareStatement(q1);
 			prepS1.setString(1, sellerid);
 			ResultSet rs1 = prepS1.executeQuery();
 			if(rs1.next())
 			{
 				//System.out.println("inside new code....");
 				rating_old = rs1.getDouble("sellerrating");
 				count = rs1.getInt("ratingCount");
 			}
 			
 			count++;
 			System.out.println("count is"+count);
 			rating_old = (rating+(rating_old*(count-1)))/count;
 			//System.out.println("rating is"+rating_old);
 			double roundOff = Math.round(rating_old * 100.0) / 100.0;
 			System.out.println("rating is"+roundOff);
 			String q="UPDATE seller set sellerrating=?, ratingCount=? where seller_id=?";
			PreparedStatement prepS = ConnectionPool.con.prepareStatement(q);
			prepS.setDouble(1, roundOff);
			prepS.setInt(2, count);
			prepS.setString(3,sellerid);
			prepS.execute();
			
			
			
			q="UPDATE seller004 set sellerrating004=?, ratingCount=? where seller_id=?";
			prepS = ConnectionPool.con.prepareStatement(q);
			prepS.setDouble(1, roundOff);
			prepS.setInt(2, count);
			prepS.setString(3,sellerid);
			prepS.execute();
			
			System.out.println("Updating rate flag in order table ");
			String q2="UPDATE orders set rateFlag=? where orderId=?  and sellerId=? and userId=? and itemId=?";
			PreparedStatement prepS2 = ConnectionPool.con.prepareStatement(q2);
			prepS2.setString(1, "Y");
			prepS2.setString(2, orderId);
			prepS2.setString(3, sellerid);
			prepS2.setString(4,user);
			prepS2.setString(5,itemId);
			prepS2.execute();
 			
		}
		
		catch (Exception e1) {
			e1.printStackTrace();
			return false;
	}
		 
		 session.setAttribute("rate", true);

		return true;
	}
	
}