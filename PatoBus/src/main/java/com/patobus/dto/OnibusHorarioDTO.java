package com.patobus.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalTime;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class OnibusHorarioDTO {
    private Long idOnibus;
    private String placa;
    private String gpsAtual;
    private LinhaDTO linha;
    private List<LocalTime> horarios;
}
