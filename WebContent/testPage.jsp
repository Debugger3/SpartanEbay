<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<title>Electronics, Cars, Fashion, Collectibles, Coupons and More Online Shopping | eBay </title>

	<style>
	.body{
	padding-top: 40px;
	}
		.dropdown-menu.multi-column {
	        width: 700px;
	  	}
	  	.dropdown-menu.multi-column1 {
	        width: 200px;
	  	}
	    .navbar {
	      margin-bottom: 0;
	      border-radius: 0;
	    }
		.dropdown-menu.multi-column .dropdown-menu {
	        display: block !important;
	        position: static !important;
	        margin: 0 !important;
	        border: none !important;
	        box-shadow: none !important;
	        min-width:100px;
	  	}
	  	.dropdown-menu.multi-column1 .dropdown-menu {
	        display: block !important;
	        position: static !important;
	        margin: 0 !important;
	        border: none !important;
	        box-shadow: none !important;
	        min-width:100px;
	  	}
		.carousel-inner img {
	    	width: 100%; /* Set width to 100% */
	      	margin: auto;
	      	min-height:200px;
		  	max-height:400px;
	  	}

	</style>
	<script src="bootstrap/js/jquery-2.1.1.min.js"></script>
	<script src="bootstrap/js/bootstrap.min.js"></script>
	<link href="bootstrap/css/bootstrap.min.css" rel="stylesheet" media="screen">
	<link href="bootstrap/css/owl.theme.css" rel="stylesheet" media="screen">
	<link href="bootstrap/css/owl.carousel.css" rel="stylesheet" media="screen">
	<script src="bootstrap/js/owl.carousel.js"></script>
	<script src="bootstrap/js/owl.carousel.min.js"></script>




