package com.gestion.vehiculos.api_rest_gestion_vehiculos.service;

import com.gestion.vehiculos.api_rest_gestion_vehiculos.model.Vehiculo;

import java.util.List;
import java.util.Optional;

public interface VehiculoService {
    /*Listar todos vehiculos*/
    List<Vehiculo> obtenerTodos();
    /*Buscar vehiculo por id*/
    Optional<Vehiculo> vehiculoId(Long id_vehiculo);
    /*Guardar nuevo vehiculo*/
    Vehiculo guardar(Vehiculo vehiculo);
    /*eliminar vehiculo*/
    void eliminar(Long id_vehiculo);
    /*actualizar vehiculo*/
    void actualizar(Vehiculo vehi);
}
