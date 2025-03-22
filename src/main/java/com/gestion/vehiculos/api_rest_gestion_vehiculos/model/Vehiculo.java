package com.gestion.vehiculos.api_rest_gestion_vehiculos.model;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIncludeProperties;
import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Getter
@Setter
@Entity
@Table(name = "vehiculos")
public class Vehiculo {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id_vehiculo;

    @Column(nullable = false, unique = true)
    private String placa;

    private String marca;
    private String modelo;
    private int anio;

    // Relación N:1 → Un vehículo es manejado por un solo conductor
    @ManyToOne(fetch = FetchType.EAGER) // Se carga junto con el vehículo
    @JoinColumn(name = "id_conductor")
    @JsonIncludeProperties({"id_conductor", "nombre", "email"}) // Controla qué datos del conductor se serializan
    private Conductor conductor;

    // Relación 1:N → Un vehículo puede tener múltiples mantenimientos
    @OneToMany(mappedBy = "vehiculo", cascade = CascadeType.ALL, orphanRemoval = true, fetch = FetchType.LAZY)
    @JsonIgnore
    private List<Mantenimiento> mantenimientos;


}

