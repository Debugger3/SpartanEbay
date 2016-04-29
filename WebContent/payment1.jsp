<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
 <%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Electronics, Cars, Fashion, Collectibles, Coupons and More Online Shopping | eBay --Payment</title>
<style >
.body{ margin-top:20px; }

.submit-button {
  margin-top: 10px;
}
</style>
<script type="text/javascript">
$(document).ready(function() {
    
    var navListItems = $('ul.setup-panel li a'),
        allWells = $('.setup-content');

    allWells.hide();

    navListItems.click(function(e)
    {
        e.preventDefault();
        var $target = $($(this).attr('href')),
            $item = $(this).closest('li');
        
        if (!$item.hasClass('disabled')) {
            navListItems.closest('li').removeClass('active');
            $item.addClass('active');
            allWells.hide();
            $target.show();
        }
    });
    
    $('ul.setup-panel li.active a').trigger('click');
    
    // DEMO ONLY //
    $('#activate-step-2').on('click', function(e) {
        $('ul.setup-panel li:eq(1)').removeClass('disabled');
        $('ul.setup-panel li a[href="#step-2"]').trigger('click');
        $(this).remove();
    })    
});
</script>
</head>
<body>
<div class="container">
<s:action name="test" executeResult="true" />
	<div class="row form-group">
        <div class="col-xs-12">
            <ul class="nav nav-pills nav-justified thumbnail setup-panel">
                <li class="active"><a href="#step-1">
                <h4 class="list-group-item-heading">Credit Card</h4>
                </a></li>
                <li class="active"><a href="#step-2">
                    <h4 class="list-group-item-heading">Debit Card</h4>
                </a></li>
                <li class="disabled"><a href="#step-3">
                    <h4 class="list-group-item-heading">Net Banking</h4>
                </a></li>
                <li class="disabled"><a href="#step-4">
                    <h4 class="list-group-item-heading">Wallet</h4>
                </a></li>
                <li class="disabled"><a href="#step-3">
                    <h4 class="list-group-item-heading">COD</h4>
                </a></li>
            </ul>
        </div>
	</div>
    <div class='row'>
        <div class='col-md-4'></div>
        <div class='col-md-4'>
          <s:form action="makePaymentBuyNow" class="require-validation" id="payment-form" method="post">
            <div class='form-row'>
              <div class='col-xs-12 form-group required'>
                <label class='control-label'>Name on Card</label>
          		<s:textfield name="holderName"   size='200' cssClass='form-control card-number'/>
          		<s:hidden name="itemId" value="%{itemId}"></s:hidden>
          		<s:hidden name="sellerId" value="%{sellerId}"></s:hidden>
          		<s:hidden name="quantity" value="%{quantity}"></s:hidden>
          		<s:hidden name="cost" value="%{cost}"></s:hidden>
          		<s:hidden name="discountedCost" value="%{discountedCost}"></s:hidden>
          		<s:hidden name="deliveryCharge" value="%{deliveryCharge}"></s:hidden>
   				<s:hidden name="contactName" value="%{contactName}"></s:hidden>
   				<s:hidden name="address" value="%{addresss}"></s:hidden>
   				<s:hidden name="city" value="%{city}"></s:hidden>
   				<s:hidden name="country" value="%{country}"></s:hidden>
   				<s:hidden name="pincode" value="%{pincode}"></s:hidden>
   				<s:hidden name="state" value="%{state}"></s:hidden>
   				<s:hidden name="phone" value="%{phone}"></s:hidden>
          </div>
          </div>
            <div class='form-row'>
              <div class='col-xs-12 form-group card required'>
                <label class='control-label'>Card Number</label>
              <s:textfield name="cardNumber"   size='200' cssClass='form-control card-number'/>
              
              </div>
            </div>
            <div class='form-row'>
              <div class='col-xs-4 form-group cvc required'>
                <label class='control-label'>CVC</label>
                <s:password  name="cvv" autocomplete='off' cssClass='form-control card-cvc' placeholder='ex. 311' size='4' type='text'/>
              </div>
              <div class='col-xs-4 form-group expiration required'>
                <label class='control-label'>Expiration</label>
                <s:textfield name="expMonth" cssClass='form-control card-expiry-month' placeholder='MM' size='2' type='text'/>
              </div>
              <div class='col-xs-4 form-group expiration required'>
                <label class='control-label'> </label>
                <s:textfield name="expYear" cssClass='form-control card-expiry-year' placeholder='YYYY' size='4' type='text'/>
              </div>
            </div>
            <div class='form-row'>
              <div class='col-md-12'>
                <div class='form-control total btn btn-info'>
                  Total:
                  <span class='amount'><s:property value="cost" /></span>
                </div>
              </div>
            </div>
            <div class='form-row'>
              <div class='col-md-12 form-group'>
                <s:submit value="Pay >>" cssClass='form-control btn btn-primary submit-button' type='submit'/>
              </div>
            </div>
          </s:form>
        </div>
    </div>

</div>
</body>
</html>