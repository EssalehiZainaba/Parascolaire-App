
	<header>
		<ul class="links">
			<li><a href="Accueil">Acceuil</a></li>
			<li><a href="NotreEcole">Notre Ecole</a></li>
			<li class="clubs" >
				<a  href="ListeClubs">Clubs</a>
				<div>
					<i class="fas fa-caret-down"></i>
				</div>
				<ul class="dropDown">
					<c:forEach var="club" items="${applicationScope.club}" >
						<li>
							<a href="presentation?clubId=${club.id }">
							<c:out value="${ club.name }" />
							</a>
						</li>  
					</c:forEach> 
				</ul>
			</li>
			<li><a href="#Footer">Contactez Nous</a></li>
		</ul>
		<div class="LogIn">
			<a href="#">Se Connecter</a>  
		</div>
	</header>