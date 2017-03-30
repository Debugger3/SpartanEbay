package org.struts.action;
import org.struts.model.ItemByCatModel;
import org.struts.service.ItemByCatService;

import com.opensymphony.xwork2.ModelDriven;
public class ItemByCatAction implements ModelDriven {
	ItemByCatModel tcm=new ItemByCatModel();
		public String execute()
		{
			System.out.println("I m here in itemByCatAction class");
			ItemByCatService tcs=new ItemByCatService();
			tcs.modelInitialization(tcm);
			System.out.println("returning here :)");
			return "success";
		}

		@Override
		public Object getModel() {
			// TODO Auto-generated method stub
			return tcm;
		}
}