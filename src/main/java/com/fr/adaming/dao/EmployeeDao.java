package com.fr.adaming.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.fr.adaming.entity.Employe;

@Repository
public interface EmployeeDao extends JpaRepository<Employe, Long>{

	public Employe findByEmail(String email);

	public Employe findByEmailAndPwd(String email, String pwd);
	
}
