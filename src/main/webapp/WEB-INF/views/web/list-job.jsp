<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Danh sách công việc</title>
</head>
<body>
	<h1>Danh sách công việc cho loại danh mục</h1>
	<table>
		<tr>
			<th>ID</th>
			<th>Tiêu đề</th>
			<th>Mô tả</th>
		</tr>
		<c:forEach var="jobs" items="${jobs}">
			<tr>
				<td>${jobs.id}</td>
				<td>${jobs.title}</td>
				<td>${jobs.description}</td>
				<td>${jobs.salary}</td>
				<td>${jobs.location}</td>
			</tr>
		</c:forEach>
	</table>
</body>
</html>