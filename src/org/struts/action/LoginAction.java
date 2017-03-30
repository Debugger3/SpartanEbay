package org.struts.action;
import java.util.Date;


 
import javax.servlet.http.HttpSession;

import org.apache.struts2.ServletActionContext;
 
import com.opensymphony.xwork2.*;
 
public class LoginAction extends ActionSupport {
	private static final long serialVersionUID = 1L;
	private String userId;
    private String passwd;
    public String execute() throws Exception {
    	System.out.println("userId is  "+userId);
        if ("admin".equals(userId) && "password".equals(passwd)) {
        	System.out.println("in if or jmg");
            HttpSession session = ServletActionContext.getRequest().getSession();
          session.setAttribute("logined","true");
          session.setAttribute("context", new Date());
          session.setAttribute("user",userId);
          System.out.println("returning success");
          session.setAttribute("type", "admin");
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
        return "success";
    }
 
    public String getPasswd() {
        return passwd;
    }
 
    public void setPasswd(String passwd) {
        this.passwd = passwd;
    }
 
    public String getUserId() {
        return userId;
    }
 
    public void setUserId(String userId) {
        this.userId = userId;
    }
}