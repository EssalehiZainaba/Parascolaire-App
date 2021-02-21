
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>Parascolaire Ensa Agadir | Accueil</title>
	<link rel="icon" href="./images/logo.png">
	<link rel="stylesheet" href="inc/css/common/header-footer.css">
	<link rel="stylesheet" href="inc/css/sideBar.css">
	<link rel="stylesheet" href="inc/css/Etudiant/activites.css">
	<link rel="stylesheet" href="inc/css/common/popUpDeconnexion.css">
  	<script src="https://kit.fontawesome.com/5bf11eee96.js" crossorigin="anonymous"></script>	
</head>
<body>

	<%@ include file="inc/header.jsp" %>
	
	<%@ include file="inc/sideBar.jsp" %>
    
    <div id="container">
    
    	<form id="participer-form" action="Participer?clubName=${clubName }&privee=${privee }" method="POST"></form>
        
        <div class="activites">
        	<c:forEach items="${activites }" var="activite" varStatus="loop">
        		<div class="activite">
    			 	<div class="imageContainer">
	                 	<img src="images/${activite.imagePath }" alt="">
	             	</div>
	        		<div class="row">
	        			<span class="title">Club :</span>
	        			<span>${activite.club.name }</span>
	        		</div>
	        		<div class="row">
	        			<span class="title">Nom :</span>
	        			<span>${activite.nom }</span>
	        		</div>
	        		<div class="row">
	        			<span class="title">Date :</span>
	        			<span>${activite.date }</span>
	        		</div>
	        		<div class="row">
	        			<span class="title">Lieu :</span>
	        			<span>${activite.lieu }</span>
	        		</div>
						
					<c:if test="${!listParticipe[loop.index] }">
						<button type="submit" form="participer-form" class="participer-submit" name="id-activite-add" value="${activite.id }">Je participe</button>
		        	</c:if>
		        	
		        	<c:if test="${listParticipe[loop.index] }">
						<button type="submit" form="participer-form" class="participer-submit" name="id-activite-remove" value="${activite.id }">Je ne participe plus</button>
		        	</c:if>
					
	        	</div>
        	</c:forEach>
        	
        	<c:if test="${!empty result }">
        		<div class="result">
        			<h1>${result }</h1>
        		</div>
        	</c:if>

        
        </div>


    </div>

	<%@ include file="../common/popUpDeconnexion.jsp" %> 
	

    <%@ include file="../common/footer.jsp" %>
</body>
	<script type="text/javascript" src="./inc/js/common/header.js"></script>
	<script type="text/javascript" src="./inc/js/common/sideBar.js"></script>
	<script type="text/javascript" src="./inc/js/Etudiant/activites.js"></script>
	<script type="text/javascript" src="./inc/js/common/popUpDeconnexion/popUpDeconnexion.js"></script>
	
</html>