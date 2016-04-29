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
<br><br>
<div class="col-md-2">
</div>
<div class="well col-md-7"> 
<div class="container">
<img src="bootstrap/Images/tick.jpg" style="height:60px;width:40px"><font color="green">Item <s:property value="itemName"/> successfully Updated.</font> 
</div>
<div class="col-md-3">
</div>
</div>
 
</body>
</html>