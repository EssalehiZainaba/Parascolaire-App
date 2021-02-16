<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    
    <title>Activités | Parascolaire Ensa Agadir</title>
    
    <link rel="icon" href="./images/logo.png">
	<link rel="stylesheet" href="inc/css/common/header-footer.css">
	<link rel="stylesheet" href="inc/css/sideBarRespo.css">
	<link rel="stylesheet" href="inc/css/Responsable/Activities.css">
    
    <script src="https://kit.fontawesome.com/5bf11eee96.js" crossorigin="anonymous"></script>

</head>
<body>

    <%@ include file="inc/header.jsp" %>
	
	<%@ include file="inc/sideBar.jsp" %>
	
	<div id="container">
	     <div id="activities">
	     <c:forEach items="${activites}" var="activite">
	     	<div class="activite">
	             <p>${activite.nom}</p>
	             <div class="imageContainer">
	                 <img src="images/${activite.imagePath}" alt="">
	             </div>
	             <p>${ activite.etudiants.size()} participants</p>
	             <div class="buttons">
	                 <button class="edit" onclick="location.href='./modifierActivite?id=${activite.id}'">
	                     <i class="fas fa-pen"></i>
	                 </button>
	                 <button class="remove" onclick="location.href='./supprimerActivite?id=${activite.id}'">
	                     <i class="fas fa-trash-alt"></i>
	                 </button>
	             </div>
	         </div>
	     	
	     </c:forEach>
	         
	         
	         
	         
	         
	     </div>
	 </div>
	 
	             
     <%@ include file="../common/footer.jsp" %>
</body>
	<script type="text/javascript" src="./inc/js/common/header.js"></script>
</html>