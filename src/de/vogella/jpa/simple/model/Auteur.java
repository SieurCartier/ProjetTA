package de.vogella.jpa.simple.model;

import java.util.Collection;
import java.util.LinkedList;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;

@Entity
public class Auteur {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	private String name;

	private Collection<Oeuvre> oeuvres;

	public Auteur() {
		super();
		oeuvres = new LinkedList<>();
	}

	public Auteur(String name, Collection<Oeuvre> oeuvres) {
		super();
		this.name = name;
		this.oeuvres = oeuvres;
	}

	public Auteur(String name) {
		super();
		this.name = name;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@ManyToMany
	public Collection<Oeuvre> getOeuvres() {
		return oeuvres;
	}

	public void setOeuvres(Collection<Oeuvre> oeuvres) {
		this.oeuvres = oeuvres;
	}

	public Long getId() {
		return id;
	}

	public void addOeuvre(Oeuvre o) {
		oeuvres.add(o);
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((name == null) ? 0 : name.hashCode());
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
		Auteur other = (Auteur) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
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
		return "Auteur [id=" + id + ", name=" + name + ", oeuvres=" + oeuvres + "]";
	}

}
