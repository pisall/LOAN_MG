<%@include file="include/_head.jsp"%>


<body>
<style>
	.margin-right5{
		margin-right:5px;
	}
	
	 .table.table-profile th, .table.table-profile td { 
        border-top: none !important;
        border-left: none !important;
        border-bottom:1px dashed #E9E9E9;
    }
    .table.table-profile td>span.glyphicon{ 
      	color:#136686;
      	padding-right:5px;
      	left:-5px;
    }
    .contain-profile{
    	width: 100px;
	    height: 100px;
	    padding:3px;
	    position: absolute;
	    right: 22px;
	    background: #FFFFFF;
	    top: -50px;
	    /* border: 1px solid #FFF; */
	    border: 1px solid #E9E9E9;
    }
    .contain-profile div.img{
    	width:100%;
    	height: 100%;
    	background-color: #8A8787;
    }
    .sticker{
    	position: absolute;
	    font-size: 30px;
	    color: #D45466;
	    top: -16px;
	    left: -17px;
	    z-index: 0;
    }
    .circle{
	    position: absolute;
	    z-index: 2;
	    font-size: 12px;
	    color: #D45466;
	    top: 5px;
	    left: 5px;
    }
    .profile-box{
     	z-index: 1;
	    position: relative;
	    box-shadow: 0px 0px 5px #8A8787;
	    border: none;
    
    }
    .edit{
    	float: right;
	    position: relative;
	    top: -22px;
	    right: 5px;
	    cursor: pointer;
	    font-size: 15px;
	    color: #C5DADD;
    }
    .edit:hover{
    	color:#136686;
    	font-size: 18px;
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
                            Mr.Prak Virak
                        </h2>
                        
                        	
                        
                 
                        <div style="position: relative;">
                        	<span class="glyphicon glyphicon-tag sticker">
                        	
                        	</span>
                        	<span class="glyphicon glyphicon-cd circle"></span>
                        	<div class="contain-profile" style="z-index:2">
                        		<div class="img">
                        			<img style="width:100%" alt="" src="${pageContext.request.contextPath}/resources/img/default_profile.jpg">
                        		</div>
                        	</div>
                        	<div class="panel panel-default profile-box" style="z-index: 1;position: relative;">
                        		<div class="panel-body">
		                        	<table class="table table-profile">
										
										<tbody>
											
											
											<tr><td><span class="lyphicon glyphicon-minus margin-right5"></span>Date of Birth</td><td><span id="co_dob"></span></td></tr>
											<tr><td><span class="lyphicon glyphicon-minus margin-right5"></span>Place of birth</td><td><span id="co_pb_address"></span></td></tr>
											<tr><td><span class="lyphicon glyphicon-minus margin-right5"></span>National ID</td><td><span id="co_national_id"></span></td></tr>
											<tr><td style="width:150px"><span class="lyphicon glyphicon-minus margin-right5"></span>Brand</td><td><span id="co_brand"></span></td></tr>
											<tr><td><span class="lyphicon glyphicon-minus margin-right5"></span>Mobile Phone</td><td><span id="co_phone"></span></td></tr>
											<tr><td><span class="lyphicon glyphicon-minus margin-right5"></span>Office Phone</td><td><span id="co_office_phone"></span></td></tr>
											
											<tr><td><span class="lyphicon glyphicon-minus margin-right5"></span>Address</td><td><span id="co_address"></span></td></tr>
											<tr><td><span class="lyphicon glyphicon-minus margin-right5"></span>Register Date</td><td><span id="co_reg_dtt"></span></td></tr>
											<tr><td><span class="lyphicon glyphicon-minus margin-right5"></span>Register By</td><td><span id="co_reg_nm"></span></td></tr>
											<tr><td><span class="lyphicon glyphicon-minus margin-right5"></span>update Date</td><td><span id="co_update_dtt"></span></td></tr>
										</tbody>
									</table>
								</div>
								<a href="#none" class="edit" id="btn_edit_mod"><span class="glyphicon glyphicon-edit"></span></a>
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
		console.log("ppp="+PAGE_ID);
	</script>
    <script src="${pageContext.request.contextPath}/resources/js/page/profile_detail.js"></script>

</body>

</html>
