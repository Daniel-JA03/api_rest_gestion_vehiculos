package com.gestion.vehiculos.api_rest_gestion_vehiculos.controller;

import com.gestion.vehiculos.api_rest_gestion_vehiculos.exception.ResourceNotFoundException;
import com.gestion.vehiculos.api_rest_gestion_vehiculos.model.Conductor;
import com.gestion.vehiculos.api_rest_gestion_vehiculos.service.ConductorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@CrossOrigin(origins = "http://localhost:5173/")
@RestController
@RequestMapping("/api/v1")
public class ConductorController {

    @Autowired
    private ConductorService conductorService;

    @GetMapping("/conductores") // Ruta : http://localhost:8080/api/v1/conductores
    public List<Conductor> listarConductores() {
        return conductorService.obtenerTodos();
    }

    @PostMapping("/conductores") // Ruta : http://localhost:8080/api/v1/conductores
    public Conductor guardarConductor(@RequestBody Conductor conductor) {
        return conductorService.guardar(conductor);
    }

    @GetMapping("/conductores/{id_conductor}") // Ruta : http://localhost:8080/api/v1/conductores/1
    public ResponseEntity<Conductor> listarConductorPoId(@PathVariable Long id_conductor) {
        Conductor conductor = conductorService.conductorId(id_conductor)
                .orElseThrow(() -> new ResourceNotFoundException("El conductor con ese ID no existe : " + id_conductor));
        return ResponseEntity.ok(conductor);
    }

    @PutMapping("/conductores/{id_conductor}") // Ruta : http://localhost:8080/api/v1/conductores/1
    public ResponseEntity<Conductor> actualizarConductor(@PathVariable Long id_conductor, @RequestBody Conductor conductorRequest) {
        Conductor conductor = conductorService.conductorId(id_conductor)
                .orElseThrow(() -> new ResourceNotFoundException("El conductor con ese ID no existe : " + id_conductor));
        conductor.setNombre(conductorRequest.getNombre());
        conductor.setLicencia(conductorRequest.getLicencia());
        conductor.setTelefono(conductorRequest.getTelefono());
        conductor.setEmail(conductorRequest.getEmail());

        Conductor conductorActualizado = conductorService.guardar(conductor);
        return ResponseEntity.ok(conductorActualizado);
    }

    @DeleteMapping("/conductores/{id_conductor}") // Ruta : http://localhost:8080/api/v1/conductores/5
    public ResponseEntity<Map<String,Boolean>> eliminarConductor(@PathVariable Long id_conductor) {
        conductorService.eliminar(id_conductor);
        Map<String, Boolean> response = new HashMap<>();
        response.put("deleted", Boolean.TRUE);
        return ResponseEntity.ok(response);
    }
}
