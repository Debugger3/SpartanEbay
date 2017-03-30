package org.struts.action;


import java.sql.PreparedStatement;
import java.sql.ResultSet;

import org.struts.utils.*;
public class vatAction{
	  	int vatTax;
			public int getVatTax() {
			return vatTax;
		}
		public void setVatTax(int vatTax) {
			this.vatTax = vatTax;
		}
			public String execute()
			{
				try{
				if(ConnectionPool.con==null)
		  			ConnectionPool.con=ConnectionPool.getConnection();
				int temp=getVatTax();
				 String query="UPDATE vat SET vatTax ="+temp+";";
		         PreparedStatement preparedStmt = ConnectionPool.con.prepareStatement(query);
		         System.out.println("VatTax:"+getVatTax());
		       System.out.println(query);
		       preparedStmt.execute(query);
			}
			
			catch (Exception e1) {
				e1.printStackTrace();
			}
				return "success";
			}
}
