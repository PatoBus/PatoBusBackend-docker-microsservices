package com.patobus.service;

import com.patobus.model.LinhaHorario;
import com.patobus.repository.HorarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class HorarioService {

    @Autowired
    private HorarioRepository horarioRepository;

    public List<LinhaHorario> findAll() {
        return horarioRepository.findAll();
    }

    public Optional<LinhaHorario> findById(Long id) {
        return horarioRepository.findById(id);
    }

    public LinhaHorario save(LinhaHorario horario) {
        return horarioRepository.save(horario);
    }

    public void deleteById(Long id) {
        horarioRepository.deleteById(id);
    }
}
