package com.patobus.controller;

import com.patobus.dto.OnibusHorarioDTO;
import com.patobus.model.Onibus;
import com.patobus.service.OnibusService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/onibus")
public class OnibusController {

    @Autowired
    private OnibusService onibusService;


    @GetMapping
    public ResponseEntity<List<Onibus>> getAll() {
        return ResponseEntity.ok(onibusService.findAll());
    }

    
    @GetMapping("/{id}")
    public ResponseEntity<Onibus> getById(@PathVariable Long id) {
        return onibusService.findById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

  
    @PostMapping
    public ResponseEntity<Onibus> create(@RequestBody Onibus onibus) {
        return ResponseEntity.ok(onibusService.save(onibus));
    }

   
    @PutMapping("/{id}")
    public ResponseEntity<Onibus> update(@PathVariable Long id, @RequestBody Onibus onibus) {
        return onibusService.findById(id)
                .map(existing -> {
                    onibus.setIdOnibus(id);
                    return ResponseEntity.ok(onibusService.save(onibus));
                })
                .orElse(ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        if (onibusService.findById(id).isPresent()) {
            onibusService.deleteById(id);
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.notFound().build();
    }

    // ✅ GET - Buscar horários de um ônibus específico
    @GetMapping("/{id}/horarios")
    public ResponseEntity<OnibusHorarioDTO> getHorarios(@PathVariable Long id) {
        try {
            OnibusHorarioDTO dto = onibusService.buscarOnibusComHorarios(id);
            return ResponseEntity.ok(dto);
        } catch (RuntimeException e) {
            return ResponseEntity.notFound().build();
        }
    }

        // GET - Retorna o ônibus com todos os horários da linha associada
    @GetMapping("/{id}/com-horarios")
    public ResponseEntity<OnibusHorarioDTO> getOnibusComHorarios(@PathVariable Long id) {
        try {
            OnibusHorarioDTO dto = onibusService.buscarOnibusComHorarios(id);
            return ResponseEntity.ok(dto);
        } catch (RuntimeException e) {
            return ResponseEntity.notFound().build();
        }
    }

    // GET - Retorna todos os ônibus com seus horários
    @GetMapping("/com-horarios")
    public ResponseEntity<List<OnibusHorarioDTO>> getAllWithHorarios() {
        List<OnibusHorarioDTO> onibusComHorarios = onibusService.findAllOnibusHorarios();
        return ResponseEntity.ok(onibusComHorarios);
    }

}
