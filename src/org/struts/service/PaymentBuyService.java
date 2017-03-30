package org.struts.service;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.http.HttpSession;
import org.apache.struts2.ServletActionContext;
import org.struts.action.address;
import org.struts.model.BuyNowModel;
import org.struts.utils.ConnectionPool;

public class PaymentBuyService {
	float balance;
	String accountNumber="";
	public boolean checkCardInfo(BuyNowModel bnm){
		try{
		if(ConnectionPool.con==null)
			ConnectionPool.con=ConnectionPool.getConnection();
		PreparedStatement st=ConnectionPool.con.prepareStatement("select * from account where cardNumber=?");
		st.setString(1, bnm.getCardNumber());		
		ResultSet rs=st.executeQuery();
		if(rs.next()){
			System.out.println( " exp year "+rs.getString("cvv"));
			System.out.println(bnm.getCvv());
			if(!(rs.getString("expYear").equals(bnm.getExpYear()) 
					&& rs.getString("expMonth").equals(bnm.getExpMonth())
					&& rs.getString("cvv").equals(bnm.getCvv())  
					&& rs.getString("accountHolderName").equals(bnm.getHolderName())))
					{
					System.out.println("crad detail is wrong");
					return false;
					
					}
			if(rs.getInt("balance")<bnm.getCost()-bnm.getDiscountedCost())
				{
				System.out.println(" balance is less");
				return false;
				}
			balance=rs.getFloat("balance");
			accountNumber=rs.getString("accountNumber");	
			}
		HttpSession session = ServletActionContext.getRequest().getSession();
		System.out.println(" session value is "+session.getAttribute("user"));
		if(session.getAttribute("user")==null || session.getAttribute("user").equals(""))
			return false;
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		return true;
	}
	public void transaction(BuyNowModel bnm)
	{
		System.out.println(" discounter price"+bnm.getDiscountedCost());
		try{
		if(ConnectionPool.con==null)
			ConnectionPool.con=ConnectionPool.getConnection();
		HttpSession session = ServletActionContext.getRequest().getSession();
		String userId=session.getAttribute("user").toString();
		float discountedCost;
		System.out.println("balance before"+balance);
		balance = balance-bnm.getDiscountedCost();
		System.out.println("balance after"+balance);
		DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd");
		Date currDate = new Date();
		System.out.println(dateFormat.format(currDate));
		String q="UPDATE account set balance=? where cardNumber=?";
		PreparedStatement prepS = ConnectionPool.con.prepareStatement(q);
		prepS.setFloat(1, balance);
		prepS.setString(2, bnm.getCardNumber());
		prepS.execute();
		String q1="UPDATE account set balance=balance+? where userId=?";
		PreparedStatement prep = ConnectionPool.con.prepareStatement(q1);
		if(bnm.getDeliveryCharge()!=0)
			discountedCost=bnm.getDiscountedCost()-bnm.getDeliveryCharge();
		else
			discountedCost=bnm.getDiscountedCost();
		prep.setFloat(1,discountedCost);		
		prep.setString(2, "ebay");
		prep.execute();
		bnm.setUUID_Or();
		bnm.setUUID_Pay();
		System.out.println("orderId.........."+bnm.getUUID_Or()+" payment id "+ bnm.getUUID_Pay()+userId);
		String insertOrderQ="INSERT INTO orders(userId , itemId , sellerId , quantity , status , orderDate , paymentId , orderFlag , price , address,orderId) VALUES (?,?,?,?,?,?,?,?,?,?,?)";
		PreparedStatement insertPrepS = ConnectionPool.con.prepareStatement(insertOrderQ);
		insertPrepS.setString(1, userId);
		insertPrepS.setString(2, bnm.getItemId());
		insertPrepS.setString(3, bnm.getSellerId());
		insertPrepS.setInt(4, bnm.getQuantity());
		insertPrepS.setString(5,"Payment Successful");
		insertPrepS.setString(6, dateFormat.format(currDate));
		insertPrepS.setString(7, bnm.getUUID_Pay());
		insertPrepS.setString(8, "B");
		insertPrepS.setFloat(9,bnm.getDiscountedCost());
		if(bnm.getAddrList()!=null)
			System.out.println(" addreess size "+bnm.getAddrList().size());
		//address add=bnm.getAddrList();
		//add
		System.out.println("quantity "+bnm.getQuantity());
		//insertPrepS.setString(10,add.getAddress()+"~"+add.getCity()+"~"+add.getPincode()+"~"+add.getState()+"~"+add.getCountry());
		insertPrepS.setString(10,"Adreesss for test");
		insertPrepS.setString(11,bnm.getUUID_Or());
		insertPrepS.execute();
		String str="Insert into payment(paymentId,price,orderId,paymentType,debitAccount) values(?,?,?,?,?)";
		PreparedStatement ps = ConnectionPool.con.prepareStatement(str);
		ps.setString(1, bnm.getUUID_Pay());
		ps.setFloat(2, bnm.getDiscountedCost());
		ps.setString(3, bnm.getUUID_Or());
		ps.setString(4, "debit");
		ps.setString(5, accountNumber);
		ps.execute();
		System.out.println("orderId.........."+bnm.getUUID_Or()+bnm.getUUID_Pay()+userId);
		String quantityUpdate="update item set item.quantity=item.quantity-"+bnm.getQuantity()+" where itemId="+"'"+bnm.getItemId()+"'"+";";
		PreparedStatement prepQUpdate = ConnectionPool.con.prepareStatement(quantityUpdate);
		prepQUpdate.execute();
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
	}
}
	
