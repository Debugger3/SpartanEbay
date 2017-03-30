package org.struts.action;
import org.struts.model.ItemByCatModel;
import org.struts.service.dealsService;

import com.opensymphony.xwork2.ModelDriven;

public class dealsAction implements ModelDriven{

	ItemByCatModel tcm=new ItemByCatModel();
	
	public String execute()
	{
		System.out.println("I am in DEALS ");
		dealsService ds=new dealsService();
		ds.modelInitialization(tcm);
		System.out.println("back in deal action");
		//System.out.println(tcm.getItemList().size()+" "+tcm.getItemList().get(1));
		
		return "success";
		
	}
	
	public String dealAdded(){
		dealsService ds=new dealsService();
		ds.moreDeal(tcm);
		return "success";
	}
	
	public String displayDeal(){
		dealsService ds=new dealsService();
		ds.displayDeal(tcm);
		return "success";
	}
	
	public String dealCart(){
		dealsService ds=new dealsService();
		System.out.println("in dealcart deal action");
		ds.dealCart(tcm);
		return "success";
	}
	
	public String deleteDeals(){
		dealsService ds=new dealsService();
		System.out.println("in deleteDeals deal action");
		ds.deleteDeals(tcm);
		return "success";
	}
	
	@Override
	public Object getModel() {
		// TODO Auto-generated method stub
		return tcm;
	}

}
