// UsuarioPermissaoService.java
package com.patobus.service;

import com.patobus.model.UsuarioPermissao;
import com.patobus.model.UsuarioPermissaoId;
import com.patobus.repository.UsuarioPermissaoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UsuarioPermissaoService {

    @Autowired
    private UsuarioPermissaoRepository usuarioPermissaoRepository;

    public List<UsuarioPermissao> findAll() {
        return usuarioPermissaoRepository.findAll();
    }

    public Optional<UsuarioPermissao> findById(UsuarioPermissaoId id) {
        return usuarioPermissaoRepository.findById(id);
    }

    public UsuarioPermissao save(UsuarioPermissao usuarioPermissao) {
        return usuarioPermissaoRepository.save(usuarioPermissao);
    }

    public void deleteById(UsuarioPermissaoId id) {
        usuarioPermissaoRepository.deleteById(id);
    }
}