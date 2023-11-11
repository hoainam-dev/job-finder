<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="com.jobfinder.util.SecurityUtils"%>
<%@include file="/common/taglib.jsp"%>

<!-- Preloader Start -->
<div id="preloader-active">
	<div class="preloader d-flex align-items-center justify-content-center">
		<div class="preloader-inner position-relative">
			<div class="preloader-circle"></div>
			<div class="preloader-img pere-text">
				<img src="./template/web/img/logo/logo.png" alt="">
			</div>
		</div>
	</div>
</div>
<!-- Preloader Start -->
<header>
	<!-- Header Start -->
	<div class="header-area header-transparrent">
		<div class="headder-top header-sticky">
			<div class="container">
				<div class="row align-items-center">
					<div class="col-lg-3 col-md-2">
						<!-- Logo -->
						<div class="logo">
							<a href="/"><img src="./template/web/img/logo/logo.png"
								alt=""></a>
						</div>
					</div>
					<div class="col-lg-9 col-md-9">
						<div class="menu-wrapper">
							<!-- Main-menu -->
							<div class="main-menu">
								<nav class="d-none d-lg-block">
									<ul id="navigation">
										<li><a href="/">Home</a></li>
										<li><a href="/viec-lam/danh-sach">Find a Jobs </a></li>
										<li><a href="about.html">About</a></li>
										<li><a href="#">Page</a>
											<ul class="submenu">
												<li><a href="blog.html">Blog</a></li>
												<li><a href="single-blog.html">Blog Details</a></li>
												<li><a href="elements.html">Elements</a></li>
												<li><a href="job_details.html">job Details</a></li>
											</ul></li>
										<li><a href="contact.html">Contact</a></li>
									</ul>
								</nav>
							</div>
							<!-- Header-btn -->
							<div class="header-btn d-none f-right d-lg-block">
								<security:authorize access="isAnonymous()">
									<a href="dang-ky" class="btn head-btn1">Register</a>
									<a href="dang-nhap" class="btn head-btn2">Login</a>
								</security:authorize>
								<security:authorize access="isAuthenticated()">
									<c:forEach items="${users}" var="user">
										<c:if
											test="${user.userName==SecurityUtils.getPrincipal().getUsername()}">
											<a style="color: #000"
												href="<c:url value='/trang-chu/thong-tin-ca-nhan?id=${user.id}'/>">
												Wellcome <%=SecurityUtils.getPrincipal().getId()%>
											</a>
										</c:if>
									</c:forEach>
									<a href="thoat" class="btn head-btn2">Thoát</a>
								</security:authorize>
							</div>
						</div>
					</div>
					<!-- Mobile Menu -->
					<div class="col-12">
						<div class="mobile_menu d-block d-lg-none"></div>
					</div>
				</div>
			</div>
		</div>
	</div>
	<!-- Header End -->
</header>