<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@include file="/common/taglib.jsp"%>
<c:url var="applicantURL" value="/api/applicant" />
<html>
<head>
<meta charset="UTF-8">
<title>Đăng ký Người Tìm Việc</title>
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
						<div class="row">
							<div class="col-lg-8 col-md-8">
								<form id="formCreate">
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
											type="hidden" name="roleId" value="3">
									</div>
									<hr />
									<h3 class="mb-30">Thông tin ứng viên</h3>
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
										<label>Kĩ năng</label>
										<textarea class="single-textarea" name="skills"
											placeholder="Java, MySQL,..." onfocus="this.placeholder = ''"
											onblur="this.placeholder = 'Java, MySQL,...'" required></textarea>
									</div>
									<div class="mt-10">
										<label>Kinh nghiệm</label>
										<textarea class="single-textarea" name="experience"
											placeholder="2 năm làm việc trong lĩnh vực website development..."
											onfocus="this.placeholder = ''"
											onblur="this.placeholder = '2 năm làm việc trong lĩnh vực website development...'"
											required></textarea>
									</div>
									<div class="mt-10">
										<label>Học vấn</label>
										<textarea class="single-textarea" name="education"
											placeholder="Dong A University,..."
											onfocus="this.placeholder = ''"
											onblur="this.placeholder = 'Dong A University,...'" required></textarea>
									</div>
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
								</form>
							</div>
						</div>
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
						url : '${applicantURL}',
						type : 'POST',
						contentType : 'application/json',
						data : JSON.stringify(data),
						dataType : 'json',
						success : function(result) {
							window.location.href = "/dang-nhap?message=register-success";
						},
						error : function(error) {
							window.location.href = "/dang-ky?type=nguoi-tim-viec&message=error";
						}
					});
		}
	</script>
</body>
</html>