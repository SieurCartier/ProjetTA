package de.vogella.jpa.simple.model;

import static org.junit.Assert.assertTrue;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

import org.junit.Before;
import org.junit.Test;

public class TestApp {

	private static final String PERSISTENCE_UNIT_NAME = "books";
	private static EntityManagerFactory factory;
	private static boolean set = false;

	@Before
	public void setUp() throws Exception {
		if (!set) {
			factory = Persistence.createEntityManagerFactory(PERSISTENCE_UNIT_NAME);
			EntityManager em = factory.createEntityManager();

			createOeuvres();
			createAuteurs();

			Query allOeuvre = em.createQuery("select o from Oeuvre o");
			List<Oeuvre> oeuvres = allOeuvre.getResultList();

			Query allAuthor = em.createQuery("select a from Auteur a");
			List<Auteur> authors = allAuthor.getResultList();

			em.getTransaction().begin();

			for (Oeuvre o : oeuvres) {
				for (Auteur a : authors) {
					o.addAuteur(a);
					em.persist(o);
					a.addOeuvre(o);
					em.persist(a);
				}
			}

			em.getTransaction().commit();
			em.close();

			set = true;
		}
	}

	private void createOeuvres() {
		EntityManager em = factory.createEntityManager();
		em.getTransaction().begin();

		for (int i = 0; i < 60; i++) {
			Oeuvre o = new Roman();
			o.setTitre("Oeuvre" + i);
			em.persist(o);
		}

		em.getTransaction().commit();
		em.close();
	}

	private void createAuteurs() {
		EntityManager em = factory.createEntityManager();

		em.getTransaction().begin();

		for (int i = 0; i < 60; i++) {
			Auteur o = new Auteur();
			o.setName("Auteur" + i);
			em.persist(o);
		}

		em.getTransaction().commit();
		em.close();
	}

	@Test
	public void createBooksAndAuthors() {
		EntityManager em = factory.createEntityManager();

		createOeuvres();

		Query allOeuvre = em.createQuery("select o from Oeuvre o");
		List<Oeuvre> oeuvres = allOeuvre.getResultList();

		createAuteurs();

		Query allAuthor = em.createQuery("select a from Auteur a");
		List<Auteur> authors = allAuthor.getResultList();

		for (Oeuvre o : oeuvres) {
			assertTrue(o.getAuteurs().containsAll(authors));
		}

		for (Auteur a : authors) {
			assertTrue(a.getOeuvres().containsAll(oeuvres));
		}
	}

}
