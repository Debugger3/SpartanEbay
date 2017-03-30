package org.struts.action;

import org.apache.commons.lang.StringUtils;
import org.apache.struts2.interceptor.validation.SkipValidation;
import org.struts.model.RegisterModel;
import org.struts.service.*;

import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;
public class RegisterAction extends ActionSupport implements ModelDriven{
	RegisterModel rm=new RegisterModel();
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
	RegisterSellerService rs=new RegisterSellerService();
	System.out.println("calling findBySellerId() ");
	if(rs.findBySellerId(rm))
	{
		System.out.println("returning false");
		return "failure";
	}
	System.out.println(" returned from findBySellerID");
	rs.registerIntoDataBase(rm);
		return "success";
	}
	
	public void validate(){
		System.out.println("validate method executing!!!! ");
		if(StringUtils.isEmpty(rm.getSellerId()))
		{
			System.out.println("validation checking of sellerid!!!! ");
			addFieldError("sellerId", "Seller Id can not be empty");
			
		}
		if(StringUtils.isEmpty(rm.getSellerName()))
		{
			System.out.println("validation checking of sellerName!! ");
			addFieldError("sellerName", "seller name can not be empty");
			
		}
		if(StringUtils.isEmpty(rm.getSellerAdd()))
		{
			System.out.println("validation checking of sellerAdd!!!! ");
			addFieldError("sellerAdd", "seller address can not be empty");
		}
		if(StringUtils.isEmpty(rm.getPass()))
		{
			System.out.println("validation checking of password!!!! ");
			addFieldError("password", "Password can not be empty");
			
		}
		if(! rm.getPass2().equals(rm.getPass()))
		{
			System.out.println("validation checking of confirm password!!!! ");
			addFieldError("ConfirmPassword", "Confirm Password is either empty or it is not matching");
			
		}
		System.out.println("validate method ending!!!! ");
		
	}
	@Override
	public Object getModel() {
		// TODO Auto-generated method stub
		System.out.println("i m callign model");
		return rm;
	}

	


}