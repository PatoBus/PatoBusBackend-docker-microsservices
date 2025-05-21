package com.patobus.model;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalTime;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class LinhaHorario {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idHorario;

    private LocalTime horario;

    @ManyToOne
    @JoinColumn(name = "id_linha")
    private Linha linha;
}
