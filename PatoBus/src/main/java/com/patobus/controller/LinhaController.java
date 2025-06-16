package com.patobus.controller;

import com.patobus.model.Linha;
import com.patobus.service.LinhaService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/linhas")
public class LinhaController {

    @Autowired
    private LinhaService linhaService;

    @GetMapping
    public ResponseEntity<List<Linha>> listarTodas() {
        return ResponseEntity.ok(linhaService.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Linha> buscarPorId(@PathVariable Long id) {
        return linhaService.findById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<Linha> criar(@RequestBody Linha linha) {
        return ResponseEntity.ok(linhaService.save(linha));
    }

    @PutMapping("/{id}")
    public ResponseEntity<Linha> atualizar(@PathVariable Long id, @RequestBody Linha dados) {
        return linhaService.findById(id).map(existente -> {
            existente.setNome(dados.getNome());
            existente.setEmpresa(dados.getEmpresa());
            return ResponseEntity.ok(linhaService.save(existente));
        }).orElse(ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletar(@PathVariable Long id) {
        if (linhaService.findById(id).isPresent()) {
            linhaService.deleteById(id);
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.notFound().build();
    }
}
