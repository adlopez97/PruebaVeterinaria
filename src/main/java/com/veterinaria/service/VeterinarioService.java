package com.veterinaria.service;

import com.veterinaria.model.dto.VeterinarioDTO;
import com.veterinaria.model.response.Response;

public interface VeterinarioService {

	public Response recuperarVeterinarios();
	public Response agregarVeterinario(VeterinarioDTO vet);


}
