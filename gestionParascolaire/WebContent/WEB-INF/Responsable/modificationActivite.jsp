
<!DOCTYPE html>
<html>
<head>
	<meta charset="ISO-8859-1">
	<title>Activit�es | Parascolaire Ensa Agadir</title>
	<link rel="icon" href="./images/logo.png">
	<link rel="stylesheet" href="./inc/css/common/header-footer.css">
	<link rel="stylesheet" href="./inc/css/sideBarRespo.css">
	<link rel="stylesheet" href="./inc/css/Responsable/creationActivite.css">
	<link rel="stylesheet" href="./inc/css/common/popUpDeconnexion.css">
 	<script src="https://kit.fontawesome.com/5bf11eee96.js" crossorigin="anonymous"></script>	
 	
</head>
<body>
	<jsp:useBean id= "am" class="services.ActiviteManager" scope="request" />        

	<jsp:setProperty name="am" property="*" />
	
	<jsp:useBean id= "activite" class="entities.Activite" scope="request" />        

	<jsp:setProperty name="activite" property="*" />

    <%@ include file="inc/header.jsp" %>
	
	<%@ include file="inc/sideBar.jsp" %>
	
   <div id="container">
   
 		  <form id="activiteForm" method="post" action="modifierActivite" enctype="multipart/form-data">
	            <div class="text">
	                <label id="nom">Nom d'activit� :</label>
	                <input type="text" name="nom" value="${activite.getNom() }"/>
	                <span class="erreur" style="color:red">${am.getErreurs()["nom"]}</span>
	            </div>
	            <div class="text">
	                <label id="lieu">Lieu :</label>
	                <input type="text" name="lieu" value="${activite.getLieu() }"/>
	                <span class="erreur" style="color:red">${am.getErreurs()["lieu"]}</span>
	            </div>
	            <div class="text">
	                <label id="date">Date :</label>
	                <input type="date" name="date" value="${activite.getDate().toString() }" class="date"/>
	                <span class="erreur" style="color:red">${am.getErreurs()["date"]}</span>
	            </div>
	            <div class="radio ">
	            	<div><label>Priv�</label><input type="radio" name="privee" value="true"></div>
	            	<div><label>Public</label><input type="radio" name="privee" value="false"></div>
	            	<span class="erreur" style="color:red">${am.getErreurs()["privee"]}</span>
	            </div>
	            <div>
	                <label class="images" for="image">
	                <span><i class="fas fa-images"></i> </span> 
	                    ajouter une image
	                </label>
	                <input type="file" id="image" name="image" accept="image/*">
	                <span class="erreur" style="color:red">${am.getErreurs()["image"]} </span>
	            </div>
				<div class="buttons">
					<button type="submit" name="id" value="${activite.getId()}">Modifier</button>
				</div>
	             
        </form>
        
   </div>  
       
     <%@ include file="../common/popUpDeconnexion.jsp" %>    
     <%@ include file="../common/footer.jsp" %>
</body>
	<script type="text/javascript" src="./inc/js/common/header.js"></script>
	<script type="text/javascript" src="./inc/js/common/popUpDeconnexion/popUpDeconnexion.js"></script>
	
</html>