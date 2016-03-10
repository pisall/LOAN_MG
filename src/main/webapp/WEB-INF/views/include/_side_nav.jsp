<ul class="nav navbar-nav side-nav" id="nav">
	<li class="dashboard">
		<a href="${pageContext.request.contextPath}/">
			<i class="fa fa-fw fa-dashboard" style="font-size: 28px;"></i> Dashboard
		</a>
	</li>
	<li val="co_0003" >
		<a href="${pageContext.request.contextPath}/co_001_controller/co_0003">
			<span class="glyphicon glyphicon-user" aria-hidden="true"></span>
			&nbsp;Customer Officer(CO)
		</a>
	</li>
	<li val="customer_information">
		<a href="${pageContext.request.contextPath}/customer/home_customer">
			<span class="glyphicon glyphicon-user" aria-hidden="true"></span>&nbsp;Customer Information
		</a>
	</li>
	<li val="loan_agreement">
		<a	href="${pageContext.request.contextPath}/LoanAgreement/newLoanAgreement">
			<span class="glyphicon glyphicon-usd" aria-hidden="true"></span>&nbsp;Loan Agreement
		</a>
	</li>
	<li val="Income">
		<a href="${pageContext.request.contextPath}/Income/IncomeView">
			<span class="glyphicon glyphicon-usd" aria-hidden="true"></span>&nbsp;Month Income
		</a>
	</li>
	<li val="Outcome">
		<a href="${pageContext.request.contextPath}/Outcome/OutcomeView">
			<span class="glyphicon glyphicon-usd" aria-hidden="true"></span>&nbsp;Month	Outcome
		</a>
	</li>
	<li val="cont_7">
		<a href="#none"data-toggle="dropdown" class="dropdown-toggle">
			<span id="back_up" class="glyphicon glyphicon-usd" aria-hidden="true"></span>&nbsp;Report <span class="caret"></span>
		</a>
		<ul class="dropdown-menu">
			<li cont_name="cont_8" val="cont_7">
				 <a href="${pageContext.request.contextPath}/report/report_loan">Expend Report</a>
			</li>
			<li cont_name="cont_7" val="cont_7">
			 	<a href="${pageContext.request.contextPath}/report/report_late">Late Report</a>
			</li>
		</ul>
	</li>
<!-- 	<li val="cont_9"><a href="#"><span -->
<!-- 			class="glyphicon glyphicon-usd" aria-hidden="true"></span>&nbsp;Help</a> -->
<!-- 	</li> -->
</ul>
