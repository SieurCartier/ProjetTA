package de.vogella.jpa.simple.model;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import java.util.List;
import java.util.Random;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

import org.junit.Before;
import org.junit.Test;

public class AuteurTest {

	private static final String PERSISTENCE_UNIT_NAME = "books";
	private EntityManagerFactory factory;
	private static boolean set = false;

	@Before
	public void setUp() throws Exception {
		if (!set) {
			factory = Persistence.createEntityManagerFactory(PERSISTENCE_UNIT_NAME);
			EntityManager em = factory.createEntityManager();

			em.getTransaction().begin();

			for (int i = 0; i < 60; i++) {
				Auteur a = new Auteur();
				a.setName("Author" + i);
				em.persist(a);
			}

			em.getTransaction().commit();

			em.close();
			set = true;
		}
	}

	@Test
	public void everythingGenerated() {
		factory = Persistence.createEntityManagerFactory(PERSISTENCE_UNIT_NAME);
		EntityManager em = factory.createEntityManager();
		Query allAuthor = em.createQuery("select a from Auteur a");
		List<Auteur> l = allAuthor.getResultList();

		assertEquals(60, l.size());
	}

	@Test
	public void randomAuthorExists() {
		EntityManager em = factory.createEntityManager();

		Query specificAuthor = em.createQuery("select a from Auteur a Where a.name = :name");

		String name = "Author" + new Random().nextInt(59);

		specificAuthor.setParameter("name", name);

		Auteur auteur = (Auteur) specificAuthor.getSingleResult();

		assertNotNull(auteur);
		assertEquals(name, auteur.getName());
	}

}
