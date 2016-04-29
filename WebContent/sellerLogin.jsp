<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd"> 
<html>
<head>
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
<style>
.flat-form {
  
  margin: 30px auto;
  width: 390px;
  height: 350px auto;
  position: relative;
  font-family: 'Roboto';
}
</style>
<title>Login Page</title>
</head>
<body>
<div class="container text-center">
<s:action name="test" executeResult="true" />
<br><br>

<div id="over" style="position:middle; width:100%; height:100%">
	<a href="indexCopy.jsp"><img  src="bootstrap/Images/test.png"/></a>
</div>
<br>
<div class="flat-form" style="box-shadow: 0 0 30px black;">
  <ul class="nav nav-tabs">
    <li class="active"><a data-toggle="tab" href="#home">Seller Sign In</a></li>
    <li><a data-toggle="tab" href="#menu1">Seller Register</a></li>
    
  </ul>

  
    <div class="tab-content" >
    	<div id="home" class="tab-pane fade in active" style="margin-left: 70px; margin-bottom: 40px;">
    	<s:form action="sellerLogin" name="sellerLogin" >
    	<br>
    	 <s:textfield name="userId"  placeholder="Seller Id" required="true"/>
    	 <br>
    	 <br>
         <s:password name="passwd"  placeholder="Password " required="true"/>
    	
 		<br><br>
		<s:submit value="Login"  class="btn btn-primary"/>
		<br><br>
        
        <br><br>
        </s:form>
  		</div>
  		
  		<div id="menu1" class="tab-pane fade" style="margin-left: 70px; margin-bottom: 40px;">
  		<br>
  		<s:form method="post" action="submitAction" label="A sample horizontal Form" cssClass="form-horizontal">
 
	
	<s:textfield label="Seller Id :" name="sellerId" placeholder="Seller Id" required="true"/><br><br>
	<s:textfield label="Seller-Name :" key="sellerName"  placeholder="Seller Name" required="true"/><br><br>
	
	
	
	<s:password name="pass" label="Password :" key="password" id="pass1" required="true" placeholder="Password"/>
	<br><br>
	
	
	<s:password  name="pass2"  id="pass2" label="Confirm Password :"  onkeyup="checkPass()" required="true" placeholder="Confirm Password"/>
	<br><br>
	
	<s:textfield label="Shipping Address :" name="sellerAdd" placeholder="Shipping Address" required="true"/>
	<br><br>
	
	<s:textfield label="Email-Id :" key="email" placeholder="Email Id"/>
	<br><br>
	<s:textfield label="Contact :" name="contact" placeholder="Contact No" required="true"/>
	 <br><br>
	
	<s:textfield label="Nature-Business :" key="nature" placeholder="Nature of Business"/>
	<br><br>
	<s:textfield label="Category-Product :" key="catProduct" placeholder="Category-Product" required="true"/>
  		<br><br>
  		<s:submit value="Submit" action="submitAction" name="submit" class="btn btn-primary" />
  		<br><br>
  			</s:form>
  			</div>
  			</div></div>
  
	</div>
</body>
</html>