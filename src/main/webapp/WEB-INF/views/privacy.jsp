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
					
                    <div class="col-lg-12 col-md-12 col-sm-12 col-xs-12">
                        <h2 class="page-header" id="pro_nm">
                            <span id="co_nm">Privacy Setting</span>
                        </h2>
                    </div>
                  	<div class="col-lg-12 col-md-12 col-sm-12 col-xs-12">
                  		<span class="glyphicon glyphicon-pushpin"></span>
                  		<span>
                  		&nbsp;
                  		Allow other can edit profile
                  		</span>
                  		&nbsp;
					    <input type="checkbox" id="btn_switch_edit" data-size="normal">
					    
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
   
	<script src="${pageContext.request.contextPath}/resources/js/bootstrap-switch.js"></script>
    <script src="${pageContext.request.contextPath}/resources/js/page/privacy.js"></script>
     <script type="text/javascript">
		var BASE_URL = "${pageContext.request.contextPath}";
		var PAGE_ID="${page_id}";
		$("#btn_switch_edit").bootstrapSwitch();
		
	</script>

</body>

</html>
