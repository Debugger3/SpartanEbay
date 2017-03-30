package org.struts.action;
import java.sql.*;
import java.util.ArrayList;

import javax.servlet.http.HttpSession;

import org.apache.struts2.ServletActionContext;
import org.struts.utils.ConnectionPool;


public class displayAddress {
	private ArrayList<address> addrList= new ArrayList<address>();
	private ArrayList<String> addressList = new ArrayList<String>();
	private String yourAddress;
	
 	 address add_obj;
	 HttpSession session = ServletActionContext.getRequest().getSession();

	 
	public ArrayList<address> getAddrList() {  
	    return addrList;  
	}  
	public void setAddrList(ArrayList<address> list) {  
	    this.addrList = list;  
	}  
	public String execute() throws SQLException
	{
		 if(ConnectionPool.con==null)
	  			ConnectionPool.con=ConnectionPool.getConnection();
		 
		 //System.out.println("XXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXxxx");
		 HttpSession session = ServletActionContext.getRequest().getSession();
		 PreparedStatement ps= ConnectionPool.con.prepareStatement("select * from address where userId=?");
		 //System.out.println(session.getAttribute("user").toString());
		 
		 System.out.println("UUUUUUUUUUUUUUUUUUUUUUUU");
		 int cost=(Integer) session.getAttribute("cost");
		 System.out.println("cost of item in cart"+cost);
		 ps.setString(1, session.getAttribute("user").toString());
		 ResultSet rs=ps.executeQuery(); 
		 //cost=rs.getInt(8)+cost;
		 
		 System.out.println("before while");
		 while(rs.next())
		 {
			 add_obj = new address();
			 System.out.println("m ooad_project........");
			 add_obj.setContactName(rs.getString(8));
			 add_obj.setAddress(rs.getString(2));
			 add_obj.setCity(rs.getString(3));
			 add_obj.setState(rs.getString(4));
			 add_obj.setCountry("India");
			 add_obj.setPincode(rs.getInt(6));
			 add_obj.setPhone(rs.getLong(7));
			 add_obj.setShipCost(rs.getInt(10));
			 add_obj.setShipTotal(rs.getInt(10)+cost);
			 add_obj.setItemCost(cost);
			 session.setAttribute("shipTotal", rs.getInt(10)+cost);
			 addrList.add(add_obj);
		 }
		 
		 for(address addr:addrList)
		 {
			 	String str;//full address
			 	str = addr.getContactName();
			 	str = str.concat("\n"+addr.getAddress());
			 	str = str.concat("\n"+addr.getCity());
			 	str = str.concat("\n"+addr.getState());
			 	str = str.concat("\n"+addr.getPincode());
			 	str = str.concat("\n"+addr.getCountry());
			 	str = str.concat("\n"+addr.getPhone());
			 	str = str.concat("\n\nDelivery Charges : "+addr.getShipCost());
			 	addressList.add(str);
		 }
	
		 /*for(String s:addressList)
			 System.out.println(s);*/
		 
		 session.setAttribute("address", yourAddress);
		 //session.setAttribute("cost",add_obj.getShipCost()+cost );
		 System.out.println("session cost "+session.getAttribute("cost"));
		 

		
		 return "success";
		
	}
	public ArrayList<String> getAddressList() {
		return addressList;
	}
	public void setAddressList(ArrayList<String> addressList) {
		this.addressList = addressList;
	}
	public String getYourAddress() {
		return yourAddress;
	}
	public void setYourAddress(String yourAddress) {
		this.yourAddress = yourAddress;
	}
	public String deleteAddress()throws SQLException
	{
		
		String addr=getYourAddress();
		boolean flag =false;
		String[] lines;

		  String regex= "\\n";
		  lines = addr.split(regex);
		  
		int l = lines[1].length();
		String selectedAddr = lines[1].substring(0, l-3);
		if(lines[1].contains("\n"))
			flag=true;
		
		System.out.println("your address is:"+selectedAddr+"\nyour phone number is"+lines[6]);
		 if(ConnectionPool.con==null)
	  			ConnectionPool.con=ConnectionPool.getConnection();
		 PreparedStatement ps= ConnectionPool.con.prepareStatement("delete from address where addr like ? and phone=?");
		ps.setString(2,lines[6]);
		ps.setString(1, "%" + selectedAddr + "%" );
		 ps.executeUpdate();  
		 System.out.println(flag);
		return "success";
		
	}
	
}