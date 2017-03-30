
package org.struts.action;
import org.apache.struts2.interceptor.validation.SkipValidation;
import org.struts.model.DeleteModel;
import org.struts.service.DeleteItemService;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

public class DeleteItemAction extends ActionSupport  implements ModelDriven<DeleteModel> {
	DeleteModel dm=new DeleteModel();
	
	@SkipValidation
		public String execute()
		{
			System.out.println("i m here in deleteItem Action");
			DeleteItemService ds=new DeleteItemService();
			ds.listItemKey(dm);
			return "success";
			
		}

		public String itemDeleteSubmit()
		{
			System.out.println("i m in itemDelete Submit");
			DeleteItemService ds=new DeleteItemService();
			ds.deleteItem(dm);
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
		
		public DeleteModel getModel() {
			// TODO Auto-generated method stub
			System.out.println("calling model in delete");
			return dm;
		}
		public String readItemId()
		{
			return "success";
		}
		
}
