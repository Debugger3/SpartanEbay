<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="s" uri="/struts-tags"%> 
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<link rel="stylesheet" href="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/css/bootstrap.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.0/jquery.min.js"></script>
  <script src="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/js/bootstrap.min.js"></script>
   
     <script src="bootstrap/js/jquery.js"></script>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
  <script language="javascript" type="text/javascript">
  function resizeIframe(obj) {
    obj.style.height = obj.contentWindow.document.body.scrollHeight + 'px';
  }
  </script>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Add New Category</title>
</head>
<body>

<div class="container">
<div class="col-lg-8 well">
		<div class="jumbotron">
		<h3>Enter New Category Details</h3> 
		</div>
		<s:form action="addCat">
        	<div class="form-group">
        	<label for="new-cat">Enter the new category</label>
     			<div >
     				<s:textfield id="new-cat"  class="col-lg-8"  name="newCat" placeholder="New category name" required="true"/>
     			</div>
     		</div>
     		<div class="form-group">
        	<label for="cat-desc">Category description</label>
     		<br>
     				<s:textfield id="cat-desc"  class="col-lg-10" name="catDesc" placeholder="Category Description" required="true"/>
     		
     		</div>
     		
     		<div class="form-group">
     		<div class="col-lg-10">
     		<br><br>
			<s:submit value="Previous" class="btn btn-primary" onCLick="goBack()"/>
			<s:submit value="Add" class="btn btn-primary" />
			<s:submit value="Home" action="homePageAction" class="btn btn-primary" />
			</div></div>        
			</s:form>           
     	</div>
	</div>
	
</body>
</html>