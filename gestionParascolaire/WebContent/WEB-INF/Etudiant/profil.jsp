
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>Mon Profil| Parascolaire Ensa Agadir</title>
	<link rel="icon" href="./images/logo.png">
	<link rel="stylesheet" href="./inc/css/common/header-footer.css">
	<link rel="stylesheet" href="./inc/css/sideBar.css">
	<link rel="stylesheet" href="./inc/css/Etudiant/profil.css">
  	<script src="https://kit.fontawesome.com/5bf11eee96.js" crossorigin="anonymous"></script>	
</head>
<body>

	<%@ include file="inc/header.jsp" %>
	
	<%@ include file="inc/sideBar.jsp" %>
    
    <div id="container">
        
        <div id="Infos">
            <div id="profil">
                <h1>${sessionScope.etudiant.prenom } ${sessionScope.etudiant.nom }</h1>
                <div class="row">
                    <div>                 
                        <span>CNE:</span> ${sessionScope.etudiant.cne }
                    </div>
                    <div>
                       <span>Filiere:</span> ${sessionScope.etudiant.filiere }
                    </div>
                </div>
                <div class="row">
                    <div>
                       <span> Pays:</span> ${sessionScope.etudiant.pays }
                    </div>
                    <div>
                       <span>Ville:</span> ${sessionScope.etudiant.ville }
                    </div>
                </div>
                <button id="modifier">Modifier</button>
            </div>
            
            
         	<c:choose >
         		<c:when test="${!empty form}">
         			<c:set var="isFormEmpty" scope="request" value="false"/>
         		</c:when>
         		<c:otherwise>
         			<c:set var="isFormEmpty" scope="request" value="true"/>
         		</c:otherwise>
         	</c:choose>
         	
         	
            <form id="formulaire" <c:if test="${!isFormEmpty }">style="height: 500px; opacity: 1; pointer-events: all;"</c:if> method="POST" action="Profil">
                <p id="closeButton">x</p>
                <p>Modifier le profil:</p>
                <div <c:if test="${!isFormEmpty }">style="opacity: 1;"</c:if>>
                    <label>Nom:</label>
                    <input type="text" name="nom" autocomplete="off" value="${sessionScope.etudiant.nom }">
                </div>
                <div <c:if test="${!isFormEmpty }">style="opacity: 1;"</c:if>>
                    <label>Prenom:</label>
                    <input type="text" name="prenom" autocomplete="off" value="${sessionScope.etudiant.prenom }">
                </div>
                <div <c:if test="${!isFormEmpty }">style="opacity: 1;"</c:if>>
                    <label>CNE:</label>
                    <input type="text" name="cne" autocomplete="off" value="${sessionScope.etudiant.cne }">
                </div>
                <div <c:if test="${!isFormEmpty }">style="opacity: 1;"</c:if>>
                    <label>Filiere:</label>
                    <input type="text" name="filiere" autocomplete="off" value="${sessionScope.etudiant.filiere }">
                </div>
                <div <c:if test="${!isFormEmpty }">style="opacity: 1;"</c:if>>
                    <label>Pays:</label>
                    <input type="text" name="pays" autocomplete="off" value="${sessionScope.etudiant.pays }">
                </div>
                <div <c:if test="${!isFormEmpty }">style="opacity: 1;"</c:if>>
                    <label>Ville:</label>
                    <input type="text" name="ville" autocomplete="off" value="${sessionScope.etudiant.ville }">
                </div>
                <button id="formSubmit">Confirmer</button>
                <c:if test="${!isFormEmpty }">
                	<br/>
                	<div style="opacity: 1;"><p style="margin: auto;">${form.result }</p></div>
    			</c:if>
            </form>
        </div>     


    </div>



    <%@ include file="../common/footer.jsp" %>
</body>
	<script type="text/javascript" src="./inc/js/common/header.js"></script>
	<script type="text/javascript" src="./inc/js/common/sideBar.js"></script>
	<script type="text/javascript" src="./inc/js/Etudiant/profil.js"></script>
</html>