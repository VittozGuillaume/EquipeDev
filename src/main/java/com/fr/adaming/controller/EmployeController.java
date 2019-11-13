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

import com.fr.adaming.controller.dto.LoginDto;
import com.fr.adaming.entity.Employe;
import com.fr.adaming.service.EmployeeService;

@RestController
@RequestMapping(path = "api/employe")
public class EmployeController {


	@Autowired
	private EmployeeService service;

	@PostMapping(path = "/save")
	public String save(@RequestBody Employe employe) {
		if (service.save(employe) != null) {
			return "SUCCESS";
		} else {
			return "FAIL";
		}
	}

	@GetMapping(path = "/find-all")
	public List<Employe> findAll() {
		return service.findAll();
	}

	@PutMapping(path = "/update")
	public String updateEmploye(@RequestBody Employe employe) {
		if (service.updateEmploye(employe)) {
			return "SUCCESS";
		} else {
			return "FAIL";
		}
	}

	@DeleteMapping(path = "/delete")
	public String deleteEmploye(@RequestBody Employe employe) {
		if (service.deleteEmploye(employe) != null) {
			return "SUCCESS";
		} else {
			return "FAIL";
		}
	}

	@PostMapping(path = "/login")
	public String login(@RequestBody LoginDto loginDto) {
		if (service.login(loginDto.getEmail(), loginDto.getPwd()) != null) {
			return "CONNECTE";
		} else {
			return "ECHEC CONNEXION";
		}
	}
}
