package org.struts.action;

public class CartAction {
	
	  private String user;

	   public String execute() throws Exception {
	      return "success";
	   }

	public String getUser() {
		return user;
	}

	public void setUser(String user) {
		this.user = user;
	}
	   
	   

}
