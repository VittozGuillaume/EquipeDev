package com.fr.adaming.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.fr.adaming.entity.Client;

@Repository
public interface ClientDao extends JpaRepository<Client, Long> {
	
	public Client findByEmail(String email);

//	public Client findByEmailAndPwd(String email, String pwd);
	
}
