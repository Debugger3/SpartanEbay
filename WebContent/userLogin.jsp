<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<%@ taglib prefix="sx" uri="/struts-dojo-tags" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd"> 
<html>
<head>
<style>
.flat-form {
  
  margin: 30px auto;
  width: 390px;
  height: 350px auto;
  position: relative;
  font-family: 'Roboto';
}
</style>
<s:head theme="simple"/> 
  <sx:head/>
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
<br>
<br>
<div id="over" style="position:middle; width:100%; height:100%">
	<a href="indexCopy.jsp"><img  src="bootstrap/Images/test.png"/></a>
</div>
<br>

  <div class="flat-form" style="box-shadow: 0 0 30px black;">
  <ul class="nav nav-tabs">
    <li class="active"><a data-toggle="tab" href="#home">Sign In</a></li>
    <li><a data-toggle="tab" href="#menu1">Register</a></li>
    
  </ul>
  
    <div class="tab-content" >
    	<div id="home" class="tab-pane fade in active" style="margin-left: 70px; margin-bottom: 40px;">
    	<s:form action="UserLogin" name="userLogin">
    	<br>
    	<s:textfield name="emailId"  class="col-lg-10" placeholder="Email" required="true"/>
        <br><br>
        <s:password name="passwd"  property="passwd" class="col-lg-10" placeholder="Password" required="true"/>
        <br><br>
        <s:submit value="Login"  class="btn btn-primary col-lg-10"/>
        <br><br>
        <a href="reset.jsp">Forgot your password?</a>
        <br><br>
        </s:form>
  	</div>
  	
  	    <div id="menu1" class="tab-pane fade " style="margin-left: 50px; margin-bottom: 40px;">
  	    <s:form action="UserRegister" name="userRegister">
  	    <br>
  	    <s:textfield name="email" placeholder="Email" class="col-lg-10" required="true"/>
        <br><br>
        <s:textfield name="reemail" class="col-lg-10" placeholder="Reenter Email"  required="true"/>
        <br><br>
          <s:password name="password" placeholder="Password" class="col-lg-10" required="true"/>
          <br><br>
          <s:textfield name="fname" class="col-lg-5"  placeholder="First name"  required="true"/>
          
         <s:textfield name="lname" class="col-lg-5" placeholder="Last name"  required="true"/>
             <br><br>
        <s:textfield name="userId" class="col-lg-10" placeholder="User Id"  required="true"/>
         <br><br>
          <s:textfield name="phone_no" class="col-lg-10" placeholder="Phone No"  required="true"/>
          <br><br>
		DOB: <sx:datetimepicker name="dob" displayFormat="dd/MM/yyyy" startDate="%{'20/01/1850'}" value="%{'today'}" endDate="%{'today'}" />
             <br><br>
        <s:submit value="Register"  class="btn btn-primary col-lg-10"/>
        <br><br>
        <p style="margin-right: 20px; margin-bottom: 40px;">By clicking <b>Register</b>, you agree that you have read and accepted 
        the <b>eBay User Agreement</b>,<b> Paisapay User Agreement</b>,<b> eBay Rules</b> and <b>Policies and User Privacy Notice</b> and that you are at least 18 years old.</p>
        </s:form>
  	    </div>
  	    </div></div>

 
</div>
	

</body>
</html>