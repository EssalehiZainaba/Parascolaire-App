    <div class="container">
        
        <img class="image-ensa" src="images/imageensaa1.jpeg">
        
        <c:forEach var="club" items="${clubs}" >
            <section class="features">
                <figure>
                    <a href="presentation?clubName=${club.name }"><img src="images/${club.logoPath}"></a>
                    <figcaption>
                        <c:out value="${ club.name }" />
                    </figcaption>
                </figure>
                <div class="description">
                	<p>
                  	${ club.paragraphe }
                  	</p>
                </div>
                </section>
         </c:forEach>

    
    </div>