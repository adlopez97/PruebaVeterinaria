package com.veterinaria.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.veterinaria.model.dto.CitaMedicaDTO;
import com.veterinaria.model.response.Response;
import com.veterinaria.service.CitasMedicaService;

import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor
public class CitasMedicaController {

	private final CitasMedicaService citasMedicasService;
	
	@GetMapping(value="/citasmedicas",produces=MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Response> recuperarCitasMedicas() {
		return new ResponseEntity<Response>(citasMedicasService.recuperarCitasMedicas(), HttpStatus.OK);
	}
	
	@PostMapping(value="/citamedica",consumes=MediaType.APPLICATION_JSON_VALUE,produces=MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Response> guardarCitaMedica(@RequestBody CitaMedicaDTO citamed) {		
		return new ResponseEntity<Response>(citasMedicasService.agregarCitaMedica(citamed),  HttpStatus.CREATED);
	}


}
