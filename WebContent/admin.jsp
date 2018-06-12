<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<!-- Bootstrap core CSS -->
<link href="ressources/vendor/bootstrap/css/bootstrap.min.css"
	rel="stylesheet">

<!-- Custom fonts for this template -->
<link href="ressources/vendor/font-awesome/css/font-awesome.min.css"
	rel="stylesheet" type="text/css">
<link href="https://fonts.googleapis.com/css?family=Montserrat:400,700"
	rel="stylesheet" type="text/css">
<link
	href="https://fonts.googleapis.com/css?family=Lato:400,700,400italic,700italic"
	rel="stylesheet" type="text/css">
<link rel="shortcut icon" type="image"
	href="ressources/img/Flav_Quizz.png">

<!-- Plugin CSS -->
<link href="ressources/vendor/magnific-popup/magnific-popup.css"
	rel="stylesheet" type="text/css">

<!-- Custom styles for this template -->
<link href="ressources/css/freelancer.min.css" rel="stylesheet">
<title>CMS_project</title>
</head>
<body>
<body id="page-top">

    <!-- Navigation -->
    <nav class="navbar navbar-expand-lg bg-secondary fixed-top text-uppercase" id="mainNav">
        <div class="container">
            <!-- <img class="img-fluid mb-5 d-block mx-auto" src="img/logo_afpa.png" alt="">-->
            <button class="navbar-toggler navbar-toggler-right text-uppercase bg-primary text-white rounded" type="button" data-toggle="collapse" data-target="#navbarResponsive" aria-controls="navbarResponsive" aria-expanded="false" aria-label="Toggle navigation">
            <button class="navbar-toggler navbar-toggler-right text-uppercase bg-primary text-white rounded" type="button" data-toggle="collapse" data-target="#navbarResponsive" aria-controls="navbarResponsive" aria-expanded="false" aria-label="Toggle navigation">
        Menu
        <i class="fa fa-bars"></i>
      </button>
            <div class="collapse navbar-collapse" id="navbarResponsive">
                <ul class="navbar-nav ml-auto">
                    <!--
                    <li class="nav-item mx-0 mx-lg-1">
                        <a class="nav-link py-3 px-0 px-lg-3 rounded js-scroll-trigger" href="index.php">Accueil</a>
                    </li>
                    
                    <li class="nav-item mx-0 mx-lg-1">
                        <a class="nav-link py-3 px-0 px-lg-3 rounded js-scroll-trigger" href="#about">Questionnaire</a>
                    </li>
                    -->
                    <li class="nav-item mx-0 mx-lg-1">
                        <a class="nav-link py-3 px-0 px-lg-3 rounded js-scroll-trigger" href="chkForm/classement.php">Classement</a>
                    </li>
                    <li class="nav-item mx-0 mx-lg-1">
                        <a class="nav-link py-3 px-0 px-lg-3 rounded js-scroll-trigger" href="pub.php">Liens</a>
                    </li>
                    <li class="nav-item mx-0 mx-lg-1">
                        <a class="nav-link py-3 px-0 px-lg-3 rounded js-scroll-trigger" href="chkForm/deconnexion.php">Se Déconnecter</a>
                    </li>
                </ul>
            </div>
        </div>
    </nav>

    
        <div class="container difficulte">
            <h2>Choix difficulté :</h2>
            <p id=ligneDifficulte><a href="chkForm/get_questionnaire.php?diff=1" id=btnDifficulte><button type="button" class="btn btn-primary btn-lg large btnFacile">Facile</button></a><strong> (1 point par bonne réponse)</strong></p>
            <p id=ligneDifficulte><a href="chkForm/get_questionnaire.php?diff=2" id=btnDifficulte><button type="button" class="btn btn-primary btn-lg large btnMoyen">Moyen</button></a><strong> (2 points par bonne réponse)</strong></p>
            <p id=ligneDifficulte><a href="chkForm/get_questionnaire.php?diff=3" id=btnDifficulte><button type="button" class="btn btn-primary btn-lg large btnDifficile">Difficile</button></a><strong> (4 points par bonne réponse)</strong></p>
            <h3>Répondez à 10 questions par questionnaire</h3>
        </div>
    

</body>
</html>