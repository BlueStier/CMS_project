<%@page import="model.*"%>
<%@page import="factory.*"%>
<%@page import="dao.*"%>
<%@page import='java.util.*'%>
<!DOCTYPE html>
<html lang="en">


<%
	DAO<?> u = DAOFactory.getArticlesDAO();
	ArrayList<Articles> liste = (ArrayList<Articles>) u.get_all();
	int taille = liste.size();
	DAO<?> c = DAOFactory.getCommentairesDAO();
	ArrayList<Commentaires> listeC = (ArrayList<Commentaires>) c.get_all();
	int tailleC = listeC.size();
	if (session.getAttribute("visiteurs") != null) {

	}
%>
<body id="page-top">
	<header class="masthead bg-primary text-white ">
		<%
			if (session.getAttribute("visiteur") != null) {
				MODEL<?> p = (MODEL<Visiteurs>) session.getAttribute("visiteur");
		%>
		<div class="text-white">
			Bonjour
			<%=p.get_pseudo()%></div>
		<%
			}
			if (session.getAttribute("pseudo_or_mdp_error") != null) {
		%>
		<div class="text-white">
			<%=session.getAttribute("pseudo_or_mdp_error")%></div>
		<%
			}
			for (int i = 0; i < taille; i++) {
				if (liste.get(i).is_visible()) {
		%>
		<fieldset>
			<legend class="text-center"><%=liste.get(i).get_titre()%></legend>
			<%=liste.get(i).get_contenu()%>
			<%
				if (liste.get(i).is_commentaires()) {
			%>
			<fieldset>
				<legend class="text-center">Commentaires : </legend>
				<%
					for (int a = 0; a < tailleC; a++) {
									if (listeC.get(a).get_article().get_id() == liste.get(i).get_id()
											&& (listeC.get(a).is_mod() == false)) {
				%>
				<div class="text-center">
					Poster par :
					<%=listeC.get(a).get_visiteurs().get_pseudo()%>
					le :
					<%=listeC.get(a).get_date()%>
					<br><%=listeC.get(a).get_contenu()%></div>
				<%
					}
								}
				%>

				<form method='post' action="ControlleurSite">
					<input type="hidden" name="numArt"
						value='<%=liste.get(i).get_id()%>'>
					<textarea name="textarea" required="required"
						placeholder='Votre commentaire ici' cols=50></textarea>
					<br>
					<button type="submit" class="btn btn-secondary btn-sm"
						id="connexion" name="text">Poster</button>
				</form>

			</fieldset>
			<%
				if (session.getAttribute("attenteMod") != null) {
			%>
			<div class="text-white">
				<%=session.getAttribute("attenteMod")%></div>
			<%
				}
			%>
			<%
				}
			%>

		</fieldset>
		<%
			}

			}
		%>
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