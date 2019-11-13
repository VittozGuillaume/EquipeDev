package com.fr.adaming.entity;

import java.time.LocalDate;

import javax.persistence.Entity;
import javax.persistence.Enumerated;

import com.fr.adaming.enumeration.FonctionType;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter @Setter @NoArgsConstructor @ToString
@Entity
public class Employe extends User {
	
	private String pwd;
	private double salaire;
	@Enumerated
	private FonctionType fonction;
	private LocalDate dateRecrutement;
	
	
	

}
