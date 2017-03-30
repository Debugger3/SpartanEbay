package org.struts.action;
import javax.servlet.http.HttpSession;

import org.apache.struts2.ServletActionContext;
import org.struts.model.*;
import org.struts.service.*;


import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;
public  class MyWelcomeAction extends ActionSupport implements ModelDriven{
	private static final long serialVersionUID = 1L;
	public UserRegisterModel urm=new UserRegisterModel();
	public String execute()
	{
			System.out.println("calling Update Information ");
			UserRegisterService urs=new UserRegisterService();
				urs.updateUser(urm);
			return "success";
		
	}
	public String executeUpdate()
	{
		UserRegisterService urs=new UserRegisterService();
		urs.updateUser1(urm);
		return SUCCESS;
	}
	
	public String executeDelete() 
	{
		UserRegisterService urs=new UserRegisterService();
		urs.deleteUser(urm);
		HttpSession session = ServletActionContext.getRequest().getSession(false);
    	session.removeAttribute("logined");
    	session.removeAttribute("context");
    	session.removeAttribute("user");
    	session.removeAttribute("type");
		return SUCCESS;
	}
	@Override
	public Object getModel() {
		// TODO Auto-generated method stub
		return urm;
	}
}
