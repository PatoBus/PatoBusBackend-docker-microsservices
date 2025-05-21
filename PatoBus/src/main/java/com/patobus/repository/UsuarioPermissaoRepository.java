// UsuarioPermissaoRepository.java
package com.patobus.repository;

import com.patobus.model.UsuarioPermissao;
import com.patobus.model.UsuarioPermissaoId;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UsuarioPermissaoRepository extends JpaRepository<UsuarioPermissao, UsuarioPermissaoId> {
}
