package org.struts.action;

import java.sql.PreparedStatement;

import org.struts.utils.ConnectionPool;

public class deletesubcategory {
	private int subCatId;
	private int categoryId;
	
	public int getSubCatId() {
		return subCatId;
	}
	public void setSubCatId(int subCatId) {
		this.subCatId = subCatId;
	}
	public int getCategoryId() {
		return categoryId;
	}
	public void setCategoryId(int categoryId) {
		this.categoryId = categoryId;
	}
	
	public String execute()
	{
		try{
			if(ConnectionPool.con==null)
	  			ConnectionPool.con=ConnectionPool.getConnection();
			System.out.println("here in delete subcat"+getSubCatId());
			String query="delete from subcategory where subcatId="+getSubCatId();
			
			PreparedStatement prepStmt=ConnectionPool.con.prepareStatement(query);
			//prepStmt.setInt(1, getSubCatId());
			prepStmt.executeUpdate(query);
			System.out.println("here in delete subcat");
			String queryItem="delete from item where subCat_Id="+getSubCatId();
			PreparedStatement prepStmt2=ConnectionPool.con.prepareStatement(queryItem);
			//prepStmt2.setInt(1, getSubCatId());
			prepStmt2.executeUpdate(queryItem);
		}
		catch(Exception e1) {
			e1.printStackTrace();
		}
		return "success";
	}
	
	public String deleteCategory()
	{
		try{
			if(ConnectionPool.con==null)
	  			ConnectionPool.con=ConnectionPool.getConnection();
			System.out.println("here in delete subcat"+getCategoryId());
			String query="delete from category where categoryId="+getCategoryId();
			
			PreparedStatement prepStmt=ConnectionPool.con.prepareStatement(query);
			//prepStmt.setInt(1, getSubCatId());
			prepStmt.executeUpdate(query);
			String catID=Integer.toString(getCategoryId());
			String queryItem="delete from item where ItemCatId="+catID;
			PreparedStatement prepStmt2=ConnectionPool.con.prepareStatement(queryItem);
			//prepStmt2.setInt(1, getSubCatId());
			prepStmt2.executeUpdate(queryItem);
		}
		catch(Exception e1) {
			e1.printStackTrace();
		}
		return "success";
	}


}
