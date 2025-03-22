package com.gestion.vehiculos.api_rest_gestion_vehiculos.service;

import com.gestion.vehiculos.api_rest_gestion_vehiculos.model.Mantenimiento;
import com.gestion.vehiculos.api_rest_gestion_vehiculos.model.Ruta;

import java.util.List;
import java.util.Optional;

public interface RutaService {
    /*Listar todos las rutas*/
    List<Ruta> obtenerTodos();
    /*Buscar ruta por id*/
    Optional<Ruta> rutaId(Long id_ruta);
    /*Guardar nueva ruta*/
    Ruta guardar(Ruta ruta);
    /*eliminar ruta*/
    void eliminar(Long id_ruta);
    /*actualizar ruta*/
    void actualizar(Ruta ruta);
}
