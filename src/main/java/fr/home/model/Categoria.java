package fr.home.model;

import java.io.Serializable;
import java.util.Collection;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;


@Entity
@Table(name="categorias")
@NamedQueries({
	@NamedQuery(
			name = "categoria_getAll",
			query = "SELECT c FROM Categoria AS c"
			),
})
public class Categoria implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "id_cat")
	private int id;
	private String titulo;
	private double coeficiente;
	
	// Many to one Categoria Pregunta
	@OneToMany(mappedBy="categoria", cascade = CascadeType.ALL)
	private Collection<Pregunta> preguntas;
	
	public Categoria() {
		super();
	}

	public Categoria(int id, String titulo, double coeficiente) {
		super();
		this.id = id;
		this.titulo = titulo;
		this.coeficiente = coeficiente;
	}

	public Categoria(String titulo, double coeficiente) {
		super();
		this.titulo = titulo;
		this.coeficiente = coeficiente;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public double getCoeficiente() {
		return coeficiente;
	}

	public void setCoeficiente(double coeficiente) {
		this.coeficiente = coeficiente;
	}

	public Collection<Pregunta> getPreguntas() {
		return preguntas;
	}

	public void setPreguntas(Collection<Pregunta> preguntas) {
		this.preguntas = preguntas;
	}

	@Override
	public String toString() {
		return "Categoria [id=" + id + ", titulo=" + titulo + ", coeficiente="
				+ coeficiente + "]";
	}

}
