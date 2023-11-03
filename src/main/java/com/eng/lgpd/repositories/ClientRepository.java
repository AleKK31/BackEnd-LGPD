package com.eng.lgpd.repositories;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.eng.lgpd.models.Client;

public interface ClientRepository extends JpaRepository<Client, Long> {
    Optional<Client> findByEmail(String email);
	Optional<Client> findByPhone(String phone);
}
