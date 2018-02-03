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

import fr.home.model.Respuesta;

@Repository
public class RespuestaDaoImpl implements IRespuestaDao {

	@PersistenceContext
	private EntityManager em;

	public void setEm(EntityManager em) {
		this.em = em;
	}

	public Respuesta add(Respuesta resp) {
		try {
			em.persist(resp);
			return resp;
		} catch(Exception e) {
			Logger.getLogger(RespuestaDaoImpl.class.getName()).log(Level.SEVERE, null, e);
		}
		return null;
	}

	public Collection<Respuesta> getAll() {
		try {
			Query query = em.createNamedQuery("respuesta_getAll");
			return query.getResultList();
		} catch(Exception e) {
			Logger.getLogger(RespuestaDaoImpl.class.getName()).log(Level.SEVERE, null, e);
		}
		return null;
	}

	public Respuesta getOne(int id) {
		try {
			return em.find(Respuesta.class, id);
		} catch(Exception e) {
			Logger.getLogger(RespuestaDaoImpl.class.getName()).log(Level.SEVERE, null, e);
		}
		return null;
	}

	public void deleteById(int id) {
		try {
			em.remove(em.find(Respuesta.class, id));
		} catch(Exception e) {
			Logger.getLogger(RespuestaDaoImpl.class.getName()).log(Level.SEVERE, null, e);
		}		
	}

	public Respuesta update(Respuesta resp) {
		try {
			em.merge(resp);
			return resp;
		} catch(Exception e) {
			Logger.getLogger(RespuestaDaoImpl.class.getName()).log(Level.SEVERE, null, e);
		}
		return null;
	}
}
