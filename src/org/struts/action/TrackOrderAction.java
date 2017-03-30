package org.struts.action;

import org.struts.model.OrderModel;
import org.struts.service.OrderService;

import com.opensymphony.xwork2.ModelDriven;

public class TrackOrderAction implements ModelDriven {
	OrderModel om=new OrderModel();
	public String execute() 
	{
		OrderService os=new OrderService();
		boolean status=os.listOrder(om);
		if(!status)
			return "error";
		return "success";
	}
	public String execute1() 
	{
		OrderService os=new OrderService();
		boolean status=os.listOrder1(om);
		if(!status)
			return "error";
		return "success";
	}
	
	public String rate() 
	{
		System.out.println("rating action called!!!!");
		OrderService os=new OrderService();
		double rating  = om.getRating();
	//	System.out.println("rating action called!!!!");
		String sellerid = om.getSellerIdrating();
		String itemId=om.getItemId();
		String orderId=om.getOrderId();
		System.out.println("rating=="+om.getRating()+"& selllerid=="+om.getSellerIdrating()+" orderid"+orderId);
		System.out.println("itemId "+itemId);
		boolean res = os.changeRating(rating , sellerid,itemId,orderId);
		//om.setRateFlag("Y");
		boolean status=os.listOrder(om);
		if(!status)
			return "error";
		return "success";
	}
	@Override
	public Object getModel() {
		// TODO Auto-generated method stub
		return om;
	}
}
