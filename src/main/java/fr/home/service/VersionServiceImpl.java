package fr.home.service;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import fr.home.dao.IVersionDao;
import fr.home.model.Version;

@Service
@Transactional
public class VersionServiceImpl implements IVersionService {

	private IVersionDao dao;

	public void setDao(IVersionDao dao) {
		this.dao = dao;
	}

	public Version add(Version vers) {
		return dao.add(vers);
	}

	public Collection<Version> getAll() {
		return dao.getAll();
	}

	public Version getOne(int id) {
		return dao.getOne(id);
	}

	public void deleteById(int id) {
		dao.deleteById(id);		
	}

	public Version update(Version vers) {
		return dao.update(vers);
	}
	
}
