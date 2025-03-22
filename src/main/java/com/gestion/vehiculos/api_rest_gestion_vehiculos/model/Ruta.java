package com.gestion.vehiculos.api_rest_gestion_vehiculos.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIncludeProperties;
import jakarta.persistence.*;
import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Getter
@Setter
@Entity
@Table(name = "ruta")
public class Ruta {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id_ruta;

    @Column(nullable = false)
    private String origen;

    @Column(nullable = false)
    private String destino;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "id_conductor", nullable = false)
    @JsonIncludeProperties({"id_conductor", "nombre", "telefono" ,"email"}) // Solo muestra estos datos del conductor
    private Conductor conductor;

}
