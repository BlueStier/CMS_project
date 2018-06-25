
<%@page import="model.*"%>
<%@page import="factory.*"%>
<%@page import="dao.*"%>
<%@page import='java.util.*'%>
<!DOCTYPE html>
<html lang="en">

<body id="page-top">
	<header class="masthead bg-primary text-white ">
		<div class="row">
			<div class="col-lg-8 mx-auto">
				<div class = "text-center">S'inscrire :</div>
				<!-- To configure the contact form email address, go to mail/contact_me.php and update the email address in the PHP file on line 19. -->
				<!-- The form should work on most web servers, but if the form is not working you may need to configure your web server differently. -->
				<form name="sentMessage" method="post"
					action="ControlleurSite">
					<!-- id="contactForm" -->
					<div class="control-group">
						<div
							class="form-group floating-label-form-group controls mb-0 pb-2">
							<label>Pseudo</label> <input class="form-control" id="Pseudo"
								type="text" name="pseudo_inscr" placeholder="Pseudo"
								required="required"
								data-validation-required-message="Veuillez entrer un Pseudo.">
							<p class="help-block text-danger"></p>
						</div>
					</div>
					<div class="control-group">
						<div
							class="form-group floating-label-form-group controls mb-0 pb-2">
							<label>Email</label> <input class="form-control" id="email"
								type="email" name="email" placeholder="Email"
								required="required"
								data-validation-required-message="Veuillez entrer votre Email.">
							<p class="help-block text-danger"></p>
						</div>
					</div>
					<div class="control-group">
						<div
							class="form-group floating-label-form-group controls mb-0 pb-2">
							<label>Mot de Passe</label> <input class="form-control" id="mdp"
								type="password" name="mdp_inscr" placeholder="Mot de passe"
								required="required"
								data-validation-required-message="Veuillez entrer un mot de passe.">
							<p class="help-block text-danger"></p>
						</div>
					</div>
					<div id="boutoninscrip">
						<button type="submit" class="btn btn-primary btn-xl" name="boutoninscrip"
							id="connexion">S'inscrire</button>
					</div>
				</form>
			</div>
		</div>
		<br> <br>
		<div class="row">
			<div class="col-lg-8 mx-auto">
				<div class = "text-center">Se connecter :</div>
				<form name="sentMessage" method="post"
					action="ControlleurSite">
					<!-- id="contactForm" -->
					<div class="control-group">
						<div
							class="form-group floating-label-form-group controls mb-0 pb-2">
							<label>Pseudo</label> <input class="form-control" id="pseudo"
								name="pseudo_conn" type="text" placeholder="Pseudo"
								required="required"
								data-validation-required-message="Veuillez entrer votre nom.">
							<p class="help-block text-danger"></p>
						</div>
					</div>
					<div class="control-group">
						<div
							class="form-group floating-label-form-group controls mb-0 pb-2">
							<label>Mot de passe</label> <input class="form-control" id="mdp"
								name="mdp_conn" type="password" placeholder="Mot de passe"
								required="required"
								data-validation-required-message="Veuillez entrer votre mot de passe.">
							<p class="help-block text-danger"></p>
						</div>
					</div>
					<br>
					<div id="boutonConnection">
						<button type="submit" class="btn btn-primary btn-xl"
							id="connexion" name="boutonconn">Connexion</button>
					</div>
				</form>
			</div>
		</div>
		<!-- Scroll to Top Button (Only visible on small and extra-small screen sizes) -->
		<div class="scroll-to-top d-lg-none position-fixed ">
			<a class="js-scroll-trigger d-block text-center text-white rounded"
				href="#page-top"> <i class="fa fa-chevron-up"></i>
			</a>
		</div>
	</header>

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