<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page session="false" %>
<!DOCTYPE html>

<html lang="en">

<head>

    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <meta name="description" content="">
    <meta name="author" content="">

    <title>Loan Agreement System</title>
	<script type="text/javascript">
    	var BASE_URL="${pageContext.request.contextPath}";
    </script>
    
		<!-- jQuery -->
    <script src="${pageContext.request.contextPath}/resources/js/jquery.js"></script>
    
    <!-- Bootstrap Core CSS -->
    <link href="${pageContext.request.contextPath}/resources/css/bootstrap.min.css" rel="stylesheet">
    <!-- Custom CSS -->
    <link href="${pageContext.request.contextPath}/resources/css/sb-admin.css" rel="stylesheet">

    <!-- Morris Charts CSS -->
    <link href="${pageContext.request.contextPath}/resources/css/plugins/morris.css" rel="stylesheet">

    <!-- Custom Fonts -->
    <link href="${pageContext.request.contextPath}/resources/font-awesome/css/font-awesome.min.css" rel="stylesheet" type="text/css">
    
    <!-- Loan approval javascript  -->  
    <script src="${pageContext.request.contextPath}/resources/js/loan_approval.js"></script>
    
     <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/resources/css/v_costomize.css">
     <style type="text/css">
     	table tr th{
     		    background-color: #638BE0 !important;
    			color: #fff;
     	}
     </style>
    <%--  <%
	int tr_id = Integer.parseInt(request.getParameter("tr_id"));
	int cu_id = Integer.parseInt(request.getParameter("cu_id")); 
	 %> --%>
     </head>

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
					<form rol="form" class="form-horizontal"> 
					<div class="col-lg-12">
						
							<div class="row">
								<div class="col-lg-6 col-md-6">
									<div class="form-group">
										 
										<label class="control-label col-sm-4" for="paid_amount" name="paid_amount"> Paid Amount:</label>
										<div class="col-sm-8">
										  <input type="text" class="form-control" id="paid_amount" placeholder="0.0">
										</div>
									</div>
									<div class="form-group">
										<label class="control-label col-sm-4" for="amount-fine" name="amount_fine">Amount fine:</label>
										<div class="col-sm-8">
										  <input type="text" class="form-control" id="amount_fine" placeholder="0.0">
										</div>
									</div>
									
									<div class="form-group">
										<label class="control-label col-sm-4" for="amount_fine" name="tr_type">Transection Type:</label>
										<div class="col-sm-8" >
										  <select class="form-control" id="tr_type">
											<option>--select--</option>
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
						</form>
					</div>
                </div>
				<!-- //list -->


            </div>
            <!-- /.container-fluid -->

        </div>
        <!-- /#page-wrapper -->

    </div> 
</body>

</html>
