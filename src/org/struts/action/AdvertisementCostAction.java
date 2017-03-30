package org.struts.action;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import org.struts.model.AddItemModel;
import org.struts.service.AddItemService;
import org.struts.service.AdvertisementCostService;
import org.struts.utils.ConnectionPool;

import com.opensymphony.xwork2.ModelDriven;

public class AdvertisementCostAction implements ModelDriven{
	
	AddItemModel am=new AddItemModel();
	
	public String execute()
	{		
		AdvertisementCostService addService=new AdvertisementCostService();
		if(addService.advr(am))
			return "SUCCESS";
		else
	      return "ERROR";	    

	}

	@Override
	public Object getModel() {
		// TODO Auto-generated method stub
		return am;
	}
}
