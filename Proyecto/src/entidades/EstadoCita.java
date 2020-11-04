package entidades;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the estado_cita database table.
 * 
 */
@Entity
@Table(name="estado_cita")
@NamedQuery(name="EstadoCita.findAll", query="SELECT e FROM EstadoCita e")
public class EstadoCita implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private int idestado;

	@Column(name="especialista_id_especialista")
	private int especialistaIdEspecialista;

	@Column(name="estado_cita")
	private String estadoCita;

	//bi-directional many-to-one association to Cita
	@OneToMany(mappedBy="estadoCita")
	private List<Cita> citas;

	public EstadoCita() {
	}

	public int getIdestado() {
		return this.idestado;
	}

	public void setIdestado(int idestado) {
		this.idestado = idestado;
	}

	public int getEspecialistaIdEspecialista() {
		return this.especialistaIdEspecialista;
	}

	public void setEspecialistaIdEspecialista(int especialistaIdEspecialista) {
		this.especialistaIdEspecialista = especialistaIdEspecialista;
	}

	public String getEstadoCita() {
		return this.estadoCita;
	}

	public void setEstadoCita(String estadoCita) {
		this.estadoCita = estadoCita;
	}

	public List<Cita> getCitas() {
		return this.citas;
	}

	public void setCitas(List<Cita> citas) {
		this.citas = citas;
	}

	public Cita addCita(Cita cita) {
		getCitas().add(cita);
		cita.setEstadoCita(this);

		return cita;
	}

	public Cita removeCita(Cita cita) {
		getCitas().remove(cita);
		cita.setEstadoCita(null);

		return cita;
	}

}