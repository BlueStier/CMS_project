<%@page import="model.*"%>
<%@page import='java.util.*'%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>CMS_Project</title>
</head>
<body>
	<li class="nav-item dropdown"><a
		class="nav-link dropdown-toggle mr-lg-2" id="alertsDropdown" href="#"
		data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
			<i class="fa fa-fw fa-bell"></i> <span
			class="indicator text-warning d-none d-lg-block"> <i
				class="fa fa-fw fa-circle"></i>
		</span>
	</a>
		<div class="dropdown-menu" aria-labelledby="alertsDropdown">
			<h6 class="dropdown-header">Commentaires à modérer:</h6>
			<%
				ArrayList<MODEL<Commentaires>> listeCOM = (ArrayList<MODEL<Commentaires>>) session
						.getAttribute("commentaires");
				int taille = listeCOM.size();
				for (int i = 0; i < taille; i++) {
			%>
			<form method='post' action="Controlleur">
				<div class="dropdown-divider"></div>
				<input type="hidden" name="modeCom1"
					value="<%=listeCOM.get(i).get_id()%>">
				<button class="dropdown-item" name="confModeCom1">
					<span class="text-success"> <strong> <i
							class="fa fa-long-arrow-up fa-fw"></i>Article concerné :&nbsp;<%=listeCOM.get(i).get_article().get_titre()%></strong>
					</span> <span class="small float-right text-muted"><%=listeCOM.get(i).get_date()%></span>
					<div class="dropdown-message small"><%=listeCOM.get(i).get_contenu()%></div>
				</button>
			</form>
			<%
				}
			%>
			<div class="dropdown-divider"></div>
			<a class="dropdown-item small" href="Controlleur?28">Voir tous
				les commentaires</a>
		</div></li>
</body>
</html>