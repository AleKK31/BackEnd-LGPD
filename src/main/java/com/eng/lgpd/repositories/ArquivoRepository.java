package com.eng.lgpd.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.eng.lgpd.models.Arquivo;

@Repository
public interface ArquivoRepository extends JpaRepository<Arquivo, String> {

}
