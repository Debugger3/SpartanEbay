<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<jsp:include page="loginCheck.jsp" />
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Add Item | ebay</title>
<script type="text/javascript">
	function goBack() {
		window.history.back();
	}
</script>
<style type="text/css">
.errorMessage {
	font-weight: light;
	color: red;
}

.body {
	background-color: GhostWhite;
}

.h3 {
	font-weight: bold;
	color: grey;
}

.sell {
	color: GhostWhite;
}

.h4 {
	font-weight: bold;
	color: grey;
}

.h2 {
	font-weight: bold;
	color: GhostWhite;
}

.banner {
	width: 100%;
	max-height: 300px;
}

.jumbotron {
	background-color: DodgerBlue;
}
</style>
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.3/jquery.min.js"></script>
<script src="bootstrap/js/bootstrap.min.js"></script>
<link href="bootstrap/css/bootstrap.min.css" rel="stylesheet"
	media="screen">
<link href="bootstrap/css/owl.theme.css" rel="stylesheet" media="screen">
<link href="bootstrap/css/owl.carousel.css" rel="stylesheet"
	media="screen">
<script src="bootstrap/js/owl.carousel.js"></script>
<script src="bootstrap/js/owl.carousel.min.js"></script>
<script
	src="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.5/js/bootstrap.min.js"></script>

<link rel="stylesheet"
	href="https://code.jquery.com/ui/1.11.4/themes/smoothness/jquery-ui.css">
<script src="https://code.jquery.com/jquery-1.10.2.js"></script>
<script src="https://code.jquery.com/ui/1.11.4/jquery-ui.js"></script>

</head>
<body>
	<div class="container">
		<s:action name="test" executeResult="true" />
		<br>
		<br>
		<br>
		<br>
		<div class="col-sm-10">
			<div class="jumbotron">
				<h3>choose category & subcategory</h3>
			</div>
			<hr>
			<div class="well">
				<s:form action="addItem1" align="center" method="post"
					enctype="multipart/form-data" style="text-align:right">
					<table>
						
						<tr>
							<td>Category</td>
							<td><s:select list="categoryList" id="categoryId"
									name="categoryId" listValue="catName" listKey="catId"
									headerKey="0" headerValue="Select Category "
									onChange="changeIt(this)"></s:select>
								<script type="text/javascript">
									$(document).ready(function() {
										$('#categoryId').change(function(event) {
																			
											var categories = $("select#categoryId")	.val();
																			
											$.getJSON('ajaxAction',	{categoryName : categories},function(jsonResponse) 
										{
										var select = $('#subCatId');

										select.find('option').remove();
										$.each(jsonResponse.subCategoryMap,function(key,value) {
											$('<option>').val(key).text(value).appendTo(select);
												});
											});
										})
									});
									
									</td>
									</tr>
									<tr>
									
							<td>Sub Category:</td>
							<td>
								<div class="col-sm-10">
									<s:select list="subCatList" name="subCatId" id="subCatId"
										listKey="key" listValue="value" headerKey="0"
										headerValue="Select Sub Category"></s:select>
								</div>
							</td>
						</tr>
						<tr>
						
					</table>
					<div align="center">
						<br> <input type="button" value="Previous"
							class="btn btn-primary" onclick="goBack()" />
						<s:submit value="Submit" action="addItem1" class="btn btn-primary"></s:submit>
						<s:submit value="Home" action="homePageAction"
							class="btn btn-primary"></s:submit>
					</div>
				</s:form>
			</div>
		</div>
	</div>
</body>
</html>