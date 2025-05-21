package com.patobus.model;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Linha {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idLinha;

    private String nome;

    private Float valor;

    @ManyToOne
    @JoinColumn(name = "id_empresa")
    private Empresa empresa;
}
