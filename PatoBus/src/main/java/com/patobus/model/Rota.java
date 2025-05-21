package com.patobus.model;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Rota {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idRota;

    private String nome;

    @Lob
    private String pontos;

    @Lob
    private String descricao;

    @ManyToOne
    @JoinColumn(name = "id_linha")
    private Linha linha;
}
