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
<h2>Student Name: sanat jain</h2><br>
<h3>Roll Number: mt2015097</h3>

  <s:form action="itemDetail" name="sellerLogin">
        Brand(Enter)  <s:textfield name="brand"  property="brand" />
        
        
        <br><br>
  
	<s:submit value="Submit"  class="btn btn-primary"/>
	
	</s:form>
	
</body>
</html>