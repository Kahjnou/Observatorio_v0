package fr.home.service;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import fr.home.dao.ISesionEncuestaDao;
import fr.home.model.SesionEncuesta;

@Service
@Transactional
public class SesionEncuestaServiceImpl implements ISesionEncuestaService {

	private ISesionEncuestaDao dao;

	public void setDao(ISesionEncuestaDao dao) {
		this.dao = dao;
	}

	public SesionEncuesta add(SesionEncuesta se) {
		return dao.add(se);
	}

	public Collection<SesionEncuesta> getAll() {
		return dao.getAll();
	}

	public SesionEncuesta getOne(int id) {
		return dao.getOne(id);
	}

	public void deleteById(int id) {
		dao.deleteById(id);
	}

	public SesionEncuesta update(SesionEncuesta se) {
		return dao.update(se);
	}
	
}
