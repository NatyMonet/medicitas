package com.citasmedicas.citasmedicas.repository;

import com.citasmedicas.citasmedicas.model.Cita;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CitaRepository extends JpaRepository<Cita, Long> {
}
