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

import fr.home.model.SesionEncuesta;

@Repository
public class SesionEncuestaDaoImpl implements ISesionEncuestaDao {
	
	@PersistenceContext
	private EntityManager em;

	public void setEm(EntityManager em) {
		this.em = em;
	}

	public SesionEncuesta add(SesionEncuesta se) {
		try {
			em.persist(se);
			return se;
		} catch(Exception e) {
			Logger.getLogger(SesionEncuestaDaoImpl.class.getName()).log(Level.SEVERE, null, e);
		}
		return null;
	}

	public Collection<SesionEncuesta> getAll() {
		try {
			Query query = em.createNamedQuery("sesion_getAll");
			return query.getResultList();
		} catch(Exception e) {
			Logger.getLogger(SesionEncuestaDaoImpl.class.getName()).log(Level.SEVERE, null, e);
		}
		return null;
	}

	public SesionEncuesta getOne(int id) {
		try {
			return em.find(SesionEncuesta.class, id);
		} catch(Exception e) {
			Logger.getLogger(SesionEncuestaDaoImpl.class.getName()).log(Level.SEVERE, null, e);
		}
		return null;
	}

	public void deleteById(int id) {
		try {
			em.remove(em.find(SesionEncuesta.class, id));
		} catch(Exception e) {
			Logger.getLogger(SesionEncuestaDaoImpl.class.getName()).log(Level.SEVERE, null, e);
		}
	}

	public SesionEncuesta update(SesionEncuesta se) {
		try {
			em.merge(se);
			return se;
		} catch(Exception e) {
			Logger.getLogger(SesionEncuestaDaoImpl.class.getName()).log(Level.SEVERE, null, e);
		}
		return null;
	}
	

}
