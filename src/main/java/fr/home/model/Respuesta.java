package fr.home.model;

import java.io.Serializable;
import java.util.Collection;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

@Entity
@Table(name="respuestas")
@NamedQueries({
	@NamedQuery(name="respuesta_getAll", query = "SELECT r FROM Respuesta AS r"),
})
public class Respuesta implements Serializable  {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "id_resp")
	private int id;
	private String texto;
	private int orden;
	private int punto;
	private char codigo;
	
	// ManyToMany Respuesta Pregunta
	@ManyToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	@JoinTable(name="sesiones_encuesta", joinColumns = @JoinColumn(name="fk_prg"), inverseJoinColumns = @JoinColumn(name="fk_resp"))
	private Collection<Pregunta> preguntaRespuestas;
	
	public Respuesta() {
		super();
	}

	public Respuesta(int id, String texto, int orden, int punto, char codigo) {
		super();
		this.id = id;
		this.texto = texto;
		this.orden = orden;
		this.punto = punto;
		this.codigo = codigo;
	}

	public Respuesta(String texto, int orden, int punto, char codigo) {
		super();
		this.texto = texto;
		this.orden = orden;
		this.punto = punto;
		this.codigo = codigo;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getTexto() {
		return texto;
	}

	public void setTexto(String texto) {
		this.texto = texto;
	}

	public int getOrden() {
		return orden;
	}

	public void setOrden(int orden) {
		this.orden = orden;
	}

	public int getPunto() {
		return punto;
	}

	public void setPunto(int punto) {
		this.punto = punto;
	}

	public char getCodigo() {
		return codigo;
	}

	public void setCodigo(char codigo) {
		this.codigo = codigo;
	}

	public Collection<Pregunta> getPreguntaRespuestas() {
		return preguntaRespuestas;
	}

	public void setPreguntaRespuestas(Collection<Pregunta> preguntaRespuestas) {
		this.preguntaRespuestas = preguntaRespuestas;
	}

	@Override
	public String toString() {
		return "Respuesta [id=" + id + ", texto=" + texto + ", orden=" + orden
				+ ", punto=" + punto + ", codigo=" + codigo + "]";
	}
}
