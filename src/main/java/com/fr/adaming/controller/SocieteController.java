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

import com.fr.adaming.entity.Societe;
import com.fr.adaming.service.SocieteService;

@RestController
@RequestMapping(path = "/api/societe")
public class SocieteController {


	@Autowired
	private SocieteService service;

	@PostMapping(path = "/save")
	public String save(@RequestBody Societe societe) {
		if (service.save(societe)!= null) {
			return "SUCCESS";
		} else {
			return "FAIL";
		}
	}

	@GetMapping(path = "/find-all")
	public List<Societe> findAll() {
		return service.findAll();
	}

	@PutMapping(path = "/update")
	public String updateSociete(@RequestBody Societe societe) {
		if (service.updateSociete(societe)) {
			return "SUCCESS";
		} else {
			return "FAIL";
		}
	}

	@DeleteMapping(path = "/delete")
	public String deleteSociete(@RequestBody Societe societe) {
		if (service.deleteSociete(societe) != null) {
			return "SUCCESS";
		} else {
			return "FAIL";
		}
	}

}
