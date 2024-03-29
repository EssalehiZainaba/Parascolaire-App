
<!DOCTYPE html>
<html>
<head>
	 <meta charset="utf-8" />
	<title>Demandes d'adhération | Parascolaire Ensa Agadir</title>
	<link rel="icon" href="./images/logo.png">
	<link rel="stylesheet" href="inc/css/common/header-footer.css">
	<link rel="stylesheet" href="inc/css/sideBarRespo.css">
	<link rel="stylesheet" href="inc/css/Responsable/demandesAdherationClub.css">
	<link rel="stylesheet" href="inc/css/Responsable/popUpConfirm.css">
	<link rel="stylesheet" href="inc/css/common/popUpDeconnexion.css">
	
	
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
		                
		                <div id="${demande.etudiant.id}" class="buttons">
		                    <button  class="add">
		                        <i class="fas fa-check"></i>
		                    </button>
		                    <button  class="remove">
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
    
    			
    <div id="confirmDelete" class="popUpConfirm hideConfirm">
        <div id="closeDelete" class="closeConfirm">X</div>
        <div class="title">Voulez vous vraiment supprimer cette Demande ?</div>
        <div class="buttons">
            <button id="delete" name="id_etudiant" type="submit" form="supprimerDemandes"  value="">Supprimer</button>
            <button id="cancelDelete" class="cancel">Cancel</button>
        </div>
    </div>
    
    <div id="confirmAccept" class="popUpConfirm hideConfirm">
        <div id="closeAccept" class="closeConfirm">X</div>
        <div class="title">Voulez vous vraiment Accepter cette Demande ?</div>
        <div class="buttons">
            <button id="accept" name="id_etudiant" type="submit" form="accepterDemandes"  value="">Accepter</button>
            <button id="cancelAccept" class="cancel">Cancel</button>
        </div>
    </div>  
     
     <%@ include file="../common/popUpDeconnexion.jsp" %> 
     <%@ include file="../common/footer.jsp" %>
</body>

	<script type="text/javascript" src="./inc/js/common/header.js"></script>
	<script type="text/javascript" src="./inc/js/Responsable/popUpConfirm.js"></script>
	<script type="text/javascript" src="./inc/js/common/popUpDeconnexion/popUpDeconnexion.js"></script>
	

</html>