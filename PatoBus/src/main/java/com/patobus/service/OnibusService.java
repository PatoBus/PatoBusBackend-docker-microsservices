// OnibusService.java
package com.patobus.service;

import com.patobus.model.Onibus;
import com.patobus.repository.OnibusRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class OnibusService {

    @Autowired
    private OnibusRepository onibusRepository;

    public List<Onibus> findAll() {
        return onibusRepository.findAll();
    }

    public Optional<Onibus> findById(Long id) {
        return onibusRepository.findById(id);
    }

    public Onibus save(Onibus onibus) {
        return onibusRepository.save(onibus);
    }

    public void deleteById(Long id) {
        onibusRepository.deleteById(id);
    }
}