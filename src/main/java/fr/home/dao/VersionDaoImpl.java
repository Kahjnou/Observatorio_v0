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

import fr.home.model.Version;

@Repository
public class VersionDaoImpl implements IVersionDao {
	
	@PersistenceContext
	private EntityManager em;

	public void setEm(EntityManager em) {
		this.em = em;
	}

	public Version add(Version ver) {
		try {
			em.persist(ver);
			return ver;
		} catch(Exception e) {
			Logger.getLogger(VersionDaoImpl.class.getName()).log(Level.SEVERE, null, e);
		}
		return null;
	}

	public Collection<Version> getAll() {
		try {
			Query query = em.createNamedQuery("version_getAll");
			return query.getResultList();
		} catch(Exception e) {
			Logger.getLogger(VersionDaoImpl.class.getName()).log(Level.SEVERE, null, e);
		}
		return null;
	}

	public Version getOne(int id) {
		try {
			return em.find(Version.class, id);
		} catch(Exception e) {
			Logger.getLogger(VersionDaoImpl.class.getName()).log(Level.SEVERE, null, e);
		}
		return null;
	}

	public void deleteById(int id) {
		try {
			em.remove(em.find(Version.class, id));
		} catch(Exception e) {
			Logger.getLogger(VersionDaoImpl.class.getName()).log(Level.SEVERE, null, e);
		}
	}

	public Version update(Version ver) {
		try {
			em.merge(ver);
			return ver;
		} catch(Exception e) {
			Logger.getLogger(VersionDaoImpl.class.getName()).log(Level.SEVERE, null, e);
		}
		return null;
	}

}
