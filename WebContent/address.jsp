<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="s" uri="/struts-tags"%>    
    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
 
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<div class="well">
<s:action name="test" executeResult="true" />
<br><br><br><br><br>
<s:form action="selectedAddress">
<pre>
<s:radio list="addressList" name="yourAddress" required="true"> </s:radio> 
<br>
</pre>
<s:if test ="%{!(getAddressList().isEmpty())}">
<s:submit value="Deliver here" class="btn btn-primary"></s:submit>
<s:submit value="Delete Address" class="btn btn-primary" action="deleteAddress"/>
<br>

</s:if>
</s:form>
<br>

<br>
<a href="addAddress.jsp"><s:submit value="Add new delivery address" class="btn btn-primary"></s:submit>
</a>


</div>
</body>
</html>