<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="s" uri="/struts-tags"%> 
<jsp:include page="loginCheck.jsp" />
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<s:action name="test" executeResult="true" />
<br><br>
<h1 style="margin-left:300px;" >Welcome <s:property value="emailId" /></h1>

     		<br>
     	<!--<s:form action="MyWelcome" align='center'>
		<s:radio name="itemOption" list="#{'1':' Update Information'}" checked="true"/><br>
		<s:radio name="itemOption" list="#{'2':' Delete Account'}" />
		<br>
		<br>
		<s:submit onCLick="goBack()" value="Previous" class="btn btn-primary" />
		<s:submit class="btn btn-primary" value="Submit"/>
		
					<s:submit value="Home" action="homePageAction" class="btn btn-primary" />
					
			<s:submit action="userLogout" value="Logout" class="btn btn-primary"  />
			
			</s:form>   -->
</body>
</html>