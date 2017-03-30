package org.struts.service;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.servlet.http.HttpSession;
import org.apache.struts2.ServletActionContext;
import org.struts.action.address;
import org.struts.model.BuyNowModel;
import org.struts.utils.ConnectionPool;

import com.opensymphony.xwork2.ActionSupport;

public class BuyNowService extends ActionSupport{
	public boolean setAddress(BuyNowModel bnm)
	{
		HttpSession session = ServletActionContext.getRequest().getSession();
		if(session.getAttribute("user")==null || session.getAttribute("user").equals(""))
			return false;
		if(bnm.getQuantity()<=0) 
			bnm.setQuantity(1);
		else
			{
			bnm.setDiscountedCost(bnm.getDiscountedCost()*bnm.getQuantity());
			bnm.setCost(bnm.getCost()*bnm.getQuantity());
			}
		if(bnm.getCost()<500)
			{bnm.setDeliveryCharge(50);
			bnm.setDiscountedCost(bnm.getDiscountedCost()+50);
			bnm.setCost(bnm.getCost()+50);
			}
		System.out.println("cost is "+bnm.getCost());
		
		String user=session.getAttribute("user").toString();
		try
  		{
			if(ConnectionPool.con==null)
	  			ConnectionPool.con=ConnectionPool.getConnection();
			PreparedStatement ps= ConnectionPool.con.prepareStatement("select * from address where userId=?");
			ps.setString(1, user);
			ResultSet rs=ps.executeQuery();
			address addObj;
			bnm.setAddrList(new ArrayList<address>());
			while(rs.next())
			{
				addObj = new address();
				addObj.setContactName(rs.getString(8));
				addObj.setAddress(rs.getString(2));
				addObj.setCity(rs.getString(3));
				addObj.setState(rs.getString(4));
				addObj.setCountry(rs.getString("country"));
				addObj.setPincode(rs.getInt(6));
				addObj.setPhone(rs.getLong(7));
				bnm.getAddrList().add(addObj);
			 }
  		}
		 catch (SQLException e1) {
				e1.printStackTrace();
			}
		 catch (Exception e1) {
				e1.printStackTrace();
		}
			/* for(address addr:addrList)	 
  		
		 {
			 	String str;//full address
			 	str = addr.getContactName();
			 	str = str.concat("\n"+addr.getAddress());
			 	str = str.concat("\n"+addr.getCity());
			 	str = str.concat("\n"+addr.getState());
			 	str = str.concat("\n"+addr.getPincode());
			 	str = str.concat("\n"+addr.getCountry());
			 	str = str.concat("\n"+addr.getPhone());
			 	addressList.add(str);
		 }
		 */
		 
	
		
		
		return true;
	}
	public void addAddress(BuyNowModel bnm) 		 
	{
		if(ConnectionPool.con==null)
			ConnectionPool.con=ConnectionPool.getConnection();
		String c ="India";
		HttpSession session = ServletActionContext.getRequest().getSession();
		String query = "insert into address(contactName,addr,pincode,city,state,phone,country,userID)values(?,?,?,?,?,?,?,?)";
		PreparedStatement preparedStmt;
		try {
			preparedStmt = ConnectionPool.con.prepareStatement(query);
			preparedStmt.setString (1, bnm.getContactName());
			preparedStmt.setString (2, bnm.getAddress());
			preparedStmt.setInt(3, bnm.getPincode());
			preparedStmt.setString (4, bnm.getCity());
			preparedStmt.setString (5, bnm.getState());
			preparedStmt.setLong(6, bnm.getPhone());
			preparedStmt.setString(7, bnm.getCountry());
			preparedStmt.setString(8,session.getAttribute("user").toString());
			preparedStmt.execute();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void deleteAddress(BuyNowModel bnm) 		 
	{
		System.out.println(" i m in delete address");
		HttpSession session = ServletActionContext.getRequest().getSession();
		if(ConnectionPool.con==null)
			ConnectionPool.con=ConnectionPool.getConnection();
		//System.out.println("phone no....>>>"+bnm.getPhone());
		String user=session.getAttribute("user").toString();
		String query = "delete from address where addr=? and userId=?";
		PreparedStatement preparedStmt;
		try {
		preparedStmt = ConnectionPool.con.prepareStatement(query);
		preparedStmt.setString (1, bnm.getAddress());
		preparedStmt.setString(2,user);
		preparedStmt.execute();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public boolean checkQuantity(BuyNowModel bnm)
	{
		String query="";
		PreparedStatement preparedStmt;
		int quantity=0;
		if(ConnectionPool.con==null)
			ConnectionPool.con=ConnectionPool.getConnection();
		try{
			query = "select quantity from item where itemId=?";
			preparedStmt = ConnectionPool.con.prepareStatement(query);
			preparedStmt.setString (1, bnm.getItemId());
			ResultSet rs=preparedStmt.executeQuery();
			while(rs.next())
			{
				quantity=rs.getInt("quantity");
				System.out.println("quantity"+quantity);
				if(quantity<bnm.getQuantity())
				{
					bnm.setQuantity(quantity);
					addActionError("Requested Quantity not available");
				}
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return true;
	}
}
