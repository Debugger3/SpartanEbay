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
<title>Add Item | ebay</title>
       
<script type="text/javascript">
	function goBack() {
		window.history.back();
	}
	 function enable_text(status)
     {
     	status=!status;	
     	document.f1.attrkey1.disabled = status;
     	document.f1.attrval1.disabled = status;
     	document.f1.attrkey2.disabled = status;
     	document.f1.attrval2.disabled = status;
     	document.f1.attrkey3.disabled = status;
     	document.f1.attrval3.disabled = status;
     	document.f1.attrkey4.disabled = status;
     	document.f1.attrval4.disabled = status;
     	document.f1.attrkey5.disabled = status;
     	document.f1.attrval5.disabled = status;
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
 <script type="text/javascript">
  dojo.addOnLoad(init);
  
  function init() {
	  var itemId = dojo.widget.byId("itemId");
	  dojo.event.connect(itemId, "onValueChanged", adver);
	  
	  var datePicker = dojo.widget.byId("end");
	  dojo.event.connect(datePicker, "onValueChanged", calcost);
	    
	 }
  
  function calcost() {
		 var start=dojo.widget.byId("start").getValue();
		 var end=dojo.widget.byId("end").getValue();
		 var cost = $("#cost").text();
	  /*  var part_s =start.split('/');
		 var mydate_s = new Date(part_s[0],part_s[1]-1,part_s[2]); 
		 var part_e =end.split('/');
		 */  
	     var mydate_s = new Date(start).getTime(); 	 
		 var mydate_e =new Date(end).getTime(); 
	  	var day=(mydate_e - mydate_s);
		var daysDiff = day / 1000 / 60 / 60 / 24;
		var totalCost=daysDiff*cost;
		
		$("#total_cost").val(totalCost);
	}
  
  function adver() {
  	
	  dojo.widget.byId("start").prop('disabled', true);
		/* $("#end").prop('disabled', true);
		$("#cost").prop('disabled', true);
		$("#other").prop('disabled', true);
		$('#add').on('change', function() {
		 */	if (dojo.widget.byId("add").getValue() == 'Y') {
			 dojo.widget.byId("start").removeAttr('disabled');
				/* $("#end").removeAttr('disabled');
				$("#cost").removeAttr('disabled'); */
				
			} else { 
				dojo.widget.byId("start").removeAttr('disabled');
				$("#end").prop('disabled', true);
				$("#cost").prop('disabled', true);
			}
		}
		/* $('#color').on('change', function() {
			if (this.value == 'others') {
				$("#othercolor").removeAttr('disabled');
			} else {
				$("#othercolor").prop('disabled', true);
			}
	
  }
 */
     </script> 
  
  <%-- <script>
	$(document).ready(function() {
		
		$("#start").prop('disabled', true);
		$("#end").prop('disabled', true);
		$("#cost").prop('disabled', true);
		$("#other").prop('disabled', true);
		$('#add').on('change', function() {
			if (this.value == 'Y') {
				$("#start").removeAttr('disabled');
				$("#end").removeAttr('disabled');
				$("#cost").removeAttr('disabled');
				
			} else {
				$("#start").prop('disabled', true);
				$("#end").prop('disabled', true);
				$("#cost").prop('disabled', true);
			}
		});
		$('#color').on('change', function() {
			if (this.value == 'others') {
				$("#othercolor").removeAttr('disabled');
			} else {
				$("#othercolor").prop('disabled', true);
			}
		});
	
</script> 
   --%>
</head>
<body onload="enable_text(false)";>
	<div class="container">
		<s:action name="test" executeResult="true" />
		<div class="col-sm-10">
			<div class="jumbotron">
				<h3>Add your item here</h3>
			</div>
			<hr>
			 <%String typeUser =session.getAttribute("type").toString(); 
			 String userId = session.getAttribute("user").toString();%>
			<div class="well">
				<s:form name="f1" action="addItem" align="center" method="post"
					enctype="multipart/form-data" style="text-align:right">
					<table>
						<tr>
							<td>Item Id:</td>
							<td>
								<div class="col-sm-10">
									<s:textfield id="itemId" name="itemId" disable="true"
										placeholder="Enter Item Id" onchange="calcost()"/>
								</div> <s:fielderror>
									<s:param>itemId</s:param>
								</s:fielderror>
							</td>
						</tr>
						<tr>
							<td>Item Name:</td>
							<td>
								<div class="col-sm-10">
									<s:textfield id="itemName" name="itemName"
										placeholder="Enter Item Name" />
								</div> <s:fielderror>
									<s:param>itemName</s:param>
								</s:fielderror>
							</td>
						</tr>
						<tr>
							<td>Item Description:</td>
							<td>
								<div class="col-sm-10">
									<s:textfield id="itemDesc" name="itemDesc"
										label="Item Description " placeholder="Enter Item Description" />
								</div> <s:fielderror>
									<s:param>itemDesc</s:param>
								</s:fielderror>
							</td>
						</tr>
						<tr>
							<td>Picture:</td>
							<td><s:file id="pic" label="pic" name="pic" /></td>
						</tr>
						<tr>
							<td>Seller Id:</td>
							<td>
								<div class="col-sm-10">
									<s:textfield id="sellerId" label="Seller Id" name="sellerId"
										placeholder="Enter Seller Id" value="%{#session.user}" />
								</div> <s:fielderror>
									<s:param>sellerId</s:param>
								</s:fielderror>
							</td>
						</tr>
						<tr>
							<td>Quantity:</td>
							<td>
								<div class="col-sm-10">
									<s:textfield placeholder="Enter Quantity" id="quantity"
										name="quantity" />
								</div> <s:fielderror>
									<s:param>sellerId</s:param>
								</s:fielderror>
							</td>
						</tr>
						<tr>
							<td>Price:</td>
							<td>
								<div class="col-sm-10">
									<s:textfield label="Price" id="price" name="price"
										placeholder="Enter price" />
								</div> <s:fielderror>
									<s:param>price</s:param>
								</s:fielderror>
							</td>
						</tr>
						<tr>
							<td>Advertising Item :</td>
							<td>
								<div class="col-sm-10">
									<s:select label="AdvertisingItem" id="add" headerKey="-1"
										headerValue="select advertisement" required="true"
										list="#{'Y':'Yes', 'N':'No'}" key="advCheck" value="N" />
								</div>
							</td>
						</tr>
						<tr>
							<td>Start Date</td>
							<td>
								<div class="col-sm-10">
									<%-- <s:textfield name="startDate" id="start" placeholder="Start Date" />
									 --%>
									 
									  <sx:datetimepicker  name="startDate" id="start" displayFormat="dd/MM/yyyy" startDate="%{'today'}" value="%{'today'}"/>
								</div>
							</td>
						</tr>
						<tr>
							<td>End Date</td>
							<td>
								<div class="col-sm-10">
									<%-- <s:textfield name="endDate" id="end" placeholder="End Date" />
										 --%>				
										<sx:datetimepicker id="end" displayFormat="dd/MM/yyyy" startDate="%{'today'}" value="%{'today'}" onchange="calcost()" name="endDate"/>
								 </div>
							</td>
						</tr>
						<tr>
							<td>Advertisement Cost / day</td>
							<td>
								<div class="col-sm-10">
									<span  id="cost" ><s:property value="#session.cost" /> </span>
								</div>
							</td>
						</tr>
						<tr>
							<td>Total Advertisement Cost</td>
							<td>
								<div class="col-sm-10">
									<s:textfield name="total_adv_Cost" id="total_cost" />
								</div>
							</td>
						</tr>

						<tr>
							<td>Category</td>
							<td><s:select list="categoryList" id="categoryId"
									name="categoryId" listValue="catName" listKey="catId"
									headerKey="0" headerValue="Select Category "
									></s:select>
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
								</script> <!--<s:fielderror>
                              <s:param>item</s:param>
                              </s:fielderror>--></td>
						</tr>
						<tr>
							<td>Sub Category:</td>
							<td>
								<div class="col-sm-10">
									<s:select 
									list="subCatList" name="subCatId" id="subCatId"
										listKey="key" listValue="subCatId" headerKey="0"
										headerValue="Select Sub Category"></s:select>
										<s:property value="subCatId"/>
										<s:property value="subCatName"/>
								</div>
							</td>
						</tr>
						<tr>
							<td>Additional Field 1:</td>
							<td>
								<div class="col-sm-10">
									<s:textfield name="addField1" id="addField1"
										placeholder="Additional Field 1" />
								</div>
							</td>
						</tr>
						<tr>
							<td>Additional Field 2:</td>
							<td>
								<div class="col-sm-10">
									<s:textfield name="addField2" id="addField2"
										placeholder="Additional Field 2" />
								</div>
							</td>
						</tr>
						<tr>
							<td>Deal:</td>
							<td>
								<div class="col-sm-10">
									<s:select name="dealFlag" label="Deal?" id="dealFlag"
										headerKey="0" headerValue="Is it Deal"
										list="#{'Y':'Yes', 'N':'No'}" />

								</div>
							</td>
						</tr>
						<tr>
							<td>Discount:</td>
							<td>
								<div class="col-sm-10">
									<s:textfield name="discount" placeholder="Discount" />
								</div>
							</td>
						</tr>

						<tr>
							<td>Expiry On</td>
							<td>
								<div class="col-sm-10">
									 <sx:datetimepicker id="expireOn" displayFormat="dd/MM/yyyy" startDate="%{'today'}" value="%{'today'}" name="expiryOn"/>
					
								</div>
							</td>
						</tr>
						<tr>
							<td>Warranty</td>
							<td>
								<div class="col-sm-10">
									<s:textfield name="warranty" id="warranty"
										placeholder="Warranty Period" />
								</div>
							</td>
						</tr>
						 <tr>
                        <td>Color </td>
                        <td>
                           <div class="col-sm-10">
                              <s:select name="color" id="color" label="select color?" 
                                 headerKey="0" headerValue="Select color"
                                 list="#{'None':'None', 'Black':'Black', 'White':'White', 'Blue':'Blue', 'Green':'Green', 'Red':'Red', 'Other':'Other'}" />
                           </div>
                        </td>
                     </tr>
						<tr>
							<td>Weight</td>
							<td>
								<div class="col-sm-10">
									<s:textfield name="weight" id="weight" placeholder="weight" />
								</div>
							</td>
						</tr>
						<tr>
							<td>Brand</td>
							<td>
								<div class="col-sm-10">
									<s:select name="brand" id="brandFlag" headerKey="0"
										headerValue="Select Brand"
										list="#{'Reebook':'Reebok','Nike':'Nike','Titan':'Titan','Mufti':'Mufti','Others':'Others'}" />
								</div>
							</td>
						</tr>
						<tr>
							<td>Condition of Item</td>
							<td>
								<div class="col-sm-10">
									<s:textfield name="condition" id="condition"
										placeholder="Condition of item" />
								</div>
							</td>
						</tr>
						      </tr>
                     <tr>
				<td><s:checkbox name="others"  onclick="enable_text(this.checked);" >Add Additional Attributes</s:checkbox><br></td>
				<td><br></td>
			</tr>        
                      <tr>
                        <td>Attribute Name:</td>
                        <td>
                           <div class="col-sm-10">
                              <s:textfield name="attrkey1" id="attrkey1" placeholder="Attribute Name"/>
                           </div>
                        </td>
                     </tr>
                      <tr>
                        <td>Attribute Value:</td>
                        <td>
                           <div class="col-sm-10">
                              <s:textfield name="attrval1" id="attrval1" placeholder="Attribute Value"/>
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
					<div align="center">
						<br> <input type="button" value="Previous"
							class="btn btn-primary" onclick="goBack()" />
						<s:submit value="Submit" action="addItem" class="btn btn-primary"></s:submit>
						<s:submit value="Home" action="homePageAction"
							class="btn btn-primary"></s:submit>
					</div>
				</s:form>
			</div>
		</div>
	</div>
</body>
</html>