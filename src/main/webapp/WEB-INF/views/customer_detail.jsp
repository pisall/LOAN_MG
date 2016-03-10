
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


<!-- Modal -->
<div class="modal fade" id="myModal" role="dialog">
	<div class="modal-dialog modal-lg">
		<div class="modal-content">
			<!-- <div class="modal-header">
				<button type="button" class="close" data-dismiss="modal">&times;</button>
			</div> -->
			<div class="modal-body" style="text-align:center;">
				<div class="row">
					<div class="panel">
						<!-- <div class="panel-heading">Customer Detail Information</div> -->
						<div class="panel-body" style="padding:25px">
							<!-- <div class="table-responsive">
								<table class="table table-hover table-striped" id="customer_detail">
									<tr><th>ID</th><td id="cu_id"></td></tr>
									<tr><th>Name</th><td id="cu_name"></td></tr>
									<tr><th>Nickname</th><td id="cu_nick_name"></td></tr>
									<tr><th>Sex</th><td id="cu_sex"></td></tr>
									<tr><th>DOB</th><td id="cu_dob"></td></tr>
									<tr><th>National ID</th><td id="cu_national_id"></td></tr>
									<tr><th>Phone</th><td id="cu_phone"></td></tr>
									<tr><th>Address</th><td id="cu_address"></td></tr>
									<tr><th>Date Created</th><td id="cu_date_created"></td></tr>
									<tr><th>Note</th><td id="cu_note"></td></tr>
									<tr><th>Pawn</th><td id="cu_pawn"></td></tr>
								</table>
							</div> -->
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
										
											<tr><td style="width:150px"><span class="lyphicon glyphicon-minus margin-right5"></span>No</td><td><span id="cu_id"></span></td></tr>
											<tr><td><span class="lyphicon glyphicon-minus margin-right5"></span>Name</td><td><span id="cu_name"></span></td></tr>
											<tr><td><span class="lyphicon glyphicon-minus margin-right5"></span>Nickname</td><td><span id="cu_nick_name"></span></td></tr>
											<tr><td><span class="lyphicon glyphicon-minus margin-right5"></span>Sex</td><td><span id="cu_sex"></span></td></tr>
											<tr><td><span class="lyphicon glyphicon-minus margin-right5"></span>Date Of Birth</td><td><span id="cu_dob"></span></td></tr>
											<tr><td><span class="lyphicon glyphicon-minus margin-right5"></span>National ID</td><td><span id="cu_national_id"></span></td></tr>
											<tr><td><span class="lyphicon glyphicon-minus margin-right5"></span>Mobile Phone</td><td><span id="cu_phone"></span></td></tr>
											<tr><td><span class="lyphicon glyphicon-minus margin-right5"></span>Address</td><td><span id="cu_address"></span></td></tr>
											<tr><td><span class="lyphicon glyphicon-minus margin-right5"></span>Date Created</td><td><span id="cu_date_created"></span></td></tr>
											<tr><td><span class="lyphicon glyphicon-minus margin-right5"></span>Note</td><td><span id="cu_note"></span></td></tr>
											<tr><td><span class="lyphicon glyphicon-minus margin-right5"></span>Pawn</td><td><span id="cu_pawn"></span></td></tr>
										</tbody>
									</table>
								</div>
								<a href="#none" class="edit"><span class="glyphicon glyphicon-edit"></span>
                        		</a>
							</div>							                    
                        </div>
						</div>
					</div>
				</div>
			</div>
		</div>
	</div>
</div>

