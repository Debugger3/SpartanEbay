<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<style>
#img2 {
    position: absolute;
    right: 30px;
    top: 20px;
}
</style>
<script type="text/javascript">
  		$(document).ready(function() {
    	$("#owl-demo").owlCarousel({
           	autoPlay: 3000,
   	       	loop:true,
      	   	items : 3,
      	   	itemsDesktop : [1199,3],
        	itemsDesktopMedium : [979,3],
        	navigation :true,
        	stopOnHover:true
    	});   
  });
</script>
</head>
<body>
			<div class="jumbotron text-center">
			<h2>Advertisement</h2>
			</div>
			<div id="owl-demo">
				<s:iterator value="itemList" status="rowStatus">
				
					<div class="item">
	      				<div class="image">
	      				<img src="data:image/jpg;base64,<s:property value="image64encode" />" height="300px" width="250px"  class="img-responsive" style="width:100%" alt="Image">
	      				
	      				<s:if test="%{(dealflag==true) && (discount!=0)}">
	      				
	      				<img id="img2" src="bootstrap/Images/Discount-Icon.png" height="5px" width="5px" style="width:20%;height:15%">
	      				<div style="position: absolute;right: 37px;top: 30px;color:white"><h4><s:property value="discount"/>%</h4></div>
	      				</s:if>
	      				</div> 
		  			 	<div class="">
		  			 	<p><b>Item Id  :</b>  <s:property value="itemId"/></p>
		  			 	
	            		<p><b>Item Name:</b> <s:property value="itemName"/> </p>
	            		<p><b>Cost      </b>
	            		<s:if test="%{(dealflag==true) && (discount!=0)}">
	            		 <strike>
	            		 </s:if> <s:property value="cost"/>
	            		 <s:if test="%{(dealflag==true) && (discount!=0)}">
	            		 </strike>
	            		 <s:property value="%{cost-(cost*discount/100)}"/>
	            		 <s:hidden name="discountedCost" value="%{cost-(cost*discount/100)}"></s:hidden>
	            		 <s:hidden name="quantity" value="1"></s:hidden>
	            		 </s:if>
	            		 </p>
	             <s:url id="buyNow" action="buyNow" var="buynow">
					<s:param name="itemId"><s:property value="itemId"/></s:param>
					<s:param name="itemDesc"><s:property value="itemDesc"/></s:param>
					<s:param name="sellerId"><s:property value="seller_id"/></s:param>
					<s:param name="itemName"><s:property value="itemName"/></s:param>
					<s:param name="cost"><s:property value="cost"/></s:param>
					<s:param name="discountedCost" value="%{cost-(cost*discount/100)}"/>
					<s:param name="discount"><s:property value="discount"/></s:param>
				</s:url>
	            	    																																																																					
	            	    <a href="${buynow}"><button type="button" class="btn btn-default btn-sm"><span class="glyphicon"></span>Buy Now</button></a>
	            	    
	         	    
	        			</div>
	    			</div>
				</s:iterator>
			</div>
	
</body>
</html>