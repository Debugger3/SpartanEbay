<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="s" uri="/struts-tags"%>  
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
 <link rel="stylesheet" href="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/css/bootstrap.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.0/jquery.min.js"></script>
  <script src="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/js/bootstrap.min.js"></script>
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
<s:action name="test" executeResult="true" />
<br><br><br><br><br>
	<div class="row ">
		<div class="col-sm-4">
		<center>	<b>Add new delivery address</b></center>
		</div>
		<br>
		<br>
		<div class="col-sm-8">
			<s:form action="addAddress">
				<table class="table table-hover">
					<tr>
						<td>Country: </td>
						<td><s:textfield name="country" label="country" value="India" /></td>
					</tr>
					<tr>
						<td>Contact Name:</td>
						<td><s:textfield name="contactName" label="Contact Name" required="true" /></td>
					</tr>
					<tr>
						<td>Address:</td>
						<td><s:textarea name="address" label="Address" required="true" /></td>
					</tr>
					<tr>
						<td>Pincode:</td>
						<td><s:textfield name="pincode" required="true" /></td>
					</tr>
					<tr>
						<td>City:</td>
						<td><s:textfield name="city" required="true"/></td>
					</tr>
					<tr>
						<td>State:</td>
						<td><s:textfield name="state" required="true"/></td>
					</tr>
					<tr>
						<td>Phone</td>
						<td><s:textfield name="phone" required="true"/></td>
					</tr>
				</table>
				
				
				
				<s:submit value="Add address" class="btn btn-primary"></s:submit>
		
		
		
			</s:form>
		
		</div>
	
	</div>
</div>
</center>
</body>
</html>