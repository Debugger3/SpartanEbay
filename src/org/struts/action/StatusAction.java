package org.struts.action;

import java.util.ArrayList;
import java.util.List;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.http.HttpSession;

import org.apache.struts2.ServletActionContext;
import org.struts.service.AddToCartService;
import org.struts.utils.ConnectionPool;

import com.opensymphony.xwork2.ActionSupport;

public class StatusAction extends ActionSupport {
	
	private String status,itemId,count,check,orderId;
	private int quant;
	private List<String> country;
	 HttpSession session = ServletActionContext.getRequest().getSession();

	public String execute()
	{
		System.out.println("i am in status action"+getStatus());
		updateDb();
		System.out.println("returning from status action :)");
		country=new ArrayList<String>();
		  country.add("recieved");
		return "success";
	}
	
	
	public void updateDb()
	{
        String user = session.getAttribute("user").toString();
        String type = session.getAttribute("type").toString();
        System.out.println("user type------------------>"+type);
        int price=0;
        String sellerId="";
        try
		{
		if(ConnectionPool.con==null)
			ConnectionPool.con=ConnectionPool.getConnection();
			String q;
			if(type.equals("seller"))
				q="Update orders set status = ? where sellerId=? and itemId=?";
			else
				q="Update orders set status = ? where userId=? and itemId=?";
			PreparedStatement prepS = ConnectionPool.con.prepareStatement(q);
			prepS.setString(1, getStatus());
			prepS.setString(2, user);
			prepS.setString(3, getItemId());

		prepS.execute();
		
	String status= getStatus();
	System.out.println("qqqqqqqqq"+getQuant()+"checking--------->"+getCheck()+"usrid"+user+"itemid"+getItemId());
	if(status.equalsIgnoreCase("Received"))
	{
		String q1="select price,sellerId from orders where userId=? and itemId=? and status=? and orderId=?";
		PreparedStatement prep = ConnectionPool.con.prepareStatement(q1);
		prep.setString(1, user);
		prep.setString(2, getItemId());
		prep.setString(3,"Received");
		prep.setString(4,getOrderId());
		ResultSet rs1 = prep.executeQuery();
		if(rs1.next())
		{
			price = rs1.getInt("price");
			sellerId = rs1.getString("sellerId");
		}
			price=price*getQuant();
			System.out.println("check..........>>>>"+price+""+sellerId);
			System.out.println("Sellerid"+sellerId);
			
			String q2="Update account set balance = balance+? where userId=?";
			PreparedStatement prep1 = ConnectionPool.con.prepareStatement(q2);
			prep1.setInt(1,price);
			prep1.setString(2,sellerId);
		prep1.execute();
		
		String q3="Update account set balance = balance-? where userId=?";
		PreparedStatement prep2 = ConnectionPool.con.prepareStatement(q3);
		prep2.setInt(1,price);
		prep2.setString(2,"ebay");
	prep2.execute();
		
	}
	}
		 catch (SQLException e1) {
		e1.printStackTrace();
	}
	catch (Exception e1) {
		e1.printStackTrace();
	}



	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}


	public String getItemId() {
		return itemId;
	}


	public void setItemId(String itemId) {
		this.itemId = itemId;
	}


	public String getCount() {
		return count;
	}


	public void setCount(String count) {
		this.count = count;
	}


	public int getQuant() {
		return quant;
	}


	public void setQuant(int quant) {
		this.quant = quant;
	}


	public String getCheck() {
		return check;
	}


	public void setCheck(String check) {
		this.check = check;
	}


	public String getOrderId() {
		return orderId;
	}


	public void setOrderId(String orderId) {
		this.orderId = orderId;
	}

}