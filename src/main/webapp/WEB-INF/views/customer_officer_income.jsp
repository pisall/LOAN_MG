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
							New CO<small>(Cuctomer Officer Agreement)</small>
						</h2>

					</div>

				</div>


				<div class="row">
					<form class="form-horizontal" role="form">
						<div class="col-md-2 col-lg-2">
							<div>
								<span class="glyphicon glyphicon-user" style="font-size: 90px;"></span>
							</div>
							<span class="btn btn-default btn-file btn-sm"> Browse <input
								type="file">
							</span>
						</div>

						<div class="col-md-10 col-lg-10">

							<div class="form-group">
								<label class="control-label col-sm-2" for="fst_nm">First
									Name:</label>
								<div class="col-sm-10">
									<input type="email" class="form-control" id="fst_nm"
										placeholder="First Name">
								</div>
							</div>

							<div class="form-group">
								<label class="control-label col-sm-2" for="ls_nm">Last
									Name:</label>
								<div class="col-sm-10">
									<input type="email" class="form-control" id="ls_nm"
										placeholder="Last Name">
								</div>
							</div>

							<div class="form-group">
								<label class="control-label col-sm-2" for="ls_nm">Sex</label>
								<div class="col-sm-10">
									<label class="radio-inline"> <input type="radio"
										name="optradio">Male
									</label> <label class="radio-inline"> <input type="radio"
										name="optradio">Female
									</label>

								</div>
							</div>

							<div class="form-group">
								<label class="control-label col-sm-2" for="nt_card">National
									Card</label>
								<div class="col-sm-10">
									<input type="email" class="form-control" id="nt_card"
										placeholder="Enter National Card">
								</div>
							</div>

							<div class="form-group">
								<label class="control-label col-sm-2" for="ls_nm">Brand</label>
								<div class="col-sm-10">
									<select class="form-control" id="sel1">
										<option>Brand Co.ltd</option>
										<option>Brand Co.ltd</option>
										<option>Brand Co.ltd</option>
										<option>Brand Co.ltd</option>
									</select>

								</div>
							</div>

							<div class="form-group">
								<label class="control-label col-sm-2" for="ph_1">Phone 1</label>
								<div class="col-sm-10">
									<input type="email" class="form-control" id="Ph_1"
										placeholder="Enter Phone">
								</div>
							</div>

							<div class="form-group">
								<label class="control-label col-sm-2" for="ph_2">Phone 2</label>
								<div class="col-sm-10">
									<input type="email" class="form-control" id="ph_2"
										placeholder="Enter Second phone">
								</div>
							</div>

							<div class="form-group">
								<label class="control-label col-sm-2" for="email">Place
									of Birth:</label>
								<div class="col-sm-10">
									<textarea class="form-control" rows="5" id="comment"></textarea>
								</div>
							</div>
							<div class="form-group">
								<label class="control-label col-sm-2" for="email">Address:</label>
								<div class="col-sm-10">
									<textarea class="form-control" rows="5" id="comment"></textarea>
								</div>
							</div>
							<div class="pull-right">
								<button type="submit" class="btn btn-default">Register</button>
								<button type="button" class="btn btn-default">Cancel</button>
							</div>


						</div>
					</form>
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
