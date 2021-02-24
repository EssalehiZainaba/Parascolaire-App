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
		
		String descriptionApps = "AppsClub est le club informatique de l'ENSAA. Crï¿½ï¿½ en Mars 2014, il a dï¿½jï¿½ plusieurs ï¿½vï¿½nements et activitï¿½s ï¿½ son actif, et bien d'autres encore sont ï¿½ venir.\r\n"
				+ "Le principal objectif du club est de dï¿½velopper les compï¿½tences informatiques des membres, et ï¿½tudiants en gï¿½nï¿½ral. Et ce au travers de formations, compï¿½titions internes et externes, projets...\r\n"
				+ "Le club permet aussi de rassembler les ï¿½tudiants de tous les niveaux sous une mï¿½me banniï¿½re, crï¿½er un esprit de concurrence entre eux, et leur donner accï¿½s ï¿½ de nouvelles connaissances.\r\n"
				+ "APPSClub est un groupe d'ï¿½tudiants dont l'objectif commun est de dynamiser la scï¿½ne ï¿½vï¿½nementielle informatique au sein de l'ENSA d'Agadir.\r\n"
				+ "\r\n"
				+ "Domaines d'actions:\r\n"
				+ "-Entrepreneuriat digital : Mettre en pratique les compï¿½tences acquises par les ï¿½tudiants en informatique et amï¿½liorer ces compï¿½tences par l'organisation des formations,cours de soutien et ï¿½vï¿½nements.\r\n"
				+ "  Spring Coding Days est un exemple d'ï¿½vï¿½nement organisï¿½ annullement par le club INFO ayant pour objectif developper l'entrepreneuriat digitale sous forme de solutions web,mobile...\r\n"
				+ "-Innovation et crï¿½ativitï¿½:Avec la progression rapide des technologies, les ï¿½tudiants du club INFO travaillent ensemble pour crï¿½er des solution innovantes et prï¿½sentent leur projets innovants lors des manifestations telles que la compï¿½tition Spring Coding days,\r\n"
				+ "  portes ouvertes d'ESTE et autre compï¿½titions.\r\n"
				+ "-Solidaritï¿½ et volontariat: L'objectif est d'encourager l'entrepreneuriat sociale chez les ï¿½tudiants par des cours de soutien,activitï¿½es de bï¿½nï¿½volat auprï¿½s des associations de la ville Essaouira. \r\n"
				+ "  Les ï¿½tudiants organisent des caravanes pour aider et sensibiliser les gens.";
		descriptionApps = descriptionApps.replaceAll("\n","<br />");
		
		String paragrapheApps = "&emsp;AppsClub est le club informatique de l'ENSAA. Crï¿½ï¿½ en Mars 2014, il a dï¿½jï¿½ plusieurs ï¿½vï¿½nements et activitï¿½s ï¿½ son actif, et bien d'autres encore sont ï¿½ venir.\r\n"
				+ "Le principal objectif du club est de dï¿½velopper les compï¿½tences informatiques des membres, et ï¿½tudiants en gï¿½nï¿½ral. Et ce au travers de formations, compï¿½titions internes et externes, projets...\r\n";
		paragrapheApps = paragrapheApps.replaceAll("\n","<br />");
		
		
		String descriptionSocial = "Le club social Ensa Agadir est un groupe de jeunes ingï¿½nieurs, ayant un but est de dï¿½velopper lï¿½esprit dï¿½initiative,\r\n"
				+ "de solidaritï¿½ et de responsabilitï¿½ tout en se sentant utile ï¿½ lï¿½ensemble. Pour ce faire, il nous est demandï¿½ de passer du quantitatif au travail qualitatif.\r\n"
				+ "\r\n"
				+ "Le Club Social a pour objet lï¿½ï¿½tude et la connaissance des relations de travail et de la protection sous leurs diffï¿½rents aspects, la promotion de la profession dï¿½experts-comptables dans le domaine social, \r\n"
				+ "lï¿½information et le perfectionnement de ses membres et de leur personnel mais aussi la participation aux dï¿½bats relatifs ï¿½ lï¿½amï¿½lioration de la lï¿½gislation nationale, europï¿½enne et internationale.\r\n"
				+ "\r\n"
				+ "Votre participation au Club Social vous permettra de bï¿½nï¿½ficier de confï¿½rences de haut niveau sur des thï¿½mes sociaux et dï¿½actualitï¿½ mais aussi de rencontrer dï¿½autres professionnels.\r\n"
				+ "\r\n"
				+ "Il a adoptï¿½ un plan dï¿½actions de communication ï¿½ destination du public, par le biais de rï¿½unions publiques animï¿½es par des membres du Club et destinï¿½es ï¿½ promouvoir le rï¿½le de lï¿½expert-comptable. Il participe ï¿½galement ï¿½ des manifestations publiques et des actions de sensibilisation.\r\n"
				+ "\r\n"
				+ "Date de crï¿½ation : Annï¿½e acadï¿½mique 2004/2005\r\n"
				+ "Crï¿½ateurs : Elï¿½ves ingï¿½nieurs animï¿½s par un esprit de solidaritï¿½ et de gï¿½nï¿½rositï¿½\r\n"
				+ "Domaine dï¿½activitï¿½s: Lï¿½intï¿½rieur et lï¿½extï¿½rieur de lï¿½ENSAA\r\n"
				+ "Population cible : Enfants, jeunes, adultes et vieux\r\n"
				+ "Moyens : De grands cï¿½urs et de bonnes ï¿½mes voulant faire le changement et une Ecole qui encourage fortement les activitï¿½s parascolaires.\r\n"
				+ "\r\n"
				+ "\r\n"
				+ "Pourquoi adhï¿½rer ?\r\n"
				+ "Le Club Social vous propose les moyens de crï¿½er, de dï¿½velopper et de perfectionner une vï¿½ritable activitï¿½ de conseil social par une sï¿½rie dï¿½actions dï¿½information et de formation de haut niveau.";
		descriptionSocial = descriptionSocial.replaceAll("\n","<br />");
		
		String paragrapheSocial = "&emsp;Le club social Ensa Agadir est un groupe de jeunes ingï¿½nieurs, ayant un but est de dï¿½velopper lï¿½esprit dï¿½initiative,\r\n"
				+ "de solidaritï¿½ et de responsabilitï¿½ tout en se sentant utile ï¿½ lï¿½ensemble. Pour ce faire, il nous est demandï¿½ de passer du quantitatif au travail qualitatif.";
		paragrapheSocial = paragrapheSocial.replaceAll("\n","<br />");
		
		
		String descriptionEnactus = "Enactus est une ONG internationale qui oeuvre dans le domaine de lï¿½entrepreneuriat social estudiantin et le dï¿½veloppement durable. Elle a ï¿½tï¿½ crï¿½ï¿½e en 1975, et basï¿½e ï¿½ Missouri ï¿½ USA . Enactus dï¿½veloppe des partenariats entre le monde des affaires et celui de lï¿½enseignement supï¿½rieur afin de prï¿½parer les ï¿½tudiants ï¿½ contribuer substantiellement au dï¿½veloppement de leur pays en tant que futurs leaders entrepreneurs, ï¿½thiques et socialement responsables.\r\n"
				+ "La crï¿½ation dï¿½Enactus au Maroc sï¿½est faite en 2003 ï¿½ lï¿½initiative de M. Adnane Raiss, et depuis, a accompagnï¿½ plus de 20 000 ï¿½tudiants ï¿½ sï¿½auto-dï¿½velopper tout en mettant en place annuellement une moyenne de 200 projets de dï¿½veloppement durable.\r\n"
				+ " Notre vision:\r\n"
				+ "   Un monde oï¿½ les jeunes, les leaders du monde acadï¿½mique et ï¿½conomiques sï¿½engagent dans lï¿½action entrepreneuriale pour favoriser le progrï¿½s sociï¿½tal et faï¿½onner un monde meilleur et durable.\r\n"
				+ " Notre mission:\r\n"
				+ "   Accompagner les ï¿½tudiants dans la mise en ï¿½uvre de leurs projets dï¿½entrepreneuriat social, ï¿½ travers des ï¿½vï¿½nements, des formations et des concours nationaux et internationaux.\r\n"
				+ "\r\n"
				+ "Depuis sa crï¿½ation en 2003, le rï¿½seau dï¿½enactus Morocco ne cesse de grandir. Cette annï¿½e, Enactus Morocco compte:\r\n"
				+ "Plus de 110 Universitï¿½s, Instituts et ï¿½coles dï¿½enseignement supï¿½rieur\r\n"
				+ "+5500 ï¿½tudiants sensibilisï¿½s et mobilisï¿½s\r\n"
				+ "Rï¿½seau de plus de 8000 laurï¿½ats Enactus\r\n"
				+ "250 projets et ï¿½vï¿½nements annuels\r\n"
				+ "195 000 bï¿½nï¿½ficiaires.";
		descriptionEnactus = descriptionEnactus.replaceAll("\n","<br />");
		
		String paragrapheEnactus = "&emsp;Enactus est une ONG internationale qui oeuvre dans le domaine de lï¿½entrepreneuriat social estudiantin et le dï¿½veloppement durable. Elle a ï¿½tï¿½ crï¿½ï¿½e en 1975, et basï¿½e ï¿½ Missouri ï¿½ USA . Enactus dï¿½veloppe des partenariats entre le monde des affaires et celui de lï¿½enseignement supï¿½rieur afin de prï¿½parer les ï¿½tudiants ï¿½ contribuer substantiellement au dï¿½veloppement de leur pays en tant que futurs leaders entrepreneurs, ï¿½thiques et socialement responsables.\r\n"
				+ "La crï¿½ation dï¿½Enactus au Maroc sï¿½est faite en 2003 ï¿½ lï¿½initiative de M. Adnane Raiss, et depuis, a accompagnï¿½ plus de 20 000 ï¿½tudiants ï¿½ sï¿½auto-dï¿½velopper tout en mettant en place annuellement une moyenne de 200 projets de dï¿½veloppement durable.";
		paragrapheEnactus = paragrapheEnactus.replaceAll("\n","<br />");
		
		
		String descriptionBTP = "Rï¿½cemment crï¿½ï¿½, et seulement en sa premiï¿½re annï¿½e, le club BTP Agadir, qui sï¿½est instaurï¿½ ï¿½ partir dï¿½une idï¿½e ï¿½manant dï¿½un groupe dï¿½ï¿½lï¿½ments-ingï¿½nieurs enthousiastes et amants de la discipline du grand domaine du Gï¿½nie Civil, sï¿½est fixï¿½ des objectifs ambitieux. \r\n"
				+ "Son ambition est vive et grandiose. Dï¿½diï¿½ principalement aux spï¿½cialisations relatives ï¿½ la construction, lï¿½infrastructure, lï¿½hydraulique, lï¿½amï¿½nagement de territoire, lï¿½urbanisme, la vision du club et son rï¿½ve intime est  dï¿½apporter son plus ï¿½ une formation qui sï¿½avï¿½re peu pratique, de faire apprendre hors le cadre militaro-scolaire, de promouvoir lï¿½ï¿½clat, le rayonnement et la performance des professions de BTP, ainsi que le renforcement des connaissances techniques et scientifiques dans le domaine et lï¿½initiation au domaine professionnel.\r\n"
				+ "\r\n"
				+ "Dans lï¿½agenda : des visites sur chantiers, des sï¿½minaires, des formations, des compï¿½titions, des confï¿½rences, des ï¿½vï¿½nements, et ceci dans une ambiance conviviale. Pour atteindre ses objectifs, il sï¿½est dotï¿½ dï¿½une ï¿½quipe motivï¿½e, dynamique et trï¿½s combattante.\r\n"
				+ "Le 02 /02 dernier, sï¿½est tenue sa toute premiï¿½re manifestation : la Mini-journï¿½e GC. Lancï¿½e sous le thï¿½me ï¿½ le BIM : Un processus rï¿½volutionnaire et prometteur pour la digitalisation du domaine de la construction ï¿½, la manifestation a connu la participation de nombreux anciens laurï¿½ats, dï¿½enseignants et de dirigeants de lï¿½EHTP. Elle sï¿½est dï¿½roulï¿½e en 4 temps: Une ouverture, une compï¿½tition, une table ronde qui a vu naitre un ï¿½change fructueux entre laurï¿½ats et ï¿½tudiants et une confï¿½rence sur ledit thï¿½me assurï¿½e par des confï¿½renciers de haut calibre. La compï¿½tition sï¿½est tenue grï¿½ce au soutien de la sociï¿½tï¿½ EngiMa : Notre partenaire.\r\n"
				+ "Le choix de ce sujet a ï¿½tï¿½ largement prisï¿½ par lï¿½ensemble des commentateurs. Ceci ï¿½tant dï¿½ au fait que ce concept naissant, qui est le BIM, suscite plein dï¿½enthousiasme dï¿½une part, et dï¿½autre part ï¿½normï¿½ment de questions et dï¿½inquiï¿½tudes.\r\n"
				+ "\r\n"
				+ "Cï¿½ï¿½tait lï¿½occasion rï¿½vï¿½e de rompre avec la routine du quotidien, dï¿½introduire une discontinuitï¿½ dans cette vaste platitude, de  partager des moments dï¿½ï¿½motions et de fraternitï¿½. Cï¿½ï¿½tait aussi un moment de retrouvailles et de bonheur partagï¿½ entre les diffï¿½rents acteurs prï¿½sents.";
		descriptionBTP = descriptionBTP.replaceAll("\n","<br />");
		
		String paragrapheBTP = "&emsp;Rï¿½cemment crï¿½ï¿½, et seulement en sa premiï¿½re annï¿½e, le club BTP Agadir, qui sï¿½est instaurï¿½ ï¿½ partir dï¿½une idï¿½e ï¿½manant dï¿½un groupe dï¿½ï¿½lï¿½ments-ingï¿½nieurs enthousiastes et amants de la discipline du grand domaine du Gï¿½nie Civil, sï¿½est fixï¿½ des objectifs ambitieux. \r\n"
				+ "Son ambition est vive et grandiose. Dï¿½diï¿½ principalement aux spï¿½cialisations relatives ï¿½ la construction, lï¿½infrastructure, lï¿½hydraulique, lï¿½amï¿½nagement de territoire, lï¿½urbanisme, la vision du club et son rï¿½ve intime est  dï¿½apporter son plus ï¿½ une formation qui sï¿½avï¿½re peu pratique, de faire apprendre hors le cadre militaro-scolaire, de promouvoir lï¿½ï¿½clat, le rayonnement et la performance des professions de BTP, ainsi que le renforcement des connaissances techniques et scientifiques dans le domaine et lï¿½initiation au domaine professionnel.";
		paragrapheBTP = paragrapheBTP.replaceAll("\n","<br />");
		
		
		String descriptionSportif = "Crï¿½ï¿½ en 2006, le Club Sportif ENSA Agadir est lï¿½un des plus anciens clubs a l'ï¿½cole. Il a su se bï¿½tir un palmarï¿½s exceptionnel pour atteindre son apogï¿½e dans les annï¿½es 1950 et 1960 puis pour y revenir ï¿½ la fin des annï¿½es 90.\r\n"
				+ "\r\n"
				+ "Combativitï¿½, rigueur, solidaritï¿½, humilitï¿½ et enthousiasme : le CSSA a toujours vï¿½hiculï¿½ des valeurs fortes, ï¿½ l'image dï¿½un club simple mais ambitieux.\r\n"
				+ "\r\n"
				+ "Entre 1954 et 1975, le CSSA a donnï¿½ quinze internationaux et deux entraï¿½neurs ï¿½ l'ï¿½quipe de France, ainsi que des internationaux ï¿½ de nombreuses ï¿½quipes africaines.\r\n"
				+ "\r\n"
				+ "C'est en 2013 que Marc Dubois, prï¿½sident du Groupe APLUSï¿½, dï¿½cide de revenir ï¿½ ses racines ardennaises en prenant le contrï¿½le du CSSA, en mï¿½moire de son pï¿½re.\r\n"
				+ "\r\n"
				+ "Trois objectifs s'imposent naturellement au CSSA Partners Team :\r\n"
				+ "- Redonner ses lettres de noblesse ï¿½ un club identitaire et populaire au passï¿½ prestigieux en rejoignant au plus vite le niveau professionnel.\r\n"
				+ "- Renforcer lï¿½ADN historique du club ï¿½ travers la dï¿½tection, la formation de jeunes joueurs prometteurs, l'optimisation des performances physiques et mentales ainsi que le trading.\r\n"
				+ "- Associer le CSSA au cï¿½ur dï¿½un projet ambitieux liï¿½ ï¿½ l'expertise ï¿½ Prï¿½vention Santï¿½, Bien-ï¿½tre et Sport ï¿½ du Groupe APLUSï¿½ tout en valorisant le territoire de l'Ardenne transfrontaliï¿½re : le concept ï¿½ MySensï¿½ ï¿½.";
		descriptionSportif = descriptionSportif.replaceAll("\n","<br />");
		
		String paragrapheSportif = "&emsp;Crï¿½ï¿½ en 2006, le Club Sportif ENSA Agadir est lï¿½un des plus anciens clubs a l'ï¿½cole. Il a su se bï¿½tir un palmarï¿½s exceptionnel pour atteindre son apogï¿½e dans les annï¿½es 1950 et 1960 puis pour y revenir ï¿½ la fin des annï¿½es 90.";
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
        etd1.setFiliere("Gï¿½nie Informatique");
        etd1.setPays("Maroc");
        etd1.setVille("Tiznit");
        daoEtudiant.add(etd1);
   
        Etudiant etd2 = new Etudiant("younes.kellouch@edu.uiz.ac.ma", form.Hashing("younes"));
        etd2.setNom("Kellouch");
        etd2.setPrenom("Younes");
        etd2.setCne("D225487965");
        etd2.setFiliere("Gï¿½nie Informatique");
        etd2.setPays("Maroc");
        etd2.setVille("Azrou l3assima");
        daoEtudiant.add(etd2);
		
        Etudiant etd3 = new Etudiant("zainaba.essalhi@edu.uiz.ac.ma", form.Hashing("zainaba"));
        etd3.setNom("Essalhi");
        etd3.setPrenom("Zainaba");
        etd3.setCne("D885478965");
        etd3.setFiliere("Gï¿½nie Informatique");
        etd3.setPays("Maroc");
        etd3.setVille("Ait Iazza");
        daoEtudiant.add(etd3);
        
        Etudiant etd4 = new Etudiant("amine.harka@edu.uiz.ac.ma", form.Hashing("amine"));
        etd4.setNom("Harka");
        etd4.setPrenom("Amine");
        etd4.setCne("D542189654");
        etd4.setFiliere("Gï¿½nie Industrielle");
        etd4.setPays("Maroc");
        etd4.setVille("Taroudant");
        daoEtudiant.add(etd4);
        
        Etudiant etd5 = new Etudiant("oussama.makhlouk@login.etd", form.Hashing("oussama"));
        etd5.setNom("Makhlouk");
        etd5.setPrenom("Oussama");
        etd5.setCne("D236547896");
        etd5.setFiliere("Gï¿½nie Informatique");
        etd5.setPays("Maroc");
        etd5.setVille("Agadir");
        daoEtudiant.add(etd5);
        
        Etudiant etd6 = new Etudiant("imane.erguiti@edu.uiz.ac.ma", form.Hashing("imane"));
        etd6.setNom("Erguiti");
        etd6.setPrenom("Imane");
        etd6.setCne("D542365896");
        etd6.setFiliere("Gï¿½nie Informatique");
        etd6.setPays("Maroc");
        etd6.setVille("Agadir");
        daoEtudiant.add(etd6);
        
        Etudiant etd7 = new Etudiant("ayoub.grioui@edu.uiz.ac.ma", form.Hashing("ayoub"));
        etd7.setNom("Grioui");
        etd7.setPrenom("Ayoub");
        etd7.setCne("D210589601");
        etd7.setFiliere("Gï¿½nie Informatique");
        etd7.setPays("Maroc");
        etd7.setVille("Temsia");
        daoEtudiant.add(etd7);
        
        Etudiant etd8 = new Etudiant("prenom.nom@edu.uiz.ac.ma", form.Hashing("prenom"));
        etd8.setNom("Nom");
        etd8.setPrenom("Prenom");
        etd8.setCne("D123456789");
        etd8.setFiliere("Gï¿½nie Informatique");
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
        
        
        
        
        
        response.sendRedirect(request.getContextPath()+"/Accueil");
	}


}
