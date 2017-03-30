package org.struts.service;

import java.sql.*;
import java.util.Iterator;

import javax.servlet.http.HttpSession;

import org.apache.struts2.ServletActionContext;
import org.struts.model.DeleteModel;
import org.struts.model.Items;
import org.struts.utils.ConnectionPool;

public class DeleteItemService {
	
public void listItemKey(DeleteModel dm)
{
	try
	{
	if(ConnectionPool.con==null)
		ConnectionPool.con=ConnectionPool.getConnection();
	Statement stmt = ConnectionPool.con.createStatement();
	System.out.println("dm.getItemId() "+ dm.getItemId());
	HttpSession session = ServletActionContext.getRequest().getSession();
	 String userId = session.getAttribute("user").toString();

	ResultSet rs = stmt.executeQuery("SELECT itemId, item_name,rowItemId from item where seller_id='"+userId+"'");
	while (rs.next()) {
		  String itemId = rs.getString(1);
		  String itemName ="";// rs.getString(2);
		  System.out.println("Item id is : "+itemId + "\n");
		  dm.addItemIdList(itemId,itemName,rs.getInt(3));
		}
	
		if(dm.getItemId()!=null)
		{
		ResultSet rs1 = stmt.executeQuery("SELECT itemId, item_name,rowItemId from item where itemId='"+dm.getItemId()+"';");
		System.out.println("dm.getItemId() --->"+dm.getItemId());
		while (rs1.next()) {
			  String itemId = rs1.getString(1);
			  String itemName = rs1.getString(2);
			  System.out.println("Item id is here : "+itemId + "\n");
			  if(itemId.equals(dm.getItemId()))
				  {
				  dm.setItemName(itemName);
				  
				  }
			  //System.out.println(dm.getItemIdList1().size());
			}
		}
	}
	 catch (SQLException e1) {
			e1.printStackTrace();
		}
	 catch (Exception e1) {
			e1.printStackTrace();
	}
 
}
public void deleteItem(DeleteModel dm)
{
	System.out.println("deleting in servie");
	try
	{
	if(ConnectionPool.con==null)
		ConnectionPool.con=ConnectionPool.getConnection();
		String query="delete from item where itemId='"+dm.getItemId()+"';";
		System.out.println("dm.getItemId() "+dm.getItemId());
		PreparedStatement prepStmt=ConnectionPool.con.prepareStatement(query);
		prepStmt.executeUpdate(query);
		
	}
	 catch (SQLException e1) {
			e1.printStackTrace();
		}
	 catch (Exception e1) {
			e1.printStackTrace();
	}
 	
}
}
