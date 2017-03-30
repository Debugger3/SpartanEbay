package org.struts.action;

import java.sql.Blob;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import org.apache.tomcat.util.codec.binary.Base64;
import org.struts.model.ItemByCatModel;
import org.struts.model.reportModel;
import org.struts.utils.ConnectionPool;

public class ReportActionByCat {
	private int subCatId;
	private int categoryId;
	private ArrayList<reportModel> itemList;
	public String execute()
	{
		try{
			  /*Class.forName("com.mysql.jdbc.Driver");
			  ConnectionPool.getConnection();
			  Statement stmt=ConnectionPool.con.createStatement();*/
			
			if(ConnectionPool.con==null)
	  			ConnectionPool.con=ConnectionPool.getConnection();
			
			System.out.println("Id are....."+getCategoryId()+"  "+getSubCatId());
			  String query ="select i.itemId,i.item_name,i.item_desc,i.cost,i.image,s.seller_id,s.shipping_address,s.name, c.categoryName from item i,seller s,category c where i.seller_id=s.seller_id and i.ItemCatId=c.categoryId and i.ItemCatId='"+getCategoryId()+"' and i.subCat_Id='"+getSubCatId()+"' order by c.categoryName ";
			  PreparedStatement stmt= ConnectionPool.con.prepareStatement(query);
			 // stmt.setInt(1, getCategoryId());
			 // stmt.setInt(2,getSubCatId());
			  //ResultSet rs=stmt.executeQuery("select item_name,itemId,image,cost from item where advertisementItem='Y' and image is not NULL");
			  ResultSet rs=stmt.executeQuery(query);
			  reportModel tc=null;
			  itemList=new ArrayList<reportModel>();
			    while(rs.next() )
			    {
			    	System.out.println("Comng in report action");
			    	tc=new reportModel();
			    	String item_name = rs.getString("item_name");
			  		String itemId = rs.getString("itemId");
			  		Blob pic = rs.getBlob("image");
			  		int cost=rs.getInt("cost");
			  		String itemDesc = rs.getString("item_desc");
			  		String seller_id = rs.getString("seller_id");
			  		String shipping_address =rs.getString("shipping_address");
			  		String name = rs.getString("name");
			  		String categoryName =  rs.getString("categoryName");
			  		if(pic!=null)
					{
					int blobLength = (int) pic.length();	
					byte[] blobAsBytes=pic.getBytes(1, blobLength);
					String image64encode=new Base64().encodeToString(blobAsBytes);
					tc.setImage64encode(image64encode);
					}
			  		tc.setItemId(itemId);
			  		tc.setItemName(item_name);
			  		tc.setCost(cost+"");
			  		tc.setCategoryName(categoryName);
			  		tc.setSeller_id(seller_id);
			  		tc.setName(name);
			  		tc.setShipping_address(shipping_address);
			  		tc.setItemDesc(itemDesc);
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
	public ArrayList<reportModel> getItemList() {
		System.out.println(" i m for list ");
		return itemList;
	}

	public void setItemList(ArrayList<reportModel> itemList) {
		this.itemList = itemList;
	}
	public int getSubCatId() {
		return subCatId;
	}
	public void setSubCatId(int subCatId) {
		this.subCatId = subCatId;
	}
	public int getCategoryId() {
		return categoryId;
	}
	public void setCategoryId(int categoryId) {
		this.categoryId = categoryId;
	}
}
