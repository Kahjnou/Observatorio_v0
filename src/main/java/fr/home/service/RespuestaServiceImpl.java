package fr.home.service;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import fr.home.dao.IRespuestaDao;
import fr.home.model.Respuesta;

@Service
@Transactional
public class RespuestaServiceImpl implements IRespuestaService{

	private IRespuestaDao dao;

	public void setDao(IRespuestaDao dao) {
		this.dao = dao;
	}

	public Respuesta add(Respuesta resp) {
		return dao.add(resp);
	}

	public Collection<Respuesta> getAll() {
		return dao.getAll();
	}

	public Respuesta getOne(int id) {
		return dao.getOne(id);
	}

	public void deleteById(int id) {
		dao.deleteById(id);
	}

	public Respuesta update(Respuesta resp) {
		return dao.update(resp);
	}
}
