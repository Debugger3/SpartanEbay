<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
  <%@ taglib prefix="s" uri="/struts-tags"%>  
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Electronics, Cars, Fashion, Collectibles, Coupons and More Online Shopping | eBay</title>

<script>
function goBack(){
	window.history.back();
}

var selectedIds = [];
function toggle(source) {
	var x=$(this).attr('id');
	console.write("id of checkbox   "+x);
    checkboxes = document.getElementsByName(x);
    for ( var i in checkboxes)
        checkboxes[i].checked = source.checked;
}
function addSelects() {

    var ids = document.getElementsByName(x);

    for ( var i = 0; i < ids.length; i++) {
        if (ids[i].checked == true) {
            selectedIds.push(ids[i].value);
        }
    }
}

</script>

</head>
<body>

<div class="container">
 <s:action name="test" executeResult="true" />

   <br><br><br><br>
 




<div class="container">
	<div class="col-sm-9 col-md-6 col-lg-8">
		<s:form action="dealCart"  method="get">
	
 	<%int count=0;
 	int j=0;%>
		<s:iterator value="itemList" status="rowStatus">
		<% if((count++)%3==0){
			
		%>
		Select checkbox 
		<input type="checkbox" id="dealCheck" name="dealCheck" value=<s:property value="itemId" /> />
		<div class="row">
		<%} %>  
		
        <div class="col-sm-4">
	    	<div class="well">
	  			<div class="well1">
	  			 <s:url id="cart" action="addtocart" var="myurl">
					<s:param name="itemId"><s:property value="itemId"/></s:param>
					<s:param name="SellerId"><s:property value="seller_id"/></s:param>
					<%if(count%3!=0) {%>
					<s:param name="cost"><s:property value="cost"/></s:param>
					<%}
					else{
					%>
					<s:param name="cost">0</s:param>
					<%} %>
				</s:url>
				 <s:url id="buyNow" action="buyNow" var="buynow">
					<s:param name="itemId"><s:property value="itemId"/></s:param>
					<s:param name="itemDesc"><s:property value="itemDesc"/></s:param>
					<s:param name="sellerId"><s:property value="seller_id"/></s:param>
					<s:param name="itemName"><s:property value="itemName"/></s:param>
					<s:param name="cost"><s:property value="cost"/></s:param>
					<s:param name="discountedCost" value="%{cost-(cost*discount/100)}"/>
					<s:param name="discount"><s:property value="discount"/></s:param>
				</s:url>
				<s:if test="%{(quantFlag=='true')}">
	      				<div style="position: absolute;right: 37px;top: 30px;color:white"><img id="img2" src="bootstrap/Images/outOfStock.jpg" height="5px" width="5px" style="width:30%;height:25%">
	      				</div>
	  			
	            		 </s:if>
	            
	  			<img src="data:image/jpg;base64,<s:property value="image64encode" />"  style="height:250px;width:450px" class="img-thumbnail" width="100" alt="Image">
	  			
	  			</div>	 
	  			<b>Item Id :</b>			
					<s:property value="itemId"/>
					<br> 
					<b>Item Name </b><s:property value="itemName"/> <br>
					<b>Item Description </b><s:property value="itemDesc"/><br>
					<%if(count%3!=0) {%>
					<b>Cost </b><s:property value="cost"/> <br>
					<%}
					else{
					%>
					<b>Cost </b> Free <br>
					<%} %>
					<b> Seller Id </b><s:property value="seller_id"/><br>
	             	
	          </div>
	        </div>
		<%if(count%3==0) {%>
		</div>	
		<%} %>
	</s:iterator>
	<% if(count%3 !=0) {%>
	</div>
	<%} %>
	
	<div class="row">
	<div class="col-sm-3 col-md-6 col-lg-2"> </div>
	<div class ="col-sm-9 col-md-6 col-lg-8">
		<s:submit value="Previous" class="btn btn-primary" onClick="goBack()"/>
		<s:submit class="btn btn-primary" name="Add to cart"/>
		<s:submit value="Home" action="homePageAction" name="home" class="btn btn-primary" />
	</s:form>
	<br><br>
	</div>
	</div>
	</div>
</div>
</body>

</html>
