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
import org.struts.model.AddToCartModel;
import org.struts.model.ItemByCatModel;
import org.struts.utils.ConnectionPool;

public class dealsService {

	HttpSession session = ServletActionContext.getRequest().getSession();
	int dealId=0;
	
	public void modelInitialization(ItemByCatModel tcm) {
		// TODO Auto-generated method stub
		
		String seller_id = session.getAttribute("user").toString();
		
		ArrayList<ItemByCatModel> catModel=new ArrayList<ItemByCatModel>();
		ArrayList<ItemByCatModel> catModel2=new ArrayList<ItemByCatModel>();
		ItemByCatModel tc=null;
		ItemByCatModel tc2=null;
		try
		{
		if(ConnectionPool.con==null)
			ConnectionPool.con=ConnectionPool.getConnection();
		
		Statement stmt = ConnectionPool.con.createStatement();
		System.out.println("subcatname "+tcm.getSubCatName());
		
		String query="Select itemId,item_name,item_desc,cost,seller_id,image,imagePath,discount,expiryOn,dealflag,subCat_Id,quantity FROM item where dealflag='Y' and seller_id='"+seller_id+"' and avail='Y'" ;

		query+=";";
		System.out.println(query);
		ResultSet rs = stmt.executeQuery(query);
		tcm.setItemList(new ArrayList<ItemByCatModel>());
		
		while (rs.next()) {
			tc=new ItemByCatModel();
			System.out.println(rs.getString(1)+"  "+rs.getString(2));
			tc.setItemId(rs.getString(1));
			tc.setItemName(rs.getString(2));
			tc.setItemDesc(rs.getString(3));
			tc.setCost(rs.getString(4));
			tc.setSeller_id(rs.getString(5));
			tc.setPhoto(rs.getBlob(6));
			tc.setImagePath(rs.getString(7));
			tc.setDiscount(rs.getInt(8));
			tc.setExpiryOn(rs.getString(9));
			//System.out.println(rs.getString(10));
			tc.setDealflag(rs.getBoolean(10));
			tc.setItemSubCatId(rs.getString(11));
			int quantity = rs.getInt("quantity");
			if(quantity==0)
			{
				tc.setQuantFlag("true");
			}
			System.out.println("quant flag--------->"+tc.getQuantFlag());
			Blob pic=rs.getBlob(6);
			if(pic!=null)
				{
				int blobLength = (int) pic.length();	
				tc.setBlobAsBytes(pic.getBytes(1, blobLength));
				tc.setImage64encode(new Base64().encodeToString(tc.getBlobAsBytes()));
				}
			catModel.add(tc);
			}
		
		
		/*ResultSet rs2 = stmt.executeQuery(query2);
		tcm.setItemList2(new ArrayList<ItemByCatModel>());
		
		while (rs2.next()) {
			tc2=new ItemByCatModel();
			tc2.setSubCatName(rs2.getString(1));
			catModel2.add(tc2);
			}*/
		
		}
		 catch (SQLException e1) {
		e1.printStackTrace();
	}
	catch (Exception e1) {
		e1.printStackTrace();
	}
	
		System.out.println("catModel.size() "+catModel.size());
		tcm.getItemList().addAll(catModel);
		//tcm.getItemList2().addAll(catModel2);
		//System.out.println(" sizze is "+tcm.getItemList().size()+"   "+tcm.getItemList().get(1).getItemId());

	}


