<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<%@ taglib prefix="sx" uri="/struts-dojo-tags" %>

<jsp:include page="loginCheck.jsp" />
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<s:head theme="simple"/> 
  <sx:head/>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<div class="container text-center">
	<s:action name="test" executeResult="true" />
		<ul class="breadcrumb">
			<li>Home</li>
	  		<li>Report Test Lab</li>
		</ul>
		<s:form action="reportActionByDate">
		Start Date <sx:datetimepicker  name="startDate" id="start" displayFormat="dd/MM/yyyy" startDate="%{'today'}" value="%{'today'}"/>
		<br><br>
		End Date  <sx:datetimepicker  name="endDate" id="end" displayFormat="dd/MM/yyyy" startDate="%{'today'}" value="%{'today'}"/>
		<br><br>
		<s:submit value="Click hee to see the result "/>
		</s:form>
</div>
</body>
</html>