</head>
<body>
	    <nav class="navbar navbar-default navbar-fixed-top" >
			<div class="container">
				<div class="navbar-header">
					<button type="button" class="navbar-toggle" data-toggle="collapse" data-target="#myNavbar">
	        			<span class="icon-bar"></span>
	        			<span class="icon-bar"></span>
	        			<span class="icon-bar"></span>
      				</button>
      				<!-- THIS IS ADDED FOR APP TYPE.. IF SMALL SCREENS SIZE -->
					<a class="navbar-brand" href="indexCopy.jsp" class="pull-left">
					<img src="bootstrap/Images/test.png"/>
					</a>
				</div>
				<div class="collapse navbar-collapse" id="myNavbar">
					<ul class="nav navbar-nav">
					<%
					if(session.getAttribute("type")!=null && session.getAttribute("type").equals("seller"))
			 		{
			 		%>
			 		
					<li class="dropdown ">
					<a href="itemManagement.jsp" data-toggle="dropdown" class="dropdown-toggle" aria-expanded="true">
    					Item Management <span class="caret"></span></a>
						<div class="dropdown-menu  multi-column1">
							<ul class="dropdown-menu">
								<li><a href="callReport"><strong>Add Item</strong></a></li>
								<li><a href="EditItemAction"><strong>Edit Item</strong></a></li>
								<li><a href="DeleteItemAction"><strong>Delete Item</strong></a></li>
								<li><a href="addDeals"><strong>Add Deals</strong></a></li>
								<li><a href="deleteDeals"><strong>Delete Deals</strong></a></li>
							</ul>
						</div>
					</li>

					<!-- <li><a href="register.jsp">Register(Seller)</a></li>-->
					<%

						}%>
						
					<li class="dropdown">
					
					
						<a href="#" data-toggle="dropdown" class="dropdown-toggle" aria-expanded="true">
    					Shop by<br />Category <span class="caret"></span></a>
					<div class="dropdown-menu multi-column" >
                     <%int count =0; %>
				          <s:iterator value="subCatList" status="rowStatus">
			              <% if(count%3==0) {%>
			            	<div class="row">
           						 <%} %>
           						 <div class="col-md-4">
				                    <ul class="dropdown-menu">
				                    <s:url action="itemByCat.action" var="urlTag" >
	    								<s:param name="itemCatId"><s:property value="catId"/></s:param>
	    								<s:param name="itemSubCatId"></s:param>
	    								<s:param name="catName"><s:property value="catName"/></s:param>
	    								<s:param name="subCatName"></s:param>
									</s:url>
					                <li><a href="${urlTag}"><strong><s:property value="catName"/></strong></a></li>
						  				<s:iterator value="subCat" var="studentElement">
										<s:iterator value="studentElement">
										<s:url action="itemByCat.action" var="urlTag" >
    										<s:param name="itemCatId"><s:property value="catId"/></s:param>
    										<s:param name="itemSubCatId"><s:property value="key"/></s:param>
    										<s:param name="catName"><s:property value="catName"/></s:param>
    										<s:param name="subCatName"><s:property value="value"/></s:param>
										</s:url>
										<li><a href="${urlTag}"><s:property value="value"/><br></a></li>
										</s:iterator>
										</s:iterator>
					  				   </ul>
	  								</div>
			  			   <%count++;
			  				   if(count%3==0){
			  				   %>
	  							</div>
	  						<%} %>
	  					</s:iterator>
				        </div>
						</li>
					</ul>

					<%
					if(session.getAttribute("user")==null)
					{
				%>
					<ul class="nav navbar-nav navbar-right">
	    				<li><a href="adminLogin.jsp"> ADMIN | </a></li>
	     				<li><a href="sellerLogin.jsp"> SELLER | </a></li>
	      				<li><a href="userLogin.jsp"> CUSTOMER | </a></li>
					</ul>
				<%} %>
				</div>
			</div>
		</nav>
		<br><br><br><br>

		<nav class="navbar navbar-default">
			<div class="container col-lg-12">
					<ul class="nav navbar-nav">
					<li><a><font color="black">Hi!</font></a></li>
		<%
			if(session.getAttribute("user")==null)
			{
		%>
		<li><a href="userLogin.jsp">Sign-in</a></li>
		<li><a><font color="black">or </font></a></li><li><a href="userLogin.jsp"> Register |</a> </li>
		<%} else
		{ %>
			<li class="dropdown">
			<a href="#" data-toggle="dropdown" class="dropdown-toggle" aria-expanded="true">
    		<%= session.getAttribute("user") %><span class="caret"></span></a>
    		<div class="dropdown-menu multi-column1">
           	<div class="col-md-4">
			<ul class="dropdown-menu">
			<%if (session.getAttribute("type").equals("admin")){ %>
			<li><a href="adminMenu.jsp">Admin Menu</a></li>
			<%} %>
			<% if(session.getAttribute("type").equals("user")){ %>
    		<li><a href="updateAccount">Update Account</a></li>
    		<li><a href="deleteUser.jsp">Delete Account</a></li>
    		<li><a href="logout">Logout</a></li>
    		<%} if(session.getAttribute("type").equals("seller")){ %>
    		<li><a href="sellerUpdate">Update Account</a></li>
    		<li><a href="deleteUser.jsp">Delete Account</a></li>
    		<li><a href="logout">Logout</a></li>
    		<%} %>
    		</ul>
    		</div>
    		</div>
    		</li>
		<%} %>

		<li><a href="dealsAction"><font color="black">Deal</font> |</a> </li>
		<li><a href="construction.jsp"><font color="black">Sell</font> |</a> </li>
		<li><a href="trackOrder.action"><font color="black">Track My Order</font> |</a></li>
		<li><a href="changeMyTrack.action"><font color="black">Change My Order Status</font> |</a></li>
		</ul>
		<ul class="nav navbar-nav navbar-right">

		<li><a href=""><font color="black"><span class="glyphicon glyphicon-bell"></span></font></a></li>
		<li><a href="addtocart.action"><font color="black"><span class="glyphicon glyphicon-shopping-cart"></span></font></a></li>
		</ul></div>

		</nav>


		<!-- <div class="col-md-1">
		<a href="construction.jsp">My eBay</a>
		</div>-->
		<!-- <div class="col-md-1">
		<a href="construction.jsp">My PaisaPay</a>
		</div>-->



</body>
</html>
