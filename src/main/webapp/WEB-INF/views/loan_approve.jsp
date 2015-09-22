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
					
                        <h2 class="page-header" style="text-align:center">
                            Loan Approval
                        </h2>
                        
                    </div>
					
                </div>
				
				
				<div class="row">	
					<div class="col-lg-12">
						<table class="table" style="background-color:#F5ECEC">
							<tbody>
								<tr>
									<td colspan="4" style="text-align:center;background-color:#FFF"><h4>Customer Infomation</h4></td>
								</tr>
								<tr>
									<td>Name : <span class="label label-primary">Prak Virak</span></td>
									<td>Sex : <span class="label label-primary">Male</span></td>
									<td>Phone : <span class="label label-primary">010 999-999</span></td>
									<td>National ID: <span class="label label-primary">834749839384</span></td>									
								</tr>

								<tr>
									<td colspan="4" style="text-align:center;background-color:#FFF;"><h4>Loan Information</h4></td>
								</tr>
								<tr>
									<td>Pay Type : <span class="label label-primary">week</span></td>
									<td>Total : <span class="label label-primary">1,938,383.00 R</span></td>
									<td>Date : <span class="label label-primary">12/12/2016</span></td>
									<td>Transaction Amount<br/>
										&nbsp;- Pay Amount : <span class="label label-primary">53,600.00</span><br/>
										&nbsp;- Balance : <span class="label label-primary">960,000.00</span>
									</td>									
								</tr>
								<tr>
									<td colspan="4" style="border:0px;">Pawn: <span class="label label-primary">Car</span></td>
								</tr>
								<tr>
									<td colspan="4" style="text-align:center;background-color:#FFF"><h4>Guarantor</h4></td>
								</tr>
								<tr>
									<td>Name : <span class="label label-primary">Prak Virak</span></td>
									<td>Sex : <span class="label label-primary">Male</span></td>
									<td>Phone : <span class="label label-primary">010 999-999</span></td>
									<td>National ID: <span class="label label-primary">0453453434</span></td>									
								</tr>
								<tr>								<tr>
									<td colspan="4" style="border:0px;">Pawn: <span class="label label-primary">Car</span></td>
								</tr>
							</tbody>
						</table>
						
					</div>
					<div class="col-lg-12">
						<form rol="form" class="form-horizontal">
							<div class="row">
								<div class="col-lg-6 col-md-6">
									<div class="form-group">
										<label class="control-label col-sm-4" for="paid_amount">Paid Amount:</label>
										<div class="col-sm-8">
										  <input type="text" class="form-control" id="paid_amount" placeholder="">
										</div>
									</div>
									<div class="form-group">
										<label class="control-label col-sm-4" for="amount-fine">Amount fine:</label>
										<div class="col-sm-8">
										  <input type="text" class="form-control" id="amount-fine" placeholder="">
										</div>
									</div>
									
									<div class="form-group">
										<label class="control-label col-sm-4" for="amount-fine">Transection Type:</label>
										<div class="col-sm-8">
										  <select class="form-control">
											<option>--select--</option>
											<option>Complete</option>
											<option>Full</option>
										  </select>
										</div>
									</div>
								</div>
								<div class="col-lg-6 col-md-6">
									<div class="form-group">
										<label class="control-label col-sm-4" for="email">Note:</label>
										<div class="col-sm-8">
										  <textarea class="form-control"></textarea>
										</div>
									</div>
									
									<div class="form-group">
										<label class="control-label col-sm-4" for="email"></label>
										<div class="col-sm-8">
										  <button type="button" class="btn btn-primary btn-block">Approve</button>
										</div>
									</div>
									
									
								</div>
							</div>
						</form>
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
	
	<!-- select -->
    <script src="select/js/bootstrap-select.js"></script>

    <!-- Bootstrap Core JavaScript -->
    <script src="js/bootstrap.min.js"></script>
	
	<!-- page js -->
    <script src="js/load_approval.js"></script>



</body>

</html>
