package org.struts.action;

import java.sql.PreparedStatement;

import javax.servlet.http.HttpSession;

import org.apache.struts2.ServletActionContext;
import org.struts.utils.ConnectionPool;

public class updateAdvCost {
	private int advcost;
	private int subCatId;
	private int categoryId;
	
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
	public int getAdvcost() {
		return advcost;
	}

	public void setAdvcost(int advcost) {
		this.advcost = advcost;
	}
	public String execute()
	{
		HttpSession session = ServletActionContext.getRequest().getSession();
	 	session.setAttribute("subcatId", getSubCatId());
		return "success";
	}
	public String updateAdvertisementCost()
	{
		
		try{
			if(ConnectionPool.con==null)
				ConnectionPool.con=ConnectionPool.getConnection();
			
			HttpSession session = ServletActionContext.getRequest().getSession();
			String subcatId=session.getAttribute("subcatId").toString();
			int id = Integer.parseInt(subcatId);
			String query="update subcategory set advertise_cost=? where subcatId=?";
			PreparedStatement ps= ConnectionPool.con.prepareStatement(query);
			ps.setInt(1, getAdvcost());
			ps.setInt(2, id);
			
					
			ps.executeUpdate();
		}
		 catch (Exception e1) {
				e1.printStackTrace();
		}
		return "success";
		
	}
}
