<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Change My Order Status</title>
<script>

function goBack() {
    window.history.back();
}
function update(e)
{
	var t=e;
	var order=$("#orderId"+t).text();
	var name = $("#status"+t).val();
	var st = $("#st"+t).val();
	alert("Status updated!!!!");
	var id= $("#itd"+t).text();
	var quantity = $("#quantity"+t).val();
	$.ajax({
	    type : "POST",
	    url : "status",
	    data : {
	 	   status: name,
	 	   itemId: id,
	 	   quant : quantity,
	 	   check : st,
	 	   orderId: order
	    },
	    dataType: 'jsonp',
	    success : function(result) {
	        },
	    error: function(e){
	 	 
	    }
	});	
	
	 $("#status"+t).attr('disabled','disabled');
}
</script>
</head>
<body>
<div class="container text-center">
	

	<s:action name="test" executeResult="true" />
		<ul class="breadcrumb">
			<li>Home</li>
	  		<li>Change My Order Status</li>
		</ul>
		<div class="jumbotron">
		<div class="col-sm-4" >Item title</div>
		<div class="col-sm-1" >Total cost</div>
		<div class="col-sm-2" >Transaction Date</div>
		
		<div class="col-sm-3" >Order Id</div>
		<div class="col-sm-2" >Order Status</div>
		</div>
					<%int i=1; %>
		
		<s:iterator value="orderList" status="rowStatus">
		
		<s:url action="displayItemById.action" var="urlTag" >
		<s:param name="itemId"><s:property value="itemId"/></s:param>
		<s:param name="orderId"><s:property value="orderId"/></s:param>
		<s:param name="sellerId"><s:property value="sellerId"/></s:param>
		</s:url>
		<div class="row">
			<% int index = i;
			i++;
		%>
		<div class="col-sm-4">
				<div class="col-sm-4 text-left"><a href="${urlTag}"><img src="data:image/jpg;base64,<s:property value="image64encode" />"  style="height:80px;width:80px" class="img-thumbnail" width="120" alt="Image"></a></div>
				
				<div class="col-sm-8 "><a href="${urlTag}"><s:property value="itemDesc"/></a><br><br> (Seller Id : <s:property value="sellerId"/>)<br><br>Order Id:<div id="orderId"><s:property value="orderId"/></div>
				<br>Address <s:property value="address"/></div></div>
				
			<span id="itd<%=index%>" style="display:none;"><s:property value="itemId"/></span>
			<span id="orderId<%=index%>" style="display:none;"><s:property value="orderId"/></span>
		<div class="col-sm-1" ><s:property value="price"/><br> Quantity : <s:textfield id="quantity%{#rowStatus.count}" name="quantity" value="%{quantity}" size="2" disabled="true" /></div>
		<div class="col-sm-2" ><s:property value="orderDate"/></div>
		
		<div class="col-sm-3" ><s:property value="orderId"/></div>
		<!-- <div class="col-sm-2" ><s:textfield id="status%{#rowStatus.count}" name="status" size="7"/></div>-->
		<div class="col-sm-2" >
		<% 	System.out.println(" i m in jsp session.getAttribute(type)"+session.getAttribute("type"));
			if(session.getAttribute("type").equals("user"))
			{ %>
			
			<s:if test="%{(status=='Approved')}">
				<s:textfield id="status%{#rowStatus.count}" name="status" size="7" disabled="true"/>
			</s:if>
			<s:else>
			
			<s:select label="Update status..."  id="status%{#rowStatus.count}" 
			list="statusList" name="status"/>
			
			</s:else>	
			<%} else
				{ %>
			
				<s:if test="%{(status=='Delivered')}">
				<s:textfield id="status%{#rowStatus.count}" name="status" size="7" disable="true"/>
			</s:if>
			<s:else>
			<s:select label="Update status..."  id="status%{#rowStatus.count}" 
			list="statusList" />
			</s:else>	
			<%} %>
		
		</div>
		
		<br><br><br>
		<s:submit value="Update" id="update%{#rowStatus.count}" style="float: right;" action="" class="btn btn-primary" onclick="update('%{#rowStatus.count}')"/>
		<script type="text/javascript">
                              
		                   </script>
		</div>
		
		<hr/>
		<br>
		
		</s:iterator>
		<input type="button" value="Previous" class="btn btn-primary" onclick="goBack()"/>
		<s:submit value="Home" action="homePageAction" class="btn btn-primary"></s:submit>
	</div>
		
</body>
</html>