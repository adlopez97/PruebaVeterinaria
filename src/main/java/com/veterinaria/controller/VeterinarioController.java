package com.veterinaria.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.veterinaria.model.dto.VeterinarioDTO;
import com.veterinaria.model.response.Response;
import com.veterinaria.service.VeterinarioService;

import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor
public class VeterinarioController {
	

	private final VeterinarioService veterinarioService;
	
	@GetMapping(value="/veterinarios",produces=MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Response> recuperarVeterinarios() {
		return new ResponseEntity<Response>(veterinarioService.recuperarVeterinarios(), HttpStatus.OK);
	}
	
	@PostMapping(value="/veterinario",consumes=MediaType.APPLICATION_JSON_VALUE,produces=MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Response> guardarVeterinario(@RequestBody VeterinarioDTO vet) {		
		return new ResponseEntity<Response>(veterinarioService.agregarVeterinario(vet),  HttpStatus.CREATED);
	}

}
