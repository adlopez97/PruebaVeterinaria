package com.veterinaria.service.impl;

import java.util.List;
import java.util.Objects;
import java.util.UUID;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import com.veterinaria.model.dto.CitaMedicaDTO;
import com.veterinaria.model.dto.PacienteDTO;
import com.veterinaria.model.dto.VeterinarioDTO;
import com.veterinaria.model.entity.CitaMedicaEntity;
import com.veterinaria.model.response.ErrorResponse;
import com.veterinaria.model.response.Response;
import com.veterinaria.model.response.SuccessResult;
import com.veterinaria.repository.CitaMedicaRepository;
import com.veterinaria.service.CitasMedicaService;
import com.veterinaria.service.PacienteService;
import com.veterinaria.service.VeterinarioService;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class CitasMedicaServiceImpl implements CitasMedicaService {
	
	private final CitaMedicaRepository citaMedicaRepository;
	private final PacienteService pacienteService;
	private final VeterinarioService veterinarioService;
	
	private static final ModelMapper modelMapper = new ModelMapper();
	
	@Override
	public Response agregarCitaMedica(CitaMedicaDTO citaMed) {
		String idTransaccion = UUID.randomUUID().toString();
		try {
			SuccessResult<PacienteDTO> pacienteResult = (SuccessResult<PacienteDTO>) pacienteService.agregarPaciente(modelMapper.map(citaMed.getPaciente(), PacienteDTO.class));
			SuccessResult<VeterinarioDTO> veterinarioResult = (SuccessResult<VeterinarioDTO>) veterinarioService.agregarVeterinario(modelMapper.map(citaMed.getVeterinario(), VeterinarioDTO.class));
			citaMed.setPaciente(pacienteResult.getResult());
			citaMed.setVeterinario(veterinarioResult.getResult());
			
			CitaMedicaEntity citaMedCreada = citaMedicaRepository.save(modelMapper.map(citaMed, CitaMedicaEntity.class));
			if(!Objects.equals(null, citaMedCreada)) {
				return SuccessResult.builder()
						.idTransaccion(idTransaccion)
						.mensaje("Operacion Exitosa")
						.result(modelMapper.map(citaMedCreada, CitaMedicaDTO.class))
						.build();
			}
			else {
				return ErrorResponse.builder()
						.idTransaccion(idTransaccion)
						.mensaje("Operacion no exitosa")
						.descripcion("Error en el alta de la cita medica")
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
	public Response recuperarCitasMedicas() {
		List<CitaMedicaEntity> cit = citaMedicaRepository.findAll();
		String idTransaccion = UUID.randomUUID().toString();
		if(!cit.isEmpty() && !Objects.equals(null, cit)) {
			return SuccessResult.builder()
					.idTransaccion(idTransaccion)
					.mensaje("Operacion Exitosa")
					.result(modelMapper.map(cit, List.class))
					.build();
		}
		else {
			return null;
		}
	}

}
