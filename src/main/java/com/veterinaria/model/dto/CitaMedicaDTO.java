package com.veterinaria.model.dto;

import java.io.Serializable;
import java.util.Date;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

@Data
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(callSuper = false)
@SuperBuilder
public class CitaMedicaDTO implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 4133999078895026954L;
	
	private long id;
	private String fechaHora;
	private String nombreAmo;
	private PacienteDTO paciente;
	private VeterinarioDTO veterinario;

}