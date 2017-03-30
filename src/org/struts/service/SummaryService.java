package org.struts.service;

import java.sql.Blob;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.servlet.http.HttpSession;

import org.apache.struts2.ServletActionContext;
import org.apache.tomcat.util.codec.binary.Base64;
import org.struts.model.AddToCartModel;
import org.struts.model.Test;
import org.struts.utils.ConnectionPool;

public class SummaryService {
	
	int total_cost=0,total_discount=0,final_total_cost=0;
	int flag=0,discount=0,dealId=0;
	String dealFlag="N",item1Flag="F",item2Flag="F";
	String item1="",item2="",item3="";
	 HttpSession session = ServletActionContext.getRequest().getSession();
	 

	public void modelInitialization(AddToCartModel atcm)
	{
		ArrayList<Test> catModel=new ArrayList<Test>();
		Test atc=null;
		try
		{
		if(ConnectionPool.con==null)
			ConnectionPool.con=ConnectionPool.getConnection();
		//String tst=atcm.getItemId();
		//int cost = atcm.getCost();
		//String seller_id = atcm.getSellerId();
		// HttpSession session = ServletActionContext.getRequest().getSession();
        String user = session.getAttribute("user").toString();
        
    
		
		String q2 = "SELECT itemId, quantity,price,dealId FROM orders where userId=? and orderFlag=?";
		PreparedStatement ps1=ConnectionPool.con.prepareStatement(q2);
		ps1.setString(1,user);
		ps1.setString(2,"C");
		ResultSet rs2 = ps1.executeQuery();
		String queryvat="select vatTax from vat where idupdate=1";
		PreparedStatement prepStmtvat=ConnectionPool.con.prepareStatement(queryvat);
		//prepStmtvat.setInt(1, 1);
		System.out.println(queryvat);
		ResultSet rsvat = prepStmtvat.executeQuery();
		System.out.println(rsvat);
		if(rsvat.next())
		{
			float taxtemp=((float)rsvat.getInt(1))/100;
			//	  atcm.setTax(taxtemp);
		}
		while(rs2.next())
		{
			String itemId= rs2.getString("itemId");
			int quantity = rs2.getInt("quantity");
			int price=rs2.getInt("price");
			String query="SELECT item_name,item_desc,cost,seller_id,image,imagePath,dealFlag FROM item where itemId=?";
			PreparedStatement prepStmt=ConnectionPool.con.prepareStatement(query);
			prepStmt.setString(1,itemId);
			ResultSet rs = prepStmt.executeQuery();
			System.out.println(" query"+query);
			//		ResultSet rs = stmt.executeQuery(query);
			//		atcm.setItemList(new ArrayList<Test>());
			while (rs.next()) {
				System.out.println("Inside!!!!!!!!!!!!!!!!!!!!!!");
				atc=new Test();
				atc.setItemId(itemId);
				atc.setItemName(rs.getString("item_name"));
				atc.setItemDesc(rs.getString("item_desc"));
				//	atc.setCost(rs.getString("cost"));
				atc.setSeller_id(rs.getString("seller_id"));
				atc.setPhoto(rs.getBlob("image"));
				atc.setImagePath(rs.getString("imagePath"));
				Blob pic=rs.getBlob("image");
				if(pic!=null)
				{
				int blobLength = (int) pic.length();	
				atc.setBlobAsBytes(pic.getBytes(1, blobLength));
				atc.setImage64encode(new Base64().encodeToString(atc.getBlobAsBytes()));
				}
				int costperItem=Integer.parseInt(rs.getString("cost"));
				int costFinal = quantity*costperItem;
				String q1="Select discount,expiryOn from item where itemId=?";
				
				PreparedStatement prepS1 = ConnectionPool.con.prepareStatement(q1);
				prepS1.setString(1, itemId);
				ResultSet rs1 = prepS1.executeQuery();
				if(rs1.next())
				{
				
					discount = rs1.getInt("discount");
				}
				if(price==0)
				{
					costFinal=0;
					discount=0;
				}
				atc.setCost(costFinal);
				total_cost = total_cost + costFinal;
				total_discount=total_discount+(costFinal*discount)/100;
				System.out.println("total discount********"+total_discount);
				atc.setDiscountMoney((costFinal*discount)/100);
				
				if(discount>0 && price!=0)
				{
					costFinal =costFinal-( (costFinal*discount)/100);
					atc.setOffer("");
				}
				else if(price==0)
				{
					atc.setCost(0);
					atc.setDiscountMoney(0);
					costFinal =0;
					atc.setOffer("U get this item for free.....");
				}
				atc.setFinalCost(costFinal);
				
				final_total_cost = final_total_cost + costFinal;
				atc.setQuantity(quantity);
				catModel.add(atc);
				atcm.setFinal_total_cost(final_total_cost);
				atcm.setTotal_discount(total_discount);
				//System.out.println("quantity value is........>>>>>addtocart"+quantity);
			
				}
			}
		}
		catch (SQLException e1) {
			e1.printStackTrace();
		}
		catch (Exception e1) {
			e1.printStackTrace();
		}
		//	System.out.println("catModel.size() "+catModel.size());
		atcm.addItemIdList(catModel);
		atcm.setTotal_cost(total_cost);
		System.out.println(" sizze is "+atcm.getItemList().size());
		System.out.println("cost is--------->"+total_cost);
        session.setAttribute("cost",final_total_cost*(1+atcm.getTax()));
	}
}

