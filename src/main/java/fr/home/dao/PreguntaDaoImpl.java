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

import fr.home.model.Pregunta;

@Repository
public class PreguntaDaoImpl implements IPreguntaDao {

	@PersistenceContext
	private EntityManager em;

	public void setEm(EntityManager em) {
		this.em = em;
	}

	public Pregunta add(Pregunta preg) {
		try {
			em.persist(preg);
			return preg;
		} catch(Exception e) {
			Logger.getLogger(PreguntaDaoImpl.class.getName()).log(Level.SEVERE, null, e);
		}
		return null;
	}

	public Collection<Pregunta> getAll() {
		try {
			Query query = em.createNamedQuery("pregunta_getAll");
			return query.getResultList();
		} catch(Exception e) {
			Logger.getLogger(PreguntaDaoImpl.class.getName()).log(Level.SEVERE, null, e);
		}
		return null;
	}

	public Pregunta getOne(int id) {
		try {
			return em.find(Pregunta.class, id);
		} catch(Exception e) {
			Logger.getLogger(PreguntaDaoImpl.class.getName()).log(Level.SEVERE, null, e);
		}
		return null;
	}

	public void deleteById(int id) {
		try {
			em.remove(em.find(Pregunta.class, id));
		} catch(Exception e) {
			Logger.getLogger(PreguntaDaoImpl.class.getName()).log(Level.SEVERE, null, e);
		}		
	}

	public Pregunta update(Pregunta preg) {
		try {
			em.merge(preg);
			return preg;
		} catch(Exception e) {
			Logger.getLogger(PreguntaDaoImpl.class.getName()).log(Level.SEVERE, null, e);
		}
		return null;
	}
}
