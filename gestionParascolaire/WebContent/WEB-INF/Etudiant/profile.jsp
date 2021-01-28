
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>Profile Etudiant</title>
	<link rel="stylesheet" href="./inc/css/header-footer.css">
	<link rel="stylesheet" href="./inc/css/sideBar.css">
	<link rel="stylesheet" href="./inc/css/Etudiant/profile.css">
  	<script src="https://kit.fontawesome.com/5bf11eee96.js" crossorigin="anonymous"></script>	
</head>
<body>

	<%@ include file="../header.jsp" %>
	
	<%@ include file="../sideBar.jsp" %>
    
    <div id="container">
        
        <div id="Infos">
            <div id="profile">
                <h1>Younes Kellouch</h1>
                <div class="row">
                    <div>                 
                        <span>CNE:</span>D135333931
                    </div>
                    <div>
                       <span>Filiere:</span> Informatique
                    </div>
                </div>
                <div class="row">
                    <div>
                       <span> Pays:</span> Morocco
                    </div>
                    <div>
                       <span>Ville:</span>Agadir
                    </div>
                </div>
                <button id="modifier">Modifier</button>
            </div>
         
            <form id="formulaire">
                <p id="closeButton">x</p>
                <p>Modifier le profile:</p>
                <div>
                    <label>Nom:</label>
                    <input type="text" name="nom" autocomplete="off">
                </div>
                <div>
                    <label>Prenom:</label>
                    <input type="text" name="prenom" autocomplete="off">
                </div>
                <div>
                    <label>CNE:</label>
                    <input type="text" name="cne" autocomplete="off">
                </div>
                <div>
                    <label>Filiere:</label>
                    <input type="text" name="filiere" autocomplete="off">
                </div>
                <div>
                    <label>Pays:</label>
                    <input type="text" name="pays" autocomplete="off">
                </div>
                <div>
                    <label>Ville:</label>
                    <input type="text" name="ville" autocomplete="off">
                </div>
                <button id="formSubmit">Terminé</button>
            
            </form>
        </div>     


    </div>



    <%@ include file="../footer.jsp" %>
</body>
	<script type="text/javascript" src="./inc/js/header.js"></script>
	<script type="text/javascript" src="./inc/js/sideBar.js"></script>
	<script type="text/javascript" src="./inc/js/Etudiant/profile.js"></script>
</html>