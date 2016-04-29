<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="s" uri="/struts-tags"%>
    <jsp:include page="userLoginCheck.jsp" />
    
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

function rate(e)
{
	var t=e;
	var id= $("#rating"+t).val();
	var seller = $("#sellerid"+t).text();
	var order=$("#orderId"+t).text();
	var item=$("#item"+t).text();
	
	if(id>5 || id<0)
		{
		alert("Please enter a valid rating b/w 0 to 5!!!");
		}
	else
		{
	$.ajax({
	    type : "POST",
	    url : "rate",
	    data : {
	 	   rating: id,
	 	   sellerIdrating: seller,
	 	   orderId : order,
	 	   itemId : item
	    },
	    dataType: 'jsonp',
	    success : function(result) {
	        },
	    error: function(e){
	 	 
	    }
	});	
	alert("Response captured");

	 $("#rating"+t).attr('disabled','disabled');
}
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
		<div class="jumbotron">
		<div class="col-sm-3" >Item title</div>
		<div class="col-sm-1" >Total cost</div>
		<div class="col-sm-2" >Transaction Date</div>
		<div class="col-sm-2" >Order Id</div>
		<div class="col-sm-3" >Order Status</div>
		<div class="col-sm-1" >Rating</div>
		</div>
		<%int i=1; %>
		
		<s:iterator value="orderList" status="rowStatus">
			<s:url action="displayItemById.action" var="urlTag" >
				<s:param name="itemId"><s:property value="itemId"/></s:param>
			</s:url>
			<div class="row">
			<% int index = i;
			i++;
			%>
				<div class="col-sm-3">
					<div class="col-sm-4 text-left"><a href="${urlTag}"><img src="data:image/jpg;base64,<s:property value="image64encode" />"  style="height:80px;width:80px" class="img-thumbnail" width="120" alt="Image"></a></div>
					<div class="col-sm-8 "><a href="${urlTag}"><s:property value="itemDesc"/></a><br><br> (Seller Id : <s:property value="sellerId"/>)
					<br>Address <s:property value="address"/></div></div>
					<div class="col-sm-1" ><s:property value="price"/><br> Quantity : <s:textfield value="%{quantity}" size="2" disabled="true" /></div>
					<div class="col-sm-2" ><s:property value="orderDate"/></div>
					
					<div class="col-sm-3" ><s:property value="orderId"/></div>
					<span id="orderId<%=index%>" style="display:none;"><s:property value="orderId"/></span>
					<span id="item<%=index%>" style="display:none;"><s:property value="itemId"/></span>
					<div class="col-sm-1" ><s:property value="status"/>
				</div>
				<div class="col-sm-1" ><s:property value="rating"/>
				<br/>
					<s:if test='%{(status=="Received") && ("N".equals(rateFlag))}'>
						<s:textfield id="rating%{#rowStatus.count}" size="2" ></s:textfield>
						<a href="" id="rate<%=index%>" onclick="rate(<%=index%>);">Rate(0-5)</a>
					</s:if>		
			     	<span id="sellerid<%=index%>" style="display:none;"><s:property value="sellerId"/></span>
			 	<br/>
				</div>
			</div>
		<hr/><br>
		</s:iterator>
		<input type="button" value="Previous" class="btn btn-primary" onclick="goBack()"/>
		<s:submit value="Home" action="homePageAction" class="btn btn-primary"></s:submit>
	</div>
		
</body>
</html>