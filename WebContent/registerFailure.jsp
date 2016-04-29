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
<s:action name="test" executeResult="true" />
<br><br><br><br><br>
Seller Id already exist please choose different one!!
<br>

<s:form>
<input type="button" value="Previous" class="btn btn-primary" onclick="goBack()"/>			
	<s:submit value="Home" action="homePageAction" class="btn btn-primary"></s:submit></div>
</s:form>
</body>
</html>