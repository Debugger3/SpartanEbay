<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>      
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<script>
function goBack() {
    window.history.back();
}
</script>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>

</head>
<body>
<s:action name="test" executeResult="true" />
<br><br><br><br><br>
Successfully Inserted Seller Id <s:property value ="sellerId"/> <br>
<a href="register.jsp">Back</a>
<s:submit value="Previous" class="btn btn-primary" onCLick="goBack()"/>
<s:submit value="Home" action="homePageAction" name="home" class="btn btn-primary" />
</body>
</html>