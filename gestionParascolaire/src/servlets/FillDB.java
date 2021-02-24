package servlets;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Random;

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
		
        CreerClubForm form = new CreerClubForm(daoClub);
		
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
		
		String descriptionApps = "AppsClub est le club informatique de l'ENSAA. Créé en Mars 2014, il a déjà plusieurs événements et activités à son actif, et bien d'autres encore sont à venir.\r\n"
				+ "Le principal objectif du club est de développer les compétences informatiques des membres, et étudiants en général. Et ce au travers de formations, compétitions internes et externes, projets...\r\n"
				+ "Le club permet aussi de rassembler les étudiants de tous les niveaux sous une même bannière, créer un esprit de concurrence entre eux, et leur donner accès à de nouvelles connaissances.\r\n"
				+ "APPSClub est un groupe d'étudiants dont l'objectif commun est de dynamiser la scène événementielle informatique au sein de l'ENSA d'Agadir.\r\n"
				+ "\r\n"
				+ "Domaines d'actions:\r\n"
				+ "-Entrepreneuriat digital : Mettre en pratique les compétences acquises par les étudiants en informatique et améliorer ces compétences par l'organisation des formations,cours de soutien et événements.\r\n"
				+ "  Spring Coding Days est un exemple d'événement organisé annullement par le club INFO ayant pour objectif developper l'entrepreneuriat digitale sous forme de solutions web,mobile...\r\n"
				+ "-Innovation et créativité:Avec la progression rapide des technologies, les étudiants du club INFO travaillent ensemble pour créer des solution innovantes et présentent leur projets innovants lors des manifestations telles que la compétition Spring Coding days,\r\n"
				+ "  portes ouvertes d'ESTE et autre compétitions.\r\n"
				+ "-Solidarité et volontariat: L'objectif est d'encourager l'entrepreneuriat sociale chez les étudiants par des cours de soutien,activitées de bénévolat auprès des associations de la ville Essaouira. \r\n"
				+ "  Les étudiants organisent des caravanes pour aider et sensibiliser les gens.";
		descriptionApps = descriptionApps.replaceAll("\n","<br />");
		
		String paragrapheApps = "&emsp;AppsClub est le club informatique de l'ENSAA. Créé en Mars 2014, il a déjà plusieurs événements et activités à son actif, et bien d'autres encore sont à venir.\r\n"
				+ "Le principal objectif du club est de développer les compétences informatiques des membres, et étudiants en général. Et ce au travers de formations, compétitions internes et externes, projets...";
		paragrapheApps = paragrapheApps.replaceAll("\n","<br />");
		
		
		String descriptionSocial = "Le club social Ensa Agadir est un groupe de jeunes ingénieurs, ayant un but est de développer l’esprit d’initiative,\r\n"
				+ "de solidarité et de responsabilité tout en se sentant utile à l’ensemble. Pour ce faire, il nous est demandé de passer du quantitatif au travail qualitatif.\r\n"
				+ "\r\n"
				+ "Le Club Social a pour objet l’étude et la connaissance des relations de travail et de la protection sous leurs différents aspects, la promotion de la profession d’experts-comptables dans le domaine social, \r\n"
				+ "l’information et le perfectionnement de ses membres et de leur personnel mais aussi la participation aux débats relatifs à l’amélioration de la législation nationale, européenne et internationale.\r\n"
				+ "\r\n"
				+ "Votre participation au Club Social vous permettra de bénéficier de conférences de haut niveau sur des thèmes sociaux et d’actualité mais aussi de rencontrer d’autres professionnels.\r\n"
				+ "\r\n"
				+ "Il a adopté un plan d’actions de communication à destination du public, par le biais de réunions publiques animées par des membres du Club et destinées à promouvoir le rôle de l’expert-comptable. Il participe également à des manifestations publiques et des actions de sensibilisation.\r\n"
				+ "\r\n"
				+ "Date de création : Année académique 2004/2005\r\n"
				+ "Créateurs : Elèves ingénieurs animés par un esprit de solidarité et de générosité\r\n"
				+ "Domaine d’activités: L’intérieur et l’extérieur de l’ENSAA\r\n"
				+ "Population cible : Enfants, jeunes, adultes et vieux\r\n"
				+ "Moyens : De grands cœurs et de bonnes âmes voulant faire le changement et une Ecole qui encourage fortement les activités parascolaires.\r\n"
				+ "\r\n"
				+ "\r\n"
				+ "Pourquoi adhérer ?\r\n"
				+ "Le Club Social vous propose les moyens de créer, de développer et de perfectionner une véritable activité de conseil social par une série d’actions d’information et de formation de haut niveau.\r\n";
		descriptionSocial = descriptionSocial.replaceAll("\n","<br />");
		
		String paragrapheSocial = "&emsp;Le club social Ensa Agadir est un groupe de jeunes ingénieurs, ayant un but est de développer l’esprit d’initiative,\r\n"
				+ "de solidarité et de responsabilité tout en se sentant utile à l’ensemble. Pour ce faire, il nous est demandé de passer du quantitatif au travail qualitatif.";
		paragrapheSocial = paragrapheSocial.replaceAll("\n","<br />");
		
		
		String descriptionEnactus = "Enactus est une ONG internationale qui oeuvre dans le domaine de l’entrepreneuriat social estudiantin et le développement durable. Elle a été créée en 1975, et basée à Missouri – USA . Enactus développe des partenariats entre le monde des affaires et celui de l‘enseignement supérieur afin de préparer les étudiants à contribuer substantiellement au développement de leur pays en tant que futurs leaders entrepreneurs, éthiques et socialement responsables.\r\n"
				+ "La création d’Enactus au Maroc s’est faite en 2003 à l’initiative de M. Adnane Raiss, et depuis, a accompagné plus de 20 000 étudiants à s’auto-développer tout en mettant en place annuellement une moyenne de 200 projets de développement durable.\r\n"
				+ " Notre vision:\r\n"
				+ "   Un monde où les jeunes, les leaders du monde académique et économiques s’engagent dans l’action entrepreneuriale pour favoriser le progrès sociétal et façonner un monde meilleur et durable.\r\n"
				+ " Notre mission:\r\n"
				+ "   Accompagner les étudiants dans la mise en œuvre de leurs projets d’entrepreneuriat social, à travers des événements, des formations et des concours nationaux et internationaux.\r\n"
				+ "\r\n"
				+ "Depuis sa création en 2003, le réseau d’enactus Morocco ne cesse de grandir. Cette année, Enactus Morocco compte:\r\n"
				+ "Plus de 110 Universités, Instituts et écoles d’enseignement supérieur\r\n"
				+ "+5500 étudiants sensibilisés et mobilisés\r\n"
				+ "Réseau de plus de 8000 lauréats Enactus\r\n"
				+ "250 projets et événements annuels\r\n"
				+ "195 000 bénéficiaires.";
		descriptionEnactus = descriptionEnactus.replaceAll("\n","<br />");
		
		String paragrapheEnactus = "&emsp;Enactus est une ONG internationale qui oeuvre dans le domaine de l’entrepreneuriat social estudiantin et le développement durable. Elle a été créée en 1975, et basée à Missouri – USA . Enactus développe des partenariats entre le monde des affaires et celui de l‘enseignement supérieur afin de préparer les étudiants à contribuer substantiellement au développement de leur pays en tant que futurs leaders entrepreneurs, éthiques et socialement responsables.\r\n"
				+ "La création d’Enactus au Maroc s’est faite en 2003 à l’initiative de M. Adnane Raiss, et depuis, a accompagné plus de 20 000 étudiants à s’auto-développer tout en mettant en place annuellement une moyenne de 200 projets de développement durable.";
		paragrapheEnactus = paragrapheEnactus.replaceAll("\n","<br />");
		
		
		String descriptionBTP = "Récemment créé, et seulement en sa première année, le club BTP Agadir, qui s’est instauré à partir d’une idée émanant d’un groupe d’éléments-ingénieurs enthousiastes et amants de la discipline du grand domaine du Génie Civil, s’est fixé des objectifs ambitieux. \r\n"
				+ "Son ambition est vive et grandiose. Dédié principalement aux spécialisations relatives à la construction, l’infrastructure, l’hydraulique, l’aménagement de territoire, l’urbanisme, la vision du club et son rêve intime est  d’apporter son plus à une formation qui s’avère peu pratique, de faire apprendre hors le cadre militaro-scolaire, de promouvoir l’éclat, le rayonnement et la performance des professions de BTP, ainsi que le renforcement des connaissances techniques et scientifiques dans le domaine et l’initiation au domaine professionnel.\r\n"
				+ "\r\n"
				+ "Dans l’agenda : des visites sur chantiers, des séminaires, des formations, des compétitions, des conférences, des évènements, et ceci dans une ambiance conviviale. Pour atteindre ses objectifs, il s’est doté d’une équipe motivée, dynamique et très combattante.\r\n"
				+ "Le 02 /02 dernier, s’est tenue sa toute première manifestation : la Mini-journée GC. Lancée sous le thème « le BIM : Un processus révolutionnaire et prometteur pour la digitalisation du domaine de la construction », la manifestation a connu la participation de nombreux anciens lauréats, d’enseignants et de dirigeants de l’EHTP. Elle s’est déroulée en 4 temps: Une ouverture, une compétition, une table ronde qui a vu naitre un échange fructueux entre lauréats et étudiants et une conférence sur ledit thème assurée par des conférenciers de haut calibre. La compétition s’est tenue grâce au soutien de la société EngiMa : Notre partenaire.\r\n"
				+ "Le choix de ce sujet a été largement prisé par l’ensemble des commentateurs. Ceci étant dû au fait que ce concept naissant, qui est le BIM, suscite plein d’enthousiasme d’une part, et d’autre part énormément de questions et d’inquiétudes.\r\n"
				+ "\r\n"
				+ "C’était l’occasion rêvée de rompre avec la routine du quotidien, d’introduire une discontinuité dans cette vaste platitude, de  partager des moments d’émotions et de fraternité. C’était aussi un moment de retrouvailles et de bonheur partagé entre les différents acteurs présents.";
		descriptionBTP = descriptionBTP.replaceAll("\n","<br />");
		
		String paragrapheBTP = "&emsp;Récemment créé, et seulement en sa première année, le club BTP Agadir, qui s’est instauré à partir d’une idée émanant d’un groupe d’éléments-ingénieurs enthousiastes et amants de la discipline du grand domaine du Génie Civil, s’est fixé des objectifs ambitieux. \r\n"
				+ "Son ambition est vive et grandiose. Dédié principalement aux spécialisations relatives à la construction, l’infrastructure, l’hydraulique, l’aménagement de territoire, l’urbanisme, la vision du club et son rêve intime est  d’apporter son plus à une formation qui s’avère peu pratique, de faire apprendre hors le cadre militaro-scolaire, de promouvoir l’éclat, le rayonnement et la performance des professions de BTP, ainsi que le renforcement des connaissances techniques et scientifiques dans le domaine et l’initiation au domaine professionnel.";
		paragrapheBTP = paragrapheBTP.replaceAll("\n","<br />");
		
		
		String descriptionSportif = "Créé en 2006, le Club Sportif ENSA Agadir est l’un des plus anciens clubs a l'école. Il a su se bâtir un palmarès exceptionnel pour atteindre son apogée dans les années 1950 et 1960 puis pour y revenir à la fin des années 90.\r\n"
				+ "\r\n"
				+ "Combativité, rigueur, solidarité, humilité et enthousiasme : le CSSA a toujours véhiculé des valeurs fortes, à l'image d’un club simple mais ambitieux.\r\n"
				+ "\r\n"
				+ "Entre 1954 et 1975, le CSSA a donné quinze internationaux et deux entraîneurs à l'équipe de France, ainsi que des internationaux à de nombreuses équipes africaines.\r\n"
				+ "\r\n"
				+ "C'est en 2013 que Marc Dubois, président du Groupe APLUS®, décide de revenir à ses racines ardennaises en prenant le contrôle du CSSA, en mémoire de son père.\r\n"
				+ "\r\n"
				+ "Trois objectifs s'imposent naturellement au CSSA Partners Team :\r\n"
				+ "- Redonner ses lettres de noblesse à un club identitaire et populaire au passé prestigieux en rejoignant au plus vite le niveau professionnel.\r\n"
				+ "- Renforcer l’ADN historique du club à travers la détection, la formation de jeunes joueurs prometteurs, l'optimisation des performances physiques et mentales ainsi que le trading.\r\n"
				+ "- Associer le CSSA au cœur d’un projet ambitieux lié à l'expertise « Prévention Santé, Bien-être et Sport » du Groupe APLUS® tout en valorisant le territoire de l'Ardenne transfrontalière : le concept « MySens® ».";
		descriptionSportif = descriptionSportif.replaceAll("\n","<br />");
		
		String paragrapheSportif = "&emsp;Créé en 2006, le Club Sportif ENSA Agadir est l’un des plus anciens clubs a l'école. Il a su se bâtir un palmarès exceptionnel pour atteindre son apogée dans les années 1950 et 1960 puis pour y revenir à la fin des années 90.\r\n"
				+ "Combativité, rigueur, solidarité, humilité et enthousiasme : le CSSA a toujours véhiculé des valeurs fortes, à l'image d’un club simple mais ambitieux.";
		paragrapheSportif = paragrapheSportif.replaceAll("\n","<br />");
		
		
		
		daoEtudiant = new DaoEtudiantImpl(factory);
        daoRespo = new DaoResponsableClubImpl(factory);
        daoAdministrateur = new DaoAdministrateurImpl(factory);
        daoClub = new DaoClubImpl(factory);
        daoActivite = new DaoActiviteImpl(factory);
        daoAppartenance = new DaoAppartenanceImpl(factory);
        DaoDemandeInscription=new DaoDemandeInscriptionImpl(factory);
        
        
        
        
        
		Administrateur administrateur=new Administrateur("admin@uiz.ac.ma",form.Hashing("admin"));		
		daoAdministrateur.add(administrateur);
        
        
		
        Etudiant etd1 = new Etudiant("youness.iharchine@edu.uiz.ac.ma", form.Hashing("youness"));
        etd1.setNom("Iharchine");
        etd1.setPrenom("Youness");
        etd1.setCne("D135338707");
        etd1.setFiliere("Génie Informatique");
        etd1.setPays("Maroc");
        etd1.setVille("Tiznit");
        daoEtudiant.add(etd1);
   
        Etudiant etd2 = new Etudiant("younes.kellouch@edu.uiz.ac.ma", form.Hashing("younes"));
        etd2.setNom("Kellouch");
        etd2.setPrenom("Younes");
        etd2.setCne("D225487965");
        etd2.setFiliere("Génie Informatique");
        etd2.setPays("Maroc");
        etd2.setVille("Azrou l3assima");
        daoEtudiant.add(etd2);
		
        Etudiant etd3 = new Etudiant("zainaba.essalhi@edu.uiz.ac.ma", form.Hashing("zainaba"));
        etd3.setNom("Essalhi");
        etd3.setPrenom("Zainaba");
        etd3.setCne("D885478965");
        etd3.setFiliere("Génie Informatique");
        etd3.setPays("Maroc");
        etd3.setVille("Ait Iazza");
        daoEtudiant.add(etd3);
        
        Etudiant etd4 = new Etudiant("amine.harka@edu.uiz.ac.ma", form.Hashing("amine"));
        etd4.setNom("Harka");
        etd4.setPrenom("Amine");
        etd4.setCne("D542189654");
        etd4.setFiliere("Génie Industrielle");
        etd4.setPays("Maroc");
        etd4.setVille("Taroudant");
        daoEtudiant.add(etd4);
        
        Etudiant etd5 = new Etudiant("oussama.makhlouk@login.etd", form.Hashing("oussama"));
        etd5.setNom("Makhlouk");
        etd5.setPrenom("Oussama");
        etd5.setCne("D236547896");
        etd5.setFiliere("Génie Informatique");
        etd5.setPays("Maroc");
        etd5.setVille("Agadir");
        daoEtudiant.add(etd5);
        
        Etudiant etd6 = new Etudiant("imane.erguiti@edu.uiz.ac.ma", form.Hashing("imane"));
        etd6.setNom("Erguiti");
        etd6.setPrenom("Imane");
        etd6.setCne("D542365896");
        etd6.setFiliere("Génie Informatique");
        etd6.setPays("Maroc");
        etd6.setVille("Agadir");
        daoEtudiant.add(etd6);
        
        Etudiant etd7 = new Etudiant("ayoub.grioui@edu.uiz.ac.ma", form.Hashing("ayoub"));
        etd7.setNom("Grioui");
        etd7.setPrenom("Ayoub");
        etd7.setCne("D210589601");
        etd7.setFiliere("Génie Informatique");
        etd7.setPays("Maroc");
        etd7.setVille("Temsia");
        daoEtudiant.add(etd7);
        
        Etudiant etd8 = new Etudiant("prenom.nom@edu.uiz.ac.ma", form.Hashing("prenom"));
        etd8.setNom("Nom");
        etd8.setPrenom("Prenom");
        etd8.setCne("D123456789");
        etd8.setFiliere("Génie Informatique");
        etd8.setPays("Maroc");
        etd8.setVille("Agadir");
        daoEtudiant.add(etd8);
        
        
        
        
        ResponsableClub respo1 = new ResponsableClub("appsclub@uiz.ac.ma", form.Hashing("appsclub"));
        ResponsableClub respo2 = new ResponsableClub("social@uiz.ac.ma", form.Hashing("social"));
        ResponsableClub respo3 = new ResponsableClub("enactus@uiz.ac.ma", form.Hashing("enactus"));
        ResponsableClub respo4 = new ResponsableClub("btp@uiz.ac.ma", form.Hashing("btp"));
        ResponsableClub respo5 = new ResponsableClub("sportif@uiz.ac.ma", form.Hashing("sportif"));
        //ResponsableClub respo6 = new ResponsableClub("harmony@uiz.ac.ma", form.Hashing("harmony"));
        daoRespo.add(respo1);
        daoRespo.add(respo2);
        daoRespo.add(respo3);
        daoRespo.add(respo4);
        daoRespo.add(respo5);
        //daoRespo.add(respo6);
        
        
        
        
        Etudiant prenom1 = new Etudiant("prenom1.nom@edu.uiz.ac.ma", form.Hashing("prenom"));
        prenom1.setNom("Nom");
        prenom1.setPrenom("Prenom");
        prenom1.setCne("D123456789");
        prenom1.setFiliere("Génie Informatique");
        prenom1.setPays("Maroc");
        prenom1.setVille("Agadir");
        daoEtudiant.add(prenom1);
        
        Etudiant prenom2 = new Etudiant("prenom2.nom@edu.uiz.ac.ma", form.Hashing("prenom"));
        prenom2.setNom("Nom");
        prenom2.setPrenom("Prenom");
        prenom2.setCne("D123456789");
        prenom2.setFiliere("Génie Informatique");
        prenom2.setPays("Maroc");
        prenom2.setVille("Agadir");
        daoEtudiant.add(prenom2);
        
        Etudiant prenom3 = new Etudiant("prenom3.nom@edu.uiz.ac.ma", form.Hashing("prenom"));
        prenom3.setNom("Nom");
        prenom3.setPrenom("Prenom");
        prenom3.setCne("D123456789");
        prenom3.setFiliere("Génie Informatique");
        prenom3.setPays("Maroc");
        prenom3.setVille("Agadir");
        daoEtudiant.add(prenom3);
        
        Etudiant prenom4 = new Etudiant("prenom4.nom@edu.uiz.ac.ma", form.Hashing("prenom"));
        prenom4.setNom("Nom");
        prenom4.setPrenom("Prenom");
        prenom4.setCne("D123456789");
        prenom4.setFiliere("Génie Informatique");
        prenom4.setPays("Maroc");
        prenom4.setVille("Agadir");
        daoEtudiant.add(prenom4);
        
        Etudiant prenom5 = new Etudiant("prenom5.nom@edu.uiz.ac.ma", form.Hashing("prenom"));
        prenom5.setNom("Nom");
        prenom5.setPrenom("Prenom");
        prenom5.setCne("D123456789");
        prenom5.setFiliere("Génie Informatique");
        prenom5.setPays("Maroc");
        prenom5.setVille("Agadir");
        daoEtudiant.add(prenom5);
        
        Etudiant prenom6 = new Etudiant("prenom6.nom@edu.uiz.ac.ma", form.Hashing("prenom"));
        prenom6.setNom("Nom");
        prenom6.setPrenom("Prenom");
        prenom6.setCne("D123456789");
        prenom6.setFiliere("Génie Informatique");
        prenom6.setPays("Maroc");
        prenom6.setVille("Agadir");
        daoEtudiant.add(prenom6);
        
        Etudiant prenom7 = new Etudiant("prenom7.nom@edu.uiz.ac.ma", form.Hashing("prenom"));
        prenom7.setNom("Nom");
        prenom7.setPrenom("Prenom");
        prenom7.setCne("D123456789");
        prenom7.setFiliere("Génie Informatique");
        prenom7.setPays("Maroc");
        prenom7.setVille("Agadir");
        daoEtudiant.add(prenom7);
        
        Etudiant prenom8 = new Etudiant("prenom8.nom@edu.uiz.ac.ma", form.Hashing("prenom"));
        prenom8.setNom("Nom");
        prenom8.setPrenom("Prenom");
        prenom8.setCne("D123456789");
        prenom8.setFiliere("Génie Informatique");
        prenom8.setPays("Maroc");
        prenom8.setVille("Agadir");
        daoEtudiant.add(prenom8);
        
        Etudiant prenom9 = new Etudiant("prenom9.nom@edu.uiz.ac.ma", form.Hashing("prenom"));
        prenom9.setNom("Nom");
        prenom9.setPrenom("Prenom");
        prenom9.setCne("D123456789");
        prenom9.setFiliere("Génie Informatique");
        prenom9.setPays("Maroc");
        prenom9.setVille("Agadir");
        daoEtudiant.add(prenom9);
        
        Etudiant prenom10 = new Etudiant("prenom10.nom@edu.uiz.ac.ma", form.Hashing("prenom"));
        prenom10.setNom("Nom");
        prenom10.setPrenom("Prenom");
        prenom10.setCne("D123456789");
        prenom10.setFiliere("Génie Informatique");
        prenom10.setPays("Maroc");
        prenom10.setVille("Agadir");
        daoEtudiant.add(prenom10);
        
        Etudiant prenom11 = new Etudiant("prenom11.nom@edu.uiz.ac.ma", form.Hashing("prenom"));
        prenom11.setNom("Nom");
        prenom11.setPrenom("Prenom");
        prenom11.setCne("D123456789");
        prenom11.setFiliere("Génie Informatique");
        prenom11.setPays("Maroc");
        prenom11.setVille("Agadir");
        daoEtudiant.add(prenom11);
        
        Etudiant prenom12 = new Etudiant("prenom12.nom@edu.uiz.ac.ma", form.Hashing("prenom"));
        prenom12.setNom("Nom");
        prenom12.setPrenom("Prenom");
        prenom12.setCne("D123456789");
        prenom12.setFiliere("Génie Informatique");
        prenom12.setPays("Maroc");
        prenom12.setVille("Agadir");
        daoEtudiant.add(prenom12);

        Etudiant prenom13 = new Etudiant("prenom13.nom@edu.uiz.ac.ma", form.Hashing("prenom"));
        prenom13.setNom("Nom");
        prenom13.setPrenom("Prenom");
        prenom13.setCne("D123456789");
        prenom13.setFiliere("Génie Informatique");
        prenom13.setPays("Maroc");
        prenom13.setVille("Agadir");
        daoEtudiant.add(prenom13);
        
        Etudiant prenom14 = new Etudiant("prenom14.nom@edu.uiz.ac.ma", form.Hashing("prenom"));
        prenom14.setNom("Nom");
        prenom14.setPrenom("Prenom");
        prenom14.setCne("D123456789");
        prenom14.setFiliere("Génie Informatique");
        prenom14.setPays("Maroc");
        prenom14.setVille("Agadir");
        daoEtudiant.add(prenom14);
        
        Etudiant prenom15 = new Etudiant("prenom15.nom@edu.uiz.ac.ma", form.Hashing("prenom"));
        prenom15.setNom("Nom");
        prenom15.setPrenom("Prenom");
        prenom15.setCne("D123456789");
        prenom15.setFiliere("Génie Informatique");
        prenom15.setPays("Maroc");
        prenom15.setVille("Agadir");
        daoEtudiant.add(prenom15);
        
        Etudiant prenom16 = new Etudiant("prenom16.nom@edu.uiz.ac.ma", form.Hashing("prenom"));
        prenom16.setNom("Nom");
        prenom16.setPrenom("Prenom");
        prenom16.setCne("D123456789");
        prenom16.setFiliere("Génie Informatique");
        prenom16.setPays("Maroc");
        prenom16.setVille("Agadir");
        daoEtudiant.add(prenom16);
        
        Etudiant prenom17 = new Etudiant("prenom17.nom@edu.uiz.ac.ma", form.Hashing("prenom"));
        prenom17.setNom("Nom");
        prenom17.setPrenom("Prenom");
        prenom17.setCne("D123456789");
        prenom17.setFiliere("Génie Informatique");
        prenom17.setPays("Maroc");
        prenom17.setVille("Agadir");
        daoEtudiant.add(prenom17);
        
        Etudiant prenom18 = new Etudiant("prenom18.nom@edu.uiz.ac.ma", form.Hashing("prenom"));
        prenom18.setNom("Nom");
        prenom18.setPrenom("Prenom");
        prenom18.setCne("D123456789");
        prenom18.setFiliere("Génie Informatique");
        prenom18.setPays("Maroc");
        prenom18.setVille("Agadir");
        daoEtudiant.add(prenom18);
        
        Etudiant prenom19 = new Etudiant("prenom19.nom@edu.uiz.ac.ma", form.Hashing("prenom"));
        prenom19.setNom("Nom");
        prenom19.setPrenom("Prenom");
        prenom19.setCne("D123456789");
        prenom19.setFiliere("Génie Informatique");
        prenom19.setPays("Maroc");
        prenom19.setVille("Agadir");
        daoEtudiant.add(prenom19);
        
        Etudiant prenom20 = new Etudiant("prenom20.nom@edu.uiz.ac.ma", form.Hashing("prenom"));
        prenom20.setNom("Nom");
        prenom20.setPrenom("Prenom");
        prenom20.setCne("D123456789");
        prenom20.setFiliere("Génie Informatique");
        prenom20.setPays("Maroc");
        prenom20.setVille("Agadir");
        daoEtudiant.add(prenom20);
        
        Etudiant prenom21 = new Etudiant("prenom21.nom@edu.uiz.ac.ma", form.Hashing("prenom"));
        prenom21.setNom("Nom");
        prenom21.setPrenom("Prenom");
        prenom21.setCne("D123456789");
        prenom21.setFiliere("Génie Informatique");
        prenom21.setPays("Maroc");
        prenom21.setVille("Agadir");
        daoEtudiant.add(prenom21);
        
        Etudiant prenom22 = new Etudiant("prenom22.nom@edu.uiz.ac.ma", form.Hashing("prenom"));
        prenom22.setNom("Nom");
        prenom22.setPrenom("Prenom");
        prenom22.setCne("D123456789");
        prenom22.setFiliere("Génie Informatique");
        prenom22.setPays("Maroc");
        prenom22.setVille("Agadir");
        daoEtudiant.add(prenom22);
        
        Etudiant prenom23 = new Etudiant("prenom23.nom@edu.uiz.ac.ma", form.Hashing("prenom"));
        prenom23.setNom("Nom");
        prenom23.setPrenom("Prenom");
        prenom23.setCne("D123456789");
        prenom23.setFiliere("Génie Informatique");
        prenom23.setPays("Maroc");
        prenom23.setVille("Agadir");
        daoEtudiant.add(prenom23);
        
        Etudiant prenom24 = new Etudiant("prenom24.nom@edu.uiz.ac.ma", form.Hashing("prenom"));
        prenom24.setNom("Nom");
        prenom24.setPrenom("Prenom");
        prenom24.setCne("D123456789");
        prenom24.setFiliere("Génie Informatique");
        prenom24.setPays("Maroc");
        prenom24.setVille("Agadir");
        daoEtudiant.add(prenom24);
        
        
        
        

        
        
        
        Club club1 = new Club();
        club1.setName("AppsClub");
        club1.setResponsableClub(daoRespo.find(10));
        club1.setDescription(descriptionApps);
        club1.setParagraphe(paragrapheApps);
        club1.setLogoPath("apps.jpg");
        club1.setCoverPath("appsclub cover.jpg");
        club1.setImg1Path("apps1.jfif");
        club1.setImg2Path("apps2.jfif");
        club1.setImg3Path("apps3.jfif");
        daoClub.add(club1);
        
        Club club2 = new Club();
        club2.setName("Social");
        club2.setResponsableClub(daoRespo.find(11));
        club2.setDescription(descriptionSocial);
        club2.setParagraphe(paragrapheSocial);
        club2.setLogoPath("social.jfif");
        club2.setCoverPath("social cover.jpg");
        club2.setImg1Path("social1.jfif");
        club2.setImg2Path("social2.jfif");
        club2.setImg3Path("social3.jfif");
        daoClub.add(club2);
        
        Club club3 = new Club();
        club3.setName("Enactus");
        club3.setResponsableClub(daoRespo.find(12));
        club3.setDescription(descriptionEnactus);
        club3.setParagraphe(paragrapheEnactus);
        club3.setLogoPath("enactus.jpg");
        club3.setCoverPath("enactus cover.jpg");
        club3.setImg1Path("enactus1.jfif");
        club3.setImg2Path("enactus2.jfif");
        club3.setImg3Path("enactus3.jfif");
        daoClub.add(club3);
        
        Club club4 = new Club();
        club4.setName("BTP");
        club4.setResponsableClub(daoRespo.find(13));
        club4.setDescription(descriptionBTP);
        club4.setParagraphe(paragrapheBTP);
        club4.setLogoPath("btp.jfif");
        club4.setCoverPath("btp cover.jpg");
        club4.setImg1Path("btp1.jfif");
        club4.setImg2Path("btp2.jfif");
        club4.setImg3Path("btp3.jfif");
        daoClub.add(club4);
        
        Club club5 = new Club();
        club5.setName("Sportif");
        club5.setResponsableClub(daoRespo.find(14));
        club5.setDescription(descriptionSportif);
        club5.setParagraphe(paragrapheSportif);
        club5.setLogoPath("sportif.jfif");
        club5.setCoverPath("sportif cover.jpg");
        club5.setImg1Path("sportif1.jfif");
        club5.setImg2Path("sportif2.jfif");
        club5.setImg3Path("sportif3.jfif");
        daoClub.add(club5);
        
        /*Club club6 = new Club();
        club6.setName("Harmony");
        club6.setResponsableClub(daoRespo.find(15));
        club6.setDescription(descriptionHarmony);
        club6.setParagraphe(paragrapheHarmony);
        club6.setLogoPath("harmony.jfif");
        club6.setCoverPath("harmony cover.jpg");
        club6.setImg1Path("harmony1.jfif");
        club6.setImg2Path("harmony2.jfif");
        club6.setImg3Path("harmony3.jfif");
        daoClub.add(club6);*/
        
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
        
        Appartenance appartenance13 = new Appartenance(daoEtudiant.find(15), daoClub.find(3), "01/01/2020");
        daoAppartenance.add(appartenance13);
        
        Appartenance appartenance14 = new Appartenance(daoEtudiant.find(16), daoClub.find(3), "01/01/2020");
        daoAppartenance.add(appartenance14);
        
        Appartenance appartenance15 = new Appartenance(daoEtudiant.find(17), daoClub.find(3), "01/01/2020");
        daoAppartenance.add(appartenance15);
        
        Appartenance appartenance16 = new Appartenance(daoEtudiant.find(18), daoClub.find(3), "01/01/2020");
        daoAppartenance.add(appartenance16);
        
        Appartenance appartenance17 = new Appartenance(daoEtudiant.find(19), daoClub.find(3), "01/01/2020");
        daoAppartenance.add(appartenance17);
        
        Appartenance appartenance18 = new Appartenance(daoEtudiant.find(20), daoClub.find(3), "01/01/2020");
        daoAppartenance.add(appartenance18);
        
        Appartenance appartenance19 = new Appartenance(daoEtudiant.find(21), daoClub.find(3), "01/01/2020");
        daoAppartenance.add(appartenance19);
        
        Appartenance appartenance20 = new Appartenance(daoEtudiant.find(22), daoClub.find(3), "01/01/2019");
        daoAppartenance.add(appartenance20);
        
        Appartenance appartenance21 = new Appartenance(daoEtudiant.find(22), daoClub.find(3), "01/01/2019");
        daoAppartenance.add(appartenance21);
        
        Appartenance appartenance22 = new Appartenance(daoEtudiant.find(23), daoClub.find(3), "01/01/2019");
        daoAppartenance.add(appartenance22);
        
        Appartenance appartenance23 = new Appartenance(daoEtudiant.find(24), daoClub.find(3), "01/01/2019");
        daoAppartenance.add(appartenance23);
        
        Appartenance appartenance24 = new Appartenance(daoEtudiant.find(25), daoClub.find(3), "01/01/2019");
        daoAppartenance.add(appartenance24);
        
        Appartenance appartenance25 = new Appartenance(daoEtudiant.find(26), daoClub.find(3), "01/01/2018");
        daoAppartenance.add(appartenance25);
        
        Appartenance appartenance26 = new Appartenance(daoEtudiant.find(27), daoClub.find(3), "01/01/2018");
        daoAppartenance.add(appartenance26);
        
        Appartenance appartenance27 = new Appartenance(daoEtudiant.find(28), daoClub.find(3), "01/01/2018");
        daoAppartenance.add(appartenance27);
        
        Appartenance appartenance28 = new Appartenance(daoEtudiant.find(29), daoClub.find(3), "01/01/2018");
        daoAppartenance.add(appartenance28);
        
        Appartenance appartenance29 = new Appartenance(daoEtudiant.find(30), daoClub.find(3), "01/01/2018");
        daoAppartenance.add(appartenance29);
        
        Appartenance appartenance30 = new Appartenance(daoEtudiant.find(31), daoClub.find(3), "01/01/2018");
        daoAppartenance.add(appartenance30);
        
        Appartenance appartenance31 = new Appartenance(daoEtudiant.find(32), daoClub.find(3), "01/01/2017");
        daoAppartenance.add(appartenance31);
        
        Appartenance appartenance32 = new Appartenance(daoEtudiant.find(33), daoClub.find(3), "01/01/2017");
        daoAppartenance.add(appartenance32);
        
        Appartenance appartenance33 = new Appartenance(daoEtudiant.find(34), daoClub.find(3), "01/01/2017");
        daoAppartenance.add(appartenance33);
        
        Appartenance appartenance34 = new Appartenance(daoEtudiant.find(35), daoClub.find(3), "01/01/2016");
        daoAppartenance.add(appartenance34);
        
        Appartenance appartenance35 = new Appartenance(daoEtudiant.find(36), daoClub.find(3), "01/01/2016");
        daoAppartenance.add(appartenance35);
        
        Appartenance appartenance36 = new Appartenance(daoEtudiant.find(37), daoClub.find(3), "01/01/2016");
        daoAppartenance.add(appartenance36);
        
        Appartenance appartenance37 = new Appartenance(daoEtudiant.find(38), daoClub.find(3), "01/01/2016");
        daoAppartenance.add(appartenance37);
        
        
        

        
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
        activite1.setNom("Computer Science: Expectations vs Reality");
        activite1.setClub(daoClub.find(1));
        activite1.setLieu("En Ligne");
        activite1.setPrivee(false);
        activite1.setDate("31/03/2021");
        activite1.setImagePath("appsclub-act1.jpg");
        daoActivite.add(activite1);
        
        Activite activite2 = new Activite();
        activite2.setNom("Defense in Depth in WEB Applications");
        activite2.setClub(daoClub.find(1));
        activite2.setLieu("En Ligne");
        activite2.setPrivee(true);
        activite2.setDate("13/04/2021");
        activite2.setImagePath("appsclub-act2.jpg");
        daoActivite.add(activite2);
        
        Activite activiteApps = new Activite();
        activiteApps.setNom("LET'S TALK v4.0");
        activiteApps.setClub(daoClub.find(1));
        activiteApps.setLieu("Amphi Mahdi Elmandjra");
        activiteApps.setPrivee(false);
        activiteApps.setDate("21/04/2021");
        activiteApps.setImagePath("appsclub-act3.jpg");
        daoActivite.add(activiteApps);
        
        Activite activite3 = new Activite();
        activite3.setNom("Don Du Sang");
        activite3.setClub(daoClub.find(2));
        activite3.setLieu("Stand ENSA Agadir");
        activite3.setPrivee(false);
        activite3.setDate("16/05/2021");
        activite3.setImagePath("social-act1.jpg");
        daoActivite.add(activite3);
        
        Activite activite4 = new Activite();
        activite4.setNom("ENIGMA 6ème édition");
        activite4.setClub(daoClub.find(2));
        activite4.setLieu("ENSA Agadir");
        activite4.setPrivee(true);
        activite4.setDate("18/04/2021");
        activite4.setImagePath("social-act2.jpg");
        daoActivite.add(activite4);
        
        Activite activite7 = new Activite();
        activite7.setNom("Présentation du secteur Bâtiments et Travaux Publiques");
        activite7.setClub(daoClub.find(4));
        activite7.setLieu("Amphi Mahdi Elmandjra");
        activite7.setPrivee(false);
        activite7.setDate("08/11/2021");
        activite7.setImagePath("btp-act1.jpg");
        daoActivite.add(activite7);
        
        Activite activite8 = new Activite();
        activite8.setNom("Rencontre Étudiant-Ingénieur");
        activite8.setClub(daoClub.find(4));
        activite8.setLieu("Amphi Mahdi Elmandjra");
        activite8.setPrivee(true);
        activite8.setDate("04/12/2021");
        activite8.setImagePath("btp-act2.jpg");
        daoActivite.add(activite8);
        
        Activite activite9 = new Activite();
        activite9.setNom("Mini Olympiads");
        activite9.setClub(daoClub.find(5));
        activite9.setLieu("ENSA Agadir");
        activite9.setPrivee(false);
        activite9.setDate("18/05/2021");
        activite9.setImagePath("sportif-act1.jpg");
        daoActivite.add(activite9);
        
        Activite activite10 = new Activite();
        activite10.setNom("Olympiades Internes");
        activite10.setClub(daoClub.find(5));
        activite10.setLieu("ENSA Agadir");
        activite10.setPrivee(true);
        activite10.setDate("05/04/2021");
        activite10.setImagePath("sportif-act2.jpg");
        daoActivite.add(activite10);
        
        
        /*Activite activite11 = new Activite();
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
        daoActivite.add(activite15);*/
        

        Activite enactusAct1 = new Activite();
        enactusAct1.setNom("Impact@Work Regional Competition - Phase 2");
        enactusAct1.setClub(daoClub.find(3));
        enactusAct1.setLieu("En ligne");
        enactusAct1.setPrivee(true);
        enactusAct1.setDate("20/03/2021");
        enactusAct1.setImagePath("enactus-act1.jpg");
        daoActivite.add(enactusAct1);
        
        Activite enactusAct26 = new Activite();
        enactusAct26.setNom("Ideathon");
        enactusAct26.setClub(daoClub.find(3));
        enactusAct26.setLieu("ENSA Agadir");
        enactusAct26.setPrivee(false);
        enactusAct26.setDate("26/04/2021");
        enactusAct26.setImagePath("enactus-act21.jpg");
        daoActivite.add(enactusAct26);
        
        Activite enactusAct2 = new Activite();
        enactusAct2.setNom("Movie night");
        enactusAct2.setClub(daoClub.find(3));
        enactusAct2.setLieu("Amphi Mahdi Elmandjra");
        enactusAct2.setPrivee(true);
        enactusAct2.setDate("19/04/2016");
        enactusAct2.setImagePath("enactus-act2.jpg");
        daoActivite.add(enactusAct2);
        
        Activite enactusAct3 = new Activite();
        enactusAct3.setNom("Recrutement Enactus ENSA Agadir");
        enactusAct3.setClub(daoClub.find(3));
        enactusAct3.setLieu("Stand à l'ENSAA");
        enactusAct3.setPrivee(false);
        enactusAct3.setDate("10/10/2016");
        enactusAct3.setImagePath("enactus-act3.jpg");
        daoActivite.add(enactusAct3);
        
        Activite enactusAct4 = new Activite();
        enactusAct4.setNom("Recrutement Enactus ENSA Agadir");
        enactusAct4.setClub(daoClub.find(3));
        enactusAct4.setLieu("Stand à l'ENSAA");
        enactusAct4.setPrivee(false);
        enactusAct4.setDate("10/10/2017");
        enactusAct4.setImagePath("enactus-act3.jpg");
        daoActivite.add(enactusAct4);
        
        Activite enactusAct5 = new Activite();
        enactusAct5.setNom("Recrutement Enactus ENSA Agadir");
        enactusAct5.setClub(daoClub.find(3));
        enactusAct5.setLieu("Stand à l'ENSAA");
        enactusAct5.setPrivee(false);
        enactusAct5.setDate("10/10/2018");
        enactusAct5.setImagePath("enactus-act3.jpg");
        daoActivite.add(enactusAct5);
        
        Activite enactusAct6 = new Activite();
        enactusAct6.setNom("Recrutement Enactus ENSA Agadir");
        enactusAct6.setClub(daoClub.find(3));
        enactusAct6.setLieu("Stand à l'ENSAA");
        enactusAct6.setPrivee(false);
        enactusAct6.setDate("10/10/2019");
        enactusAct6.setImagePath("enactus-act3.jpg");
        daoActivite.add(enactusAct6);
        
        Activite enactusAct7 = new Activite();
        enactusAct7.setNom("Recrutement Enactus ENSA Agadir");
        enactusAct7.setClub(daoClub.find(3));
        enactusAct7.setLieu("Stand à l'ENSAA");
        enactusAct7.setPrivee(false);
        enactusAct7.setDate("10/10/2020");
        enactusAct7.setImagePath("enactus-act3.jpg");
        daoActivite.add(enactusAct7);
        
        Activite enactusAct9 = new Activite();
        enactusAct9.setNom("Présentation des projets ENACTUS 2015/2016");
        enactusAct9.setClub(daoClub.find(3));
        enactusAct9.setLieu("Amphi Mohamed Mokhtar Soussi");
        enactusAct9.setPrivee(false);
        enactusAct9.setDate("30/12/2016");
        enactusAct9.setImagePath("enactus-act9.jpg");
        daoActivite.add(enactusAct9);
        
        Activite enactusAct10 = new Activite();
        enactusAct10.setNom("The Journey of an Entrepreneur: Terry Jones");
        enactusAct10.setClub(daoClub.find(3));
        enactusAct10.setLieu("Amphi Mahdi Elmandjra");
        enactusAct10.setPrivee(false);
        enactusAct10.setDate("14/11/2020");
        enactusAct10.setImagePath("enactus-act10.jpg");
        daoActivite.add(enactusAct10);
        
        Activite enactusAct11 = new Activite();
        enactusAct11.setNom("Sustainable Innovation Fest - by Enactus");
        enactusAct11.setClub(daoClub.find(3));
        enactusAct11.setLieu("En ligne");
        enactusAct11.setPrivee(false);
        enactusAct11.setDate("11/07/2020");
        enactusAct11.setImagePath("enactus-act11.jpg");
        daoActivite.add(enactusAct11);
        
        Activite enactusAct12 = new Activite();
        enactusAct12.setNom("A Talk with Citi Leaders");
        enactusAct12.setClub(daoClub.find(3));
        enactusAct12.setLieu("En ligne");
        enactusAct12.setPrivee(false);
        enactusAct12.setDate("02/07/2020");
        enactusAct12.setImagePath("enactus-act12.jpg");
        daoActivite.add(enactusAct12);
        
        Activite enactusAct13 = new Activite();
        enactusAct13.setNom("Insta'Talks : A conversation with Zineb Rachid");
        enactusAct13.setClub(daoClub.find(3));
        enactusAct13.setLieu("En ligne");
        enactusAct13.setPrivee(false);
        enactusAct13.setDate("14/04/2020");
        enactusAct13.setImagePath("enactus-act13.jpg");
        daoActivite.add(enactusAct13);
        
        Activite enactusAct14 = new Activite();
        enactusAct14.setNom("Insta'Talks : A conversation with Maha Ech-Chefaa");
        enactusAct14.setClub(daoClub.find(3));
        enactusAct14.setLieu("En ligne");
        enactusAct14.setPrivee(false);
        enactusAct14.setDate("07/04/2019");
        enactusAct14.setImagePath("enactus-act14.jpg");
        daoActivite.add(enactusAct14);
        
        Activite enactusAct15 = new Activite();
        enactusAct15.setNom("Insta'Talks : A conversation with Ghassan Benchiheb");
        enactusAct15.setClub(daoClub.find(3));
        enactusAct15.setLieu("En ligne");
        enactusAct15.setPrivee(false);
        enactusAct15.setDate("31/03/2019");
        enactusAct15.setImagePath("enactus-act15.jpg");
        daoActivite.add(enactusAct15);
        
        Activite enactusAct16 = new Activite();
        enactusAct16.setNom("Insta'Talks : a conversation with Adnane Addioui");
        enactusAct16.setClub(daoClub.find(3));
        enactusAct16.setLieu("En ligne");
        enactusAct16.setPrivee(false);
        enactusAct16.setDate("24/03/2019");
        enactusAct16.setImagePath("enactus-act16.jpg");
        daoActivite.add(enactusAct16);
        
        Activite enactusAct17 = new Activite();
        enactusAct17.setNom("Enactus Impact Challenge 2019");
        enactusAct17.setClub(daoClub.find(3));
        enactusAct17.setLieu("ENSA Agadir");
        enactusAct17.setPrivee(false);
        enactusAct17.setDate("14/12/2019");
        enactusAct17.setImagePath("enactus-act17.jpg");
        daoActivite.add(enactusAct17);
        
        Activite enactusAct18 = new Activite();
        enactusAct18.setNom("Moonshot Youth Festival");
        enactusAct18.setClub(daoClub.find(3));
        enactusAct18.setLieu("ENSA Agadir");
        enactusAct18.setPrivee(false);
        enactusAct18.setDate("18/11/2019");
        enactusAct18.setImagePath("enactus-act18.jpg");
        daoActivite.add(enactusAct18);
        
        Activite enactusAct19 = new Activite();
        enactusAct19.setNom("Womenpreneur Experience");
        enactusAct19.setClub(daoClub.find(3));
        enactusAct19.setLieu("ENSA Agadir");
        enactusAct19.setPrivee(false);
        enactusAct19.setDate("13/11/2018");
        enactusAct19.setImagePath("enactus-act19.jpg");
        daoActivite.add(enactusAct19);
        
        Activite enactusAct20 = new Activite();
        enactusAct20.setNom("Enactus Morocco 2018/2019 Kick Off Seminar");
        enactusAct20.setClub(daoClub.find(3));
        enactusAct20.setLieu("ENSA Agadir");
        enactusAct20.setPrivee(false);
        enactusAct20.setDate("12/10/2018");
        enactusAct20.setImagePath("enactus-act20.jpg");
        daoActivite.add(enactusAct20);
        
        Activite enactusAct21 = new Activite();
        enactusAct21.setNom("Ideathon");
        enactusAct21.setClub(daoClub.find(3));
        enactusAct21.setLieu("ENSA Agadir");
        enactusAct21.setPrivee(true);
        enactusAct21.setDate("21/09/2018");
        enactusAct21.setImagePath("enactus-act21.jpg");
        daoActivite.add(enactusAct21);
        
        Activite enactusAct22 = new Activite();
        enactusAct22.setNom("MEDUP Fund : Session d'information");
        enactusAct22.setClub(daoClub.find(3));
        enactusAct22.setLieu("ENSA Agadir");
        enactusAct22.setPrivee(false);
        enactusAct22.setDate("20/07/2018");
        enactusAct22.setImagePath("enactus-act22.jpg");
        daoActivite.add(enactusAct22);
        
        Activite enactusAct23 = new Activite();
        enactusAct23.setNom("Compétition Nationale Enactus Morocco 2019");
        enactusAct23.setClub(daoClub.find(3));
        enactusAct23.setLieu("ENSA Agadir");
        enactusAct23.setPrivee(true);
        enactusAct23.setDate("18/06/2017");
        enactusAct23.setImagePath("enactus-act23.jpg");
        daoActivite.add(enactusAct23);
        
        
        Activite enactusAct24 = new Activite();
        enactusAct24.setNom("Meet The Leader : Maral Kalajian");
        enactusAct24.setClub(daoClub.find(3));
        enactusAct24.setLieu("ENSA Agadir");
        enactusAct24.setPrivee(false);
        enactusAct24.setDate("14/04/2017");
        enactusAct24.setImagePath("enactus-act24.jpg");
        daoActivite.add(enactusAct24);
        
        
        Activite enactusAct25 = new Activite();
        enactusAct25.setNom("Tech Camp");
        enactusAct25.setClub(daoClub.find(3));
        enactusAct25.setLieu("ENSA Agadir");
        enactusAct25.setPrivee(false);
        enactusAct25.setDate("18/01/2017");
        enactusAct25.setImagePath("enactus-act25.jpg");
        daoActivite.add(enactusAct25);
        
        
        Random random = new Random();
        for (int i=15; i<39; i++)
        	for (int j=10; j<35; j++) {
        		int rng = random.nextInt(4 - 1) + 1;
        		if(rng != 1)
        			daoEtudiant.participer(daoEtudiant.find(i), daoActivite.find(j));
        	}
        
        
        response.sendRedirect(request.getContextPath()+"/Accueil");
	}


}
