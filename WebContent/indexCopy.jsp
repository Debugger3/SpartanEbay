<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>   
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Electronics, Cars, Fashion, Collectibles, Coupons and More Online Shopping | eBay</title>
<style type="text/css">

.errorMessage {
  font-weight: light;
  color: red;
}
 
#owl-demo .owl-item {
  margin: 3px;
}

#owl-demo .owl-item img {
  display: block;
  width: 100%;
  height: 285px;
}

</style>

</head>
<body>
<div class="container text-center">
	<s:action name="test" executeResult="true" />
			  		
		<div class="row">
			<div class="span2">
			<s:action name="deal" executeResult="true" />
				
			</div>
			<div class="col-sm-8">
				<%@ include file="advertisement.jsp" %>
				<br><br>
				<a href="acknowledge.jsp"><strong>Acknowledge</strong></a><br>
				<a href="workaround.jsp"><strong>Work Around</strong></a>
			</div>  	
		<div class="span2">
						

			 
			  <%
			 System.out.println("i m here");
			 if(session.getAttribute("type")!=null && session.getAttribute("user")!=null)
			 {
				 System.out.println("i m here11");	 
			 String typeUser =session.getAttribute("type").toString();
			 String userId = session.getAttribute("user").toString(); if(typeUser.equals("seller")) { System.out.println("here in indexcopy.....inside if"+typeUser); %> 
			 <a href="reportAction"><strong>Generate Report</strong></a>
			 <a href="reportLabTest.jsp"><strong>Generate Report Lab Test</strong></a>
			 <% }
			 } %>
			 <a href="finalexam.jsp"><strong>Final Exam - 01 </strong></a>
			 <br>
			 <a href="finalexam2"><strong>Exam 01 - Report 2</strong></a>
			 <br>
 		</div>
		
		<div class="span2">
		 <a href="callReportCat"><strong>Generate Report by category</strong></a>
		 <br>
		 </div>
	</div>
<br>
</div>

</body>
</html>