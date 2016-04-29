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
 
 <style type="text/css">

 /* make sidebar nav vertical */ 
@media (min-width: 768px) {
  .sidebar-nav .navbar .navbar-collapse {
    padding: 0;
    max-height: none;
  }
  .sidebar-nav .navbar ul {
    float: none;
  }
  .sidebar-nav .navbar ul:not {
    display: block;
  }
  .sidebar-nav .navbar li {
    float: none;
    display: block;
  }
  .sidebar-nav .navbar li a {
    padding-top: 12px;
    padding-bottom: 12px;
  }
}
</style>
<title>Admin Menu</title>
</head>
<body>
<div class="container text-center">
<s:action name="test" executeResult="true" />

</div>
<br><br><br><br>
<div class="col-sm-12">
 <div class="jumbotron text-center">
    <h3>ADMIN MENU</h3>
    
  </div>

</div>
<hr/>
<br>
<div class="row">
  <div class="col-sm-3">
    <div class="sidebar-nav">
      <div class="navbar navbar-default" role="navigation">
        <div class="navbar-header">
          <button type="button" class="navbar-toggle" data-toggle="collapse" >
            <span class="sr-only">Toggle navigation</span>
            <span class="icon-bar"></span>
            <span class="icon-bar"></span>
            <span class="icon-bar"></span>
          </button>
          <span class="visible-xs navbar-brand">Sidebar menu</span>
        </div>
        <div class="navbar-collapse collapse ">
          <ul class="nav navbar-nav">
            <li class="active"><a href="addCat.jsp" target="iframe_a">Add Category</a></li>
            <li><a href="selectCat" target="iframe_a">Delete Category</a></li>
            <li><a href="success.jsp" target="iframe_a" >Add Subcategory</a></li>
            <li><a href="selectCatSubCat" target="iframe_a" >Delete Subcategory</a></li>
            <li><a href="vatTax.jsp" target="iframe_a" >Update VAT</a></li>
            <li><a href="selectsubCatForAdv" target="iframe_a" >Update Advertisement Cost</a></li>
            <li><a href="adminlogout"  >Logout</a></li>
           </ul>        </div><!--/.nav-collapse -->
      </div>
    </div>
  </div>
  
  <div class="col-sm-9">
    <iframe src="addCat.jsp" width="100%" name="iframe_a" frameborder="0" scrolling="no" onload="resizeIframe(this)"></iframe>
 
  </div>
</div>

</body>
</html>