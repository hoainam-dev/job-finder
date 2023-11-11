<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="/common/taglib.jsp"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Nhà tuyển dụng</title>
</head>
<body class="g-sidenav-show  bg-gray-100">
	<!-- Left SideBar -->
	<%@ include file="/common/employer/header.jsp"%>
	<main
		class="main-content position-relative max-height-vh-100 h-100 border-radius-lg ">
	<!-- Navbar --> <%@ include file="/common/employer/navbar.jsp"%>
	<div class="container-fluid py-4">
	<c:if test="${not empty message}">
		<div class="alert alert-${alert}">${message}</div>
	</c:if>
		<div class="row">
			<div class="col-lg-7 mx-auto">
				<div class="card mt-2 mx-auto p-4 bg-light">
					<div class="card-body bg-light">
						<div class="container">
							<form id="contact-form" role="form"
								action="/trang-chu/thong-tin-ca-nhan?id=${user.id}"
								method="post">
								<input name="id" value="${user.id}" type="hidden">
								<div class="controls">

									<div class="row">
										<div class="col-md-6">
											<div class="form-group">
												<label for="form_firstName">First Name *</label> <input
													id="form_firstName" type="text" name="firstName"
													class="form-control" value="${user.firstName}"
													required="required" data-error="Firstname is required.">

											</div>
										</div>
										<div class="col-md-6">
											<div class="form-group">
												<label for="form_lastName">Last Name *</label> <input
													id="form_lastName" type="text" name="lastName"
													class="form-control" value="${user.lastName}"
													required="required" data-error="Lastname is required.">
											</div>
										</div>
									</div>
									<div class="row">

										<div class="col-md-6">
											<div class="form-group">
												<label for="form_phone">Phone *</label> <input
													id="form_phone" type="text" name="phone"
													class="form-control" value="${user.phone}"
													required="required" data-error="Valid email is required.">

											</div>
										</div>
									</div>
									<div class="row">
										<div class="col-md-12">
											<div class="form-group">

												<label for="form_address">Address *</label> <input
													id="form_address" name="address" class="form-control"
													value="${user.address}" required="required"
													data-error="Please, leave us a message.">
											</div>
										</div>
										<div class="col-md-12 text-center">
											<input type="submit" class="btn btn-send pt-2 btn-block"
												value="Send Message">
										</div>
	</main>
</body>
</html>