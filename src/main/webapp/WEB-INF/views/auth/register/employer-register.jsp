<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@include file="/common/taglib.jsp"%>
<c:url var="employerURL" value="/api/employer" />
<html>
<head>
<meta charset="UTF-8">
<title>Đăng ký Nhà tuyển dụng</title>
</head>
<body>
	<!-- slider Area Start-->
	<div class="slider-area ">
		<!-- Mobile Menu -->
		<div class="slider-active">
			<div class="single-slider slider-height d-flex align-items-center"
				data-background="./template/web/img/hero/h1_hero.jpg">
				<div class="container">
					<div class="section-top-border">
						<form id="formCreate">
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
											<label>Tên đăng nhập</label> <input type="text"
												name="userName" placeholder="Tên đăng nhập"
												onfocus="this.placeholder = ''"
												onblur="this.placeholder = 'Tên đăng nhập'" required
												class="single-input">
										</div>
										<div class="mt-10">
											<label>Enail</label> <input type="email" name="email"
												placeholder="nguyenvana@gmail.com"
												onfocus="this.placeholder = ''"
												onblur="this.placeholder = 'nguyenvana@gmail.com'" required
												class="single-input">
										</div>
										<div class="mt-10">
											<label>Mật khẩu</label> <input type="password"
												name="password" placeholder="Mật khẩu"
												onfocus="this.placeholder = ''"
												onblur="this.placeholder = 'Mật khẩu'" required
												class="single-input">
										</div>
										<div class="mt-10">
											<label>Xác nhận mật khẩu</label> <input type="password"
												name="password" placeholder="Xác nhận mật khẩu"
												onfocus="this.placeholder = ''"
												onblur="this.placeholder = 'Xác nhận mật khẩu'" required
												class="single-input">
										</div>
										<input type="hidden" name="status" value="1"> <input
											type="hidden" name="roleId" value="2">
									</div>
									<hr />
									<h3 class="mb-30">Thông tin nhà tuyển dụng</h3>
									<div class="row">
										<div class="col-sm-6">
											<label>Họ</label> <input type="text" name="lastName"
												placeholder="Nguuyễn Văn" onfocus="this.placeholder = ''"
												onblur="this.placeholder = 'Nguyễn Văn'" required
												class="single-input">
										</div>
										<div class="col-sm-6">
											<label>Tên</label> <input type="text" name="firstName"
												placeholder="A" onfocus="this.placeholder = ''"
												onblur="this.placeholder = 'A'" required
												class="single-input">
										</div>
									</div>
									<div class="mt-10">
										<label>Chức vụ</label> <input type="text" name="position"
											placeholder="Quản lý nhân sự, Giám đốc,..."
											onfocus="this.placeholder = ''"
											onblur="this.placeholder = 'Quản lý nhân sự, Giám đốc,...'"
											required class="single-input">
									</div>
									<div class="mt-10">
										<label>Tên công ty</label> <input type="text"
											name="companyName" placeholder="Axon"
											onfocus="this.placeholder = ''"
											onblur="this.placeholder = 'Axon'" required
											class="single-input">
									</div>
									<div class="mt-10">
										<label>Địa chỉ công ty</label> <input type="text"
											name="companyAddress"
											placeholder="33 Xô Viết Nghệ Tĩnh - Đà Nẵng"
											onfocus="this.placeholder = ''"
											onblur="this.placeholder = '33 Xô Viết Nghệ Tĩnh - Đà Nẵng'"
											required class="single-input">
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
										<input type="button" id="btnRegister"
											class="genric-btn primary-border circle single-input-primary"
											value="Đăng ký" />
									</div>
								</div>
							</div>
						</form>
					</div>
				</div>
			</div>
		</div>
	</div>
	<!-- slider Area End-->
	<script type="text/javascript">
		var btnRegister = document.getElementById("btnRegister");
		btnRegister.onclick = function(e) {
			e.preventDefault();
			var data = {};
			var formData = $('#formCreate').serializeArray();
			$.each(formData, function(i, v) {
				data["" + v.name + ""] = v.value;
			});
			resgister(data);
		};

		function resgister(data) {
			$
					.ajax({
						url : '${employerURL}',
						type : 'POST',
						contentType : 'application/json',
						data : JSON.stringify(data),
						dataType : 'json',
						success : function(result) {
							window.location.href = "/dang-nhap?message=register-success";
						},
						error : function(error) {
							window.location.href = "/dang-ky?type=nha-tuyen-dungc&message=error";
						}
					});
		}
	</script>
</body>
</html>