package org.struts.service;

import java.sql.*;
import java.util.ArrayList;

import org.struts.model.*;
import org.struts.utils.ConnectionPool;
public class SellService {
	ArrayList<SellModel> reportModel=new ArrayList<SellModel>();
	SellModel sml=null;
	public boolean findBySellerId(RegisterModel rm) {
		if (ConnectionPool.con != null) {
			try {
				PreparedStatement prepStatement = ConnectionPool.con.prepareStatement("select count(*) from seller where seller_id = ?");
				prepStatement.setString(1, rm.getSellerId());

				ResultSet result = prepStatement.executeQuery();
				if (result != null) {
					while (result.next()) {
						if (result.getInt(1) == 1) {
							System.out.println("bbcudbuwbew"+result.getInt(1));
							return true;
						}
					}
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		System.out.println("bbcudbuwbew  outside");

		return false;
	}
	public void showReport(SellModel sm)
	{
		 try
  		{
  			if(ConnectionPool.con==null)
  			ConnectionPool.con=ConnectionPool.getConnection();
  			String query="select * from (select itemId,item_name,weight,shipping_address,seller.name,item.sellerId097 from item,seller where item.sellerId097=seller.seller_id )as o where o.weight!='' and o.sellerId097=?" ; 
  			PreparedStatement preparedStmt = ConnectionPool.con.prepareStatement(query);
  			preparedStmt.setString (1, sm.getSellerId());
  			ResultSet rs=preparedStmt.executeQuery();
  			
  			while(rs.next() )
  			{
  				sml=new SellModel();
  				sm.setSellerName(rs.getString("name"));
  				sml.setItemId(rs.getString("itemId"));
  				sml.setItemName(rs.getString("item_name"));
  				sml.setItemWeight(rs.getString("weight"));
  				sml.setSellerAddress(rs.getString("shipping_address"));
  			
  				System.out.println("seller address is"+rs.getString("shipping_address"));
  			
  				System.out.println("Seller nameis......."+rs.getString("name"));
  				
  				
  				reportModel.add(sml);
  				
  				
  			}
  		/*	String q="select name from seller where seller_id=?" ; 
  			PreparedStatement ps = ConnectionPool.con.prepareStatement(q);
  			ps.setString (1, sm.getSellerId());
  			ResultSet rs1=ps.executeQuery();
  		//	System.out.println("seller name is"+rs.getString("seller.name"));
  			sm.setSellerName(rs1.getString("name"));
  		*/	System.out.println("sellerName is.........."+sm.getSellerName());
  			sm.setReportList(reportModel);
  			
			
  			}
		 catch (SQLException e1) {
				e1.printStackTrace();
			}
		 catch (Exception e1) {
				e1.printStackTrace();
		}
	}
	
}