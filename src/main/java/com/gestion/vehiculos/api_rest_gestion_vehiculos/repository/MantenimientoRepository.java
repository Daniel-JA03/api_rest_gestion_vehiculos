package com.gestion.vehiculos.api_rest_gestion_vehiculos.repository;

import com.gestion.vehiculos.api_rest_gestion_vehiculos.model.Mantenimiento;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MantenimientoRepository extends JpaRepository<Mantenimiento, Long> {
}
