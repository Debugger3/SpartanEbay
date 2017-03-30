package org.struts.action;

import org.struts.model.AddSubCatModel;
import org.struts.model.CallModel;
import org.struts.service.AddSubCatService;
import com.opensymphony.xwork2.ModelDriven;

public class AddSubCatAction implements ModelDriven {
	AddSubCatModel asc=new AddSubCatModel();
	public String categoryList()
	{
		AddSubCatService as=new AddSubCatService();
		as.categoryList(asc);
		return "success";
	}
	@Override
	public Object getModel() {
		// TODO Auto-generated method stub
		return asc;
	}

}
