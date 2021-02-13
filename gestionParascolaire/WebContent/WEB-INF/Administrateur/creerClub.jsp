
<!DOCTYPE html>
<html>
<head>
	 <meta charset="utf-8" />
	<title>Creer club</title>
	<link rel="stylesheet" href="./inc/css/common/header-footer.css">
	<link rel="stylesheet" href="./inc/css/Administrateur/creerClub.css">
 	<script src="https://kit.fontawesome.com/5bf11eee96.js" ></script>	
 	 <script type="text/javascript">     
        function ConfirmDelete()
{
     var x = confirm("voulez vous supprimer ce candidat?");
     if (x)
         return true;
     else
       return false;
}
     
</script>
 	
</head>
<body>

    <%@ include file="inc/header.jsp" %>
	
	
   <div id="container">
           <span class="erreur" style="color: red;">${Erreur['name']}</span>
           <br>
           <span class="erreur" style="color: red;">${Erreur['email']}</span>
   
           <form id="addClub" method="post" action="CreerClub" >
               <p class="close">x</p>
               <input type="text" name="name" placeholder="Nom du Club" autocomplete="off">
               <input type="email" name="email" placeholder="Email responsable" autocomplete="off">
               <button type="submit" id="submitButton" name="submit">Créer</button>
           </form>
           
            <div id="clubsContainer">
            <c:forEach  items="${clubs }" var="club" >
                <div class="club">
                    <p><c:out value="${ club.name }" /></p>
                   <a href="<c:url value="/suppClub"><c:param name="id" value="${ club.id }"/></c:url>" onclick=" ConfirmDelete()" > <i class="fas fa-trash" ></i> </a>                
                </div>
    
 			</c:forEach>
                <button id="creerButton">
                    Créer<br>un club
                </button>
            </div>
   
   </div>  
        
     <%@ include file="../common/footer.jsp" %>
</body>
	<script type="text/javascript" src="./inc/js/common/header.js"></script>
	<script type="text/javascript" src="./inc/js/Administrateur/creerClub.js"></script>
</html>