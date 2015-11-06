	<%@include file="include/_head.jsp"%>
	
	<link href="${pageContext.request.contextPath}/resources/css/form-elements.css" rel="stylesheet">
	<link href="${pageContext.request.contextPath}/resources/css/login-style.css" rel="stylesheet">

    </head>

    <body>

        <!-- Top content -->
        <div class="top-content">
        	
            <div class="inner-bg">
                <div class="container">
                    <div class="row">
                        <div class="col-sm-8 col-sm-offset-2 text">
                            <h1><strong>Loan System Management</strong> Login Form</h1>
                            
                        </div>
                    </div>
                    <div class="row">
                        <div class="col-sm-6 col-sm-offset-3 form-box">
                        	<div class="form-top">
                        		<div class="form-top-left">
                        			<h3>Login to our site</h3>
                            		<p>Enter your username and password to log on:</p>
                        		</div>
                        		<div class="form-top-right">
                        			<i class="fa fa-key"></i>
                        		</div>
                        		<c:if test="${param.error != null}">
                        		<div class="row">
                        			<div class="col-lg-12 col-md-12 col-sm-12 col-xs-12">
                        				<div class="alert alert-danger" role="alert">
                        					<a href="#" class="close" data-dismiss="alert" aria-label="close" title="close">×</a>
											<span class="glyphicon glyphicon-exclamation-sign" aria-hidden="true"></span>
											<span class="sr-only">Error:</span>
											 Enter invalid account
										</div>
                        			</div>
                        		</div>
                        		</c:if>
                        		
                        		<c:if test="${param.logout != null}">
                        			<div class="row">
                        			<div class="col-lg-12 col-md-12 col-sm-12 col-xs-12">
                        				<div class="alert alert-success" role="alert">
                        					<a href="#" class="close" data-dismiss="alert" aria-label="close" title="close">×</a>
										  	<span class="glyphicon glyphicon-exclamation-sign" aria-hidden="true"></span>
										  	You have been logged out successfully.
										</div>
                        			</div>
                        		</div>
								</c:if>
                        		
                            </div>
                            <c:url var="loginUrl" value="/login" />
                            <div class="form-bottom">
                            	
			                    <form role="form" action="${loginUrl }" method="post" class="login-form">
			                    	<div class="form-group">
			                    		<label class="sr-only" for="form-username">Username</label>
			                        	<input type="text" id="ssoId" name="ssoId" placeholder="Username..." class="form-username form-control" id="form-username">
			                        </div>
			                        <div class="form-group">
			                        	<label class="sr-only" for="form-password">Password</label>
			                        	<input type="password" id="password" name="password" placeholder="Password..." class="form-password form-control" id="form-password">
			                        </div>
			                        <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}" />
			                        <button type="submit" class="btn">Login</button>
			                    </form>
		                    </div>
		                    
                        </div>
                    </div>
                   
                </div>
            </div>
            
        </div>

		<%@include file="include/_script.jsp"%>
       
    </body>

</html>