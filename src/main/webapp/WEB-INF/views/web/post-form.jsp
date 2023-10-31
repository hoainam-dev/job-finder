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
			  
			<form:form action="/viec-lam/tao-viec-lam" class="form-horizontal" modelAttribute="job" role="form" method="POST">
				   <div id="errors" style="display: none;"></div>
			
				   <div class="form-group">
					    <label for="name" class="col-sm-3 control-label" style="font-weight: bold">Title</label>
					    <div class="col-sm-9">
					      <form:input type="text" path="title" class="form-control" name="name" id="name" placeholder="Please enter title..." required="required"/>
					    </div>
				   </div> <!-- form-group // -->
				   
				   <div class="form-group">
					    <label for="name" class="col-sm-3 control-label" style="font-weight: bold">Position</label>
					    <div class="col-sm-9">
					      <form:input type="text" path="position" class="form-control" name="name" id="name" placeholder="Please enter position..." required="required"/>
					    </div>
				   </div> <!-- form-group // -->
				   
				  <div class="form-group">
				    <label for="name" class="col-sm-3 control-label" style="font-weight: bold">Location</label>
				    <div class="col-sm-9">
				      <form:input type="text" path="location" class="form-control" name="name" id="name" placeholder="Please enter location..." required="required"/>
			      	</div>
				  </div> <!-- form-group // -->
				  
				   <div class="form-group">
					    <label for="about" class="col-sm-3 control-label" style="font-weight: bold">Description</label>
					    <div class="col-sm-9">
					      <form:textarea path="description" class="form-control" placeholder="Please enter description..." required="required"/></textarea>
					    </div>
				  </div> <!-- form-group // -->
		
				   <div class="form-group">
					    <label for="name" class="col-sm-3 control-label" style="font-weight: bold">Requirements</label>
					    <div class="col-sm-9">
					      <form:input type="text" path="requirements" class="form-control" name="name" id="name" placeholder="Please enter requirements..." required="required"/>
					    </div>
				   </div> <!-- form-group // -->
				   
				   <div class="form-group">
					    <label for="name" class="col-sm-3 control-label" style="font-weight: bold">Salary</label>
					    <div class="col-sm-9">
					      <form:input type="number" path="salary" class="form-control" name="name" id="name" placeholder="Please enter salary..." required="required"/>
					    </div>
				   </div> <!-- form-group // -->	
				   
				   <div class = "row">
				   		<div class="col-sm-6">
				   			<div class="form-group">
						   		<label>Category:</label>
					            <form:select path="category_id">
					                <form:option value="" label="Select a category" />
					                <form:options items="${categories}" itemValue="id" itemLabel="name" required="required"/>
					            </form:select>
						    </div>
				   		</div>
				   		<div class="col-sm-6">
				   			<label>Type</label>
			   				<form:select id="type" name="type" path="type">
			   					<form:option value="FullTime" label="Full Time" required="required"/>
			   					<form:option value="PartTime" label="Part Time" required="required"/>
			   					<form:option value="Remote" label="Remote" required="required"/>
			   					<form:option value="Freelance" label="Freelance" required="required"/>
			   				</form:select>
				   		</div>
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