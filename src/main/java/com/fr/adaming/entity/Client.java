package com.fr.adaming.entity;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter @Setter @NoArgsConstructor @ToString
@Entity
public class Client extends User {
	
	private String domaine;
	private String nomRepresentant;
	private String nomEntreprise;
	
	@OneToMany(cascade = CascadeType.ALL)
	@JoinColumn(name = "id_client")
	private List<Contrat> contrat;
	
	@OneToMany(cascade = CascadeType.ALL)
	@JoinColumn(name = "id_client")
	private List<Projet> projets;

	public Client(String nom, String prenom, String email, String domaine,
			String nomRepresentant, String nomEntreprise) {
		this.nom = nom;
		this.prenom = prenom;
		this.email = email;
		this.domaine = domaine;
		this.nomRepresentant = nomRepresentant;
		this.nomEntreprise = nomEntreprise;
	}

	public Client(Long id, String nom, String prenom, String email, String domaine,
			String nomRepresentant, String nomEntreprise) {
		this.id = id;
		this.nom = nom;
		this.prenom = prenom;
		this.email = email;
		this.domaine = domaine;
		this.nomRepresentant = nomRepresentant;
		this.nomEntreprise = nomEntreprise;
	}
	
	
	
	
	

}
