<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>    
<jsp:include page="loginCheck.jsp" />
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<script>
function goBack() {
    window.history.back();
}
</script>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Item Management |ebay </title>
<style type="text/css">

body {
    background-color: GhostWhite ;
}
h3{
    
    font-weight:bold;
    
    color:GhostWhite;

    }
    h4{
    
    font-weight:bold;
    
    color:grey;

    }
        .jumbotron{
        background-color: DodgerBlue 
        }
    
    .banner{
    width:100%;
    max-height:300px;
        }
</style>
</head>
<body>
<div class="container text-center">
<s:action name="test" executeResult="true" />
<br><br><br><br><br>

	<div class ="jumbotron">
		<h3>
			ITEM MANAGEMENT
		</h3>
	</div>
	<h5>Seller Id Logged in is <%=session.getAttribute("user") %></h5>
	<a href="logout.action">Logout</a>
	<div class="col-sm-12">
	</div>
    
    
	<div class="well">
		<s:form action="itemAction">
		<s:radio name="itemOption" list="#{'1':'Add Item'}" checked="true"/><br>
		<s:radio name="itemOption" list="#{'2':'Delete Item'}" /><br>
		<s:radio name="itemOption" list="#{'3':'Add Deals'}" /><br>
		<s:radio name="itemOption" list="#{'7':'Delete Deals'}" /><br>
		<s:radio name="itemOption" list="#{'4':'Update Account'}" /><br>
		<s:radio name="itemOption" list="#{'5':'Delete Account'}" />
		<br><s:radio name="itemOption" list="#{'6':'Edit Item'}" />
		<br>
		<input type="button" value="Previous Page" onclick="goBack()" class="btn btn-primary"/>
		<s:submit class="btn btn-primary" value="Submit"/>
		<s:submit action="homePageAction" value="Home Page" class="btn btn-primary" />
		</s:form>
	</div>
	</div>
</body>
</html>