<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="s" uri="/struts-tags"%>   
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<style>
.caret-right {
    border-bottom: 4px solid transparent;
    border-top: 4px solid transparent;
    border-left: 4px solid;
    display: inline-block;
    height: 0;
    opacity: 0.3;
    vertical-align: top;
    width: 0;
}
.dropdown:hover .dropdown-menu {
    display: block;
    margin-top: 0; // remove the gap so it doesn't close
 }
    .rightMenu {
    position:relative;
    float:right;
}
.right-caret {

    border-bottom: 4px solid transparent;
    border-top: 4px solid transparent;
    border-left: 4px solid #000000;
    display: inline-block;
    height: 0;
    opacity: 1;
    vertical-align: top;
    width: 0;

}
.right
{
    float:right;
}
</style>

</head>
<body>

  <div class="nav col-sm-3" role="navigation" style="float: left;">
  	<a href="deals.jsp">
  	<h3>Spartan's Deals</h3>
	</a>
	<hr>
	<h4>Shop by Category</h4>
	<hr>
    <s:iterator value="subCatList" status="rowStatus">
	<ul id="sidebar" class="nav nav-stacked">
    <li class="nav dropdown">
    
		<s:url action="itemByCat.action" var="urlTag" >
	    	<s:param name="itemCatId"><s:property value="catId"/></s:param>
	    	<s:param name="itemSubCatId"></s:param>
	    	<s:param name="catName"><s:property value="catName"/></s:param>
	    	<s:param name="subCatName"></s:param>
		</s:url>
		<a href="${urlTag}" class="dropdown-toggle disabled" aria-expanded="true">
		<s:property value="catName"/>
	   	<span class="right-caret right"></span>
     	</a>
        	       <ul class="dropdown-menu rightMenu" style="padding-right: 0.8pt;">
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
	  		
		
	</li>
	</ul>
	</s:iterator>
	</div>
				
  
</body>
</html>