<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@include file="/common/taglib.jsp"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<html>
<head>
<meta charset="UTF-8">
<title>Đăng ký Nhà tuyển dụng</title>
</head>
<body>
	<style>
.error {
	color: red;
}
</style>
<!-- Navigation -->
	<%@ include file="/common/auth/header.jsp" %>
	<!-- slider Area Start-->
	<div class="slider-area ">
		<!-- Mobile Menu -->
		<div class="slider-active">
			<div class="single-slider slider-height d-flex align-items-center"
				data-background="./template/web/img/hero/h1_hero.jpg">
				<div class="container">
					<div class="section-top-border">
						<form:form action="dang-ky-nha-tuyen-dung" method="POST" modelAttribute="employerDTO">
							<div class="row">
								<div class="col-lg-8 col-md-8">
									<h3 class="mb-30">Tài khoản</h3>
									<c:if test="${param.incorrectAccount != null}">
										<div class="alert alert-danger">Username or password
											incorrect</div>
									</c:if>
									<c:if test="${param.accessDenied != null}">
										<div class="alert alert-danger">you Not authorize</div>
									</c:if>
									<c:if test="${not empty message}">
										<div class="alert alert-${alert}">${message}</div>
									</c:if>
									<div class="mt-10">
										<div class="mt-10">
											<label>Tên đăng nhập (*)</label>
											<form:input type="text" class="single-input" path="userName"
												placeholder="Tên đăng nhập" />
											<span><form:errors cssClass="error" path="userName" /></span>
										</div>
										<div class="mt-10">
											<label>Email (*)</label>
											<form:input type="email" class="single-input" path="email"
												placeholder="Email" />
											<span><form:errors cssClass="error" path="email" /></span>
										</div>
										<div class="mt-10">
											<label>Mật khẩu (*)</label>
											<form:input type="password" class="single-input"
												path="password" />
											<span><form:errors cssClass="error" path="password" /></span>
										</div>
										<div class="mt-10">
											<label>Xác nhận mật khẩu (*)</label>
											<form:input type="password" class="single-input"
												path="confirmPassword" />
											<span><form:errors cssClass="error"
													path="confirmPassword" /></span>
										</div>
										<input type="hidden" name="status" value="1"> <input
											type="hidden" name="roleId" value="2">
									</div>
									<hr />
									<h3 class="mb-30">Thông tin nhà tuyển dụng</h3>
									<div class="row">
										<div class="col-sm-6">
											<label>Họ (*)</label>
											<form:input type="text" class="single-input" path="lastName" />
											<span><form:errors cssClass="error" path="lastName" /></span>
										</div>
										<div class="col-sm-6">
											<label>Tên (*)</label>
											<form:input type="text" class="single-input" path="firstName" />
											<span><form:errors cssClass="error" path="firstName" /></span>
										</div>
									</div>
									<div class="mt-10">
										<label>Chức vụ</label>
										<form:input type="text" class="single-input" path="position" />
										<span><form:errors cssClass="error" path="position" /></span>
									</div>
									<div class="mt-10">
										<label>Tên công ty</label>
										<form:input type="text" class="single-input"
											path="companyName" />
										<span><form:errors cssClass="error" path="companyName" /></span>
									</div>
									<div class="mt-10">
										<label>Địa chỉ công ty</label>
										<form:input type="text" class="single-input"
											path="companyAddress" />
										<span><form:errors cssClass="error"
												path="companyAddress" /></span>
									</div>
									<!-- <div class="input-group-icon mt-10">
										<div class="icon">
											<i class="fa fa-plane" aria-hidden="true"></i>
										</div>
										<div class="form-select" id="default-select"">
											<select>
												<option value=" 1">City</option>
												<option value="1">Dhaka</option>
												<option value="1">Dilli</option>
												<option value="1">Newyork</option>
												<option value="1">Islamabad</option>
											</select>
										</div>
									</div> -->
									<div class="mt-5">
										<div class="switch-wrap d-flex justify-content-left">
											<div class="primary-radio">
												<input type="checkbox" id="default-radio"> <label
													for="default-radio"></label>
											</div>
											<p>Đồng ý với các chính sách bảo mật</p>
										</div>
									</div>
									<div class="mt-10">
										<input type="submit"
											class="genric-btn primary-border circle single-input-primary"
											value="Đăng ký" />
									</div>
								</div>
							</div>
							</form>
						</form:form>
					</div>
				</div>
			</div>
		</div>
	</div>
	<!-- slider Area End-->
	<!-- Footer -->
	<%@ include file="/common/auth/footer.jsp" %>
</body>
</html>