package com.patobus.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class UsuarioCadastroDTO {
    private String nome;
    private String cpf;
    private String email;
    private String telefone;
    private String senha;
    private String tipo;
}