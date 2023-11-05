<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="/common/taglib.jsp"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Job Detail</title>
</head>
<body>
<style>
p{
	color: #000;
	
}
.post-details1{
	padding: 0;
	margin: 0;
}
</style>
	<main> 
		<!-- Navigation --> 
		<%@ include file="/common/element/header.jsp"%>
		 
		<!-- job post company Start -->
		<div class="job-post-company pt-130 pb-130">
			<div class="container">
				<div class="row justify-content-center">
					<h2>${job.title}</h2>
				</div><br/>
				<div class="row justify-content-between">
					<!-- Left Content -->
					<div class="left-content col-xl-8 col-lg-9">
						<!-- job single -->
						<div class="single-job-items mb-50">
							<div class="job-items">
								<div class="company-img company-img-details">
									<a href="#"><img src="/template/web/img/icon/job-list1.png" alt=""></a>
								</div>
								<div class="job-tittle">
									<c:forEach var="employer" items="${employers}">
										<c:if test="${job.employer_id==employer.id}">
											<h4>${employer.companyName}</h4>
										</c:if>
									</c:forEach> 
									<c:forEach var="category" items="${categories}">
										<c:if test="${job.category_id==category.id}">
											<p>${category.name}</p>
										</c:if>
									</c:forEach>
									<ul>
										<li><i class="fas fa-map-marker-alt"></i>${job.location}</li>
										<li><span class="salary">${job.salary} - ${job.salary+5} triệu</span></li>
										<li><i class="fa fa-regular fa-clock"></i>${job.createAt}</li>
									</ul>
								</div>
							</div>
						</div>
						<!-- job single End -->
	
						<div class="job-post-details">
							<div class="post-details1">
								<!-- Small Section Tittle -->
								<div class="small-section-tittle">
									<h3>Hình thức làm việc</h4>
								</div>
								<p>- ${job.type}</p>
							</div>
							<div class="post-details1">
								<!-- Small Section Tittle -->
								<div class="small-section-tittle">
									<h3>Mô tả công việc</h4>
								</div>
								<c:forEach var="description" items='${job.description.split("-")}'>
									<p>- ${description}</p>
								</c:forEach>
							</div>
							<div class="post-details2">
								<!-- Small Section Tittle -->
								<div class="small-section-tittle">
									<h3>Yêu cầu</h4>
								</div>
								<c:forEach var="requirement" items='${job.requirements.split("-")}'>
									<p>- ${requirement}</p>
								</c:forEach>
							</div>
							<div class="post-details2">
								<!-- Small Section Tittle -->
								<div class="small-section-tittle">
									<h3>Quyền lợi</h4>
								</div>
								<c:forEach var="benefit" items='${job.benefit.split("-")}'>
									<p>- ${benefit}</p>
								</c:forEach>
							</div>
							<div class="post-details1">
								<!-- Small Section Tittle -->
								<div class="small-section-tittle">
									<h3>Kỹ năng</h4>
								</div>
								<ul>
										<c:forEach var="skill" items="${skills}">
											<c:forEach var="jobSkill" items="${job.skills}">
												<c:if test="${skill.id==jobSkill}">
													<li><p>${skill.name}</p></li>
												</c:if>
											</c:forEach>
										</c:forEach>
									</ul>
							</div>
							<div class="apply-btn2">
								<a href="/trang-chu" class="btn">Back Home</a>
							</div>
						</div>
	
					</div>
					<!-- Right Content -->
					<div class="right-content col-xl-4 col-lg-4">
						<div class="job-box post-details3  mb-50">
							<!-- Small Section Tittle -->
							<div class="small-section-tittle">
								<h4>Tổng quan tuyển dụng</h4>
							</div>
							<ul>
								<li>Hạn tuyển dụng : <span>${job.deadline}</span></li>
								<li>Địa điểm : <span>${job.location }</span></li>
								<li>Mức lương: <span class="salary">${job.salary} - ${job.salary+5} triệu</span></li>
							</ul>
							<div class="apply-btn2">
								<a href="#" class="btn">Ứng tuyển</a>
							</div>
						</div>
						<div class="post-details4  mb-50">
							<!-- Small Section Tittle -->
							<div class="small-section-tittle">
								<h4>Thông tin liên hệ</h4>
							</div>
							<ul>
								<c:forEach var="employer" items="${employers}">
									<c:forEach var="user" items="${users}">
										<c:if test="${job.employer_id==employer.id}">
											<c:if test="${employer.id==user.id}">
												<li>Tên           : <span>${user.lastName} ${user.firstName}</span></li>
												<li>Chức vụ       : <span>${employer.position}</span></li>
												<li>Số điện thoại : <span>${user.phone}</span></li>
												<li>Email         : <span>${user.email}</span></li>
											</c:if>
										</c:if>
									</c:forEach>
								</c:forEach>
							</ul>
						</div>
					</div>
				</div>
			</div>
		</div>
		<!-- job post company End --> 
		
		<!-- Footer --> 
		<%@ include file="/common/element/footer.jsp"%> 
	</main>
</body>
</html>