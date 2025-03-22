package com.gestion.vehiculos.api_rest_gestion_vehiculos.service;

import com.gestion.vehiculos.api_rest_gestion_vehiculos.exception.ResourceNotFoundException;
import com.gestion.vehiculos.api_rest_gestion_vehiculos.model.Conductor;
import com.gestion.vehiculos.api_rest_gestion_vehiculos.model.Mantenimiento;
import com.gestion.vehiculos.api_rest_gestion_vehiculos.model.Vehiculo;
import com.gestion.vehiculos.api_rest_gestion_vehiculos.repository.MantenimientoRepository;
import com.gestion.vehiculos.api_rest_gestion_vehiculos.repository.VehiculoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Service
public class MantenimientoServiceImpl implements  MantenimientoService{

    @Autowired
    private MantenimientoRepository mantenimientoRepository;

    @Override
    public List<Mantenimiento> obtenerTodos() {
       return mantenimientoRepository.findAll();
    }

    @Override
    public Optional<Mantenimiento> mantenimientoId(Long id_mantenimiento) {
        return mantenimientoRepository.findById(id_mantenimiento);
    }

    @Override
    public Mantenimiento guardar(Mantenimiento mantenimiento) {
        return mantenimientoRepository.save(mantenimiento);
    }

    @Override
    public void eliminar(Long id_mantenimiento) {
        Mantenimiento mantenimiento = mantenimientoId(id_mantenimiento)
                .orElseThrow(() -> new ResourceNotFoundException("El mantenimiento con ese ID no existe : " + id_mantenimiento));
        mantenimientoRepository.deleteById(id_mantenimiento);
    }

    @Override
    public void actualizar(Mantenimiento man) {
        mantenimientoRepository.save(man);
    }
}
