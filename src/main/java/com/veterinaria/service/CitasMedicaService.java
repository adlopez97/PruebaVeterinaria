package com.veterinaria.service;

import com.veterinaria.model.dto.CitaMedicaDTO;
import com.veterinaria.model.response.Response;

public interface CitasMedicaService {
	
	public Response recuperarCitasMedicas();
	public Response agregarCitaMedica(CitaMedicaDTO citamed);

}
