<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="s" uri="/struts-tags"%>  
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
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
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Add new delivery address</title>
</head>
<body>
<center>
<div class="container text-center">
	<div class="row ">
		<div class="col-sm-4">
			<b>Add new delivery address</b>
		</div>
		<br>
		<br>
		<div class="col-sm-8">
			<s:form action="addAddressBuyNow">
				<s:textfield name="country" label="country" value="India" >Country: &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; </s:textfield><br>
				<br><s:textfield name="contactName" label="Contact Name" required="true">Contact Name:</s:textfield>
				<br><br><s:textarea name="address" label="Address" required="true">Address:&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</s:textarea>
				<br><br><s:textfield name="pincode" required="true">Pincode:&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</s:textfield>
				<br>
				<br>
				<s:textfield name="city" required="true">City:&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</s:textfield>
				<br><br>
				<s:textfield name="state" required="true">State:&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</s:textfield>	
				<br><br>
				<s:textfield name="phone" required="true">Telephone:&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</s:textfield>	
				<br>
				<br>				
    			<s:hidden name="itemId" id="itemId" value="%{itemId}"></s:hidden>
				<s:hidden name="itemName" value="%{itemName}"></s:hidden>
		    	<s:hidden name="sellerId" value="%{sellerId}"></s:hidden>
		    	<s:hidden name="cost" value="%{cost}"></s:hidden>
		    	<s:hidden name="discount" value="%{discount}"></s:hidden>
				<s:hidden name="discountedCost" value="%{cost}"></s:hidden>
				<a>
			<s:submit value="Add address" class="btn btn-primary"></s:submit>
			
		</a>
		
		
			</s:form>
		
		</div>
	
	</div>
</div>
</center>
</body>
</html>