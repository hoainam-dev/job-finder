<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ include file="/common/taglib.jsp"%>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="UTF-8">
<meta name="viewport"
	content="width=device-width, initial-scale=1, shrink-to-fit=no">
<title>Công việc đã ứng tuyển</title>

<!-- Thêm Bootstrap CSS -->
<link rel="stylesheet"
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css">
</head>
<body>
	<main> <!-- Apply_job_start -->
	<section class="featured-job-area">
		<div class="container">
			<!-- Section Tittle -->
			<div class="row">
				<div class="col-lg-12">
					<div class="section-tittle text-center">
						<h2>Công việc đã ứng tuyển</h2>
					</div>
				</div>
			</div>
			<!-- JOBS -->
			<c:if test="${empty appliedJobs}">
				<div class="alert alert-info">You have not applied for any
					jobs yet.</div>
			</c:if>
			<c:if test="${not empty appliedJobs}">
				<ul class="list-group">
					<c:forEach var="job" items="${appliedJobs}">
						<div class="row justify-content-center">
							<div class="col-xl-10">
								<!-- single-job-content -->
								<div class="single-job-items mb-30">
									<div class="job-items">
										<div class="company-img">
											<a href="/viec-lam/chi-tiet-bai-viet/${job.id}"> <img
												src="./template/web/img/icon/job-list1.png" alt=""></a>
										</div>
										<div class="job-tittle">
											<a href="/viec-lam/chi-tiet-bai-viet/${job.id}">
												<h4>${job.title}</h4>
											</a> ${job.createBy }
											<ul>
												<li><i class="fas fa-map-marker-alt"></i>${job.location }</li>
												<li>$ ${job.salary}</li>
												<li><i class="fa fa-regular fa-clock"></i>${job.createAt}</li>
											</ul>
										</div>
									</div>
									<div class="items-link f-right">
										<a href="/viec-lam/chi-tiet-bai-viet/${job.id}">Show
											Detail</a>
									</div>
								</div>
							</div>
						</div>
					</c:forEach>
				</ul>
			</c:if>
			<!-- JOBS -->
		</div>
	</section>
	<!-- Apply_job_end --> 
	<!-- Footer --> 
	<%@ include file="/common/web/home-footer.jsp"%> </main>
</body>


<script src="https://code.jquery.com/jquery-3.3.1.slim.min.js"></script>
<script
	src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.7/umd/popper.min.js"></script>
<script
	src="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js"></script>

</html>
