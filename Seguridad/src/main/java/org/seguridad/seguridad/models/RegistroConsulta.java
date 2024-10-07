package org.seguridad.seguridad.models;

import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDateTime;

@Entity
@Data
public class RegistroConsulta {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(length = 100000)
    private String consulta;

    @Column(length = 100000)
    private String respuesta;

    @Column(name = "fecha_consulta", length = 100000)
    private LocalDateTime fecha_consulta;

    private String username;
}
