package com.veterinaria.model.entity;

import java.io.Serializable;
import java.util.Date;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

@Entity
@Table(name="citas_medicas")
@Data
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(callSuper = false)
@SuperBuilder
public class CitaMedicaEntity implements Serializable {/**
	 * 
	 */
	private static final long serialVersionUID = 3209160511387911677L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY) //este campo se genera automaticamente
	private long id;

	@Temporal(TemporalType.DATE)
	@Column(name = "fecha_hora")
	@JsonFormat(pattern="yyyy-MM-dd HH:mm:ss")
	private String fechaHora;

	@Column(name = "nombre_propietario")
	private String nombreAmo;

	// bi-directional many-to-one association to Paciente
	@JsonIgnore
	@ManyToOne
	@JoinColumn(name = "id_paciente")
	private PacienteEntity paciente;

	// bi-directional many-to-one association to Veterinario
	@JsonIgnore
	@ManyToOne
	@JoinColumn(name = "id_veterinario")
	private VeterinarioEntity veterinario;

}
