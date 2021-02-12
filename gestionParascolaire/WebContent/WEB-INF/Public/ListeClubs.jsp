<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Clubs Ensa</title>
    <link rel="stylesheet" href="./inc/css/header-footer.css">
    <link rel="stylesheet" href="./inc/css/connexionForm.css">
    <link rel="stylesheet" href="./inc/css/Public/ListeClubs.css">
    <script src="https://kit.fontawesome.com/5bf11eee96.js" ></script>
</head>
<body>


	<%@ include file="inc/header.jsp" %>
	
	
    <div class="container">
        
        <img class="image-ensa" src="images/imageensaa1.jpeg">
        
        <c:forEach var="club" items="${clubs}" >
            <section class="features">
                <figure>
                    <img src="images/enactus1.jpg">
                    <figcaption>
                        <c:out value="${ club.name }" />
                    </figcaption>
                    <div class="description">
                       <c:out value="${ club.description }" />
                     </div>
                </figure>
                </section>
         </c:forEach>

    
    </div>
    
    <%@ include file="../footer.jsp" %>
    <%@ include file="../connexionForm.jsp" %>
    
    
</body>
<script type="text/javascript" src="./inc/js/header.js"></script>
<script type="text/javascript" src="./inc/js/connexionForm.js"></script>
<script type="text/javascript" src="./inc/js/Public/ListeClubs.js"></script>
</html>