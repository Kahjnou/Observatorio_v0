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
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

@Entity
@Table(name="preguntas")
@NamedQueries({
	@NamedQuery(name = "pregunta_getAll", query = "SELECT p FROM Pregunta AS p"),
})
public class Pregunta implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "id_prg")
	public int id;
	public int numero;
	public String texto;
	public int maxRespuestas;
	public boolean activado;
	
	// One to many Pregunta Categoria
	@ManyToOne
	@JoinColumn(name = "fk_cat", referencedColumnName = "id_cat")
	private Categoria categoria;
	
	// ManyToMany Pregunta Encuesta
	@ManyToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	@JoinTable(name="versiones", joinColumns=@JoinColumn(name="fk_e"), inverseJoinColumns = @JoinColumn(name="fk_prg"))
	private Collection<Encuesta> preguntaEncuestas;
	
	// ManyToMany Pregunta Respuesta
	@ManyToMany(mappedBy = "preguntaRespuestas", fetch = FetchType.LAZY)
	private Collection<Respuesta> respuestaPreguntas;
	
	public Pregunta() {
		super();
	}

	public Pregunta(int id, int numero, String texto, int maxRespuestas,
			boolean activado) {
		super();
		this.id = id;
		this.numero = numero;
		this.texto = texto;
		this.maxRespuestas = maxRespuestas;
		this.activado = activado;
	}

	public Pregunta(int numero, String texto, int maxRespuestas,
			boolean activado) {
		super();
		this.numero = numero;
		this.texto = texto;
		this.maxRespuestas = maxRespuestas;
		this.activado = activado;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getNumero() {
		return numero;
	}	

	public void setNumero(int numero) {
		this.numero = numero;
	}

	public String getTexto() {
		return texto;
	}

	public void setTexto(String texto) {
		this.texto = texto;
	}
	
	public int getMaxRespuestas() {
		return maxRespuestas;
	}

	public void setMaxRespuestas(int maxRespuestas) {
		this.maxRespuestas = maxRespuestas;
	}

	public boolean isActivado() {
		return activado;
	}

	public void setActivado(boolean activado) {
		this.activado = activado;
	}

	public Categoria getCategoria() {
		return categoria;
	}

	public void setCategoria(Categoria categoria) {
		this.categoria = categoria;
	}

	public Collection<Encuesta> getPreguntaEncuestas() {
		return preguntaEncuestas;
	}

	public void setPreguntaEncuestas(Collection<Encuesta> preguntaEncuestas) {
		this.preguntaEncuestas = preguntaEncuestas;
	}

	public Collection<Respuesta> getRespuestaPreguntas() {
		return respuestaPreguntas;
	}

	public void setRespuestaPreguntas(Collection<Respuesta> respuestaPreguntas) {
		this.respuestaPreguntas = respuestaPreguntas;
	}

	@Override
	public String toString() {
		return "Pregunta [id=" + id + ", numero=" + numero + ", texto=" + texto
				+ ", activado=" + activado + "]";
	}
	
}
