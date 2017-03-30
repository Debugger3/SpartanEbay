package org.struts.action;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import org.struts.model.FinalTestModel;
import org.struts.utils.ConnectionPool;

public class FinalTestAction2 {
	private ArrayList<FinalTestModel> arr;
	public String execute()
	{
		try{
			if(ConnectionPool.con==null)
				ConnectionPool.con=ConnectionPool.getConnection();
			arr=new ArrayList<FinalTestModel>();
			FinalTestModel temp=null;
			int i=1;
			float avgVal;
			String query="SELECT * from seller004";
  			PreparedStatement preparedStmt = ConnectionPool.con.prepareStatement(query);
			ResultSet rs = preparedStmt.executeQuery();
			while(rs.next())
			{
				temp=new FinalTestModel();
				temp.setSno(i);
				i++;
				temp.setSellerId(rs.getString("seller_id"));
				temp.setSellerName(rs.getString("name"));
				String query1="SELECT avg(cost) as avg from item where seller_id=?";
	  			PreparedStatement preparedStmt1 = ConnectionPool.con.prepareStatement(query1);
	  			preparedStmt1.setString(1, rs.getString("seller_id"));
				ResultSet rs1 = preparedStmt1.executeQuery();
				avgVal=0;
				if(rs1.next())
				{
					avgVal=rs1.getFloat("avg");
				}
				temp.setAvgPrice(avgVal);
				arr.add(temp);
			}
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
	public ArrayList<FinalTestModel> getArr() {
		return arr;
	}
	public void setArr(ArrayList<FinalTestModel> arr) {
		this.arr = arr;
	}
}
