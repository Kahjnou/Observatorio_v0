package fr.home.util;

import java.util.logging.Level;
import java.util.logging.Logger;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

public class DbUtility {

	public static EntityManagerFactory emf;
	public static EntityManager em;
	public static EntityTransaction tx;
	
	static {
		try {
			emf = Persistence.createEntityManagerFactory("Prototipo");
			em = emf.createEntityManager();
			tx = em.getTransaction();
		}catch(Exception ex) {
			Logger.getLogger(DbUtility.class.getName()).log(Level.SEVERE, null,
					ex);
		}
	}

	public static EntityManager getEm() {
		return em;
	}

	public static EntityTransaction getTx() {
		return tx;
	}
	
}
