<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Employer Register</title>
</head>
<body>
	<main>
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
									<h3 class="mb-30">Đăng ký nhà tuyển dụng</h3>
									<form action="#">
										<div class="mt-10">
											<input type="text" name="first_name" placeholder="First Name"
												onfocus="this.placeholder = ''"
												onblur="this.placeholder = 'First Name'" required
												class="single-input">
										</div>
										<div class="mt-10">
											<input type="text" name="last_name" placeholder="Last Name"
												onfocus="this.placeholder = ''"
												onblur="this.placeholder = 'Last Name'" required
												class="single-input">
										</div>
										<div class="mt-10">
											<input type="text" name="last_name" placeholder="Last Name"
												onfocus="this.placeholder = ''"
												onblur="this.placeholder = 'Last Name'" required
												class="single-input">
										</div>
										<div class="mt-10">
											<input type="email" name="EMAIL" placeholder="Email address"
												onfocus="this.placeholder = ''"
												onblur="this.placeholder = 'Email address'" required
												class="single-input">
										</div>
										<div class="input-group-icon mt-10">
											<div class="icon">
												<i class="fa fa-thumb-tack" aria-hidden="true"></i>
											</div>
											<input type="text" name="address" placeholder="Address"
												onfocus="this.placeholder = ''"
												onblur="this.placeholder = 'Address'" required
												class="single-input">
										</div>
										<div class="input-group-icon mt-10">
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
										</div>
										<div class="mt-10">
												<a href="#" class="genric-btn primary-border circle arrow">Dang nhap<span
											class="lnr lnr-arrow-right"></span></a>
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

	</main>
</body>
</html>