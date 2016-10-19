package de.vogella.jpa.simple.model;

import javax.persistence.Entity;

@Entity
public class Manga extends BD {

	public Manga() {
		super();
	}

	public Manga(JournalPeriodic journalOrigine) {
		super(journalOrigine);
	}

	@Override
	public String toString() {
		return "Manga [journalOrigine=" + journalOrigine + ", id=" + id + ", titre=" + titre + ", auteurs=" + auteurs
				+ ", oeuvreEmprunte=" + oeuvreEmprunte + "]";
	}

}
