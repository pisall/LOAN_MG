<%@include file="include/_head.jsp"%>
<style>
table{
    font-size: 12px
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
		<!-- End Navigation -->

		<div id="page-wrapper">

			<div class="container-fluid">

				<!-- Page Heading -->
				<div class="row">

					<div class="col-lg-12 col-md-12 col-sm-12 col-xs-12">				
						
						<h2 class="page-header" style="text-align: center;"><button style="float: left;" class="btn btn-primary" onclick=" return goBack('customer','home_customer');">
								<span style="width: 30px" class="glyphicon glyphicon-arrow-left"></span>
							</button> Loan Reports
							 </h2>
						<span >
							
						</span>
					</div>

				</div>
				<!--//Page Heading -->

				<!-- list-->
				<div class="row">
					
					<div class="col-lg-12 col-md-12 col-sm-12 col-xs-12">
						<div class="panel panel-default">
							
							<!-- panel body -->
							<div class="panel panel-body">
								<div class="table-responsive">
									<table class="table table-hover table-bordered">
										<thead class="style2">
											<tr class="active">											
												<th>Customer No</th>
												<th>Customer Name</th>
												<th>Payment Date</th>
												<th>Loan Amount</th>
												<th>Paid Amount</th>												
												<th>Amount Fine</th>
												<th>Days Late</th>											
												<th>Total Amount</th>
												<th>Officer Name</th>		
												<th>Officer Phone</th>																																	
											</tr>
										</thead>
										<tbody id="report_loan_late" >
											
										</tbody>
									</table>
									
								</div>
							</div>
							
							<!-- //panel body -->
						</div>								
					</div>
					
				</div>
				<!-- //list -->
				<div class="row">
					<div class="col-md-1 col-sm-1 col-lg-1 col-xs-1 id="select_num">
						<select class='form-control' id='record_num' style='width: 100%'>
							<option value='10'>10</option>
							<option value='15'>15</option>
							<option value='20'>20</option>
							<option value='25'>25</option>
							<option value='30'>30</option>
						</select>
					</div>
					<div class="col-md-11 col-sm-11 col-lg-11 col-sx-11" style="text-align: center;">
						<!-- <div class="col-md-6 col-md-offset-3" style="text-align: center"> -->
						<ul class="pagination" id="paging" style="margin: 0 auto;">
						</ul>
						<!-- </div> -->
					</div>

				</div>
			</div>
			<!-- /.container-fluid -->
		</div>
		<!-- /#page-wrapper -->
	</div>

	<%@include file="include/_script.jsp"%>
	<script type="text/javascript">
		var BASE_URL = "${pageContext.request.contextPath}";
		var PAGE_ID = "${page_id}";
		var id="<%=strCoId%>";
	</script>
	
	<script src="${pageContext.request.contextPath}/resources/js/report_late.js"></script>
</body>

</html>
