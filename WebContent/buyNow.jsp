<%@ page language="java" contentType="text/html; charset=UTF-8"
   pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
   <head>
      <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
      <title>Electronics, Cars, Fashion, Collectibles, Coupons and More Online Shopping | eBay -- Buy Now</title>
   </head>
   <body>
      <div class="container text-center">
      <s:action name="test" executeResult="true" />
      <div class="col-md-8">
         <h3>Your order details - 1 item(s)</h3>
         <hr>
         <div class="row">
            <div class="col-md-4 row text-left">
               <b>
                  <s:property value="itemId"/>
                  <br>
                  <s:property value="itemDesc"/>
                  <br>
                  <s:property value="itemName"/>
                  <br>
                  Seller Id : <s:property value="sellerId"/>
                  
                  <br>
                  <s:hidden name="itemId" id="itemId" value="%{itemId}"></s:hidden>
            <s:hidden name="itemName" value="%{itemName}"></s:hidden>
            <s:hidden name="sellerId" value="%{sellerId}"></s:hidden>
            <s:hidden name="cost" value="%{cost}"></s:hidden>
            <s:hidden name="discount" value="%{discount}"></s:hidden>
            <s:hidden name="discountedCost" value="%{discountedCost}"></s:hidden>
            <s:hidden name="deliveryCharge" value="%{deliveryCharge}"></s:hidden>
                  Quantity :&nbsp &nbsp 
                  <s:select name="quantity" size="1" id="quantity"
                     list="#{'1':'1', '2':'2', '3':'3', '4':'4' , '5' :'5'}"  onchange="handleChange(this.value)" />
                  <script type="text/javascript">
                     function handleChange(value){
                     	//alert($("#discountedCost").val());
                     		//var  
                     	  	window.location="buyNow.action?itemId="+$("#itemId").val()+"&itemDesc=&sellerId="+$("#sellerId").val()+"&itemName="+$("#itemName").val()+"&cost="+$("#cost").val()+"&discountedCost="+$("#discountedCost").val()+"&discount="+$("#discount").val()+"&quantity1="+$("#quantity").val();
                     	  	//$("#quantity").val=value;
                     	  	/*$.ajax({
                     	  	    type : "POST",
                     	  	    url : "buyNow",
                     	  	    data : { 
                     	  	 	   itemId : $("#itemId").val(),
                     	  	 	   sellerId :$("#sellerId").val(),
                     	  	 	   itemName :$("#itemName").val(),
                     	  	 	   cost : $("#cost").val(),
                     	  	 	   discountedCost : $("#discountedCost").val(),
                     	  	 	   discount : $("#discount").val(),
                     	  	 	   quantity : $("#quantity").val()
                     	  	    },
                     	  	    dataType: 'jsonp',
                     	  	    success : function(result) {
                     	  	        },
                     	  	    error: function(e){
                     	  	 	   alert(e);
                     	  	    }
                     	  	});
                     	  	*/
                     	}                      	
                            
                  </script>
                  
                  <s:if test="hasActionMessages()">
      				showDialog("<s:actionerror/>");
					</s:if>
					<s:property value="getText('msg.welcome')" />
               </b>
            </div>
            <div class="col-md-4 row text-right">
               <b>
                  Cost :
                  <s:property value="%{cost*quantity}"/>
                  <br>
                  <s:if test="%{discount!=0}">
                     Discount :
                     <s:property value="discount"/>
                     %<br>
                  </s:if>
                  <s:if test="%{deliveryCharge!=0}">
                     Delivery Charge :
                     <s:property value="deliveryCharge"/>
                  </s:if>
                  <hr>
                  Total Cost :
                  <s:property value="%{discountedCost*quantity+deliveryCharge}"/>
               </b>
            </div>
         </div>
         <hr>
         <h3>Your item(s) will be delivered to this address</h3>
         <br>
         <%int i=1; %>
         <s:form action="addNewAddressBuyNow">
            <s:hidden name="itemId" id="itemId" value="%{itemId}"></s:hidden>
            <s:hidden name="itemName" value="%{itemName}"></s:hidden>
            <s:hidden name="sellerId" value="%{sellerId}"></s:hidden>
            <s:hidden name="cost" value="%{cost}"></s:hidden>
            <s:hidden name="discount" value="%{discount}"></s:hidden>
            <s:hidden name="discountedCost" value="%{discountedCost}"></s:hidden>
            <s:hidden name="deliveryCharge" value="%{deliveryCharge}"></s:hidden>
            <s:iterator value="addrList" status="rowStatus">
               <%if(i%3==0){ %>
               <div class="row">
                  <% }%>
                  <div class="col-md-4 well text-left">
                     <s:url action="payment1" var="urlTag" >
                        <s:param name="itemId">
                           <s:property value="itemId"/>
                        </s:param>
                        <s:param name="itemName">
                           <s:property value="itemName"/>
                        </s:param>
                        <s:param name="sellerId">
                           <s:property value="sellerId"/>
                        </s:param>
                        <s:param name="cost">
                           <s:property value="%{discountedCost*quantity+deliveryCharge}"/>
                        </s:param>
                        <s:param name="discountedCost">
                           <s:property value="%{discountedCost*quantity+deliveryCharge}"/>
                        </s:param>
                        <s:param name="contactName">
                           <s:property value="contactName"/>
                        </s:param>
                        <s:param name="deliveryCharge">
                           <s:property value="deliveryCharge"/>
                        </s:param>
                        <s:param name="address">
                           <s:property value="addresss"/>
                        </s:param>
                        <s:param name="city">
                           <s:property value="city"/>
                        </s:param>
                        <!--<s:param name="quantity">
                           <s:property value="quantity"/>
                        </s:param>-->
                        <s:param name="country">
                           <s:property value="country"/>
                        </s:param>
                        <s:param name="pincode">
                           <s:property value="pincode"/>
                        </s:param>
                        <s:param name="state">
                           <s:property value="state"/>
                        </s:param>
                        <s:param name="phone">
                           <s:property value="phone"/>
                        </s:param>
                     </s:url>
                     <s:url action="deleteAddressBuyNow" var="urlTagDel" >
                        <s:param name="itemId">
                           <s:property value="itemId"/>
                        </s:param>
                        <s:param name="itemName">
                           <s:property value="itemName"/>
                        </s:param>
                        <s:param name="sellerId">
                           <s:property value="sellerId"/>
                        </s:param>
                        <s:param name="cost">
                           <s:property value="%{cost}"/>
                        </s:param>
                        <s:param name="discountedCost">
                           <s:property value="%{discountedCost}"/>
                        </s:param>
                        <s:param name="discount">
                           <s:property value="%{discount}"/>
                        </s:param>
                        <s:param name="contactName">
                           <s:property value="contactName"/>
                        </s:param>
                        <s:param name="address">
                           <s:property value="address"/>
                        </s:param>
                        <s:param name="city">
                           <s:property value="city"/>
                        </s:param>
                        <!--<s:param name="quantity">
                           <s:property value="quantity"/>
                        </s:param>-->
                        <s:param name="country">
                           <s:property value="country"/>
                        </s:param>
                        <s:param name="pincode">
                           <s:property value="pincode"/>
                        </s:param>
                        <s:param name="state">
                           <s:property value="state"/>
                        </s:param>
                        <s:param name="phone">
                           <s:property value="phone"/>
                        </s:param>
                     </s:url>
                     <div align="right">
                        <a href="${urlTagDel}"><span class="glyphicon glyphicon-trash"></span></a>
                     </div>
                     <s:property value="contactName"/>
                     <br>
                     <s:property value="address"/>
                     <br>
                     <s:property value="city"/>
                     , 
                     <s:property value="state"/>
                     - 
                     <s:property value="pincode"/>
                     , 
                     <s:property value="country"/>
                     <br>
                     <s:property value="phone"/>
                     <br>
                     <a href="${urlTag}">Deliver here</a>
                  </div>
                  <%
                     if(i%3==0){
                     %>
               </div>
               <%}i++; %>
            </s:iterator>
            <div class="row">
               <s:submit value="Add New delivery address" class="btn btn-primary"></s:submit>
            </div>
         </s:form>
         <hr>
      </div>
      </div>
   </body>
</html>