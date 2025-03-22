package com.gestion.vehiculos.api_rest_gestion_vehiculos.service;

import com.gestion.vehiculos.api_rest_gestion_vehiculos.model.Conductor;

import java.util.List;
import java.util.Optional;

public interface ConductorService {
    /*Listar todos los conductores*/
    List<Conductor> obtenerTodos();
    /*Buscar conductor por id*/
    Optional<Conductor> conductorId(Long id_conductor);
    /*Guardar nuevo conductor*/
    Conductor guardar(Conductor conductor);
    /*eliminar conductor*/
    void eliminar(Long id_conductor);
    /*actualizar conductor*/
    void actualizar(Conductor con);
}
