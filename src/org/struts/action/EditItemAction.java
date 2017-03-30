
package org.struts.action;
import java.sql.SQLException;

import javax.servlet.http.HttpSession;

import org.apache.struts2.ServletActionContext;
import org.apache.struts2.interceptor.validation.SkipValidation;
import org.struts.model.DeleteModel;
import org.struts.model.EditModel;
import org.struts.service.DeleteItemService;
import org.struts.service.EditItemService;

import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

public class EditItemAction extends ActionSupport  implements ModelDriven<EditModel> {
	EditModel dm=new EditModel();
	
	@SkipValidation
		public String execute()
		{
		 	HttpSession session = ServletActionContext.getRequest().getSession();
		 	session.setAttribute("edit", "yes");
			System.out.println("i m here in Edit Item Action");
			EditItemService ds=new EditItemService();
			ds.listItemKey(dm);
			return "success";
			
		}

	public String UpdateItem()
	{
		System.out.println("In update method");
		EditItemService ds=new EditItemService();
		try {
			ds.Update(dm);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return "success";
	}
		public String itemEditSubmit()
		{
			System.out.println("i m in Edit Submit");
			EditItemService ds=new EditItemService();
			ds.editItem(dm);
			return "success";
		}

		public void validate()
		{
			if(dm.getItemId().equals("0"))
			{
				System.out.println("Item Id is  0");
				addFieldError("itemId1", "Select item to be deleted");
			}
		}
		
		public String getitemKey()
		{
			return "0";
		}
		
		public EditModel getModel() {
			// TODO Auto-generated method stub
			System.out.println("calling model in delete");
			return dm;
		}
		public String readItemId()
		{
			return "success";
		}
		
}
