<%@ page language="java" contentType="text/html; charset=UTF-8"
   pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<%@ taglib prefix="sx" uri="/struts-dojo-tags" %>  
<jsp:include page="loginCheck.jsp" />
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
   <head>
   <s:head theme="simple"/> 
  <sx:head/>
      <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
      <%String editFlag =session.getAttribute("edit").toString();
      	if(editFlag.equals("yes"))
      	{	
      %>
      	<title>Edit Item | ebay </title>
      <%} %>
      <% if(!(editFlag.equals("yes"))){%>
      	<title>Add Item | ebay </title>
      	<%} %>
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
         background-color: GhostWhite ;
         }
         .h3{
         font-weight:bold;
         color:grey	;
         }
         .sell{
         color:GhostWhite;
         }
         .h4{
         font-weight:bold;
         color:grey;
         }
         .h2{
         font-weight:bold;
         color:GhostWhite;
         }   
         .banner{
         width:100%;
         max-height:300px;
         }
         .jumbotron{
         background-color: DodgerBlue ;
         }
          .myFile{
        /* Your style here */
        color: transparent;
      }
      </style>
      
   </head>
   <body onload="change()">
   <%String typeUser =session.getAttribute("type").toString(); 
	String userId = session.getAttribute("user").toString();%>
      <div class="container">
         <s:action name="test" executeResult="true" />
         
         <br><br><br><br>
         <div class="col-sm-10">
            <div class="jumbotron">
           
      						 <h3>Edit your item here</h3>
      		
            </div>
            <hr>
            
           
            <div class="well">
           
               <s:form action="updateItem" align="center" method="post"  enctype="multipart/form-data" style="text-align:right">
             
               		<s:iterator value="itemList">
              
                  <table>
                 
                     <tr>
                        <td>Item Id: </td>
                        <td>
                           <div class="col-sm-10">
                              <s:textfield id="itemId" name="itemId" disable="true" placeholder="Enter Item Id"/>
                           </div>
                           <s:fielderror>
                              <s:param>itemId</s:param>
                           </s:fielderror>
                        </td>
                     </tr>
                     <tr>
                        <td>Item Name: </td>
                        <td>
                           <div class="col-sm-10">
                              <s:textfield id="itemName" name="itemName" placeholder="Enter Item Name"/>
                           </div>
                           <s:fielderror>
                              <s:param>itemName</s:param>
                           </s:fielderror>
                        </td>
                     </tr>
                     <tr>
                        <td>Item Description: </td>
                        <td>
                           <div class="col-sm-10">
                              <s:textfield id="itemDesc" name="itemDesc" label="Item Description " placeholder="Enter Item Description"/>
                           </div>
                           <s:fielderror>
                              <s:param>itemDesc</s:param>
                           </s:fielderror>
                        </td>
                     </tr>
                     <tr>
                        <td>Picture: </td>
                        <td>
                           <s:file id="pic" label ="pic" name="imagePath" value="%{imagePath}"  cssClass="myFile"/><s:property value="imagePath"/>
                        </td>
                     </tr>
                     <tr>
                        <td>Seller Id: </td>
                        <td>
                           <div class="col-sm-10">
                              <s:textfield id="sellerId" label ="Seller Id" name="sellerId" placeholder="Enter Seller Id" value="%{#session.user}" />
                           </div>
                           <s:fielderror>
                              <s:param>sellerId</s:param>
                           </s:fielderror>
                        </td>
                     </tr>
                     <tr>
                        <td>Quantity: </td>
                        <td>
                           <div class="col-sm-10">
                              <s:textfield placeholder="Enter Quantity" id="quantity" name="quantity" value="%{quantity}"/>
                           </div>
                           
                        </td>
                     </tr>
                     <tr>
                        <td>Price: </td>
                        <td>
                           <div class="col-sm-10">
                              <s:textfield label ="Price" id="price" name="price" placeholder="Enter price" value="%{cost}"/>
                           </div>
                           <s:fielderror>
                              <s:param>price</s:param>
                           </s:fielderror>
                        </td>
                     </tr>
                     <tr>
                        <td>Advertising Item : </td>
                        <td>
                           <div class="col-sm-10">
                              <s:select name="advCheck" id="advCheck" label="Advertisement Item?" 
                                 headerKey="0" headerValue="Select Advertisement"
                                 list="#{'Y':'Yes', 'N':'No'}"  value="%{advCheck}"/>
                           </div>
                        </td>
                     </tr>
                     <tr>
                        <td> Category</td>
                        <td>
                        <s:hidden value="%{itemSubCatId}" name="subCatName1" id="subCatName1"></s:hidden>
                           <s:select list="categoryList" id="categoryId" name="categoryId"
                              listValue="catName" listKey="catId"
                              headerKey="0" headerValue="Select Category "  onChange="changeIt(this)"
                              value="%{#session.categoryName}"
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
                              	            	if(value!=$('#subCatName1').val())
                              	              	$('<option>').val(key).text(value).appendTo(select);
                              	            	else
                              	            		$('<option selected="selected">').val(key).text(value).appendTo(select);      
                              	            }
                              	            );
                              	          
                              	            
                              	          });
                              	         })
                              	         
                              	      // $('#subCatId').key = $('#subCatName1').val();
                              });
                              
      						function change()
      						{
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
                     	           
                       	          //$('#subCatId').val(key) = $('#subCatName1').val();
                     	          });
      						}
                              	
                           </script>			    
                           
                        </td>
                        <td></td>
                     </tr>
                     <tr>
                        <td>Sub Category: </td>
                        <td>
                           <div class="col-sm-10">
                              <s:select list="subCatList" name="subCatId" id="subCatId"
                                 listKey="key" listValue="value" 
                                 headerKey="%{itemSubCatId}" headerValue="Select Sub Category"
                                  value="%{itemSubCatId}"></s:select>
                                  <s:property value="itemSubCatId"/>
                           </div>
                        </td>
                         
                     </tr>
                     <tr>
                        <td>Additional Field 1: </td>
                        <td>
                           <div class="col-sm-10">
                              <s:textfield name="addField1" id="addField1" placeholder="Additional Field 1" value="%{addField1}"/>
                           </div>
                        </td>
                     </tr>
                     <tr>
                        <td>Additional Field 2: </td>
                        <td>
                           <div class="col-sm-10">
                              <s:textfield name="addField2" id="addField2" placeholder="Additional Field 2" value="%{addField2}"/>
                           </div>
                        </td>
                     </tr>
                     <tr>
                        <td>Deal:</td>
                        <td>
                           <div class="col-sm-10">
                              <s:select name="dealFlag"  label="Deal?" id="dealFlag" 
                                 headerKey="0" headerValue="Is it Deal"
                                 list="#{'Y':'Yes', 'N':'No'}" value="%{dealflag}"/>
                                 
                           </div>
                        </td>
                     </tr>
                     <tr>
                        <td>Discount: </td>
                        <td>
                           <div class="col-sm-10">
                              <s:textfield name="discount" placeholder="Discount"/>
                           </div>
                        </td>
                     </tr>
                     
                     <tr>
                        <td>Expiry On </td>
                        <td>
                           <div class="col-sm-10">
                               
                               <sx:datetimepicker name="expiryOn" id="expireOn" startDate="%{'today'}"/>
                               
                           </div>
                        </td>
                     </tr>
                     <tr>
                        <td>Warranty </td>
                        <td>
                           <div class="col-sm-10">
                              <s:textfield name="warranty" id="warranty" placeholder="Warranty Period" value="%{warrantyperiod}"/>
                           </div>
                        </td>
                     </tr>
                     <tr>
                       <td>Color </td> 
                       <td> <div class="col-sm-10"> 
                       			<s:select name="color" id="color" label="select color?" headerKey="0" headerValue="%{color}" list="#{ 'Golden':'Golden', 'Sliver':'Silver', 'Blue':'Blue', 'Red':'Red', 'Others':'Other'}" value="%{color}"/> 
 								
                       		</div> 
                       </td>
                     </tr>
                     <tr>
                        <td>Weight </td>
                        <td>
                           <div class="col-sm-10">
                              <s:textfield name="weight" id="weight" placeholder="weight" value="%{weight}"/>
                           </div>
                        </td>
                     </tr>
                     <tr>
                        <td>Brand </td>
                        <td>
                           <div class="col-sm-10">
                              <s:textfield name="brand" id="brand" placeholder="Brand" value="%{brand}"/>
                           </div>
                        </td>
                     </tr>
                     <tr>
                        <td>Condition of Item </td>
                        <td>
                           <div class="col-sm-10">
                              <s:textfield name="condition" id="condition" placeholder="Condition of item" value="%{conditionoftheitem}"/>
                           </div>
                        </td>
                     </tr>
                          <tr>
                        <td>Attribute Name:</td>
                        <td>
                           <div class="col-sm-10">
                              <s:textfield name="attrkey1" id="attrkey1" placeholder="Attribute Name" value="%{attrkey1}"/>
                           </div>
                        </td>
                     </tr>
                      <tr>
                        <td>Attribute Value:</td>
                        <td>
                           <div class="col-sm-10">
                              <s:textfield name="attrval1" id="attrval1" placeholder="Attribute Value" value="%{attrval1}"/>
                           </div>
                        </td>
                     </tr>
                      <tr>
                        <td>Attribute Name:</td>
                        <td>
                           <div class="col-sm-10">
                              <s:textfield name="attrkey2" id="attrkey2" placeholder="Attribute Name"/>
                           </div>
                        </td>
                     </tr>
                      <tr>
                        <td>Attribute Value:</td>
                        <td>
                           <div class="col-sm-10">
                              <s:textfield name="attrval2" id="attrval2" placeholder="Attribute Value"/>
                           </div>
                        </td>
                     </tr>
                      <tr>
                        <td>Attribute Name:</td>
                        <td>
                           <div class="col-sm-10">
                              <s:textfield name="attrkey3" id="attrkey3" placeholder="Attribute Name"/>
                           </div>
                        </td>
                     </tr>
                      <tr>
                        <td>Attribute Value:</td>
                        <td>
                           <div class="col-sm-10">
                              <s:textfield name="attrval3" id="attrval3" placeholder="Attribute Value"/>
                           </div>
                        </td>
                     </tr>
                      <tr>
                        <td>Attribute Name:</td>
                        <td>
                           <div class="col-sm-10">
                              <s:textfield name="attrkey4" id="attrkey4" placeholder="Attribute Name"/>
                           </div>
                        </td>
                     </tr>
                      <tr>
                        <td>Attribute Value:</td>
                        <td>
                           <div class="col-sm-10">
                              <s:textfield name="attrval4" id="attrval4" placeholder="Attribute Value"/>
                           </div>
                        </td>
                     </tr>
                      <tr>
                        <td>Attribute Name:</td>
                        <td>
                           <div class="col-sm-10">
                              <s:textfield name="attrkey5" id="attrkey5" placeholder="Attribute Name"/>
                           </div>
                        </td>
                     </tr>
                      <tr>
                        <td>Attribute Value:</td>
                        <td>
                           <div class="col-sm-10">
                              <s:textfield name="attrval5" id="attrval5" placeholder="Attribute Value"/>
                           </div>
                        </td>
                     </tr>
                     
                  </table>
            
               		</s:iterator>
             
                  <div align="center">
                     <br>
                     <input type="button" value="Previous" class="btn btn-primary" onclick="goBack()"/>
                     <s:submit value="Submit" action="updateItem" class="btn btn-primary"></s:submit>
                     <s:submit value="Home" action="homePageAction" class="btn btn-primary"></s:submit>
                  </div>
               </s:form>
            </div>
         </div>
      </div>
   </body>
</html>
