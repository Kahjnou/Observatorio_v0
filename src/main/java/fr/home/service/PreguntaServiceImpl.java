package fr.home.service;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import fr.home.dao.IPreguntaDao;
import fr.home.model.Pregunta;

@Service
@Transactional
public class PreguntaServiceImpl implements IPreguntaService {

	private IPreguntaDao dao;

	public void setDao(IPreguntaDao dao) {
		this.dao = dao;
	}

	public Pregunta add(Pregunta enc) {
		return dao.add(enc);
	}

	public Collection<Pregunta> getAll() {
		return dao.getAll();
	}

	public Pregunta getOne(int id) {
		return dao.getOne(id);
	}

	public void deleteById(int id) {
		dao.deleteById(id);
	}

	public Pregunta update(Pregunta enc) {
		return dao.update(enc);
	}
	
}
