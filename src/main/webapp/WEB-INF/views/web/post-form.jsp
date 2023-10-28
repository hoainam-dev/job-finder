<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="/common/taglib.jsp"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Create Post</title>
</head>
<body>
		<!-- Hero Area Start-->
	        <div class="row slider-area" style="background:#F2185D; padding:30px">
				<div class="col-xl-1">
				 	<a href="/trang-chu"><i class="fa fa-home" aria-hidden="true" style="font-size:30px; color:white"></i></a>
				</div>
		         <div class="col-xl-10">
		             <div class="hero-cap text-center">
		                 <h2>CREATE POST</h2>
		             </div>
	         	</div>
	       </div>
	    <!-- Hero Area End -->
        
		<div class="container" style="margin-top:20px">  
		  <section class="panel panel-default">
			<div class="panel-body">
			  
			<form:form action="/viec-lam/tao-viec-lam" class="form-horizontal" modelAttribute="jobs" role="form" enctype="multipart/form-data">
		
			
				   <div class="form-group">
					    <label for="name" class="col-sm-3 control-label" style="font-weight: bold">Title</label>
					    <div class="col-sm-9">
					      <form:input type="text" path="title" class="form-control" name="name" id="name" placeholder="Please enter title..."/>
					    </div>
				   </div> <!-- form-group // -->
				   
				  <div class="form-group">
				    <label for="name" class="col-sm-3 control-label" style="font-weight: bold">Location</label>
				    <div class="col-sm-9">
				      <form:input type="text" path="location" class="form-control" name="name" id="name" placeholder="Please enter location..."/>
			      	</div>
				  </div> <!-- form-group // -->
				  
				   <div class="form-group">
					    <label for="about" class="col-sm-3 control-label" style="font-weight: bold">Description</label>
					    <div class="col-sm-9">
					      <form:textarea path="description" class="form-control" placeholder="Please enter description..."/></textarea>
					    </div>
				  </div> <!-- form-group // -->
		
				   <div class="form-group">
					    <label for="name" class="col-sm-3 control-label" style="font-weight: bold">Requirements</label>
					    <div class="col-sm-9">
					      <form:input type="text" path="requirements" class="form-control" name="name" id="name" placeholder="Please enter requirements..."/>
					    </div>
				   </div> <!-- form-group // -->
				   
				   <div class="form-group">
					    <label for="name" class="col-sm-3 control-label" style="font-weight: bold">Salary</label>
					    <div class="col-sm-9">
					      <form:input type="number" path="salary" class="form-control" name="name" id="name" placeholder="Please enter salary..."/>
					    </div>
				   </div> <!-- form-group // -->	
				   
				   <div class="form-group">
				   		<label for="categoryId" class="col-sm-1 control-label" style="font-weight: bold" >Category:</label>
				        <select id="categoryId" name="categoryId" style="padding:5px;">
				            <c:forEach items="${categories}" var="category">
				                <option value="${category.id}">${category.name}</option>
				            </c:forEach>
				        </select><br>
				    </div>
				  
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