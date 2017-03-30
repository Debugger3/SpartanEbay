package org.struts.action;
import org.struts.model.CategoryModel;
import org.struts.service.TestActionService;
import com.opensymphony.xwork2.ModelDriven;
public class testAction implements ModelDriven{
	CategoryModel tm=new CategoryModel();
	TestActionService ts;
	public String execute()
	{
		ts=new TestActionService();
		ts.insert(tm);
		System.out.println("In TestAction size of subCatList is "+tm.getSubCatList().size());
		return "success";	
	}
	@Override
	public Object getModel() {
		// TODO Auto-generated method stub
		return tm;
	}
}
