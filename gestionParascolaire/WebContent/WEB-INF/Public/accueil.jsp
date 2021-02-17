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
                
                <img src="images/enactusAccueil.jpg">
           
                <img src="images/SocialAccueil.jpeg">
                     
                <img src="images/BTPAccueil.jpeg">
            
                <img src="images/SmoAccueil.jpeg">
              
                <img src="images/UltraAccueil.jpeg">

             
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


            <div>
               Para Gest (we should discuss a proper name) 
               <br><br>
               la plus grande plateforme du gestion des parascolaire universitaires connue a l'echelle national
               <br><br>
               Utilisée par des milliers Universitées partout au Maroc pour une meilleure gestion des Clubs, activitées, et etudiants
               <br><br>
               Une plateforme qui réunit un ensemble de grandes événements et partage des expériences univérsitaires 
               <br><br>
               
               <br><br>
              
               
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