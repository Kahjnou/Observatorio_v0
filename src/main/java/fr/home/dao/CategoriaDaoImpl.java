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

import fr.home.model.Categoria;

@Repository
public class CategoriaDaoImpl implements ICategoriaDao {
	
	@PersistenceContext
	private EntityManager em;

	public void setEm(EntityManager em) {
		this.em = em;
	}

	public Categoria add(Categoria cat) {
		try {
			em.persist(cat);
			return cat;
		} catch(Exception e) {
			Logger.getLogger(CategoriaDaoImpl.class.getName()).log(Level.SEVERE, null, e);
		}
		return null;
	}

	public Collection<Categoria> getAll() {
		try {
			Query query = em.createNamedQuery("categoria_getAll");
			return query.getResultList();
		} catch(Exception e) {
			Logger.getLogger(CategoriaDaoImpl.class.getName()).log(Level.SEVERE, null, e);
		}
		return null;
	}

	public Categoria getOne(int id) {
		try {
			return em.find(Categoria.class, id);			
		} catch(Exception e) {
			Logger.getLogger(CategoriaDaoImpl.class.getName()).log(Level.SEVERE, null, e);
		}
		return null;
	}

	public void deleteById(int id) {
		try {
			em.remove(em.find(Categoria.class, id));			
		} catch(Exception e) {
			Logger.getLogger(CategoriaDaoImpl.class.getName()).log(Level.SEVERE, null, e);
		}		
	}

	public Categoria update(Categoria cat) {
		try {
			em.merge(cat);
			return cat;
		} catch(Exception e) {
			Logger.getLogger(CategoriaDaoImpl.class.getName()).log(Level.SEVERE, null, e);
		}
		return null;
	}

}
