<%@page import="model.*"%>

<!DOCTYPE html>

<html lang="fr">

<head>
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport"
	content="width=device-width, initial-scale=1, shrink-to-fit=no">
<meta name="description" content="">
<meta name="author" content="">
<title>CMS_project</title>
<!-- Bootstrap core CSS-->
<link href="ressources/theme2/vendor/bootstrap/css/bootstrap.min.css"
	rel="stylesheet">
<!-- Custom fonts for this template-->
<link
	href="ressources/theme2/vendor/font-awesome/css/font-awesome.min.css"
	rel="stylesheet" type="text/css">
<!-- Page level plugin CSS-->
<link
	href="ressources/theme2/vendor/datatables/dataTables.bootstrap4.css"
	rel="stylesheet">
<!-- Custom styles for this template-->
<link href="ressources/theme2/css/sb-admin.css" rel="stylesheet">
<link rel="shortcut icon" type="image"
	href="ressources/theme1/img/Flav_Quizz.png">
</head>

<body class="fixed-nav sticky-footer bg-dark" id="page-top">
	<%
		if (session.getAttribute("user") == null) {
			response.sendRedirect("/WebContent/index.jsp");
		} else {
			MODEL<?> u = (MODEL<?>) session.getAttribute("user");

			int v = 0;
			if (session.getAttribute("voir") != null) {
				v = Integer.parseInt(session.getAttribute("voir").toString());
			}
			int c = Integer.parseInt(session.getAttribute("comOK").toString());
	%>

	<!-- Navigation-->
	<nav class="navbar navbar-expand-lg navbar-dark bg-dark fixed-top"
		id="mainNav">
		<a class="navbar-brand" href="index.jsp">CMS_project by BlueStier</a>
		<button class="navbar-toggler navbar-toggler-right" type="button"
			data-toggle="collapse" data-target="#navbarResponsive"
			aria-controls="navbarResponsive" aria-expanded="false"
			aria-label="Toggle navigation">
			<span class="navbar-toggler-icon"></span>
		</button>
		<div class="collapse navbar-collapse" id="navbarResponsive">
			<ul class="navbar-nav navbar-sidenav" id="exampleAccordion">
				<jsp:include page='/WEB-INF/profils/admin.jsp' />

			</ul>
			<ul class="navbar-nav sidenav-toggler">
				<li class="nav-item"><a class="nav-link text-center"
					id="sidenavToggler"> <i class="fa fa-fw fa-angle-left"></i>
				</a></li>
			</ul>
			<ul class="navbar-nav ml-auto">
				<a class="navbar-brand">Hello <%=u.get_pseudo()%></a>
				<%
					if (c == 1) {
				%>
				<jsp:include page='/WEB-INF/comAModerer.jsp' />

				<%
					}
				%>
				<li class="nav-item"><a class="nav-link" data-toggle="modal"
					data-target="#exampleModal"> <i class="fa fa-fw fa-sign-out"></i>Déconnexion
				</a></li>
			</ul>
		</div>
	</nav>
	<div class="content-wrapper">		
		<%
			
			if (v == 5) {
		%>
		<jsp:include page='/WEB-INF/toutVoir/voirUser.jsp' />

		<%
			}

			else if (v == 9) {
		%>
		<jsp:include page='/WEB-INF/toutVoir/roles.jsp' />
		<%
			}

			else if (v == 13) {
		%>
		<jsp:include page='/WEB-INF/toutVoir/visiteur.jsp' />
		<%
			}

			else if (v == 17) {
		%>
		<jsp:include page='/WEB-INF/toutVoir/parametre.jsp' />
		<%
			}

			else if (v == 20) {
		%>
		<jsp:include page='/WEB-INF/toutVoir/visiteur.jsp' />


		<%
			}

			else if (v == 21) {
		%>
		<jsp:include page='/WEB-INF/toutVoir/Article.jsp' />

		<%
			}

			else if (v == 23) {
		%>
		<jsp:include page='/WEB-INF/toutVoir/cat.jsp' />


		<%
			}

			else if (v == 28) {
		%>
		<jsp:include page='/WEB-INF/toutVoir/commentaires.jsp' />

		<%
			}
			else {
				%>
		<jsp:include page='/WEB-INF/profils/synthese.jsp' />
		<%
			}
				
			}
		%>



	</div>
	<!-- /.container-fluid-->
	<!-- /.content-wrapper-->
	<footer class="sticky-footer">
		<div class="container">
			<div class="text-center">
				<small>Copyright © BlueStier 2018</small>
			</div>
		</div>
	</footer>
	<!-- Scroll to Top Button-->
	<a class="scroll-to-top rounded" href="#page-top"> <i
		class="fa fa-angle-up"></i>
	</a>
	<!-- Logout Modal-->
	<div class="modal fade" id="exampleModal" tabindex="-1" role="dialog"
		aria-labelledby="exampleModalLabel" aria-hidden="true">
		<div class="modal-dialog" role="document">
			<div class="modal-content">
				<div class="modal-header">
					<h5 class="modal-title" id="exampleModalLabel">Prêt à quitter?</h5>
					<button class="close" type="button" data-dismiss="modal"
						aria-label="Close">
						<span aria-hidden="true">×</span>
					</button>
				</div>
				<div class="modal-body">Cliquer sur "Logout" si vous souhaitez
					quitter</div>
				<div class="modal-footer">
					<button class="btn btn-secondary" type="button"
						data-dismiss="modal">Cancel</button>
					<a class="btn btn-primary" href="index.jsp">Logout</a>
				</div>
			</div>
		</div>
	</div>
	<!-- Bootstrap core JavaScript-->
	<script src="ressources/theme2/vendor/jquery/jquery.min.js"></script>
	<script
		src="ressources/theme2/vendor/bootstrap/js/bootstrap.bundle.min.js"></script>
	<!-- Core plugin JavaScript-->
	<script
		src="ressources/theme2/vendor/jquery-easing/jquery.easing.min.js"></script>
	<!-- Page level plugin JavaScript-->
	<script src="ressources/theme2/vendor/chart.js/Chart.min.js"></script>
	<script src="ressources/theme2/vendor/datatables/jquery.dataTables.js"></script>
	<script
		src="ressources/theme2/vendor/datatables/dataTables.bootstrap4.js"></script>
	<!-- Custom scripts for all pages-->
	<script src="ressources/theme2/js/sb-admin.min.js"></script>
	<!-- Custom scripts for this page-->
	<script src="ressources/theme2/js/sb-admin-datatables.min.js"></script>
	<script src="ressources/theme2/js/sb-admin-charts.min.js"></script>
	</div>
</body>

</html>
