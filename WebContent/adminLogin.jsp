<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
 pageEncoding="ISO-8859-1"%>
 <%@ taglib prefix="s" uri="/struts-tags"%> 
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<script>
function goBack() {
    window.history.back();
}
</script>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<div class="container text-center">
<s:action name="test" executeResult="true" />
<br><br><br><br><Br><br>
<div class="col-md-4 col-md-offset-4" >
	<div class="panel panel-default">
    	<div class="panel-heading"> <strong class="">Admin Login</strong></div>
    </div>
    
<s:form action="login" method="post">
<div class="form-group">

  <s:textfield name="userId"  class="col-lg-10" placeholder="User id"/> <br/>
</div>
<div class="form-group">

<s:password  class="col-lg-10"  name="passwd" placeholder="Password"/> <br />
</div>
<br><br>
<s:submit action="login" value="Login" class="btn btn-primary col-lg-10"/>
</s:form>
<s:form>
<br><br>
<s:submit value="Previous" class="btn btn-primary" onClick="goBack()" />
<s:submit value="Home" action="homePageAction" name="home" class="btn btn-primary" />
</s:form>
</div>
</div>
</body>
</html>