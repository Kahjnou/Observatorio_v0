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
@Table(name="versiones")
@NamedQueries({
	@NamedQuery(
			name = "version_getAll",
			query = "SELECT v FROM Version AS v"),
})
public class Version implements Serializable  {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "id_v")
	private int id;
	private String autor;
	@Temporal(TemporalType.DATE)
	private Date fecha;
	private String identificacion;
	
	// ManyTone encuesta version for join table
	@ManyToOne
	@JoinColumn(name="fk_e", referencedColumnName = "id_e")
	private Encuesta encuesta;
	
	// ManyToOne encuesta pregunta for join table
	@ManyToOne
	@JoinColumn(name="fk_prg", referencedColumnName = "id_prg")
	private Pregunta pregunta;
	
	public Version() {
		super();
	}

	public Version(int id, String autor, Date fecha, String identificacion) {
		super();
		this.id = id;
		this.autor = autor;
		this.fecha = fecha;
		this.identificacion = identificacion;
	}

	public Version(String autor, Date fecha, String identificacion) {
		super();
		this.autor = autor;
		this.fecha = fecha;
		this.identificacion = identificacion;
	}

	public Version(String autor) {
		super();
		this.autor = autor;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
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

	public String getIdentificacion() {
		return identificacion;
	}

	public void setIdentificacion(String identificacion) {
		this.identificacion = identificacion;
	}

	@Override
	public String toString() {
		return "Version [id=" + id + ", autor=" + autor + ", fecha=" + fecha
				+ "identificacion=" + identificacion + "]";
	}

	public Encuesta getEncuesta() {
		return encuesta;
	}

	public void setEncuesta(Encuesta encuesta) {
		this.encuesta = encuesta;
	}

	public Pregunta getPregunta() {
		return pregunta;
	}

	public void setPregunta(Pregunta pregunta) {
		this.pregunta = pregunta;
	}
	
}
