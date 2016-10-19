package de.vogella.jpa.simple.model;

import java.util.Collection;

import javax.persistence.Entity;
import javax.persistence.OneToMany;

@Entity
public class Film extends Oeuvre {

	private Collection<Auteur> realisateurs;

	public Film() {
		super();
	}

	public Film(String titre, Collection<Auteur> auteurs, Emprunt oeuvreEmprunte) {
		super(titre, auteurs, oeuvreEmprunte);
	}

	public Film(String titre, Collection<Auteur> auteurs, Emprunt oeuvreEmprunte, Collection<Auteur> realisateurs) {
		super(titre, auteurs, oeuvreEmprunte);
		this.realisateurs = realisateurs;
	}

	public Film(Collection<Auteur> realisateurs) {
		super();
		this.realisateurs = realisateurs;
	}

	@OneToMany
	public Collection<Auteur> getRealisateurs() {
		return realisateurs;
	}

	public void setRealisateurs(Collection<Auteur> realisateurs) {
		this.realisateurs = realisateurs;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + ((realisateurs == null) ? 0 : realisateurs.hashCode());
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
		Film other = (Film) obj;
		if (realisateurs == null) {
			if (other.realisateurs != null)
				return false;
		} else if (!realisateurs.equals(other.realisateurs))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Film [realisateurs=" + realisateurs + "]";
	}

}
