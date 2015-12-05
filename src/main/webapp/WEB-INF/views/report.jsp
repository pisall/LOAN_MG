<%@include file="include/_head.jsp"%>

<body>
	
		<div id="page-wrapper">

			<div class="container-fluid">

				<!-- Page Heading -->
				<div class="row">

					<div class="col-lg-12">

						<h2 class="page-header" style="text-align: center;">
							
							Schedule Payments
						</h2>
						<span> </span>
					</div>

				</div>
				<!--//Page Heading -->

				<!-- list-->
				<div class="row">
					<div class="col-lg-12">
						<!-- panel top-->
						<div class="panel panel-default">
							<c:forEach var="entry" items="${Customer}">
								
								<div class="panel panel-heading">
									<div class="row">
										<div class="col-md-4 col-sm-4 col-xs-4">
											<input type="hidden" value="${entry.cu_id}" id="TR_CU_ID">
											<table class="table">
												<tbody>
													<tr>
														<td style="border: 0px">Customer No :</td>
														<td style="border: 0px">${entry.cu_id}</td>
													</tr>
													<tr>
														<td style="border: 0px">Customer Name :</td>
														<td style="border: 0px">${entry.cu_nm}</td>
													</tr>
													<tr>
														<td>Phone:</td>
														<td>${entry.cu_phone}</td>
													</tr>
													<tr>
														<td>Date Time :</td>
														<td><%=datetime%></td>
													</tr>
													<tr>
														<td>Address :</td>
														<td>${entry.cu_address}</td>
													</tr>

												</tbody>
											</table>

										</div>
										<div class="col-md-4 col-sm-4 col-xs-4">
											<table class="table">

												<tbody>
													<tr>
														<td style="border: 0px">Loan Period :</td>
														<td style="border: 0px">${entry.ac_period}&nbsp;
															${entry.ac_period_type} </td>
													</tr>
													<tr>
														<td>Full Amount :</td>
														<td><fmt:formatNumber value="${entry.ac_amount}"
																type="currency" currencySymbol="R"
																pattern=" #,##0.00 ¤; -#,##0.00 ¤" /></td>

													</tr>
													<tr>
														<td>Part of Loan:</td>
														<td></td>
													</tr>

												</tbody>
											</table>

										</div>
										<div class="col-md-4 col-sm-4 col-xs-4">
											<table class="table">

												<tbody>
													<tr>
														<td style="border: 0px">CO IDP :</td>
														<td style="border: 0px">${entry.co_id}</td>
													</tr>
													<tr>
														<td>CO Name :</td>
														<td>${entry.co_first_nm}&nbsp;${entry.co_last_nm}</td>
													</tr>
													<tr>
														
														<td>CO Phone :</td>
														<td>${entry.co_phone}&nbsp; ${entry.co_cpm_phone}</td>
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
										<thead class="style2">
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

												<tr>
													<td>${idcount.count}</td>
													<td>${entry.date_pay}</td>
													<td>${entry.pay_day}</td>
													<td><fmt:formatNumber
															value="${entry.tr_origin_amount}" type="currency"
															currencySymbol="R" pattern=" #,##0.00 ¤; -#,##0.00 ¤" />
													</td>
													<td><fmt:formatNumber value="${entry.tr_save_payment}"
															type="currency" currencySymbol="R"
															pattern=" #,##0.00 ¤; -#,##0.00 ¤" /></td>
													<td><fmt:formatNumber value="${entry.tr_pay_amount}"
															type="currency" currencySymbol="R"
															pattern=" #,##0.00 ¤; -#,##0.00 ¤" /></td>
													<td> <fmt:formatNumber value="${entry.tr_balance}"
															type="currency" currencySymbol="R"
															pattern=" #,##0.00 ¤; -#,##0.00 ¤" /></td>

													<td onclick="transaction_payment('${entry.tr_id}','${entry.cu_id}','${entry.tr_stts}');" >

														<c:choose>
															<c:when test="${entry.tr_stts=='1'}">
																<a href="#"> <img  alt=""
																	src="${pageContext.request.contextPath}/resources/img/transaction.png"
																	width="35px" height="25px"></a>
															</c:when>
															<c:when test="${entry.tr_stts=='2'}">
																<a href="#"> <img alt=""
																	src="${pageContext.request.contextPath}/resources/img/done.png"
																	width="35px" height="25px"></a>
															</c:when>
															<c:when test="${entry.tr_stts=='3'}">
																<a href="#"> <img class='img_late'   alt=""
																	src="${pageContext.request.contextPath}/resources/img/area.png"
																	width="35px" height="25px"></a>
															</c:when>
															<c:when test="${entry.tr_stts=='4'}">
																<a href="#"> <img alt=""
																	src="${pageContext.request.contextPath}/resources/img/fullpay.png"
																	width="35px" height="25px"></a>
															</c:when>
															<c:otherwise>
															</c:otherwise>
														</c:choose> <c:choose>
															<c:when test="${entry.tr_stts=='3'}">
																<input type="hidden" value="${entry.tr_pay_amount}"
																	class="amount">
															</c:when>
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
	<!-- </div>
 -->
	<%@include file="include/_script.jsp"%>

	<!-- Loan Report javascript  -->
	<script type="text/javascript">
		src = "${pageContext.request.contextPath}/resources/js/loanAgreement_Report.js"
	</script>
	<!-- Reprot schadule payment  -->
	

	<script type="text/javascript">
		var BASE_URL = "${pageContext.request.contextPath}";
		var PAGE_ID = "${page_id}";
		console.log("ppp=" + PAGE_ID);
		var total = 0;
		
		// send parametter to loanApprove
		function transaction_payment(tr_id,cu_id,tr_stts){	
			location.href=BASE_URL+"/schadule_payment/loanApprove?tr_id="+tr_id+"&cu_id="+cu_id+"&tr_stts="+tr_stts; 
		} 
	</script>

	

</body>

</html>
