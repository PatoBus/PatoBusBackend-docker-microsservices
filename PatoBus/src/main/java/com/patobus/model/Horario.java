package com.patobus.model;

import jakarta.persistence.*;
import java.time.LocalTime;
import java.util.List;

@Entity
@Table(name = "horarios")
public class Horario {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private LocalTime hora;

    @OneToMany(mappedBy = "horario")
    private List<LinhaHorario> linhaHorarios;

    public Horario() {
    }

    public Horario(LocalTime hora) {
        this.hora = hora;
    }

    public Long getId() {
        return id;
    }

    public LocalTime getHora() {
        return hora;
    }

    public void setHora(LocalTime hora) {
        this.hora = hora;
    }

    public List<LinhaHorario> getLinhaHorarios() {
        return linhaHorarios;
    }

    public void setLinhaHorarios(List<LinhaHorario> linhaHorarios) {
        this.linhaHorarios = linhaHorarios;
    }
}
