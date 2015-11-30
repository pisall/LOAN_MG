<%@include file="include/_head.jsp"%>

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
					
                        <h2 class="page-header" id="pro_nm">
                            
                            <div class="row">
                            	<div class="col-lg-6 col-md-6 col-sm-6 col-xs-6">
                            		<span id="co_nm">Mr.Prak Virak</span>
                            	</div>
                            	
                            	<div class="col-lg-6 col-md-6 col-sm-6 col-xs-6">
                            		<div class="btn-group" style="float:right;">
									  <button type="button" class="btn btn-default dropdown-toggle" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
									    Action <span class="caret"></span>
									  </button>
									  <ul class="dropdown-menu dropdown-menu-right" >
									    <li id="opt_change_username"><a href="#">Change user name</a></li>
									    <li id="opt_change_password"><a href="#">Change password</a></li>
									   
									  </ul>
									</div>
                            	</div>
                            
                            </div>
                        </h2>
                        
                        	
                        
                 
                        <div style="position: relative;">
                        	<!-- Single button -->
                       			<div class="row">
                       				<div class="col-lg-12 col-md-12 col-sm-12 col-xs-12">
                       					<table class="table">
                       						<colgroup>
                       							<col style="background-color:#F5F5F5;border-top: 2px solid #D45466;">
                       							<col />
                       						</colgroup>
                       						<tbody>
                       							<tr><td style="width:150px;">Use Id</td><td style="text-align: right !important;"><span id="username">Prakvirak</span></td></tr>
                       							<tr><td>Type</td><td style="text-align: right !important;"><span id="account_type">Admin</span></td></tr>
                       							<tr><td>Register by</td><td style="text-align: right !important;"><a href="#none" id="reg_co_nm">Kry sophanatt</a><input type="hidden" value="" id="reg_co_id"></td></tr>
                       							<tr><td>Date Register</td><td style="text-align: right !important;"><span id="reg_dtt">10 Oct 2014</span></td></tr>
                       						</tbody>
                       					</table>
                       				</div>
                       			</div>
                        </div>
                    </div>
					
                </div>
				


            </div>
            <!-- /.container-fluid -->

        </div>
        <!-- /#page-wrapper -->
        <!-- model change password -->
        <div class="modal fade" id="myModal" role="dialog">
		    <div class="modal-dialog">
		    
		      <!-- Modal content-->
		      <div class="modal-content">
		        <div class="modal-header">
		          <button type="button" class="close" data-dismiss="modal">&times;</button>
		          <h4 class="modal-title">Change Password</h4>
		        </div>
		        <!-- //modal body -->
		        <div class="modal-body">	
		        	 <div>
		        	 	<div class="form-group required">
					      <input id="old_pass" type="password" class="form-control has-error" placeholder="Old Password" aria-describedby="basic-addon1">
					    </div>
					      <br/>
					      <div class="form-group required">
					      	<input id="new_pass" type="password" class="form-control" placeholder="New Password" aria-describedby="basic-addon1">
					      </div>
					      <br/>
					      <div class="form-group required">
					      	<input id="conf_new_pass" type="password" class="form-control" placeholder="Confirm Password" aria-describedby="basic-addon1">
					      </div>
				      </div>				    
		        </div>
		        <!-- //modal body -->
		        <div class="modal-footer">
		        <a href="#none" class="btn btn-primary" id="btn_change_pass_confirm">Confirm change</a>
		          <button type="button" class="btn btn-default" data-dismiss="modal">Close</button>
		        </div>
		      </div>
		      
		    </div>
		 </div>
		 <!-- //model change password -->
		 
		 <!-- model change user name -->
        <div class="modal fade" id="user_change" role="dialog">
		    <div class="modal-dialog">
		    
		      <!-- Modal content-->
		      <div class="modal-content">
		        <div class="modal-header">
		          <button type="button" class="close" data-dismiss="modal">&times;</button>
		          <h4 class="modal-title">Change user name</h4>
		        </div>
		        <!-- //modal body -->
		        <div class="modal-body">	
		        	 <div>
		        	 	<div class="form-group required">
					      <input id="change_user_nm" type="text" class="form-control has-error" placeholder="New User Name" aria-describedby="basic-addon1">
					    </div>
					      <br/>
					      <div class="form-group required">
					      	<input id="user_nm_change_password" type="password" class="form-control" placeholder="Password" aria-describedby="basic-addon1">
					      </div>
					     
				      </div>				    
		        </div>
		        <!-- //modal body -->
		        <div class="modal-footer">
		        <a href="#none" class="btn btn-primary" id="btn_change_username_confirm">Confirm change</a>
		          <button type="button" class="btn btn-default" data-dismiss="modal">Close</button>
		        </div>
		      </div>
		      
		    </div>
		 </div>
		 <!-- //model change password -->
		 
		 <!-- model view register-->
        <div class="modal fade" id="reg_modal" role="dialog">
		    <div class="modal-dialog">
		    	
		      <!-- Modal content-->
		      <div class="modal-content">
		       <button type="button" id="modal_close" class="close" style="position: absolute;right: 5px;z-index: 100; cursor: pointer;">&times;</button>
		        <!-- //modal body -->
		        <div class="modal-body">	
		        	 <div class="row">
		        	 	<div class="col-lg-4 co-sm-4 col-md-4 col-xs-4">
		        	 		<img src="/controller/resources/img/png/user_default.png" class="img-responsive">
		        	 	</div>
		        	 	<div class="col-lg-8 co-sm-8 col-md-8 col-xs-8">
		        	 		<div style="margin-bottom: 5px;padding-bottom:3px; border-bottom:1px 1px solid #fff;">
		        	 			<div><span style="color: #136686;font-weight: bold;" id="view_reg_co_nm"></span></div>
		        	 			<div><span style="color: #878788;" id="view_reg_co_brand"></span></div>
		        	 		</div>
		        	 		
		        	 		
		        	 		<div><span class="glyphicon glyphicon-phone" style="margin-right:3px;"></span><span id="view_reg_co_phone"></span></div>
		        	 		<div><span class="glyphicon glyphicon-earphone" style="margin-right:3px;"></span><span id="view_reg_co_cmp_phone"></span></div>
		        	 		<div><span style="margin-right:3px;">Address :  </span><span id="view_reg_address"></span></div>
		        	 	</div>
		        	 	
				      </div>				    
		        </div>
		        <!-- //modal body -->
		        <div class="modal-footer" style="background-color: #EEF0F5;">
		          <button type="button" class="btn btn-default btn-sm" data-dismiss="modal">Close</button>
		        </div>
		      </div>
		      
		    </div>
		 </div>
		 <!-- //model view register -->
      
		  

    </div>
    
<!-- Code snippet -->

    
    <!-- script -->
   <%@include file="include/_script.jsp"%>
    <script type="text/javascript">
		var BASE_URL = "${pageContext.request.contextPath}";
		var PAGE_ID="${page_id}";
	</script>
    <script src="${pageContext.request.contextPath}/resources/js/page/account_setting.js"></script>

</body>

</html>
