<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<%@ page import="org.struts.model.*" %>    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Delete Subcategory</title>
<script>
function goBack() {
    window.history.back();
}
</script>
</head>
<body>
<div class="container text-center">
	<s:action name="test" executeResult="true" />
	<div class="jumbotron">
	<h3>Delete SubCategory</h3>
	</div>	
	
	<s:form name="form1">
    <div class="form-group">
    	<div class="row">
    	   <div class="col-lg-10">
	   		Category Name  <s:doubleselect value="defaultCat" headerKey="0" headerValue="Select..." 
			   name="categoryName"  list="itemIdList1" listValue="itemId"  listKey="itemId" 
			   doubleName="subCatName" doubleList="itemName">
			</s:doubleselect>	     
       	</div>
       	</div>
       	<div class="row">
       	<div class="col-lg-10">
       	<br><br>
       	<input type="button" value="Previous" class="btn btn-primary" onclick="goBack()"/>
		<s:submit value="Delete" action="deleteSubCategory"  class="btn btn-primary"/>
		<s:submit value="Home" action="homePageAction" class="btn btn-primary"></s:submit>
		</div>
		</div>
	</div>
    </s:form>   	
    </div><!-- End form group -->
    

</body>
</html>