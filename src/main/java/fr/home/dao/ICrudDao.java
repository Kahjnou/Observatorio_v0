package fr.home.dao;

import java.util.Collection;

public interface ICrudDao<T> {

	public T add(T t);
	public Collection<T> getAll();
	public T getOne(int id);
	public void deleteById(int id);
	public T update(T t);
}
