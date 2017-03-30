package org.struts.action;
import java.sql.Blob;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.servlet.http.HttpSession;

import org.apache.struts2.ServletActionContext;
import org.apache.tomcat.util.codec.binary.Base64;
import org.struts.model.*;
import org.struts.utils.ConnectionPool;

import com.opensymphony.xwork2.ModelDriven;
public class LabTestAction implements ModelDriven{
	ItemByCatModel itm=new ItemByCatModel(); 
	public String execute()
	{
		try
  		{
		 
  			if(ConnectionPool.con==null)
  				ConnectionPool.con=ConnectionPool.getConnection();
			HttpSession session = ServletActionContext.getRequest().getSession();
			String user=session.getAttribute("user").toString();
			//System.out.println(" session value is "+session.getAttribute("user"));
			if(session.getAttribute("user")==null || session.getAttribute("user").equals(""))
				return "error";
			ItemByCatModel tc;
			String q="Select * from item where expiryDate between ? and ? and seller_id=?";
			PreparedStatement prepStmtAdv = ConnectionPool.con.prepareStatement(q);
			prepStmtAdv.setString(1, itm.getStartDate());
			prepStmtAdv.setString(2, itm.getEndDate());
			prepStmtAdv.setString(3, user);
			ResultSet rs = prepStmtAdv.executeQuery();
			itm.setItemList(new ArrayList<ItemByCatModel>());
				while(rs.next())
				{
					tc=new ItemByCatModel();
					System.out.println("in loop");
					String itemId = rs.getString("itemId");
					tc.setItemId(itemId);
					tc.setItemName(rs.getString("item_name"));
					tc.setItemDesc(rs.getString("item_desc"));
					tc.setCost(rs.getString("cost"));
					tc.setSeller_id(rs.getString("seller_id"));
					//tc.setPhoto(rs.getBlob(6));
					//tc.setImagePath(rs.getString(7));
					int quantity = rs.getInt("quantity");
					Blob pic=rs.getBlob("image");
					if(pic!=null)
						{
						int blobLength = (int) pic.length();	
						tc.setBlobAsBytes(pic.getBytes(1, blobLength));
						tc.setImage64encode(new Base64().encodeToString(tc.getBlobAsBytes()));
						}
					itm.getItemList().add(tc);
					
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
	@Override
	public Object getModel() {
		// TODO Auto-generated method stub
		return itm;
	}

}
