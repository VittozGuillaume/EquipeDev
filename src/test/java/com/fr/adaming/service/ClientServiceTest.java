package com.fr.adaming.service;


import static org.junit.Assert.assertNotNull;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.fr.adaming.entity.Client;

@SpringBootTest
public class ClientServiceTest {

	@Autowired
	private ClientService service;
	
	@Test
	public void createValidClient_shouldReturnClientWithIdNotNull() {
		//prépare les inputs
		Client c = new Client();
		
		c.setNom("nomA");
		c.setEmail("emailA");
		
		//invoc method
		Client returnedClient = service.save(c);
		
		
		
		//vérifier le résultat
		assertNotNull(returnedClient);
		assertNotNull(returnedClient.getId());
	}
}
