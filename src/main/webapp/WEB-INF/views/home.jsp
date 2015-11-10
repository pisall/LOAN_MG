<%@include file="include/_head.jsp"%>

<body>
	<div id="wrapper">

		<!-- Navigation -->
		<nav class="navbar navbar-inverse navbar-fixed-top" role="navigation">

			<!-- Fixed Up Navigation -->
			<%@include file="include/_fixed_up_nav.jsp"%>

			<!-- Side Bar Navigation -->
			<div class="collapse navbar-collapse navbar-ex1-collapse">
				<%@include file="include/_side_nav.jsp"%>
			</div>

		</nav>
		<!-- End Navigation -->

		<div id="page-wrapper">

			<div class="container-fluid">

				<!-- Page Heading -->
			<!-- 	<div class="row">
					<div class="col-lg-12">
						<h1 class="page-header">
							Dashboard <small>Statistics Overview</small>
						</h1>
						
					</div>
				</div>
				
				<div>

					<h2>Users</h2>
					<table class="table table-default">
						<thead>
							<tr>
								<th>ID</th>
								<th>Name</th>
								<th>Sex</th>
								<th>Phone</th>
								<th>Email</th>
								<th>Address</th>
								<th>Status</th>
							</tr>
						</thead>
						<tbody id="tableUser">

						</tbody>

					</table>

					<div id="success"></div>
					<h2>Add User</h2>

					NM :<input type="text" name="usNm" id="usNm" class="form-control">
					<br /> Sex :<input type="text" name="usSex" id="usSex"
						class="form-control"> <br /> Phone :<input type="text"
						name="usPhone" id="usPhone" class="form-control"> <br />
					Email :<input type="text" name="usEmail" id="usEmail"
						class="form-control"> <br /> Address :<input type="text"
						name="usAddress" id="usAddress" class="form-control"> <br />
					<input type="submit" value="add" id="addUser"> <br />
				</div> -->


				<div class="row">
					<div class="col-lg-6">
						<div class="panel panel-default">
							<div class="panel-heading">
								<h3 class="panel-title">
									<!-- <i class="fa fa-money fa-fw"></i>  -->
									Customer Officer Information
								</h3>
							</div>
							<div class="panel-body">
								<div class="panel panel-primary">
									<div class="panel-heading">
										<div class="row">
											<div class="col-xs-3">
												<img src="${pageContext.request.contextPath}/resources/img/Co_Info.png" height="150" width="250">
												<!--  <i class="fa fa-shopping-cart fa-5x"></i> -->
											</div>
											<div class="col-xs-9 text-right">
												<div class="huge">124</div>
												<div>New Orders!</div>
											</div>
										</div>
									</div>
									<!--  <a href="#">
                                <div class="panel-footer">
                                    <span class="pull-left">View Details</span>
                                    <span class="pull-right"><i class="fa fa-arrow-circle-right"></i></span>
                                    <div class="clearfix"></div>
                                </div>
                            </a> -->
								</div>
							</div>
						</div>
					</div>
					<div class="col-lg-6">
						<div class="panel panel-default">
							<div class="panel-heading">
								<h3 class="panel-title">
									<!-- <i class="fa fa-money fa-fw"> -->
									</i>Customer Information <%=session.getAttribute("username")/* session.getAttribute("username") */%>
								</h3>
							</div>
							<div class="panel-body">
								<div class="panel panel-green">
									<div class="panel-heading">
										<div class="row">
											<div class="col-xs-3">
												<img src="${pageContext.request.contextPath}/resources/img/Customers.png" height="150" width="250">
											</div>
											<div class="col-xs-9 text-right">
												<div class="huge">124</div>
												<div>New Orders!</div>
											</div>
										</div>
									</div>
									<!--  <a href="#">
                                <div class="panel-footer">
                                    <span class="pull-left">View Details</span>
                                    <span class="pull-right"><i class="fa fa-arrow-circle-right"></i></span>
                                    <div class="clearfix"></div>
                                </div>
                            </a> -->
								</div>
							</div>
						</div>
					</div>
					<div class="col-lg-6">
						<div class="panel panel-default">
							<div class="panel-heading">
								<h3 class="panel-title">
									<!-- <i class="fa fa-money fa-fw"> -->
									</i>Income Information
								</h3>
							</div>
							<div class="panel-body">
								<div class="panel panel-yellow">
									<div class="panel-heading">
										<div class="row">
											<div class="col-xs-3">
												<img src="${pageContext.request.contextPath}/resources/img/Income.png" height="150" width="250">
											</div>
											<div class="col-xs-9 text-right">
												<div class="huge">124</div>
												<div>New Orders!</div>
											</div>
										</div>
									</div>
									<!--  <a href="#">
                                <div class="panel-footer">
                                    <span class="pull-left">View Details</span>
                                    <span class="pull-right"><i class="fa fa-arrow-circle-right"></i></span>
                                    <div class="clearfix"></div>
                                </div>
                            </a> -->
								</div>
							</div>
						</div>
					</div>
					<div class="col-lg-6">
						<div class="panel panel-default">
							<div class="panel-heading">
								<h3 class="panel-title">
									<!-- <i class="fa fa-money fa-fw"></i> -->
									Outcome Information
								</h3>
							</div>
							<div class="panel-body">
								<div class="panel panel-red">
									<div class="panel-heading">
										<div class="row">
											<div class="col-xs-3">
												<img src="${pageContext.request.contextPath}/resources/img/Outcome1.png" height="150" width="250">
											</div>
											<div class="col-xs-9 text-right">
												<div class="huge">124</div>
												<div>New Orders!</div>
											</div>
										</div>
									</div>
									<!--   <a href="#">
                                <div class="panel-footer">
                                    <span class="pull-left">View Details</span>
                                    <span class="pull-right"><i class="fa fa-arrow-circle-right"></i></span>
                                    <div class="clearfix"></div>
                                </div>
                            </a> -->
								</div>
							</div>
						</div>
					</div>


				</div>
				<!-- /.row -->

			</div>
			<!-- /.container-fluid -->

		</div>
		<!-- /#page-wrapper -->

	</div>
	<!-- /#wrapper -->

	<%@include file="include/_script.jsp"%>
	<script type="text/javascript">
	var userId = "${pageContext.request.userPrincipal.principal.username}";
	console.log("user id="+userId);
	</script>

	<script type="text/javascript">
		$(function() {
			
			listUser();
		
		
		
$("#addUser")
.click(
		function() {

			json = {

				"usNm" : $("#usNm").val(),
				"usSex" : $("#usSex").val(),
				"usPhone" : $("#usPhone").val(),
				"usEmail" : $("#usEmail").val(),
				"usAddress" : $("#usAddress").val()

			};
			
			$
					.ajax({
						url : "${pageContext.request.contextPath}/addUser",
						type : 'POST',
						dataType : 'JSON',
						data : JSON.stringify(json),
						beforeSend : function(xhr) {
							xhr.setRequestHeader("Accept",
									"application/json");
							xhr.setRequestHeader(
									"Content-Type",
									"application/json");
						},
						success : function(data) {

							if (data == true) {
								$("#success")
										.html(
												"<div class='alert alert-success' role='alert'>Successfully Added</div>");
								$("#success").fadeIn(1500)
										.fadeOut(3000);
								
								listUser();
							}

						},
						error : function(data, status, er) {
							console.log("error: " + data
									+ " status: " + status
									+ " er:" + er);
						}
					});
		});

});
		
		function listUser(){
			
			$.ajax({
				
				url : "${pageContext.request.contextPath}/listUser",
				type : 'GET',
				dataType : 'JSON',
				//data : JSON.stringify(json),
				beforeSend : function(xhr) {
					xhr.setRequestHeader("Accept", "application/json");
					xhr.setRequestHeader("Content-Type", "application/json");
				},
				success : function(data) {
					console.log(data);
					var results;
					$(data).each(function(i,v){
						results+="<tr>"
									+"<td >"+v.usID+"</td>"
									+"<td >"+v.usNm+"</td>"
									+"<td >"+v.usSex+"</td>"
									+"<td >"+v.usPhone+"</td>"
									+"<td >"+v.usEmail+"</td>"
									+"<td >"+v.usAddress+"</td>"
									+"<td><button onclick='return deleteUser("+v.usID+");'>Delete</button><button onclick='return updateUser();''>Edit</button></td>"
									+"</tr>"
					});
					
					$("#tableUser").html(results);

				},
				error : function(data, status, er) {
					console.log("error: " + data + " status: " + status+ " er:" + er);
				}
			});
		}
		

		function deleteUser(userID) {
		
			json = {

				"usID" : userID

			};
			
			$.ajax({
				url : "${pageContext.request.contextPath}/deleteUser",
				type : 'POST',
				dataType : 'JSON',
				data : JSON.stringify(json),
				beforeSend : function(xhr) {
					xhr.setRequestHeader("Accept", "application/json");
					xhr.setRequestHeader("Content-Type", "application/json");
				},
				success : function(data) {

					listUser();

				},
				error : function(data, status, er) {
					console.log("error: " + data + " status: " + status+ " er:" + er);
				}
			});

		}
		
		function updateUser(){
			
			
			json = {

					"usID" : $("#usID").html(),
					"usNm" : $("#usNm").html(),
					"usSex" : $("#usSex").html(),
					"usPhone" : $("#usPhone").html(),
					"usEmail" : $("#usEmail").html(),
					"usAddress" : $("#usAddress").html()

				};
			
			console.log(json);
			
			$.ajax({
				url : "${pageContext.request.contextPath}/updateUser",
				type : 'POST',
				dataType : 'JSON',
				data : JSON.stringify(json),
				beforeSend : function(xhr) {
					xhr.setRequestHeader("Accept", "application/json");
					xhr.setRequestHeader("Content-Type", "application/json");
				},
				success : function(data) {					
					
					

				},
				error : function(data, status, er) {
					console.log("error: " + data + " status: " + status+ " er:" + er);
				}
			});
		}
		
		
	</script>



</body>

</html>

