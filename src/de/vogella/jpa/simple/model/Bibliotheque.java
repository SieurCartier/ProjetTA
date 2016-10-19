package de.vogella.jpa.simple.model;

import java.util.Collection;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class Bibliotheque {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	private Collection<Oeuvre> oeuvres;

	private Collection<Auteur> auteurs;

	private Collection<Lecteur> lecteurs;

	private Collection<Emprunt> emprunts;

	public Bibliotheque() {
		super();
	}

	public Bibliotheque(Collection<Oeuvre> oeuvres, Collection<Auteur> auteurs) {
		super();
		this.oeuvres = oeuvres;
		this.auteurs = auteurs;
	}

	@OneToMany(fetch = FetchType.EAGER)
	public Collection<Oeuvre> getOeuvres() {
		return oeuvres;
	}

	public void setOeuvres(Collection<Oeuvre> oeuvres) {
		this.oeuvres = oeuvres;
	}

	@OneToMany
	public Collection<Auteur> getAuteurs() {
		return auteurs;
	}

	public void setAuteurs(Collection<Auteur> auteurs) {
		this.auteurs = auteurs;
	}

	@OneToMany
	public Collection<Lecteur> getLecteurs() {
		return lecteurs;
	}

	public void setLecteurs(Collection<Lecteur> lecteurs) {
		this.lecteurs = lecteurs;
	}

	@OneToMany
	public Collection<Emprunt> getEmprunts() {
		return emprunts;
	}

	public void setEmprunts(Collection<Emprunt> emprunts) {
		this.emprunts = emprunts;
	}

	public Long getId() {
		return id;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((auteurs == null) ? 0 : auteurs.hashCode());
		result = prime * result + ((emprunts == null) ? 0 : emprunts.hashCode());
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((lecteurs == null) ? 0 : lecteurs.hashCode());
		result = prime * result + ((oeuvres == null) ? 0 : oeuvres.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Bibliotheque other = (Bibliotheque) obj;
		if (auteurs == null) {
			if (other.auteurs != null)
				return false;
		} else if (!auteurs.equals(other.auteurs))
			return false;
		if (emprunts == null) {
			if (other.emprunts != null)
				return false;
		} else if (!emprunts.equals(other.emprunts))
			return false;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (lecteurs == null) {
			if (other.lecteurs != null)
				return false;
		} else if (!lecteurs.equals(other.lecteurs))
			return false;
		if (oeuvres == null) {
			if (other.oeuvres != null)
				return false;
		} else if (!oeuvres.equals(other.oeuvres))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Bibliotheque [id=" + id + ", oeuvres=" + oeuvres + ", auteurs=" + auteurs + ", lecteurs=" + lecteurs
				+ ", emprunts=" + emprunts + "]";
	}

}
