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
		if (session.getAttribute("demandeModif") != null) {
			MODEL<?> u = (MODEL<?>) session.getAttribute("demandeModif");
	%>
	<div class="container">
		<div class="card card-register mx-auto mt-5">
			<div class="card-header">Modifier un utilisateur</div>
			<div class="card-body">
				<form method='post' action="Controlleur">
					<div class="form-group">
						<div class="form-row">
							<div class="col-md-6">
								<label for="exampleInputName">Nom</label> <input
									class="form-control" id="exampleInputName" type="text"
									aria-describedby="nameHelp" value="<%=u.get_nom()%>"
									name="nomUser" required="required">
							</div>
							<div class="col-md-6">
								<label for="exampleInputLastName">Pseudo</label> <input
									class="form-control" id="exampleInputLastName" type="text"
									aria-describedby="nameHelp" value="<%=u.get_pseudo()%>"
									name="pseudoUser" required="required">
							</div>
						</div>
					</div>
					<div class="form-group">
						<label for="exampleInputEmail1">Email</label> <input
							class="form-control" id="exampleInputEmail1" type="email"
							aria-describedby="emailHelp" value="<%=u.get_mail()%>"
							name="mailUser" required="required">
					</div>
					<div class="form-group">
						<div class="form-row">
							<div class="col-md-12">
								<label for="InputPassword">Mot de passe</label> <input
									class="form-control" id="InputPassword" type="password"
									placeholder="Entrez le nouveau mot de passe" name="mdpUser"
									required="required">
							</div>

						</div>
					</div>
					<div class="form-group">
						<div class="form-row">
							<div class="col-md-12">
								<div class="text-center">
									<label for="categorie">Role</label> <select id="categorie"
										name="role">
										<%
											DAO<?> c = DAOFactory.getRolesDAO();
												ArrayList<MODEL<Roles>> listeCAT = (ArrayList<MODEL<Roles>>) c.get_all();
												int taille = listeCAT.size();
												for (int i = 0; i < taille; i++) {
										%>
										<option value="<%=i%>"><%=listeCAT.get(i).get_nom()%></option>
										<%
											}
										%>
									</select>
								</div>
							</div>
						</div>
					</div>
					<div class="form-group">
						<div class="form-row">
							<div class="col-md-6">
								<input type="hidden" name="idModif" value="<%=u.get_id()%>"></input>
								<button type="submit" class="btn btn-primary btn-block"
									id="register" name="updateUser">Enregistrer</button>
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
			<div class="card-header">Enregistrer un utilisateur</div>
			<div class="card-body">
				<form method='post' action="Controlleur">
					<div class="form-group">
						<div class="form-row">
							<div class="col-md-6">
								<label for="exampleInputName">Nom</label> <input
									class="form-control" id="exampleInputName" type="text"
									aria-describedby="nameHelp" placeholder="Entrez le nom"
									name="nomUser" required="required">
							</div>
							<div class="col-md-6">
								<label for="exampleInputLastName">Pseudo</label> <input
									class="form-control" id="exampleInputLastName" type="text"
									aria-describedby="nameHelp" placeholder="Entrez le pseudo"
									name="pseudoUser" required="required">
							</div>
						</div>
					</div>
					<div class="form-group">
						<label for="exampleInputEmail1">Email</label> <input
							class="form-control" id="exampleInputEmail1" type="email"
							aria-describedby="emailHelp" placeholder="Entrez l'email"
							name="mailUser" required="required">
					</div>
					<div class="form-group">
						<div class="form-row">
							<div class="col-md-12">
								<label for="InputPassword">Mot de passe</label> <input
									class="form-control" id="InputPassword" type="password"
									placeholder="mot de passe" name="mdpUser" required="required">
							</div>

						</div>
					</div>
					<div class="form-group">
						<div class="form-row">
							<div class="col-md-12">
								<div class="text-center">
									<label for="categorie">Role</label> <select id="categorie"
										name="role">
										<%
											DAO<?> c = DAOFactory.getRolesDAO();
												ArrayList<MODEL<Roles>> listeCAT = (ArrayList<MODEL<Roles>>) c.get_all();
												int taille = listeCAT.size();
												for (int i = 0; i < taille; i++) {
										%>
										<option value="<%=i%>"><%=listeCAT.get(i).get_nom()%></option>
										<%
											}
										%>
									</select>
								</div>
							</div>
						</div>
					</div>
					<div class="form-group">
						<div class="form-row">
							<div class="col-md-6">

								<button type="submit" class="btn btn-primary btn-block"
									id="register" name="registerUser">Enregistrer</button>
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
