<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Sub Category Deleted</title>
<script>
function goBack() {
    window.history.back();
}
</script>
</head>
<body>
<s:action name="test" executeResult="true" />
<br><br><br><br><br>
<div class="container">
	SubCategory <s:property value="subCatName"/> is deleted...
</div>
<div class="container">
	<a href="welcome.jsp"> Admin Welcome Page </a>
	<br><br>
	<input type="button" value="Previous" class="btn btn-primary" onclick="goBack()"/>
	<s:form name="form1">
	
	<s:submit value="Home" action="homePageAction" class="btn btn-primary"></s:submit>
	</s:form>
</div>
</body>
</html>