<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<table>
<tr>
                        <td> Category</td>
                        <td>
                           <s:select list="categoryList" id="categoryId" name="categoryId"
                              listValue="catName" listKey="catId"
                              headerKey="0" headerValue="Select Category "  onChange="changeIt(this)"
                              ></s:select>
                           <script type="text/javascript">
                              $(document).ready(function() {
                              	   $('#categoryId').change(function(event) {
                              	          var categories = $("select#categoryId").val();
                              	          $.getJSON('ajaxAction', {
                              	            categoryName : categories
                              	          }, function(jsonResponse) {
                              	            var select = $('#subCatId');
                              	            select.find('option').remove();
                              	            $.each(jsonResponse.subCategoryMap, function(key, value) {
                              	              $('<option>').val(key).text(value).appendTo(select);
                              	            }
                              	            );
                              	          });
                              	         })
                              });
                              
                              
                              	
                           </script>			    
                           
                        </td>
                     </tr>
                     <tr>
                        <td>Sub Category: </td>
                        <td>
                           <div class="col-sm-10">
                              <s:select list="subCatList" name="subCatId" id="subCatId"
                                 listKey="key" listValue="value" 
                                 headerKey="0" headerValue="Select Sub Category"></s:select>
                           </div>
                        </td>
                     </tr>
</table>
</body>
</html>