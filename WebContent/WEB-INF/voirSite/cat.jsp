<%@page import="model.*"%>
<%@page import="factory.*"%>
<%@page import="dao.*"%>
<%@page import='java.util.*'%>
<!DOCTYPE html>
<html lang="en">

<head>

</head>
<%
	DAO<?> u = DAOFactory.getCatDAO();
	ArrayList<Cat> liste = (ArrayList<Cat>) u.get_all();	
	int taille = liste.size();
%>
<body id="page-top">

	<!-- Header -->
	<header class="masthead bg-primary text-white text-center">
		
			<h2>Choix de la catégorie :</h2>
			<% for(int i = 0;i<taille;i++){ %>
			<form method='post' action="ControlleurSite">
			<div class="container">
			<button type="button" class="btn btn-primary btn-lg"><%=liste.get(i).get_nom() %></button></div><br></form><%} %>
			
	</header>

	<!-- Scroll to Top Button (Only visible on small and extra-small screen sizes) -->
	<div class="scroll-to-top d-lg-none position-fixed ">
		<a class="js-scroll-trigger d-block text-center text-white rounded"
			href="#page-top"> <i class="fa fa-chevron-up"></i>
		</a>
	</div>

	<!-- Bootstrap core JavaScript -->
	<script src="vendor/jquery/jquery.min.js"></script>
	<script src="vendor/bootstrap/js/bootstrap.bundle.min.js"></script>

	<!-- Plugin JavaScript -->
	<script src="vendor/jquery-easing/jquery.easing.min.js"></script>
	<script src="vendor/magnific-popup/jquery.magnific-popup.min.js"></script>

	<!-- Contact Form JavaScript -->
	<script src="js/jqBootstrapValidation.js"></script>
	<script src="js/contact_me.js"></script>

	<!-- Custom scripts for this template -->
	<script src="js/freelancer.min.js"></script>

</body>

</html>