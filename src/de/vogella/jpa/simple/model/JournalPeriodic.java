package de.vogella.jpa.simple.model;

import java.util.Collection;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.OneToOne;

@Entity
public class JournalPeriodic extends Oeuvre {

	private BD bd;

	public JournalPeriodic() {
		super();
	}

	public JournalPeriodic(String titre, Collection<Auteur> auteurs, Emprunt oeuvreEmprunte) {
		super(titre, auteurs, oeuvreEmprunte);
	}

	public JournalPeriodic(BD bd) {
		super();
		this.bd = bd;
	}

	@OneToOne(fetch = FetchType.EAGER)
	public BD getBd() {
		return bd;
	}

	public void setBd(BD bd) {
		this.bd = bd;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + ((bd == null) ? 0 : bd.hashCode());
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
		JournalPeriodic other = (JournalPeriodic) obj;
		if (bd == null) {
			if (other.bd != null)
				return false;
		} else if (!bd.equals(other.bd))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "JournalPeriodic [bd=" + bd + "]";
	}

}
