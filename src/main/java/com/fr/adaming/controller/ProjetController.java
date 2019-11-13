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

import com.fr.adaming.entity.Contrat;
import com.fr.adaming.service.ContratService;

@RestController
@RequestMapping(path = "/api/projet")
public class ProjetController {



	@Autowired
	private ContratService service;

	@PostMapping(path = "/save")
	public String save(@RequestBody Contrat contrat) {
		if (service.save(contrat)!= null) {
			return "SUCCESS";
		} else {
			return "FAIL";
		}
	}

	@GetMapping(path = "/find-all")
	public List<Contrat> findAll() {
		return service.findAll();
	}

	@PutMapping(path = "/update")
	public String updateContrat(@RequestBody Contrat contrat) {
		if (service.updateContrat(contrat)) {
			return "SUCCESS";
		} else {
			return "FAIL";
		}
	}

	@DeleteMapping(path = "/delete")
	public String deleteContrat(@RequestBody Contrat contrat) {
		if (service.deleteContrat(contrat) != null) {
			return "SUCCESS";
		} else {
			return "FAIL";
		}
	}
}
