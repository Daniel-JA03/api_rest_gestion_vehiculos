package com.gestion.vehiculos.api_rest_gestion_vehiculos.model;

import com.fasterxml.jackson.annotation.JsonIncludeProperties;
import jakarta.persistence.*;
import lombok.*;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDate;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
@Table(name = "mantenimiento")
public class Mantenimiento {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id_mantenimiento;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private TipoMantenimiento tipo; // PREVENTIVO, CORRECTIVO

    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate fecha;

    private Double costo;

    @Column(nullable = false)
    private String descripcion;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private EstadoVehiculo estado;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "id_vehiculo", nullable = false)
    @JsonIncludeProperties({"id_vehiculo", "placa", "marca"})
    private Vehiculo vehiculo;

    public enum TipoMantenimiento {
        PREVENTIVO,
        CORRECTIVO
    }

    public enum EstadoVehiculo {
        COMPLETADO,
        EN_MANTENIMIENTO,
        PENDIENTE
    }
}

