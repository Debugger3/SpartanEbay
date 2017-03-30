package org.struts.service;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import org.struts.utils.ConnectionPool;
import org.struts.model.SubCatModel;
import org.struts.model.CategoryModel;

public class TestActionService {
	
	public void insert(CategoryModel tm)
	{
		System.out.println("I am inside TestActionService");
		try
		{
			if(ConnectionPool.con==null)
				ConnectionPool.con=ConnectionPool.getConnection();
			Statement stmt = ConnectionPool.con.createStatement();
			ResultSet rs = stmt.executeQuery("SELECT categoryId,categoryDesc from category");
			System.out.println("i m in test action");
			tm.setSubCatList(new ArrayList<SubCatModel>());
			while (rs.next()) {
				int catId = rs.getInt(1);
				String catName = rs.getString(2);
				String query="SELECT subcatId, subcatDesc from subcategory where categoryid=?";
				PreparedStatement prepStmt=ConnectionPool.con.prepareStatement(query);
				prepStmt.setInt(1,catId);
				ResultSet rs1 = prepStmt.executeQuery();
				SubCatModel st=new SubCatModel();  
				st.setCatName(catName);
				st.setCatId(catId+"");
				st.setSubCat(new ArrayList<Map<String, String>>());
				Map<String,String> myMap1 = new HashMap<String, String>();
				while (rs1.next()) {
					myMap1.put(rs1.getString(1),rs1.getString(2));
				  }
			    //System.out.println("New List");
				/*for (Map.Entry<String, String> entry : myMap1.entrySet())
				{
				   // System.out.println("it is "+entry.getKey() + "/" + entry.getValue());
				}*/
				st.getSubCat().add(myMap1);
				tm.getSubCatList().add(st);
				}
			}
		 catch (SQLException e1) {
				e1.printStackTrace();
			}
		 catch (Exception e2) {
				e2.printStackTrace();
		}
		System.out.println("catList size is  in TestActionService:"+tm.getSubCatList().size());
	}
}