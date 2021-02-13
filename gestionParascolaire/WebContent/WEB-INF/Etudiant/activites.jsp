
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>Profil �tudiant</title>
	<link rel="stylesheet" href="inc/css/header-footer.css">
	<link rel="stylesheet" href="inc/css/sideBar.css">
	<link rel="stylesheet" href="inc/css/Etudiant/activites.css">
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
	                 	<img src="images/image3.jpeg" alt="">
	             	</div>
	        		<div class="row">
	        			<span class="title">Club :</span>
	        			<span>${activite.club.name }</span>
	        		</div>
	        		<div class="row">
	        			<span class="title">Nom :</span>
	        			<span>${activite.nom }</span>
	        		</div>
	        		<!-- Had description je pense blach ha deranjat styling o safi ==> I AGREE //Z -->
        			<!--<div class="row">
	        				<span>Description :</span>
	        				<span class="description">
	        					Lorem ipsum, dolor sit amet consectetur adipisicing elit. Dicta ullam, error cumque recusandae, architecto, perferendis 
	        					officiis non fuga fugit ad provident ipsam? Velit consequatur deserunt aliquid cupiditate quam eum exercitationem.Lorem ipsum, 	Lorem ipsum, dolor sit amet consectetur adipisicing elit. Dicta ullam, error cumque recusandae, architecto, perferendis 
	        					officiis non fuga fugit ad provident ipsam? Velit consequatur deserunt aliquid cupiditate quam eum exercitationem.
	        				</span>
	       					<span>${activite.description }</span>
	        			</div> 
	        		-->
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



    <%@ include file="../footer.jsp" %>
</body>
	<script type="text/javascript" src="./inc/js/header.js"></script>
	<script type="text/javascript" src="./inc/js/sideBar.js"></script>
	<script type="text/javascript" src="./inc/js/Etudiant/activites.js"></script>
</html>