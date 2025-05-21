package com.patobus.repository;

import com.patobus.model.Permissao;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PermissaoRepository extends JpaRepository<Permissao, Long> {
    Permissao findByNome(String nome);
}