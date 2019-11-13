package com.fr.adaming.service;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.stereotype.Service;

import com.fr.adaming.dao.ContratDao;
import com.fr.adaming.entity.Contrat;

@Service
public class ContratService {


	@Autowired
	private ContratDao dao;
	
	/**Saves a given contrat in the database
	 * @param contrat - the given entity
	 * @return contrat if the given contrat didn't exist in the database - else, returns null
	 */
	public Contrat save(Contrat contrat) {
		
		// Vérifier si le contrat existe dans la BD (email)
//		Contrat c = dao.findByEmail(contrat.getEmail());
		
		Contrat c = new Contrat();
		c.setMethodologie(contrat.getMethodologie());
		
		
		if(dao.exists(Example.of(c))) {
			//Le contrat existe dans la BD (FAIL)
			return null;
		}else {
			//Le contrat n'existe pas (SUCCESS) : enregistrer le contrat dans la BD et retourner le contrat
			contrat.setDateInsertion(LocalDateTime.now());
			return dao.save(contrat);
		}
		
	}
	
	/** Finds all contrats in database
	 * @return List of contrats - in case no contrats has been inserted, it returns an empty list
	 */
	public List<Contrat> findAll(){
		return dao.findAll();
	}
	
	/**Updates the values of a given contrat
	 * @param contrat - the given entity
	 * @return true if the given contrat has been modified - else, returns false
	 */
	public boolean updateContrat(Contrat contrat) {
		
		// Chercher contrat par id
		if(dao.existsById(contrat.getId())) {
			contrat.setDateModification(LocalDateTime.now());
			dao.save(contrat);
			return true;
		}else {
			System.out.println("DEBUG Le contrat à modifier n'existe pas ");
			return false;
		}
	}
	
	/**Modifies attribute "deleted" from given contrat in database
	 * @param contrat
	 * @return contrat - the given contrat
	 */
	public Contrat deleteContrat(Contrat contrat) {
		// Changer la valeur de l'attribut "deleted"
		contrat.setDateSuppression(LocalDateTime.now());
		contrat.setDeleted(true);
		return dao.save(contrat);
	}
}
