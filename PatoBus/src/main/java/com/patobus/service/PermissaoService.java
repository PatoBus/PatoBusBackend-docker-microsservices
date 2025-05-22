package com.patobus.service;

import com.patobus.model.Permissao;
import com.patobus.repository.PermissaoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PermissaoService {

    @Autowired
    private PermissaoRepository permissaoRepository;

    public List<Permissao> findAll() {
        return permissaoRepository.findAll();
    }

    public Permissao findByNome(String nome) {
        return permissaoRepository.findByNome(nome);
    }

    public Permissao save(Permissao permissao) {
        return permissaoRepository.save(permissao);
    }

    public void deleteById(Long id) {
        permissaoRepository.deleteById(id);
    }
}