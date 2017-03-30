package org.struts.service;

import java.sql.Blob;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import javax.servlet.http.HttpSession;

import org.apache.struts2.ServletActionContext;
import org.apache.tomcat.util.codec.binary.Base64;
import org.struts.model.ItemByCatModel;
import org.struts.utils.ConnectionPool;

public class ItemByCatService {
	 HttpSession session = ServletActionContext.getRequest().getSession();

	 
		public void modelInitialization(ItemByCatModel tcm)
		{
			ArrayList<ItemByCatModel> catModel=new ArrayList<ItemByCatModel>();
			ItemByCatModel tc=null;
			try
			{
			if(ConnectionPool.con==null)
				ConnectionPool.con=ConnectionPool.getConnection();
			Statement stmt = ConnectionPool.con.createStatement();
			System.out.println("tcm.getItemSubCatId()  "+tcm.getItemSubCatId() );
			System.out.println("tcm.getItemCatId()  "+tcm.getItemCatId());
			
			
			// inc count here code
			
			
			
			String query="SELECT itemId,item_name,item_desc,cost,seller_id,image,imagePath,quantity FROM item where itemCatId="+tcm.getItemCatId();
			
			if(!tcm.getItemSubCatId().equals(""))
				query+=" and subCat_id = "+tcm.getItemSubCatId();
			query+=";";
			System.out.println(" query"+query+" ~~~tcm.getItemSubCatId()"+tcm.getItemSubCatId());
			ResultSet rs = stmt.executeQuery(query);
			tcm.setItemList(new ArrayList<ItemByCatModel>());
			while (rs.next()) {
				tc=new ItemByCatModel();
				String itemId = rs.getString(1);
				tc.setItemId(itemId);
				tc.setItemName(rs.getString(2));
				tc.setItemDesc(rs.getString(3));
				tc.setCost(rs.getString(4));
				tc.setSeller_id(rs.getString(5));
				tc.setPhoto(rs.getBlob(6));
				tc.setImagePath(rs.getString(7));
				int quantity = rs.getInt("quantity");
				Blob pic=rs.getBlob(6);
				if(pic!=null)
					{
					int blobLength = (int) pic.length();	
					tc.setBlobAsBytes(pic.getBytes(1, blobLength));
					tc.setImage64encode(new Base64().encodeToString(tc.getBlobAsBytes()));
					}
				
				//rating
				double rating=1.0 , roundoff=1.0;
				 String q1="Select sellerrating,ratingCount from seller where seller_id=?";
	        			PreparedStatement prepS1 = ConnectionPool.con.prepareStatement(q1);
	        			prepS1.setString(1, tc.getSeller_id());
	        			ResultSet rsRating = prepS1.executeQuery();
	        			if(rsRating.next())
	        			{
	        				tc.setRatingCount(rsRating.getInt("ratingCount"));
	        				rating = rsRating.getDouble("sellerrating");
	        				roundoff = rating;//Math.round((rating*10)/10);
	        				tc.setRating(roundoff);

	        			}
	        		
				//
				
				//cart flag....
				if(session.getAttribute("user") !=null)
				{
		        String user = session.getAttribute("user").toString();
		        int count=0;
				String query1="SELECT rowOrderId from orders where itemId=? and userId=? and orderFlag=?";
				//System.out.println("itemId---------------------------------->"+atcm.getItemId());
				PreparedStatement prepStmt=ConnectionPool.con.prepareStatement(query1);
				prepStmt.setString(1,itemId);
				prepStmt.setString(2,user);
				prepStmt.setString(3,"C");
				ResultSet rs1 = prepStmt.executeQuery();
				if(rs1.next())
				{
					count++;
					
				}
				if(quantity==0)
				{
					tc.setQuantFlag("true");
				
				}
				System.out.println("quant flag---------------------------------->"+tc.getQuantFlag());
				if(count>=1)
					tc.setCartFlag("true");
				else
					tc.setCartFlag("false");
				System.out.println("cartflaf is----------------------->"+tc.getCartFlag());
				}
				
				////
			
				catModel.add(tc);
				}
			}
			 catch (SQLException e1) {
			e1.printStackTrace();
		}
		catch (Exception e1) {
			e1.printStackTrace();
		}
			System.out.println("catModel.size() "+catModel.size());
			tcm.getItemList().addAll(catModel);
			System.out.println(" sizze is "+tcm.getItemList().size());
	}
		
		
		
		
		
		public void displayItemById(ItemByCatModel it)
		{
			try
			{
			if(ConnectionPool.con==null)
				ConnectionPool.con=ConnectionPool.getConnection();
			Statement stmt = ConnectionPool.con.createStatement();
			System.out.println("it.getItemId()  "+it.getItemId());
			String query="SELECT itemId,item_name,item_desc,cost,seller_id,image,s.subcatId,s.categoryId,s.subcatName,c.categoryName FROM item i, category c,subcategory s ";
			query=query+"where c.categoryId=s.categoryId  and s.subcatId=i.subCat_Id and i.itemId='"+it.getItemId()+"'";
			ResultSet rs = stmt.executeQuery(query);
				while (rs.next()) {
					it.setItemName(rs.getString("item_name"));
					it.setItemDesc(rs.getString("item_desc"));
					it.setCost(rs.getString("cost"));
					it.setSeller_id(rs.getString("seller_id"));
					Blob pic=rs.getBlob("image");
					if(pic!=null)
					{
						int blobLength = (int) pic.length();	
						it.setBlobAsBytes(pic.getBytes(1, blobLength));
						it.setImage64encode(new Base64().encodeToString(it.getBlobAsBytes()));
					}
					it.setItemCatId(rs.getString("categoryId"));
					it.setItemSubCatId(rs.getString("subcatId"));
					
					it.setCatName(rs.getString("subcatName"));
					it.setSubCatName(rs.getString("categoryName"));
				System.out.println("got record ryt");
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


