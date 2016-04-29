<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>

<s:action name="test" executeResult="true" />
<br><br><br><br><br>

<br>

<h1> Reset your password</h1>
Enter the email address you use to buy or sell on eBay. 
 <s:form action="forgotpassword" name="forgotpassword">
 <br><br>
         <s:textfield name="emailId"  property="emailId" />
        <br><br>
       <s:submit value="Continue" class="btn btn-primary" />
        
        	</s:form>
</body>
</html>