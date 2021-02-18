 <nav class="side-bar">
        <ul class="side-links">

            <li><a class="link" href="Profil">Profil</a></li>


            <li class="menu">

                <a class="button link">
                    <i class="fas fa-caret-right rotated"></i>
                    &nbsp;&nbsp;Activit�s Publiques
                </a>

                <ul class="sub-menu open">

                    <li><a class="element act-pub openn" href="Activites?clubName=tout&privee=false">Tout les clubs</a></li>

                    <li>

                        <a class="button link element act-pub openn" href="#">
                            <i class="fas fa-caret-right"></i>
                            &nbsp;&nbsp;Mes clubs
                        </a>

                        <ul class="sub-menu">
                        	<li><a class="element act-pub-my-clubs" href="Activites?clubName=tousMesClubs&privee=false">Tous</a></li>
                        	<c:forEach items="${mesClubs }" var="club">
                        		<li><a class="element act-pub-my-clubs" href="Activites?clubName=${club.name }&privee=false">${club.name }</a></li>
                        	</c:forEach>

                        </ul>

                    </li>

                    <li>

                        <a class="button link element act-pub openn" href="#">
                            <i class="fas fa-caret-right"></i>
                            &nbsp;&nbsp;Autres clubs
                        </a>

                        <ul class="sub-menu">
                            <li><a class="element act-pub-other-clubs" href="Activites?clubName=tousAutresClubs&privee=false">Tous</a></li>
                        	<c:forEach items="${autresClubs }" var="club">
                        		<li><a class="element act-pub-other-clubs" href="Activites?clubName=${club.name }&privee=false">${club.name }</a></li>
                        	</c:forEach>
                        </ul>

                    </li>

                </ul>

            </li>


            <li class="menu">

                <a class="button link">
                    <i class="fas fa-caret-right rotated"></i>
                    &nbsp;&nbsp;Activit�s Priv�es
                </a>

                <ul class="sub-menu open">
                	<li><a class="element act-prv openn" href="Activites?clubName=tousMesClubs&privee=true">Tous</a></li>
           	        <c:forEach items="${mesClubs }" var="club">
                   		<li><a class="element act-prv openn" href="Activites?clubName=${club.name }&privee=true">${club.name }</a></li>
                   	</c:forEach>
                </ul>

            </li>


            <li class="menu">

                <a class="button link">
                    <i class="fas fa-caret-right"></i>
                    &nbsp;&nbsp;Mes Clubs
                </a>

                <ul class="sub-menu">
                    <c:forEach items="${mesClubs }" var="club">
                  		<li><a class="element my-clubs" href="presentation?clubName=${club.name }">${club.name }</a></li>
                  	</c:forEach>
                </ul>

            </li>


            <li class="menu">

                <a class="button link">
                    <i class="fas fa-caret-right"></i>
                    &nbsp;&nbsp;Autres Clubs
                </a>

                <ul class="sub-menu">
                    <c:forEach items="${autresClubs }" var="club">
                  		<li><a class="element other-clubs" href="presentation?clubName=${club.name }">${club.name }</a></li>
                  	</c:forEach>
                </ul>

            </li>


        </ul>
    </nav>