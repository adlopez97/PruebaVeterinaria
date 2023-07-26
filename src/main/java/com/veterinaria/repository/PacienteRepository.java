package com.veterinaria.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.veterinaria.model.entity.PacienteEntity;

public interface PacienteRepository extends JpaRepository <PacienteEntity,Integer>{

}