	public void moreDeal(ItemByCatModel tcm) {

		System.out.println(tcm.getItemId1()+" "+tcm.getItemId2()+" "+tcm.getItemId3());
			
		String user=session.getAttribute("user").toString();
		
		ItemByCatModel tc=null;
		ItemByCatModel tc2=null;
		try
		{
		if(ConnectionPool.con==null)
			ConnectionPool.con=ConnectionPool.getConnection();
		
		Statement stmt = ConnectionPool.con.createStatement();
		int dealCost=0;
		String q="select cost from item where itemId in (?,?) ";
		PreparedStatement prepStatement = ConnectionPool.con.prepareStatement(q);
		prepStatement.setString(1, tcm.getItemId1());
		prepStatement.setString(2, tcm.getItemId2());
		
		

		System.out.println(q);

		ResultSet result = prepStatement.executeQuery();
		if (result != null) {
			while (result.next()) {
				System.out.println("helllll");
				dealCost=dealCost+result.getInt(1);
			}
		}
		if(tcm.getItemId1().equals(tcm.getItemId2())){
			dealCost=dealCost*2;
		}

		System.out.println("price======"+dealCost);
		
		String query="Insert into deals(item1,item2,item3,dealCost,sellerId) value(?,?,?,?,?)";
		PreparedStatement preparedStmt = ConnectionPool.con.prepareStatement(query);
			preparedStmt.setString (1,tcm.getItemId1() );
			preparedStmt.setString (2,tcm.getItemId2() );
			preparedStmt.setString (3,tcm.getItemId3() );
			preparedStmt.setInt (4,dealCost );
			preparedStmt.setString (5,user );

			preparedStmt.execute();
			
			
			System.out.println("here.........before selecting dealid");
			String qdealId="select dealId from deals where item1=? and item2=? and item3=? ";
			PreparedStatement prepStatementdealId = ConnectionPool.con.prepareStatement(qdealId);
			prepStatementdealId.setString(1, tcm.getItemId1());
			prepStatementdealId.setString(2, tcm.getItemId2());
			prepStatementdealId.setString (3,tcm.getItemId3() );

			ResultSet rsdealId = prepStatementdealId.executeQuery();
			if (rsdealId.next()) {
				dealId = rsdealId.getInt("dealId");
				System.out.println("deal id is------------"+dealId);
			}


			
			String qy="update item set avail='N' where itemId in (?,?,?)";
			PreparedStatement preparedStmt1 = ConnectionPool.con.prepareStatement(qy);
				preparedStmt1.setString (1,tcm.getItemId1() );
				preparedStmt1.setString (2,tcm.getItemId2() );
				preparedStmt1.setString (3,tcm.getItemId3() );
				preparedStmt1.execute();
			
				System.out.println("before updating deal id------------");
				
				//update but 2 get one free offer in db
				if(tcm.getItemId1().equals(tcm.getItemId2()) && tcm.getItemId1().equals(tcm.getItemId3()))
				{
					String qoffer="update item set buytwoOffer=? where itemId in (?,?,?)";
					PreparedStatement preparedStmtoffer = ConnectionPool.con.prepareStatement(qoffer);
					preparedStmtoffer.setString (1,"Y");
					preparedStmtoffer.setString (2,tcm.getItemId1() );
					preparedStmtoffer.setString (3,tcm.getItemId2() );
					preparedStmtoffer.setString (4,tcm.getItemId3() );
						//preparedStmt2.setString (5,session.getAttribute("user").toString());
					preparedStmtoffer.execute();
					
				}

				String qy1="update item set dealId=? where itemId in (?,?,?)";
				PreparedStatement preparedStmt2 = ConnectionPool.con.prepareStatement(qy1);
				preparedStmt2.setInt (1,dealId );
					preparedStmt2.setString (2,tcm.getItemId1() );
					preparedStmt2.setString (3,tcm.getItemId2() );
					preparedStmt2.setString (4,tcm.getItemId3() );
					//preparedStmt2.setString (5,session.getAttribute("user").toString());
					preparedStmt2.execute();
						}
		 catch (SQLException e1) {
		e1.printStackTrace();
	}
	catch (Exception e1) {
		e1.printStackTrace();
	}
	
	
		//System.out.println(" sizze is "+tcm.getItemList().size()+"   "+tcm.getItemList2().size());
}


	public void displayDeal(ItemByCatModel tcm) {
		
		ArrayList<ItemByCatModel> catModel=new ArrayList<ItemByCatModel>();
		
		ItemByCatModel tc=null;
		int i;
		try
		{
		if(ConnectionPool.con==null)
			ConnectionPool.con=ConnectionPool.getConnection();
		
		Statement stmt = ConnectionPool.con.createStatement();
		
		String query="select * from deals";
		PreparedStatement prepStatement = ConnectionPool.con.prepareStatement(query);
		ResultSet rs=prepStatement.executeQuery();
		PreparedStatement prepStmt;
		ResultSet rs1;
		tcm.setItemList(new ArrayList<ItemByCatModel>());
		while(rs.next()){
			i=0;
			while(i<3){
			String query1="Select itemId,item_name,item_desc,cost,seller_id,image,imagePath,discount,expiryOn,dealflag,subCat_Id,quantity FROM item  where itemId='"+rs.getString(i+2)+"'";
			System.out.println(rs.getString(1)+"  "+rs.getString(2)+" "+rs.getString(3)+" "+rs.getString(4));
			prepStmt=ConnectionPool.con.prepareStatement(query1);
			rs1=prepStmt.executeQuery();
			while (rs1.next()) {
				tc=new ItemByCatModel();
				tc.setItemId(rs1.getString(1));
				tc.setItemName(rs1.getString(2));
				tc.setItemDesc(rs1.getString(3));
				tc.setCost(rs1.getString(4));
				tc.setSeller_id(rs1.getString(5));
				tc.setPhoto(rs1.getBlob(6));
				tc.setImagePath(rs1.getString(7));
				tc.setDiscount(rs1.getInt(8));
				if(rs1.getString(9)!=null)
					tc.setExpiryOn(rs1.getString(9).toString());
				//System.out.println(rs.getString(10));
				tc.setDealflag(rs1.getBoolean(10));
				tc.setItemSubCatId(rs1.getString(11));
				//quantity flag
				int quantity = rs1.getInt("quantity");
				if(quantity==0)
				{
					tc.setQuantFlag("true");
				}
				System.out.println("i am here........"+tc.getQuantFlag());
				////
				Blob pic=rs1.getBlob(6);
				if(pic!=null)
					{
					int blobLength = (int) pic.length();	
					tc.setBlobAsBytes(pic.getBytes(1, blobLength));
					tc.setImage64encode(new Base64().encodeToString(tc.getBlobAsBytes()));
					}
				catModel.add(tc);
				}
				i++;
			}
			
					
		}
			
		}
		catch (SQLException e1) {
			e1.printStackTrace();
		}
		catch (Exception e1) {
			e1.printStackTrace();
		}

		tcm.getItemList().addAll(catModel);
		System.out.println("sizzzzze "+tcm.getItemList().size());
		 i=0;
		while(i<tcm.getItemList().size()){
			System.out.println(tcm.getItemList().get(i).getItemId());
			i++;
		}

		
		
	}


