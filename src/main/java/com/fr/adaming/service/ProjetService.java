package com.fr.adaming.service;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.stereotype.Service;

import com.fr.adaming.dao.ProjetDao;
import com.fr.adaming.entity.Projet;

@Service
public class ProjetService {

	@Autowired
	private ProjetDao dao;
	
	/**Saves a given projet in the database
	 * @param projet - the given entity
	 * @return projet if the given projet didn't exist in the database - else, returns null
	 */
	public Projet save(Projet projet) {
		
		// Vérifier si le projet existe dans la BD (email)
//		Projet c = dao.findByEmail(projet.getEmail());
		
		Projet c = new Projet();
		c.setNomEquipe(projet.getNomEquipe());
		c.setNomProjet(projet.getNomProjet());
		
		
		if(dao.exists(Example.of(c))) {
			//Le projet existe dans la BD (FAIL)
			return null;
		}else {
			//Le projet n'existe pas (SUCCESS) : enregistrer le projet dans la BD et retourner le projet
			projet.setDateInsertion(LocalDateTime.now());
			return dao.save(projet);
		}
		
	}
	
	/** Finds all projets in database
	 * @return List of projets - in case no projets has been inserted, it returns an empty list
	 */
	public List<Projet> findAll(){
		return dao.findAll();
	}
	
	/**Updates the values of a given projet
	 * @param projet - the given entity
	 * @return true if the given projet has been modified - else, returns false
	 */
	public boolean updateProjet(Projet projet) {
		
		// Chercher projet par id
		if(dao.existsById(projet.getId())) {
			projet.setDateModification(LocalDateTime.now());
			dao.save(projet);
			return true;
		}else {
			System.out.println("DEBUG Le projet à modifier n'existe pas ");
			return false;
		}
	}
	
	/**Modifies attribute "deleted" from given projet in database
	 * @param projet
	 * @return projet - the given projet
	 */
	public Projet deleteProjet(Projet projet) {
		// Changer la valeur de l'attribut "deleted"
		projet.setDateSuppression(LocalDateTime.now());
		projet.setDeleted(true);
		return dao.save(projet);
	}
}
