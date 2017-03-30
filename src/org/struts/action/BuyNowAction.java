package org.struts.action;

import org.struts.model.BuyNowModel;
import org.struts.service.BuyNowService;

import com.opensymphony.xwork2.ModelDriven;

public class BuyNowAction implements ModelDriven{

	BuyNowModel bnm=new BuyNowModel();;
	public String execute()
	{
		BuyNowService buyService=new BuyNowService();
		System.out.println("bnm.getQuantity1 "+bnm.getQuantity1());
		if(bnm.getQuantity1()>0)
			bnm.setQuantity(bnm.getQuantity1());
		if(!buyService.setAddress(bnm))
			return "loginError";
		System.out.println("quantiyt"+bnm.getQuantity());
		if(!buyService.checkQuantity(bnm))
			//return "quantityMore";
			System.out.println("less quantity");
		System.out.println(bnm.getQuantity());
		System.out.println("cost is "+bnm.getCost());
		System.out.println("cost is "+bnm.getDiscountedCost());
		return "success";
	}
	
	public String redirect()
	{
		System.out.println("i  m in redirect "+bnm.getItemId());
		return "success";
	}
	
	public String addAddress()
	{
		BuyNowService buyService=new BuyNowService();
		buyService.addAddress(bnm);
		if(!buyService.setAddress(bnm))
			return "loginError";
		return "success";
	}
	public String deleteAddress()
	{
		BuyNowService buyService=new BuyNowService();
		buyService.deleteAddress(bnm);
		if(!buyService.setAddress(bnm))
			return "loginError";
		return "success";
	}
	@Override
	public Object getModel() {
		// TODO Auto-generated method stub
		
		return bnm;
	}

}
