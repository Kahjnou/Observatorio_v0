package fr.home.model;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name="sesiones_encuesta")
@NamedQueries({
	@NamedQuery(
			name = "sesion_getAll",
			query = "SELECT s FROM SesionEncuesta AS s"),
})
public class SesionEncuesta implements Serializable  {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "id_ses")
	private int id;
	private int numero;
	private String autor;
	@Temporal(TemporalType.TIMESTAMP)
	private Date fecha;
	private boolean activada;
	
	// ManyToOne SesionEncuesta Pregunta for join table
	@ManyToOne
	@JoinColumn(name="fk_prg", referencedColumnName = "id_prg")
	private Pregunta pregunta;
	
	// ManyToOne SesionEncuesta Respuesta for join table
	@ManyToOne
	@JoinColumn(name="fk_resp", referencedColumnName = "id_resp")
	private Respuesta respuesta;
	
	public SesionEncuesta() {
		super();
	}

	public SesionEncuesta(int id, int numero, String autor, Date fecha,
			boolean activada) {
		super();
		this.id = id;
		this.numero = numero;
		this.autor = autor;
		this.fecha = fecha;
		this.activada = activada;
	}

	public SesionEncuesta(int numero, String autor, Date fecha) {
		super();
		this.numero = numero;
		this.autor = autor;
		this.fecha = fecha;
		this.activada = false;
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

	public String getAutor() {
		return autor;
	}

	public void setAutor(String autor) {
		this.autor = autor;
	}

	public Date getFecha() {
		return fecha;
	}

	public void setFecha(Date fecha) {
		this.fecha = fecha;
	}

	public boolean isActivada() {
		return activada;
	}

	public void setActivada(boolean activada) {
		this.activada = activada;
	}

	public Pregunta getPregunta() {
		return pregunta;
	}

	public void setPregunta(Pregunta pregunta) {
		this.pregunta = pregunta;
	}

	public Respuesta getRespuesta() {
		return respuesta;
	}

	public void setRespuesta(Respuesta respuesta) {
		this.respuesta = respuesta;
	}

	@Override
	public String toString() {
		return "SesionEncuesta [id=" + id + ", numero=" + numero + ", autor="
				+ autor + ", fecha=" + fecha + ", activada=" + activada + "]";
	}
}
