package com.veterinaria.service.impl;

import java.util.List;
import java.util.Objects;
import java.util.UUID;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import com.veterinaria.model.dto.PacienteDTO;
import com.veterinaria.model.entity.PacienteEntity;
import com.veterinaria.model.response.ErrorResponse;
import com.veterinaria.model.response.Response;
import com.veterinaria.model.response.SuccessResult;
import com.veterinaria.repository.PacienteRepository;
import com.veterinaria.service.PacienteService;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class PacienteServiceImpl implements PacienteService {

//	@Autowired
//	private final VeterinariaDao dao;
	private final PacienteRepository pacienteRepository;
	
	private static final ModelMapper modelMapper = new ModelMapper();
	
	@Override
	public Response agregarPaciente(PacienteDTO pac) {
		String idTransaccion = UUID.randomUUID().toString();
		try {
			PacienteEntity paccreado = pacienteRepository.save(modelMapper.map(pac, PacienteEntity.class));
			if(!Objects.equals(null, paccreado)) {
				return SuccessResult.builder()
						.idTransaccion(idTransaccion)
						.mensaje("Operacion Exitosa")
						.result(modelMapper.map(paccreado, PacienteDTO.class))
						.build();
			}
			else {
				return ErrorResponse.builder()
						.idTransaccion(idTransaccion)
						.mensaje("Operacion no exitosa")
						.descripcion("Error en el alta del paciente")
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
	public Response recuperarPacientes() {
		List<PacienteEntity> pac = pacienteRepository.findAll();
		String idTransaccion = UUID.randomUUID().toString();
		if(!pac.isEmpty() && !Objects.equals(null, pac)) {
			return SuccessResult.builder()
					.idTransaccion(idTransaccion)
					.mensaje("Operacion Exitosa")
					.result(modelMapper.map(pac, List.class))
					.build();
		}
		else {
			return null;
		}
	}

}
