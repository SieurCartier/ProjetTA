package de.vogella.jpa.simple.model;

import java.util.Collection;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class Lecteur {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	private String name;

	private Collection<Emprunt> emprunts;

	public Lecteur() {
		super();
	}

	public Lecteur(String name, Collection<Emprunt> emprunts) {
		super();
		this.name = name;
		this.emprunts = emprunts;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@OneToMany(mappedBy = "lecteur")
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
		result = prime * result + ((emprunts == null) ? 0 : emprunts.hashCode());
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((name == null) ? 0 : name.hashCode());
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
		Lecteur other = (Lecteur) obj;
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
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Lecteur [id=" + id + ", name=" + name + ", emprunts=" + emprunts + "]";
	}

}
