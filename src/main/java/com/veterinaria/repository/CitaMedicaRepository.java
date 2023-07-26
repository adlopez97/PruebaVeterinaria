package com.veterinaria.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.veterinaria.model.entity.CitaMedicaEntity;

public interface CitaMedicaRepository extends JpaRepository <CitaMedicaEntity,Integer> {

}
