package com.fr.adaming.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fr.adaming.entity.Client;
import com.fr.adaming.service.ClientService;

@RestController
@RequestMapping(path = "api/client")
public class ClientController {

	@Autowired
	private ClientService service;

	@PostMapping(path = "/save")
	public String save(@RequestBody Client client) {
		if (service.save(client) != null) {
			return "SUCCESS";
		} else {
			return "FAIL";
		}
	}

	@GetMapping(path = "/find-all")
	public List<Client> findAll() {
		return service.findAll();
	}

	@PutMapping(path = "/update")
	public String updateClient(@RequestBody Client client) {
		if (service.updateClient(client)) {
			return "SUCCESS";
		} else {
			return "FAIL";
		}
	}

	@DeleteMapping(path = "/delete")
	public String deleteClient(@RequestBody Client client) {
		if (service.deleteClient(client) != null) {
			return "SUCCESS";
		} else {
			return "FAIL";
		}
	}

//	@PostMapping(path = "/login")
//	public String login(@RequestBody LoginDto loginDto) {
//		if (service.login(loginDto.getEmail(), loginDto.getPwd()) != null) {
//			return "CONNECTE";
//		} else {
//			return "ECHEC CONNEXION";
//		}
//	}
}
