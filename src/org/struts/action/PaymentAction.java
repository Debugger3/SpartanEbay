package org.struts.action;

import org.struts.model.PaymentModel;
import org.struts.service.PaymentService;

import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

public class PaymentAction extends ActionSupport implements ModelDriven{
	PaymentModel pm = new PaymentModel();
	public String execute(){
		PaymentService ps=new PaymentService();
		
		if(ps.checkCardInfo(pm))
		{	sendMail sm=new sendMail();
			sm.execute();
		    return SUCCESS;
		}
		return ERROR;
	}

	@Override
	public Object getModel() {
		// TODO Auto-generated method stub
		return pm;
	}
	

}
