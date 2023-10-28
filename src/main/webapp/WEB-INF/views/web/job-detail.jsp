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
	<main>
	    <!-- Navigation -->
	    	
			<!-- Hero Area Start-->
			        <div class="row slider-area" style="background:#F2185D; padding:30px">
        			<div class="col-xl-1">
        			 	<a href="/trang-chu"><i class="fa fa-home" aria-hidden="true" style="font-size:30px; color:white"></i></a>
        			</div>
                    <div class="col-xl-10">
                        <div class="hero-cap text-center">
                            <h2>${job.title}</h2>
                        </div>
                    </div>
                </div>
        <!-- Hero Area End -->
        <!-- job post company Start -->
        <div class="job-post-company pt-120 pb-120">
            <div class="container">
                <div class="row justify-content-between">
                    <!-- Left Content -->
                    <div class="col-xl-7 col-lg-8">
                        <!-- job single -->
                        <div class="single-job-items mb-50">
                            <div class="job-items">
                                <div class="company-img company-img-details">
                                    <a href="#"><img src="assets/img/icon/job-list1.png" alt=""></a>
                                </div>
                                <div class="job-tittle">
                                    <h4>${job.title}</h4>
                                    <ul>
                                        <li><i class="fas fa-map-marker-alt"></i>${job.location }</li>
                                        <li>$ ${job.salary }</li>
                                        <li><i class="fa fa-regular fa-clock"></i>${job.create_at}</li>
                                    </ul>
                                </div>
                            </div>
                        </div>
                          <!-- job single End -->
                       
                        <div class="job-post-details">
                            <div class="post-details1 mb-50">
                                <!-- Small Section Tittle -->
                                <div class="small-section-tittle">
                                    <h4>Job Description</h4>
                                </div>
                                <p>${job.description}</p>
                            </div>
                            <div class="post-details2  mb-50">
                                 <!-- Small Section Tittle -->
                                <div class="small-section-tittle">
                                    <h4>Requirements</h4>
                                </div>
                               <p>${job.requirements}</p>
                            </div>
                            <div class="apply-btn2">
	                           <a href="/trang-chu" class="btn">Back Home</a>
	                        </div>
                        </div>

                    </div>
                    <!-- Right Content -->
                    <div class="col-xl-4 col-lg-4">
                        <div class="post-details3  mb-50">
                            <!-- Small Section Tittle -->
                           <div class="small-section-tittle">
                               <h4>Job Overview</h4>
                           </div>
                          <ul>
                              <li>Posted date time : <span>${job.create_at }</span></li>
                              <li>Location : <span>${job.location }</span></li>
                              <li>Salary :  <span>$ ${job.salary }</span></li>
                              <li>Application date : <span></span></li>
                          </ul>
                         <div class="apply-btn2">
                            <a href="#" class="btn">Apply Now</a>
                         </div>
                       </div>
                        <div class="post-details4  mb-50">
                            <!-- Small Section Tittle -->
                           <div class="small-section-tittle">
                               <h4>Company Information</h4>
	                           </div>
	                            <ul>
                                <li>Name: <span>Colorlib </span></li>
                                <li>Web : <span> colorlib.com</span></li>
                                <li>Email: <span>carrier.colorlib@gmail.com</span></li>
                            </ul>
                       </div>
                    </div>
                </div>
            </div>
        </div>
        <!-- job post company End -->
	</main>
</body>
</html>