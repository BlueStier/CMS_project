<%@page import="model.*"%>
<%@page import="factory.*"%>
<%@page import="dao.*"%>
<%@page import='java.util.*'%>
<!DOCTYPE html>
<html lang="en">

<head>
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport"
	content="width=device-width, initial-scale=1, shrink-to-fit=no">
<meta name="description" content="">
<meta name="author" content="">
<title>SB Admin - Start Bootstrap Template</title>
<!-- Bootstrap core CSS-->
<link href="vendor/bootstrap/css/bootstrap.min.css" rel="stylesheet">
<!-- Custom fonts for this template-->
<link href="vendor/font-awesome/css/font-awesome.min.css"
	rel="stylesheet" type="text/css">
<!-- Page level plugin CSS-->
<link href="vendor/datatables/dataTables.bootstrap4.css"
	rel="stylesheet">
<!-- Custom styles for this template-->
<link href="css/sb-admin.css" rel="stylesheet">
</head>
<%
	MODEL<?> t = (MODEL<?>) DAOFactory.getThemesDAO().find_courant();
	DAO<?> c = DAOFactory.getCatDAO();
	ArrayList<Cat> liste = (ArrayList<Cat>) c.get_all();
	int tailleCat = liste.size();
	DAO<?> a = DAOFactory.getArticlesDAO();
	ArrayList<Articles> listeA = (ArrayList<Articles>) a.get_all();
	int tailleA = listeA.size();
	DAO<?> v = DAOFactory.getVisiteursDAO();
	ArrayList<Visiteurs> listeV = (ArrayList<Visiteurs>) v.get_all();
	int tailleV = listeV.size();
	DAO<?> com = DAOFactory.getCommentairesDAO();
	ArrayList<Commentaires> listeC = (ArrayList<Commentaires>) com.get_all();
	int tailleC = listeC.size();
	int tailleM = 0;
	for(int i = 0;i<tailleC;i++){
		if(listeC.get(i).is_mod()){
			tailleM++;
		}
	}
%>
<body>
	<div>
		<div class="container-fluid">
			<!-- Breadcrumbs-->
			<ol class="breadcrumb">
				<li class="breadcrumb-item"><a href="Controlleur?1">Acceuil</a>
				</li>

			</ol>
			<!-- Example DataTables Card-->
			<div class="card mb-3">
				<div class="card-header">
					<i class="fa fa-table"></i> Synthèse
				</div>
				<div class="card-body">
					<div>
						<table  width="100%"
							cellspacing="0">
							<thead>
								<tr>
									<th>Thème</th>
									<th>Nombre de catégories</th>
									<th>Nombres d'articles</th>
									<th>Nombre de commentaires total</th>
									<th>Nombre de commentaires en attentee de modération</th>
									<th>Nombre de visiteurs inscrit</th>
								</tr>
							</thead>							
							<tbody>
								<tr>
									<td><a href="Controlleur?17"><%=t.get_nom()%></a></td>
									<td class="text-center"><a href="Controlleur?25"><%=tailleCat%></a></td>
									<td class="text-center"><a href="Controlleur?21"><%=tailleA%></a></td>
									<td class="text-center"><a href="Controlleur?28"><%=tailleC%></a></td>
									<td class="text-center"><a href="Controlleur?28"><%=tailleM%></a></td>
									<td class="text-center"><a href="Controlleur?28"><%=tailleV%></a></td>
								</tr>							
							</tbody>
						</table>
					</div>
				</div>				
			</div>
		</div>
		<!-- /.container-fluid-->
		<!-- /.content-wrapper-->
		<footer class="sticky-footer">
			<div class="container">
				<div class="text-center">
					<small>Copyright © Your Website 2018</small>
				</div>
			</div>
		</footer>
		<!-- Scroll to Top Button-->
		<a class="scroll-to-top rounded" href="#page-top"> <i
			class="fa fa-angle-up"></i>
		</a>
		
		
		<!-- Bootstrap core JavaScript-->
		<script src="vendor/jquery/jquery.min.js"></script>
		<script src="vendor/bootstrap/js/bootstrap.bundle.min.js"></script>
		<!-- Core plugin JavaScript-->
		<script src="vendor/jquery-easing/jquery.easing.min.js"></script>
		<!-- Page level plugin JavaScript-->
		<script src="vendor/datatables/jquery.dataTables.js"></script>
		<script src="vendor/datatables/dataTables.bootstrap4.js"></script>
		<!-- Custom scripts for all pages-->
		<script src="js/sb-admin.min.js"></script>
		<!-- Custom scripts for this page-->
		<script src="js/sb-admin-datatables.min.js"></script>
	</div>
</body>

</html>