	public void dealCart(ItemByCatModel tcm) {
		
		System.out.println("in deal cart "+tcm.getDealCheck());
		String str=tcm.getDealCheck();
		String temp;
		
		String str1[]=str.split(",");
		ArrayList<String> ll=new ArrayList<String>();
		System.out.println("huygdcysb"+str1.length);
		try
		{
		if(ConnectionPool.con==null)
			ConnectionPool.con=ConnectionPool.getConnection();
		
		Statement stmt = ConnectionPool.con.createStatement();
		PreparedStatement prepStmt;
		ResultSet rs;
		String query;
		for(int i=0;i<str1.length;i++){
			temp=str1[i].trim();
			query="select item1,item2,item3 from deals where item1='"+temp+"'";
			System.out.println(query);
			prepStmt=ConnectionPool.con.prepareStatement(query);
			rs=prepStmt.executeQuery();
			while(rs.next()){
				
				ll.add(rs.getString(1));
				ll.add(rs.getString(2));
				ll.add(rs.getString(3));
				System.out.println(rs.getString(1)+" "+rs.getString(2)+" "+rs.getString(3));
			}
			
		}
		System.out.println(ll.size());

	
	}
	catch (SQLException e1) {
		e1.printStackTrace();
	}
	catch (Exception e1) {
		e1.printStackTrace();
	}
		System.out.println("kmcdojcio  "+ll.size());
		AddToCartModel.dealItemList=ll;
  }

public void deleteDeals(ItemByCatModel tcm) {
		
	String user = session.getAttribute("user").toString();
	
	ArrayList<String> dealList=tcm.getDealItemList();
	System.out.println("******* in delete deal and no of deals checked= "+tcm.getDealCheck());
	String str=tcm.getDealCheck();
	String temp;
	String q1;
	String str1[]=str.split(",");
	ArrayList<String> ll=new ArrayList<String>();
	System.out.println("huygdcysb"+str1.length);
	try
	{
	if(ConnectionPool.con==null)
		ConnectionPool.con=ConnectionPool.getConnection();
	
	Statement stmt = ConnectionPool.con.createStatement();
	PreparedStatement prepS1;
	ResultSet rs;
	int j=0;
	String[] str2=new String[str1.length*3];
	for(int i=0;i<str1.length;i++){
			temp=str1[i].trim();
			q1="select item1,item2,item3 from deals where item1='"+temp+"' and sellerId='"+user+"'";
			System.out.println(q1);
			 prepS1 = ConnectionPool.con.prepareStatement(q1);
			 rs=prepS1.executeQuery();
			while(rs.next()){
				str2[j++]=rs.getString("item1");
				str2[j++]=rs.getString("item2");
				str2[j++]=rs.getString("item3");
				
			}
			
			q1="delete from deals where item1='"+temp+"' and sellerId='"+user+"'";
			System.out.println(q1);
			prepS1 = ConnectionPool.con.prepareStatement(q1);
			prepS1.executeUpdate();
			//System.out.println(prepS1.executeQuery());
			}
		
			
		for(int i=0;i<str2.length;i++){
				q1="update item set avail='Y'  where itemId='"+str2[i]+"' and seller_id='"+user+"'";
				System.out.println(q1);
				prepS1 = ConnectionPool.con.prepareStatement(q1);
				prepS1.execute();
				q1="update item set buytwoOffer='N' where itemId='"+str2[i]+"' and seller_id='"+user+"'";
				System.out.println(q1);
				prepS1 = ConnectionPool.con.prepareStatement(q1);
				prepS1.execute();
				
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
