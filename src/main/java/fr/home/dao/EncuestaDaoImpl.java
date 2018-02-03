package fr.home.dao;

import java.util.Collection;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import fr.home.model.Encuesta;

@Repository
public class EncuestaDaoImpl implements IEncuestaDao {
	
	@PersistenceContext
	private EntityManager em;

	public void setEm(EntityManager em) {
		this.em = em;
	}

	public Encuesta add(Encuesta enc) {
		try {
			em.persist(enc);
			return enc;
		} catch(Exception e) {
			Logger.getLogger(EncuestaDaoImpl.class.getName()).log(Level.SEVERE, null, e);
		}
		return null;
	}

	public Collection<Encuesta> getAll() {
		try {
			Query query = em.createNamedQuery("encuesta_getall");
			return query.getResultList();
		} catch(Exception e) {
			Logger.getLogger(EncuestaDaoImpl.class.getName()).log(Level.SEVERE, null, e);
		}
		return null;
	}

	public Encuesta getOne(int id) {
		try {
			return em.find(Encuesta.class, id);
		} catch(Exception e) {
			Logger.getLogger(EncuestaDaoImpl.class.getName()).log(Level.SEVERE, null, e);
		}
		return null;
	}

	public void deleteById(int id) {
		try {
			em.remove(em.find(Encuesta.class, id));
		} catch(Exception e) {
			Logger.getLogger(EncuestaDaoImpl.class.getName()).log(Level.SEVERE, null, e);
		}
	}

	public Encuesta update(Encuesta enc) {
		try {
			em.merge(enc);
			return enc;
		} catch(Exception e) {
			Logger.getLogger(EncuestaDaoImpl.class.getName()).log(Level.SEVERE, null, e);
		}
		return null;
	}

}
