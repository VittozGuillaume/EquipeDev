package com.fr.adaming.entity;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter @Setter @NoArgsConstructor @ToString
@Entity
public class Projet extends AbstractEntity {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String nomProjet;
	private String nomEquipe;
	
	@ManyToMany(cascade = CascadeType.ALL)
	@JoinTable(name = "projet_employe", joinColumns = @JoinColumn(name = "id_projet" ), inverseJoinColumns = @JoinColumn(name = "id_employe"))
	private List<Employe> employes;

}
