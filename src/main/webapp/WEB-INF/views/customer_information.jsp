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
                           <span></span>Customer Infomation
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
									<div class="col-md-6">
										<span class="col-md-4 col-sm-4" style="padding:0px">
											<select class="form-control">
												<option>Co ID or Name</option>
												<option>Co ID</option>
												<option>Name</option>
											</select>
										</span>
											
									</div>
									<div class="col-md-6 col-sm-6 pull-right">
											
											<div class="form-group input-group">
												<input class="form-control" type="text" placeholder="Enter Customer ID Card or Name">
												<span class="input-group-btn"><button class="btn btn-default" type="button"><i class="fa fa-search"></i></button></span>
											</div>
										
									</div>
								</div>
							
							</div>	
							<!-- panel body -->
							<div class="panel panel-body">
								<div class="table-responsive">
									<table class="table table-hover table-striped">
										<thead>
											<tr>
												<th>ID</th>
												<th>Name</th>
												<th>Sex</th>
												<th>DOF</th>
												<th>National ID</th>
												<th>Branch</th>
												<th>Phone</th>
												
												<th>Action</th>
											</tr>
										</thead>
										<tbody>
											<tr>
												<td>2464</td>
												<td>Prak virak</td>
												<td>Male</td>
												<td>09-08-1990</td>
												<td>09978797767</td>
												<td>Phnom Penh</td>
												<td>010 988-752</td>
												
												<td>
													<a href="#none"><span class="glyphicon glyphicon-pencil"></span></a>
													&nbsp;
													<a href="#none"><span class="glyphicon glyphicon-trash"></span></a>
													&nbsp;
													<a href="#none"><span class="glyphicon glyphicon-random"></span></a>
												</td>
		
											</tr>
											<tr>
												<td>2464</td>
												<td>Prak virak</td>
												<td>Male</td>
												<td>09-08-1990</td>
												<td>09978797767</td>
												<td>Phnom Penh</td>
												<td>010 988-752</td>
											
												<td>
													<a href="#none"><span class="glyphicon glyphicon-pencil"></span></a>
													&nbsp;
													<a href="#none"><span class="glyphicon glyphicon-trash"></span></a>
													&nbsp;
													<a href="#none"><span class="glyphicon glyphicon-random"></span></a>
												</td>
											</tr>
											<tr>
												<td>2464</td>
												<td>Prak virak</td>
												<td>Male</td>
												<td>09-08-1990</td>
												<td>09978797767</td>
												<td>Phnom Penh</td>
												<td>010 988-752</td>
												
												<td>
													<a href="#none"><span class="glyphicon glyphicon-pencil"></span></a>
													&nbsp;
													<a href="#none"><span class="glyphicon glyphicon-trash"></span></a>
													&nbsp;
													<a href="#none"><span class="glyphicon glyphicon-random"></span></a>
												</td>
											</tr>
											<tr>
												<td>2464</td>
												<td>Prak virak</td>
												<td>Male</td>
												<td>09-08-1990</td>
												<td>09978797767</td>
												<td>Phnom Penh</td>
												<td>010 988-752</td>
											
												<td>
													<a href="#none"><span class="glyphicon glyphicon-pencil"></span></a>
													&nbsp;
													<a href="#none"><span class="glyphicon glyphicon-trash"></span></a>
													&nbsp;
													<a href="#none"><span class="glyphicon glyphicon-random"></span></a>
												</td>
											</tr>
											
										</tbody>
									</table>
								</div>
								
							</div>
							<!-- //panel body -->
							
						</div>
						<div class="row">
							<div class="col-md-6 col-md-offset-3" style="text-align:center">
								<ul class="pagination">
								   <li class="next"><a href="none"><span class="glyphicon glyphicon-chevron-left"></span></a></li>
								  <li class="active"><a href="#">1</a></li>
								  <li><a href="#">2</a></li>
								  <li><a href="#">3</a></li>
								  <li><a href="#">4</a></li>
								  <li><a href="#">5</a></li>
								  
								  <li class="next"><a href="none"><span class="glyphicon glyphicon-chevron-right"></span></a></li>
								</ul>
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
