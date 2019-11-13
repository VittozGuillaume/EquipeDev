package com.fr.adaming.entity;

import java.time.LocalDateTime;

import javax.persistence.MappedSuperclass;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter @Setter @NoArgsConstructor @ToString
@MappedSuperclass
public abstract class AbstractEntity {
	
	protected LocalDateTime dateInsertion;
	protected LocalDateTime dateModification;
	protected LocalDateTime dateSuppression;
	protected boolean deleted;

}
