package org.struts.action;

import org.struts.model.BuyNowModel;
import org.struts.service.PaymentBuyService;

import com.opensymphony.xwork2.ModelDriven;

public class PaymentAction1 implements ModelDriven{
	BuyNowModel bnm;
	public String execute()
	{
		return "success";
	}
	public String buy()
	{
		PaymentBuyService pbs=new PaymentBuyService();
		if(!pbs.checkCardInfo(bnm))
			{
			System.out.println("I m returning false ohhhhnooooo");
			return "error";
			}
		pbs.transaction(bnm);
		return "success";
	}
	@Override
	public Object getModel() {
		// TODO Auto-generated method stub
		bnm=new BuyNowModel();
		return bnm;
	}
}
