<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Screen 01 Result</title>
<style>
#boxshadow {
    position: relative;
    -moz-box-shadow: 0px 0px 10px grey;
    -webkit-box-shadow: 0px 0px 10px grey;
    box-shadow: 0px 0px 10px grey;
    padding: 10px;    
    background: white;
    padding: 30px 30px 30px 30px;
}
</style>
</head>
<body>
<div class="container text-center">
	<s:action name="test" executeResult="true" />
	<div class="panel panel-default">
	<div class="panel-heading">
	 
	 <div class="col-sm-1">
	 <strong>S. No</strong>
	 </div>
	 <div class="col-sm-4">
	 <strong>Item Id</strong>
	 </div>
	 <div class="col-sm-3">
	 <strong>Deal Id</strong>
	 </div>
	 <div class="col-sm-4">
	 <strong>Free Item Id</strong>
	 </div>
	 <br><br><br>
	</div>
	</div>
	
</div>
	<div class="container" id="boxshadow">
	
	
		<s:iterator value="arr" status="rowStatus">
				<div class="row" style="background-color:white; border: 1px solid #ccc;margin-top: 30px;margin-bottom: 30px; padding:20px;">
				   
        	    	<div class="col-sm-1">
        	    	<s:property value="sno"/>
        	    	</div>
        	    	
        	    	<div class="col-sm-4">
        	    	<s:property value="itemId"/>
        	    	</div>
        	    	<div class="col-sm-3">
        	    	<s:property value="dealId"/>
        	    	</div>
        	    	<div class="col-sm-4">
        	    	<s:property value="freeItemId"/>
        	    	</div>
        	    </div>
		
		</s:iterator>
	</div>
</body>
</html>