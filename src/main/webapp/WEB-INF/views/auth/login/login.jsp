<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="/common/taglib.jsp"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Dang nhap</title>
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
								<div class="col-lg-6 col-md-6">
									<h3 class="mb-30">Đăng nhập</h3>
									<form action="#">
										<div class="mt-10">
											<input type="text" name="email" placeholder="Email"
												onfocus="this.placeholder = ''"
												onblur="this.placeholder = 'Email'" required
												class="single-input">
										</div>
										<div class="mt-10">
											<input type="text" name="password" placeholder="Password"
												onfocus="this.placeholder = ''"
												onblur="this.placeholder = 'Password'" required
												class="single-input">
										</div>
										<div class="mt-3">
											<div class="col-lg-4 col-md-4 mt-sm-30">
												<div class="single-element-widget">
													<div class="switch-wrap d-flex justify-content-between">
														<p>Nhớ mật khẩu</p>
														<div class="confirm-radio">
															<input type="checkbox" id="confirm-radio" checked>
															<label for="confirm-radio"></label>
														</div>
													</div>
												</div>
											</div>
										</div>
										<div class="mt-10">
											<a href="#" class="genric-btn primary-border circle arrow">Đăng
												nhập<span class="lnr lnr-arrow-right"></span>
											</a>
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
