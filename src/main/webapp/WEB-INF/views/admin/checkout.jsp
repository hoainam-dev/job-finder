<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="/common/taglib.jsp"%>
<!DOCTYPE html>
<html lang="en">
<head>
  <meta charset="utf-8">
  <title>Accept a payment</title>
  <meta name="description" content="A demo of a payment on Stripe">
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <link rel="stylesheet" href="/template/admin/css/checkout.css">
  
  <script src="https://js.stripe.com/v3/"></script>

  <script>
    var publicKey = "${publicKey}"; 
    var amount = "${amount}";
    var email = "${email}";
    var productName = "${productName}";
  </script>

  <script src="/template/admin/js/checkout.js" defer></script>
  
</head>

<body>

<!-- Display a payment form -->
<form id="payment-form">
  <h2>Like the content: Support JavaWhizz</h2>
  <span>You are about to make a payment of: </span>
  <span>${amount}</span>
  <span>USD</span>

  <div id="link-authentication-element">
    <!--Stripe.js injects the Link Authentication Element-->
  </div>

  <div id="payment-element">
    <!--Stripe.js injects the Payment Element-->
  </div>

  <button id="submit">
    <div class="spinner hidden" id="spinner"></div>
    <span id="button-text">Pay now</span>
  </button>

  <div id="payment-message" class="hidden"></div>

</form>

</body>
</html>