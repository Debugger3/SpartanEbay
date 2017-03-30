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
import org.struts.model.AddItemModel;
import org.struts.model.AddToCartModel;
import org.struts.model.ItemByCatModel;
import org.struts.model.Test;
import org.struts.utils.ConnectionPool;

public class AddToCartService {
	
	float total_cost=0,total_discount=0,final_total_cost=0;
	int flag=0,discount=0;
	String dealFlag="N",item1Flag="F",item2Flag="F";
	String item1="",item2="",item3="";
	HttpSession session = ServletActionContext.getRequest().getSession();
	String flagWhere="";
	 

	public void modelInitialization(AddToCartModel atcm)
	{
		int dealId=0;
		ArrayList<Test> catModel=new ArrayList<Test>();
		Test atc=null;
		try
		{
		if(ConnectionPool.con==null)
			ConnectionPool.con=ConnectionPool.getConnection();
		System.out.println("failing where");
		String tst=atcm.getItemId();
		int cost = atcm.getCost();
		String seller_id = atcm.getSellerId();
		// HttpSession session = ServletActionContext.getRequest().getSession();
         String user = session.getAttribute("user").toString();
        
         if(tst!=null)
         {
        	 
        	 boolean result = valid(atcm);
        	 if(result)
        	 {
        		 String q1="Select discount,expiryOn,dealFlag,dealId from item where itemId=?";
        		 PreparedStatement prepS1 = ConnectionPool.con.prepareStatement(q1);
        		 prepS1.setString(1, tst);
        		 ResultSet rs1 = prepS1.executeQuery();
        			if(rs1.next())
        			{
        			
        				discount = rs1.getInt("discount");
        				dealFlag = rs1.getString("dealFlag");
        				dealId = rs1.getInt("dealId");
        			}
        			System.out.println("dealflag============"+dealFlag);
        		if(discount>0)
     			{
     				cost =cost-( (cost*discount)/100);
     			}
    
        		 System.out.println("inserting from here--------------"+atcm.getItemId()+"selllerid========="+atcm.getSellerId());
        		 
        	String q="INSERT INTO orders(userId , itemId , sellerId , quantity , orderFlag , price,dealId) VALUES (?,?,?,?,?,?,?)";
			PreparedStatement prepS = ConnectionPool.con.prepareStatement(q);
			prepS.setString(1, user);
			prepS.setString(2, tst);
			prepS.setString(3, seller_id);
			prepS.setInt(4, 1);
			prepS.setString(5,"C");
			prepS.setInt(6,cost);
			prepS.setInt(7,dealId);

		prepS.execute();
		
		//call 
		System.out.println("deal flag before check deal"+dealFlag);
				if(dealFlag.equals("Y"))
				{
					System.out.println(" deal flag is Y");
					flagWhere="model";
					checkDeal(atcm);
				}
		
        	 }
        /*	 else
        	 {
        		 System.out.println("here inside else loop");
        		 String q="Update orders set quantity = quantity+? where userId=? and itemId=?";
     			PreparedStatement prepS = ConnectionPool.con.prepareStatement(q);
     			prepS.setInt(1, 1);
     			prepS.setString(2, user);
     			prepS.setString(3, tst);
     		prepS.execute();
     		
        	 }*/
         }
		
		String q2 = "SELECT itemId , quantity,price FROM orders where userId=? and orderFlag=?";
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
			int taxtemp=rsvat.getInt(1);
			atcm.setTax(taxtemp);
		}
		while(rs2.next())
		{
			String itemId= rs2.getString("itemId");
			int quantity = rs2.getInt("quantity");
			int price = rs2.getInt("price");
			if(price!=0)
			{
				String query="SELECT item_name,item_desc,cost,seller_id,image,imagePath,quantity FROM item where itemId=?";
				query+=";";
				PreparedStatement prepStmt=ConnectionPool.con.prepareStatement(query);
				prepStmt.setString(1,itemId);
				ResultSet rs = prepStmt.executeQuery();
				System.out.println(" query"+query);
				//	ResultSet rs = stmt.executeQuery(query);
				//		atcm.setItemList(new ArrayList<Test>());
				while (rs.next()) {
					System.out.println("Inside!!!!!!!!!!!!!!!!!!!!!!");
					atc=new Test();
					atc.setItemId(itemId);
					atc.setItemName(rs.getString("item_name"));
					atc.setItemDesc(rs.getString("item_desc"));
					//	atc.setCost(rs.getString("cost"));
					atc.setSeller_id(rs.getString("seller_id"));
					atc.setTotal_quant(rs.getInt("quantity"));
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
						//System.out.println("inside new code....");
						discount = rs1.getInt("discount");
						atc.setDiscount(discount);
					}
					atc.setCost(costFinal);
					total_cost = total_cost + costFinal;
					total_discount=total_discount+(costFinal*discount)/100;
					System.out.println("total discount********"+total_discount);
					atc.setDiscountMoney((costFinal*discount)/100);
					if(discount>0)
					{
						costFinal =costFinal-( (costFinal*discount)/100);
					}
					atc.setFinalCost(costFinal);
					final_total_cost = final_total_cost + costFinal;
					atc.setQuantity(quantity);
					catModel.add(atc);
					atcm.setFinal_total_cost((int)final_total_cost);
					atcm.setTotal_discount((int)total_discount);
					//	System.out.println("quantity value is........>>>>>addtocart"+quantity);
					
				}
			}
		  }
		}
		 catch (SQLException e1) {
		e1.printStackTrace();
	}
	catch (Exception e1) {
		e1.printStackTrace();
	}
		atcm.addItemIdList(catModel);
		atcm.setTotal_cost((int)total_cost);
		System.out.println(" sizze is "+atcm.getItemList().size());
		System.out.println("cost is--------->"+total_cost);
        session.setAttribute("cost",final_total_cost*(1+atcm.getTax()));


}
	public void checkDeal(AddToCartModel atcm)
	{
		int dealId=0;

		float item3cost=0;
		HttpSession session = ServletActionContext.getRequest().getSession();
        String user = session.getAttribute("user").toString();
        String itemCheck="";
        String item2Check="";
        int countItem2=0;
        int quantity;
        String offer="";
		try
		{
		if(ConnectionPool.con==null)
			ConnectionPool.con=ConnectionPool.getConnection();
		String tst=atcm.getItemId();
		String sellerId = atcm.getSellerId();
		System.out.println("Selller id is ---------------------------------"+sellerId);
		System.out.println("checking for deals???"+tst);
		String qd="Select dealId,buytwoOffer from item where itemId=?";
 		System.out.println("Inside deal flag=======True");
 			PreparedStatement prepSd = ConnectionPool.con.prepareStatement(qd);
 			prepSd.setString(1, tst);
 			ResultSet rsd= prepSd.executeQuery();
 			if(rsd.next())
 			{
 				//System.out.println("inside new code....");
 				dealId = rsd.getInt("dealId");
 				offer = rsd.getString("buytwoOffer");
 			}
 			String qd1="Select item1,item2,item3 from deals where dealId=?";
     		System.out.println("selecting item1 and item 2 from deals table---------");
     			PreparedStatement prepSd1 = ConnectionPool.con.prepareStatement(qd1);
     			prepSd1.setInt(1, dealId);
     			ResultSet rsd1= prepSd1.executeQuery();
     			if(rsd1.next())
     			{
     				item1=rsd1.getString("item1");
     				item2 = rsd1.getString("item2");
     				item3 = rsd1.getString("item3");
     			}
     			//for buy 2 get one free.....directly updating quatity of repeated item =2
     			if(offer.equals("Y"))
     			{
     				int quant=0;
     				System.out.println("do something!!!!!!!!!!!!11111");
     				//select quantity
     				String qItemcheck="select quantity from orders where itemId=? and userId =? and orderFlag=? and price!=?" ;
     				PreparedStatement prepSd4 = ConnectionPool.con.prepareStatement(qItemcheck);
     				System.out.println(" item to be checked "+item1);
     				prepSd4.setString(1, item1);
     				prepSd4.setString(2, user);
     				prepSd4.setString(3, "C");
     				prepSd4.setInt(4, 0);
        			ResultSet rsItem3= prepSd4.executeQuery();
        			if(rsItem3.next())
        				{
        				//item3cost=rsItem3.getFloat(1);
        				quant=rsItem3.getInt("quantity");
        				}
        			
        			//check wheather free item is already present or not.....
        			//select rowoderid
        			int rowOrderId=0;
     				String item3check="select rowOrderId from orders where itemId=? and userId =? and orderFlag=? and price=?" ;
     				PreparedStatement prepSitem3check = ConnectionPool.con.prepareStatement(item3check);
     				System.out.println(" item to be checked "+item1);
     				prepSitem3check.setString(1, item1);
     				prepSitem3check.setString(2, user);
     				prepSitem3check.setString(3, "C");
     				prepSitem3check.setInt(4, 0);
        			ResultSet rsItem3check= prepSitem3check.executeQuery();
        			if(rsItem3check.next())
        				{
        				//item3cost=rsItem3.getFloat(1);
        				rowOrderId=rsItem3check.getInt("rowOrderId");
        				int set = quant/2;
         				String qUpdateItem3="Update orders set quantity=? where rowOrderId=?" ;
         				PreparedStatement prepSO=ConnectionPool.con.prepareStatement(qUpdateItem3);
         				prepSO.setInt(1,set);
         				prepSO.setInt(2,rowOrderId);
         				prepSO.execute();
         				}
        			
        			else if(quant>=2)
        			{
        				int set = quant/2;
        				//insert item if not present
        				String qfree="INSERT INTO orders(userId , itemId , sellerId , quantity , orderFlag , price) VALUES (?,?,?,?,?,?)";
						PreparedStatement prepSfree = ConnectionPool.con.prepareStatement(qfree);
						prepSfree.setString(1, user);
						prepSfree.setString(2, tst);
						prepSfree.setString(3,atcm.getSellerId());
						prepSfree.setInt(4, set);
						prepSfree.setString(5,"C");
						prepSfree.setInt(6,0);
						//prepS.setString(7,"Y");
						prepSfree.execute();
					
        			}
        			
        			/////
        		/*	int set = quant/2;
     				String qUpdateItem3="Update orders set quantity=? where itemid=? and userId=? and orderFlag=? and price=?" ;
     				PreparedStatement prepSO=ConnectionPool.con.prepareStatement(qUpdateItem3);
     				prepSO.setInt(1,set);
     				prepSO.setString(2,item3);
     				prepSO.setString(3,session.getAttribute("user").toString());
     				prepSO.setString(4,"C");
     				prepSO.setFloat(5, 0);
     				prepSO.execute();
     				*/
     				
     		    }
     			else
     			{
     				if(item1.equals(tst))
     				{
     					itemCheck=item2;
     				
     				}
     				else if(item2.equals(tst))
     				{
     					itemCheck=item1;
     				}
     				else return;
     				System.out.println("checking for item 3");
     				String qItemcheck="select quantity from orders where itemId=? and userId =? and orderFlag=?" ;
     				PreparedStatement prepSd4 = ConnectionPool.con.prepareStatement(qItemcheck);
     				System.out.println(" item to be checked "+itemCheck);
     				prepSd4.setString(1, itemCheck);
     				prepSd4.setString(2, user);
     				prepSd4.setString(3, "C");
        			ResultSet rsItem3= prepSd4.executeQuery();
        			if(rsItem3.next())
        				{
        				//item3cost=rsItem3.getFloat(1);
        				int count=0;
        				quantity=rsItem3.getInt("quantity");
        				 //checking for presence if item3
        				
        				String qItempresence="select count(*) from orders where itemId=? and userId =? and orderFlag=?"  ;
        				PreparedStatement prepPresence = ConnectionPool.con.prepareStatement(qItempresence);
        				prepPresence.setString(1, item3);
        				prepPresence.setString(2, user);
        				prepPresence.setString(3, "C");
        				ResultSet rsPresence= prepPresence.executeQuery();
        				
        				if(rsPresence.next())
        				{
        					count=rsPresence.getInt(1);
        				System.out.println("count of item 3"+count);
        					if(count>0)
        					{
        						System.out.println("i m here to update Item 3");
        						String qUpdateItem3="Update orders set price=?, quantity=? where itemid=? and userId=? and orderFlag=?" ;
        	     				PreparedStatement prepSO=ConnectionPool.con.prepareStatement(qUpdateItem3);
        	     				prepSO.setFloat(1, 0);
        	     				prepSO.setInt(2,Math.min(atcm.getQuantity(), quantity));
        	     				prepSO.setString(3,item3);
        	     				prepSO.setString(4,session.getAttribute("user").toString());
        	     				prepSO.setString(5,"C");
        	     				prepSO.execute();
        	     				 	
        					}
        					else
        					{
        						//inserting 3rd item
        						System.out.println("i m here to insert Item 3");
                				String q="INSERT INTO orders(userId , itemId , sellerId , quantity , orderFlag , price,dealId) VALUES (?,?,?,?,?,?,?)";
                				PreparedStatement prepS = ConnectionPool.con.prepareStatement(q);
                				prepS.setString(1, user);
                				prepS.setString(2, item3);
                				prepS.setString(3, atcm.getSellerId());
                				prepS.setInt(4, 1);
                				prepS.setString(5,"C");
                				prepS.setInt(6,0);
                				prepS.setInt(7,dealId);
                				prepS.execute();


        					}
        				}
        				
        				        				
        				
        			}
     			}
     				
     			     				
		}
		
		
		 catch (SQLException e1) {
				e1.printStackTrace();
			}
			catch (Exception e1) {
				e1.printStackTrace();
			}
     				
     				

	}
	public void removeItem(AddToCartModel atcm)
	{
		float item3cost=0;
		int dealId=0;
		HttpSession session = ServletActionContext.getRequest().getSession();
        String user = session.getAttribute("user").toString();
		try
		{
		if(ConnectionPool.con==null)
			ConnectionPool.con=ConnectionPool.getConnection();
		String tst=atcm.getItemId();
		///////////////////////////////////////////
		
		 String q1="Select dealFlag from item where itemId=?";
 		// System.out.println("Hiiiiii priyanka");
 			PreparedStatement prepS1 = ConnectionPool.con.prepareStatement(q1);
 			prepS1.setString(1, tst);
 			ResultSet rs1 = prepS1.executeQuery();
 			if(rs1.next())
 			{
 				dealFlag = rs1.getString("dealFlag");
 			}
 			System.out.println("dealflag============"+dealFlag);
 			if(dealFlag.equals("Y"))
 			{
 				
 				String qd="Select dealId from item where itemId=?";
         		System.out.println("Inside deal flag=======True");
         			PreparedStatement prepSd = ConnectionPool.con.prepareStatement(qd);
         			prepSd.setString(1, tst);
         			ResultSet rsd= prepSd.executeQuery();
         			if(rsd.next())
         			{
         				dealId = rsd.getInt("dealId");
         				System.out.println("inside new code...."+dealId);

         			}
         			String qd1="Select item1,item2,item3 from deals where dealId=?";
             		 System.out.println("selecting item1 and item 2 from deals table---------");
             			PreparedStatement prepSd1 = ConnectionPool.con.prepareStatement(qd1);
             			prepSd1.setInt(1, dealId);
             			ResultSet rsd1= prepSd1.executeQuery();
             			if(rsd1.next())
             			{
             				item1=rsd1.getString("item1");
             				item2 = rsd1.getString("item2");
             				item3 = rsd1.getString("item3");
             			}
             			if(item1.equals(tst)  || item2.equals(tst))
             			{
             				String qItem3="select cost,discount from item where itemId=?" ;

             				PreparedStatement prepSd4 = ConnectionPool.con.prepareStatement(qItem3);
                			prepSd4.setString(1, item3);
                			ResultSet rsItem3= prepSd4.executeQuery();
                			if(rsItem3.next())
                			{
                				System.out.println("selecting cost and discount for item 3 updation");
                				item3cost=rsItem3.getFloat(1);
                			}
             				String qOrderItem3="Update orders set price=? where itemid=? and userId=? and orderFlag=?" ;
             				PreparedStatement prepSO=ConnectionPool.con.prepareStatement(qOrderItem3);
             				prepSO.setFloat(1, item3cost);
             				prepSO.setString(2,item3);
             				prepSO.setString(3,session.getAttribute("user").toString());
             				prepSO.setString(4,"C");
             				prepSO.execute();
             				
             			}
             				
 			}	
             				
             				
             					
	///////////////////////////////
		 
		String q="DELETE from orders where userId=? and itemId=? and orderFlag='C'";
			PreparedStatement prepS = ConnectionPool.con.prepareStatement(q);
			prepS.setString(1, user);
			prepS.setString(2, tst);
			prepS.execute();
			atcm.setItemId(null);
	}
		 catch (SQLException e1) {
		e1.printStackTrace();
	}
	catch (Exception e1) {
		e1.printStackTrace();
	}

	}
	
	
	public void updateItem(AddToCartModel atcm)
	{
		
		//Test atc = null;
		int actual_quantity=50;
		String dealFlag="";
		String sellerId="";
		try
		{
		if(ConnectionPool.con==null)
			ConnectionPool.con=ConnectionPool.getConnection();
		String tst=atcm.getItemId();
		 HttpSession session = ServletActionContext.getRequest().getSession();
         String user = session.getAttribute("user").toString();
         	int quantity = atcm.getQuantity();
     		int cost = atcm.getCost();
     		String q1="Select quantity,dealFlag,seller_id from item where itemId=?";
		// System.out.println("Hiiiiii priyanka");
			PreparedStatement prepS1 = ConnectionPool.con.prepareStatement(q1);
			prepS1.setString(1, tst);
		//	System.out.println("");
			ResultSet rs1 = prepS1.executeQuery();
			if(rs1.next())
			{
				System.out.println("inside new code....");
			 actual_quantity= rs1.getInt("quantity");
			 dealFlag=rs1.getString("dealFlag");
			 sellerId = rs1.getString("seller_id");
			 atcm.setSellerId(sellerId);
			}
			System.out.println("quantity"+quantity+"aQ"+actual_quantity);
		
     if(quantity>actual_quantity)
    	 quantity=actual_quantity;
     if(quantity<=0)
    	 quantity=1;
       System.out.println("check----------->"+quantity+"    "+cost);
       
       System.out.println("check----------->"+user);
       System.out.println("check----------->"+tst);

		String q="Update orders set quantity = ? where userId=? and itemId=? and price!=?";
			PreparedStatement prepS = ConnectionPool.con.prepareStatement(q);
			prepS.setInt(1, quantity);
			prepS.setString(2, user);
			prepS.setString(3, tst);
			prepS.setInt(4, 0);
		prepS.execute();
		if(dealFlag.equals("Y"))
		{
			System.out.println(" deal flag is Y");
			checkDeal(atcm);
		}
		atcm.setItemId(null);
		//modelInitialization(atcm);
	}
		/* catch (SQLException e1) {
		e1.printStackTrace();
	}*/
	catch (Exception e1) {
		e1.printStackTrace();
	}

	}

	
	public boolean valid(AddToCartModel atcm) 
	{
		int rowOrderId;
		int count=0;
		try
		{
			System.out.println("where m i?");
		String query1="SELECT rowOrderId from orders where itemId=? and userId=? and orderFlag=?";
		String tst=atcm.getItemId();
		System.out.println("itemId---------------------------------->"+atcm.getItemId());
        String user = session.getAttribute("user").toString();
		PreparedStatement prepStmt=ConnectionPool.con.prepareStatement(query1);
		prepStmt.setString(1,tst);
		prepStmt.setString(2,user);
		prepStmt.setString(3,"C");
		ResultSet rs1 = prepStmt.executeQuery();
		if(rs1.next())
		{
			count++;
		}
		if(count==0)
		{
			return true;
		}
		else
		{
			return false;
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


	public void showCart(AddToCartModel atcm)
	{
		System.out.println(" I m in show cart ");
		ArrayList<Test> catModel=new ArrayList<Test>();
		String user = session.getAttribute("user").toString();
		Test atc=null;
		int quantity=0;
		float taxtemp=0;
		//String dealFlag;
		float costperItem;
		float cost,costFinal;
		
		try
		{
		if(ConnectionPool.con==null)
			ConnectionPool.con=ConnectionPool.getConnection();
		String q2 = "SELECT itemId,quantity,price FROM orders where userId=? and orderFlag=?";
		PreparedStatement ps1=ConnectionPool.con.prepareStatement(q2);
		ps1.setString(1,user);
		ps1.setString(2,"C");
		ResultSet rs2 = ps1.executeQuery();
		String queryvat="select vatTax from vat where idupdate=1";
		PreparedStatement prepStmtvat=ConnectionPool.con.prepareStatement(queryvat);
		ResultSet rsvat = prepStmtvat.executeQuery();
		System.out.println(rsvat);
		if(rsvat.next())
		{
			taxtemp=((float)rsvat.getInt(1))/100;
			//atcm.setTax(taxtemp);
		}
		while(rs2.next())
		{
		  String itemId= rs2.getString("itemId");
		  quantity = rs2.getInt("quantity");
		  //cost=rs2.getString()
		  //dealFlag=rs2.getString("dealFlag");
		  cost=rs2.getFloat("price");
		  String query="SELECT item_name,item_desc,cost,seller_id,image,imagePath,discount,expiryOn,quantity FROM item where itemId=?;";
		  PreparedStatement prepStmt=ConnectionPool.con.prepareStatement(query);
		  prepStmt.setString(1,itemId);
		  ResultSet rs = prepStmt.executeQuery();
		  System.out.println(" query"+query);
		  while (rs.next()) {
			System.out.println("Inside!!!!!!!!!!!!!!!!!!!!!!"+itemId);
			atc=new Test();
			atc.setItemId(itemId);
			atc.setItemName(rs.getString("item_name"));
			atc.setItemDesc(rs.getString("item_desc"));
			atc.setCost(rs.getInt("cost")*quantity);
			if(cost==0)
				atc.setCost(0);
			atc.setSeller_id(rs.getString("seller_id"));
			atc.setPhoto(rs.getBlob("image"));
			atc.setImagePath(rs.getString("imagePath"));
			atc.setTotal_quant(rs.getInt("quantity"));

			//quantity=rs.getInt("quantity");
			Blob pic=rs.getBlob("image");
			if(pic!=null)
				{
				int blobLength = (int) pic.length();	
				atc.setBlobAsBytes(pic.getBytes(1, blobLength));
				atc.setImage64encode(new Base64().encodeToString(atc.getBlobAsBytes()));
				}
			costperItem=0;
			if(atc.getCost()!=0)
				costperItem=rs.getFloat("cost");
			System.out.println(" costperItem --->"+costperItem);
			costFinal = quantity*costperItem;
			System.out.println("costFinal "+costFinal);
			/*String q1="Select discount,expiryOn from item where itemId=?";
			PreparedStatement prepS1 = ConnectionPool.con.prepareStatement(q1);
			prepS1.setString(1, itemId);
			ResultSet rs1 = prepS1.executeQuery();
				if(rs1.next())
				{
					//System.out.println("inside new code....");
					discount = rs1.getInt("discount");
				}*/
			if(costperItem!=0)
				discount=rs.getInt("discount");
			else discount=0;
			//atc.setCost((int)costFinal);
			atc.setDiscountMoney((int)(costFinal*discount)/100);
				
			if(discount>0)
				{
					costFinal =costFinal-( (costFinal*discount)/100);
				}
			atc.setFinalCost((int)costFinal);
			final_total_cost = final_total_cost + cost;
			System.out.println(" final_total_cost "+final_total_cost + "cost "+cost);
			total_cost = total_cost + costFinal+atc.getDiscountMoney(); 
			//System.out.println("total_discount  ---->"+total_discount+ " discount "+discount+" cost   "+cost);
			total_discount=total_discount+atc.getDiscountMoney();
			atc.setQuantity(quantity);
			catModel.add(atc);
			atcm.setFinal_total_cost((int)final_total_cost);
			atcm.setTotal_discount((int)total_discount);	
		}
		  }
		atcm.addItemIdList(catModel);
		atcm.setTotal_cost((int)total_cost);
		atcm.setTotal_discount((int)total_discount);
		}
		 catch (SQLException e1) {
		e1.printStackTrace();
	}
	catch (Exception e1) {
		e1.printStackTrace();
	}
	}

	
	/*public void dealCart(AddToCartModel atcm){
		
		
		System.out.println("deal item list size "+atcm.dealItemList.size());
		ArrayList<Test> catModel=new ArrayList<Test>();
		Test atc=null;
		ArrayList<String> dealList=atcm.getDealItemList();
		try
		{
		if(ConnectionPool.con==null)
			ConnectionPool.con=ConnectionPool.getConnection();
		for(int i=0;i<dealList.size();i++){
		
		String tst=dealList.get(i);
		int cost=0;
		String seller_id=null ;//= atcm.getSellerId();
		// HttpSession session = ServletActionContext.getRequest().getSession();
         String user = session.getAttribute("user").toString();
        
         if(tst!=null)
         {
        	 
        	 boolean result = valid(atcm);
        	 if(result)
        	 {
        		 String q1="Select cost,discount,expiryOn,seller_id from item where itemId=?";
        		// System.out.println("Hiiiiii priyanka");
        			PreparedStatement prepS1 = ConnectionPool.con.prepareStatement(q1);
        			prepS1.setString(1, tst);
        			ResultSet rs1 = prepS1.executeQuery();
        			if(rs1.next())
        			{
        				cost=rs1.getInt("cost");
        				discount = rs1.getInt("discount");
        				seller_id=rs1.getString("seller_id");
        			}
     			if(discount>0)
     			{
     				//System.out.println("here---------------------------->jjjjjjjj");
     				cost =cost-( (cost*discount)/100);
     			}
     			if(i%3==2){
     				cost=0;
     			}
    
        		 
        		 
		String q="INSERT INTO orders(userId , itemId , sellerId , quantity , orderFlag , price) VALUES (?,?,?,?,?,?)";
			PreparedStatement prepS = ConnectionPool.con.prepareStatement(q);
			prepS.setString(1, user);
			prepS.setString(2, tst);
			prepS.setString(3, seller_id);
			prepS.setInt(4, 1);
			prepS.setString(5,"C");
			prepS.setInt(6,cost);
		prepS.execute();
        	 }
       }
		
		String q2 = "SELECT itemId , quantity FROM orders where userId=? and orderFlag=?";
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
		
		String query="SELECT item_name,item_desc,cost,seller_id,image,imagePath FROM item where itemId=?";
		
		query+=";";
		PreparedStatement prepStmt=ConnectionPool.con.prepareStatement(query);
		  prepStmt.setString(1,itemId);
		  ResultSet rs = prepStmt.executeQuery();
		  
		System.out.println(" query"+query);
	//	ResultSet rs = stmt.executeQuery(query);
	//	atcm.setItemList(new ArrayList<Test>());
		while (rs.next()) {
			System.out.println("Inside!!!!!!!!!!!!!!!!!!!!!!");
			atc=new Test();
			atc.setItemId(itemId);
			atc.setItemName(rs.getString("item_name"));
			atc.setItemDesc(rs.getString("item_desc"));
			//atc.setCost(rs.getString("cost"));
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
			if(i%3==2){
				costperItem=0;
			}
			int costFinal = quantity*costperItem;
			
			 String q1="Select discount,expiryOn from item where itemId=?";
			 System.out.println("Hiiiiii priyanka");
				PreparedStatement prepS1 = ConnectionPool.con.prepareStatement(q1);
				prepS1.setString(1, itemId);
				ResultSet rs1 = prepS1.executeQuery();
				if(rs1.next())
				{
					//System.out.println("inside new code....");
					discount = rs1.getInt("discount");
				}
				atc.setCost(costFinal);
				total_cost = total_cost + costFinal;
				total_discount=total_discount+(costFinal*discount)/100;
				System.out.println("total discount********"+total_discount);
				atc.setDiscountMoney((costFinal*discount)/100);
				
			if(discount>0)
 			{
 				costFinal =costFinal-( (costFinal*discount)/100);
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
        session.setAttribute("cost",final_total_cost);
		

	}*/
	
	public void dealCart(AddToCartModel atcm){
		flagWhere = "deal";
		System.out.println("deal item list size "+atcm.dealItemList.size());
		ArrayList<Test> catModel=new ArrayList<Test>();
		Test atc=null;
		int i,quant=0,set=0;
		System.out.println("get itemList");
		ArrayList<String> dealList=atcm.getDealItemList();
		System.out.println("get itemList done");
		if(session.getAttribute("user")!=null)
		{
		String user = session.getAttribute("user").toString();
		String offer="";
		int count=0;
		try
		{
		if(ConnectionPool.con==null)
			ConnectionPool.con=ConnectionPool.getConnection();
			for(i=0;i<dealList.size();i++){
			String tst=dealList.get(i);
			//atcm.setItemId(tst);
			int cost=0;
			String seller_id=null ;//= atcm.getSellerId();
			// HttpSession session = ServletActionContext.getRequest().getSession();
			
			// check for presence if already
			String query1="SELECT rowOrderId from orders where itemId=? and userId=? and orderFlag=?";
			PreparedStatement prepStmt=ConnectionPool.con.prepareStatement(query1);
			prepStmt.setString(1,tst);
			prepStmt.setString(2,user);
			prepStmt.setString(3,"C");
			ResultSet rs1 = prepStmt.executeQuery();
			while(rs1.next())
			{
				count++;
			}
			System.out.println("tst "+tst);
			if(tst!=null)
			{
				//check for buy 2 offer
				System.out.println("i should come here");
				String qoffer="Select buytwoOffer from item where itemId=?";
				PreparedStatement prepSoffer = ConnectionPool.con.prepareStatement(qoffer);
				prepSoffer.setString(1, tst);
				ResultSet rsoffer = prepSoffer.executeQuery();
				if(rsoffer.next())
				{
					offer=rsoffer.getString("buytwoOffer");
	
				}
				System.out.println("offfer is----------------"+offer);
				atcm.setItemId(tst);
				boolean result = valid(atcm);
				System.out.println("valid check ok ");
				if(result)
				{
					String q1="Select quantity,cost,discount,expiryOn,seller_id from item where itemId=?";
					PreparedStatement prepS1 = ConnectionPool.con.prepareStatement(q1);
					prepS1.setString(1, tst);
					ResultSet rs2 = prepS1.executeQuery();
					if(rs2.next())
					{
						cost=rs2.getInt("cost");
		
						discount = rs2.getInt("discount");
						seller_id=rs2.getString("seller_id");
						quant = rs2.getInt("quantity");
						if(quant==0)
							set=1;
					}
					if(discount>0)
					{
						//	System.out.println("here---------------------------->jjjjjjjj");
						cost =cost-( (cost*discount)/100);
					}
					//insert buy 2 get one item n return........
					if(offer!=null && offer.equals("Y") && count==0)
					{
						System.out.println("inserting offer items.........");
						String q="INSERT INTO orders(userId , itemId , sellerId , quantity , orderFlag , price) VALUES (?,?,?,?,?,?)";
						PreparedStatement prepS = ConnectionPool.con.prepareStatement(q);
						prepS.setString(1, user);
						prepS.setString(2, tst);
						prepS.setString(3, seller_id);
						prepS.setInt(4, 2);
						prepS.setString(5,"C");
						prepS.setInt(6,cost);
						//prepS.setString(7,"Y");
						prepS.execute();
			
						////insert free item buy 2 offer
						String qfree="INSERT INTO orders(userId , itemId , sellerId , quantity , orderFlag , price) VALUES (?,?,?,?,?,?)";
						PreparedStatement prepSfree = ConnectionPool.con.prepareStatement(qfree);
						prepSfree.setString(1, user);
						prepSfree.setString(2, tst);
						prepSfree.setString(3, seller_id);
						prepSfree.setInt(4, 1);
						prepSfree.setString(5,"C");
						prepSfree.setInt(6,0);
						//prepS.setString(7,"Y");
						prepSfree.execute();
						
						modelInitialization(atcm);
						return;
			
					}
					else if(offer!=null && !offer.equals("Y") && quant!=0)
					{
					//////
					if(i%3==2 && set!=1){
						cost=0;
					}
					System.out.println("inserting 11111");
					String q="INSERT INTO orders(userId , itemId , sellerId , quantity , orderFlag , price) VALUES (?,?,?,?,?,?)";
					PreparedStatement prepS = ConnectionPool.con.prepareStatement(q);
					prepS.setString(1, user);
					prepS.setString(2, tst);
					prepS.setString(3, seller_id);
					if(quant==0)
					{
						prepS.setInt(4, 0);
						set=1;
					}
					else
					{
					prepS.setInt(4, 1);
					}
					prepS.setString(5,"C");
					prepS.setInt(6,cost);
					//prepS.setString(7,"Y");
					prepS.execute();
					}
				}
			}
			}
			
			showCart(atcm);
		
		}
		 catch (SQLException e1) {
		e1.printStackTrace();
	}
	catch (Exception e1) {
		e1.printStackTrace();
	}
	}
	}

}
