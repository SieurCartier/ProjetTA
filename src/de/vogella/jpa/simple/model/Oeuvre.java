package de.vogella.jpa.simple.model;

import java.util.Collection;
import java.util.LinkedList;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.OneToOne;

@Entity
public abstract class Oeuvre {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	protected Long id;

	protected String titre;

	protected Collection<Auteur> auteurs;

	protected Emprunt oeuvreEmprunte;

	public Oeuvre() {
		super();
		auteurs = new LinkedList<>();
	}

	public Oeuvre(String titre, Collection<Auteur> auteurs, Emprunt oeuvreEmprunte) {
		super();
		this.titre = titre;
		this.auteurs = auteurs;
		this.oeuvreEmprunte = oeuvreEmprunte;
	}

	public String getTitre() {
		return titre;
	}

	public void setTitre(String titre) {
		this.titre = titre;
	}

	@ManyToMany
	public Collection<Auteur> getAuteurs() {
		return auteurs;
	}

	public void setAuteurs(Collection<Auteur> auteurs) {
		this.auteurs = auteurs;
	}

	@OneToOne(fetch = FetchType.EAGER)
	public Emprunt getOeuvreEmprunte() {
		return oeuvreEmprunte;
	}

	public void setOeuvreEmprunte(Emprunt oeuvreEmprunte) {
		this.oeuvreEmprunte = oeuvreEmprunte;
	}

	public void addAuteur(Auteur a) {
		auteurs.add(a);
	}

	public Long getId() {
		return id;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((auteurs == null) ? 0 : auteurs.hashCode());
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((oeuvreEmprunte == null) ? 0 : oeuvreEmprunte.hashCode());
		result = prime * result + ((titre == null) ? 0 : titre.hashCode());
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
		Oeuvre other = (Oeuvre) obj;
		if (auteurs == null) {
			if (other.auteurs != null)
				return false;
		} else if (!auteurs.equals(other.auteurs))
			return false;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (oeuvreEmprunte == null) {
			if (other.oeuvreEmprunte != null)
				return false;
		} else if (!oeuvreEmprunte.equals(other.oeuvreEmprunte))
			return false;
		if (titre == null) {
			if (other.titre != null)
				return false;
		} else if (!titre.equals(other.titre))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Oeuvre [id=" + id + ", titre=" + titre + "]";
	}

}
