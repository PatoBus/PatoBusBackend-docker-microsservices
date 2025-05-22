package com.patobus.controller;

import com.patobus.dto.EmpresaDTO;
import com.patobus.model.Empresa;
import com.patobus.service.EmpresaService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/empresas")
public class EmpresaController {

    @Autowired
    private EmpresaService empresaService;

    @Autowired
    private ModelMapper modelMapper;

    // Converte Empresa para EmpresaDTO
    private EmpresaDTO toDTO(Empresa empresa) {
        return modelMapper.map(empresa, EmpresaDTO.class);
    }

    // Converte EmpresaDTO para Empresa
    private Empresa toEntity(EmpresaDTO dto) {
        return modelMapper.map(dto, Empresa.class);
    }

    @GetMapping
    public List<EmpresaDTO> findAll() {
        return empresaService.findAll()
                .stream()
                .map(this::toDTO)
                .collect(Collectors.toList());
    }

    @GetMapping("/{id}")
    public ResponseEntity<EmpresaDTO> findById(@PathVariable Long id) {
        return empresaService.findById(id)
                .map(this::toDTO)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public EmpresaDTO create(@RequestBody EmpresaDTO dto) {
        Empresa empresa = toEntity(dto);
        Empresa empresaSalva = empresaService.save(empresa);
        return toDTO(empresaSalva);
    }

    @PutMapping("/{id}")
    public ResponseEntity<EmpresaDTO> update(@PathVariable Long id, @RequestBody EmpresaDTO dto) {
        return empresaService.findById(id)
                .map(empresaExistente -> {
                    empresaExistente.setNome(dto.getNome());
                    empresaExistente.setCnpj(dto.getCnpj());
                    Empresa empresaAtualizada = empresaService.save(empresaExistente);
                    return ResponseEntity.ok(toDTO(empresaAtualizada));
                })
                .orElse(ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        if (empresaService.findById(id).isPresent()) {
            empresaService.deleteById(id);
            return ResponseEntity.noContent().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }


}
