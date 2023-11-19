package com.eng.lgpd.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.eng.lgpd.models.Arquivo;

public interface ArquivoRepository extends JpaRepository<Arquivo, Long> {

}
