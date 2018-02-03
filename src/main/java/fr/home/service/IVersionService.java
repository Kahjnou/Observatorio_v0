package fr.home.service;

import java.util.Collection;

import fr.home.model.Version;

public interface IVersionService {

	public Version add(Version vers);
	public Collection<Version> getAll();
	public Version getOne(int id);
	public void deleteById(int id);
	public Version update(Version vers);
}
