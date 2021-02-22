    <div class="container">
        
        <img class="image-ensa" src="images/imageensaa1.jpeg">
        
        <c:forEach var="club" items="${clubs}" >
            <section class="features">
                <figure>
                    <a href="presentation?clubId=${club.id }"><img src="images/${club.logoPath }"></a>
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