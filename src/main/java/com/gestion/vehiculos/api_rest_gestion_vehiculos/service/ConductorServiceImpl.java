package com.gestion.vehiculos.api_rest_gestion_vehiculos.service;

import com.gestion.vehiculos.api_rest_gestion_vehiculos.exception.ResourceNotFoundException;
import com.gestion.vehiculos.api_rest_gestion_vehiculos.model.Conductor;
import com.gestion.vehiculos.api_rest_gestion_vehiculos.repository.ConductorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ConductorServiceImpl implements ConductorService{

    @Autowired
    private ConductorRepository conductorRepository;

    @Override
    public List<Conductor> obtenerTodos() {

        return conductorRepository.findAll();
    }

    @Override
    public Optional<Conductor> conductorId(Long id_conductor) {

        return conductorRepository.findById(id_conductor);
    }

    @Override
    public Conductor guardar(Conductor conductor) {

        return conductorRepository.save(conductor);
    }

    @Override
    public void eliminar(Long id_conductor) {
        Conductor conductor = conductorId(id_conductor)
                .orElseThrow(() -> new ResourceNotFoundException("El conductor con ese ID no existe : " + id_conductor));
        conductorRepository.deleteById(id_conductor);
    }

    @Override
    public void actualizar(Conductor con) {

        conductorRepository.save(con);
    }
}
