package com.patobus.controller;

import com.patobus.model.Linha;
import com.patobus.service.LinhaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/linhas")
public class LinhaController {

    @Autowired
    private LinhaService linhaService;

    @GetMapping
    public List<Linha> findAll() {
        return linhaService.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Linha> findById(@PathVariable Long id) {
        return linhaService.findById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public Linha create(@RequestBody Linha linha) {
        return linhaService.save(linha);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Linha> update(@PathVariable Long id, @RequestBody Linha linha) {
        return linhaService.findById(id)
                .map(l -> {
                    linha.setId(id);
                    return ResponseEntity.ok(linhaService.save(linha));
                })
                .orElse(ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        return linhaService.findById(id)
                .map(l -> {
                    linhaService.deleteById(id);
                    return ResponseEntity.noContent().<Void>build();
                })
                .orElse(ResponseEntity.notFound().build());
    }
}
