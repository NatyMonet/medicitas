package com.citasmedicas.citasmedicas.repository;

import com.citasmedicas.citasmedicas.model.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UsuarioRepository extends JpaRepository<Usuario, Long> {
    Usuario findByEmail(String email);
}