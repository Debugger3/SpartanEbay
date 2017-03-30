package org.struts.action;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import org.struts.model.FinalTestModel;
import org.struts.utils.ConnectionPool;

public class FinalTestAction1 {
	private String weight;
	private ArrayList<FinalTestModel> arr;
	public ArrayList<FinalTestModel> getArr() {
		return arr;
	}
	public void setArr(ArrayList<FinalTestModel> arr) {
		this.arr = arr;
	}


	private ArrayList<Integer> in;
	public String execute()
	{
		arr=new ArrayList<FinalTestModel>();
		FinalTestModel temp=null;
		try{
			if(ConnectionPool.con==null)
				ConnectionPool.con=ConnectionPool.getConnection();
			System.out.println("wieght "+weight);
			String query="SELECT * from item where dealId is not null and weight>=?";
  			PreparedStatement preparedStmt = ConnectionPool.con.prepareStatement(query);
  			preparedStmt.setInt(1,Integer.parseInt(getWeight()));
			ResultSet rs = preparedStmt.executeQuery();
			int i=1;
			while(rs.next())
			{
				String query1="SELECT * from deals where dealId=? and item3=?";
	  			PreparedStatement preparedStmt1 = ConnectionPool.con.prepareStatement(query1);
	  			preparedStmt1.setString(1,rs.getString("dealId"));
	  			preparedStmt1.setString(2,rs.getString("itemId"));

				ResultSet rs1 = preparedStmt1.executeQuery();
				if(rs1.next())
				{
					System.out.println("do nothing ");
				}
				else
				{
					String query2="SELECT * from deals where dealId=?";
		  			PreparedStatement preparedStmt2 = ConnectionPool.con.prepareStatement(query2);
		  			preparedStmt2.setString(1,rs.getString("dealId"));
		  			

					ResultSet rs2 = preparedStmt2.executeQuery();
					while(rs2.next())
					{
						temp=new FinalTestModel();
						temp.setSno(i);
						i++;
						temp.setItemId(rs.getString("itemId")); 
						temp.setDealId(rs.getString("dealId"));
						temp.setFreeItemId(rs2.getString("item3"));
						arr.add(temp);
					}
				}
			}
			System.out.println(arr.size());
		}
		 catch (SQLException e1) {
				e1.printStackTrace();
				return "error";
			}
		 catch (Exception e1) {
				e1.printStackTrace();
				return "error";
		}
		
		return "success";
	}
	public String getWeight() {
		return weight;
	}
	public void setWeight(String weight) {
		this.weight = weight;
	}
	
	
}
