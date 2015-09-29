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

						<h2 class="page-header">
							CO <small>Customer Officer Infomation</small>
						</h2>

					</div>

				</div>
				<!--//Page Heading -->
				<!-- list-->
				<div class="row">
					<div class="col-lg-12">
						<!-- panel top-->
						<div class="panel panel-default">
							<div class="panel panel-heading">
								<div class="row">
									<div class="col-md-6 pull-right">

										<div class="form-group input-group">
											<input class="form-control" type="text"
												placeholder="Enter CO ID or Name"> <span
												class="input-group-btn"><button
													class="btn btn-default" type="button">
													<i class="fa fa-search"></i>
												</button></span>
										</div>

									</div>
								</div>

							</div>
							<!-- panel body -->
							<div class="panel panel-body">
								<div class="table-responsive">
								<c:if test="${not empty listCo}">
									<table class="table table-hover table-striped">
										<thead>
											<tr>
												<th>ID</th>
												<th>Name</th>
												<th>Sex</th>
												<th>Brand</th>
												<th>Tell</th>
												<th>Action</th>
											</tr>
										</thead>
										<tbody>
											<c:forEach items="${listCo}" var="co">
												<tr>
													<td>${co.coId} <c:if test="${not empty paging}"><span>page=${paging.pageNo}</span></c:if></td>
													<td>${co.coFirstNm} ${co.coLastNm} </td>
													<td>
														<c:if test="${co.coSex == \"M\"}">Male</c:if>
														<c:if test="${co.coSex == \"F\"}">Female</c:if>
													
													</td>
													<td>${co.coBrand}</td>
													<td>${co.coPhone}</td>
													<td><a href="#none"><span
															class="glyphicon glyphicon-pencil"></span></a> &nbsp; <a
														href="#none"><span class="glyphicon glyphicon-trash"></span></a>
													</td>
												</tr>	
												
											</c:forEach>
										
											<!-- <tr>
												<td>2464</td>
												<td>Prak virak</td>
												<td>Male</td>
												<td>Phnom Penh</td>
												<td>010 988-752</td>
												<td><a href="#none"><span
														class="glyphicon glyphicon-pencil"></span></a> &nbsp; <a
													href="#none"><span class="glyphicon glyphicon-trash"></span></a>
												</td> glyphicon glyphicon-pencil
											</tr>
											<tr>
												<td>2464</td>
												<td>Prak virak</td>
												<td>Male</td>
												<td>Phnom Penh</td>
												<td>010 988-752</td>
												<td><a href="#none"><span
														class="glyphicon glyphicon-pencil"></span></a> &nbsp; <a
													href="#none"><span class="glyphicon glyphicon-trash"></span></a>
												</td>
											</tr>
											<tr>
												<td>2464</td>
												<td>Prak virak</td>
												<td>Male</td>
												<td>Phnom Penh</td>
												<td>010 988-752</td>
												<td><a href="#none"><span
														class="glyphicon glyphicon-pencil"></span></a> &nbsp; <a
													href="#none"><span class="glyphicon glyphicon-trash"></span></a>
												</td>
											</tr>
											<tr>
												<td>2464</td>
												<td>Prak virak</td>
												<td>Male</td>
												<td>Phnom Penh</td>
												<td>010 988-752</td>
												<td><a href="#none"><span
														class="glyphicon glyphicon-pencil"></span></a> &nbsp; <a
													href="#none"><span class="glyphicon glyphicon-trash"></span></a>
												</td>
											</tr> -->

										</tbody>
									</table>
								</c:if>
								</div>

							</div>
							<!-- //panel body -->

						</div>
						<div class="row">
						<form rol="form" method="get">
							
						</form>
							<div class="col-md-6 col-md-offset-3" style="text-align: center">
								<c:if test="${not empty paging}">
								<ul class="pagination">
									
									<li class="next">
										<a href="											
											<c:if test="${paging.pageNo==1}">${pageContext.request.contextPath}/cocontroller/listCo?page_no=1&pcnt=${paging.pcnt}</c:if>
											<c:if test="${paging.pageNo!=1}">${pageContext.request.contextPath}/cocontroller/listCo?page_no=${paging.pageNo-1}&pcnt=${paging.pcnt}</c:if>											
										"><span
											class="glyphicon glyphicon-chevron-left"></span></a></li>
									<c:forEach var="i" begin="1" end="${paging.totalPage}">
									<c:if test="${paging.pageNo == i}">
										<li class="active" ><a href="${pageContext.request.contextPath}/cocontroller/listCo?page_no=${i}&pcnt=3">${i}</a></li>
										
									</c:if>
									<c:if test="${paging.pageNo != i}">
										<li><a href="${pageContext.request.contextPath}/cocontroller/listCo?page_no=${i}&pcnt=3">${i}</a></li>
									</c:if>
									
									</c:forEach>

									<li class="next">
										<a href="
											<c:if test="${paging.pageNo==paging.totalPage}">${pageContext.request.contextPath}/cocontroller/listCo?page_no=${paging.pageNo}&pcnt=${paging.pcnt}</c:if>
											<c:if test="${paging.pageNo!=paging.totalPage}">${pageContext.request.contextPath}/cocontroller/listCo?page_no=${paging.pageNo+1}&pcnt=${paging.pcnt}</c:if>
											"
										><span class="glyphicon glyphicon-chevron-right"></span></a></li>
								</ul>
								</c:if>
							</div>
						</div>
						<!--//panel top -->

					</div>

				</div>
				<!-- //list -->


			</div>
			<!-- /.container-fluid -->

		</div>
		<!-- /#page-wrapper -->

	</div>
	<!-- /#wrapper -->

	<!-- jQuery -->
	<script src="js/jquery.js"></script>

	<!-- Bootstrap Core JavaScript -->
	<script src="js/bootstrap.min.js"></script>



</body>

</html>
