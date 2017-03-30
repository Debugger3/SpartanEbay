package org.struts.service;

import java.io.*;
import java.sql.*;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Locale;

import org.struts.model.*;
import org.struts.utils.ConnectionPool;
public class AddItemService {
	
	
	public boolean addItem(AddItemModel am) //throws ParseException
	{
		 try
	  		{
			 
	  			if(ConnectionPool.con==null)
	  				ConnectionPool.con=ConnectionPool.getConnection();
	  			int advId=0;
	  			String q="INSERT INTO advertisement(startDate,endDate,adv_id,cost ) VALUES (?,?,?,?)";
	  			PreparedStatement prepStmt = ConnectionPool.con.prepareStatement(q);
	  			DateFormat formatter = new SimpleDateFormat("YYYY-MM-DD");
	  			System.out.println(" am.getStartDate() "+am.getStartDate().substring(0, 10));
	  			prepStmt.setDate(1, new java.sql.Date(formatter.parse(am.getStartDate().substring(0, 10)).getTime()));
	  			prepStmt.setDate(2, new java.sql.Date(formatter.parse(am.getEndDate().substring(0, 10)).getTime()));
	  			prepStmt.setString (3, am.getItemId());
	  			prepStmt.setInt (4, am.getAdv_Cost());
	  			prepStmt.execute();
	  			
	  			String queryAdv="Select adv_row from advertisement where adv_id=?";
	  			PreparedStatement prepStmtAdv = ConnectionPool.con.prepareStatement(queryAdv);
	  			prepStmtAdv.setString(1, am.getItemId());
	  			ResultSet rsAdv = prepStmtAdv.executeQuery();
	  			if(rsAdv.next())
	  				advId=rsAdv.getInt("adv_row");
	  			String query="INSERT INTO item(item_name,item_desc,seller_id,image,cost,subCat_Id,field1,field2,advertisementItem,itemId,imagePath,ItemCatId,dealFlag,discount,expiryOn,quantity,numberofitemsold,warrantyperiod,color,weight,brand,expirydate,conditionoftheitem,avail,advtid ) VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
	  			PreparedStatement preparedStmt = ConnectionPool.con.prepareStatement(query);
	  			preparedStmt.setString (1, am.getItemName());
	  			preparedStmt.setString (2, am.getItemDesc());
	  			preparedStmt.setString(3, am.getSellerId());
	  			if(am.getPic()!=null)
	    		{
	  				FileInputStream fis=new FileInputStream(am.getPic());
	  				preparedStmt.setBinaryStream(4,fis,(int)am.getPic().length());
	  				preparedStmt.setString(11,am.getPic().getAbsolutePath());
	    		}
	  			else
	  				{
	  				preparedStmt.setBinaryStream(4,null);
	  				preparedStmt.setString(11,null);
	  				}
	  			preparedStmt.setInt(5,am.getPrice());
	  			//System.out.println("am.getSubCatId()"+am.getSubCatId());
	  			preparedStmt.setString(6,am.getSubCatId());
	  			preparedStmt.setString(7,am.getAddField1());
	  			preparedStmt.setString(8,am.getAddField2()); 
	  			preparedStmt.setString(9,am.getAdvCheck());
	  			preparedStmt.setString(10,am.getItemId());
	  			preparedStmt.setInt(12,Integer.parseInt(am.getCategoryId()));
	  			System.out.println("am.getDealFlag() "+am.getDealFlag());
	  			//preparedStmt.setString(13,am.getDealFlag());
	  			System.out.println("i m ok here");
	  			preparedStmt.setString(13,am.getDealFlag());
	  			System.out.println("failed?");
	  			System.out.println(" am.getDiscount() "+ am.getDiscount());
	  			preparedStmt.setInt(14, am.getDiscount());
	  			
	  			preparedStmt.setDate(15, new java.sql.Date(formatter.parse(am.getExpiryOn().substring(0, 10)).getTime()));
	  			//preparedStmt.setString(15, am.getExpireOn());
	  			preparedStmt.setInt(16, am.getQuantity());
	  			preparedStmt.setString(17, "0");
	  			preparedStmt.setString(18, am.getWarranty());
	  			preparedStmt.setString(19, am.getColor());
	  			preparedStmt.setString(20, am.getWeight());
	  			preparedStmt.setString(21, am.getBrand());
	  			System.out.println("am.getExpireOn() "+am.getExpiryOn());
	  			preparedStmt.setString(22, am.getExpiryOn());
	  			preparedStmt.setString(23, am.getCondition());
	  			if("Y".equals(am.getDealFlag())){
	  				preparedStmt.setString(24,"Y");
	  				System.out.println(" i m setting avail to Y");
	  			}
	  			else{
	  				preparedStmt.setString(24,"N");
	  			}
	  			preparedStmt.setInt(25, advId);
	  			preparedStmt.execute();
	  			
	  			
	  			String queryAttribute ="INSERT INTO attribute(itemId,attrkey1,attrval1,attrkey2,attrval2,attrkey3,attrval3,attrkey4,attrval4,attrkey5,attrval5)VALUES(?,?,?,?,?,?,?,?,?,?,?)";
	  			PreparedStatement preparedStmtAttr = ConnectionPool.con.prepareStatement(queryAttribute);
	  			preparedStmtAttr.setString(1, am.getItemId());
	  			preparedStmtAttr.setString(2, am.getAttrkey1());
	  			preparedStmtAttr.setString(3, am.getAttrval1());
	  			preparedStmtAttr.setString(4, am.getAttrkey2());
	  			preparedStmtAttr.setString(5, am.getAttrval2());
	  			preparedStmtAttr.setString(6, am.getAttrkey3());
	  			preparedStmtAttr.setString(7, am.getAttrval3());
	  			preparedStmtAttr.setString(8, am.getAttrkey4());
	  			preparedStmtAttr.setString(9, am.getAttrval4());
	  			preparedStmtAttr.setString(10, am.getAttrkey5());
	  			preparedStmtAttr.setString(11, am.getAttrval5());
	  			preparedStmtAttr.execute();

	  			
	  			
	  			
	  			
	  			return true;
	  			}
			 catch (SQLException e1) {
					e1.printStackTrace();
				}
			 catch (Exception e1) {
					e1.printStackTrace();
			}
		 return false;
	}
	public boolean validate(AddItemModel am) 
	{
		try
		{
		String query1="SELECT count(*) from item where itemId=?";
		PreparedStatement prepStmt=ConnectionPool.con.prepareStatement(query1);
		prepStmt.setString(1,am.getItemId());
		ResultSet rs1 = prepStmt.executeQuery();
		if(rs1.next())
		{
			int count=rs1.getInt(1);
			if(count==1)
				return false;
			else return true;
		}
		}
		 catch (SQLException e1) {
				e1.printStackTrace();
			}
		 catch (Exception e1) {
				e1.printStackTrace();
		}
		return false;
	}
	public void listCategory(AddItemModel dm)
	{
		System.out.println(" i m here finally for categoryList");
		System.out.println( "dm vaue "+dm.getItemId()+ " ~ "+dm.getItemDesc()+" ~ "+dm.getItemName());
		try
		{
		if(ConnectionPool.con==null)
			ConnectionPool.con=ConnectionPool.getConnection();
		if(dm.getCategoryList()==null)
		{
		Statement stmt = ConnectionPool.con.createStatement();
		ResultSet rs = stmt.executeQuery("SELECT categoryName,categoryId from category");
		while (rs.next()) {
			  String categoryId = rs.getString("categoryId");
			  String categoryName = rs.getString("categoryName");
			  if(dm.getCategoryId()!=null && dm.getCategoryId().equals(categoryId))
				  dm.setCategoryName(categoryName);
			  dm.addCategoryList(categoryId,categoryName);
			}
			

		}
		System.out.println(dm.getSubCatId()+ " category id in services "+dm.getCategoryId());
		}
		
		 catch (SQLException e1) {
				e1.printStackTrace();
			}
		 catch (Exception e1) {
				e1.printStackTrace();
		}
	 
	}
}

