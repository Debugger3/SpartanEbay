<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd"> 
<html>
<head>
<script>
function goBack() {
    window.history.back();
}
</script>
<title>Login|Registration Page</title>
</head>
<body>
<div class="container text-center">
<s:action name="test" executeResult="true" />
<br><br><br>

<br>


  	<div id="userlogin" style="margin-right:350px;float:right;">
  	<div class="panel panel-default">
	<div class="panel-heading"> <strong class="">Update Information</strong>
	</div>
</div>
    <s:form action="UserUpdate1" >
             User Id   <s:textfield name="userId"  property="userId" value="%{urm.userId}"/>
         <br><br>
        
        First Name   <s:textfield name="fname"  property="fname" value="%{urm.fname}" />
          <br><br>
        Last Name   <s:textfield name="lname"  property="lname" value="%{urm.lname}"/>
             <br><br>
        Password   <s:textfield name="password"  property="password" value="%{urm.password}" />
          <br><br>
      
          Phone no  <s:textfield name="phone_no"  property="phone_no" value="%{urm.phone_no}"/>
          <br><br>
          Date of Birth  <s:textfield name="dob" value="%{urm.dob}"  property="%{urm.dob}" />
		<br><br>
		    <s:submit value="Previous" class="btn btn-primary" onCLick="goBack()"/>
	
	<s:submit action="homePageAction" value="Home" class="btn btn-primary" />
	  <s:submit value="Update"  class="btn btn-primary"/>
		
             
        	</s:form>
  	</div>

  
	</div>

</body>
</html>