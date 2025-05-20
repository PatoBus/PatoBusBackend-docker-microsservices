package com.patobus.model;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.*;



@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Onibus {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idOnibus;

    private String placa;
    private String gpsAtual;

    @ManyToOne
    @JoinColumn(name = "id_linha")
    private Linha linha;
}
