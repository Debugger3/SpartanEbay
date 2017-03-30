package org.struts.action;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.text.SimpleDateFormat;
import java.util.*;
import javax.mail.*;
import javax.mail.internet.*;
import javax.servlet.http.HttpSession;

import org.apache.struts2.ServletActionContext;
import org.struts.utils.ConnectionPool;

import javax.activation.*;

public class sendMail
{
   public String execute()
   {     HttpSession se = ServletActionContext.getRequest().getSession();
   		String to="";
	   String host="smtp.gmail.com";  
	   final String user="ebayspartans@gmail.com ";//change accordingly  
	   final String password="Spartans@2016";//change accordingly  
	   // UUID uniqueKey = UUID.randomUUID();  
	   //String orderid = "OD"+uniqueKey;
	   String userId = se.getAttribute("user").toString();
	   to=userId;
	   Date date = new Date();
	   SimpleDateFormat sdf = new SimpleDateFormat("ddMMyyyyhmmss");
	   String formattedDate = sdf.format(date);
	   System.out.println(formattedDate); // 12/01/2011 4:48:16 PM
	   String orderid = "OD"+se.getAttribute("user").toString().substring(0,4).toUpperCase()+formattedDate;
	   System.out.println("order id is "+orderid);
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
	      message.setSubject("SPARTNAS EBAY");  
	      message.setText("Thank you for shopping with Spartans Ebay\nYou orderid is "+orderid);  
	        
	     //send the message  
	      Transport.send(message);  
	   
	      System.out.println("message sent successfully...");  
	    
	      } catch (MessagingException e) {e.printStackTrace();}  

	   return "success";
   }
}