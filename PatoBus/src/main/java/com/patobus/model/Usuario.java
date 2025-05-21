package com.patobus.model;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Usuario {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idUsuario;

    private String nome;

    @Column(length = 11, unique = true)
    private String cpf;

    @Column(unique = true)
    private String email;

    private String telefone;

    private String senha;

    private String tipo;
}
