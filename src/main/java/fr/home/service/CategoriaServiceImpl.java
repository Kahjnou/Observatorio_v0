package fr.home.service;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import fr.home.dao.ICategoriaDao;
import fr.home.model.Categoria;

@Service
@Transactional
public class CategoriaServiceImpl implements ICategoriaService {

	private ICategoriaDao dao;

	public void setDao(ICategoriaDao dao) {
		this.dao = dao;
	}

	public Categoria add(Categoria cat) {
		System.out.println("dao: " + dao);
		System.out.println("To add: " + cat);
		return dao.add(cat);
	}

	public Collection<Categoria> getAll() {
		return dao.getAll();
	}

	public Categoria getOne(int id) {
		return dao.getOne(id);
	}

	public void deleteById(int id) {
		dao.deleteById(id);
	}

	public Categoria update(Categoria cat) {
		return dao.update(cat);
	}
}
