package org.struts.action;

import java.sql.*;
import java.util.Date;



import javax.servlet.http.HttpSession;

import org.apache.commons.lang.StringUtils;
import org.apache.struts2.ServletActionContext;
import org.struts.utils.ConnectionPool;

import com.opensymphony.xwork2.*;

public class addCatAction extends ActionSupport {
       private static final long serialVersionUID = 1L;
        private String newCat;
        private String catDesc;
        public String getNewCat() {
			return newCat;
		}

		public void setNewCat(String newCat) {
			this.newCat = newCat;
		}
    public String getCatDesc() {
			return catDesc;
		}

		public void setCatDesc(String catDesc) {
			this.catDesc = catDesc;
		}

	public String execute() throws Exception {
        System.out.println("hello in add category");
         HttpSession session = ServletActionContext.getRequest().getSession();
         if(ConnectionPool.con==null)
	  			ConnectionPool.con=ConnectionPool.getConnection();
         System.out.println("connection done");
         String query="INSERT INTO category(categoryName, categoryDesc) VALUES ('"+newCat+"','"+catDesc+"')";
         PreparedStatement preparedStmt = ConnectionPool.con.prepareStatement(query);
         int i=preparedStmt.executeUpdate();
       // System.out.println("hellp");
        System.out.println(newCat+"...."+catDesc);
        
      if(i>0)
      {
                System.out.println("inserted new category");
                query="select categoryId from category where categoryName='"+newCat+"'";
                preparedStmt = ConnectionPool.con.prepareStatement(query);
                ResultSet rs=preparedStmt.executeQuery();
                String catId="";
                while(rs.next())
                {
                	 catId=(String)rs.getString(1);
                }
                System.out.println(catId);
          System.out.println("returning success in cate");
            return "success";
        
    }
      System.out.println("returning error in cate");
      return "error";
  }

  public String logout() throws Exception {
      HttpSession session = ServletActionContext.getRequest().getSession();
      session.removeAttribute("logined");
      session.removeAttribute("context");
      session.removeAttribute("user");
      return "success";
  }
  public void validate()
  {
	  if(StringUtils.isEmpty(newCat))
		 {
		    addFieldError( "newCat", "newCat is not given." );
		 }
	  if(StringUtils.isEmpty(catDesc))
      	{
			System.out.println("validation checking of catDesc ");
			addFieldError("catDesc","Category Description can not be empty");
      	}	
		
		 
  }
}

  