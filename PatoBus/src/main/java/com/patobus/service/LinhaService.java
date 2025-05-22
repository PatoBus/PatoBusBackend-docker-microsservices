package com.patobus.service;

import com.patobus.model.Linha;
import com.patobus.repository.LinhaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class LinhaService {

    @Autowired
    private LinhaRepository linhaRepository;

    public List<Linha> findAll() {
        return linhaRepository.findAll();
    }

    public Optional<Linha> findById(Long id) {
        return linhaRepository.findById(id);
    }

    public Linha save(Linha linha) {
        return linhaRepository.save(linha);
    }

    public void deleteById(Long id) {
        linhaRepository.deleteById(id);
    }
}