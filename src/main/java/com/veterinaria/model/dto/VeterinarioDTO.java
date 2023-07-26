package com.veterinaria.model.dto;

import java.io.Serializable;
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
public class VeterinarioDTO implements Serializable {

	private static final long serialVersionUID = -5154714322914893481L;

	private long id;
	private String cedulaProfesional;
	private String apellidoPaterno;
	private String apellidoMaterno;
	private String nombre;
	private List<CitaMedicaDTO> citasMedicas;
	
}