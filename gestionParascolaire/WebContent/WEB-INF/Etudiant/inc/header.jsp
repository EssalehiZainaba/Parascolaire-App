
	<header>
	      <ul class="links">
	          <li><a href="Activites">Acceuil</a></li>
	          <li><a href="NotreEcole">Notre Ecole</a></li>
	          <li class="clubs" >
	                  <a  href="ListeClubs">Clubs</a>
	                  <div>
	                      <i class="fas fa-caret-down"></i>
	                  </div>
	                  <ul class="dropDown">
	                   <c:forEach var="club" items="${applicationScope.club}" >
                        <li><a href="presentation?clubName=${club.name }">
                        <c:out value="${club.name }" />
                        </a></li>  
                      </c:forEach> 
	                  </ul>
	          </li>
	          <li><a href="#Footer">Contactez Nous</a></li>
	      </ul>
			<div id="deconnexion" class="LogIn">
			     Se deconnecter  
			</div>
	</header>