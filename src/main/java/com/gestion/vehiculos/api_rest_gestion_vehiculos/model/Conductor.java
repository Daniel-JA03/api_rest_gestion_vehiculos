package com.gestion.vehiculos.api_rest_gestion_vehiculos.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Getter
@Setter
@Entity
@Table(name = "conductores")
public class Conductor {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id_conductor;

    @Column(nullable = false)
    private String nombre;

    @Column(nullable = false, unique = true)
    private String licencia;

    private String telefono;

    @Column(nullable = false, unique = true)
    private String email;

    // Relación 1:N → Un conductor puede manejar múltiples vehículos
    @OneToMany(mappedBy = "conductor", cascade = CascadeType.ALL, orphanRemoval = true, fetch = FetchType.LAZY)
    @JsonIgnore // Para evitar problemas de recursión infinita en la serialización
    private List<Vehiculo> vehiculos;

    // Relación 1:N → Un conductor puede tener múltiples rutas asignadas
    @OneToMany(mappedBy = "conductor", cascade = CascadeType.ALL, orphanRemoval = true, fetch = FetchType.LAZY)
    @JsonIgnore
    private List<Ruta> rutas;
}
