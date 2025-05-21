package com.patobus.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class LinhaDTO {
    private Long idLinha;
    private String nome;
    private Float valor;
    private EmpresaDTO empresa;
}