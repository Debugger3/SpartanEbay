<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<script>

function value1()
{
	document.getElementById("catName").value=document.getElementById("catN").value;
}
function goBack() {
    window.history.back();
}
</script>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<h1>CONGRATULATION! NOW ADD A SUBCATEGORY</h1>

<br> <br>
Add new subcategory 
<br> <br>
<%@ page import="org.struts.utils.ConnectionPool" %>
<%@ page import="java.sql.*" %>
<%@ page import="java.util.*" %>
<select name="item" id="catN" onchange="value1()">
  <option value="" selected>--select--</option>
 
<%
ConnectionPool.con=ConnectionPool.getConnection();
String query="select categoryName from category";
PreparedStatement preparedStmt = ConnectionPool.con.prepareStatement(query);
ResultSet rs=preparedStmt.executeQuery();
ArrayList<String> cats=new ArrayList<String>();

while(rs.next())
{%>

<option value="<%String item= rs.getString(1); out.print(item);%>"><% out.print(item);%></option>
      <%
        String desc = rs.getString(1);
        out.println(desc);

        }

%>
</select>


	<br> <br><br> <br>
	<s:form action="addsubCat">
		<s:hidden name="item" id="catName" />
		Enter subcategory name <s:textfield name="subcatName"></s:textfield><br> <br>
		<s:fielderror>
			<s:param>subcatName1</s:param>
		</s:fielderror>
		Subcategory description <s:textfield name="subcatDesc"></s:textfield>
		<s:fielderror>
   			<s:param>subcatDesc1</s:param>
		</s:fielderror>
    	<br> <br><br> <br>
    	<s:submit value="Add Subcategory" />
    </s:form>
<s:submit value="Previous" class="btn btn-primary" onCLick="goBack()"/>
<s:form action="homePageAction">
<s:submit value="Home" action="homePageAction" name="home" class="btn btn-primary" />
</s:form>
</body>
</html>