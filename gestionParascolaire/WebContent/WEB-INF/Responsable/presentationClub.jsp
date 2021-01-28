
<!DOCTYPE html>
<html>
<head>
	<meta charset="ISO-8859-1">
	<title>creer Presentation de Club</title>
	<link rel="stylesheet" href="./inc/css/header-footer.css">
	<link rel="stylesheet" href="./inc/css/sideBar.css">
	<link rel="stylesheet" href="./inc/css/Responsable/presentationClub.css">
 	<script src="https://kit.fontawesome.com/5bf11eee96.js" crossorigin="anonymous"></script>	
</head>
<body>

    <%@ include file="../header.jsp" %>
	
	<%@ include file="../sideBar.jsp" %>
	
   <div id="container">
   
 		  <form id="presentationForm">
	
	            <div class="text">
	                <label id="description">Description :</label>
	                <textarea name="description"></textarea>
	            </div>
	            <div class="text">
	                <label id="paragraphe">Paragraphe :</label>
	                <textarea name="paragraphe"></textarea> 
	            </div>
	            <div>       
	                <label class="logo images" for="logo">
	                    <span><i class="fas fa-images"></i></span> 
	                    ajouter logo
	                </label>
	                <input type="file" id="logo" name="logo" accept="image/*">
	            </div>
	            <div>
	                <label class="images" for="image1">
	                    <span><i class="fas fa-images"></i></span>    
	                    ajouter 1ere image
	                </label>  
	                <input type="file" id="image1" name="image1" accept="image/*">
	            </div>
	            <div>
	                <label class="images" for="image2">
	                <span><i class="fas fa-images"></i> </span> 
	                    ajouter 2eme image
	                </label>
	                <input type="file" id="image2" name="image2" accept="image/*">
	            </div>
	            <div>
	                <label class="images" for="image3">
	                    <span><i class="fas fa-images"></i>  </span> 
	                    ajouter 3eme image
	                </label>
	                <input type="file" id="image3" name="image3" accept="image/*">
	            </div>
	
	            <button type="submit">Créer</button> 
        </form>
        
   </div>  
        
     <%@ include file="../footer.jsp" %>
</body>
	<script type="text/javascript" src="./inc/js/header.js"></script>
	<script type="text/javascript" src="./inc/js/sideBar.js"></script>
</html>