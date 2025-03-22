package com.gestion.vehiculos.api_rest_gestion_vehiculos.service;

import com.gestion.vehiculos.api_rest_gestion_vehiculos.exception.ResourceNotFoundException;
import com.gestion.vehiculos.api_rest_gestion_vehiculos.model.Vehiculo;
import com.gestion.vehiculos.api_rest_gestion_vehiculos.repository.VehiculoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class VehiculoServiceImpl implements VehiculoService{

    @Autowired
    private VehiculoRepository vehiculoRepository;

    @Override
    public List<Vehiculo> obtenerTodos() {
        return vehiculoRepository.findAll();
    }

    @Override
    public Optional<Vehiculo> vehiculoId(Long id_vehiculo) {
        return vehiculoRepository.findById(id_vehiculo);
    }

    @Override
    public Vehiculo guardar(Vehiculo vehiculo) {
        return vehiculoRepository.save(vehiculo);
    }

    @Override
    public void eliminar(Long id_vehiculo) {
        Vehiculo vehiculo = vehiculoId(id_vehiculo)
                .orElseThrow(() -> new ResourceNotFoundException("El vehiculo con ese ID no existe : " + id_vehiculo));
        vehiculoRepository.deleteById(id_vehiculo);
    }

    @Override
    public void actualizar(Vehiculo vehi) {
        vehiculoRepository.save(vehi);
    }
}
