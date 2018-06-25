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

<body>
	<div class="container-fluid">
		<!-- Breadcrumbs-->
		<ol class="breadcrumb">
			<li class="breadcrumb-item"><a href="Controlleur?1">Acceuil</a></li>
			<li class="breadcrumb-item active">Voir tout les commentaires</li>
		</ol>
		<!-- Icon Cards-->

		<%
			DAO<?> u = DAOFactory.getCommentairesDAO();
			ArrayList<Commentaires> liste = (ArrayList<Commentaires>) u.get_all();
			int taille = liste.size();
			for (int i = 0; i < taille; i++) {
				if (liste.get(i).is_mod()) {
		%>
		<form method='post' action="Controlleur">
			<div class="col-xl-12 col-sm-6 mb-3">
				<div class="card text-white bg-primary o-hidden h-100">

					<div class="card-body">
						<div class="card-body-icon">
							<i class="fa fa-comments"></i>
						</div>En attente de modération :
						<div class="mr-5">
							<strong>Commentaire laissé par le visiteur :</strong>&nbsp;
							<%=liste.get(i).get_visiteurs().get_pseudo()%>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<strong>Concerne
								l'article :</strong>&nbsp;<%=liste.get(i).get_article().get_titre()%>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<strong>De
								la catégorie :</strong>&nbsp;<%=liste.get(i).get_article().get_cat().get_nom()%>
						</div>
						<div class="mr-5">
						<strong>Contenu : </strong>&nbsp;<%=liste.get(i).get_contenu()%>
						</div>				
						Commentaire en attente de modération
					</div>

					<div class="form-group">
						<div class="form-row">
							<div class="col-md-6">

								<input type="hidden" name="modeCom"
									value="<%=liste.get(i).get_id()%>">
								<button class="btn btn-primary btn-block" name="confModeCom">Valider
									la modération</button>
							</div>
							<div class="col-md-6">

								<a class="btn btn-primary btn-block" data-toggle="modal"
									data-target="#Modal<%=i%>">Supprimer</a>
							</div>
						</div>
					</div>
				</div>
			</div>

			<!-- Logout Modal-->
			<div class="modal fade" id="Modal<%=i%>" tabindex="-1" role="dialog"
				aria-labelledby="exampleModalLabel" aria-hidden="true">
				<div class="modal-dialog" role="document">
					<div class="modal-content">
						<div class="modal-header">
							<h5 class="modal-title" id="exampleModalLabel">Supprimer :</h5>
							<button class="close" type="button" data-dismiss="modal"
								aria-label="Close">
								<span aria-hidden="true">×</span>
							</button>
						</div>
						<div class="modal-body">Cliquer sur Supprimer pour confirmer
						</div>
						<div class="modal-footer">
							<button class="btn btn-secondary" type="button"
								data-dismiss="modal">Annuler</button>

							<input type="hidden" name="supCom"
								value="<%=liste.get(i).get_id()%>"></input>
							<button class="btn btn-primary" type="submit" name="confSupCom">Supprimer</button>
						</div>
					</div>
				</div>
			</div>
		</form>
		<%
			} else {
		%>
		<form method='post' action="Controlleur">
			<div class="col-xl-12 col-sm-6 mb-3">
				<div class="card text-white bg-success o-hidden h-100">

					<div class="card-body">
						<div class="card-body-icon">
							<i class="fa fa-comments"></i>

						</div>
						Commentaire modéré visible sur le site
						<div class="mr-5">
							<strong>Commentaire laissé par le visiteur :</strong>&nbsp;
							<%=liste.get(i).get_visiteurs().get_pseudo()%>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<strong>Concerne
								l'article :</strong>&nbsp;<%=liste.get(i).get_article().get_titre()%>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<strong>De
								la catégorie :</strong>&nbsp;<%=liste.get(i).get_article().get_cat().get_nom()%>
						</div>
						<div class="mr-5">
						<strong>Contenu : </strong>&nbsp;<%=liste.get(i).get_contenu()%>
						</div>						
					</div>

					<div class="form-group">
						<div class="form-row">
							
							<div class="col-md-12">
								<a class="btn btn-primary btn-block" data-toggle="modal"
									data-target="#Modal<%=i%>">Supprimer</a>
							</div>
						</div>
					</div>
				</div>
			</div>

			<!-- Logout Modal-->
			<div class="modal fade" id="Modal<%=i%>" tabindex="-1" role="dialog"
				aria-labelledby="exampleModalLabel" aria-hidden="true">
				<div class="modal-dialog" role="document">
					<div class="modal-content">
						<div class="modal-header">
							<h5 class="modal-title" id="exampleModalLabel">Supprimer :</h5>
							<button class="close" type="button" data-dismiss="modal"
								aria-label="Close">
								<span aria-hidden="true">×</span>
							</button>
						</div>
						<div class="modal-body">Cliquer sur Supprimer pour confirmer
						</div>
						<div class="modal-footer">
							<button class="btn btn-secondary" type="button"
								data-dismiss="modal">Annuler</button>

							<input type="hidden" name="supCom"
								value="<%=liste.get(i).get_id()%>"></input>
							<button class="btn btn-primary" type="submit" name="confSupCom">Supprimer</button>
						</div>
					</div>
				</div>
			</div>
		</form>
		<%
			}
			}
		%>

	</div>
	<!-- Bootstrap core JavaScript-->
	<script src="vendor/jquery/jquery.min.js"></script>
	<script src="vendor/bootstrap/js/bootstrap.bundle.min.js"></script>
	<!-- Core plugin JavaScript-->
	<script src="vendor/jquery-easing/jquery.easing.min.js"></script>
</body>

</html>
