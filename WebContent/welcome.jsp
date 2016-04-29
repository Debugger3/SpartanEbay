<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="s" uri="/struts-tags"%> 
<jsp:include page="loginCheck.jsp" />
<html>
<head>
<script>
function goBack() {
    window.history.back();
}
</script>
<style type="text/css">
.errorMessage {
  font-weight: light;
  color: red;
}
</style>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<meta name="viewport" content="width=device-width, initial-scale=1">
<title>Welcome</title>
</head>
<body>
<s:action name="test" executeResult="true" />
<br><br><br><br><br>
<div class="container">
Welcome Admin, you have logged in. <br />
The attribute of 'context' in session is
<s:property value="#session.context" />
<br /><br /><br />
	<div class="col-lg-5">
<a href="logout.action">Logout</a>
<br><br>
<a href="success.jsp">Enter a new Subcategory</a>
<br><br>
<s:form>
<s:submit action="deleteSuCat" value="Delete Subcategory" />
</s:form>
<br><br>
</div>
<div class="col-lg-8 well">
		<div class="jumbotron">
		<h3>Enter New Category Details</h3> 
		</div>
		<s:form action="addCat">
        	<div class="form-group">
        	<label for="new-cat">Enter the new category</label>
     			<div class="col-lg-10">
     				<s:textfield id="new-cat" name="newCat" property="newCat" />
     				<s:fielderror>
				    <s:param>newCat</s:param>
					</s:fielderror>
     			</div>
     		</div>
     		<div class="form-group">
        	<label for="cat-desc">Category description</label>
     			<div class="col-lg-10">
     				<s:textfield id="cat-desc" name="catDesc" property="catDesc" />
     				<s:fielderror>
				    <s:param>catDesc</s:param>
					</s:fielderror>
     			</div>
     		</div>
     		
     		<div class="form-group">
     		<div class="col-lg-10">
     		<br><br>
			<s:submit value="Previous" class="btn btn-primary" onCLick="goBack()"/>
			<s:submit value="Add" class="btn btn-primary"/>
			<s:submit value="Home" action="homePageAction" class="btn btn-primary" />
			</div></div>        
			</s:form>           
     	</div>
	</div>
	
</body>
</html>