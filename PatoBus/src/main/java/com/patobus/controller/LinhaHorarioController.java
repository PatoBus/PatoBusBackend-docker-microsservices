package com.patobus.controller;

import com.patobus.model.LinhaHorario;
import com.patobus.service.LinhaHorarioService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/linhas-horarios")
public class LinhaHorarioController {

    @Autowired
    private LinhaHorarioService linhaHorarioService;

    @GetMapping
    public ResponseEntity<List<LinhaHorario>> listarTodas() {
        return ResponseEntity.ok(linhaHorarioService.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<LinhaHorario> buscarPorId(@PathVariable Long id) {
        return linhaHorarioService.findById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<LinhaHorario> criar(@RequestBody LinhaHorario linhaHorario) {
        return ResponseEntity.ok(linhaHorarioService.save(linhaHorario));
    }

    @PutMapping("/{id}")
    public ResponseEntity<LinhaHorario> atualizar(@PathVariable Long id, @RequestBody LinhaHorario dados) {
        return linhaHorarioService.findById(id).map(existente -> {
            existente.setHorario(dados.getHorario());
            existente.setLinha(dados.getLinha());
            return ResponseEntity.ok(linhaHorarioService.save(existente));
        }).orElse(ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletar(@PathVariable Long id) {
        if (linhaHorarioService.findById(id).isPresent()) {
            linhaHorarioService.deleteById(id);
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.notFound().build();
    }
}
