package org.struts.service;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import org.struts.model.AddSubCatModel;
import org.struts.model.SubCatModel;
import org.struts.utils.ConnectionPool;

public class AddSubCatService {
	public void categoryList(AddSubCatModel asc)
	{
		System.out.println(" i m here finally for categoryList");
		try
		{
		if(ConnectionPool.con==null)
			ConnectionPool.con=ConnectionPool.getConnection();
		Statement stmt = ConnectionPool.con.createStatement();
		ResultSet rs = stmt.executeQuery("SELECT categoryName,categoryId from category");
		SubCatModel s;
		asc.setCatList(new ArrayList<SubCatModel>());
		while (rs.next()) {
			  String categoryId = rs.getString("categoryId");
			  String categoryName = rs.getString("categoryName");
			  s=new SubCatModel();
			  s.setCatId(categoryId);
			  s.setCatName(categoryName);
			  s.setSubCat(null);
			  asc.getCatList().add(s);
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
