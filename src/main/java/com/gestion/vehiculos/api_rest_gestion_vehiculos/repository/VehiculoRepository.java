package com.gestion.vehiculos.api_rest_gestion_vehiculos.repository;

import com.gestion.vehiculos.api_rest_gestion_vehiculos.model.Vehiculo;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface VehiculoRepository extends JpaRepository<Vehiculo, Long> {
}
