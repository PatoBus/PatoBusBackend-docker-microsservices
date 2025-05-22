package com.patobus.repository;

import com.patobus.model.LinhaHorario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LinhaHorarioRepository extends JpaRepository<LinhaHorario, Long> {
}
