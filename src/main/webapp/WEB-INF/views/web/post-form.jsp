<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ include file="/common/taglib.jsp"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Create Post</title>
</head>
<body>
<div class="container">
  
  <section class="panel panel-default">
	<div class="panel-heading"> 
	<h3 class="panel-title">Create Post</h3> 
	</div> 
	<div class="panel-body">
	  
	<form:form action="createPost" class="form-horizontal" modelAttribute="jobs" role="form">

	
		   <div class="form-group">
			    <label for="name" class="col-sm-3 control-label">Title</label>
			    <div class="col-sm-9">
			      <form:input type="text" path="title" class="form-control" name="name" id="name" placeholder="Please enter title..."/>
			    </div>
		   </div> <!-- form-group // -->
		   
		  <div class="form-group">
		    <label for="name" class="col-sm-3 control-label">Location</label>
		    <div class="col-sm-9">
		      <form:input type="text" path="location" class="form-control" name="name" id="name" placeholder="Please enter location..."/>
	      	</div>
		  </div> <!-- form-group // -->
		  
		   <div class="form-group">
			    <label for="about" class="col-sm-3 control-label">Description</label>
			    <div class="col-sm-9">
			      <form:textarea path="description" class="form-control"/></textarea>
			    </div>
		  </div> <!-- form-group // -->

		   <div class="form-group">
			    <label for="name" class="col-sm-3 control-label">Requirements</label>
			    <div class="col-sm-9">
			      <form:input type="text" path="requirements" class="form-control" name="name" id="name" placeholder="Please enter requirements..."/>
			    </div>
		   </div> <!-- form-group // -->
		   
		   <div class="form-group">
			    <label for="name" class="col-sm-3 control-label">Salary</label>
			    <div class="col-sm-9">
			      <form:input type="number" path="salary" class="form-control" name="name" id="name" placeholder="Please enter salary..."/>
			    </div>
		   </div> <!-- form-group // -->	 
			  
		  <div class="form-group">
			    <label for="name" class="col-sm-3 control-label">Upload Image</label>
			    <div class="col-sm-3">
			      <label class="control-label small" path="image" for="file_img">Type Image	 (jpg/png):</label> <input type="file" name="file_img">
			    </div>
		  </div> <!-- form-group // -->
		  
	  <hr>
	  <div class="form-group">
	    <div class="col-sm-offset-3 col-sm-9">
	      <button type="submit" class="btn btn-primary">Create Post	</button>
	    </div>
	  </div> <!-- form-group // -->
</form:form>
  
</div><!-- panel-body // -->
</section><!-- panel// -->

  
</div> <!-- container// -->
</body>
</html>