package com.eng.lgpd.repositories;

import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;

import com.eng.lgpd.models.Formulario;

public interface FormularioRepository extends JpaRepository<Formulario, Long> {
}