<%@include file="include/_head.jsp"%>
<%
	int cus_id=0;
	if (strCoNm == "" || strCoNm == null) {
		response.sendRedirect("../login");
	}
	
	 if (request.getParameter("cus_id") != null) {
	        cus_id=Integer.parseInt(request.getParameter("cus_id").toString());
	  } //check_cus
%>
<style>
		.form-group.required .control-label:after {
		  content:"*";
		  color:red;
		}
		.help-block{
			display: none;
		}
	</style>
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
					<form class="form-horizontal" id="loanAgreement"
						action="newLoanAgreementGetData" method="POST" role="form">

						<div class="col-md-6 col-lg-6">
							<div class="panel panel-default">
								<div class="panel-heading" style="font-size: 14px;">User
									Information</div>
								<div class="panel-body">

									<div>
										<span class="glyphicon glyphicon-user"
											style="font-size: 90px;"></span>
									</div>
									<!--<span class="btn btn-default btn-file btn-sm"> Browse <input
										type="file" id="cu_photo" name="cu_photo">

									</span>-->

									<div class="form-group required">
										<label class="control-label col-sm-2" for="fst_nm">
											Name </label>
										<div class="col-sm-10">
											<input type="text" class="form-control" name="cu_nm"
												id="cu_nm" placeholder="Full Name" maxlength="50">
											 <span class="help-block with-errors"><ul class="list-unstyled"><li> </li></ul></span>	
										</div>
									</div>

									<!--<div class="form-group">
										<label class="control-label col-sm-2" for="ls_nm">
											Nick name:</label>
										<div class="col-sm-10">
											<input type="text" maxlength="50"
												class="form-control required" name="cu_nick_nm"
												id="nick_name" placeholder="Nick Name">
										</div>
									</div>-->

									<div class="form-group required">
										<label class="control-label col-sm-2" for="ls_nm">Sex </label>
										<div class="col-sm-10" name="cu_sex" id="cu_sex">
											<label class="radio-inline"> <input type="radio"
												value="m" name="cu_sex" checked="checked">Male
											</label> <label class="radio-inline"> <input type="radio"
												value="f" name="cu_sex">Female
											</label>
										</div>
									</div>

									<div class="form-group required">
										<label class="control-label col-sm-2" for="nt_card">
											DOB</label>
										<div class="col-sm-10">
											<input maxlength="50" type="text"
												class="form-control" id="cu_dob" name="cu_dob"
												placeholder="Date of Birth">
											 <span class="help-block with-errors"><ul class="list-unstyled"><li> </li></ul></span>	
										</div>
									</div>
									<div class="form-group required">
										<label class="control-label col-sm-2" for="nt_card">
											ID Card</label>
										<div class="col-sm-10">
											<input type="text" maxlength="9"
												class="form-control"
												name="cu_national_id" id="cu_national_id"
												placeholder="Enter National Card">
												 <span class="help-block with-errors"><ul class="list-unstyled"><li> </li></ul></span>	
										</div>
									</div>
									<div class="form-group required">
										<label class="control-label col-sm-2" for="nt_card">
											Phone</label>
										<div class="col-sm-10">
											<input type="text" maxlength="10"
												class="form-control " name="cu_phone"
												id="cu_phone" placeholder="User Phone number">
												 <span class="help-block with-errors"><ul class="list-unstyled"><li> </li></ul></span>	
										</div>
									</div>

									<div class="form-group">
										<label class="control-label col-sm-2" for="text">
											Address</label>
										<div class="col-sm-10">
											<textarea class="form-control" maxlength="100"
												rows="3" name="cu_address" id="cu_address"
												placeholder="User Address"></textarea>
										</div>
									</div>

									<div class="form-group">
										<label class="control-label col-sm-2" for="text"> Pawn</label>
										<div class="col-sm-10">
											<textarea class="form-control" maxlength="100" rows="3"
												name="cu_pawn" id="user_pawn" placeholder="User Pawn"></textarea>
										</div>
									</div>

									<hr />

									<div class="form-group required">
										<label class="control-label col-sm-2" for="text">
											Guarantor</label>
										<div class="col-sm-10">
											<input type="text" maxlength="50"
												class="form-control" name="gu_nm" id="gu_nm"
												placeholder="Guarantor name">
											 <span class="help-block with-errors"><ul class="list-unstyled"><li> </li></ul></span>	
										</div>
									</div>

									<div class="form-group required">
										<label class="control-label col-sm-2" for="ls_nm">Sex</label>
										<div class="col-sm-10" name="cu_sex" id="cu_sex">
											<label class="radio-inline"> <input type="radio"
												value="f" name="gu_sex" checked="checked">Male
											</label> <label class="radio-inline"> <input type="radio"
												value="m" name="gu_sex">Female
											</label>
										</div>
									</div>

									<div class="form-group required">
										<label class="control-label col-sm-2" for="nt_card">
											ID Card</label>
										<div class="col-sm-10">
											<input type="text" maxlength="9"
												class="form-control "
												name="gu_national_id" id="gu_national_id"
												placeholder="Guarantor National Card">
												 <span class="help-block with-errors"><ul class="list-unstyled"><li> </li></ul></span>	
										</div>
									</div>
									<div class="form-group required">
										<label class="control-label col-sm-2" for="text">
											Phone</label>
										<div class="col-sm-10">
											<input type="text" maxlength="10"
												class="form-control" name="gu_phone"
												id="gu_phone" placeholder="Guarantor cu_phone">
												 <span class="help-block with-errors"><ul class="list-unstyled"><li> </li></ul></span>	
										</div>
									</div>
									<div class="form-group">
										<label class="control-label col-sm-2" for="text"> Pawn</label>
										<div class="col-sm-10">
											<textarea class="form-control" maxlength="100" rows="3"
												name="gu_pawn" id="gu_pawn" placeholder="Guarantor Note"></textarea>
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
									<div class="form-group required">
										<label class="control-label col-sm-2">Amount</label>
										<div class="col-sm-10">
											<!-- <div class="input-group"> -->
											<input type="text" class="form-control "
												name="ac_amount" id="ac_amount" placeholder="Amount">
												 <span class="help-block with-errors"><ul class="list-unstyled"><li> </li></ul></span>	
											<!-- <div class="input-group-addon">R</div> -->
											<!-- </div> -->
										</div>
									</div>

									<div class="form-group required">
										<label class="control-label col-sm-2">Rate</label>
										<div class="col-sm-10">
											<!-- <div class="input-group"> -->
											<input type="text" class="form-control "
												name="ac_rate" id="ac_rate" placeholder="Rate" maxlength="5">
												 <span class="help-block with-errors"><ul class="list-unstyled"><li></li></ul></span>											
										</div>
									</div>


									<!-- <div class="form-group">
										<label class="control-label col-sm-2" for="ls_nm">
											Saving Amount:</label>
										<div class="col-sm-10">
											<select class="form-control required" name="ac_saving_ac_amount">
												<option>2500</option>
												<option>5000</option>
												<option>7500</option>
												<option>10000</option>
											</select>
										</div>
									</div>-->

									<div class="form-group">
										<label class="control-label col-sm-2" for="ls_nm">
											Account Type:</label>
										<div class="col-sm-10">
											<select class="form-control" id="ac_type" name="ac_type">
												<option value='loan'>Loan</option>
												<!-- <option>Saving</option>
												<option>PayRoll</option>
												<option>Deposit</option>-->
											</select>
										</div>
									</div>

									<div class="form-group required">
										<label class="control-label col-sm-2" for="ls_nm">
											Period:</label>
										<div class="col-sm-10">
											<input type="text" class="form-control required check_number"
												name="ac_period" id="ac_period" placeholder="Period" maxlength="2">
												 <span class="help-block with-errors"><ul class="list-unstyled"><li> </li></ul></span>	
											<br /> <select class="form-control" id="ac_period_type" name="ac_period_type"
												>
												<option value="Day">Day</option>
												<option value="Week">Week</option>
												<option value="Month">Month</option>
												<!--<option>Year</option>-->
											</select>

										</div>
									</div>

									<div class="pull-right">
										<button type="button" id="query" class="btn btn-primary">
											Save</button>
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
		var PAGE_ID = "${page_id}";		
		var cus_id="<%=cus_id%>";
		
		if(cus_id !=0){
			 popup("${pageContext.request.contextPath}/LoanAgreement/report/"+cus_id);
		}
		
		jQuery.validator.addMethod("lessThen24", function(value, element) {
			var ac_period_type=$("#ac_period_type").val();	
			return  this.optional(element)  || (parseFloat(value) < 25 );
		   
		}, " Period must be less than 24");
		
		jQuery.validator.addMethod("lessThen56", function(value, element) {
			var ac_period_type=$("#ac_period_type").val();	
			return  this.optional(element) || ac_period_type==1 || (parseFloat(value) < 57 );
		   
		}, " Period must be less than 56");
		
		jQuery.validator.addMethod("lessThen10", function(value, element) {
			return  this.optional(element) || (parseFloat(value) < 11 );
		   
		}, " Rate must be less than 10");
		
	</script>

	<script type="text/javascript">
	
		$(document).ready(function(){
			$("#query").click(function(){			
				coInsert();
			});
			//blur event
			onblur();
			$("#ac_amount").ForceNumericOnly();
			$("#ac_rate").ForceNumericOnly();
			$("#ac_period").ForceNumericOnly();
			$("#cu_phone").ForceNumericOnly();
			$("#cu_national_id").ForceNumericOnly();
			$("#gu_phone").ForceNumericOnly();
			$("#gu_national_id").ForceNumericOnly();
			
			$("#ac_period").blur(function(){
				
				var ac_period_type=$("#ac_period_type").val();
				if(ac_period_type=="Day"){
					checkLength("ac_period","Period must be less than 56", 57);
				}else{
					checkLength("ac_period","Period must be less than 24", 25);
				}
			});
			
			$("#ac_rate").blur(function(){
				checkLength("ac_rate","Rate must be less than 10 %",11)			
			});
			
			$("#cu_dob").datepicker({
				showOtherMonths : true,
				selectOtherMonths : true,
				changeMonth : true,
				changeYear : true,
				dateFormat : "dd-mm-yy",
				onSelect: function(dateText) {
					  var txt="";
						txt=this.value;
						if(txt==""){
							$("#cu_dob").siblings(".help-block").show();
							$("#cu_dob").parents(".form-group").addClass("has-error");
						}else{
							$("#cu_dob").parents(".form-group").removeClass("has-error");
							$("#cu_dob").siblings(".help-block").hide();
						}
				  }
			});		
		});
		
	

		function onblur(){
			//Customer validation 
			checkNullOnBlue("cu_nm");
			checkNullOnBlue("cu_dob");
			checkNullOnBlue("cu_national_id");
			checkNullOnBlue("cu_phone");
			checkNullOnBlue("gu_nm");
			checkNullOnBlue("gu_phone");
			checkNullOnBlue("gu_national_id");
			checkNullOnBlue("ac_amount");
			checkNullOnBlue("ac_rate");
			checkNullOnBlue("ac_period");
			
			
			
		}
		
		
		

		function validation(input){
			/*--  log_email  --*/
			var error=false;
			if(checkNull(input.cu_nm,"cu_nm"))error=true;
			if(checkNull(input.cu_dob,"cu_dob"))error=true;
			if(checkNull(input.cu_national_id,"cu_national_id"))error=true;
			if(checkNull(input.cu_phone,"cu_phone"))error=true;
			if(checkNull(input.gu_nm,"gu_nm"))error=true;
			if(checkNull(input.gu_phone,"gu_phone"))error=true;
			if(checkNull(input.gu_national_id,"gu_national_id"))error=true;
			if(checkNull(input.ac_amount,"ac_amount"))error=true;
			if(checkNull(input.ac_rate,"ac_rate")){
				error=true;
			}else{
				if(checkLength("ac_rate","Rate must be less than 10 %",11)){
					error=true;
				}
			}			
			if(checkNull(input.ac_period,"ac_period")){
				error=true;
			}else{
				var ac_period_type=$("#ac_period_type").val();
				if(ac_period_type=="Day"){
					if(checkLength("ac_period","Period must be less than 56", 57)){
						error=true;
					}				
				}else{
					if(checkLength("ac_period","Period must be less than 24", 25)){
						error=true;
					};
				}
			}
			
		
			return error;
		}
		function coInsert(isNew){
			var input={};
			input['cu_nm']=$("#cu_nm").val();
			input['cu_dob']=$("#cu_dob").val();
			input['cu_national_id']=$("#cu_national_id").val();
			input['cu_phone']=$("#cu_phone").val();
			input['gu_nm']=$("#gu_nm").val();
			input['gu_phone']=$("#gu_phone").val();
			input['gu_national_id']=$("#gu_national_id").val();
			input['ac_amount']=$("#ac_amount").val();
			input['ac_rate']=$("#ac_rate").val();
			input['ac_period']=$("#ac_period").val();
			
			if(validation(input)){
				
				return;
			}
		    $("#loanAgreement").submit();					
		}
		
		

	</script>

</body>

</html>
