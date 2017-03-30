package org.struts.action;
import com.opensymphony.xwork2.ModelDriven;

import org.apache.commons.lang.StringUtils;
import org.apache.struts2.interceptor.validation.SkipValidation;
import org.struts.model.*;
import org.struts.service.AddItemService;
import org.struts.service.CallService;

import com.opensymphony.xwork2.ActionSupport;

public class AddItemAction extends ActionSupport implements ModelDriven {
	AddItemModel am=new AddItemModel();	
	
	public String execute() {
		System.out.println("before call in add Item Action ");
		AddItemService addService=new AddItemService();
		if(addService.addItem(am))
			return SUCCESS;
		else
	      return ERROR;	    
}
	@SkipValidation
	public String displayList()
	{
		
		System.out.println("I m in display List");
		System.out.println(am.getSubCatId()+ " category id "+am.getCategoryId());
		System.out.println();
		System.out.println("i m here in AddItem Action");
		AddItemService addService=new AddItemService();
		addService.listCategory(am);
		return "success";
	}
	@Override
	public Object getModel() {
		// TODO Auto-generated method stub
		System.out.println("calling model ");
		return am;
	}
}