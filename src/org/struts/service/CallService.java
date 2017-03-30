package org.struts.service;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import org.struts.model.CallModel;
import org.struts.model.SubCatModel;
import org.struts.utils.ConnectionPool;
public class CallService {
	public void listCategory(CallModel dm)
	{
		System.out.println(" i m here finally for categoryList");
		try
		{
		if(ConnectionPool.con==null)
			ConnectionPool.con=ConnectionPool.getConnection();
		Statement stmt = ConnectionPool.con.createStatement();
		ResultSet rs = stmt.executeQuery("SELECT categoryName,categoryId from category");
		while (rs.next()) {
			  String categoryId = rs.getString("categoryId");
			  String categoryName = rs.getString("categoryName");
			  if(dm.getCategoryId()!=null && dm.getCategoryId().equals(categoryId))
				  dm.setCategoryName(categoryName);
			  dm.addCategoryList(categoryId,categoryName);
			}
			dm.setSubCatList(new HashMap<String, String>());
			if(dm.getCategoryId()!=null)
			{
				  
				  Map<String,String> mapSubCat= new HashMap<String, String>();
				  String query="SELECT subcatId,subcatName from subcategory where categoryid=?";
				  System.out.println("dm.getCategoryId() is "+dm.getCategoryId());
				  PreparedStatement prepStmt=ConnectionPool.con.prepareStatement(query);
				  prepStmt.setString(1,dm.getCategoryId());
				  ResultSet rs1 = prepStmt.executeQuery();
				  while (rs1.next()) {
					  String subcatId = rs1.getString(1);
					  String subcatName = rs1.getString(2);
					  //System.out.println("subcatId "+subcatId +" and "+ subcatName);
					  mapSubCat.put(subcatId,subcatName);
				  }
				  dm.setSubCatList(mapSubCat);
				  System.out.println("size of array size is "+dm.getSubCatList().size());
			}
		}
		 catch (SQLException e1) {
				e1.printStackTrace();
			}
		 catch (Exception e1) {
				e1.printStackTrace();
		}
	 
	}
	}
