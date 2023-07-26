package com.veterinaria.model.entity;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

@Entity
@Table(name="pacientes")
@Data
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(callSuper = false)
@SuperBuilder
public class PacienteEntity implements Serializable {/**
	 * 
	 */
	private static final long serialVersionUID = -3226647583556489334L;

	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private long id;

	@Column(name="apellido_materno_amo")
	private String apellidoMaternoAmo;

	@Column(name="apellido_paterno_amo")
	private String apellidoPaternoAmo;

	@Temporal(TemporalType.DATE)
	@Column(name="fecha_nacimiento")
	private Date fechaNacimiento;

	@Column(name="nombre_amo")
	private String nombreAmo;

	@Column(name="nombre_paciente")
	private String nombrePaciente;

	private String telefono;

	@Column(name="tipo_paciente")
	private String tipoPaciente;

	//bi-directional many-to-one association to CitasMedica
	@JsonIgnore
	@OneToMany(mappedBy="paciente")
	private List<CitaMedicaEntity> citasMedicas;

}
