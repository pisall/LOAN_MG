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
                    
					<input type="hidden" id="tr_id" value="<%= request.getParameter("tr_id") %>"/>
					<input type="hidden" id="cu_id" value="<%= request.getParameter("cu_id") %>"/> 
					
                        <h2 class="page-header" style="text-align:center">
                            Loan Approval
                        </h2>
                        
                    </div>
					
                </div>
				
			
				<div class="row">	
					<div class="col-lg-12">
						<table class="table" style="background-color:#F5ECEC">
							<tbody id="customer_info">
								<!-- <tr>
									<td colspan="4" style="text-align:center;background-color:#FFF"><h4>Customer Infomation</h4></td>
								</tr>
								<tr>
									<td>Name : <span class="label label-primary">Prak Virak</span></td>
									<td>Sex : <span class="label label-primary">Male</span></td>
									<td>Phone : <span class="label label-primary">010 999-999</span></td>
									<td>National ID: <span class="label label-primary">834749839384</span></td>									
								</tr>

								<tr>
									<td colspan="4" style="text-align:center;background-color:#FFF;"><h4>Loan Information</h4></td>
								</tr>
								<tr>
									<td>Pay Type : <span class="label label-primary">week</span></td>
									<td>Total : <span class="label label-primary">1,938,383.00 R</span></td>
									<td>Date : <span class="label label-primary">12/12/2016</span></td>
									<td>Transaction Amount<br/>
										&nbsp;- Pay Amount : <span class="label label-primary">53,600.00</span><br/>
										&nbsp;- Balance : <span class="label label-primary">960,000.00</span>
									</td>									
								</tr>
								<tr>
									<td colspan="4" style="border:0px;">Pawn: <span class="label label-primary">Car</span></td>
								</tr>
								<tr>
									<td colspan="4" style="text-align:center;background-color:#FFF"><h4>Guarantor</h4></td>
								</tr>
								<tr>
									<td>Name : <span class="label label-primary">Prak Virak</span></td>
									<td>Sex : <span class="label label-primary">Male</span></td>
									<td>Phone : <span class="label label-primary">010 999-999</span></td>
									<td>National ID: <span class="label label-primary">0453453434</span></td>									
								</tr>
								<tr>								<tr>
									<td colspan="4" style="border:0px;">Pawn: <span class="label label-primary">Car</span></td>
								</tr> -->
							</tbody>
						</table>
						
					</div>
					<form  class="form-horizontal" id="form_approve"> 
					<div class="col-lg-12">
						
							<div class="row">
								<div class="col-lg-6 col-md-6">
									<div class="form-group">
										 
										<label class="control-label col-sm-4" for="paid_amount" > Paid Amount:</label>
										<div class="col-sm-8">
										  <input type="text" class="form-control check_number required" id="paid_amount" placeholder="0.0">
										</div>
									</div>
									<div class="form-group">
										<label class="control-label col-sm-4" for="amount-fine" >Amount fine:</label>
										<div class="col-sm-8">
										  <input type="text" class="form-control check_number required" id="amount_fine" placeholder="0.0">
										</div>
									</div>
									
									<div class="form-group">
										<label class="control-label col-sm-4" for="amount_fine" >Transection Type:</label>
										<div class="col-sm-8" >
										  <select class="form-control" id="tr_type">
											<option value="2">Complete</option>
											<option value="3">Area</option>
											<option value="4">Finished</option> 
										  </select>
										</div>
									</div>
								</div>
								<div class="col-lg-6 col-md-6">
									<div class="form-group">
										<label class="control-label col-sm-4" for="email">Note:</label>
										<div class="col-sm-8">
										  <textarea class="form-control" id="tr_note"></textarea>
										</div>
									</div>
									
									<div class="form-group">
										<label class="control-label col-sm-4" for="email"></label>
										<div class="col-sm-8">
										  <button type="button" id="btnApprovale" class="btn btn-primary btn-block">Approve</button>
										</div>
									</div>
									 
								</div>
							</div>
							</div>
						</form>
					</div>
                </div>
               
				<!-- //list -->


            </div>
            <!-- /.container-fluid -->

        </div>
        <!-- /#page-wrapper -->
        <%@include file="include/_script.jsp"%>

    <script src="${pageContext.request.contextPath}/resources/js/loan_approval.js"></script>
    <script type="text/javascript">
    	var BASE_URL="${pageContext.request.contextPath}";
    </script>
   
</body>

</html>
