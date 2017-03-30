package org.struts.action;

import org.struts.model.ItemByCatModel;
import org.struts.service.dealsService;
import org.struts.service.itemBySubCatService;

import com.opensymphony.xwork2.ModelDriven;

public class itemBySubCatAction implements ModelDriven{

	ItemByCatModel tcm=new ItemByCatModel();
	
	public String execute()
	{
		System.out.println("I am in subcataction ");
		itemBySubCatService scs=new itemBySubCatService();
		scs.modelInitialization(tcm);
		System.out.println("back in subcat action");
		
		return "success";
		
	}
	
	@Override
	public Object getModel() {
		// TODO Auto-generated method stub
		return tcm;
	}



}
