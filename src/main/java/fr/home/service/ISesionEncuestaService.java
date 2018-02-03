package fr.home.service;

import java.util.Collection;

import fr.home.model.SesionEncuesta;

public interface ISesionEncuestaService {

	public SesionEncuesta add(SesionEncuesta se);
	public Collection<SesionEncuesta> getAll();
	public SesionEncuesta getOne(int id);
	public void deleteById(int id);
	public SesionEncuesta update(SesionEncuesta se);
}
