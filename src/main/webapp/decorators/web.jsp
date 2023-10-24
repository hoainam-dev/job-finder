<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@include file="/common/taglib.jsp" %>
<!DOCTYPE html">
<html>
<head>
    <title><dec:title default="Trang chủ" /></title>
	<meta charset="UTF-8">
    <link rel="manifest" href="site.webmanifest">
	<link rel="shortcut icon" type="image/x-icon" href="<c:url value='./template/web/img/favicon.ico' />">

	<!-- CSS here -->
    <link type="text/css" rel="stylesheet" href="<c:url value='/template/web/css/bootstrap.min.css' />">
    <link type="text/css" rel="stylesheet" href="<c:url value='/template/web/css/owl.carousel.min.css' />">
    <link type="text/css" rel="stylesheet" href="<c:url value='/template/web/css/flaticon.css' />">
    <link type="text/css" rel="stylesheet" href="<c:url value='/template/web/css/price_rangs.css' />">
    <link type="text/css" rel="stylesheet" href="<c:url value='/template/web/css/slicknav.css' />">
    <link type="text/css" rel="stylesheet" href="<c:url value='/template/web/css/animate.min.css' />">
    <link type="text/css" rel="stylesheet" href="<c:url value='/template/web/css/magnific-popup.css' />">
    <link type="text/css" rel="stylesheet" href="<c:url value='/template/web/css/fontawesome-all.min.css' />">
    <link type="text/css" rel="stylesheet" href="<c:url value='/template/web/css/themify-icons.css' />">
    <link type="text/css" rel="stylesheet" href="<c:url value='/template/web/css/slick.css' />">
    <link type="text/css" rel="stylesheet" href="<c:url value='/template/web/css/nice-select.css' />">
    <link type="text/css" rel="stylesheet" href="<c:url value='/template/web/css/style.css' />">
</head>
<body>
	<!-- Navigation -->
	<%@ include file="/common/web/header.jsp" %>
	
	<dec:body/>
	
	<!-- Footer -->
	<%@ include file="/common/web/footer.jsp" %>
	
	<!-- All JS Custom Plugins Link Here here -->
	<script src="<c:url value='/template/web/js/vendor/modernizr-3.5.0.min.js' />"></script>
	<!-- Jquery, Popper, Bootstrap -->
	<script src="<c:url value='/template/web/js/vendor/jquery-1.12.4.min.js' />"></script>
	<script src="<c:url value='/template/web/js/popper.min.js' />"></script>
	<script src="<c:url value='/template/web/js/bootstrap.min.js' />"></script>
    
   	<!-- Jquery Mobile Menu -->
   	<script src="<c:url value='/template/web/js/jquery.slicknav.min.js' />"></script>

	<!-- Jquery Slick , Owl-Carousel Plugins -->
	<script src="<c:url value='/template/web/js/owl.carousel.min.js' />"></script>
	<script src="<c:url value='/template/web/js/slick.min.js' />"></script>
	<script src="<c:url value='/template/web/js/price_rangs.js' />"></script>
   
	<!-- One Page, Animated-HeadLin -->
	<script src="<c:url value='/template/web/js/wow.min.js' />"></script>
	<script src="<c:url value='/template/web/js/animated.headline.js' />"></script>
	<script src="<c:url value='/template/web/js/jquery.magnific-popup.js' />"></script>

	<!-- Scrollup, nice-select, sticky -->
	<script src="<c:url value='/template/web/js/jquery.scrollUp.min.js' />"></script>
	<script src="<c:url value='/template/web/js/jquery.nice-select.min.js' />"></script>
	<script src="<c:url value='/template/web/js/jquery.sticky.js' />"></script>
      
    <!-- contact js -->
    <script src="<c:url value='/template/web/js/contact.js' />"></script>
    <script src="<c:url value='/template/web/js/jquery.validate.min.js' />"></script>
    <script src="<c:url value='/template/web/js/mail-script.js' />"></script>
    <script src="<c:url value='/template/web/js/jquery.ajaxchimp.min.js' />"></script>
   
	<!-- Jquery Plugins, main Jquery -->	
	<script src="<c:url value='/template/web/js/plugins.js' />"></script>
	<script src="<c:url value='/template/web/js/main.js' />"></script>
</body>
</html>