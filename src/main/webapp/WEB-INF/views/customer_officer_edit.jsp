
	<%@include file="include/_head.jsp"%>
	
	<style>
		.form-group.required .control-label:after {
		  content:"*";
		  color:red;
		}
		.help-block{
			display: none;
		}
		
		div.input-label{
		    float: right;
	    	height: 0px;
		}
		div.input-label>label{
			font-weight: normal;
		    color: #294A98;
		    position: relative;
		    top: -29px;
		    right: 10px;
		    background: #E9E9E9;
		    padding: 2px 5px;
		    border-radius: 5px;
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

        <div id="page-wrapper">

            <div class="container-fluid">

                <!-- Page Heading -->
                <div class="row">
					
                    <div class="col-lg-12">
					
                        <h2 class="page-header">
                        	<div class="row">
                        		<div class="ccol-lg-6 col-sm-6 col-md-6 co-xs-6">
                        			Update CO<small>(Cuctomer Officer Agreement)</small>
                        		</div>
                        		<div class="ccol-lg-6 col-sm-6 col-md-6 co-xs-6">
<!--                         			<a href="#none" class="btn btn-default" data-toggle="modal" data-target="#myModal"><span>update</span></a> -->
                        			<a class="btn btn-primary pull-right" href="${pageContext.request.contextPath}/co_001_controller/co_0003" ><span class="glyphicon glyphicon-list"></span>&nbsp; List</a>
                        		</div>
                        	</div>
                            
                        </h2>
                        
                    </div>
					
                </div>
				
				
				<div class="row">	
					<form class="form-horizontal" role="form">		
						
						<div class="col-sm-12 col-md-12 col-lg-12 col-xs-12">
						
						<!-- panel-group -->
						<div class="panel-group">
								<!-- account information -->
						    <div class="panel panel-default" id="ACCOUNT_INFO">
						      <div class="panel-heading">Account Information</div>
						      <div class="panel-body">
						      	<div class="row">
						      		<div class="col-sm-12 col-md-12 col-lg-12 col-xs-12">
						      			<div class="form-group required">
											<label class="control-label col-sm-2" for="fst_nm">User mame</label>
											<div class="col-sm-10">
											  <input type="email" class="form-control" id="user_nm" placeholder="User name">
											  <span class="help-block with-errors"><ul class="list-unstyled"><li>Please fill out this field.</li></ul></span>
											</div>
											
										</div>
										<input type="hidden" id="log_in"/>
										<div class="form-group required">
											<label class="control-label col-sm-2" for="fst_nm">Password</label>
											<div class="col-sm-10 ">
											  <input type="password" class="form-control" id="password" placeholder="User name">
											  <span class="help-block with-errors"><ul class="list-unstyled"><li>Please fill out this field.</li></ul></span>
											</div>
										</div>
										<div class="form-group required">
											<label class="control-label col-sm-2" for="fst_nm">Permission</label>
											<div class="col-sm-10 ">
<!-- 											  <input type="password" class="form-control" id="role" placeholder="User name"> -->
											<select id="role">
												<option value="ROLE_ADMIN">ADMIN</option>
												<option value="ROLE_USER">USER</option>
											</select>
											  <span class="help-block with-errors"><ul class="list-unstyled"><li>Please fill out this field.</li></ul></span>
											</div>
										</div>
						      		</div>
						      	</div>
						      </div>
						    </div>
						    <!-- //account information -->
					
						    
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
										  <input type="text" class="form-control" id="first_nm" placeholder="First Name">
										</div>
									  </div>
									  
									  <div class="form-group">
										<label class="control-label col-sm-2" for="ls_nm">Last Name:</label>
										<div class="col-sm-10">
										  <input type="text" class="form-control" id="last_nm" placeholder="Last Name">
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
										  <input type="text" class="form-control" id="national_id" placeholder="Enter National Card">
										</div>
									  </div>
									  
									  <div class="form-group">
										<label class="control-label col-sm-2" for="ls_nm">Brand</label>
										<div class="col-sm-10">
											 <input type="text" class="form-control" id="brand" placeholder="Enter Phone">
											
										</div>
									  </div>
									  
									  <div class="form-group required">
										<label class="control-label col-sm-2" for="ph_1">Mobile</label>
										<div class="col-sm-10">
										  <input type="text" class="form-control" id="phone" placeholder="Enter Phone">
										  <div class="input-label"><label id="lb_phone">010 738-3848</label></div>
										  <span class="help-block with-errors"><ul class="list-unstyled"><li>Please fill out this field.</li></ul></span>
										</div>
									  </div>
									  
									  <div class="form-group">
										<label class="control-label col-sm-2" for="ph_2">Office Phone</label>
										<div class="col-sm-10">
										  <input type="text" class="form-control" id="cpm_phone" placeholder="Enter Second phone">
										   <div class="input-label"><label id="lb_office_phone">010 738-3848</label></div>
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
									  <a href="#none" id="btn_save" class="btn btn-primary"><span>Update</span></a>
										  <a class="btn btn-default" href="${pageContext.request.contextPath}/co_001_controller/co_0003">Cancel</a>
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
    
    <button class="btn btn-primary" data-toggle="modal" data-target="#myModal">Trigger Modal in iFrame</button>

		<!-- Modal -->
		<div class="modal fade" id="myModal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
		  <div class="modal-dialog">
		    <div class="modal-content">
		      <div class="modal-header">
		        <button type="button" class="close" data-dismiss="modal" aria-hidden="true">&times;</button>
		        <h4 class="modal-title" id="myModalLabel">Modal title</h4>
		      </div>
		      <div class="modal-body" style="text-align:center;">
		          <iframe src="${pageContext.request.contextPath}/uploadController/fileUploadForm" width="300" height="380" frameborder="0" allowtransparency="true"></iframe>  
		      </div>
		      <div class="modal-footer">
		        <button type="button" class="btn btn-default" data-dismiss="modal">Close</button>
		        <button type="button" class="btn btn-primary">Save changes</button>
		      </div>
		    </div>
		    <!-- /.modal-content -->
		  </div>
		  <!-- /.modal-dialog -->
		</div>
		<!-- /.modal -->
    
    

    <!-- jQuery -->
    <%@include file="include/_script.jsp"%>
    <script type="text/javascript">
		var BASE_URL = "${pageContext.request.contextPath}";
		var ID="${id}";
		var PAGE_ID="${page_id}";
		
	</script>
    
    <script src="${pageContext.request.contextPath}/resources/js/page/customer_officer_edit.js"></script>



</body>

</html>
