package org.struts.action;

import javax.servlet.http.HttpSession;

import org.apache.commons.lang.StringUtils;
import org.apache.struts2.ServletActionContext;
import org.apache.struts2.interceptor.validation.SkipValidation;
import org.struts.model.AddToCartModel;
import org.struts.model.ItemByCatModel;
import org.struts.service.AddItemService;
import org.struts.service.AddToCartService;
import org.struts.service.ItemByCatService;
import org.struts.service.SummaryService;

import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;
import com.opensymphony.xwork2.Preparable;

public class AddToCartAction extends ActionSupport implements ModelDriven , Preparable {
	private static final long serialVersionUID = 1L;
	AddToCartModel atcm;
	public String execute()
	{
		System.out.println("i am in add to cart action");
		AddToCartService atcs=new AddToCartService();
		atcs.modelInitialization(atcm);
		System.out.println("returning from  execute....... :)");
		return "success";
	}
	
	public String remove()
	{
		System.out.println("i am in add to remove action");
		AddToCartService atcs=new AddToCartService();
		atcs.removeItem(atcm);
		System.out.println("returning here :)");
		String abc = execute();
		return "success";
	}
	
	public String update()
	{
		System.out.println("i am in add to update action");
		AddToCartService atcs=new AddToCartService();
		atcs.updateItem(atcm);
		System.out.println("returning here from update........ :)");
	//	String abc = execute();
		return "success";
	}
	
	public String summary()
	{
		System.out.println("i am in add to summary action");
		SummaryService atcs=new SummaryService();
		atcs.modelInitialization(atcm);
		System.out.println("returning here :)");
		return "success";
	}
	
	public String dealCart()
	{
		System.out.println("i am in add to update action");
		AddToCartService atcs=new AddToCartService();
		atcs.dealCart(atcm);
		System.out.println("returning here from update........ :)");
	//	String abc = execute();
		return "success";
	}

/*	public void validate()
	{
		 HttpSession session = ServletActionContext.getRequest().getSession();
        String user = session.getAttribute("user").toString();
        if(user!=null)
        {
			AddToCartService addService=new AddToCartService();
			if(!addService.validate(atcm))
			{
				System.out.println("Item Id already exixts ");
				addFieldError("itemId", "Item Id already exists");
			}
        }
	}	
*/
	@Override
	public Object getModel() {
		// TODO Auto-generated method stub
		return atcm;
	}

	@Override
	public void prepare() throws Exception {
		// TODO Auto-generated method stub
		
		atcm=new AddToCartModel();
		
	}
	
}