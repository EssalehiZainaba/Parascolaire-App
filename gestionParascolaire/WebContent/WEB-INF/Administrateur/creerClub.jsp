
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>Creer club</title>
	<link rel="stylesheet" href="./inc/css/header-footer.css">
	<link rel="stylesheet" href="./inc/css/sideBar.css">
	<link rel="stylesheet" href="./inc/css/Administrateur/creerClub.css">
 	<script src="https://kit.fontawesome.com/5bf11eee96.js" crossorigin="anonymous"></script>	
</head>
<body>

    <%@ include file="../header.jsp" %>
	
	<%@ include file="../sideBar.jsp" %>
	
   <div id="container">
   
           <form id="addClub">
               <p class="close">x</p>
               <input type="text" name="nom" placeholder="Nom du Club" autocomplete="off">
               <button type="button" id="submitButton">créer</button>
           </form>
            <div id="clubsContainer">
                <div class="club">
                    <p>Club Social</p>
                    <i class="fas fa-trash"></i>
                </div>
                <div class="club">
                    <p>Club Btp</p>
                    <i class="fas fa-trash"></i>
                </div>
                <div class="club">
                    <p>Club industriel</p>
                    <i class="fas fa-trash"></i>
                </div>
                <div class="club">
                    <p>Metanoia</p>
                    <i class="fas fa-trash"></i>
                </div>
                <button id="creerButton">
                    Créer<br>un club
                </button>
            </div>
   
   </div>  
        
     <%@ include file="../footer.jsp" %>
</body>
	<script type="text/javascript" src="./inc/js/header.js"></script>
	<script type="text/javascript" src="./inc/js/sideBar.js"></script>
	<script type="text/javascript" src="./inc/js/Administrateur/creerClub.js"></script>
</html>