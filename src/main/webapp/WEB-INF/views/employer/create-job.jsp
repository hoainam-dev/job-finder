<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="/common/taglib.jsp"%>
<%@ page import="com.jobfinder.util.SecurityUtils"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Tạo việc làm</title>
</head>
<body class="g-sidenav-show  bg-gray-100">
	<!-- Left SideBar -->
	<%@ include file="/common/employer/header.jsp"%>
	<main
		class="main-content position-relative max-height-vh-100 h-100 border-radius-lg ">
	<!-- Navbar --> <%@ include file="/common/employer/navbar.jsp"%>

	<div class="container-fluid py-4">
		<div class="row">
			<div class="col-12">
				<div class="card mb-4">
					<div class="card-header pb-0">
						<h6>Tạo việc làm</h6>
					</div>
					<div class="card-body px-0 pt-0 pb-2">
						<div class="container" style="margin-top: 20px">
							<section class="panel panel-default">
								<div class="panel-body">
									<form:form action="/nha-tuyen-dung/tao-viec-lam"
										cssClass="form-horizontal" modelAttribute="jobDTO"
										method="POST">
										<input type="hidden" name="employer_id" value="${employer.id}" />
										<div class="form-group">
											<label for="title" class="col-sm-3 control-label"
												style="font-weight: bold">Title</label>
											<div class="col-sm-9">
												<form:input type="text" path="title" cssClass="form-control"
													placeholder="Please enter title..." />
											</div>
										</div>
										<!-- form-group // -->

										<div class="form-group">
											<label for="location" class="col-sm-3 control-label"
												style="font-weight: bold">Location</label>
											<div class="col-sm-9">
												<form:input type="text" path="location"
													cssClass="form-control"
													placeholder="Please enter location..." />
											</div>
										</div>
										<!-- form-group // -->

										<div class="form-group">
											<label for=requirements class="col-sm-3 control-label"
												style="font-weight: bold">Description</label>
											<div class="col-sm-9">
												<form:textarea path="description" cssClass="form-control"
													placeholder="Please enter description..." />
											</div>
										</div>
										<!-- form-group // -->

										<div class="form-group">
											<label for="requirements" class="col-sm-3 control-label"
												style="font-weight: bold">Requirements</label>
											<div class="col-sm-9">
												<form:input type="text" path="requirements"
													cssClass="form-control"
													placeholder="Please enter requirements..." />
											</div>
										</div>
										<!-- form-group // -->

										<div class="form-group">
											<label for="salary" class="col-sm-3 control-label"
												style="font-weight: bold">Salary</label>
											<div class="col-sm-9">
												<form:input type="number" path="salary"
													cssClass="form-control"
													placeholder="Please enter salary..." />
											</div>
										</div>
										<!-- form-group // -->

										<div class="form-group">
											<label for="category_id" class="col-sm-1 control-label"
												style="font-weight: bold">Category:</label> <select
												id="category_id" name="category_id" style="padding: 5px;">
												<c:forEach items="${categories}" var="category">
													<option value="${category.id}">${category.name}</option>
												</c:forEach>
											</select><br>
										</div>

										<div class="form-group">
											<label for="position" class="col-sm-1 control-label"
												style="font-weight: bold">Position</label> <select
												id="position" name="position" style="padding: 5px;">
											</select><br> <select hidden="true" id="positionVal">
												<c:forEach items="${positions}" var="position">
													<option value="${position.category_id}"
														class="${position.category_id}">${position.name}</option>
												</c:forEach>
											</select><br>
										</div>
										<!-- form-group // -->

										<hr>
										<div class="form-group">
											<div class="col-sm-offset-3 col-sm-9">
												<button type="submit" class="btn btn-primary">Create
													Job</button>
											</div>
										</div>
										<!-- form-group // -->
									</form:form>
								</div>
							</section>
						</div>
					</div>
				</div>
			</div>
		</div>
	</div>
	</main>
	<script>
		document.addEventListener("DOMContentLoaded", function() {
			// Lay ra the select voi id "category"
			var categorySelect = document.getElementById("category_id");

			// Lay ra the select voi id "position"
			var positionSelect = document.getElementById("position");

			// Lay ra the select voi id "positionVal"
			var positionValue = document.getElementById("positionVal");

			var selectedCategory = "1";

			// Khai bao mot mang de luu gia tri cua cac tuy chon
			var optionValues = [];

			// Lay tat ca tuy chon co class "position" trong the select
			var options = positionValue
					.getElementsByClassName(selectedCategory);

			// Lap qua tung tuy chon va lay gia tri cua no
			for (var i = 0; i < options.length; i++) {
				optionValues.push(options[i].text);
			}

			// Ham them cac tuy chon cho the option
			function updatePositionState() {
				// Xoa tat ca cac tuy chon hien tai trong "position"
				positionSelect.innerHTML = "";

				// Them cac tuy chon tuong ung voi "category" đa chon
				optionValues.forEach(function(position) {
					var option = document.createElement("option");
					option.text = position;
					option.value = position;
					positionSelect.appendChild(option);
				});
			}

			// Initial call to set the select tag state
			updatePositionState();

			// Ham thay doi gia tri position option tag khi category thay doi
			categorySelect.addEventListener("change", function() {
				selectedCategory = categorySelect.value;//gan lai gia tri category da chon

				// Lay tat ca tuy chon co class "position" trong the select
				options = positionValue
						.getElementsByClassName(selectedCategory);

				optionValues = [];//gan mang gia tri thanh rong
				// Lap qua tung tuy chon va lay gia tri cua no
				for (var i = 0; i < options.length; i++) {
					optionValues.push(options[i].text);
				}

				updatePositionState();
			});
		});
	</script>
</body>
</html>