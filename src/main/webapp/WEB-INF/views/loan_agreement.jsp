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

						<h2 class="page-header">Loan Agreement</h2>

					</div>

				</div>


				<div class="row" style="font-size: 12px;">

					<!-- Form User Information -->
				<form class="form-horizontal" id="loanAgreement" action="newLoanAgreementGetData" method ="POST" role="form">

					<div class="col-md-6 col-lg-6">
						<div class="panel panel-default">
							<div class="panel-heading" style="font-size: 14px;">User
								Information</div>
							<div class="panel-body">

									<div>
										<span class="glyphicon glyphicon-user"
											style="font-size: 90px;"></span>
									</div>
									<span class="btn btn-default btn-file btn-sm"> Browse 
									<input type="file" id="cu_photo" name="cu_photo">
										
									</span>

									<div class="form-group">
										<label class="control-label col-sm-2" for="fst_nm">
											Name:</label>
										<div class="col-sm-10">
											<input type="text"  class="form-control required" name="cu_nm" id="cu_nm"
												placeholder="Full Name" maxlength="50">
										</div>
									</div>

									<div class="form-group">
										<label class="control-label col-sm-2" for="ls_nm">
											Nick name:</label>
										<div class="col-sm-10">
											<input type="text" maxlength="50" class="form-control required" name="cu_nick_nm" id="nick_name"
												placeholder="Nick Name">
										</div>
									</div>

									<div class="form-group">
										<label class="control-label col-sm-2" for="ls_nm">Sex</label>
										<div class="col-sm-10" name="cu_sex" id="cu_sex">
											<label class="radio-inline"> 
												<input type="radio" value="Male" name="cu_sex" checked="checked">Male
											</label>
											 <label class="radio-inline"> 
												<input type="radio" value="Female" name="cu_sex">Female
											</label> 
										</div>
									</div>

									<div class="form-group">
										<label class="control-label col-sm-2" for="nt_card">
											DOB</label>
										<div class="col-sm-10">
											<input type="text" maxlength="10" class="form-control required" name="cu_dob" id="cu_dob"
												placeholder="use date of birth">
										</div>
									</div>
									<div class="form-group">
										<label class="control-label col-sm-2" for="nt_card">
											ID Card</label>
										<div class="col-sm-10">
											<input type="text" maxlength="11"  class="form-control required check_number" name="cu_national_id" id="cu_id_card"
												placeholder="Enter National Card">
										</div>
									</div>
									<div class="form-group">
										<label class="control-label col-sm-2" for="nt_card">
											Phone</label>
										<div class="col-sm-10">
											<input type="text" maxlength="11"  class="form-control required check_number" name="cu_phone" id="cu_phone"
												placeholder="User Phone number">
										</div>
									</div>

									<div class="form-group">
										<label class="control-label col-sm-2" for="text">
											Address</label>
										<div class="col-sm-10">
											<textarea class="form-control required" maxlength="100" rows="3" name="cu_address" id="cu_address" placeholder="User Address"></textarea>
										</div>
									</div>

									<div class="form-group">
										<label class="control-label col-sm-2" for="text">
											Pawn</label>
										<div class="col-sm-10">
											<textarea class="form-control " maxlength="100" rows="3" name="cu_pawn" id="user_pawn" placeholder="User Pawn"></textarea>
										</div>
									</div>
									
									<hr/>
									
									<div class="form-group">
										<label class="control-label col-sm-2" for="text">
											Guarantor</label>
										<div class="col-sm-10">
											<input type="text" maxlength="50" class="form-control required" name="gu_nm" id="gu_name"
												placeholder="Guarantor name">
										</div>
									</div> 
									
									<div class="form-group">
										<label class="control-label col-sm-2" for="ls_nm">Sex</label>
										<div class="col-sm-10" name="cu_sex" id="cu_sex">
											<label class="radio-inline"> 
												<input type="radio" value="Male" name="gu_sex" checked="checked">Male
											</label>
											 <label class="radio-inline"> 
												<input type="radio" value="Female" name="gu_sex">Female
											</label> 
										</div>
									</div>
									 
									<div class="form-group">
										<label class="control-label col-sm-2" for="nt_card">
											ID Card</label>
										<div class="col-sm-10">
											<input type="text" maxlength="11" class="form-control required check_number"  name="gu_national_id" id="gu_id_card"
												placeholder="Guarantor National Card">
										</div>
									</div>
										<div class="form-group">
										<label class="control-label col-sm-2" for="text">
											Phone</label>
										<div class="col-sm-10">
											<input type="text" maxlength="11" class="form-control required check_number" name="gu_phone" id="gu_phone"
												placeholder="Guarantor phone">
										</div>
									</div> 
									<div class="form-group">
										<label class="control-label col-sm-2" for="text">
											Pawn</label>
										<div class="col-sm-10">
											<textarea class="form-control" maxlength="100" rows="3" name="gu_pawn" id="gu_pawn" placeholder="Guarantor Note"></textarea>
										</div>
									</div>
								 
							</div>
						</div>
					</div>

					<!-- Loan Information -->

					<div class="col-md-6 col-lg-6">
						<div class="panel panel-default">
							<div class="panel-heading" style="font-size: 14px;">Loan
								Information</div>
							<div class="panel-body">
								 
									<!-- account infor  -->
									<div class="form-group">
										<label class="control-label col-sm-2">Amount</label>
										<div class="col-sm-10">
											<!-- <div class="input-group"> -->
												<input type="text" class="form-control required check_number" name="ac_amount" id="amount"
													placeholder="Amount">
												<!-- <div class="input-group-addon">R</div> -->
											<!-- </div> -->
										</div>
									</div>

									<div class="form-group">
										<label class="control-label col-sm-2">Rate</label>
										<div class="col-sm-10">
											<!-- <div class="input-group"> -->
												<input type="text" class="form-control required check_number" name="ac_rate" id="rate"
													placeholder="Rate" maxlength="4">
												<!-- <div class="input-group-addon">%</div> -->
											<!-- </div> -->
										</div>
									</div>


									 <div class="form-group">
										<label class="control-label col-sm-2" for="ls_nm">
											Saving Amount:</label>
										<div class="col-sm-10">
											<select class="form-control required" name="ac_saving_amount">
												<option>2500</option>
												<option>5000</option>
												<option>7500</option>
												<option>10000</option>
											</select>
										</div>
									</div>
									
									 <div class="form-group">
										<label class="control-label col-sm-2" for="ls_nm">
											Account Type:</label>
										<div class="col-sm-10">
											<select class="form-control required" name="ac_type">
												<option>Loan</option>
												<option>Saving</option>
												<option>PayRoll</option>
												<option>Deposit</option>
											</select>
										</div>
									</div>
									
									<div class="form-group">
										<label class="control-label col-sm-2" for="ls_nm">
											Period:</label>
										<div class="col-sm-10">
											<input type="text" class="form-control required check_number" name="ac_period"
												placeholder="Period" maxlength="3">
											<br/>
											<select class="form-control"  name="ac_period_type" id="period">
												<option>Day</option>
												<option>Week</option>
												<option>Month</option>
												<option>Year</option>
											</select>
											
										</div>
									</div>

									<div class="pull-right">
										<button type="submit" class="btn btn-primary">Int Query</button> 
									</div> 
							</div>
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
	<%@include file="include/_script.jsp"%>
	<script>
	// just for the demos, avoids form submit
	var PAGE_ID="${page_id}";
	
	</script>
	
	<script type="text/javascript">
		$(function(){
			$("#loanAgreement").validate({
				 errorPlacement: function(label, element) {
			           label.addClass('arrow');
			           label.insertAfter(element);
			          console.log(element);
					  },
				 /* wrapper: 'div', */
				  submitHandler: function(form) { 
				   	form.submit();
				  }
				 });
		})
	</script>

</body>

</html>
