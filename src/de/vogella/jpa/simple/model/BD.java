package de.vogella.jpa.simple.model;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.OneToOne;

@Entity
public class BD extends Oeuvre {

	protected JournalPeriodic journalOrigine;

	public BD() {
		super();
	}

	public BD(JournalPeriodic journalOrigine) {
		super();
		this.journalOrigine = journalOrigine;
	}

	@OneToOne(fetch = FetchType.EAGER)
	public JournalPeriodic getJournalOrigine() {
		return journalOrigine;
	}

	public void setJournalOrigine(JournalPeriodic journalOrigine) {
		this.journalOrigine = journalOrigine;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + ((journalOrigine == null) ? 0 : journalOrigine.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (!super.equals(obj))
			return false;
		if (getClass() != obj.getClass())
			return false;
		BD other = (BD) obj;
		if (journalOrigine == null) {
			if (other.journalOrigine != null)
				return false;
		} else if (!journalOrigine.equals(other.journalOrigine))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "BD [journalOrigine=" + journalOrigine + "]";
	}

}
