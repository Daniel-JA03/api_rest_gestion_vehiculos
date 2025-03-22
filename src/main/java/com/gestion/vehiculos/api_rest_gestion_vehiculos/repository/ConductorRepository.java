package com.gestion.vehiculos.api_rest_gestion_vehiculos.repository;

import com.gestion.vehiculos.api_rest_gestion_vehiculos.model.Conductor;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ConductorRepository extends JpaRepository<Conductor, Long> {
}
