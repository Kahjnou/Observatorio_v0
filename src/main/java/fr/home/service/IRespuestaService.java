package fr.home.service;

import java.util.Collection;

import fr.home.model.Respuesta;

public interface IRespuestaService {

	public Respuesta add(Respuesta resp);
	public Collection<Respuesta> getAll();
	public Respuesta getOne(int id);
	public void deleteById(int id);
	public Respuesta update(Respuesta resp);
}
