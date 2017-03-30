package org.struts.action;
import org.struts.model.Filtermodel;
import org.struts.service.FilterService;
import com.opensymphony.xwork2.ModelDriven;
public class FilterAction implements ModelDriven<Filtermodel>{
	Filtermodel fm=new Filtermodel();
	public String execute()
	{
		System.out.println("I am Filter Action");
		System.out.println("I am new" + fm.getCatId());
		System.out.println(fm.getCheckMe());
		System.out.println(fm.getCheckMe1());
		FilterService fs=new FilterService();
		fs.filtering(fm);
		return "success";
		
	}
	public Filtermodel getModel() {
		// TODO Auto-generated method stub
	
		return fm;
	}
} 
