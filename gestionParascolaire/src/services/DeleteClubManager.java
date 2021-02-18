package services;

import dao.DaoActivite;
import dao.DaoClub;
import entities.Activite;
import entities.Club;

public class DeleteClubManager {

	private DaoClub daoClub;
	private DaoActivite daoActivite;
	
	public DeleteClubManager(DaoClub daoClub, DaoActivite daoActivite) {
		this.daoClub = daoClub;
		this.daoActivite = daoActivite;
	}
	
	
	
	public void deleteClub(String clubName, String chemin) {
		
		Club club = daoClub.find(clubName);
		FilesManager filesManager = new FilesManagerImpl();
		
		for (Activite activite : club.getActivites()) {
			filesManager.delete(chemin, activite.getImagePath());
			daoActivite.delete(activite.getId());
		}
		
		filesManager.delete(chemin, club.getLogoPath());
		filesManager.delete(chemin, club.getImg1Path());
		filesManager.delete(chemin, club.getImg2Path());
		filesManager.delete(chemin, club.getImg3Path());

		
		daoClub.delete(club.getId());
		


	}
}
