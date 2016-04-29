<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="s" uri="/struts-tags"%> 
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Reset Password</title>
</head>
<body>
<s:action name="test" executeResult="true" />
</br></br></br></br>
<h3><font color="green">We've sent email to <b></b><s:property value="emailId" /></b></h3></font>
Follow the instructions in the email to reset your password
</br></br>
Your email may take up to 5 minutes to arrive (depending on your email service provider).<br>
If you don't receive an email, try the following:

<b>Check your spam or junk mail folder</b>



     		<div class="form-group">
     		<div class="col-lg-10">
     		<br><br>
			<s:submit onCLick="goBack()" value="Previous" class="btn btn-primary" />
			<s:submit action="userLogout" value="Logout" class="btn btn-primary"  />
			<s:submit value="Home" action="homePageAction" class="btn btn-primary" />
			</div></div>     
</body>
</html>