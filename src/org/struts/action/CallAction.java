package org.struts.action;

import org.struts.model.CallModel;
import org.struts.service.CallService;
import com.opensymphony.xwork2.ModelDriven;

public class CallAction implements ModelDriven<CallModel> {
	CallModel cm=new CallModel();
	
	public String execute()
	{
		System.out.println("i m here in CallItem Action");
		CallService cs=new CallService();
		cs.listCategory(cm);
		return "success";
	}
	/*public String deleteSubCat()
	{
		CallService cs=new CallService();
		cs.listItemKey(cm);
		return "success";
	}*/
	public String getDefaultValue()
	{
		return "N";
	}
	public CallModel getModel() {
		// TODO Auto-generated method stub
	
		return cm;
	}

}
