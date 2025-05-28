package com.patobus.model;

import jakarta.persistence.*;
import lombok.Data;
@Data
@Entity
@Table(name = "linha_horario")
public class LinhaHorario {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "linha_id", nullable = false)
    private Linha linha;

    @ManyToOne
    @JoinColumn(name = "horario_id", nullable = false)
    private Horario horario;


}
