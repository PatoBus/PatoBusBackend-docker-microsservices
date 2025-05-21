package com.patobus.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class RotaDTO {
    private Long idRota;
    private String nome;
    private String pontos; // JSON ou String com coordenadas geográficas
    private String descricao;
    private LinhaDTO linha;
}