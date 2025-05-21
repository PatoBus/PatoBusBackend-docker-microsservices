package com.patobus.repository;

import com.patobus.model.LinhaHorario;
import org.springframework.data.jpa.repository.JpaRepository;

public interface HorarioRepository extends JpaRepository<LinhaHorario, Long> {
}
