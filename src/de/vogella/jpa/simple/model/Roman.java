package de.vogella.jpa.simple.model;

import java.util.Collection;

import javax.persistence.Entity;

@Entity
public class Roman extends Oeuvre {

	public Roman() {
		super();
	}

	public Roman(String titre, Collection<Auteur> auteurs, Emprunt oeuvreEmprunte) {
		super(titre, auteurs, oeuvreEmprunte);
	}

	@Override
	public String toString() {
		return "Roman []";
	}

}
