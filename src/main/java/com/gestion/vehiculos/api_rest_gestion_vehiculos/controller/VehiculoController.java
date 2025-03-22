package com.gestion.vehiculos.api_rest_gestion_vehiculos.controller;

import com.gestion.vehiculos.api_rest_gestion_vehiculos.exception.ResourceNotFoundException;
import com.gestion.vehiculos.api_rest_gestion_vehiculos.model.Vehiculo;
import com.gestion.vehiculos.api_rest_gestion_vehiculos.service.VehiculoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@CrossOrigin(origins = "http://localhost:5173/")
@RestController
@RequestMapping("/api/v1")
public class VehiculoController {

    @Autowired
    private VehiculoService vehiculoService;

    @GetMapping("/vehiculos") // Ruta : http://localhost:8080/api/v1/vehiculos
    public List<Vehiculo> listarVehiculos() {
        return vehiculoService.obtenerTodos();
    }

    @PostMapping("/vehiculos") // Ruta : http://localhost:8080/api/v1/vehiculos
    public Vehiculo guardarVehiculo(@RequestBody Vehiculo vehiculo) {
        return vehiculoService.guardar(vehiculo);
    }

    @GetMapping("/vehiculos/{id_vehiculo}") // Ruta : http://localhost:8080/api/v1/vehiculos/1
    public ResponseEntity<Vehiculo> listarVehiculoPorId(@PathVariable Long id_vehiculo) {
        Vehiculo vehiculo = vehiculoService.vehiculoId(id_vehiculo)
                .orElseThrow(() -> new ResourceNotFoundException("El vehiculo con ese ID no existe : " + id_vehiculo));
        return ResponseEntity.ok(vehiculo);
    }

    @PutMapping("/vehiculos/{id_vehiculo}") // Ruta : http://localhost:8080/api/v1/vehiculos/1
    public ResponseEntity<Vehiculo> actualizarVehiculo(@PathVariable Long id_vehiculo, @RequestBody Vehiculo vehiculoRequest) {
        Vehiculo vehiculo = vehiculoService.vehiculoId(id_vehiculo)
                .orElseThrow(() -> new ResourceNotFoundException("El vehiculo con ese ID no existe : " + id_vehiculo));
        vehiculo.setPlaca(vehiculoRequest.getPlaca());
        vehiculo.setMarca(vehiculoRequest.getMarca());
        vehiculo.setModelo(vehiculoRequest.getModelo());
        vehiculo.setAnio(vehiculoRequest.getAnio());
        vehiculo.setConductor(vehiculoRequest.getConductor());

        Vehiculo vehiculoActualizado = vehiculoService.guardar(vehiculo);
        return ResponseEntity.ok(vehiculoActualizado);
    }

    @DeleteMapping("/vehiculos/{id_vehiculo}") // Ruta : http://localhost:8080/api/v1/vehiculos/5
    public ResponseEntity<Map<String,Boolean>> eliminarVehiculo(@PathVariable Long id_vehiculo) {

        vehiculoService.eliminar(id_vehiculo);
        Map<String, Boolean> response = new HashMap<>();
        response.put("deleted", Boolean.TRUE);
        return ResponseEntity.ok(response);
    }

}
