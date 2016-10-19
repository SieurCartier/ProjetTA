package de.vogella.jpa.simple.model;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;

@Entity
public class Emprunt {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	protected Long id;

	private Lecteur lecteur;

	private Oeuvre oeuvre;

	public Emprunt() {
		super();
	}

	public Emprunt(Lecteur lecteur, Oeuvre oeuvre) {
		super();
		this.lecteur = lecteur;
		this.oeuvre = oeuvre;
	}

	@ManyToOne(fetch = FetchType.EAGER)
	public Lecteur getLecteur() {
		return lecteur;
	}

	public void setLecteur(Lecteur lecteur) {
		this.lecteur = lecteur;
	}

	@OneToOne(fetch = FetchType.EAGER)
	public Oeuvre getOeuvre() {
		return oeuvre;
	}

	public void setOeuvre(Oeuvre oeuvre) {
		this.oeuvre = oeuvre;
	}

	public Long getId() {
		return id;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((lecteur == null) ? 0 : lecteur.hashCode());
		result = prime * result + ((oeuvre == null) ? 0 : oeuvre.hashCode());
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
		Emprunt other = (Emprunt) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (lecteur == null) {
			if (other.lecteur != null)
				return false;
		} else if (!lecteur.equals(other.lecteur))
			return false;
		if (oeuvre == null) {
			if (other.oeuvre != null)
				return false;
		} else if (!oeuvre.equals(other.oeuvre))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Emprunt [id=" + id + ", lecteur=" + lecteur + ", oeuvre=" + oeuvre + "]";
	}

}
