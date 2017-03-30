package org.struts.service;

import java.sql.Blob;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import org.apache.tomcat.util.codec.binary.Base64;
import org.struts.model.ItemByCatModel;
import org.struts.utils.ConnectionPool;

public class itemBySubCatService {

	public void modelInitialization(ItemByCatModel tcm) {
		// TODO Auto-generated method stub
		
		
		
		ArrayList<ItemByCatModel> catModel=new ArrayList<ItemByCatModel>();
		ArrayList<ItemByCatModel> catModel2=new ArrayList<ItemByCatModel>();
		
		ItemByCatModel tc=null;
		ItemByCatModel tc2=null;
		try
		{
		if(ConnectionPool.con==null)
			ConnectionPool.con=ConnectionPool.getConnection();
		
		Statement stmt = ConnectionPool.con.createStatement();
		
		System.out.println("tcm.isdealflag "+tcm.getDealflag());
		
		String query="Select itemId,item_name,item_desc,cost,seller_id,image,imagePath,discount,expiryOn,dealflag,subCat_Id FROM item where dealflag=" + tcm.getDealflag();
		
		String query2="Select distinct subcatName,subcatId from subcategory ";
		
		query2+=";";
		
		query+=";";
		
		ResultSet rs = stmt.executeQuery(query);
		tcm.setItemList(new ArrayList<ItemByCatModel>());
		
		while (rs.next()) {
			tc=new ItemByCatModel();
			tc.setItemId(rs.getString(1));
			tc.setItemName(rs.getString(2));
			tc.setItemDesc(rs.getString(3));
			tc.setCost(rs.getString(4));
			tc.setSeller_id(rs.getString(5));
			tc.setPhoto(rs.getBlob(6));
			tc.setImagePath(rs.getString(7));
			tc.setDiscount(rs.getInt(8));
			tc.setExpiryOn(rs.getString(9));
			tc.setDealflag(rs.getBoolean(10));
			tc.setItemSubCatId(rs.getString(11));
			Blob pic=rs.getBlob(6);
			if(pic!=null)
				{
				int blobLength = (int) pic.length();	
				tc.setBlobAsBytes(pic.getBytes(1, blobLength));
				tc.setImage64encode(new Base64().encodeToString(tc.getBlobAsBytes()));
				}
			catModel.add(tc);
			}
		
		
		ResultSet rs2 = stmt.executeQuery(query2);
		tcm.setItemList2(new ArrayList<ItemByCatModel>());
		
		while (rs2.next()) {
			tc2=new ItemByCatModel();
			tc2.setSubCatName(rs2.getString(1));
			tc2.setItemSubCatId(rs2.getString(2));
			catModel2.add(tc2);
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
		tcm.getItemList2().addAll(catModel2);
		System.out.println(" sizze is "+tcm.getItemList().size()+"   "+tcm.getItemList2());

	}
	}

