package org.struts.action;

import java.sql.*;

import java.util.Date;
import java.util.Properties;
import java.util.UUID;

import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import javax.servlet.http.HttpSession;

import org.apache.struts2.ServletActionContext;
import org.struts.utils.ConnectionPool;

import com.opensymphony.xwork2.*;

public class ForgotAction extends ActionSupport {
        private static final long serialVersionUID = 1L;
        private String emailId,password;

    public String getEmailId() {
			return emailId;
		}

		public void setEmailId(String emailId) {
			this.emailId = emailId;
		}

	public String execute() throws Exception {
       // System.out.println("hellow"+userId+"--"+passwd);
		System.out.println("password change requested for"+emailId);
         HttpSession ses = ServletActionContext.getRequest().getSession();
         if(ConnectionPool.con==null)
	  			ConnectionPool.con=ConnectionPool.getConnection();
         String query="select * from user where emailId=?";
         
         System.out.println("Email forgot....>>"+emailId);
         PreparedStatement preparedStmt = ConnectionPool.con.prepareStatement(query);
        preparedStmt.setString(1, emailId);
         ResultSet rs=preparedStmt.executeQuery();
         
       // System.out.println("hellp");
        //System.out.println("username:"+userId+"  passwd"+passwd);
        
      while(rs.next())
      {
    		String to="";
    		   String host="smtp.gmail.com";  
    		   final String user="sanat1111jain93@gmail.com";//change accordingly  
    		   final String password="parija21-12-1993";//change accordingly  
    		   UUID uniqueKey = UUID.randomUUID();  
    		   String orderid = "OD"+uniqueKey;
    		   
    		     to=emailId;
    		   
    		    //Get the session object  
    		    Properties props = new Properties();  
    		    props.put("mail.smtp.host",host);  
    		    props.put("mail.smtp.starttls.enable","true");
    		    props.put("mail.smtp.auth", "true");  
    		      
    		    Session session = Session.getDefaultInstance(props,  
    		   	     new javax.mail.Authenticator() {  
    		   	       protected PasswordAuthentication getPasswordAuthentication() {  
    		   	     return new PasswordAuthentication(user,password);  
    		   	       }  
    		   	     });  
    		   
    		    //Compose the message  
    		     try {  
    		      MimeMessage message = new MimeMessage(session);  
    		      message.setFrom(new InternetAddress(user));  
    		      message.addRecipient(Message.RecipientType.TO,new InternetAddress(to));  
    		      message.setSubject("Spartan's ebay!");  
    		      message.setText("Your password is : "+rs.getString("password"));  
    		        
    		     //send the message  
    		      Transport.send(message);  
    		   
    		      System.out.println("message sent successfully...");  
    		    
    		      } catch (MessagingException e) {e.printStackTrace();}  

    		   return "success";
    
      }
     // System.out.println("returning error");
      return "error";
  }

  public String logout() throws Exception {
      HttpSession session = ServletActionContext.getRequest().getSession();
      session.removeAttribute("logined");
      session.removeAttribute("context");
      session.removeAttribute("user");
      session.removeAttribute("type");
//Map session = ActionContext.getContext().getSession();
//session.remove("logined");
 //     session.remove("context");
      return "success";
  }

}

