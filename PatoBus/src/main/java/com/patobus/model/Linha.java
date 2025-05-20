package com.patobus.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.AllArgsConstructor;
import lombok.Data ;
import lombok.NoArgsConstructor;


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
