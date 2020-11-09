package entidades;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the cita database table.
 * 
 */
@Entity
@NamedQuery(name="Cita.findAll", query="SELECT c FROM Cita c")
public class Cita implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="idcita")
	private int idcita;

	private String descripcion;

	@Column(name="medico_id_medico")
	private int medicoIdMedico;

	//bi-directional many-to-one association to EstadoCita
	@ManyToOne
	@JoinColumn(name="estado_cita_idcita")
	private EstadoCita estadoCita;

	//bi-directional many-to-one association to Persona
	@ManyToOne
	private Persona persona;

	//bi-directional many-to-one association to Usuario
	@ManyToOne
	private Usuario usuario;

	public Cita() {
	}

	public int getIdcita() {
		return this.idcita;
	}

	public void setIdcita(int idcita) {
		this.idcita = idcita;
	}

	public String getDescripcion() {
		return this.descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public int getMedicoIdMedico() {
		return this.medicoIdMedico;
	}

	public void setMedicoIdMedico(int medicoIdMedico) {
		this.medicoIdMedico = medicoIdMedico;
	}

	public EstadoCita getEstadoCita() {
		return this.estadoCita;
	}

	public void setEstadoCita(EstadoCita estadoCita) {
		this.estadoCita = estadoCita;
	}

	public Persona getPersona() {
		return this.persona;
	}

	public void setPersona(Persona persona) {
		this.persona = persona;
	}

	public Usuario getUsuario() {
		return this.usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

}