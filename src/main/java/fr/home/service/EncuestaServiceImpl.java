package fr.home.service;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import fr.home.dao.IEncuestaDao;
import fr.home.model.Encuesta;

@Service
@Transactional
public class EncuestaServiceImpl implements IEncuestaService {

	private IEncuestaDao dao;

	public void setDao(IEncuestaDao dao) {
		this.dao = dao;
	}

	public Encuesta add(Encuesta enc) {
		return dao.add(enc);
	}

	public Collection<Encuesta> getAll() {
		return dao.getAll();
	}

	public Encuesta getOne(int id) {
		return dao.getOne(id);
	}

	public void deleteById(int id) {
		dao.deleteById(id);		
	}

	public Encuesta update(Encuesta enc) {
		return dao.update(enc);
	}
}
