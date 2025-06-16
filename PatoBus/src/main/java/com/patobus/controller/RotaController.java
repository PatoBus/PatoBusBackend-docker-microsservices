package com.patobus.controller;

import com.patobus.dto.RotaDTO;
import com.patobus.model.Rota;
import com.patobus.service.RotaService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@RestController
@RequestMapping("/rotas")
public class RotaController {

    @Autowired
    private RotaService rotaService;

    @GetMapping
    public ResponseEntity<List<Rota>> listar() {
        return ResponseEntity.ok(rotaService.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Rota> buscar(@PathVariable Long id) {
        return rotaService.findById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<Rota> criar(@RequestBody  Rota rota) {
        return ResponseEntity.ok(rotaService.save(rota));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletar(@PathVariable Long id) {
        rotaService.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}
