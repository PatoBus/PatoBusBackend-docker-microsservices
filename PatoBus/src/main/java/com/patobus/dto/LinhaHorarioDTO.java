package com.patobus.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class LinhaHorarioDTO {
    private LinhaDTO linha;
    private HorarioDTO horario;
    private String diaSemana;
    private RotaDTO rota;
}
