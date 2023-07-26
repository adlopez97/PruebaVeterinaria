package com.veterinaria.service;

import com.veterinaria.model.dto.PacienteDTO;
import com.veterinaria.model.response.Response;

public interface PacienteService {
	
	public Response recuperarPacientes();
	public Response agregarPaciente(PacienteDTO pac);

}
