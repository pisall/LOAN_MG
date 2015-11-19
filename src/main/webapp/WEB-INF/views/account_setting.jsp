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
                            Mr.Prak Virak
                        </h2>
                        
                        	
                        
                 
                        <div style="position: relative;">
                        	<!-- Single button -->
							<div class="btn-group" style="position: absolute; right:0px;">
							  <button type="button" class="btn btn-default dropdown-toggle" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
							    Action <span class="caret"></span>
							  </button>
							  <ul class="dropdown-menu dropdown-menu-right" >
							    <li><a href="#">Change user name</a></li>
							    <li><a href="#">Change password</a></li>
							   
							  </ul>
							</div>
                        	<div class="panel panel-default">
                        		<div class="panel-body">
                        			<div class="row">
                        				<div class="col-lg-12 col-md-12 col-sm-12 col-xs-12">
                        					<label>User Name &nbsp; : </label>
                        					<span >prakvirak2</span>
                        				</div>
                        				
                        				
                        			</div>
		                        	
								</div>
								
							</div>
							
                        
                        </div>
                        
                        
                        
                    </div>
					
                </div>
				


            </div>
            <!-- /.container-fluid -->

        </div>
        <!-- /#page-wrapper -->
      
		  

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
