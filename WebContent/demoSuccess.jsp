<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
 <link rel="stylesheet" href="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/css/bootstrap.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.0/jquery.min.js"></script>
  <script src="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/js/bootstrap.min.js"></script>
   
     <script src="bootstrap/js/jquery.js"></script>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<style type="text/css">
 .body{
 height: 100%;
 min-height:100%;
}
</style>
<title>Insert title here</title>
</head>
<body>
 <%Object flag1 =session.getAttribute("subcatId");
 String flag=null;
 if(flag1!=null)
 {
	flag=flag1.toString();
 }
 	
 	%>
<div class="container">
<h3>

<% if(flag != null) { %>
Cost updated successfully
<%} else{%>
Sub Category deleted successfully
<%} %>
</h3>
</div>
</body>
</html>