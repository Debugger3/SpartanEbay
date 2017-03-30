package org.struts.action;

import org.apache.commons.lang.StringUtils;
import org.apache.struts2.interceptor.validation.SkipValidation;
import org.struts.model.*;
import org.struts.service.*;

import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;
public class SellAction extends ActionSupport implements ModelDriven{
	SellModel sm=new SellModel();
	@SkipValidation
	public String homePage()
	{
		System.out.println("I m returning home??");
		return "home";
	}
	
	public String execute()
	{
		return "success";
	}
	public String executeSubmit()
	{
	SellService ss=new SellService();
	System.out.println("calling show report......... ");
	 ss.showReport(sm);
	
		return "success";
	}
	
	
	@Override
	public Object getModel() {
		// TODO Auto-generated method stub
		System.out.println("i m callign model");
		return sm;
	}

	


}