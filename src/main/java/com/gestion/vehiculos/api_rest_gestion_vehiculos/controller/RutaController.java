package com.gestion.vehiculos.api_rest_gestion_vehiculos.controller;

import com.gestion.vehiculos.api_rest_gestion_vehiculos.exception.ResourceNotFoundException;
import com.gestion.vehiculos.api_rest_gestion_vehiculos.model.Ruta;
import com.gestion.vehiculos.api_rest_gestion_vehiculos.service.RutaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@CrossOrigin(origins = "http://localhost:5173/")
@RestController
@RequestMapping("/api/v1")
public class RutaController {

    @Autowired
    private RutaService rutaService;

    @GetMapping("/rutas") // Ruta : http://localhost:8080/api/v1/rutas
    public List<Ruta> listarRutas() {
        return rutaService.obtenerTodos();
    }

    @PostMapping("/rutas") // Ruta : http://localhost:8080/api/v1/rutas
    public Ruta guardarRutas(@RequestBody Ruta ruta) {
        return rutaService.guardar(ruta);
    }

    @GetMapping("/rutas/{id_ruta}") // Ruta : http://localhost:8080/api/v1/rutas/1
    public ResponseEntity<Ruta> listarRutaPoId(@PathVariable Long id_ruta) {
        Ruta ruta = rutaService.rutaId(id_ruta)
                .orElseThrow(() -> new ResourceNotFoundException("La ruta con ese ID no existe : " + id_ruta));
        return ResponseEntity.ok(ruta);
    }

    @PutMapping("/rutas/{id_ruta}") // Ruta : http://localhost:8080/api/v1/rutas/1
    public ResponseEntity<Ruta> actualizarRuta(@PathVariable Long id_ruta, @RequestBody Ruta rutaRequest) {
        Ruta ruta = rutaService.rutaId(id_ruta)
                .orElseThrow(() -> new ResourceNotFoundException("La ruta con ese ID no existe : " + id_ruta));
        ruta.setOrigen(rutaRequest.getOrigen());
        ruta.setDestino(rutaRequest.getDestino());
        ruta.setConductor(rutaRequest.getConductor());

        Ruta rutaActualizado = rutaService.guardar(ruta);
        return ResponseEntity.ok(rutaActualizado);
    }

    @DeleteMapping("/rutas/{id_ruta}") // Ruta : http://localhost:8080/api/v1/rutas/5
    public ResponseEntity<Map<String,Boolean>> eliminarRuta(@PathVariable Long id_ruta) {
        rutaService.eliminar(id_ruta);
        Map<String, Boolean> response = new HashMap<>();
        response.put("deleted", Boolean.TRUE);
        return ResponseEntity.ok(response);
    }
}
