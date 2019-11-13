package com.fr.adaming.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.fr.adaming.entity.Societe;

public interface SocieteDao extends JpaRepository<Societe, Long> {

	public Societe findByNomSociete(String nomSociete);

	public Societe findSocieteById(Long id);

	public boolean existsById(Long id);

	public List<Societe> findByNomSocieteIn(List<String> nomSociete);

	public List<Societe> findAll();
}
