



<%@include file="include/_head.jsp"%>

<body style="background-color:#fff;">

            <div class="container-fluid">
				<div class="col-lg-8 col-lg-offset-2 col-md-10 col-md-offset-2">
				
					<div class="row">
					
						<div class="col-lg-12">
						
							<h2 class="page-header" style="text-align:center">
								Customer Officer Information(CO)
							</h2>
							
						</div>
						
					</div>
				
					<div class="row">	
						<div class="col-lg-12 col-md-12 col-sm-12 col-xs-12">
							<div class="col-xs-12 col-lg-3 col-md-3 col-sm-3  pull-right">
							
									<img src="img/default_profile.jpg" class="img-responsive"/>
								
							</div>
						</div>
						
						<div class="col-lg-12 col-md-12 col-xs-12 col-sm-12">
							<div class="panel panel-default">
								<div class="panel panel-body">
									<table class="table">
										<tbody>
											<tr>
												<td>ID</td>
												<td><span id="co_id">1</span></td>
											</tr>
											<tr>
												<td>Name</td>
												<td><span id="co_nm">Prak Virak</span></td>
											</tr>
											<tr>
												<td>Gender</td>
												<td><span id="sex">Male</span></td>
											</tr>
											<tr>
												<td>National ID</td>
												<td><span id="co_national_id">82748472382</span></td>
											</tr>
											
											<tr>
												<td>Brand</td>
												<td><span id="brand">Phone Penh</span></td>
											</tr>
											
											<tr>
												<td>Phone</td>
												<td><span id="co_phone">010-0873-047</span></td>
											</tr>
											
											<tr>
												<td>Office Phone</td>
												<td><span id="office_phone">010-0873-047</span></td>
											</tr>
											
											<tr>
												<td>Office Phone</td>
												<td><span id="office_phone">010-0873-047</span></td>
											</tr>
											
											
										</tbody>
									</table>
									 <button type="button" class="btn btn-info btn-lg" data-toggle="modal" data-target="#myModal">Open Modal</button>
								</div>
							</div>
							
						</div>
						
					</div>
				
				</div>
				

            </div>
            <!-- /.container-fluid -->

			<!-- Include Script -->
			<jsp:include page="include/_script.jsp" />
</body>

</html>
