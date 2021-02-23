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
				+ "Le principal objectif du club est de développer les compétences informatiques des membres, et étudiants en général. Et ce au travers de formations, compétitions internes et externes, projets...\r\n";
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
				+ "Le Club Social vous propose les moyens de créer, de développer et de perfectionner une véritable activité de conseil social par une série d’actions d’information et de formation de haut niveau.";
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
		
		String paragrapheSportif = "&emsp;Créé en 2006, le Club Sportif ENSA Agadir est l’un des plus anciens clubs a l'école. Il a su se bâtir un palmarès exceptionnel pour atteindre son apogée dans les années 1950 et 1960 puis pour y revenir à la fin des années 90.";
		paragrapheSportif = paragrapheSportif.replaceAll("\n","<br />");
		
		
		
		daoEtudiant = new DaoEtudiantImpl(factory);
        daoRespo = new DaoResponsableClubImpl(factory);
        daoAdministrateur = new DaoAdministrateurImpl(factory);
        daoClub = new DaoClubImpl(factory);
        daoActivite = new DaoActiviteImpl(factory);
        daoAppartenance = new DaoAppartenanceImpl(factory);
        DaoDemandeInscription=new DaoDemandeInscriptionImpl(factory);
        
        
        
        
        
		Administrateur administrateur=new Administrateur("admin@uiz.ac.ma","admin");		
		daoAdministrateur.add(administrateur);
        
        
		
        Etudiant etd1 = new Etudiant("youness.iharchine@edu.uiz.ac.ma", "youness");
        etd1.setNom("Iharchine");
        etd1.setPrenom("Youness");
        etd1.setCne("D135338707");
        etd1.setFiliere("Génie Informatique");
        etd1.setPays("Maroc");
        etd1.setVille("Tiznit");
        daoEtudiant.add(etd1);
   
        Etudiant etd2 = new Etudiant("younes.kellouch@edu.uiz.ac.ma", "younes");
        etd2.setNom("Kellouch");
        etd2.setPrenom("Younes");
        etd2.setCne("D225487965");
        etd2.setFiliere("Génie Informatique");
        etd2.setPays("Maroc");
        etd2.setVille("Azrou l3assima");
        daoEtudiant.add(etd2);
		
        Etudiant etd3 = new Etudiant("zainaba.essalhi@edu.uiz.ac.ma", "zainaba");
        etd3.setNom("Essalhi");
        etd3.setPrenom("Zainaba");
        etd3.setCne("D885478965");
        etd3.setFiliere("Génie Informatique");
        etd3.setPays("Maroc");
        etd3.setVille("Ait Iazza");
        daoEtudiant.add(etd3);
        
        Etudiant etd4 = new Etudiant("amine.harka@edu.uiz.ac.ma", "amine");
        etd4.setNom("Harka");
        etd4.setPrenom("Amine");
        etd4.setCne("D542189654");
        etd4.setFiliere("Génie Industrielle");
        etd4.setPays("Maroc");
        etd4.setVille("Taroudant");
        daoEtudiant.add(etd4);
        
        Etudiant etd5 = new Etudiant("oussama.makhlouk@login.etd", "oussama");
        etd5.setNom("Makhlouk");
        etd5.setPrenom("Oussama");
        etd5.setCne("D236547896");
        etd5.setFiliere("Génie Informatique");
        etd5.setPays("Maroc");
        etd5.setVille("Agadir");
        daoEtudiant.add(etd5);
        
        Etudiant etd6 = new Etudiant("imane.erguiti@edu.uiz.ac.ma", "imane");
        etd6.setNom("Erguiti");
        etd6.setPrenom("Imane");
        etd6.setCne("D542365896");
        etd6.setFiliere("Génie Informatique");
        etd6.setPays("Maroc");
        etd6.setVille("Agadir");
        daoEtudiant.add(etd6);
        
        Etudiant etd7 = new Etudiant("ayoub.grioui@edu.uiz.ac.ma", "ayoub");
        etd7.setNom("Grioui");
        etd7.setPrenom("Ayoub");
        etd7.setCne("D210589601");
        etd7.setFiliere("Génie Informatique");
        etd7.setPays("Maroc");
        etd7.setVille("Temsia");
        daoEtudiant.add(etd7);
        
        Etudiant etd8 = new Etudiant("prenom.nom@edu.uiz.ac.ma", "prenom");
        etd8.setNom("Nom");
        etd8.setPrenom("Prenom");
        etd8.setCne("D123456789");
        etd8.setFiliere("Génie Informatique");
        etd8.setPays("Maroc");
        etd8.setVille("Agadir");
        daoEtudiant.add(etd8);
        
        

        ResponsableClub respo1 = new ResponsableClub("appsclub@uiz.ac.ma", "appsclub");
        ResponsableClub respo2 = new ResponsableClub("social@uiz.ac.ma", "social");
        ResponsableClub respo3 = new ResponsableClub("enactus@uiz.ac.ma", "enactus");
        ResponsableClub respo4 = new ResponsableClub("btp@uiz.ac.ma", "btp");
        ResponsableClub respo5 = new ResponsableClub("sportif@uiz.ac.ma", "sportif");
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
