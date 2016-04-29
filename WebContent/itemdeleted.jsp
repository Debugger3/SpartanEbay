<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>        
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Item Deleted</title>
<script>
function goBack() {
    window.history.back();
}
</script>
</head>
<body>
<s:action name="test" executeResult="true" />
<br><br><br><br><br>
Item is deleted...
<br><br>
<s:submit type="button" value="Previous Page" onclick="goBack()" class="btn btn-primary"/>
<s:form>
<s:submit action="homePageAction" value="Home Page" class="btn btn-primary" />
</s:form>
</body>
</html>