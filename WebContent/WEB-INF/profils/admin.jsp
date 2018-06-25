<%@page import="model.*"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
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
<body>
	<%
		if (session.getAttribute("user") == null) {
			response.sendRedirect("/index.jsp");
		} else {
			MODEL<?> u = (MODEL<?>) session.getAttribute("user");
	%>
	<form method='get' action="Controlleur">
		<li class="nav-item" data-toggle="tooltip" data-placement="right"
			title="Acceuil"><a class="nav-link" href="Controlleur?1"> <i
				class="fa fa-fw fa-dashboard"></i> <span class="nav-link-text">Acceuil</span>
		</a></li>
		<%
			if (u.get_role().is_ajout_users()) {
		%>
		<li class="nav-item" data-toggle="tooltip" data-placement="right"
			title="utilisateurs"><a
			class="nav-link nav-link-collapse collapsed" data-toggle="collapse"
			href="#collapseUsers" data-parent="#exampleAccordion"> <i
				class="fa fa-fw fa-user"></i> <span class="nav-link-text">Utilisateurs</span>
		</a>
			<ul class="sidenav-second-level collapse" id="collapseUsers">
				<li><a href="Controlleur?2"><i
						class="fa fa-fw fa-plus-circle"></i> Ajouter</a></li>
				<li><a href="Controlleur?3"><i
						class="fa fa-fw fa-check-circle"></i> Modifier</a></li>
				<li><a href="Controlleur?4"><i
						class="fa fa-fw fa-times-circle"></i> Supprimer</a></li>
				<li><a href="Controlleur?5"><i
						class="fa fa-fw fa-binoculars"></i> Voir tous</a></li>
			</ul></li>
		<%
			}
		%>
		<%
			if (u.get_role().is_ajout_role()) {
		%>
		<li class="nav-item" data-toggle="tooltip" data-placement="right"
			title="roles"><a class="nav-link nav-link-collapse collapsed"
			data-toggle="collapse" href="#collapseRoles"
			data-parent="#exampleAccordion"> <i class="fa fa-fw fa-gavel"></i>
				<span class="nav-link-text">Rôles</span>
		</a>
			<ul class="sidenav-second-level collapse" id="collapseRoles">
				<li><a href="Controlleur?6"><i
						class="fa fa-fw fa-plus-circle"></i> Ajouter</a></li>
				<li><a href="Controlleur?7"><i
						class="fa fa-fw fa-check-circle"></i> Modifier</a></li>
				<li><a href="Controlleur?8"><i
						class="fa fa-fw fa-times-circle"></i> Supprimer</a></li>
				<li><a href="Controlleur?9"><i
						class="fa fa-fw fa-binoculars"></i> Voir tous</a></li>
			</ul></li>
		<%
			}
		%>
		<%
			if (u.get_role().is_ajout_visiteur()) {
		%>
		<li class="nav-item" data-toggle="tooltip" data-placement="right"
			title="visiteurs"><a
			class="nav-link nav-link-collapse collapsed" data-toggle="collapse"
			href="#collapsevisiteurs" data-parent="#exampleAccordion"> <i
				class="fa fa-fw fa-users"></i> <span class="nav-link-text">Visiteurs</span>
		</a>
			<ul class="sidenav-second-level collapse" id="collapsevisiteurs">
				<li><a href="Controlleur?10"><i
						class="fa fa-fw fa-plus-circle"></i> Ajouter</a></li>
				<li><a href="Controlleur?11"><i
						class="fa fa-fw fa-check-circle"></i> Modifier</a></li>
				<li><a href="Controlleur?12"><i
						class="fa fa-fw fa-times-circle"></i> Supprimer</a></li>
				<li><a href="Controlleur?13"><i
						class="fa fa-fw fa-binoculars"></i> Voir tous</a></li>
			</ul></li>
		<%
			}
		%>
		<%
			if (u.get_role().is_ajout_param()) {
		%>
		<li class="nav-item" data-toggle="tooltip" data-placement="right"
			title="Example Pages"><a
			class="nav-link nav-link-collapse collapsed" data-toggle="collapse"
			href="#collapseParam" data-parent="#exampleAccordion"> <i
				class="fa fa-fw fa-cogs"></i> <span class="nav-link-text">Paramètres
			</span>
		</a>
			<ul class="sidenav-second-level collapse" id="collapseParam">
				<li><a href="Controlleur?14"><i
						class="fa fa-fw fa-plus-circle"></i> Ajouter</a></li>
				<li><a href="Controlleur?15"><i
						class="fa fa-fw fa-check-circle"></i> Modifier</a></li>
				<li><a href="Controlleur?16"><i
						class="fa fa-fw fa-times-circle"></i> Supprimer</a></li>
				<li><a href="Controlleur?17"><i
						class="fa fa-fw fa-binoculars"></i> Voir tous</a></li>
			</ul></li>
		<%
			}
		%>
		<%
			if (u.get_role().is_ajout_articles()) {
		%>
		<li class="nav-item" data-toggle="tooltip" data-placement="right"
			title="Menu Levels"><a
			class="nav-link nav-link-collapse collapsed" data-toggle="collapse"
			href="#collapseArticle" data-parent="#exampleAccordion"> <i
				class="fa fa-fw fa-newspaper-o"></i> <span class="nav-link-text">Articles</span>
		</a>
			<ul class="sidenav-second-level collapse" id="collapseArticle">
				<li><a href="Controlleur?18"><i
						class="fa fa-fw fa-plus-circle"></i> Ajouter</a></li>
				<li><a href="Controlleur?19"><i
						class="fa fa-fw fa-check-circle"></i> Modifier</a></li>
				<li><a href="Controlleur?20"><i
						class="fa fa-fw fa-times-circle"></i> Supprimer</a></li>
				<li><a href="Controlleur?21"><i
						class="fa fa-fw fa-binoculars"></i> Voir tous</a></li>
			</ul></li>
		<%
			}
		%>
		<%
			if (u.get_role().is_ajout_cat()) {
		%>
		<li class="nav-item" data-toggle="tooltip" data-placement="right"
			title="Menu Levels"><a
			class="nav-link nav-link-collapse collapsed" data-toggle="collapse"
			href="#collapseCat" data-parent="#exampleAccordion"> <i
				class="fa fa-fw fa-files-o"></i> <span class="nav-link-text">Catégories</span>
		</a>
			<ul class="sidenav-second-level collapse" id="collapseCat">
				<li><a href="Controlleur?22"><i
						class="fa fa-fw fa-plus-circle"></i> Ajouter</a></li>
				<li><a href="Controlleur?23"><i
						class="fa fa-fw fa-check-circle"></i> Modifier</a></li>
				<li><a href="Controlleur?24"><i
						class="fa fa-fw fa-times-circle"></i> Supprimer</a></li>
				<li><a href="Controlleur?25"><i
						class="fa fa-fw fa-binoculars"></i> Voir tous</a></li>
			</ul></li>
		<%
			}
		%>
		<%
			if (u.get_role().is_mod()) {
		%>
		<li class="nav-item" data-toggle="tooltip" data-placement="right"
			title="Menu Levels"><a
			class="nav-link nav-link-collapse collapsed" data-toggle="collapse"
			href="#collapseCom" data-parent="#exampleAccordion"> <i
				class="fa fa-fw fa-comments"></i> <span class="nav-link-text">Commentaires</span>
		</a>
			<ul class="sidenav-second-level collapse" id="collapseCom">
				<li><a href="Controlleur?26"><i
						class="fa fa-fw fa-times-circle"></i> Supprimer</a></li>
				<li><a href="Controlleur?27"><i
						class="fa fa-fw fa-scissors"></i> Modéré</a></li>
				<li><a href="Controlleur?28"><i
						class="fa fa-fw fa-binoculars"></i> Voir tous</a></li>
			</ul></li>
		<%
			}
			}
		%>
		<li class="nav-item" data-toggle="tooltip" data-placement="right"
			title="site"><a class="nav-link" href="Controlleur?30"> <i
				class="fa fa-fw fa-link"></i> <span class="nav-link-text">Site</span>
		</a></li>
	</form>
</body>
</html>