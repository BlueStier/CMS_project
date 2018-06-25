<%@page import="model.*"%>
<%@page import="factory.*"%>
<%@page import="dao.*"%>
<%@page import='java.util.*'%>
<!DOCTYPE html>
<html lang="fr">

<head>

<meta charset="utf-8">
<meta name="viewport"
	content="width=device-width, initial-scale=1, shrink-to-fit=no">
<meta name="description" content="">
<meta name="author" content="BlueStier">

<title>Site de visu du CMS_Project</title>

<!-- Bootstrap core CSS -->
<link href="ressources/theme1/vendor/bootstrap/css/bootstrap.min.css"
	rel="stylesheet">
<%
	DAO<?> u = DAOFactory.getThemesDAO();
	ArrayList<Themes> liste = (ArrayList<Themes>) u.get_all();
	String t = "";
	int taille = liste.size();
	for (int i = 0; i < taille; i++) {
		if (liste.get(i).is_courant()) {
			t = liste.get(i).get_path();
		}
	}
	session.setAttribute("css", t);
	int v = 0;
	if (session.getAttribute("voir") != null) {
		v = Integer.parseInt(session.getAttribute("voir").toString());
	}
%>
<!-- Custom fonts for this template -->
<link href="<%=session.getAttribute("css")%>" rel="stylesheet"
	type="text/css">
<link href="https://fonts.googleapis.com/css?family=Montserrat:400,700"
	rel="stylesheet" type="text/css">
<link
	href="https://fonts.googleapis.com/css?family=Lato:400,700,400italic,700italic"
	rel="stylesheet" type="text/css">

<!-- Plugin CSS -->
<link href="ressources/theme1/vendor/magnific-popup/magnific-popup.css"
	rel="stylesheet" type="text/css">

<link href="<%=session.getAttribute("css")%>" rel="stylesheet">
<link rel="shortcut icon" type="image"
	href="ressources/theme1/img/Flav_Quizz.png">

</head>

<body id="page-top">
	<form method='get' action="ControlleurSite">
		<!-- Navigation -->
		<nav
			class="navbar navbar-expand-lg bg-secondary fixed-top text-uppercase"
			id="mainNav">
			<div class="container">
				<!-- <img class="img-fluid mb-5 d-block mx-auto" src="img/logo_afpa.png" alt="">-->
				<a class="navbar-brand js-scroll-trigger" src="img/Logo_AFPA_2.png"
					href="http://localhost:8080/CMS_project/index.jsp"><img
					src="ressources/theme1/img/Flav_Quizz.png" alt="logo Afpa"></a>
				<button
					class="navbar-toggler navbar-toggler-right text-uppercase bg-primary text-white rounded"
					type="button" data-toggle="collapse"
					data-target="#navbarResponsive" aria-controls="navbarResponsive"
					aria-expanded="false" aria-label="Toggle navigation">
					Menu <i class="fa fa-bars"></i>
				</button>
				<div class="collapse navbar-collapse" id="navbarResponsive">
					<ul class="navbar-nav ml-auto">
						<li class="nav-item mx-0 mx-lg-1"><a
							class="nav-link py-3 px-0 px-lg-3 rounded js-scroll-trigger"
							href="ControlleurSite?1">Acceuil</a></li>
						<li class="nav-item mx-0 mx-lg-1"><a
							class="nav-link py-3 px-0 px-lg-3 rounded js-scroll-trigger"
							href="ControlleurSite?2">Articles</a></li>
						<li class="nav-item mx-0 mx-lg-1"><a
							class="nav-link py-3 px-0 px-lg-3 rounded js-scroll-trigger"
							href="ControlleurSite?3">Catégories</a></li>
					</ul>
				</div>
			</div>
		</nav>
	</form>
	<!-- Header -->
	<%
		if (v == 1) {
	%>
	<header class="masthead bg-primary text-white text-center">
		<h1 class="text-uppercase mb-0">Site de visu du CMS_Project</h1>
	</header>
	<%
		} else if (v == 3) {
	%>
	<jsp:include page='/WEB-INF/voirSite/cat.jsp' />
	<%
		} else if (v == 2) {
	%>
	<jsp:include page='/WEB-INF/voirSite/articles.jsp' />
	<%
		} else if (v == 4) {
			%>
			<jsp:include page='/WEB-INF/voirSite/connectInscrjsp.jsp' />
			<%
		} else {
	%>
	<header class="masthead bg-primary text-white text-center">
		<h1 class="text-uppercase mb-0">Site de visu du CMS_Project</h1>
	</header>
	<%
		}
	%>
	<!-- Scroll to Top Button (Only visible on small and extra-small screen sizes) -->
	<div class="scroll-to-top d-lg-none position-fixed ">
		<a class="js-scroll-trigger d-block text-center text-white rounded"
			href="#page-top"> <i class="fa fa-chevron-up"></i>
		</a>
	</div>

	<!-- Bootstrap core JavaScript -->
	<script src="ressources/theme1/vendor/jquery/jquery.min.js"></script>
	<script
		src="ressources/theme1/vendor/bootstrap/js/bootstrap.bundle.min.js"></script>

	<!-- Plugin JavaScript -->
	<script
		src="ressources/theme1/vendor/jquery-easing/jquery.easing.min.js"></script>
	<script
		src="ressources/theme1/vendor/magnific-popup/jquery.magnific-popup.min.js"></script>

	<!-- Contact Form JavaScript -->
	<script src="ressources/theme1/js/jqBootstrapValidation.js"></script>
	<script src="ressources/theme1/js/contact_me.js"></script>

	<!-- Custom scripts for this template -->
	<script src="ressources/theme1/js/freelancer.min.js"></script>

</body>

</html>