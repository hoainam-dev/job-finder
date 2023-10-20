<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@include file="/common/taglib.jsp"%>
<c:url var="userURL" value="/api/user" />
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
								<h3 class="mb-30">Tài khoản</h3>
								<form id="formUser">
									<div class="mt-10">
										<div class="mt-10">
											<label>Tên đăng nhập</label> <input type="text"
												name="userName" placeholder="Tên đăng nhập"
												onfocus="this.placeholder = ''"
												onblur="this.placeholder = 'Tên đăng nhập'" required
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
										<input type="hidden" name="status" value="1">
										<input type="hidden" name="roleId" value="3">
									</div>
								</form>
								<hr />
							</div>
							<form id="formApplicant">
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
											onblur="this.placeholder = 'A'" required class="single-input">
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
								<input type="hidden" name="user_id" value="${userId}">
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
	<!-- slider Area End-->
	<script type="text/javascript">
		var btnRegister = document.getElementById("btnRegister");
		btnRegister.onclick = function(e) {
			e.preventDefault();
			var userdata = {};
			var userData = $('#formUser').serializeArray();
			$.each(userData, function(i, v) {
				userdata["" + v.name + ""] = v.value;
			});
			addUser(userdata);
			console.log(userdata);
			
			var applicantdata = {};
			var applicantData = $('#formApplicant').serializeArray();
			$.each(applicantData, function(i, v) {
				applicantdata["" + v.name + ""] = v.value;
			});
			console.log(applicantdata);
			addApplicant(applicantdata);
			
		};
		function addUser(data) {
			$.ajax({
				url : '${userURL}',
				type : 'POST',
				contentType : 'application/json',
				data : JSON.stringify(data),
				dataType : 'json',
				success : function(result) {
					console.log("SUCCESS");
				},
				error : function(error) {
					console.log("ERROR");
				}
			});
		}
		function addApplicant(data) {
			$.ajax({
				url : '${applicantURL}',
				type : 'POST',
				contentType : 'application/json',
				data : JSON.stringify(data),
				dataType : 'json',
				success : function(result) {
					console.log("SUCCESS");
				},
				error : function(error) {
					console.log("ERROR");
				}
			});
		}
	</script>
</body>
</html>