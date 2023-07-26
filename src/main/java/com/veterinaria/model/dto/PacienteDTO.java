package com.veterinaria.model.dto;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

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
public class PacienteDTO implements Serializable {
	
	private static final long serialVersionUID = -4596572442024305568L;
	
	private long id;
	private String apellidoMaternoAmo;
	private String apellidoPaternoAmo;
	private Date fechaNacimiento;
	private String nombreAmo;
	private String nombrePaciente;
	private String telefono;
	private String tipoPaciente;
	private List<CitaMedicaDTO> citasMedicas;

}