<%@page import="java.util.Date"%>
<%@page import="java.text.SimpleDateFormat"%>
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
    <!-- Bootstrap Core CSS -->
    <link href="${pageContext.request.contextPath}/resources/css/bootstrap.min.css" rel="stylesheet">
    <!-- Custom CSS -->
    <link href="${pageContext.request.contextPath}/resources/css/sb-admin.css" rel="stylesheet">

    <!-- Morris Charts CSS -->
    <link href="${pageContext.request.contextPath}/resources/css/plugins/morris.css" rel="stylesheet">

    <!-- Custom Fonts -->
    <link href="${pageContext.request.contextPath}/resources/font-awesome/css/font-awesome.min.css" rel="stylesheet" type="text/css">
    <!-- Loan Report javascript  --> 
    <script type="text/javascript"> src="${pageContext.request.contextPath}/resources/js/loanAgreement_Report.js" </script>
    
    
     <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/resources/css/v_costomize.css">
     <style type="text/css">
     	table tr th{
     		    background-color: #638BE0 !important;
    			color: #fff;
     	}
     </style>


 	<!-- jQuery -->
    <script src="${pageContext.request.contextPath}/resources/js/jquery.js"></script>

    <!-- Bootstrap Core JavaScript -->
    <script src="${pageContext.request.contextPath}/resources/js/bootstrap.min.js"></script>
    
    <!-- Jquery Confirm -->
    <script src="${pageContext.request.contextPath}/resources/js/jquery.confirm.min.js"></script>
    
    <script src="${pageContext.request.contextPath}/resources/js/plugins/morris/raphael.min.js"></script>
    
     <script src="${pageContext.request.contextPath}/resources/js/plugins/morris/morris.min.js"></script>
     
 	<!-- Reprot schadule payment  -->
     <script src="${pageContext.request.contextPath}/resources/js/report_payment.js"></script>
     
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
					
                        <h2 class="page-header" style="text-align:center;">
                             Schedule Payments
                        </h2> 
                    </div>
					
                </div>
				<!--//Page Heading -->
				<%
				Date  now = new Date();
				SimpleDateFormat date = new SimpleDateFormat("dd/MM/yyyy");
				
				String datetime = date.format(now);
				%>
				<!-- list-->
				<div class="row">					
                    <div class="col-lg-12">
						<!-- panel top-->
						<div class="panel panel-default">						
						<c:forEach var ="entry" items="${Customer}">
							<div class="panel panel-heading">
								<div class="row">
									<div class="col-md-4"> 
										<table class="table">
											<tbody>
											  <tr>
												<td style="border:0px">Customer Name :</td>
												<td style="border:0px">${entry.cu_nm}</td>
											  </tr>
											  <tr>
												<td>Date Time :</td>
												<td><%=datetime %></td>
											  </tr>
											  <tr>
												<td>Address :</td>
												<td>${entry.cu_address}</td>
											  </tr>
											 
											</tbody>
										</table>
											
									</div>
									<div class="col-md-4">
										<table class="table">
											
											<tbody>
											  <tr>
												<td style="border:0px">Loan Period :</td>
												<td style="border:0px">${entry.ac_period} &nbsp; ${entry.ac_period_type}</td>
											  </tr>
											  <tr>
												<td>Full Amont :</td>
												<td>${entry.ac_amount} R</td>
											  </tr>
											  <tr>
												<td>Part of Loan:</td>
												<td></td>
											  </tr>
											 
											</tbody>
										</table>
											
									</div>
									<div class="col-md-4">
											<table class="table">
											
											<tbody>
											  <tr>
												<td style="border:0px">Customer Officer IDP :</td>
												<td style="border:0px">${entry.co_id}</td>
											  </tr>
											  <tr>
												<td>Customer offer Name :</td>
												<td>${entry.co_first_nm} &nbsp; ${entry.co_last_nm}</td>
											  </tr>
											  <tr>
												<td>Customer offer Phone :</td>
												<td>${entry.co_phone} &nbsp; ${entry.co_cpm_phone}</td>
											  </tr>
											 
											</tbody>
										</table>
									 
									</div>
								</div>
							
							</div>
						</c:forEach>	
							<!-- panel body -->
							<div class="panel panel-body"> 
								<div class="table-responsive">
									<table class="table table-hover table-striped">
										<thead>
											<tr class="tr-heading">
												<th>No</th>
												<th>Date Time</th>
												<th>Day</th>
												<th>Full Amount</th>
												<th>Save Amount</th>
												<th>Pay Amount</th>
												<th>Balance</th>
												<th>Status</th>
												
											</tr>
										</thead>
										<tbody>
										
										<c:forEach items="${list}" var="entry" varStatus="idcount">
											<tr class="tr-safe" >
												<td>${idcount.count}</td>
												<td>${entry.pay_date}</td>
												<td>${entry.pay_day}</td>
												<td>${entry.tr_origin_amount}</td>
												<td>${entry.tr_save_payment}</td>
												<td>${entry.tr_pay_amount}</td>
												<td>${entry.tr_balance}</td>
												 
												<td onclick="transaction_payment('${entry.tr_id}','${entry.cu_id}');">
												
												<c:choose>
												  <c:when test="${entry.tr_stts=='1'}">
												    <a href="#"> <img alt="" src="${pageContext.request.contextPath}/resources/img/transaction.png" width="35px" height="25px"></a>
												  </c:when>
												  <c:when test="${entry.tr_stts=='2'}">
												     <a href="#"> <img alt="" src="${pageContext.request.contextPath}/resources/img/done.png"  width="35px" height="25px"></a>
												  </c:when>
												  <c:when test="${entry.tr_stts=='3'}">
												     <a href="#"> <img alt="" src="${pageContext.request.contextPath}/resources/img/area.png"  width="35px" height="25px"></a>
												  </c:when>
												  <c:when test="${entry.tr_stts=='4'}">
												    <a href="#"> <img alt="" src="${pageContext.request.contextPath}/resources/img/fullpay.png" width="35px" height="25px"></a>
												  </c:when>
												  <c:otherwise> 
												  </c:otherwise>
												</c:choose> 
 
												</td> 
											</tr>
										</c:forEach> 
											
										</tbody>
									</table>
								</div>
								
							</div>
							<!-- //panel body -->
							
						</div>
						
						<!--//panel top -->
                        
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
