<%@ page contentType="text/html; charset=UTF-8" %>

<!DOCTYPE html>

<html>

<head>
	<meta charset="UTF-8">
	<title>Parascolaire Ensa Agadir</title>
	<link rel="icon" href="./images/logo.png">
	<link rel="stylesheet" href="./inc/css/common/header-footer.css">
	<link rel="stylesheet" href="./inc/css/common/connexionForm.css">
	<link rel="stylesheet" href="./inc/css/Accueil/accueil.css">
	<link rel="stylesheet" href="./inc/css/Accueil/header.css">
  	<script src="https://kit.fontawesome.com/5bf11eee96.js" crossorigin="anonymous"></script>	
</head>

<body>

   	<%@ include file="inc/header.jsp" %>
   	
    <div class="container ${!empty erreurs ? 'blur' :''}">

        <div class="Slider-images ">
        	
           <div class="wrapper">	    
                <img src="images/enactusAccueil.jpg">
				<div class="description hideDescription">
					<h1>Club Enactus</h1>
					<p>
					    Enactus est une ONG internationale qui oeuvre dans le domaine de l’entrepreneuriat social estudiantin et le développement durable pour
					     améliorer les vies et façonner un monde meilleur et durable .

					</p>
					<a class="readMore" href="presentation?clubName=Enactus">Lire la suite</a>
				</div>
           </div>
           
           <div class="wrapper">
                <img src="images/SocialAccueil.jpeg">
               	<div class="description hideDescription">
					<h1>Club Social</h1>
					<p>
					Le club social Ensa Agadir est un groupe de jeunes ingénieurs, ayant un but est de développer l’esprit d’initiative,
					 de solidarité et de responsabilité tout en se sentant utile à l’ensemble. 
					 Pour ce faire, il nous est demandé de passer du quantitatif au travail qualitatif.
				
					</p>
					<a class="readMore" href="presentation?clubName=Social">Lire la suite</a>
				</div>
           </div>
           
           <div class="wrapper">          
                <img src="images/BTPAccueil.jpeg">
               	<div class="description hideDescription">
					<h1>Club BTP</h1>
					<p>
					    Le club BTP est un club qui s’intéresse à intégrer les élèves ingénieurs dans
					     le domaine du BTP et les approcher de la vie professionnelle .

					</p>
					<a class="readMore" href="presentation?clubName=BTP">Lire la suite</a>
				</div>
           </div>
           
           <div class="wrapper"> 
                <img src="images/SmoAccueil.jpeg">
               	<div class="description hideDescription">
					<h1>South Meeting Olympiad</h1>
					<p>
					    SMO - South Meeting Olympiad représente l'événement phare des activités parascolaires entretenues par
					     les étudiants de l'ENSA Agadir, un grand tournoi de challenge qui réunit un ensemble de grandes écoles
					      d'ingénieurs de commerce et de médecine a l'échelle nationale.
					</p>
					 <a class="readMore" href="presentation?clubName=Sportif">Lire la suite</a></button>
				</div>
           </div>
           
           <div class="wrapper">  
                <img src="images/UltraAccueil.jpeg">
               	<div class="description hideDescription">
					<h1>Club Sportif</h1>
					<p>
					   Le Club Sportif ENSA Agadir est chargé de tous ce qui est dans le domaine sportif
					   et culturel dans l'école.
					</p>
					<a class="readMore" href="presentation?clubName=Sportif">Lire la suite</a>
				</div>
           </div>
  
        </div>
        
        <div id="buttonLeft">&lt;</div>
        <div id="buttonRight">&gt;</div>

        <div id="circles">
            <div class="cercle"></div>
            <div class="cercle"></div>
            <div class="cercle"></div>
            <div class="cercle"></div>
            <div class="cercle"></div>
        </div>


           
        
        <div class="bloc-paragest">
			<div class="bloc-text-paragest">
				ParaGest
			</div>
        
        <div class="bloc">
			<div class="bloc-text">
				La plus grande plateforme de gestion du parascolaire universitaire connue a l'échelle nationale.
			</div>
		</div>
		
		<div class="bloc">
			<div class="bloc-text">
				Utilisée par des dizaines d'universités partout au Maroc pour une meilleure gestion des clubs, activitées parascolaires, et etudiants.
			</div>
		</div>
		
		<div class="bloc">
			<div class="bloc-text">
				Une plateforme qui réunit un ensemble de grandes événements et partage des expériences univérsitaires.
			</div>
		</div>
		
    
    </div>

    
    <%@ include file="../common/footer.jsp" %>
    <%@ include file="../common/connexionForm.jsp" %>
    
</body>
	<script type="text/javascript" src="./inc/js/common/header.js"></script>
	<script type="text/javascript" src="./inc/js/common/connexionForm.js"></script>
	<script type="text/javascript" src="./inc/js/Accueil/accueil.js"></script>
	<script type="text/javascript" src="./inc/js/Accueil/header.js"></script>
</html>