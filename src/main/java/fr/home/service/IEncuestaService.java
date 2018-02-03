package fr.home.service;

import java.util.Collection;

import fr.home.model.Encuesta;

public interface IEncuestaService {
	
	public Encuesta add(Encuesta enc);
	public Collection<Encuesta> getAll();
	public Encuesta getOne(int id);
	public void deleteById(int id);
	public Encuesta update(Encuesta enc);
}
