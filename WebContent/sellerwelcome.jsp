<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%> 
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<script>
function goBack() {
    window.history.back();
}
</script>
</head>
<body>
<div class="container text-center">
<s:action name="test" executeResult="true" />
</div>
<br><br><br><br><br><br>
Welcome   <s:property value="userId" />
<br>
<br>
<a href="<%= request.getContextPath() %>/logout.action">Logout</a>
<br />
<a href="itemManagement.jsp">Redirect to ITEM MANAGEMENT</a>
<s:submit value="Previous" class="btn btn-primary" onCLick="goBack()"/>
<s:submit value="Home" action="homePageAction" name="home" class="btn btn-primary" />
</body>
</html>