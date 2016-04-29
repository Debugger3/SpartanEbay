<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Electronics, Cars, Fashion, Collectibles, Coupons and More Online Shopping | eBay</title>
<script>
function goBack() {
    window.history.back();
}
function filterprice()
{
	document.filter.submit();
	}
	
</script>
<style>
#img2 {
    position: absolute;
    right: 30px;
    top: 20px;
}
</style>
</head>
<body>
	<div class="container text-center">
		<s:action name="test" executeResult="true" />
		<br><br><br><br><br>
		<ul class="breadcrumb">
			<li><s:property value="catName"/></li> 
	  		<s:if test="%{subCatName!=null}">
	  			<li><s:property value="subCatName"/></li>
	  		</s:if>
		</ul>
	</div>
	<div class="col-sm-2">
	
	<div class="leftnav bottom-padding40" id ="leftnav">
	<label>Filter by:</label>
	<div class="lftnav-lbl">
	<label>Price Range</label>
	
	
	<s:form action="filter">
	<s:hidden name="catId" value="%{itemCatId}"/>
	<s:hidden name="subcatId" value="%{itemSubCatId}"/>
	<s:hidden name="catName" value="%{catName}"/>
	<s:hidden name="subCatName" value="%{subCatName}"/>
	&nbspBelow 500  <s:checkbox name="checkMe" label="Below 500" onclick="filterprice()"/><br>
	&nbsp500-1000   <s:checkbox name="checkMe1" label="500-1000" onclick="filterprice()"/><br> 
	&nbspAbove 1000 <s:checkbox name="checkMe2" label="Above 1000" onclick="filterprice()"/>
	<br>
	<label>Color</label>
	<s:textfield id="color" name="color"></s:textfield>
	<s:submit action="filter" value="Choosecolor"></s:submit>
	
	
	</s:form>
	</div>
	</div>
	
	</div>
	
	<div class="container">
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
					<s:param name="cost"><s:property value="cost"/></s:param>
				</s:url>
				 <s:url id="buyNow" action="buyNow" var="buynow">
					<s:param name="itemId"><s:property value="itemId"/></s:param>
					<s:param name="itemDesc"><s:property value="itemDesc"/></s:param>
					<s:param name="sellerId"><s:property value="seller_id"/></s:param>
					<s:param name="itemName"><s:property value="itemName"/></s:param>
					<s:param name="cost"><s:property value="cost"/></s:param>
					<s:param name="discount"><s:property value="discount"/></s:param>
					<s:param name="discountedCost"><s:property value="%{cost-(cost*discount/100)}"/></s:param>
					<s:param name="quantity" value="1"></s:param>
				</s:url>
	  			<img src="data:image/jpg;base64,<s:property value="image64encode" />"  style="height:250px;width:450px" class="img-thumbnail" width="100" alt="Image">
	  			<s:if test="%{(dealflag==true)}">
	      				<img id="img2" src="bootstrap/Images/Discount-Icon.png" height="0px" width="5px" style="width:20%;height:15%">
	      				<div style="position: absolute;right: 37px;top: 30px;color:white"><h4><s:property value="discount"/>%</h4></div>
	      		</s:if>
	  			</div>	 
	  			 <b>Item Id :</b>			
					<s:property value="itemId"/>
					<br> 
					<b>Item Name </b><s:property value="itemName"/> <br>
					<b>Item Description </b><s:property value="itemDesc"/><br>
						<b>Cost </b>
						<s:if test="%{(dealflag==true)}">
	            		 <strike>
	            		 </s:if>
	            		 <s:property value="cost"/> 
	            		<s:if test="%{(dealflag==true)}">
	            		 </strike>
	            		 <s:property value="%{cost-(cost*discount/100)}"/>
	            		 </s:if>
	            		 <br>
					<b> Seller Id </b><s:property value="seller_id"/>
					<div align="right" style="position: absolute;right: 37px;bottom:70px;">
						<img id="imgrating" src="bootstrap/Images/rating-icon.png" height="5px" width="5px" style="width:10%;height:15%">
					<font color="blue" size="3"><s:property value="rating"/>/<s:property value="ratingCount"/></font><br></div>
					<br>
	         	   	         <s:if test="%{(cartFlag=='true') || (quantFlag=='true')}">
	         	<a href="${buynow}"><button type="button" class="btn btn-default btn-sm" disabled="disabled"><span class="glyphicon"></span>Buy Now</button></a>
	         	   	         
	         	    <a href="${myurl}"><button type="button" class="btn btn-default btn-sm" disabled="disabled"><span class="glyphicon"></span>Add to cart</button></a>
	           <br>
	           <s:if test="%{(cartFlag=='true')}">
	           <a href="${myurl}"><b>Already added in your cart</b></a>
	            		 </s:if>
	            		 <s:else>
	<img id="img2" src="bootstrap/Images/outOfStock.jpg" height="5px" width="5px" style="width:30%;height:25%">
	      				<div style="position: absolute;right: 37px;top: 30px;color:white"></div>
	      				            		 </s:else>
	            		 </s:if>
	            		 <s:else>
	   <a href="${myurl}"><button type="button" class="btn btn-default btn-sm"><span class="glyphicon"></span>Add to cart</button></a>
	  <a href="${buynow}"><button type="button" class="btn btn-default btn-sm"><span class="glyphicon"></span>Buy Now</button></a>
	            		 
	            		 </s:else>
	          
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