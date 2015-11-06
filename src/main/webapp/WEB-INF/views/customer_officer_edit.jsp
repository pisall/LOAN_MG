
	<%@include file="include/_head.jsp"%>
	
	<style>
		.form-group.required .control-label:after {
		  content:"*";
		  color:red;
		}
		.help-block{
			display: none;
		}
	</style>

</head>

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
					
                        <h2 class="page-header">
                            New CO<small>(Cuctomer Officer Agreement)</small>
                        </h2>
                        
                    </div>
					
                </div>
				
				
				<div class="row">	
					<form class="form-horizontal" role="form">		
						
						<div class="col-sm-12 col-md-12 col-lg-12 col-xs-12">
						
						<!-- panel-group -->
						<div class="panel-group">
						
					
						    
						    <!-- general information -->
						    <div class="panel panel-default">
						      <div class="panel-heading">General Information</div>
						      
						      <!-- panel body -->
						      <div class="panel-body">
							      <div class="row">
							      	<div class="col-md-12 col-lg-12">
									  <div class="form-group">
										<label class="control-label col-sm-2" for="fst_nm">First Name:</label>
										<div class="col-sm-10 ">
										  <input type="email" class="form-control" id="first_nm" placeholder="First Name">
										</div>
									  </div>
									  
									  <div class="form-group">
										<label class="control-label col-sm-2" for="ls_nm">Last Name:</label>
										<div class="col-sm-10">
										  <input type="email" class="form-control" id="last_nm" placeholder="Last Name">
										</div>
									  </div>
									  
									  <div class="form-group">
										<label class="control-label col-sm-2" for="ls_nm">Sex</label>
										<div class="col-sm-10" id="sex">
											<label class="radio-inline">
											  <input type="radio" name="sex" checked value="M">Male
											</label>
											<label class="radio-inline">
											  <input type="radio" name="sex" value="F">Female
											</label>
											
										</div>
									  </div>
									  
									  <div class="form-group">
										<label class="control-label col-sm-2" for="fst_nm">Dat of Birth:</label>
										<div class="col-sm-10 ">
										  <input data-provide="datepicker" type="date" class="form-control datepicker" id="dob" placeholder="Date of Birth">
										</div>
									  </div>
									  
									  <div class="form-group required">
										<label class="control-label col-sm-2" for="nt_card">National Card</label>
										<div class="col-sm-10">
										  <input type="email" class="form-control" id="national_id" placeholder="Enter National Card">
										</div>
									  </div>
									  
									  <div class="form-group">
										<label class="control-label col-sm-2" for="ls_nm">Brand</label>
										<div class="col-sm-10">
											 <select class="form-control" id="brand">
												<option>Brand 1</option>
												<option>Brand 2</option>
												<option>Brand 3</option>
												<option>Brand 4</option>
											  </select>
											
										</div>
									  </div>
									  
									  <div class="form-group required">
										<label class="control-label col-sm-2" for="ph_1">Mobile</label>
										<div class="col-sm-10">
										  <input type="email" class="form-control" id="phone" placeholder="Enter Phone">
										  <span class="help-block with-errors"><ul class="list-unstyled"><li>Please fill out this field.</li></ul></span>
										</div>
									  </div>
									  
									  <div class="form-group">
										<label class="control-label col-sm-2" for="ph_2">Office Phone</label>
										<div class="col-sm-10">
										  <input type="email" class="form-control" id="cpm_phone" placeholder="Enter Second phone">
										</div>
									  </div>
									  
									  <div class="form-group">
										<label class="control-label col-sm-2" for="email">Place of Birth:</label>
										<div class="col-sm-10">
										  <textarea class="form-control" rows="5" id="pb_adress"></textarea>
										</div>
									  </div>
									   <div class="form-group">
										<label class="control-label col-sm-2" for="address">Address:</label>
										<div class="col-sm-10">
										  <textarea class="form-control" rows="5" id="address"></textarea>
										</div>
									  </div>
											                 
									</div>
							      
							      </div>
						      </div>
						      <!-- //panel body -->
						    </div>
						    <!-- //general information -->
						    <br/>
						    <div class="pull-right">
									  		<a href="#none" id="btn_save" class="btn btn-primary"><span>Register</span></a>
										  <button type="button" class="btn btn-default">Cancel</button>
									  </div>
						    
							</div>
							<!-- //panel-group -->
						 		
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
    <%@include file="include/_script.jsp"%>
    <script type="text/javascript">
		var BASE_URL = "${pageContext.request.contextPath}";
		var ID="${id}>";
		
	</script>
    
    <script src="${pageContext.request.contextPath}/resources/js/page/customer_officer_edit.js"></script>



</body>

</html>