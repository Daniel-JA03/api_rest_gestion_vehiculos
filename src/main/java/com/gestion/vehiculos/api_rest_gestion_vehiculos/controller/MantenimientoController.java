package com.gestion.vehiculos.api_rest_gestion_vehiculos.controller;

import com.gestion.vehiculos.api_rest_gestion_vehiculos.exception.ResourceNotFoundException;
import com.gestion.vehiculos.api_rest_gestion_vehiculos.model.Conductor;
import com.gestion.vehiculos.api_rest_gestion_vehiculos.model.Mantenimiento;
import com.gestion.vehiculos.api_rest_gestion_vehiculos.service.MantenimientoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@CrossOrigin(origins = "http://localhost:5173/")
@RestController
@RequestMapping("/api/v1")
public class MantenimientoController {

    @Autowired
    private MantenimientoService mantenimientoService;


    @GetMapping("/mantenimientos") // Ruta : http://localhost:8080/api/v1/mantenimientos
    public List<Mantenimiento> listarMantenimientos() {
        return mantenimientoService.obtenerTodos();
    }

    @PostMapping("/mantenimientos") // Ruta : http://localhost:8080/api/v1/mantenimientos
    public Mantenimiento guardarMantenimiento(@RequestBody Mantenimiento mantenimiento) {
        return  mantenimientoService.guardar(mantenimiento);
    }

    @GetMapping("/mantenimientos/{id_mantenimiento}") // Ruta : http://localhost:8080/api/v1/mantenimientos/1
    public ResponseEntity<Mantenimiento> listarMantenimientoPoId(@PathVariable Long id_mantenimiento) {
        Mantenimiento mantenimiento = mantenimientoService.mantenimientoId(id_mantenimiento)
                .orElseThrow(() -> new ResourceNotFoundException("El mantenimiento con ese ID no existe : " + id_mantenimiento));
        return ResponseEntity.ok(mantenimiento);
    }

    @PutMapping("/mantenimientos/{id_mantenimiento}") // Ruta : http://localhost:8080/api/v1/mantenimientos/1
    public ResponseEntity<Mantenimiento> actualizarMantenimiento( @PathVariable Long id_mantenimiento, @RequestBody Mantenimiento mantenimientoRequest) {
        Mantenimiento mantenimiento = mantenimientoService.mantenimientoId(id_mantenimiento)
                .orElseThrow(() -> new ResourceNotFoundException("El mantenimiento con ese ID no existe : " + id_mantenimiento));

        mantenimiento.setTipo(mantenimientoRequest.getTipo());
        mantenimiento.setFecha(mantenimientoRequest.getFecha());
        mantenimiento.setCosto(mantenimientoRequest.getCosto());
        mantenimiento.setDescripcion(mantenimientoRequest.getDescripcion());
        mantenimiento.setEstado(mantenimientoRequest.getEstado());
        mantenimiento.setVehiculo(mantenimientoRequest.getVehiculo());


       Mantenimiento mantenimientoActualizado = mantenimientoService.guardar(mantenimiento);
        return ResponseEntity.ok(mantenimientoActualizado);
    }

    @DeleteMapping("/mantenimientos/{id_mantenimiento}") // Ruta : http://localhost:8080/api/v1/mantenimientos/5
    public ResponseEntity<Map<String,Boolean>> eliminarMantenimiento(@PathVariable Long id_mantenimiento) {
        mantenimientoService.eliminar(id_mantenimiento);
        Map<String, Boolean> response = new HashMap<>();
        response.put("deleted", Boolean.TRUE);
        return ResponseEntity.ok(response);
    }

    @GetMapping("/mantenimientos/tipos") // Ruta : http://localhost:8080/api/v1/mantenimientos/tipos
    public Mantenimiento.TipoMantenimiento[] getTiposMantenimiento() {
        return Mantenimiento.TipoMantenimiento.values();
    }

    @GetMapping("/mantenimientos/estados") // Ruta : http://localhost:8080/api/v1/mantenimientos/estados
    public Mantenimiento.EstadoVehiculo[] getEstadosVehiculo() {
        return Mantenimiento.EstadoVehiculo.values();
    }
}
