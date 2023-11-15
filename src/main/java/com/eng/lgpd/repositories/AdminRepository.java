package com.eng.lgpd.repositories;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.eng.lgpd.models.Admin;

public interface AdminRepository extends JpaRepository<Admin, Long> {
    Optional<Admin> findByEmail(String email);
	Optional<Admin> findByPhone(String phone);
}
