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
<body background="pic.jpeg">
<div class="container">
<s:action name="test" executeResult="true" />
Payment Successful!!
<p>Order has been placed!<p>
<p>Order Status = Payment Successful<p>
<p>Order id=<s:property value="UUID_Or" /></p>
<p>Shipping Address=<s:property value="#session.address" /></p>
<h1>YOU ARE QUALIFIED FOR LAB EXAM!! :)</h1>
</div>
</body>
</html>