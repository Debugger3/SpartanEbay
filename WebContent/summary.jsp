<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>  
<jsp:include page="userLoginCheck.jsp" />
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<style>
h3 {
    color: blue;
    text-shadow: 2px 2px 4px lime;
} 
.row{
  margin-top: 30px;
  margin-bottom: 30px;
          padding:20px;
}
#boxshadow {
    position: relative;
    -moz-box-shadow: 0px 0px 10px grey;
    -webkit-box-shadow: 0px 0px 10px grey;
    box-shadow: 0px 0px 10px grey;
    padding: 10px;    
    background: white;
    padding: 30px 30px 30px 30px;
}

</style>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Electronics, Cars, Fashion, Collectibles, Coupons and More Online Shopping | eBay</title>
<script type="text/javascript">
function goBack() {
    window.history.back();
}

</script>
</head>
<body>
	<div class="container text-center">
	
			<s:action name="test" executeResult="true" />
	</div>
<div class="panel panel-default">
	<div class="panel-heading"> <strong class=""><font size="5" style="font-weight: normal;">Summary</font></strong>
	 <div align="right">
	 		<b>Total cost:  </b><s:property value="total_cost"/> <br>
	 		<b>Total discount:  -</b><s:property value="total_discount"/> <br>
	 		<b>_____ <br>
	 		<b>Final sum =  </b><s:property value="final_total_cost"/> <br>
	 
	  </div>
	</div>
</div>
<br>
	<div class="container" id="boxshadow">
	<%int i=1; %>
		<s:iterator value="itemList" status="rowStatus">
		<% int index = i;
			i++;
		%>
		<div class="row" style="background-color:white; border: 1px solid #ccc;margin-top: 30px;margin-bottom: 30px; padding:20px;">     
        	<div class="col-sm-4">
	  			<img src="data:image/jpg;base64,<s:property value="image64encode" />"  style="height:150px;width:300px" class="img-thumbnail" width="100" alt="Image" align="middle">
	  			<s:if test="%{(cost==0)}">
	      				<img id="img2" src="bootstrap/Images/free.png" height="5px" width="5px" style="width:40%;height:35%">
	      		</s:if>

  			</div>
 			<div class="col-sm-2">
	  				<span id="cost<%=index%>" style="display:none;"><s:property value="cost"/></span> 			
					<b>Item id </b><span id="itd<%=index%>"><s:property value="itemId"/></span> <br>
					<b>Item Name </b><s:property value="itemName"/> <br>
					<b>Item Description </b><s:property value="itemDesc"/><br>
					<b> Quantity </b><s:textfield id="q%{#rowStatus.count}"  name="quantity" size="2" disabled="true"/><br>			
	         </div>
	         
	          <div class="col-sm-4" align="right">
	         	    <br>
	         	    <b>Cost: </b><s:property value="cost"/> <br>
	         	    <b>Discount: -</b><s:property value="discountMoney"/> <br>
	         	    _______<br>
	         	    <b>DiscountedCost: </b><s:property value="finalCost"/>
	         	  	<span id="price" style="display:none;"><s:property value="finalCost"/></span>
	         	    
	         	    
	          </div>
		</div>	
	</s:iterator>
	<%if(i==1){ %> 
	<div class="panel panel-default">
		<div class="panel-heading"> <strong class="">
			<font size="4" color="black" style="font-weight: normal;">Your shopping cart is empty, but it doesn't have to be.</font><br><br>
			<font size="2" color="gray" style="font-weight: normal;">There are a lot of great deals waiting for you. Start shopping and look for the "add to cart" button.<br>
			You can add several items to your cart from different seller and pay for them at once.</font><br>
			<a href="homePageAction"><font size="4" color="#EE82EE" >Start Shopping</font></a></strong>
		</div>
	</div>
	
	
	<%} %>
	<div id="footer" align="center">
	<hr style="display: block;">
	<p><img src="bootstrap/Images/securityLock.jpg" alt="" width="75" height="75" align="middle"><font size="6" color="gray" style="font-weight: normal;"> SPARTANS GUARANTEE*</font></p>
	<font size="3" color="gray" style="font-weight: normal;">100% Satisfaction or Replacement/Refund.</font>
	</div>
	</div>
	<br><br>
	<div align="center">
	<s:form>
	
		<s:submit value="Continue Shopping" class="btn btn-primary" action="homePageAction"/>
		&nbsp&nbsp<s:submit value="Previous" class="btn btn-primary" onClick="goBack()"/>
		&nbsp&nbsp<s:submit value="Proceed" class="btn btn-primary" action="showAddress"/>
	</s:form>
	</div>
	<br><br>
</body>
</html>