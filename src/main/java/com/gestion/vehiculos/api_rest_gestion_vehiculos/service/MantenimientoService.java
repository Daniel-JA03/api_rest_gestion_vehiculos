package com.gestion.vehiculos.api_rest_gestion_vehiculos.service;

import com.gestion.vehiculos.api_rest_gestion_vehiculos.model.Mantenimiento;

import java.util.List;
import java.util.Optional;

public interface MantenimientoService {
    /*Listar todos los mantenimientos*/
    List<Mantenimiento> obtenerTodos();
    /*Buscar mantenimiento por id*/
    Optional<Mantenimiento> mantenimientoId(Long id_mantenimiento);
    /*Guardar nuevo mantenimiento*/
    Mantenimiento guardar(Mantenimiento mantenimiento);
    /*eliminar mantenimiento*/
    void eliminar(Long id_mantenimiento);
    /*actualizar mantenimiento*/
    void actualizar(Mantenimiento man);
}
