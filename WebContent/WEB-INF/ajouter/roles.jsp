<%@page import="model.*"%>
<%@page import="factory.*"%>
<%@page import="dao.*"%>
<%@page import='java.util.*'%>
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

<body class="bg-dark">
	<%
		if (session.getAttribute("demandeModifR") != null) {
			MODEL<?> u = (MODEL<?>) session.getAttribute("demandeModifR");
			out.println(u.toString());
	%>
	<div class="container">
		<div class="card card-register mx-auto mt-5">
			<div class="card-header">Modifier un role</div>
			<div class="card-body">
				<form method='post' action="Controlleur">
					<div class="form-group">
						<div class="form-row">
							<div class="col-md-12">
								<label for="exampleInputName">Nom</label> <input
									class="form-control" id="titre" name="nomRole" type="text"
									aria-describedby="nameHelp" value="<%=u.get_nom()%>"
									required="required">
							</div>
						</div>
					</div>
					<div class="form-group">
						<div class="form-row">

							<div class="col-md-6">
								<label for="visible">Thèmes :</label> <input type="checkbox"
									name="ajout_theme">
							</div>

							<div class="col-md-6">
								<label for="visible">Utilisateurs :</label> <input
									type="checkbox" name="ajout_users">
							</div>
						</div>
					</div>
					<div class="form-group">
						<div class="form-row">

							<div class="col-md-6">
								<label for="visible">Rôles :</label> <input type="checkbox"
									name="ajout_role">
							</div>

							<div class="col-md-6">
								<label for="visible">Visiteurs :</label> <input type="checkbox"
									name="ajout_visiteur">
							</div>
						</div>
					</div>
					<div class="form-group">
						<div class="form-row">
							<div class="col-md-6">
								<label for="visible">Articles :</label> <input type="checkbox"
									name="ajout_article">
							</div>
							<div class="col-md-6">
								<label for="visible">Modérateur :</label> <input type="checkbox"
									name="ajout_mod">
							</div>
						</div>
					</div>
					<div class="form-group">
						<div class="form-row">
							<div class="col-md-6">
								<label for="visible">Paramètres :</label> <input type="checkbox"
									name="ajout_param">
							</div>
							<div class="col-md-6">
								<label for="visible">Catégories :</label> <input type="checkbox"
									name="ajout_cat">
							</div>
						</div>
					</div>
					<div class="form-group">
						<div class="form-row">
							<div class="col-md-6">
								<input type="hidden" name="idModif" value="<%=u.get_id()%>"></input>
								<button type="submit" class="btn btn-primary btn-block"
									id="register" name="updateRole">Enregistrer</button>
							</div>
							<div class="col-md-6">

								<a class="btn btn-secondary btn-block" href="Controlleur?1">Annuler</a>
							</div>
						</div>
					</div>
				</form>
			</div>
		</div>
	</div>
	<%
		} else {
	%>
	<div class="container">
		<div class="card card-register mx-auto mt-5">
			<div class="card-header">Ajouter un role</div>
			<div class="card-body">
				<form method='post' action="Controlleur">
					<div class="form-group">
						<div class="form-row">
							<div class="col-md-12">
								<label for="exampleInputName">Nom</label> <input
									class="form-control" id="titre" name="nomRole" type="text"
									aria-describedby="nameHelp" placeholder="Entrez un nom"
									required="required">
							</div>
						</div>
					</div>
					<div class="form-group">
						<div class="form-row">

							<div class="col-md-6">
								<label for="visible">Thèmes :</label> <input type="checkbox"
									name="ajout_theme">
							</div>

							<div class="col-md-6">
								<label for="visible">Utilisateurs :</label> <input
									type="checkbox" name="ajout_users">
							</div>
						</div>
					</div>
					<div class="form-group">
						<div class="form-row">

							<div class="col-md-6">
								<label for="visible">Rôles :</label> <input type="checkbox"
									name="ajout_role">
							</div>

							<div class="col-md-6">
								<label for="visible">Visiteurs :</label> <input type="checkbox"
									name="ajout_visiteur">
							</div>
						</div>
					</div>
					<div class="form-group">
						<div class="form-row">
							<div class="col-md-6">
								<label for="visible">Articles :</label> <input type="checkbox"
									name="ajout_article">
							</div>
							<div class="col-md-6">
								<label for="visible">Modérateur :</label> <input type="checkbox"
									name="ajout_mod">
							</div>
						</div>
					</div>
					<div class="form-group">
						<div class="form-row">
							<div class="col-md-6">
								<label for="visible">Paramètres :</label> <input type="checkbox"
									name="ajout_param">
							</div>
							<div class="col-md-6">
								<label for="visible">Catégories :</label> <input type="checkbox"
									name="ajout_cat">
							</div>
						</div>
					</div>
					<div class="form-group">
						<div class="form-row">
							<div class="col-md-6">

								<button type="submit" class="btn btn-primary btn-block"
									id="register" name="registerRole">Enregistrer</button>
							</div>
							<div class="col-md-6">

								<a class="btn btn-secondary btn-block" href="Controlleur?1">Annuler</a>
							</div>
						</div>
					</div>
				</form>
			</div>
		</div>
	</div>
	<%
		}
	%>
	<!-- Bootstrap core JavaScript-->
	<script src="vendor/jquery/jquery.min.js"></script>
	<script src="vendor/bootstrap/js/bootstrap.bundle.min.js"></script>
	<!-- Core plugin JavaScript-->
	<script src="vendor/jquery-easing/jquery.easing.min.js"></script>
</body>

</html>
