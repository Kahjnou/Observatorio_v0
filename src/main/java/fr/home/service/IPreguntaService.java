package fr.home.service;

import java.util.Collection;

import fr.home.model.Pregunta;

public interface IPreguntaService {

	public Pregunta add(Pregunta enc);
	public Collection<Pregunta> getAll();
	public Pregunta getOne(int id);
	public void deleteById(int id);
	public Pregunta update(Pregunta enc);
}
