package org.struts.action;

import java.sql.*;

import java.util.Date;



import javax.servlet.http.HttpSession;

import org.apache.commons.lang.StringUtils;
import org.apache.struts2.ServletActionContext;
import org.struts.service.AddItemService;
import org.struts.utils.ConnectionPool;

import com.opensymphony.xwork2.*;

public class addsubCat extends ActionSupport {
        private static final long serialVersionUID = 1L;
        private String subcatName;
        private String subcatDesc;
        private String item;

    public String execute() throws Exception {
    	 if(ConnectionPool.con==null)
	  			ConnectionPool.con=ConnectionPool.getConnection();
    	 System.out.println("in adding subcategory for "+item);
    	String query="select categoryId from category where categoryName='"+item+"'";
    	PreparedStatement   preparedStmt = ConnectionPool.con.prepareStatement(query);
        ResultSet rs=preparedStmt.executeQuery();
        int catId=0;
        while(rs.next())
        {
        	 catId=Integer.parseInt((String)rs.getString(1));
        }
        System.out.println("received catefory id is"+catId);
        System.out.println("hellow");
         HttpSession session = ServletActionContext.getRequest().getSession();
        
         query="insert into subcategory(subcatName,subcatDesc,categoryId) values('"+subcatName+"','"+subcatDesc+"','"+catId+"')";
 		 preparedStmt = ConnectionPool.con.prepareStatement(query);
         int i=preparedStmt.executeUpdate();
         while(i>0)
      {
                System.out.println("successssss");
      
                
         //   session.setAttribute("logined","true");
          //session.setAttribute("context", new Date());
      
// Better is using ActionContext

  //Map session = ActionContext.getContext().getSession();
//session.put("logined","true");
  //          session.put("context", new Date());
          System.out.println("returning success");
          return "success";
        
    }
      System.out.println("returning error");
      return "error";
  }

    public void validate()
	{
		if(StringUtils.isEmpty(subcatName))
        {
			System.out.println("validation checking of sub category Name ");
			addFieldError("subcatName1","Category Name can not be empty");
		}
		if(StringUtils.isEmpty(subcatDesc))
		 {
		    addFieldError( "subcatDesc1", "Subcategory Description is not given." );
		 }
		 
	}
	  
  public String logout() throws Exception {
      HttpSession session = ServletActionContext.getRequest().getSession();
      session.removeAttribute("logined");
      session.removeAttribute("context");
      session.removeAttribute("user");
      return "success";
  }

public String getSubcatName() {
	return subcatName;
}

public void setSubcatName(String subcatName) {
	this.subcatName = subcatName;
}

public String getSubcatDesc() {
	return subcatDesc;
}

public void setSubcatDesc(String subcatDesc) {
	this.subcatDesc = subcatDesc;
}

public String getItem() {
	return item;
}

public void setItem(String item) {
	this.item = item;
}

}

