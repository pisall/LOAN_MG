<jsp:include page="include/_head.jsp" />

<body>

    <div id="wrapper">

        <!-- Navigation -->
        <nav class="navbar navbar-inverse navbar-fixed-top" role="navigation">
            <!-- Brand and toggle get grouped for better mobile display // logo at left top-->
            <div class="navbar-header">
                <button type="button" class="navbar-toggle" data-toggle="collapse" data-target=".navbar-ex1-collapse">
                    <span class="sr-only">Toggle navigation</span>
                    <span class="icon-bar"></span>
                    <span class="icon-bar"></span>
                    <span class="icon-bar"></span>
                </button>
                <a class="navbar-brand" href="index.html">SB Admin</a>
            </div>
            <!-- Top Menu Items -->
            <ul class="nav navbar-right top-nav">
                
                <li class="dropdown">
                    <a href="#" class="dropdown-toggle" data-toggle="dropdown"><i class="fa fa-user"></i> John Smith <b class="caret"></b></a>
                    <ul class="dropdown-menu">
                        <li>
                            <a href="#"><i class="fa fa-fw fa-user"></i> Profile</a>
                        </li>
                        <li>
                            <a href="#"><i class="fa fa-fw fa-envelope"></i> Inbox</a>
                        </li>
                        <li>
                            <a href="#"><i class="fa fa-fw fa-gear"></i> Settings</a>
                        </li>
                        <li class="divider"></li>
                        <li>
                            <a href="#"><i class="fa fa-fw fa-power-off"></i> Log Out</a>
                        </li>
                    </ul>
                </li>
            </ul>
            <!-- Sidebar Menu Items - These collapse to the responsive navigation menu on small screens -->
            <div class="collapse navbar-collapse navbar-ex1-collapse">
                <ul class="nav navbar-nav side-nav">
                    <li class="active">
                        <a href="index.html"><i class="fa fa-fw fa-dashboard"></i> Dashboard</a>
                    </li>
                    <li>
                        <a href="charts.html"><i class="fa fa-fw fa-bar-chart-o"></i>User Management</a>
                    </li>
                   
                    <li>
                        <a href="blank-page.html"><i class="fa fa-fw fa-file"></i> Blank Page</a>
                    </li>
                    <li>
                        <a href="index-rtl.html"><i class="fa fa-fw fa-dashboard"></i> RTL Dashboard</a>
                    </li>
                </ul>
            </div>
            <!-- /.navbar-collapse -->
        </nav>

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
