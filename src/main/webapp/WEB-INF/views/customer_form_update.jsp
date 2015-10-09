f<%@include file="include/_head.jsp"%>

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

					<div class="col-lg-12 col-md-12 col-sm-12">

						<h2 class="page-header">

							<span></span>Edit Customer 
							<!-- <button style="float: right;" type="button" class="btn btn-info" data-toggle="modal"
							data-target="#myModal">Add Customer</button> -->
						</h2>

					</div>
				</div>
				<!--//Page Heading -->

				<!-- Go Back -->
				<div class="row">
					<div class="col-md-12 col-lg-12">
						<button class="btn btn-primary" onclick="goBack()">
							<span style="width: 30px" class="glyphicon glyphicon-arrow-left"></span>
						</button>
					</div>
				</div>
				<!-- End Go Back  -->

				<br />

				<!-- Form Update-->
				<!-- Row -->
				<div class="row">
					<div class="col-md-6 col-lg-6">
						<!-- Panel  -->
						<div class="panel panel-default">
							<!-- Panel Head -->
							<div class="panel-heading">Customer Information</div>
							<!-- Panel Body -->
							<div class="panel-body">
								<c:if test="${not empty customer}">
									<c:set value="${customer}" var="cu" />
									<!-- Start From -->
									<form class="form-horizontal" role="form">
										<div>
											<div>
												<span class="glyphicon glyphicon-user"
													style="font-size: 90px;"></span>
											</div>
											<span class="btn btn-default btn-file btn-sm"> Browse
												<input type="file">
											</span>
										</div>
										<div class="form-group">
											<label class="control-label col-sm-2" for="cu_name">Name</label>
											<div class="col-sm-10">
												<input type="text" class="form-control" id="cu_name"
													placeholder="Enter Name" value="${cu.cuName}">
											</div>
										</div>

										<div class="form-group">
											<label class="control-label col-sm-2" for="cu_nick_name">Nickname</label>
											<div class="col-sm-10">
												<input type="text" class="form-control" id="cu_nick_name"
													placeholder="Enter Nickname" value="${cu.cuNickName}">
											</div>
										</div>

										<div class="form-group">
											<label class="control-label col-sm-2" for="cu_sex">Sex</label>
											<div class="col-sm-10">
												<select class="form-control" id="cu_sex">
													<c:if test="${cu.cuSex=='f'}">
														<option value="f">Female</option>
													</c:if>
													<option value="m">Male</option>
												</select>
											</div>
										</div>
										<div class="form-group">
											<label class="control-label col-sm-2" for="cu_dob">DOB</label>
											<div class="col-sm-10">
												<input type="text" class="form-control" id="cu_dob"
													placeholder="Enter Date Of Birth" value="${cu.cuDOB}">
											</div>
										</div>

										<div class="form-group">
											<label class="control-label col-sm-2" for="cu_id_card">ID
												Card</label>
											<div class="col-sm-10">
												<input type="text" class="form-control" id="cu_id_card"
													placeholder="Enter National Card"
													value="${cu.cuNationalID}">
											</div>
										</div>
										<div class="form-group">
											<label class="control-label col-sm-2" for="cu_phone">Phone</label>
											<div class="col-sm-10">
												<input type="text" class="form-control" id="cu_phone"
													placeholder="Enter Phone" value="${cu.cuPhone}">
											</div>
										</div>

										<div class="form-group">
											<label class="control-label col-sm-2" for="cu_address">Address</label>
											<div class="col-sm-10">
												<input type="text" class="form-control" id="cu_address"
													placeholder="Enter Address" value="${cu.cuAddress}">
											</div>
										</div>

										<div class="form-group">
											<label class="control-label col-sm-2" for="cu_pawn">Pawn</label>
											<div class="col-sm-10">
												<textarea class="form-control" rows="5" id="cu_pawn">${cu.cuPawn}</textarea>
											</div>
										</div>

										<div class="form-group">
											<label class="control-label col-sm-2" for="cu_note">Note</label>
											<div class="col-sm-10">
												<textarea class="form-control" rows="5" id="cu_note">${cu.cuNickName}</textarea>
											</div>
										</div>
									</form>
								</c:if>
								<!-- End Form -->
							</div>
							<!-- End Panel Body -->
						</div>
						<!-- Eng Panel -->
					</div>
					<!-- End col -->


					<!-- Start col -->
					<div class="col-md-6 col-lg-6">
						<!-- Panel  -->
						<div class="panel panel-default">
							<!-- Panel Head -->
							<div class="panel-heading">
								<span>Guarantor Information</span>
								<span>
									<c:if test="${not empty guarantor}">						
									<select id="foundGuarantorByID" class="form-control" style="width: 57%;float: right;margin-top: -7px">
										<option value="">-----Select Guarantor ID And Name-----</option>
										<c:forEach items="${guarantor}" var="gu" >										
											<option value="${gu.gu_id}">ID = ${gu.gu_id} , Name=${gu.gu_nm}</option>
										</c:forEach>
									</select>
								</c:if>
								</span>
							</div>

							<!-- Panel Body -->
							<div class="panel-body">
								<!-- Start Form -->
								<form class="form-horizontal" role="form">
									<div>
										<div>
											<span class="glyphicon glyphicon-user"
												style="font-size: 90px;"></span>
										</div>
										<span class="btn btn-default btn-file btn-sm"> Browse <input
											type="file">
										</span>
									</div>
									<div class="form-group">
										<label class="control-label col-sm-2" for="cu_name">Name</label>
										<div class="col-sm-10">
											<input type="text" class="form-control" id="gu_name"
												placeholder="Enter Name">
										</div>
									</div>

									<div class="form-group">
										<label class="control-label col-sm-2" for="cu_nick_name">Nickname</label>
										<div class="col-sm-10">
											<input type="text" class="form-control" id="gu_nick_name"
												placeholder="Enter Nickname">
										</div>
									</div>

									<div class="form-group">
										<label class="control-label col-sm-2" for="gu_sex">Sex</label>
										<div class="col-sm-10">
											<select class="form-control" id="cu_sex">
												<c:if test="${gu.gu_sex=='f'} }">
													<option value="f">Female</option>
												</c:if>											
												<option value="m">Male</option>
											</select>
										</div>
									</div>
									<div class="form-group">
										<label class="control-label col-sm-2" for="cu_dob">DOB</label>
										<div class="col-sm-10">
											<input type="text" class="form-control" id="gu_dob"
												placeholder="Enter Date Of Birth">
										</div>
									</div>

									<div class="form-group">
										<label class="control-label col-sm-2" for="cu_id_card">ID
											Card</label>
										<div class="col-sm-10">
											<input type="text" class="form-control" id="gu_national_id"
												placeholder="Enter National Card">
										</div>
									</div>
									<div class="form-group">
										<label class="control-label col-sm-2" for="cu_phone">Phone</label>
										<div class="col-sm-10">
											<input type="text" class="form-control" id="gu_phone"
												placeholder="Enter Phone">
										</div>
									</div>

									<div class="form-group">
										<label class="control-label col-sm-2" for="cu_address">Address</label>
										<div class="col-sm-10">
											<input type="text" class="form-control" id="gu_address"
												placeholder="Enter Address">
										</div>
									</div>

									<div class="form-group">
										<label class="control-label col-sm-2" for="cu_pawn">Pawn</label>
										<div class="col-sm-10">
											<textarea class="form-control" rows="5" id="gu_pawn"></textarea>
										</div>
									</div>

									<div class="form-group">
										<label class="control-label col-sm-2" for="cu_note">Note</label>
										<div class="col-sm-10">
											<textarea class="form-control" rows="5" id="gu_note"></textarea>
										</div>
									</div>

								</form>
								<!-- End Form -->
							</div>
							<!-- End Panel Body -->
						</div>
						<!-- Eng Panel -->
					</div>
					<!-- End col -->

				</div>
				<!-- End Row -->
				<div style="text-align: center;">
					<button type="submit" class="btn btn-primary">Update</button>
					<button type="button" class="btn btn-danger">Cancel</button>
				</div>
				<!-- End Form -->
				<br />
			</div>
			<!-- /.container-fluid -->

		</div>
		<!-- /#page-wrapper -->
	</div>
	<!-- /#wrapper -->

	<%@include file="include/_script.jsp"%>
	
	<script type="text/javascript">
		var BASE_URL = "${pageContext.request.contextPath}";
	</script>
	
	
	<script type="text/javascript">
		$(function(){
			$("#foundGuarantorByID").change(function(){
					var guID=$(this).val();
					
					var input={
						"customerDto":{
							"cuID":52,
						},
						"gu_id":guID
					} 
					
					if(guID!=""){
						$.ajax({
							url : BASE_URL + "/guarantor/listGuarantorByID",
							type : 'POST',
							dataType : 'JSON',
							data : JSON.stringify(input),
							beforeSend : function(xhr) {
								xhr.setRequestHeader("Accept", "application/json");
								xhr.setRequestHeader("Content-Type", "application/json");
							},
							success : function(data) {
								if(data.length==1){
									$(data).each(function(i,v){
										$("#gu_name").val(v.gu_nm);
										$("#gu_nick_name").val(v.gu_nick_nm);
										$("#gu_sex").val(v.gu_sex);
										$("#gu_dob").val(v.gu_dob);
										$("#gu_national_id").val(v.gu_national_id);
										$("#gu_phone").val(v.gu_phone);
										$("#gu_address").val(v.gu_address);
										$("#gu_pawn").val(v.gu_pawn);
										$("#gu_note").val(v.gu_note);
									});
								}
							},
							error : function(data, status, er) {
								console.log("error: " + data + " status: " + status + " er:" + er);
							}
						});					
					}else{
						$("#gu_name").val("");
						$("#gu_nick_name").val("");
						$("#gu_sex").val("");
						$("#gu_dob").val("");
						$("#gu_national_id").val("");
						$("#gu_phone").val("");
						$("#gu_address").val("");
						$("#gu_pawn").val("");
						$("#gu_note").val("");
					}		
			});
			
		});
		/**
		 * Go Back
		 */
		function goBack() {
			window.history.back();
		}
	</script>
	
</body>

</html>