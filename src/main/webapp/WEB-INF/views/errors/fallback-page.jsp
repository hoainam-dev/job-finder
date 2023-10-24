<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="/common/taglib.jsp"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Error</title>
</head>
<body>
	<main> <!-- slider Area Start-->
	<div class="slider-area ">
		<!-- Mobile Menu -->
		<div class="slider-active">
			<div class="single-slider slider-height d-flex align-items-center"
				data-background="./template/web/img/hero/h1_hero.jpg">
				<div class="container">
					<div class="section-top-border">
						<div class="row">
							<div class="col-lg-6 col-md-6">
								<blockquote class="generic-blockquote">
									<h1>Oops!</h1>
									<h2>404 Not Found</h2>
									<div class="error-details">Sorry, an error has occured,
										Requested page not found!</div>
									<div class="error-actions">
										<a href="${context}/products" class="btn btn-primary btn-lg"><span
											class="glyphicon glyphicon-home"></span> Take Me Home </a><a
											href="/"
											class="btn btn-default btn-lg"> <span
											class="glyphicon glyphicon-envelope"></span> Contact Support
										</a>
									</div>
								</blockquote>
							</div>

						</div>
					</div>
				</div>
			</div>
		</div>
	</div>
	<!-- slider Area End--> </main>

</body>
</html>
