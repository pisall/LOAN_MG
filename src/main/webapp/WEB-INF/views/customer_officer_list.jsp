<%@include file="include/_head.jsp"%>

</head>

<body>
	<style>
		.modal-header{
			border-bottom: 1px solid #FFFFFF;
		    background-color: #136686;
		    box-shadow: 0px 1px 2px #797777;
		    color:#fff;
		}
	</style>

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

        <div id="page-wrapper">
			<div class="container-fluid" style="    height: 200px; position: absolute;">
				<div class="row">
					<div class="col-md-6">
					</div>
				</div>
				
			</div>
            <div class="container-fluid">

                <!-- Page Heading -->
                <div class="row">
					
                    <div class="col-lg-12">
					
                        <h2 class="page-header">
                        	<div class="row">
                        		<div class="col-lg-6 col-md-6">CO <small>Customer Officer Infomation</small></div>
                        		<div class="col-lg-6 col-md-6 pull-right" style="text-align:right"><a class="btn btn-primary" href="${pageContext.request.contextPath}/co_001_controller/co_0001"><span class="glyphicon glyphicon-plus">&nbsp;New</span></a></div>
                        		
                        	</div>
                            
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
												<input class="form-control" type="text" placeholder="Enter CO ID or Name">
												<span class="input-group-btn"><button class="btn btn-default" type="button"><i class="fa fa-search"></i></button></span>
											</div>
										
									</div>
								</div>
							
							</div>	
							<!-- panel body -->
							<div class="panel panel-body">
								<div class="table-responsive">
									<table class="table table-hover table-striped" id="list">
										<colgroup>
											<col >
											<col >
											<col >
											<col >
											<col >
											<col style="width: 50px;">
										</colgroup>
										<thead class="style2">
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
											<!-- <tr>
												<td>2464</td>
												<td>Prak virak</td>
												<td>Male</td>
												<td>Phnom Penh</td>
												<td>010 988-752</td>
												<td>
													<a href="#none"><span class="glyphicon glyphicon-pencil"></span></a>
													&nbsp;
													<a href="#none"><span class="glyphicon glyphicon-trash"></span></a>
												</td>
												
												
												glyphicon glyphicon-pencil
											</tr> -->
											
											
										</tbody>
									</table>
								</div>
								
							</div>
							<!-- //panel body -->
							
						</div>
						<div class="row">
							<div class="col-md-6 col-md-offset-3" style="text-align:center">
								<ul class="pagination" id="paging">
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
        
        <!-- model user detail -->
        <div class="modal fade" id="myModal" role="dialog">
		    <div class="modal-dialog">
		    
		      <!-- Modal content-->
		      <div class="modal-content">
		        <div class="modal-header">
		          <button type="button" class="close" data-dismiss="modal">&times;</button>
		          <h4 class="modal-title">Customer Official Detail</h4>
		        </div>
		        <div class="modal-body">
		          <div class="row">	
						<div class="col-lg-12 col-md-12 col-sm-12 col-xs-12">
							<div class="col-xs-12 col-lg-3 col-md-3 col-sm-3  pull-right">
							
									<img src="${pageContext.request.contextPath}/resources/img/png/user_default.png" class="img-responsive"/>
								
							</div>
						</div>
						
						<div class="col-lg-12 col-md-12 col-xs-12 col-sm-12">
							<div class="panel panel-default">
								<div class="panel panel-body">
									<table class="table table-striped table-bordered table-condensed">
										<tbody>
											<tr>
												<td>ID</td>
												<td><span id="pop_co_id"></span></td>
											</tr>
											<tr>
												<td>Name</td>
												<td><span id="pop_co_nm"></span></td>
											</tr>
											<tr>
												<td>Gender</td>
												<td><span id="pop_co_sex"></span></td>
											</tr>
											<tr>
												<td>National ID</td>
												<td><span id="pop_co_national_id"></span></td>
											</tr>
											
											<tr>
												<td>Brand</td>
												<td><span id="pop_brand"></span></td>
											</tr>
											
											<tr>
												<td>Phone</td>
												<td><span id="pop_co_phone"></span></td>
											</tr>
											
											<tr>
												<td>Office Phone</td>
												<td><span id="pop_office_phone"></span></td>
											</tr>
											
											<tr>
												<td>Place of Birth</td>
												<td><span id="pop_co_pb_address"></span></td>
											</tr>
											<tr>
												<td>Office Phone</td>
												<td><span id="pop_co_address"></span></td>
											</tr>
											
											<tr>
												<td>Register by</td>
												<td><span id="pop_reg_id"></span></td>
											</tr>
											
											<tr>
												<td>Register date</td>
												<td><span id="pop_reg_dtt"></span></td>
											</tr>
											
											<tr>
												<td>Update</td>
												<td><span id="pop_update_dtt"></span></td>
											</tr>
											
											
											
										</tbody>
									</table>
								</div>
							</div>
							
						</div>
						
					</div>
		        </div>
		        <div class="modal-footer">
		          <button type="button" class="btn btn-default" data-dismiss="modal">Close</button>
		        </div>
		      </div>
		      
		    </div>
		 </div>
		 <!-- //model user detail -->
		  

    </div>
    
<!-- Code snippet -->

    
    <!-- script -->
   <%@include file="include/_script.jsp"%>
    <script type="text/javascript">
		var BASE_URL = "${pageContext.request.contextPath}";
		var PAGE_ID="${page_id}";
		console.log("ppp="+PAGE_ID);
	</script>
    <script src="${pageContext.request.contextPath}/resources/js/page/customer_officer_list.js"></script>

</body>

</html>
