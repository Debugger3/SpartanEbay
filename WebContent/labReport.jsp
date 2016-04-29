<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="s" uri="/struts-tags"%>
   
    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Track My Order</title>
<script>
function goBack() {
    window.history.back();

}
window.onload = function()
{
	//Disable fields
	//document.frmMain.field1.disabled = true;
	//document.frmMain.field2.disabled = true;
	//document.frmMain.field3.disabled = true;
	
}
</script>

</head>
<body>
<div class="container text-center">
	<s:action name="test" executeResult="true" />
		<ul class="breadcrumb">
			<li>Home</li>
	  		<li>Track My Order</li>
		</ul>
		<h1>Item detail of seller=<s:property value="sellerName"/></h1>
		<div class="jumbotron">
		<div class="col-sm-3" >Srl no.</div>
		<div class="col-sm-3" >Seller Id</div>
		<div class="col-sm-3" >Seller name</div>
		
		<div class="col-sm-3" >Seller Address</div>
		</div>
		<s:iterator value="reportList" status="rowStatus">
		<div class="row">
			
				
		<div class="col-sm-3" ><s:property value="itemId"/></div>
		<div class="col-sm-3" ><s:property value="sellerId"/></div>
		<div class="col-sm-3" ><s:property value="sellerName"/></div>
		<div class="col-sm-3" ><s:property value="sellerAddress"/></div>
		<hr/>
		<br>
		
		</s:iterator>
		<input type="button" value="Previous" class="btn btn-primary" onclick="goBack()"/>
		<s:submit value="Home" action="homePageAction" class="btn btn-primary"></s:submit>
	</div>
		
</body>
</html>