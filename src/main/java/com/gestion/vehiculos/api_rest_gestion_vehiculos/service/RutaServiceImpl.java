package com.gestion.vehiculos.api_rest_gestion_vehiculos.service;

import com.gestion.vehiculos.api_rest_gestion_vehiculos.exception.ResourceNotFoundException;
import com.gestion.vehiculos.api_rest_gestion_vehiculos.model.Mantenimiento;
import com.gestion.vehiculos.api_rest_gestion_vehiculos.model.Ruta;
import com.gestion.vehiculos.api_rest_gestion_vehiculos.repository.RutaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class RutaServiceImpl implements RutaService{

    @Autowired
    private RutaRepository rutaRepository;

    @Override
    public List<Ruta> obtenerTodos() {

        return rutaRepository.findAll();
    }

    @Override
    public Optional<Ruta> rutaId(Long id_ruta) {

        return rutaRepository.findById(id_ruta);
    }

    @Override
    public Ruta guardar(Ruta ruta) {

        return rutaRepository.save(ruta);
    }

    @Override
    public void eliminar(Long id_ruta) {
        Ruta ruta = rutaId(id_ruta)
                .orElseThrow(() -> new ResourceNotFoundException("La ruta con ese ID no existe : " + id_ruta));
        rutaRepository.deleteById(id_ruta);
    }

    @Override
    public void actualizar(Ruta ruta) {

        rutaRepository.save(ruta);
    }
}
