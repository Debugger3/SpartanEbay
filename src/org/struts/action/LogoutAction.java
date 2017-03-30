package org.struts.action;
import java.util.Date;

 
import javax.servlet.http.HttpSession;

import org.apache.struts2.ServletActionContext;
 
import com.opensymphony.xwork2.*;
 
public class LogoutAction extends ActionSupport {
 
    public String execute() throws Exception { 
    	HttpSession session = ServletActionContext.getRequest().getSession(false);
    	session.removeAttribute("logined");
    	session.removeAttribute("context");
    	session.removeAttribute("user");
    	if(session.getAttribute("type").equals("user"))
    	{
    		session.removeAttribute("type");
    		return SUCCESS;
    	}
    	else {
    		session.removeAttribute("type");
    		return ERROR;
    	}
        
    }
 
}