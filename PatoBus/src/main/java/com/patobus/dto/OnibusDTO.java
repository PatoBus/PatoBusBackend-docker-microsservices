package com.patobus.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class OnibusDTO {
    private Long idOnibus;
    private String placa;
    private String gpsAtual;
    private LinhaDTO linha;
}
