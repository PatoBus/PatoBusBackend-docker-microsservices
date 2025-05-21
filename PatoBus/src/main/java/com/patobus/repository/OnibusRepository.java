package com.patobus.repository;

import com.patobus.model.Onibus;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OnibusRepository extends JpaRepository<Onibus, Long> {
}