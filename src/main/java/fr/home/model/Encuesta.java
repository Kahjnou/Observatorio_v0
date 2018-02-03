package fr.home.model;

import java.io.Serializable;
import java.util.Collection;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

@Entity
@Table(name="encuestas")
@NamedQueries({
	@NamedQuery(
			name = "encuesta_getall",
			query ="SELECT e FROM Encuesta AS e"),
})
public class Encuesta implements Serializable  {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "id_e")
	private int id;
	private String identificacion;
	private String numero;
	private boolean modelo;
	
	// Many to Many Encuesta Pregunta
	@ManyToMany(mappedBy = "preguntaEncuestas", fetch = FetchType.LAZY)
	private Collection<Pregunta> encuestaPreguntas;
	
	public Encuesta() {
		super();
	}

	public Encuesta(int id, String identificacion, String numero, boolean modelo) {
		super();
		this.id = id;
		this.identificacion = identificacion;
		this.numero = numero;
		this.modelo = modelo;
	}
	

	public Encuesta(String identificacion, String numero, boolean modelo) {
		super();
		this.identificacion = identificacion;
		this.numero = numero;
		this.modelo = modelo;
	}



	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getIdentificacion() {
		return identificacion;
	}

	public void setIdentificacion(String identificacion) {
		this.identificacion = identificacion;
	}

	public String getNumero() {
		return numero;
	}

	public void setNumero(String numero) {
		this.numero = numero;
	}

	public boolean isModelo() {
		return modelo;
	}

	public void setModelo(boolean modelo) {
		this.modelo = modelo;
	}

	public Collection<Pregunta> getEncuestaPreguntas() {
		return encuestaPreguntas;
	}

	public void setEncuestaPreguntas(Collection<Pregunta> encuestaPreguntas) {
		this.encuestaPreguntas = encuestaPreguntas;
	}

	@Override
	public String toString() {
		return "Encuesta [id=" + id + ", identificacion=" + identificacion
				+ ", numero=" + numero + ", modelo=" + modelo +"]";
	}
	
}
