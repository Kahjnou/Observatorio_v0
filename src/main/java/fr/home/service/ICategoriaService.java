package fr.home.service;

import java.util.Collection;

import fr.home.model.Categoria;

public interface ICategoriaService {

	public Categoria add(Categoria cat);
	public Collection<Categoria> getAll();
	public Categoria getOne(int id);
	public void deleteById(int id);
	public Categoria update(Categoria cat);
}
