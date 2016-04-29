<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Electronics, Cars, Fashion, Collectibles, Coupons and More Online Shopping | eBay</title>
  <link rel="stylesheet" href="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/css/bootstrap.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.3/jquery.min.js"></script>
  <script src="bootstrap/js/bootstrap.min.js"></script>
  <link href="bootstrap/css/bootstrap.min.css" rel="stylesheet" media="screen">
</head>

<body>
<div class="container text-center">
<s:action name="test" executeResult="true" />
<br><br><br><br><br>    
  <s:if test="%{subCatName!=null}"> 
     <h3><s:property value="subCatName"/></h3><br>
  </s:if>
  <s:else>
  	<h3><s:property value="catName"/></h3><br>
  </s:else>
   
</div>
 
<s:iterator value="itemList" status="rowStatus">
      <div class="row">
	        <div class="col-sm-5">
	        	<div class="well">
					<b>Item Id :</b>			
					<s:property value="itemId"/>
					<br> 
					<b>Item Name </b><s:property value="itemName"/> <br>
					<b>Item Description </b><s:property value="itemDesc"/><br>
					<b>Cost </b><s:property value="cost"/> <br>
					<b> Seller Id </b><s:property value="seller_id"/><br>
					<!--<s:property value="imagePath"/><br>-->
					<!--  imagePath<img src="<s:property value="imagePath"/>" border="0"
			 width="10" height="10">    -->
				</div>
			</div>
        	<div class="col-sm-3">
	          <div class="well">
	  			<img src="data:image/jpg;base64,<s:property value="image64encode" />" height="300px" width="250px"  class="img-responsive" style="width:100%" alt="Image">
	  			 <a href="construction.jsp"><button type="button" class="btn btn-default btn-sm">
	                <span class="glyphicon"></span>Buy Now
	             </button></a>
	          </div>
	        </div>
        </div>	
	<br>
</s:iterator>

</body>
</html>