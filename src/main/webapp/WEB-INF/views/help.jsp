<jsp:include page="include/_head.jsp" />

<body>

    <div id="wrapper">

        <!-- Navigation -->
        <nav class="navbar navbar-inverse navbar-fixed-top" role="navigation">
            <!-- Brand and toggle get grouped for better mobile display // logo at left top-->
            <div class="navbar-header">
                <button type="button" class="navbar-toggle" data-toggle="collapse" data-target=".navbar-ex1-collapse">
                    <span class="sr-only">Toggle navigation</span>
                    <span class="icon-bar"></span>
                    <span class="icon-bar"></span>
                    <span class="icon-bar"></span>
                </button>
                <a class="navbar-brand" href="index.html">SB Admin</a>
            </div>
            <!-- Top Menu Items -->
            <ul class="nav navbar-right top-nav">
                
                <li class="dropdown">
                    <a href="#" class="dropdown-toggle" data-toggle="dropdown"><i class="fa fa-user"></i> John Smith <b class="caret"></b></a>
                    <ul class="dropdown-menu">
                        <li>
                            <a href="#"><i class="fa fa-fw fa-user"></i> Profile</a>
                        </li>
                        <li>
                            <a href="#"><i class="fa fa-fw fa-envelope"></i> Inbox</a>
                        </li>
                        <li>
                            <a href="#"><i class="fa fa-fw fa-gear"></i> Settings</a>
                        </li>
                        <li class="divider"></li>
                        <li>
                            <a href="#"><i class="fa fa-fw fa-power-off"></i> Log Out</a>
                        </li>
                    </ul>
                </li>
            </ul>
            <!-- Sidebar Menu Items - These collapse to the responsive navigation menu on small screens -->
            <div class="collapse navbar-collapse navbar-ex1-collapse">
                <jsp:include page="include/_side_nav.jsp" />
            </div>
            <!-- /.navbar-collapse -->
        </nav>

        <div id="page-wrapper">

            <div class="container-fluid">

               
				<div class="row">					
                    <div class="col-lg-8 col-lg-offset-2">
						<div class="panel-group">
							<div class="panel panel-primary">
								<div class="panel-heading text-center">								
										<h3>Help</h3>
								</div>
								<div class="panel-body">
									We are the #1 Busiest Dental Clinic in the World.
									We are the 1st and Original Laser Teeth Whitening Clinic.
									Recommended by Top Government Officials and Stars.
									We have been on 100s of TV Channels and 1000s of TV Shows.
									DO NOT TRUST OUR COMPETITION.
									We have LICENSED DOCTORS THEY DO NOT.
									*Make One Payment of $22 and we will provide you with FREE
									Unlimited Laser White Smile Treatments for Lifetime.
									*100% Money Back Guarantee.
									-If you do not like our services we will give you your money back.
									*LIFETIME WARRANTY
									*NO PAIN & NO SIDE EFFECTS
									*Takes 20 to 40 Minutes
									PROMOTION ENDS: (FRIDAY) SEPTEMBER 18th 8pm
								</div>
							</div>
						</div>
					</div>
                        
				</div>
				<!-- //row -->
					
                </div>
				<!-- //list -->


            </div>
            <!-- /.container-fluid -->

        </div>
        <!-- /#page-wrapper -->

    </div>
    <!-- /#wrapper -->

    <!-- jQuery -->
    <script src="js/jquery.js"></script>

    <!-- Bootstrap Core JavaScript -->
   



</body>

</html>
