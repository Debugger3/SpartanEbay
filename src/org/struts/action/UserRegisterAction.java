package org.struts.action;

import org.apache.commons.lang.StringUtils;
import org.apache.struts2.interceptor.validation.SkipValidation;
import org.struts.model.*;
import org.struts.service.*;

import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;
public class UserRegisterAction extends ActionSupport implements ModelDriven{
	UserRegisterModel rm=new UserRegisterModel();
	@SkipValidation
	public String homePage()
	{
		//System.out.println("I m returning home??");
		return "home";
	}
	
	public String execute()
	{
		return "success";
	}
	public String executeSubmit()
	{
	UserRegisterService rs=new UserRegisterService();
	if(rs.findByUserId(rm))
	{
		System.out.println("User already present");
		return "failure";
	}
	rs.registerIntoDataBase(rm);
	System.out.println("inserted");
		return "success";
	}
	
	
	@Override
	public Object getModel() {
		// TODO Auto-generated method stub
		//System.out.println("i m callign model");
		return rm;
	}

	


}
