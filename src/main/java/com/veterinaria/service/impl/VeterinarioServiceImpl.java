package com.veterinaria.service.impl;

import java.util.List;
import java.util.Objects;
import java.util.UUID;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import com.veterinaria.model.dto.VeterinarioDTO;
import com.veterinaria.model.entity.VeterinarioEntity;
import com.veterinaria.model.response.ErrorResponse;
import com.veterinaria.model.response.Response;
import com.veterinaria.model.response.SuccessResult;
import com.veterinaria.repository.VeterinarioRepository;
import com.veterinaria.service.VeterinarioService;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class VeterinarioServiceImpl implements VeterinarioService {

//	@Autowired
//	private final VeterinariaDao dao;
	private final VeterinarioRepository veterinarioRepository;
	
	private static final ModelMapper modelMapper = new ModelMapper();
	
	@Override
	public Response agregarVeterinario(VeterinarioDTO vet) {
		String idTransaccion = UUID.randomUUID().toString();
		try {
			VeterinarioEntity vetcreado = veterinarioRepository.save(modelMapper.map(vet, VeterinarioEntity.class));
			if(!Objects.equals(null, vetcreado)) {
				return SuccessResult.builder()
						.idTransaccion(idTransaccion)
						.mensaje("Operacion Exitosa")
						.result(modelMapper.map(vetcreado, VeterinarioDTO.class))
						.build();
			}
			else {
				return ErrorResponse.builder()
						.idTransaccion(idTransaccion)
						.mensaje("Operacion no exitosa")
						.descripcion("Error en el alta del veterinario")
						.build();
			}
		}
		catch(Exception e) {
			return ErrorResponse.builder()
					.idTransaccion(idTransaccion)
					.mensaje("Operacion no exitosa")
					.descripcion(e.getCause().toString())
					.build();
		}
		
		
	}
	
	@Override
	public Response recuperarVeterinarios() {
		List<VeterinarioEntity> vet = veterinarioRepository.findAll();
		String idTransaccion = UUID.randomUUID().toString();
		if(!vet.isEmpty() && !Objects.equals(null, vet)) {
			return SuccessResult.builder()
					.idTransaccion(idTransaccion)
					.mensaje("Operacion Exitosa")
					.result(modelMapper.map(vet, List.class))
					.build();
		}
		else {
			return null;
		}
	}

}
