package com.eng.lgpd.repositories;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.eng.lgpd.dtos.AdminDTO;
import com.eng.lgpd.models.Admin;

public interface AdminRepository extends JpaRepository<Admin, Long> {
    Optional<AdminDTO> findByEmail(String email);
	Optional<AdminDTO> findByPhone(String phone);
}
