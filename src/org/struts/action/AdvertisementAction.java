package org.struts.action;

import java.sql.*;
import java.util.ArrayList;

import org.apache.tomcat.util.codec.binary.Base64;
import org.struts.model.ItemByCatModel;
import org.struts.utils.ConnectionPool;
public class AdvertisementAction{
	
	private ArrayList<ItemByCatModel> itemList;
	ItemByCatModel tc;
	public String execute()
	{
		try{
		  Class.forName("com.mysql.jdbc.Driver");
		  ConnectionPool.getConnection();
		  Statement stmt=ConnectionPool.con.createStatement();
		  ResultSet rs=stmt.executeQuery("select item_name,itemId,image,cost,dealFlag,discount,seller_id from item where advertisementItem='Y' and image is not NULL");
		   tc=null;
		  itemList=new ArrayList<ItemByCatModel>();
		    while(rs.next() )
		    {
		    	tc=new ItemByCatModel();
		    	String name = rs.getString("item_name");
		  		String itemId = rs.getString("itemId");
		  		Blob pic = rs.getBlob("image");
		  		int cost=rs.getInt("cost");
		  		if(pic!=null)
				{
				int blobLength = (int) pic.length();	
				byte[] blobAsBytes=pic.getBytes(1, blobLength);
				String image64encode=new Base64().encodeToString(blobAsBytes);
				tc.setImage64encode(image64encode);
				}
		  		tc.setItemId(itemId);
		  		tc.setItemName(name);
		  		tc.setCost(cost+"");
		  		String dealFlag=rs.getString("dealFlag");
		  		if(dealFlag.equals("Y"))
		  			tc.setDealflag(true);
		  		else
		  			tc.setDealflag(false);
		  		
		  		tc.setDiscount(rs.getInt("discount"));
		  		tc.setSeller_id(rs.getString("seller_id"));
		  		itemList.add(tc);
		    }
		    }
		 catch (SQLException e1) {
				e1.printStackTrace();
			}
			catch (Exception e1) {
				e1.printStackTrace();
			}
		return "success";
	}

	

	public ArrayList<ItemByCatModel> getItemList() {
		return itemList;
	}

	public void setItemList(ArrayList<ItemByCatModel> itemList) {
		this.itemList = itemList;
	}

}
