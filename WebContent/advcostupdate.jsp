<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="s" uri="/struts-tags"%> 
<jsp:include page="loginCheck.jsp" />
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<link rel="stylesheet" href="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/css/bootstrap.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.0/jquery.min.js"></script>
  <script src="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/js/bootstrap.min.js"></script>
   
     <script src="bootstrap/js/jquery.js"></script>
<style type="text/css">
 .body{
 height: 100%;
 min-height:100%;
}
</style>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<div class="container well ">
	<s:form action="updateadvcost">
	<center>
	Advertisement cost :<s:textfield name="advcost" placeholder="Enter Advertisement cost"></s:textfield>
	<br><br> <s:submit value="Enter" class="btn btn-primary"/></center>
	
	</s:form>
</div>
</body>
</html>