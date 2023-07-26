package com.veterinaria.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.veterinaria.model.entity.VeterinarioEntity;

public interface VeterinarioRepository extends JpaRepository <VeterinarioEntity,Integer>{

}
