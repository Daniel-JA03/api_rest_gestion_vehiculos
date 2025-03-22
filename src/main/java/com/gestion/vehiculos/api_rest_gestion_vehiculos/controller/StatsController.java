package com.gestion.vehiculos.api_rest_gestion_vehiculos.controller;

import com.gestion.vehiculos.api_rest_gestion_vehiculos.repository.ConductorRepository;
import com.gestion.vehiculos.api_rest_gestion_vehiculos.repository.MantenimientoRepository;
import com.gestion.vehiculos.api_rest_gestion_vehiculos.repository.RutaRepository;
import com.gestion.vehiculos.api_rest_gestion_vehiculos.repository.VehiculoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@CrossOrigin(origins = "http://localhost:5173/")
@RestController
@RequestMapping("/api/v1")
public class StatsController {

    @Autowired
    private VehiculoRepository vehiculoRepository;

    @Autowired
    private MantenimientoRepository mantenimientoRepository;

    @Autowired
    private ConductorRepository conductorRepository;

    @Autowired
    private RutaRepository rutaRepository;

    @GetMapping("/stats") // Ruta : http://localhost:8080/api/v1/stats
    public Map<String, Long> getStats() {
        Map<String, Long> stats = new HashMap<>();
        stats.put("totalVehiculos", vehiculoRepository.count());
        stats.put("totalMantenimientos", mantenimientoRepository.count());
        stats.put("totalConductores", conductorRepository.count());
        stats.put("totalRutas", rutaRepository.count());
        return stats;
    }
}
