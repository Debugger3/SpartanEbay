package org.struts.action;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import org.struts.model.CategoryModel;
import org.struts.model.SubCatModel;
import org.struts.utils.ConnectionPool;

import com.opensymphony.xwork2.ModelDriven;

public class DealAction implements ModelDriven{
	CategoryModel cm=new CategoryModel();
 public String execute()
 {
	 try
		{
			if(ConnectionPool.con==null)
				ConnectionPool.con=ConnectionPool.getConnection();
			Statement stmt = ConnectionPool.con.createStatement();
			ResultSet rs = stmt.executeQuery("select max(noOfClicks) clicks,categoryId,categoryName from ooad_project.category group by categoryId order by clicks desc LIMIT 5");
			System.out.println("i m in test action");
			int counter=0;
			cm.setSubCatList(new ArrayList<SubCatModel>());
			while (rs.next()) {
				int catId = rs.getInt(2);
				String catName = rs.getString(3);
				String query="SELECT subcatId, subcatDesc from subcategory where categoryid=?";
				PreparedStatement prepStmt=ConnectionPool.con.prepareStatement(query);
				prepStmt.setInt(1,catId);
				System.out.println("rs.getInt(1) "+rs.getInt(1));
				counter=rs.getInt(1);
				ResultSet rs1 = prepStmt.executeQuery();
				SubCatModel st=new SubCatModel();  
				st.setCatName(catName);
				st.setCatId(catId+"");
				st.setSubCat(new ArrayList<Map<String, String>>());
				st.setCount(counter);
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
			
				cm.getSubCatList().add(st);
				//cm.setCount(counter);
				}
			}
		 catch (SQLException e1) {
				e1.printStackTrace();
			}
		 catch (Exception e2) {
				e2.printStackTrace();
		}
		System.out.println("catList size is  in DealActionService:"+cm.getSubCatList().size());
  
	 return "success";
 }

@Override
public Object getModel() {
	// TODO Auto-generated method stub
	return cm;
}


}
