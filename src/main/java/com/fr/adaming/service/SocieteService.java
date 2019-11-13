package com.fr.adaming.service;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.stereotype.Service;

import com.fr.adaming.dao.SocieteDao;
import com.fr.adaming.entity.Societe;

@Service
public class SocieteService {

	@Autowired
	private SocieteDao dao;
	
	/**Saves a given societe in the database
	 * @param societe - the given entity
	 * @return societe if the given societe didn't exist in the database - else, returns null
	 */
	public Societe save(Societe societe) {
		
		// Vérifier si le societe existe dans la BD (email)
//		Societe c = dao.findByEmail(societe.getEmail());
		
		Societe c = new Societe();
		c.setNomSociete(societe.getNomSociete());
		c.setLogo(societe.getLogo());
		
		
		if(dao.exists(Example.of(c))) {
			//Le societe existe dans la BD (FAIL)
			return null;
		}else {
			//Le societe n'existe pas (SUCCESS) : enregistrer le societe dans la BD et retourner le societe
			societe.setDateInsertion(LocalDateTime.now());
			return dao.save(societe);
		}
		
	}
	
	/** Finds all societes in database
	 * @return List of societes - in case no societes has been inserted, it returns an empty list
	 */
	public List<Societe> findAll(){
		return dao.findAll();
	}
	
	/**Updates the values of a given societe
	 * @param societe - the given entity
	 * @return true if the given societe has been modified - else, returns false
	 */
	public boolean updateSociete(Societe societe) {
		
		// Chercher societe par id
		if(dao.existsById(societe.getId())) {
			societe.setDateModification(LocalDateTime.now());
			dao.save(societe);
			return true;
		}else {
			System.out.println("DEBUG Le societe à modifier n'existe pas ");
			return false;
		}
	}
	
	/**Modifies attribute "deleted" from given societe in database
	 * @param societe
	 * @return societe - the given societe
	 */
	public Societe deleteSociete(Societe societe) {
		// Changer la valeur de l'attribut "deleted"
		societe.setDateSuppression(LocalDateTime.now());
		societe.setDeleted(true);
		return dao.save(societe);
	}
}
