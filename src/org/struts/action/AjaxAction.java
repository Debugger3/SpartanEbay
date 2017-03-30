package org.struts.action;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.*;

import org.struts.utils.ConnectionPool;

public class AjaxAction {
	private Map<String, String> subCategoryMap = new LinkedHashMap<String, String>();
	private String categoryId;
	private String itemId;
	private String itemName;
 public String subCatList()
 {
	 try{
		 if(ConnectionPool.con==null)
			 ConnectionPool.con=ConnectionPool.getConnection();
	  String query="SELECT subcatId,subcatName from subcategory where categoryid=?";
	  System.out.println("dm.getCategoryId() is "+categoryId);
	  PreparedStatement prepStmt=ConnectionPool.con.prepareStatement(query);
	  prepStmt.setString(1,categoryId);
	  ResultSet rs1 = prepStmt.executeQuery();
	  while (rs1.next()) {
		  String subcatId = rs1.getString(1);
		  String subcatName = rs1.getString(2);
		  //System.out.println("subcatId "+subcatId +" and "+ subcatName);
		  subCategoryMap.put(subcatId,subcatName);
	  }
	  System.out.println("SubCat size"+ subCategoryMap.size());
	 }
	  catch (SQLException e1) {
			e1.printStackTrace();
		}
	 catch (Exception e1) {
			e1.printStackTrace();
	}
	 return "success";
 }
 public String itemNameValue()
 {
	 try{
		  String query="SELECT item_name from item where itemId=?";
		  System.out.println("dm.itemId() is "+itemId);
		  PreparedStatement prepStmt=ConnectionPool.con.prepareStatement(query);
		  prepStmt.setString(1,itemId);
		  ResultSet rs1 = prepStmt.executeQuery();
		  while (rs1.next()) {
			  //String subcatId = rs1.getString(1);
			  System.out.println("i hv set here then what is the issue");
			  itemName =  rs1.getString(1);
		  }
		  
		 }
		  catch (SQLException e1) {
				e1.printStackTrace();
			}
		 catch (Exception e1) {
				e1.printStackTrace();
		}
	 return "success";
 }
public Map<String, String> getSubCategoryMap() {
	return subCategoryMap;
}
public void setSubCategoryMap(Map<String, String> subCategoryMap) {
	this.subCategoryMap = subCategoryMap;
}
public String getCategoryName() {
	return categoryId;
}
public void setCategoryName(String categoryName) {
	this.categoryId = categoryName;
}

public String getItemId() {
	return itemId;
}
public void setItemId(String itemId) {
	this.itemId = itemId;
}
public String getItemName() {
	return itemName;
}
public void setItemName(String itemName) {
	this.itemName = itemName;
}
}
