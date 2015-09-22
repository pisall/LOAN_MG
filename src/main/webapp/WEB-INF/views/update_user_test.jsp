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
						<h1 class="page-header">
							Dashboard <small>Statistics Overview</small>
						</h1>
						<!--  <ol class="breadcrumb">
                            <li class="active">
                                <i class="fa fa-dashboard"></i> Dashboard
                            </li>
                        </ol> -->
					</div>
				</div>
				<%-- <a href="${pageContext.request.contextPath}/listUser" >List User</a> --%>
				<!-- /.row -->
				<div>
					<c:if test="${not empty listSpecificUser }">
						<h2>Update User</h2>
						<c:forEach items="${listSpecificUser}" var="user">				
						<form:form action="updateUser" method="get">
							<input type="hidden" value="${user.usID}" name="usID">
						NM :<input type="text" name="usNm" value="${user.usNm}" class="form-control">
							<br />
						Sex :<input type="text" name="usSex"  value="${user.usSex}" class="form-control">
							<br />
						Phone :<input type="text" name="usPhone" value="${user.usPhone}" class="form-control">
							<br />
						Email :<input type="text" name="usEmail" value="${user.usEmail}" class="form-control">
							<br />
						Address :<input type="text" name="usAddress" value="${user.usAddress}" class="form-control">
							<br />
							<input type="submit" value="add">
						</form:form>
						</c:forEach>
					</c:if>
				</div>

			</div>
			<!-- /.container-fluid -->

		</div>
		<!-- /#page-wrapper -->

	</div>
	<!-- /#wrapper -->

	<%@include file="include/_script.jsp"%>


</body>

</html>

