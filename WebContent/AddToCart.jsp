<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>  
<jsp:include page="userLoginCheck.jsp" />
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<style>

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

function check(j)
{
	var t = j;
	var quant = $("#q"+t).val();
	var price = $("#cost"+j).text();
	var aq = $("#actualquant"+j).text();
	if((aq-quant)>=0 && quant>0)
	{
	$.ajax({
    type : "POST",
    url : "quantity",
    data : {
 	   quantity: quant,
 	   itemId : $("#itd"+j).text(),
    	},
    	dataType: 'jsonp',
	    success : function(result) {
	        },
	    error: function(e){
	    }
		});
		alert("updated");
	}
	else
	{
		if(quant<=0)
		{
			alert("please enter valid quantity!!!");
		}
		else if((aq-quant)<0)
		{
			alert("Out of stock!!! , we have only"+aq+"items");
		}
	}
}
	
</script>
</head>
<body>
	<div class="container text-center">
	
			<s:action name="test" executeResult="true" />
	</div>
<div class="panel panel-default">
	<div class="panel-heading"> <strong class=""><font size="5" style="font-weight: normal;">Items in your Cart</font></strong>
	   <div align="right">
	 		<b>Total cost:  </b><s:property value="total_cost"/> <br>
	 		<b>Total discount:  -</b><s:property value="total_discount"/> <br>
	 		<b>Vat :</b><s:property value="tax"/>%<br>
	 		
	 		<b>_____ <br>
	 		<b>Final sum =  </b><s:property value="final_total_cost"/> <br>
	   </div>
	</div>
</div>
<br>
	<div class="container" id="boxshadow">
	<%int i=1;
	boolean flag = false;
	%>
		<s:iterator value="itemList" status="rowStatus">
		<% int index = i;
			i++;
			flag=true;
		%>
	
		<div class="row" style="background-color:white; border: 1px solid #ccc;margin-top: 30px;margin-bottom: 30px; padding:20px;">     
        	    <div class="col-sm-4">
	  				<s:url id="cart" action="remove" var="myurl">
						<s:param name="itemId"><s:property value="itemId"/></s:param>
					</s:url>
  				
	          
	  			<img src="data:image/jpg;base64,<s:property value="image64encode" />"  style="height:150px;width:300px" class="img-thumbnail" width="100" alt="Image" align="middle">
	  			</div>
	  			<div class="col-sm-4">
	  				<span id="cost<%=index%>" style="display:none;"><s:property value="cost"/></span>
	  				<span id="actualquant<%=index%>" style="display:none;"><s:property value="total_quant"/></span>
					<b>Item id :</b><span id="itd<%=index%>"><s:property value="itemId"/></span> <br>
					<b>Item Name :</b><s:property value="itemName"/> <br>
					<b>Item Description :</b><s:property value="itemDesc"/><br>
					<b>Discount :</b><s:property value="discount"/>%<br>
					<b> Quantity :</b><s:textfield id="q%{#rowStatus.count}"  name="quantity" size="2"/><br>
					<a href="" id="update<%=index%>" class="" onclick="check(<%=index%>);">Update</a>				
				</div>
	          	<div class="col-sm-4" align="right">
	         	    <a href="${myurl}">remove</a>
	         	    <br>
	         	    <b>Cost: </b><s:property value="cost"/> <br>
	         	    <b>Discount: -</b><s:property value="discountMoney"/> <br>
	         	    _______<br>
	         	    <b>DiscountedCost: </b><s:property value="finalCost"/>
	         	    
	         	    
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
		&nbsp&nbsp<s:submit value="Summary" class="btn btn-primary" action="summary"/>
	</s:form>
	</div>
	<br><br>
</body>
</html>