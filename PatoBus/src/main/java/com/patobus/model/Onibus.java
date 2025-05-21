package com.patobus.model;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Onibus {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idOnibus;

    private String placa;

    private String gpsAtual;

    @ManyToOne
    @JoinColumn(name = "id_linha")
    private Linha linha;
}
