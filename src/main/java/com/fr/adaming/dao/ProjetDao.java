package com.fr.adaming.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.fr.adaming.entity.Projet;

@Repository
public interface ProjetDao extends JpaRepository<Projet, Long>{

}
