package org.struts.action;

import java.sql.Blob;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import org.struts.model.MyreportModel;
import org.struts.utils.ConnectionPool;

import com.opensymphony.xwork2.ModelDriven;

public class MyReportAction implements ModelDriven {
	  	
	MyreportModel tcm=new MyreportModel();
			public String execute()
			{
				try{
				MyreportModel tc=null;
				ArrayList<MyreportModel> reportModel=new ArrayList<MyreportModel>();
				if(ConnectionPool.con==null)
		  			ConnectionPool.con=ConnectionPool.getConnection();
				 String query="select item.itemId,item.item_name,seller.seller_id,seller.shipping_address from seller,category,item where (categoryId=ItemCatId) and (item.seller_id=seller.seller_id) and categoryId="+tcm.getReportcat()+";";
		         PreparedStatement preparedStmt = ConnectionPool.con.prepareStatement(query);
		       System.out.println(query);
		       ResultSet rs = preparedStmt.executeQuery(query);
		     /*  tcm.setReportList(new ArrayList<MyreportModel>());
*/		       while(rs.next())
		       {
						tc=new MyreportModel();
						tc.setItemId(rs.getString(1));
						tc.setItemname(rs.getString(2));
						tc.setSellerid(rs.getString(3));
						
						tc.setSellerAddress(rs.getString(4));
						reportModel.add(tc);
						 System.out.println(tc.getItemname());
		       }
				tcm.setReportList(reportModel);
				System.out.println(reportModel.size());
				System.out.println(tcm.getReportList().size());
			}
			
			catch (SQLException e1) {
				e1.printStackTrace();
			}
			catch (Exception e1) {
				e1.printStackTrace();
			}
				return "success";
			}
			public Object getModel() {
				// TODO Auto-generated method stub
				return tcm;
			}
}
