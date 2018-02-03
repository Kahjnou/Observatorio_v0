package fr.home.rest;

import java.util.List;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import fr.home.model.Categoria;
import fr.home.service.ICategoriaService;

@Path("/ws")
@Component
public class CategoriaRest {

	@Autowired
	private ICategoriaService categoriaService;

	public void setCategoriaService(ICategoriaService categoriaService) {
		this.categoriaService = categoriaService;
	}
	
	@GET
	@Path("/categorias")
	@Produces(MediaType.APPLICATION_JSON)
	public List<Categoria> getAllCategorias() {
		return (List<Categoria>) categoriaService.getAll();
	}
	
}
