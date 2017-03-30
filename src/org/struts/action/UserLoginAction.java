package org.struts.action;

import java.sql.*;

import java.util.Date;



import javax.servlet.http.HttpSession;

import org.apache.struts2.ServletActionContext;
import org.struts.utils.ConnectionPool;

import com.opensymphony.xwork2.*;

public class UserLoginAction extends ActionSupport {
        private static final long serialVersionUID = 1L;
        private String emailId;
        public String getEmailId() {
			return emailId;
		}

		public void setEmailId(String emailId) {
			this.emailId = emailId;
		}

		private String passwd;

    public String execute() throws Exception {
       // System.out.println("hellow"+userId+"--"+passwd);
         HttpSession session = ServletActionContext.getRequest().getSession();
         if(ConnectionPool.con==null)
	  			ConnectionPool.con=ConnectionPool.getConnection();
         String query="select * from user where emailId='"+emailId+"' and password='"+passwd+"'";
         PreparedStatement preparedStmt = ConnectionPool.con.prepareStatement(query);
         ResultSet rs=preparedStmt.executeQuery();
       // System.out.println("hellp");
        //System.out.println("username:"+userId+"  passwd"+passwd);
        
      while(rs.next())
      {
                System.out.println("Email:"+emailId+"  passwd"+passwd);
               System.out.println("successssss");
                session.setAttribute("logined","true");
                session.setAttribute("type", "userType");
                session.setAttribute("context", new Date());
                session.setAttribute("user", emailId);
                session.setAttribute("type", "user");
                // Better is using ActionContext
                //Map session = ActionContext.getContext().getSession();
                //session.put("logined","true");
                //session.put("context", new Date());
                System.out.println("returning success");
                return "success";    
    }
      System.out.println("returning error");
      return "error";
  }

  public String logout() throws Exception {
      HttpSession session = ServletActionContext.getRequest().getSession();
      session.removeAttribute("logined");
      session.removeAttribute("context");
      session.removeAttribute("user");
//Map session = ActionContext.getContext().getSession();
//session.remove("logined");
 //     session.remove("context");
      return "success";
  }

  public String getPasswd() {
      return passwd;
  }

  public void setPasswd(String passwd) {
      this.passwd = passwd;
  }


}

