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
				<div class="row">
					<div class="col-lg-12">
						<h1 class="page-header">
							Dashboard <small>Statistics Overview</small>
						</h1>
						<!--  <ol class="breadcrumb">
                            <li class="active">
                                <i class="fa fa-dashboard"></i> Dashboard
                            </li>
                        </ol> -->
					</div>
				</div>
				<%-- <a href="${pageContext.request.contextPath}/listUser" >List User</a> --%>
				<!-- /.row -->
				<div>
					<c:if test="${not empty users }">
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
							<tbody>
								<c:forEach items="${users}" var="user">
									<tr>
										<td>${user.usID}</td>
										<td>${user.usNm}</td>
										<td>${user.usSex}</td>
										<td>${user.usPhone}</td>
										<td>${user.usEmail}</td>
										<td>${user.usAddress}</td>
										<td><a href="${pageContext.request.contextPath}/deleteUser/${user.usID}">Delete</a></td>
									</tr>
								</c:forEach>
							</tbody>

						</table>
					</c:if>
					<h2>Add User</h2>
					<form:form action="addUser" method="post">
						NM :<input type="text" name="usNm" class="form-control">
						<br />
						Sex :<input type="text" name="usSex" class="form-control">
						<br />
						Phone :<input type="text" name="usPhone" class="form-control">
						<br />
						Email :<input type="text" name="usEmail" class="form-control">
						<br />
						Address :<input type="text" name="usAddress" class="form-control">
						<br />
						<input type="submit" value="add">
					</form:form>
					<br />
					<h2>Update User</h2>
					<form:form action="updateUser" method="post">
						NM :<input type="text" name="usNm" class="form-control">
						<br />
						Sex :<input type="text" name="usSex" class="form-control">
						<br />
						Phone :<input type="text" name="usPhone" class="form-control">
						<br />
						Email :<input type="text" name="usEmail" class="form-control">
						<br />
						Address :<input type="text" name="usAddress" class="form-control">
						<br />
						<input type="submit" value="add">
					</form:form>




				</div>


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
												<img src="img/cus_officer.png">
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
									</i>Customer Information
								</h3>
							</div>
							<div class="panel-body">
								<div class="panel panel-green">
									<div class="panel-heading">
										<div class="row">
											<div class="col-xs-3">
												<img src="img/cus_info.png">
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
												<img src="img/income_info.png">
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
												<img src="img/outcome_info.png">
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


</body>

</html>

