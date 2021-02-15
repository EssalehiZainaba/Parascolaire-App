
<!DOCTYPE html>
<html>
<head>
	 <meta charset="utf-8" />
	<title>Gérer les demandes d'adhération</title>
	<link rel="stylesheet" href="inc/css/common/header-footer.css">
	<link rel="stylesheet" href="inc/css/sideBarRespo.css">
	<link rel="stylesheet" href="inc/css/Responsable/demandesAdherationClub.css">
	<script src="https://kit.fontawesome.com/5bf11eee96.js" ></script>	
</head>

<body>

    <%@ include file="inc/header.jsp" %>
	
	<%@ include file="inc/sideBar.jsp" %>

	<div id="container">
        <div id="demandes">
        <form id="accepterDemandes" action="GestionDemandes?confirmer=confirmer" method="POST"></form>
        <form id="supprimerDemandes" action="GestionDemandes?supprimer=supprimer" method="POST"></form>
			
			<c:if test="${size>0}">
		      
		       <c:forEach items="${demandes}" var="demande">
		            
		            <div class="demande">
		                
		                <p>${demande.etudiant.nom} ${demande.etudiant.prenom}</p>
		                <p>${demande.etudiant.filiere}</p>
		                <p>${demande.dateDemande}</p>
		                
		                <div class="buttons">
		                    <button name="id_etudiant" type="submit" form="accepterDemandes" value="${demande.etudiant.id}" class="add">
		                        <i class="fas fa-check"></i>
		                    </button>
		                    <button name="id_etudiant" type="submit" form="supprimerDemandes" value="${demande.etudiant.id}" class="remove">
		                        <i class="fas fa-trash-alt"></i>
		                    </button>
		                </div>
		            
		            </div>
	            
	            </c:forEach>
			
			</c:if> 
			
			<c:if test="${size==0}">
				<div class="noDemandes">
					<h1>Le Club n'a pas de demandes d'adheration !</h1>
				</div>
			</c:if>         	
     
        </div>
    </div>
            
     <%@ include file="../common/footer.jsp" %>
</body>

	<script type="text/javascript" src="./inc/js/common/header.js"></script>

</html>