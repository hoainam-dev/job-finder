<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="/common/taglib.jsp"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Trang chủ</title>
</head>
<body>
<style>
	.row {
	    display: flex;
	    align-items: center;
	}
	
	.image-container {
	    flex: 1;
	    width: 2rem;
	    text-align: center; /* Đặt ảnh ở giữa dòng */
	}
	
	.text-container {
	    flex: 2;
	    padding: 10px; /* Tạo khoảng cách giữa h5 và p */
	    justify-content: left;
	    text-align: left; /* Đặt ảnh ở giữa dòng */
	}
</style>
	<main>
		<!-- Navigation -->
		<%@ include file="/common/web/home-header.jsp" %>
	
		<!-- slider Area Start-->
		<div class="slider-area ">
			<!-- Mobile Menu -->
			<div class="slider-active">
				<div class="single-slider slider-height d-flex align-items-center"
					data-background="./template/web/img/hero/h1_hero.jpg">
					<div class="container">
						<div class="row">
							<div class="col-xl-6 col-lg-9 col-md-10">
								<div class="hero__caption">
									<h1>Find the most exciting startup jobs</h1>
								</div>
							</div>
						</div>
						<!-- Search Box -->
						<div class="row">
							<div class="col-xl-8">
								<!-- form -->
								<form action="/tim-kiem" class="search-box" method="GET">
									<div class="input-form">
										<input type="text" name="keyword" placeholder="Job Tittle or keyword">
									</div>
									<button type="submit" class="btn btn-primary search-form"> Tìm kiếm</button>
								</form>
							</div>
						</div>
					</div>
				</div>
			</div>
		</div>
		<!-- slider Area End-->
		
		<!-- Featured_job_start -->
		<section class="featured-job-area feature-padding">
			<div class="container">
				<!-- Section Tittle -->
				<div class="row">
					<div class="col-lg-12">
						<div class="section-tittle text-center">
							<span>Tin tuyển dụng</span>
							<h2>Tin nổi bật</h2>
						</div>
					</div>
				</div>
				<c:forEach var="job" items="${jobs}">
					<div class="row justify-content-center">
						<div class="col-xl-11">
							<!-- single-job-content -->
								<div class="single-job-items mb-30">
									<div class="job-items">
										<div class="company-img">
											<a href="job_details.html"><img src="./template/web/img/icon/job-list1.png" alt=""></a>
										</div>
										<div class="job-tittle">
											<a href="/viec-lam/chi-tiet-viec-lam/${job.id}">
												<h5>${job.title}</h5>
											</a>
											<ul>
												<c:forEach var="employer" items="${employers}">
													<c:if test="${job.employer_id==employer.id}">
														<p>${employer.companyName}</p> 
													</c:if>
												</c:forEach>
												<li><i class="fas fa-map-marker-alt"></i>${job.type}</li>
												<li><i class="fas fa-map-marker-alt"></i>${job.location}</li>
												<c:if test="${job.salary==0}">
													<li>Thỏa thuận</li>
												</c:if>
												<c:if test="${job.salary>0&&job.salary<10}">
													<li>Dưới 10 triệu</li>
												</c:if>
												<c:if test="${job.salary>50}">
													<li>Trên 50 triệu</li>
												</c:if>
												<c:if test="${job.salary>=10&&job.salary<=50}">
													<li>${job.salary} - ${job.salary+5} triệu</li>
												</c:if>
												<li>
												<i class="fa fa-regular fa-clock"></i>${job.createAt}</li>
											</ul>
										</div>
									</div>
									<div class="items-link f-right">
										<a href="/viec-lam/chi-tiet-viec-lam/${job.id}">Xem chi tiết</a>
									</div>
								</div>
						</div>
					</div>
				</c:forEach>
			</div>
		</section>
		<!-- Featured_job_end -->
		
		<!-- Our Services Start -->
		<div class="our-services section-pad-t30">
			<div class="container">
				<!-- Section Tittle -->
				<div class="row">
					<div class="col-lg-12">
						<div class="section-tittle text-center">
							<span>FEATURED TOURS Packages</span>
							<h2>Browse Top Categories</h2>
						</div>
					</div>
				</div>
				<a href="">
					<div class="row d-flex justify-contnet-center">
						<c:forEach var="category" items="${categories}">
							<div class="col-xl-3 col-lg-3 col-md-4 col-sm-6">
								<div class="single-services text-center mb-30">
									<div class="services-ion">
										<span class="flaticon-tour"></span>
									</div>
									<div class="services-cap">
										<h5>
											<a href="/viec-lam/${category.id}"><p>${category.name}</p></a>
										</h5>
									</div>
								</div>
							</div>
						</c:forEach>
					</div>
				</a>
				<!-- More Btn -->
			</div>
		</div>
		<!-- Our Services End -->
		
		<!-- Online CV Area Start -->
		<div class="online-cv cv-bg section-overly pt-90 pb-120"
			data-background="./template/web/img/gallery/cv_bg.jpg">
			<div class="container">
				<div class="row justify-content-center">
					<div class="col-xl-10">
						<div class="cv-caption text-center">
							<p class="pera1">FEATURED TOURS Packages</p>
							<p class="pera2">Make a Difference with Your Online Resume!</p>
							<a href="#" class="border-btn2 border-btn4">Upload your cv</a>
						</div>
					</div>
				</div>
			</div>
		</div>
		<!-- Online CV Area End-->
		
		<!-- How  Apply Process Start-->
		<div class="apply-process-area apply-bg pt-150 pb-150"
			data-background="./template/web/img/gallery/how-applybg.png">
			<div class="container">
				<!-- Section Tittle -->
				<div class="row">
					<div class="col-lg-12">
						<div class="section-tittle white-text text-center">
							<span>Apply process</span>
							<h2>How it works</h2>
						</div>
					</div>
				</div>
				<!-- Apply Process Caption -->
				<div class="row">
					<div class="col-lg-4 col-md-6">
						<div class="single-process text-center mb-30">
							<div class="process-ion">
								<span class="flaticon-search"></span>
							</div>
							<div class="process-cap">
								<h5>1. Search a job</h5>
								<p>Sorem spsum dolor sit amsectetur adipisclit, seddo
									eiusmod tempor incididunt ut laborea.</p>
							</div>
						</div>
					</div>
					<div class="col-lg-4 col-md-6">
						<div class="single-process text-center mb-30">
							<div class="process-ion">
								<span class="flaticon-curriculum-vitae"></span>
							</div>
							<div class="process-cap">
								<h5>2. Apply for job</h5>
								<p>Sorem spsum dolor sit amsectetur adipisclit, seddo
									eiusmod tempor incididunt ut laborea.</p>
							</div>
						</div>
					</div>
					<div class="col-lg-4 col-md-6">
						<div class="single-process text-center mb-30">
							<div class="process-ion">
								<span class="flaticon-tour"></span>
							</div>
							<div class="process-cap">
								<h5>3. Get your job</h5>
								<p>Sorem spsum dolor sit amsectetur adipisclit, seddo
									eiusmod tempor incididunt ut laborea.</p>
							</div>
						</div>
					</div>
				</div>
			</div>
		</div>
		<!-- How  Apply Process End-->
		<!-- Testimonial Start -->
		<div class="testimonial-area testimonial-padding">
			<div class="container">
				<!-- Testimonial contents -->
				<div class="row d-flex justify-content-center">
					<div class="col-xl-8 col-lg-8 col-md-10">
						<div class="h1-testimonial-active dot-style">
							<!-- Single Testimonial -->
							<div class="single-testimonial text-center">
								<!-- Testimonial Content -->
								<div class="testimonial-caption ">
									<!-- founder -->
									<div class="testimonial-founder  ">
										<div class="founder-img mb-30">
											<img src="./template/web/img/testmonial/testimonial-founder.png"
												alt=""> <span>Margaret Lawson</span>
											<p>Creative Director</p>
										</div>
									</div>
									<div class="testimonial-top-cap">
										<p>“I am at an age where I just want to be fit and healthy
											our bodies are our responsibility! So start caring for your
											body and it will care for you. Eat clean it will care for you
											and workout hard.”</p>
									</div>
								</div>
							</div>
						</div>
					</div>
				</div>
			</div>
		</div>
		<!-- Testimonial End -->
		
		<!-- Support Company Start-->
		<div class="support-company-area support-padding fix">
			<div class="container">
				<div class="row align-items-center">
					<div class="col-xl-6 col-lg-6">
						<div class="right-caption">
							<!-- Section Tittle -->
							<div class="section-tittle section-tittle2">
								<span>What we are doing</span>
								<h2>24k Talented people are getting Jobs</h2>
							</div>
							<div class="support-caption">
								<p class="pera-top">Mollit anim laborum duis au dolor in
									voluptate velit ess cillum dolore eu lore dsu quality mollit
									anim laborumuis au dolor in voluptate velit cillum.</p>
								<p>Mollit anim laborum.Duis aute irufg dhjkolohr in re
									voluptate velit esscillumlore eu quife nrulla parihatur.
									Excghcepteur signjnt occa cupidatat non inulpadeserunt mollit
									aboru. temnthp incididbnt ut labore mollit anim laborum suis
									aute.</p>
								<a href="/viec-lam/tao-viec-lam" class="btn post-btn">Post a job</a>
							</div>
						</div>
					</div>
					<div class="col-xl-6 col-lg-6">
						<div class="support-location-img">
							<img src="./template/web/img/service/support-img.jpg" alt="">
							<div class="support-img-cap text-center">
								<p>Since</p>
								<span>1994</span>
							</div>
						</div>
					</div>
				</div>
			</div>
		</div>
		<!-- Support Company End-->
		
		<!-- Blog Area Start -->
		<div class="home-blog-area blog-h-padding">
			<div class="container">
				<!-- Section Tittle -->
				<div class="row">
					<div class="col-lg-12">
						<div class="section-tittle text-center">
							<span>Our latest blog</span>
							<h2>Our recent news</h2>
						</div>
					</div>
				</div>
				<div class="row">
					<div class="col-xl-6 col-lg-6 col-md-6">
						<div class="home-blog-single mb-30">
							<div class="blog-img-cap">
								<div class="blog-img">
									<img src="./template/web/img/blog/home-blog1.jpg" alt="">
									<!-- Blog date -->
									<div class="blog-date text-center">
										<span>24</span>
										<p>Now</p>
									</div>
								</div>
								<div class="blog-cap">
									<p>| Properties</p>
									<h3>
										<a href="single-blog.html">Footprints in Time is perfect
											House in Kurashiki</a>
									</h3>
									<a href="#" class="more-btn">Read more »</a>
								</div>
							</div>
						</div>
					</div>
				</div>
			</div>
		</div>
		<!-- Blog Area End -->
		
		<!-- Footer -->
		<%@ include file="/common/web/home-footer.jsp" %>
	</main>
	
</body>
</html>