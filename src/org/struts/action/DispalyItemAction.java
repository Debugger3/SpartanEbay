package org.struts.action;

import org.struts.model.ItemByCatModel;
import org.struts.service.ItemByCatService;

import com.opensymphony.xwork2.ModelDriven;

public class DispalyItemAction implements ModelDriven{
	ItemByCatModel it=new ItemByCatModel();
	public String execute()
	{
		ItemByCatService its=new ItemByCatService();
		its.displayItemById(it);
		return "success";
	}
	
	@Override
	public Object getModel() {
		// TODO Auto-generated method stub
		return it;
	}
}
