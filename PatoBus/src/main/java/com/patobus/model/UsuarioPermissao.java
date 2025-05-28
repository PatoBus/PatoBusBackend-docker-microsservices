package com.patobus.model;

import jakarta.persistence.*;
import lombok.*;

@Entity
@IdClass(UsuarioPermissaoId.class)
@Data
@NoArgsConstructor
@AllArgsConstructor
public class UsuarioPermissao {

    @Id
    @Column(name = "id_usuario")
    private Long idUsuario;

    @Id
    @Column(name = "id_permissao")
    private Long idPermissao;

    @ManyToOne
    @JoinColumn(name = "id_usuario", insertable = false, updatable = false)
    private Usuario usuario;

    @ManyToOne
    @JoinColumn(name = "id_permissao", insertable = false, updatable = false)
    private Permissao permissao;
}
