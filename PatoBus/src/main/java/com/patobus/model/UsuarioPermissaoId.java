package com.patobus.model;

import lombok.*;

import java.io.Serializable;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class UsuarioPermissaoId implements Serializable {

    private Long idUsuario;
    private Long idPermissao;
}
