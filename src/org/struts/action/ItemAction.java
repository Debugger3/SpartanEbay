package org.struts.action;
import javax.servlet.http.HttpSession;

import org.apache.struts2.ServletActionContext;
import org.struts.model.*;
import org.struts.service.RegisterSellerService;
import org.struts.service.UserRegisterService;

import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;
public  class ItemAction extends ActionSupport implements ModelDriven{
	private int itemOption;
	public RegisterModel rm=new RegisterModel();
	public String execute()
	{
		HttpSession session = ServletActionContext.getRequest().getSession();
		session.setAttribute("edit", "no");
		System.out.println(" i m in itemAction java and value of item selected is "+itemOption);
		if(itemOption==1)
		{
			System.out.println("calling add jsp inside ItemAction");
			return "Add";
		}
		else if(itemOption==2)
		{
			System.out.println("calling delete jsp inside ItemAction");
			DeleteItemAction ds=new DeleteItemAction();
			ds.execute();
			return "Delete";
		}
		else if(itemOption==3)
		{
			System.out.println("calling deals add jsp inside ItemAction");
			return "addDeals";
		}
		else if(itemOption==4)
		{
			System.out.println("calling Update Information ");
			RegisterSellerService rss=new RegisterSellerService();
			rss.updateSeller(rm);
			return "view";
		}
		else if (itemOption==6)
		{
			
			session.setAttribute("update", "no");
			System.out.println("calling edit jsp inside ItemAction");
			EditItemAction ds=new EditItemAction();
			ds.execute();
			return "Edit";
		}
		else if(itemOption==7)
		{
			System.out.println("calling deals add jsp inside ItemAction");
			return "deleteDeals";
		}
		else 
		{RegisterSellerService rss=new RegisterSellerService();
		rss.deleteSeller(rm);
		return SUCCESS; 
		
	}
		
	
	}
	public String sellerUpdate()
	{
		RegisterSellerService rss=new RegisterSellerService();
		rss.updateSeller(rm);
		return SUCCESS;
	}
	
	public String executeUpdate()
	{
		RegisterSellerService rss=new RegisterSellerService();
		rss.updateSeller1(rm);
		return SUCCESS;
	}
	public int getItemOption() {
		return itemOption;
	}
	public void setItemOption(int itemOption) {
		this.itemOption = itemOption;
	}
	@Override
	public Object getModel() {
		// TODO Auto-generated method stub
		return rm;
	}
}
