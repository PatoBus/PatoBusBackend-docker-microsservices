package com.patobus.service;

import com.patobus.model.LinhaHorario;
import com.patobus.repository.LinhaHorarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class LinhaHorarioService {

    @Autowired
    private LinhaHorarioRepository linhaHorarioRepository;

    public List<LinhaHorario> findAll() {
        return linhaHorarioRepository.findAll();
    }

    public Optional<LinhaHorario> findById(Long id) {
        return linhaHorarioRepository.findById(id);
    }

    public LinhaHorario save(LinhaHorario linhaHorario) {
        return linhaHorarioRepository.save(linhaHorario);
    }

    public void deleteById(Long id) {
        linhaHorarioRepository.deleteById(id);
    }
}
