package servlets;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.persistence.EntityManagerFactory;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.DaoActivite;
import dao.DaoActiviteImpl;
import dao.DaoAdministrateur;
import dao.DaoAdministrateurImpl;
import dao.DaoAppartenance;
import dao.DaoAppartenanceImpl;
import dao.DaoClub;
import dao.DaoClubImpl;
import dao.DaoDemandeInscription;
import dao.DaoDemandeInscriptionImpl;
import dao.DaoEtudiant;
import dao.DaoEtudiantImpl;
import dao.DaoResponsableClub;
import dao.DaoResponsableClubImpl;
import dao.JPAUtil;
import entities.Activite;
import entities.Administrateur;
import entities.Appartenance;
import entities.Club;
import entities.DemandeInscription;
import entities.Etudiant;
import entities.ResponsableClub;
import services.CreerClubForm;

/**
 * Servlet implementation class FillDB
 */
@WebServlet("/FillDB")
public class FillDB extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
	
	private DaoEtudiant daoEtudiant;
	private DaoResponsableClub daoRespo;
	private DaoAdministrateur daoAdministrateur;
	private DaoClub daoClub;
	private DaoActivite daoActivite;
	private DaoAppartenance daoAppartenance;
	private DaoDemandeInscription DaoDemandeInscription;
       

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		EntityManagerFactory factory = JPAUtil.getEntityManagerFactory();
		
		

		DaoClub daoClub = new DaoClubImpl(JPAUtil.getEntityManagerFactory());	
		CreerClubForm formm = new CreerClubForm(daoClub);
		System.out.print(formm.Hashing("admin"));
		
		Date date = new Date();  
		SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");  
		String strDate= formatter.format(date);
		
		String description = "Lorem ipsum dolor sit amet, consectetur adipiscing elit. Sed vitae nulla ut nisl ultrices ultricies. Donec quis elit ante. Curabitur scelerisque mi et elit rhoncus consequat. Proin accumsan tortor quis metus gravida euismod. Proin in scelerisque erat. Vivamus eget ligula mauris. Donec vulputate tortor mollis enim convallis pretium. Duis nec varius felis, et aliquet purus. Mauris leo metus, gravida sed dui ut, consequat molestie augue. Aliquam erat volutpat. Suspendisse non nunc ac erat facilisis scelerisque id et ipsum. Aliquam efficitur euismod est id sollicitudin. Donec condimentum pellentesque porttitor.\r\n"
				+ "\r\n"
				+ "Nam sed commodo felis. Nullam commodo justo metus, ultricies mattis purus malesuada ut. Fusce non semper turpis, sed semper eros. In tristique ex nec convallis consectetur. Suspendisse diam libero, aliquam in bibendum sit amet, malesuada ornare metus. Nulla pretium rhoncus magna, ut viverra lorem elementum ac. Aliquam porta condimentum venenatis. Sed pretium, tortor non efficitur fermentum, tellus nisi sollicitudin arcu, id luctus velit magna sit amet justo. Vivamus vel est ac tortor ultricies egestas sit amet eget purus. Nunc eleifend erat ut sem maximus placerat. Aenean tempus odio ex, in lacinia urna viverra ac. Pellentesque eget metus a eros lobortis aliquam quis ut diam. Interdum et malesuada fames ac ante ipsum primis in faucibus. Vestibulum sem ex, placerat nec mi et, suscipit bibendum odio. Nulla facilisi.\r\n"
				+ "\r\n"
				+ "Aliquam erat volutpat. Suspendisse vitae dui eleifend, dignissim arcu condimentum, facilisis diam. Suspendisse et cursus dui. Vivamus vehicula, purus et cursus tempor, mauris diam tincidunt ante, sed bibendum sem orci in tortor. Vestibulum ante ipsum primis in faucibus orci luctus et ultrices posuere cubilia curae; Fusce molestie tellus risus, eu consectetur turpis ullamcorper in. Cras sed finibus orci, at bibendum elit. Integer quis nibh bibendum, gravida dolor a, luctus quam. Aenean ornare pulvinar ornare. Nam sed orci in nunc posuere volutpat sed eu nibh. Duis sollicitudin turpis sit amet quam vulputate pretium. Nam efficitur sed nulla id egestas. Nam libero turpis, posuere et turpis vel, viverra laoreet quam.\r\n"
				+ "\r\n"
				+ "Maecenas nibh ante, ultricies nec turpis congue, efficitur consequat ante. Mauris nulla purus, ultricies a dignissim imperdiet, viverra eu turpis. Vestibulum ante ipsum primis in faucibus orci luctus et ultrices posuere cubilia curae; Proin et lorem vitae mi porta aliquet. Suspendisse eu blandit dui. In tincidunt, mi et sagittis ullamcorper, purus libero bibendum mauris, id dapibus ipsum elit et libero. Ut dictum condimentum dui, luctus sollicitudin arcu. Etiam id tortor dolor. Nam pharetra eleifend diam nec venenatis. Etiam a mi ac nunc tempus aliquet. Quisque pharetra lacus quam, vitae tincidunt turpis viverra id. In hac habitasse platea dictumst. Phasellus et condimentum turpis, sed interdum risus.\r\n"
				+ "\r\n"
				+ "Curabitur ornare molestie tortor ac varius. Maecenas bibendum sem vitae eros egestas sollicitudin. Morbi aliquam porttitor risus, in laoreet eros pellentesque eu. Morbi ligula leo, commodo eu est sed, laoreet semper augue. Donec gravida sapien erat, vel ullamcorper velit sagittis at. Duis ligula arcu, tempor id consectetur vitae, pharetra id arcu. Donec quis faucibus lorem, eu ullamcorper nisl.";
		description = description.replaceAll("\n","<br />");
		
		String paragraphe = "Lorem ipsum dolor sit amet, consectetur adipiscing elit. Sed vitae nulla ut nisl ultrices ultricies. Donec quis elit ante. Curabitur scelerisque mi et elit rhoncus consequat. Proin accumsan tortor quis metus gravida euismod. Proin in scelerisque erat. Vivamus eget ligula mauris. Donec vulputate tortor mollis enim convallis pretium. Duis nec varius felis, et aliquet purus. Mauris leo metus, gravida sed dui ut, consequat molestie augue. Aliquam erat volutpat. Suspendisse non nunc ac erat facilisis scelerisque id et ipsum. Aliquam efficitur euismod est id sollicitudin. Donec condimentum pellentesque porttitor.";
		paragraphe = paragraphe.replaceAll("\n","<br />");
		
		String descriptionApps = "AppsClub est le club informatique de l'ENSAA. Cr�� en Mars 2014, il a d�j� plusieurs �v�nements et activit�s � son actif, et bien d'autres encore sont � venir.\r\n"
				+ "Le principal objectif du club est de d�velopper les comp�tences informatiques des membres, et �tudiants en g�n�ral. Et ce au travers de formations, comp�titions internes et externes, projets...\r\n"
				+ "Le club permet aussi de rassembler les �tudiants de tous les niveaux sous une m�me banni�re, cr�er un esprit de concurrence entre eux, et leur donner acc�s � de nouvelles connaissances.\r\n"
				+ "APPSClub est un groupe d'�tudiants dont l'objectif commun est de dynamiser la sc�ne �v�nementielle informatique au sein de l'ENSA d'Agadir.\r\n"
				+ "\r\n"
				+ "Domaines d'actions:\r\n"
				+ "-Entrepreneuriat digital : Mettre en pratique les comp�tences acquises par les �tudiants en informatique et am�liorer ces comp�tences par l'organisation des formations,cours de soutien et �v�nements.\r\n"
				+ "  Spring Coding Days est un exemple d'�v�nement organis� annullement par le club INFO ayant pour objectif developper l'entrepreneuriat digitale sous forme de solutions web,mobile...\r\n"
				+ "-Innovation et cr�ativit�:Avec la progression rapide des technologies, les �tudiants du club INFO travaillent ensemble pour cr�er des solution innovantes et pr�sentent leur projets innovants lors des manifestations telles que la comp�tition Spring Coding days,\r\n"
				+ "  portes ouvertes d'ESTE et autre comp�titions.\r\n"
				+ "-Solidarit� et volontariat: L'objectif est d'encourager l'entrepreneuriat sociale chez les �tudiants par des cours de soutien,activit�es de b�n�volat aupr�s des associations de la ville Essaouira. \r\n"
				+ "  Les �tudiants organisent des caravanes pour aider et sensibiliser les gens.";
		descriptionApps = descriptionApps.replaceAll("\n","<br />");
		
		String paragrapheApps = "&emsp;AppsClub est le club informatique de l'ENSAA. Cr�� en Mars 2014, il a d�j� plusieurs �v�nements et activit�s � son actif, et bien d'autres encore sont � venir.\r\n"
				+ "Le principal objectif du club est de d�velopper les comp�tences informatiques des membres, et �tudiants en g�n�ral. Et ce au travers de formations, comp�titions internes et externes, projets...\r\n";
		paragrapheApps = paragrapheApps.replaceAll("\n","<br />");
		
		
		String descriptionSocial = "Le club social Ensa Agadir est un groupe de jeunes ing�nieurs, ayant un but est de d�velopper l�esprit d�initiative,\r\n"
				+ "de solidarit� et de responsabilit� tout en se sentant utile � l�ensemble. Pour ce faire, il nous est demand� de passer du quantitatif au travail qualitatif.\r\n"
				+ "\r\n"
				+ "Le Club Social a pour objet l��tude et la connaissance des relations de travail et de la protection sous leurs diff�rents aspects, la promotion de la profession d�experts-comptables dans le domaine social, \r\n"
				+ "l�information et le perfectionnement de ses membres et de leur personnel mais aussi la participation aux d�bats relatifs � l�am�lioration de la l�gislation nationale, europ�enne et internationale.\r\n"
				+ "\r\n"
				+ "Votre participation au Club Social vous permettra de b�n�ficier de conf�rences de haut niveau sur des th�mes sociaux et d�actualit� mais aussi de rencontrer d�autres professionnels.\r\n"
				+ "\r\n"
				+ "Il a adopt� un plan d�actions de communication � destination du public, par le biais de r�unions publiques anim�es par des membres du Club et destin�es � promouvoir le r�le de l�expert-comptable. Il participe �galement � des manifestations publiques et des actions de sensibilisation.\r\n"
				+ "\r\n"
				+ "Date de cr�ation : Ann�e acad�mique 2004/2005\r\n"
				+ "Cr�ateurs : El�ves ing�nieurs anim�s par un esprit de solidarit� et de g�n�rosit�\r\n"
				+ "Domaine d�activit�s: L�int�rieur et l�ext�rieur de l�ENSAA\r\n"
				+ "Population cible : Enfants, jeunes, adultes et vieux\r\n"
				+ "Moyens : De grands c�urs et de bonnes �mes voulant faire le changement et une Ecole qui encourage fortement les activit�s parascolaires.\r\n"
				+ "\r\n"
				+ "\r\n"
				+ "Pourquoi adh�rer ?\r\n"
				+ "Le Club Social vous propose les moyens de cr�er, de d�velopper et de perfectionner une v�ritable activit� de conseil social par une s�rie d�actions d�information et de formation de haut niveau.";
		descriptionSocial = descriptionSocial.replaceAll("\n","<br />");
		
		String paragrapheSocial = "&emsp;Le club social Ensa Agadir est un groupe de jeunes ing�nieurs, ayant un but est de d�velopper l�esprit d�initiative,\r\n"
				+ "de solidarit� et de responsabilit� tout en se sentant utile � l�ensemble. Pour ce faire, il nous est demand� de passer du quantitatif au travail qualitatif.";
		paragrapheSocial = paragrapheSocial.replaceAll("\n","<br />");
		
		
		String descriptionEnactus = "Enactus est une ONG internationale qui oeuvre dans le domaine de l�entrepreneuriat social estudiantin et le d�veloppement durable. Elle a �t� cr��e en 1975, et bas�e � Missouri � USA . Enactus d�veloppe des partenariats entre le monde des affaires et celui de l�enseignement sup�rieur afin de pr�parer les �tudiants � contribuer substantiellement au d�veloppement de leur pays en tant que futurs leaders entrepreneurs, �thiques et socialement responsables.\r\n"
				+ "La cr�ation d�Enactus au Maroc s�est faite en 2003 � l�initiative de M. Adnane Raiss, et depuis, a accompagn� plus de 20 000 �tudiants � s�auto-d�velopper tout en mettant en place annuellement une moyenne de 200 projets de d�veloppement durable.\r\n"
				+ " Notre vision:\r\n"
				+ "   Un monde o� les jeunes, les leaders du monde acad�mique et �conomiques s�engagent dans l�action entrepreneuriale pour favoriser le progr�s soci�tal et fa�onner un monde meilleur et durable.\r\n"
				+ " Notre mission:\r\n"
				+ "   Accompagner les �tudiants dans la mise en �uvre de leurs projets d�entrepreneuriat social, � travers des �v�nements, des formations et des concours nationaux et internationaux.\r\n"
				+ "\r\n"
				+ "Depuis sa cr�ation en 2003, le r�seau d�enactus Morocco ne cesse de grandir. Cette ann�e, Enactus Morocco compte:\r\n"
				+ "Plus de 110 Universit�s, Instituts et �coles d�enseignement sup�rieur\r\n"
				+ "+5500 �tudiants sensibilis�s et mobilis�s\r\n"
				+ "R�seau de plus de 8000 laur�ats Enactus\r\n"
				+ "250 projets et �v�nements annuels\r\n"
				+ "195 000 b�n�ficiaires.";
		descriptionEnactus = descriptionEnactus.replaceAll("\n","<br />");
		
		String paragrapheEnactus = "&emsp;Enactus est une ONG internationale qui oeuvre dans le domaine de l�entrepreneuriat social estudiantin et le d�veloppement durable. Elle a �t� cr��e en 1975, et bas�e � Missouri � USA . Enactus d�veloppe des partenariats entre le monde des affaires et celui de l�enseignement sup�rieur afin de pr�parer les �tudiants � contribuer substantiellement au d�veloppement de leur pays en tant que futurs leaders entrepreneurs, �thiques et socialement responsables.\r\n"
				+ "La cr�ation d�Enactus au Maroc s�est faite en 2003 � l�initiative de M. Adnane Raiss, et depuis, a accompagn� plus de 20 000 �tudiants � s�auto-d�velopper tout en mettant en place annuellement une moyenne de 200 projets de d�veloppement durable.";
		paragrapheEnactus = paragrapheEnactus.replaceAll("\n","<br />");
		
		
		String descriptionBTP = "R�cemment cr��, et seulement en sa premi�re ann�e, le club BTP Agadir, qui s�est instaur� � partir d�une id�e �manant d�un groupe d��l�ments-ing�nieurs enthousiastes et amants de la discipline du grand domaine du G�nie Civil, s�est fix� des objectifs ambitieux. \r\n"
				+ "Son ambition est vive et grandiose. D�di� principalement aux sp�cialisations relatives � la construction, l�infrastructure, l�hydraulique, l�am�nagement de territoire, l�urbanisme, la vision du club et son r�ve intime est  d�apporter son plus � une formation qui s�av�re peu pratique, de faire apprendre hors le cadre militaro-scolaire, de promouvoir l��clat, le rayonnement et la performance des professions de BTP, ainsi que le renforcement des connaissances techniques et scientifiques dans le domaine et l�initiation au domaine professionnel.\r\n"
				+ "\r\n"
				+ "Dans l�agenda : des visites sur chantiers, des s�minaires, des formations, des comp�titions, des conf�rences, des �v�nements, et ceci dans une ambiance conviviale. Pour atteindre ses objectifs, il s�est dot� d�une �quipe motiv�e, dynamique et tr�s combattante.\r\n"
				+ "Le 02 /02 dernier, s�est tenue sa toute premi�re manifestation : la Mini-journ�e GC. Lanc�e sous le th�me � le BIM : Un processus r�volutionnaire et prometteur pour la digitalisation du domaine de la construction �, la manifestation a connu la participation de nombreux anciens laur�ats, d�enseignants et de dirigeants de l�EHTP. Elle s�est d�roul�e en 4 temps: Une ouverture, une comp�tition, une table ronde qui a vu naitre un �change fructueux entre laur�ats et �tudiants et une conf�rence sur ledit th�me assur�e par des conf�renciers de haut calibre. La comp�tition s�est tenue gr�ce au soutien de la soci�t� EngiMa : Notre partenaire.\r\n"
				+ "Le choix de ce sujet a �t� largement pris� par l�ensemble des commentateurs. Ceci �tant d� au fait que ce concept naissant, qui est le BIM, suscite plein d�enthousiasme d�une part, et d�autre part �norm�ment de questions et d�inqui�tudes.\r\n"
				+ "\r\n"
				+ "C��tait l�occasion r�v�e de rompre avec la routine du quotidien, d�introduire une discontinuit� dans cette vaste platitude, de  partager des moments d��motions et de fraternit�. C��tait aussi un moment de retrouvailles et de bonheur partag� entre les diff�rents acteurs pr�sents.";
		descriptionBTP = descriptionBTP.replaceAll("\n","<br />");
		
		String paragrapheBTP = "&emsp;R�cemment cr��, et seulement en sa premi�re ann�e, le club BTP Agadir, qui s�est instaur� � partir d�une id�e �manant d�un groupe d��l�ments-ing�nieurs enthousiastes et amants de la discipline du grand domaine du G�nie Civil, s�est fix� des objectifs ambitieux. \r\n"
				+ "Son ambition est vive et grandiose. D�di� principalement aux sp�cialisations relatives � la construction, l�infrastructure, l�hydraulique, l�am�nagement de territoire, l�urbanisme, la vision du club et son r�ve intime est  d�apporter son plus � une formation qui s�av�re peu pratique, de faire apprendre hors le cadre militaro-scolaire, de promouvoir l��clat, le rayonnement et la performance des professions de BTP, ainsi que le renforcement des connaissances techniques et scientifiques dans le domaine et l�initiation au domaine professionnel.";
		paragrapheBTP = paragrapheBTP.replaceAll("\n","<br />");
		
		
		String descriptionSportif = "Cr�� en 2006, le Club Sportif ENSA Agadir est l�un des plus anciens clubs a l'�cole. Il a su se b�tir un palmar�s exceptionnel pour atteindre son apog�e dans les ann�es 1950 et 1960 puis pour y revenir � la fin des ann�es 90.\r\n"
				+ "\r\n"
				+ "Combativit�, rigueur, solidarit�, humilit� et enthousiasme : le CSSA a toujours v�hicul� des valeurs fortes, � l'image d�un club simple mais ambitieux.\r\n"
				+ "\r\n"
				+ "Entre 1954 et 1975, le CSSA a donn� quinze internationaux et deux entra�neurs � l'�quipe de France, ainsi que des internationaux � de nombreuses �quipes africaines.\r\n"
				+ "\r\n"
				+ "C'est en 2013 que Marc Dubois, pr�sident du Groupe APLUS�, d�cide de revenir � ses racines ardennaises en prenant le contr�le du CSSA, en m�moire de son p�re.\r\n"
				+ "\r\n"
				+ "Trois objectifs s'imposent naturellement au CSSA Partners Team :\r\n"
				+ "- Redonner ses lettres de noblesse � un club identitaire et populaire au pass� prestigieux en rejoignant au plus vite le niveau professionnel.\r\n"
				+ "- Renforcer l�ADN historique du club � travers la d�tection, la formation de jeunes joueurs prometteurs, l'optimisation des performances physiques et mentales ainsi que le trading.\r\n"
				+ "- Associer le CSSA au c�ur d�un projet ambitieux li� � l'expertise � Pr�vention Sant�, Bien-�tre et Sport � du Groupe APLUS� tout en valorisant le territoire de l'Ardenne transfrontali�re : le concept � MySens� �.";
		descriptionSportif = descriptionSportif.replaceAll("\n","<br />");
		
		String paragrapheSportif = "&emsp;Cr�� en 2006, le Club Sportif ENSA Agadir est l�un des plus anciens clubs a l'�cole. Il a su se b�tir un palmar�s exceptionnel pour atteindre son apog�e dans les ann�es 1950 et 1960 puis pour y revenir � la fin des ann�es 90.";
		paragrapheSportif = paragrapheSportif.replaceAll("\n","<br />");
		
		
		
		daoEtudiant = new DaoEtudiantImpl(factory);
        daoRespo = new DaoResponsableClubImpl(factory);
        daoAdministrateur = new DaoAdministrateurImpl(factory);
        daoClub = new DaoClubImpl(factory);
        daoActivite = new DaoActiviteImpl(factory);
        daoAppartenance = new DaoAppartenanceImpl(factory);
        DaoDemandeInscription=new DaoDemandeInscriptionImpl(factory);
        
        
        
        
        
		Administrateur administrateur=new Administrateur("admin@uiz.ac.ma",formm.Hashing("admin"));		
		daoAdministrateur.add(administrateur);
        
        
		
        Etudiant etd1 = new Etudiant("youness.iharchine@edu.uiz.ac.ma", formm.Hashing("youness"));
        etd1.setNom("Iharchine");
        etd1.setPrenom("Youness");
        etd1.setCne("D135338707");
        etd1.setFiliere("G�nie Informatique");
        etd1.setPays("Maroc");
        etd1.setVille("Tiznit");
        daoEtudiant.add(etd1);
   
        Etudiant etd2 = new Etudiant("younes.kellouch@edu.uiz.ac.ma", formm.Hashing("younes"));
        etd2.setNom("Kellouch");
        etd2.setPrenom("Younes");
        etd2.setCne("D225487965");
        etd2.setFiliere("G�nie Informatique");
        etd2.setPays("Maroc");
        etd2.setVille("Azrou l3assima");
        daoEtudiant.add(etd2);
		
        Etudiant etd3 = new Etudiant("zainaba.essalhi@edu.uiz.ac.ma", formm.Hashing("zainaba"));
        etd3.setNom("Essalhi");
        etd3.setPrenom("Zainaba");
        etd3.setCne("D885478965");
        etd3.setFiliere("G�nie Informatique");
        etd3.setPays("Maroc");
        etd3.setVille("Ait Iazza");
        daoEtudiant.add(etd3);
        
        Etudiant etd4 = new Etudiant("amine.harka@edu.uiz.ac.ma", formm.Hashing("amine"));
        etd4.setNom("Harka");
        etd4.setPrenom("Amine");
        etd4.setCne("D542189654");
        etd4.setFiliere("G�nie Industrielle");
        etd4.setPays("Maroc");
        etd4.setVille("Taroudant");
        daoEtudiant.add(etd4);
        
        Etudiant etd5 = new Etudiant("oussama.makhlouk@login.etd", formm.Hashing("oussama"));
        etd5.setNom("Makhlouk");
        etd5.setPrenom("Oussama");
        etd5.setCne("D236547896");
        etd5.setFiliere("G�nie Informatique");
        etd5.setPays("Maroc");
        etd5.setVille("Agadir");
        daoEtudiant.add(etd5);
        
        Etudiant etd6 = new Etudiant("imane.erguiti@edu.uiz.ac.ma", formm.Hashing("imane"));
        etd6.setNom("Erguiti");
        etd6.setPrenom("Imane");
        etd6.setCne("D542365896");
        etd6.setFiliere("G�nie Informatique");
        etd6.setPays("Maroc");
        etd6.setVille("Agadir");
        daoEtudiant.add(etd6);
        
        Etudiant etd7 = new Etudiant("ayoub.grioui@edu.uiz.ac.ma", formm.Hashing("ayoub"));
        etd7.setNom("Grioui");
        etd7.setPrenom("Ayoub");
        etd7.setCne("D210589601");
        etd7.setFiliere("G�nie Informatique");
        etd7.setPays("Maroc");
        etd7.setVille("Temsia");
        daoEtudiant.add(etd7);
        
        Etudiant etd8 = new Etudiant("prenom.nom@edu.uiz.ac.ma", formm.Hashing("prenom"));
        etd8.setNom("Nom");
        etd8.setPrenom("Prenom");
        etd8.setCne("D123456789");
        etd8.setFiliere("G�nie Informatique");
        etd8.setPays("Maroc");
        etd8.setVille("Agadir");
        daoEtudiant.add(etd8);
        
        

        ResponsableClub respo1 = new ResponsableClub("appsclub@uiz.ac.ma", formm.Hashing("appsclub"));
        ResponsableClub respo2 = new ResponsableClub("social@uiz.ac.ma", formm.Hashing("social"));
        ResponsableClub respo3 = new ResponsableClub("enactus@uiz.ac.ma", formm.Hashing("enactus"));
        ResponsableClub respo4 = new ResponsableClub("btp@uiz.ac.ma", formm.Hashing("btp"));
        ResponsableClub respo5 = new ResponsableClub("sportif@uiz.ac.ma", formm.Hashing("sportif"));
        daoRespo.add(respo1);
        daoRespo.add(respo2);
        daoRespo.add(respo3);
        daoRespo.add(respo4);
        daoRespo.add(respo5);
        
        
        
        Club club1 = new Club();
        club1.setName("AppsClub");
        club1.setResponsableClub(daoRespo.find(10));
        club1.setDescription(descriptionApps);
        club1.setParagraphe(paragrapheApps);
        club1.setLogoPath("apps.jpg");
        club1.setCoverPath("appsclub cover.jpg");
        club1.setImg1Path("image2.jpeg");
        club1.setImg2Path("image3.jpeg");
        club1.setImg3Path("image4.jpeg");
        daoClub.add(club1);
        
        Club club2 = new Club();
        club2.setName("Social");
        club2.setResponsableClub(daoRespo.find(11));
        club2.setDescription(descriptionSocial);
        club2.setParagraphe(paragrapheSocial);
        club2.setLogoPath("social.jfif");
        club2.setCoverPath("social cover.jpg");
        club2.setImg1Path("image2.jpeg");
        club2.setImg2Path("image3.jpeg");
        club2.setImg3Path("image4.jpeg");
        daoClub.add(club2);
        
        Club club3 = new Club();
        club3.setName("Enactus");
        club3.setResponsableClub(daoRespo.find(12));
        club3.setDescription(descriptionEnactus);
        club3.setParagraphe(paragrapheEnactus);
        club3.setLogoPath("enactus1.jpg");
        club3.setCoverPath("enactus cover.jpg");
        club3.setImg1Path("image2.jpeg");
        club3.setImg2Path("image3.jpeg");
        club3.setImg3Path("image4.jpeg");
        daoClub.add(club3);
        
        Club club4 = new Club();
        club4.setName("BTP");
        club4.setResponsableClub(daoRespo.find(13));
        club4.setDescription(descriptionBTP);
        club4.setParagraphe(paragrapheBTP);
        club4.setLogoPath("btp.jfif");
        club4.setCoverPath("btp cover.jpg");
        club4.setImg1Path("image2.jpeg");
        club4.setImg2Path("image3.jpeg");
        club4.setImg3Path("image4.jpeg");
        daoClub.add(club4);
        
        Club club5 = new Club();
        club5.setName("Sportif");
        club5.setResponsableClub(daoRespo.find(14));
        club5.setDescription(descriptionSportif);
        club5.setParagraphe(paragrapheSportif);
        club5.setLogoPath("sportif.jfif");
        club5.setCoverPath("sportif cover.jpg");
        club5.setImg1Path("image2.jpeg");
        club5.setImg2Path("image3.jpeg");
        club5.setImg3Path("image4.jpeg");
        daoClub.add(club5);
        
        this.getServletContext().setAttribute("club", daoClub.lister());
        
        
        
        Appartenance appartenance1 = new Appartenance(daoEtudiant.find(2), daoClub.find(1), strDate);
        daoAppartenance.add(appartenance1);
     
        Appartenance appartenance2 = new Appartenance(daoEtudiant.find(2), daoClub.find(3), strDate);
        daoAppartenance.add(appartenance2);
        
        Appartenance appartenance3 = new Appartenance(daoEtudiant.find(2), daoClub.find(4), strDate);
        daoAppartenance.add(appartenance3);
        
        
        Appartenance appartenance4 = new Appartenance(daoEtudiant.find(3), daoClub.find(1), strDate);
        daoAppartenance.add(appartenance4);
     
        Appartenance appartenance5 = new Appartenance(daoEtudiant.find(3), daoClub.find(4), strDate);
        daoAppartenance.add(appartenance5);
        
        Appartenance appartenance6 = new Appartenance(daoEtudiant.find(3), daoClub.find(5), strDate);
        daoAppartenance.add(appartenance6);
        
        
        Appartenance appartenance7 = new Appartenance(daoEtudiant.find(4), daoClub.find(1), strDate);
        daoAppartenance.add(appartenance7);
     
        Appartenance appartenance8 = new Appartenance(daoEtudiant.find(4), daoClub.find(2), strDate);
        daoAppartenance.add(appartenance8);
        
        Appartenance appartenance9 = new Appartenance(daoEtudiant.find(4), daoClub.find(3), strDate);
        daoAppartenance.add(appartenance9);
        
        
        Appartenance appartenance10 = new Appartenance(daoEtudiant.find(5), daoClub.find(2), strDate);
        daoAppartenance.add(appartenance10);
     
        Appartenance appartenance11 = new Appartenance(daoEtudiant.find(5), daoClub.find(4), strDate);
        daoAppartenance.add(appartenance11);
        
        Appartenance appartenance12 = new Appartenance(daoEtudiant.find(5), daoClub.find(5), strDate);
        daoAppartenance.add(appartenance12);
        
        
        
        DemandeInscription demande1=new DemandeInscription(daoEtudiant.find(2), daoClub.find(2), strDate);
        DaoDemandeInscription.add(demande1);
        
        DemandeInscription demande2=new DemandeInscription(daoEtudiant.find(2), daoClub.find(5), strDate);
        DaoDemandeInscription.add(demande2);
        
        
        DemandeInscription demande3=new DemandeInscription(daoEtudiant.find(3), daoClub.find(2), strDate);
        DaoDemandeInscription.add(demande3);
        
        DemandeInscription demande4=new DemandeInscription(daoEtudiant.find(3), daoClub.find(3), strDate);
        DaoDemandeInscription.add(demande4);
        
        
        DemandeInscription demande5=new DemandeInscription(daoEtudiant.find(4), daoClub.find(4), strDate);
        DaoDemandeInscription.add(demande5);
        
        DemandeInscription demande6=new DemandeInscription(daoEtudiant.find(4), daoClub.find(5), strDate);
        DaoDemandeInscription.add(demande6);
        
        
        DemandeInscription demande7=new DemandeInscription(daoEtudiant.find(5), daoClub.find(1), strDate);
        DaoDemandeInscription.add(demande7);
        
        DemandeInscription demande8=new DemandeInscription(daoEtudiant.find(5), daoClub.find(3), strDate);
        DaoDemandeInscription.add(demande8);
        
        
        
     
        Activite activite1 = new Activite();
        activite1.setNom("Activite 1-1");
        activite1.setClub(daoClub.find(1));
        activite1.setLieu("Lieu 1-1");
        activite1.setPrivee(false);
        activite1.setDate("11/05/2021");
        activite1.setImagePath("image3.jpeg");
        daoActivite.add(activite1);
        
        Activite activite2 = new Activite();
        activite2.setNom("Activite 1-2");
        activite2.setClub(daoClub.find(1));
        activite2.setLieu("Lieu 1-2");
        activite2.setPrivee(true);
        activite2.setDate("01/11/2021");
        activite2.setImagePath("image3.jpeg");
        daoActivite.add(activite2);
        
        Activite activite3 = new Activite();
        activite3.setNom("Activite 2-1");
        activite3.setClub(daoClub.find(2));
        activite3.setLieu("Lieu 2-1");
        activite3.setPrivee(false);
        activite3.setDate("22/05/2021");
        activite3.setImagePath("image3.jpeg");
        daoActivite.add(activite3);
        
        Activite activite4 = new Activite();
        activite4.setNom("Activite 2-2");
        activite4.setClub(daoClub.find(2));
        activite4.setLieu("Lieu 2-2");
        activite4.setPrivee(true);
        activite4.setDate("02/12/2021");
        activite4.setImagePath("image3.jpeg");
        daoActivite.add(activite4);
        
        Activite activite5 = new Activite();
        activite5.setNom("Activite 3-1");
        activite5.setClub(daoClub.find(3));
        activite5.setLieu("Lieu 3-1");
        activite5.setPrivee(false);
        activite5.setDate("13/05/2021");
        activite5.setImagePath("image3.jpeg");
        daoActivite.add(activite5);
        
        Activite activite6 = new Activite();
        activite6.setNom("Activite 3-2");
        activite6.setClub(daoClub.find(3));
        activite6.setLieu("Lieu 3-2");
        activite6.setPrivee(true);
        activite6.setDate("03/11/2021");
        activite6.setImagePath("image3.jpeg");
        daoActivite.add(activite6);
        
        Activite activite7 = new Activite();
        activite7.setNom("Activite 4-1");
        activite7.setClub(daoClub.find(4));
        activite7.setLieu("Lieu 4-1");
        activite7.setPrivee(false);
        activite7.setDate("14/05/2021");
        activite7.setImagePath("image3.jpeg");
        daoActivite.add(activite7);
        
        Activite activite8 = new Activite();
        activite8.setNom("Activite 4-2");
        activite8.setClub(daoClub.find(4));
        activite8.setLieu("Lieu 4-2");
        activite8.setPrivee(true);
        activite8.setDate("04/12/2021");
        activite8.setImagePath("image3.jpeg");
        daoActivite.add(activite8);
        
        Activite activite9 = new Activite();
        activite9.setNom("Activite 5-1");
        activite9.setClub(daoClub.find(5));
        activite9.setLieu("Lieu 5-1");
        activite9.setPrivee(false);
        activite9.setDate("15/05/2021");
        activite9.setImagePath("image3.jpeg");
        daoActivite.add(activite9);
        
        Activite activite10 = new Activite();
        activite10.setNom("Activite 5-2");
        activite10.setClub(daoClub.find(5));
        activite10.setLieu("Lieu 5-2");
        activite10.setPrivee(true);
        activite10.setDate("05/11/2021");
        activite10.setImagePath("image3.jpeg");
        daoActivite.add(activite10);
        
        
        Activite activite11 = new Activite();
        activite11.setNom("Activite 1-3");
        activite11.setClub(daoClub.find(1));
        activite11.setLieu("Lieu 1-3");
        activite11.setPrivee(true);
        activite11.setDate("01/11/2020");
        activite11.setImagePath("image3.jpeg");
        daoActivite.add(activite11);
        
        Activite activite12 = new Activite();
        activite12.setNom("Activite 2-3");
        activite12.setClub(daoClub.find(2));
        activite12.setLieu("Lieu 2-3");
        activite12.setPrivee(true);
        activite12.setDate("02/11/2020");
        activite12.setImagePath("image3.jpeg");
        daoActivite.add(activite12);
        
        Activite activite13 = new Activite();
        activite13.setNom("Activite 3-3");
        activite13.setClub(daoClub.find(3));
        activite13.setLieu("Lieu 3-3");
        activite13.setPrivee(true);
        activite13.setDate("03/11/2020");
        activite13.setImagePath("image3.jpeg");
        daoActivite.add(activite13);
        
        Activite activite14 = new Activite();
        activite14.setNom("Activite 4-3");
        activite14.setClub(daoClub.find(4));
        activite14.setLieu("Lieu 4-3");
        activite14.setPrivee(true);
        activite14.setDate("04/11/2020");
        activite14.setImagePath("image3.jpeg");
        daoActivite.add(activite14);
        
        Activite activite15 = new Activite();
        activite15.setNom("Activite 5-3");
        activite15.setClub(daoClub.find(5));
        activite15.setLieu("Lieu 5-3");
        activite15.setPrivee(true);
        activite15.setDate("05/11/2020");
        activite15.setImagePath("image3.jpeg");
        daoActivite.add(activite15);
        

        
      
        
        
        
        response.sendRedirect(request.getContextPath()+"/Accueil");
	}


}
