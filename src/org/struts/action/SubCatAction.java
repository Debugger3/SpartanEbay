package org.struts.action;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import org.struts.utils.ConnectionPool;

public class SubCatAction {
	private String categoryName;
	private String subCatName;

	public String deleteSubCategory()
	{
		try
  		{
		if(ConnectionPool.con==null)
  			ConnectionPool.con=ConnectionPool.getConnection();
		String query="delete from subcategory where subcatName='"+subCatName+"'";
    	PreparedStatement   preparedStmt = ConnectionPool.con.prepareStatement(query);
    	preparedStmt.executeUpdate(query);
  		}
		 catch (SQLException e1) {
				e1.printStackTrace();
			}
		 catch (Exception e1) {
				e1.printStackTrace();
		}
	 	
        return "success";
	}

	public String getSubCatName() {
		return subCatName;
	}

	public void setSubCatName(String subCatName) {
		this.subCatName = subCatName;
	}

	public String getCategoryName() {
		return categoryName;
	}

	public void setCategoryName(String categoryName) {
		this.categoryName = categoryName;
	}
}
