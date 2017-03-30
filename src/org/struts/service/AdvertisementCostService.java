package org.struts.service;

import org.apache.struts2.ServletActionContext;
import org.struts.model.AddItemModel;
import org.struts.utils.ConnectionPool;


import java.io.*;
import java.sql.*;

import javax.servlet.http.HttpSession;

public class AdvertisementCostService {

	public boolean advr(AddItemModel am)
	{
		HttpSession session = ServletActionContext.getRequest().getSession();

		try{
			  Class.forName("com.mysql.jdbc.Driver");
			  ConnectionPool.getConnection();
			  Statement stmt=ConnectionPool.con.createStatement();
			  System.out.println("subcatid  "+am.getSubCatId());
			  PreparedStatement ps= ConnectionPool.con.prepareStatement("select advertise_cost from subcategory where subcatId=?");
				 ps.setString(1,am.getSubCatId());
				 ResultSet rs=ps.executeQuery();  
				 if(rs.next())
				 {
					 session.setAttribute("cost", rs.getInt("advertise_cost"));
				 }
			   System.out.println("adv cost  "+am.getAdv_Cost());
			   return true;
			    }
			 catch (SQLException e1) {
					e1.printStackTrace();
				}
				catch (Exception e1) {
					e1.printStackTrace();
				}
			return false; 
			
	}

}
