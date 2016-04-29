<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <jsp:include page="loginCheck.jsp" />
<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Add Deals| ebay </title>

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
<div class="container text-center"  >
<s:action name="test" executeResult="true" />
<br><br><br><br><br>
<div class="jumbotron">
  <h2> Add Deal </h2>
</div>

<br><br>
<s:form method="post" action="dealAdded"  label="A sample horizontal Form" >
  <div class="form-group">
  Item 1 :
  <s:select list="itemList" id="itemId1" name="itemId1"
                              listValue="itemId" listKey="itemId"
                              headerKey="0" headerValue="Select Item : "  onChange="changeIt(this)"
                              ></s:select>
	
	<br>
	<br>
	Item 2 :
	 <s:select list="itemList" id="itemId2" name="itemId2"
                              listValue="itemId" listKey="itemId"
                              headerKey="0" headerValue="Select Item : "  onChange="changeIt(this)"
                              ></s:select>
	<br>
	<br>
	
	Item 3 :
	 <s:select list="itemList" id="itemId3" name="itemId3"
                              listValue="itemId" listKey="itemId"
                              headerKey="0" headerValue="Select Item : "  onChange="changeIt(this)"
                              ></s:select>
	<br>
	<br>
  
  <br>
  <br>  
  <s:submit value="Previous" class="btn btn-primary" onClick="goBack()"/>
  <s:submit action="dealAdded" value="Add " class="btn btn-primary"/>
  <s:submit action="homePageAction" value="Home" class="btn btn-primary"/>
</div>
</s:form>
</div>
</body>
</html>