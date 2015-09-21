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
                <jsp:include page="include/_side_nav.jsp" />
            </div>
            <!-- /.navbar-collapse -->
        </nav>

        <div id="page-wrapper">

            <div class="container-fluid">

                <!-- Page Heading -->
                <div class="row">
					
                    <div class="col-lg-12">
					
                        <h2 class="page-header" style="text-align:center;">
                            Weekly Pay Schedule
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
									<div class="col-md-4">
										<table class="table">
											
											<tbody>
											  <tr>
												<td style="border:0px">Customer Name :</td>
												<td style="border:0px">Prak Virak</td>
											  </tr>
											  <tr>
												<td>Date Time :</td>
												<td>01/12/2030 8:30 AM</td>
											  </tr>
											  <tr>
												<td>Address :</td>
												<td>01/12/2030 8:30 AM</td>
											  </tr>
											 
											</tbody>
										</table>
											
									</div>
									<div class="col-md-4">
										<table class="table">
											
											<tbody>
											  <tr>
												<td style="border:0px">Loan Period :</td>
												<td style="border:0px">5 weeks</td>
											  </tr>
											  <tr>
												<td>Full Amont :</td>
												<td>1000,000.00 R</td>
											  </tr>
											  <tr>
												<td>Part Borrow :</td>
												<td>2</td>
											  </tr>
											 
											</tbody>
										</table>
											
									</div>
									<div class="col-md-4">
											<table class="table">
											
											<tbody>
											  <tr>
												<td style="border:0px">Customer Officer IDP :</td>
												<td style="border:0px">2012255</td>
											  </tr>
											  <tr>
												<td>Customer offer Name :</td>
												<td>Virak</td>
											  </tr>
											  <tr>
												<td>Customer offer Phone :</td>
												<td>010 101-100</td>
											  </tr>
											 
											</tbody>
										</table>
											
									</div>
								</div>
							
							</div>	
							<!-- panel body -->
							<div class="panel panel-body">
								
								<div class="table-responsive">
									<table class="table table-hover table-striped">
										<thead>
											<tr class="tr-heading">
												<th>No</th>
												<th>Date Time</th>
												<th>Day</th>
												<th>Full Amount</th>
												<th>Save Amount</th>
												<th>Pay Amount</th>
												<th>Balance</th>
												<th>Status</th>
												<th>action</th>
											</tr>
										</thead>
										<tbody>
											<tr class="tr-safe">
												<td>1</td>
												<td>17/02/2015</td>
												<td>Monday</td>
												<td>1,000,000.00</td>
												<td>5,000.00</td>
												<td>5,3600.00</td>
												<td>960,000.00</td>
												<td>cleared</td>
												<td></td>
						
											</tr>
											<tr class="tr-safe">
												<td>2</td>
												<td>17/02/2015</td>
												<td>Monday</td>
												<td>1,000,000.00</td>
												<td>5,000.00</td>
												<td>5,3600.00</td>
												<td>960,000.00</td>
												<td>cleared</td>
												<td></td>
											</tr>
											<tr class="tr-safe">
												<td>3</td>
												<td>17/02/2015</td>
												<td>Monday</td>
												<td>1,000,000.00</td>
												<td>5,000.00</td>
												<td>5,3600.00</td>
												<td>960,000.00</td>
												<td>cleared</td>
												<td></td>
											</tr>
											<tr class="tr-warning">
												<td>4</td>
												<td>17/02/2015</td>
												<td>Monday</td>
												<td>1,000,000.00</td>
												<td>5,000.00</td>
												<td>5,3600.00</td>
												<td>960,000.00</td>
												<td>appending</td>
												<td><a href="#none"><span class="glyphicon glyphicon-saved"></span></a></td>
											</tr>
											<tr class="tr-appending">
												<td>5</td>
												<td>17/02/2015</td>
												<td>Monday</td>
												<td>1,000,000.00</td>
												<td>5,000.00</td>
												<td>5,3600.00</td>
												<td>960,000.00</td>
												<td>appending</td>
												<td><a href="#none"><span class="glyphicon glyphicon-saved"></span></a></td>
											</tr>
											<tr class="tr-appending">
												<td>6</td>
												<td>17/02/2015</td>
												<td>Monday</td>
												<td>1,000,000.00</td>
												<td>5,000.00</td>
												<td>5,3600.00</td>
												<td>960,000.00</td>
												<td>appending</td>
												<td><a href="#none"><span class="glyphicon glyphicon-saved"></span></a></td>
											</tr>
											
										</tbody>
									</table>
								</div>
								
							</div>
							<!-- //panel body -->
							
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
   



</body>

</html>
