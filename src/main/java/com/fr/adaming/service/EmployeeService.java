package com.fr.adaming.service;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.stereotype.Service;

import com.fr.adaming.dao.EmployeeDao;
import com.fr.adaming.entity.Employe;

@Service
public class EmployeeService {

	
	@Autowired
	private EmployeeDao dao;
	
	/**Saves a given employee in the database
	 * @param employee - the given entity
	 * @return employee if the given employee didn't exist in the database - else, returns null
	 */
	public Employe save(Employe employee) {
		
		// Vérifier si le employee existe dans la BD (email)
//		Employe c = dao.findByEmail(employee.getEmail());
		
		Employe c = new Employe();
		c.setEmail(employee.getEmail());
		
		
		if(dao.exists(Example.of(c))) {
			//Le employee existe dans la BD (FAIL)
			return null;
		}else {
			//Le employee n'existe pas (SUCCESS) : enregistrer le employee dans la BD et retourner le employee
			employee.setDateInsertion(LocalDateTime.now());
			return dao.save(employee);
		}
		
	}
	
	/** Finds all employees in database
	 * @return List of employees - in case no employees has been inserted, it returns an empty list
	 */
	public List<Employe> findAll(){
		return dao.findAll();
	}
	
	/**Updates the values of a given employee
	 * @param employee - the given entity
	 * @return true if the given employee has been modified - else, returns false
	 */
	public boolean updateEmploye(Employe employee) {
		
		// Chercher employee par id
		if(dao.existsById(employee.getId())) {
			employee.setDateModification(LocalDateTime.now());
			dao.save(employee);
			return true;
		}else {
			System.out.println("DEBUG Le employee à modifier n'existe pas ");
			return false;
		}
	}
	
	/**Modifies attribute "deleted" from given employee in database
	 * @param employee
	 * @return employee - the given employee
	 */
	public Employe deleteEmploye(Employe employee) {
		// Changer la valeur de l'attribut "deleted"
		employee.setDateSuppression(LocalDateTime.now());
		employee.setDeleted(true);
		return dao.save(employee);
	}
	
	
	public Employe login(String email, String pwd) {
		return dao.findByEmailAndPwd(email, pwd);
	}

}

