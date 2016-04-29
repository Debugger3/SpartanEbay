<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <jsp:include page="loginCheck.jsp" />
<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Delete item | ebay </title>
<style> 
.jumbotron{ 
background-color: DodgerBlue ; 
color:GhostWhite 
} 
.dropdown { 
-webkit-appearance: none; 
-moz-appearance: none; 
text-indent: 1px; 
text-overflow: '';
width:150px; 
} 
</style>
<script>

function goBack() {
    window.history.back();
}
</script>
</head>
<body>
<div class="container text-center">
		<s:action name="test" executeResult="true" />
		<br><br><br>
		
<div class="col-md-2">
</div>
 
<div class="container">
<img src="bootstrap/Images/tick.jpg" style="height:60px;width:40px"><font color="green">Deals successfully added.</font> 
</div>
<div class="col-md-3">
</div> 
</div>
</body>
</html>