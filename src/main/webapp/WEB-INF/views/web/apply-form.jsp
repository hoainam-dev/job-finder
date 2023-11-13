<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="UTF-8">
<meta name="viewport"
	content="width=device-width, initial-scale=1, shrink-to-fit=no">
<title>Apply for Job</title>
<!-- Bootstrap CSS -->
<link rel="stylesheet"
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css">
<!-- Custom CSS -->
<link rel="stylesheet" href="path/to/your/custom.css">
</head>
<body class="bg-light">

	<div class="container mt-5">
		<div class="card">
			<div class="card-header">
				<h3 class="text-center">Apply for ${job.title}</h3>
			</div>
			<div class="card-body">
				<!-- Your form goes here -->
				<form id="applyForm"
					action="/viec-lam/nop-ho-so-ung-tuyen/${job.id}" method="POST">
					
					<!-- Import thông tin -->
					<!--  
					<div class="form-group">
						<label for="fullName">Full Name</label> <input type="text"
							class="form-control" id="fullName" name="fullName" required>
					</div>
					<div class="form-group">
						<label for="email">Email</label> <input type="email"
							class="form-control" id="email" name="email" required>
					</div>
					<div class="form-group">
						<label for="resume">Resume (PDF only)</label> <input type="file"
							class="form-control-file" id="resume" name="resume" accept=".pdf"
							required>
					</div>
					-->
					<!-- Import thông tin -->
					<a href="/viec-lam/chi-tiet-viec-lam/${job.id}">
						<button type="button" class="btn btn-secondary mr-2">Hủy</button>
					</a>
					<button type="submit" class="btn btn-primary">Nộp hồ sơ ứng tuyển</button>

				</form>
			</div>
			<div class="card-footer text-muted">Your company name &copy;
				2023</div>
		</div>
	</div>

	<!-- Bootstrap JS and dependencies -->
	<script src="https://code.jquery.com/jquery-3.3.1.slim.min.js"></script>
	<script
		src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.7/umd/popper.min.js"></script>
	<script
		src="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js"></script>

</body>
</html>
