package com.veterinaria.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.veterinaria.model.dto.PacienteDTO;
import com.veterinaria.model.response.Response;
import com.veterinaria.service.PacienteService;

import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor
public class PacienteController {
	
	private final PacienteService pacienteService;
	
	@GetMapping(value="/pacientes",produces=MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Response> recuperarPacientes() {
		return new ResponseEntity<Response>(pacienteService.recuperarPacientes(), HttpStatus.OK);
	}
	
	@PostMapping(value="/paciente",consumes=MediaType.APPLICATION_JSON_VALUE,produces=MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Response> guardarPaciente(@RequestBody PacienteDTO pac) {		
		return new ResponseEntity<Response>(pacienteService.agregarPaciente(pac),  HttpStatus.CREATED);
	}

}