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
<div class="container text-center">
<s:action name="test" executeResult="true" />

<br><br>

Are you sure you want to delete account!!!!
<s:form action="deleteAccount">
	
	<s:submit value="Home" action="homePageAction" class="btn btn-primary" />
	<s:submit class="btn btn-primary" value="Delete Account"/>
	<s:submit action="userLogout" value="Logout" class="btn btn-primary"  />
			
			</s:form>
</div>
</body>
</html>