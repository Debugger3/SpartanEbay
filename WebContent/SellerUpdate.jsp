<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>  
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
  <meta name="viewport" content="width=device-width, initial-scale=1">
<title>Register Page | eBay</title>
<style type="text/css">
.errorMessage {
  font-weight: light;
  color: red;
}
</style>
<script>
function checkPass()
{
    var pass1 = document.getElementById('pass1');
    var pass2 = document.getElementById('pass2');
    var message = document.getElementById('confirmMessage');
    var goodColor = "#66cc66";
    var badColor = "#ff6666";

    if(pass1.value == pass2.value){
        pass2.style.backgroundColor = goodColor;
        message.style.color = goodColor;
        message.innerHTML = "Passwords Match!"
    }else{
        pass2.style.backgroundColor = badColor;
        message.style.color = badColor;
        message.innerHTML = "Passwords Do Not Match!"
    }
}  

function goBack() {
    window.history.back();
}
</script>
</head>
<body>


<div class="container text-center">
<s:action name="test" executeResult="true" />
<br><br><br><br><br>
	<div class="row">
    <div class="col-md-4 col-md-offset-4">
    <div class="form-group col-md-offset-4 " >	
      
        </div>
        </div>
        <div class="col-md-4 col-md-offset-4" >
            <div class="panel panel-default">
                <div class="panel-heading"> <strong class="">Update Seller Information</strong>
             </div></div>


<!-- <div class="container well" >-->
<div class="panel-body">
<s:form  action="SellerUpdate1" label="A sample horizontal Form" cssClass="form-horizontal">

   	<div class="form-group"> 
			<label for="inputPassword3" class="col-sm-3 control-label">Seller Name</label> 
	<div class="col-sm-9">
	<s:textfield label="Seller-Name :" key="sellerName" value="%{rm.sellerName}" />
	<s:fielderror>
    <s:param>sellerName</s:param>
	</s:fielderror>
	
	</div>
	</div>
	<div id="loginForm">
	   	<div class="form-group"> 
			<label for="inputPassword3" class="col-sm-3 control-label">Password</label> 
	<div class="col-sm-9">
	<s:textfield name="pass" label="Password :" key="password" id="pass1" value="%{rm.pass}" />
	<s:fielderror>
    <s:param>password</s:param>
	</s:fielderror>
	
	</div>
	</div>
	   <div class="form-group"> 
		<label for="inputPassword3" class="col-sm-3 control-label">Seller Address</label>
  	<div class="col-sm-9">
	<s:textfield label="Shipping Address :" key="sellerAdd"  name="sellerAdd" value="%{rm.sellerAdd}"/>
	<s:fielderror>
    <s:param>sellerAdd</s:param>
	</s:fielderror>
	</div>
	</div>
	<div class="form-group"> 
			<label for="inputPassword3" class="col-sm-3 control-label">Email Id:</label> 
	<div class="col-sm-9">
	<s:textfield label="Email-Id :" key="email" value="%{rm.email}" />
	</div>
	</div>
	<div class="form-group"> 
			<label for="inputPassword3" class="col-sm-3 control-label">Contact No. :</label> 
	<div class="col-sm-9">
	<s:textfield label="Contact :" key="contact" value="%{rm.contact}" />
	</div>
	</div>
	<div class="form-group"> 
			<label for="inputPassword3" class="col-sm-3 control-label">Nature of Business</label> 
	<div class="col-sm-9">
	<s:textfield label="Nature-Business :" name="nature" key="nature" value="%{rm.nature}"/>
	</div>
	</div>
	<div class="form-group last">
	<div class="row">
	<s:submit value="Previous" class="btn btn-primary" onCLick="goBack()"/>
	<s:submit value="Submit"  class="btn btn-primary" />
	<s:submit value="Home" action="homePageAction" name="home" class="btn btn-primary" />
	</div>
</div>

</s:form>
</div>
</div>
</div>
</div>
</body>
</html>