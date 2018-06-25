<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<!-- Bootstrap core CSS -->
<link href="ressources/theme1/vendor/bootstrap/css/bootstrap.min.css"
	rel="stylesheet">

<!-- Custom fonts for this template -->
<link href="ressources/theme1/vendor/font-awesome/css/font-awesome.min.css"
	rel="stylesheet" type="text/css">
<link href="https://fonts.googleapis.com/css?family=Montserrat:400,700"
	rel="stylesheet" type="text/css">
<link
	href="https://fonts.googleapis.com/css?family=Lato:400,700,400italic,700italic"
	rel="stylesheet" type="text/css">
<link rel="shortcut icon" type="image"
	href="ressources/theme1/img/Flav_Quizz.png">

<!-- Plugin CSS -->
<link href="ressources/theme1/vendor/magnific-popup/magnific-popup.css"
	rel="stylesheet" type="text/css">

<!-- Custom styles for this template -->
<link href="ressources/theme1/css/freelancer.min.css" rel="stylesheet">
<title>CMS_project</title>
</head>
<body id="page-top">
	<header class="masthead bg-primary text-white text-center">
	<h1 class="text-uppercase mb-0">CMS_project</h1>
	<br>
	<br>
	<h2 class="font-weight-light mb-0">CMS by BlueStier
		</h2>
	</header>
	<h2 class="text-center text-uppercase text-secondary mb-0">Entrez votre 
		Pseudo et votre mot de passe svp</h2>
	<section id="contact">
	<div class="container seconnecter">
		<div class="row">
			<div class="col-lg-8 mx-auto">
			
				<form method='post' action="Controlleur">
					<div class="control-group">
						
							<div class="form-group floating-label-form-group controls mb-0 pb-2">
							<label>Pseudo : </label><input class="form-control" type="text"
								name="pseudo" placeholder="Pseudo" required="required"
								data-validation-required-message="Veuillez entrer votre Pseudo.">
							<p class="help-block text-danger"></p>
						</div>
					</div>
					<div class="control-group">
						<div
							class="form-group floating-label-form-group controls mb-0 pb-2">
							<label>Mot de passe : </label><input class="form-control"
								type="password" name="mdp" placeholder="Mot de passe"
								required="required"
								data-validation-required-message="Veuillez saisir votre mot de passe."><br>
							<p class="help-block text-danger"></p>
						</div>
					</div>
					<div id="boutonConnection">
						<button type="submit" class="btn btn-primary btn-xl"
							id="connexion" name="connexion">Connexion</button>
					</div>
				</form>
				<%
					if (request.getAttribute("pseudo_or_mdp_error") != null) {
						out.println(request.getAttribute("pseudo_or_mdp_error"));
					}
				%>
			</div>
		</div>
	</div>
	</section>
</body>
</html>