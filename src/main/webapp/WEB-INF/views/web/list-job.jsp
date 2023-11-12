<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Danh sách công việc</title>
</head>
<body>
<style>
	.left-content {
	    background: #fff;
	}
	.right-content {
	    background: #fff;
	}
</style>
	<main>
	<!-- Navigation --> 
	<%@ include file="/common/element/header.jsp"%>
	<!-- Hero Area Start-->
    <div class="slider-area ">
        <div class="single-slider section-overly slider-height2 d-flex align-items-center" 
        data-background="/template/web/img/hero/h1_hero.png">
            <div class="container">
                <div class="row">
                    <div class="col-xl-12">
                        <div class="hero-cap text-center">
                            <h2>Danh sách tuyển dụng</h2>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </div>
    <!-- Hero Area End -->
	<!-- Job List Area Start -->
	<div class="job-listing-area pt-120 pb-120">
		<div class="container">
			<div class="row">
				<!-- Left content -->
				<div class="left-content col-xl-3 col-lg-3 col-md-4">
					<div class="row">
						<div class="col-7">
							<div class="small-section-tittle2 mb-45">
								<div class="ion">
									<svg xmlns="http://www.w3.org/2000/svg"
										xmlns:xlink="http://www.w3.org/1999/xlink" width="20px"
										height="12px">
                                    <path fill-rule="evenodd"
											fill="rgb(27, 207, 107)"
											d="M7.778,12.000 L12.222,12.000 L12.222,10.000 L7.778,10.000 L7.778,12.000 ZM-0.000,-0.000 L-0.000,2.000 L20.000,2.000 L20.000,-0.000 L-0.000,-0.000 ZM3.333,7.000 L16.667,7.000 L16.667,5.000 L3.333,5.000 L3.333,7.000 Z" />
                                    </svg>
								</div>
								<h4>Lọc nhanh</h4>
							</div>
						</div>
						<div class="col-5">
							<a class="btn btn-info" style="padding:15px" href="/viec-lam/danh-sach">bỏ lọc</a>
						</div>
					</div>
					<!-- Job Category Listing start -->
					<div class="job-category-listing mb-50">
						<form>
							<!-- category -->
							<div class="single-listing">
								<div class="small-section-tittle2">
									<h4>Lĩnh vực</h4>
								</div>
								<!-- Select job items start -->
								<div class="select-job-items2">
									<select style="padding: 5px" name="category">
										<option value="0">Tất cả lĩnh vực</option>
										<c:forEach var="category" items="${categories}">
											<option value="${category.id}">${category.name}</option>
										</c:forEach>
									</select>
								</div>
							</div>
							<hr />
							<!-- type -->
							<div class="select-Categories">
								<div class="small-section-tittle2">
									<h4>Phương thức làm việc</h4>
								</div>
								<select style="padding: 5px" name="type">
									<option value="">Tất cả phương thức</option>
									<option value="Full Time">Full Time</option>
									<option value="Part Time">Part Time</option>
									<option value="Remote">Remote</option>
									<option value="Freelance">Freelance</option>
								</select>
							</div>
							<hr />
							<!-- salary -->
							<div class="select-Categories">
								<div class="small-section-tittle2">
									<h4>Mức lương</h4>
								</div>
								<select style="padding: 5px" name="salary">
									<option value="1">Tất cả mức lương</option>
									<option value="9">Dưới 10 triệu</option>
									<% for (int i = 10; i <= 45; i += 5) { %>
										<option value="<%=i%>"><%=i%> - <%=i + 5%> triệu</option>
									<% } %>
									<option value="50">Trên 50 triệu</option>
									<option value="0">Thỏa thuận</option>
								</select>
							</div>
							<hr />
							<!-- location -->
							<div class="select-Categories">
								<div class="small-section-tittle2">
									<h4>Địa điểm</h4>
								</div>
								<div>
									<select style="padding: 5px" name="location" id="location">
										<option value="" selected>Chọn tỉnh thành</option>
									</select>
								</div>
							</div>
							<hr />
							<input type="submit"
								class="genric-btn circle single-input-primary" value="Lọc">
						</form>
					</div>
					<!-- Job Category Listing End -->
				</div>
				<!-- Right content -->
				<div class="right-content col-xl-9 col-lg-9 col-md-8">
                	<!-- Featured_job_start -->
	                <section class="featured-job-area">
		                <div class="container">
		                	<!-- Count of Job list Start -->
                            <div class="row">
                                <div class="col-lg-12">
                                    <div class="count-job mb-35">
                                        <c:if test="${jobs.size()==0}">
                                        	<p>Không có tin nào trùng khớp để hiển thị</p>
                                        </c:if>
                                        <c:if test="${jobs.size()>0}">
                                        	<span>${jobs.size()} tin tìm thấy</span>
                                        <!-- Select job items start -->
                                        <div class="select-job-items">
                                            <span>Lọc theo</span>
                                            <select name="select">
                                                <option value="">None</option>
												<option value="">Alphabet</option>
												<option value="">Time</option>
                                            </select>
                                        </div>
                                        <!--  Select job items End-->
                                        <c:forEach var="job" items="${jobs}">
                                        	<!-- single-job-content -->
			                                <div class="single-job-items mb-30">
			                                    <div class="job-items">
			                                        <div class="company-img">
			                                            <a href="/viec-lam/chi-tiet-viec-lam/${job.id}">
			                                            	<img src="/template/web/img/icon/job-list1.png" alt="">
			                                            </a>
			                                        </div>
			                                        <div class="job-tittle job-tittle2">
			                                            <a href="/viec-lam/chi-tiet-viec-lam/${job.id}">
			                                                <h5>${job.title}</h5>
			                                            </a>
			                                            <ul>
			                                                <li>
			                                                	<c:forEach var="employer" items="${employers}">
																	<c:if test="${job.employer_id==employer.id}">
																		<p>${employer.companyName}</p>
																	</c:if>
																</c:forEach>
			                                                </li>
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
			                                            </ul>
			                                        </div>
			                                    </div>
			                                </div>
                                        </c:forEach>
                                        </c:if>
                                    </div>
                                </div>
                            </div>
                            <!-- Count of Job list End -->
		                </div>
	                </section>
                </div>
			</div>
		</div>
	</div>
	<!-- Job List Area End --> 
	<!--Pagination Start  -->
	<div class="pagination-area pb-115 text-center">
		<div class="container">
			<div class="row">
				<div class="col-xl-12">
					<div class="single-wrap d-flex justify-content-center">
						<nav aria-label="Page navigation example">
							<ul class="pagination justify-content-start">
								<li class="page-item active"><a class="page-link" href="#">01</a></li>
								<li class="page-item"><a class="page-link" href="#">02</a></li>
								<li class="page-item"><a class="page-link" href="#">03</a></li>
								<li class="page-item"><a class="page-link" href="#"><span
										class="ti-angle-right"></span></a></li>
							</ul>
						</nav>
					</div>
				</div>
			</div>
		</div>
	</div>
	<!--Pagination End  --> </main>
	<!-- Navigation -->
	<%@ include file="/common/element/footer.jsp"%>
	<script
		src="https://cdnjs.cloudflare.com/ajax/libs/jquery/3.6.0/jquery.min.js"
		referrerpolicy="no-referrer"></script>
	<script
		src="https://cdnjs.cloudflare.com/ajax/libs/axios/0.21.1/axios.min.js"></script>
	<script>
    	const host = "https://provinces.open-api.vn/api/";
    	// Sử dụng fetch API để lấy dữ liệu từ API
    	fetch(host).then(response => response.json())
    	    .then(data => {
    	        // Xử lý dữ liệu JSON ở đây
    	        fillSelect(data);
    	    });
    	function fillSelect(data) {
    	    const selectElement = document.querySelector('#location');
    	    selectElement.innerHTML = '<option value="">Chọn tỉnh/thành phố</option>';

    	    data.forEach(city => {
    	        const option = document.createElement('option');
    	        option.value = city.codename;
    	        option.text = city.name;
    	        selectElement.appendChild(option);
    	    });
    	}
	</script>
</body>
</html>