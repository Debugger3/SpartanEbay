<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<div class="container text-center">
		<s:action name="test" executeResult="true" />
		<br><br><br><br><br>

	<div class="col-lg-10">
<%int count=0; %>
		<s:iterator value="itemList" status="rowStatus">
		<% if((count++)%2==0) {
		%>
		<div class="row">
		<%} %>      
        	<div class="col-sm-5">
	          <div class="well">
	  			<div class="well1">
	  			 <s:url id="cart" action="addtocart" var="myurl">
					<s:param name="itemId"><s:property value="itemId"/></s:param>
					<s:param name="SellerId"><s:property value="seller_id"/></s:param>
					
				</s:url>
				
	  			<img src="data:image/jpg;base64,<s:property value="image64encode" />"  style="height:250px;width:450px" class="img-thumbnail" width="100" alt="Image">
	  			
	  			</div>	 
	  			 <b>Item Id :</b>			
					<s:property value="itemId"/>
					<br> 
					<b>Item Name </b><s:property value="itemName"/> <br>
					<b>Item Description </b><s:property value="itemDesc"/><br>
				
					<b> Seller Id </b><s:property value="seller_id"/>
					
	           <br>
	          
	          </div>
	        </div>
		<%if(count%2==0) {%>
		</div>	
		<%} %>
	</s:iterator>
	<% if(count%2!=0) {%>
	</div>
	<%} %>
	
	<div class="row">
	<div class="col-sm-3 col-md-6 col-lg-2"> </div>
	<div class ="col-sm-9 col-md-6 col-lg-8">
	<s:form>
		<s:submit value="Previous" class="btn btn-primary" onClick="goBack()"/>
		<s:submit value="Home" action="homePageAction" name="home" class="btn btn-primary" />
	</s:form>
	</div>
	</div>
	</div>
</body>
</html>