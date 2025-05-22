package com.patobus.model;

import jakarta.persistence.*;

@Entity
@Table(name = "linha_horario")
public class LinhaHorario {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "linha_id", nullable = false)
    private Linha linha;

    @ManyToOne
    @JoinColumn(name = "horario_id", nullable = false)
    private Horario horario;

    // Construtores
    public LinhaHorario() {
    }

    public LinhaHorario(Linha linha, Horario horario) {
        this.linha = linha;
        this.horario = horario;
    }

    // Getters e Setters
    public Long getId() {
        return id;
    }

    public Linha getLinha() {
        return linha;
    }

    public void setLinha(Linha linha) {
        this.linha = linha;
    }

    public Horario getHorario() {
        return horario;
    }

    public void setHorario(Horario horario) {
        this.horario = horario;
    }
}
