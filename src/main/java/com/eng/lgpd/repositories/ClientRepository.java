package com.eng.lgpd.repositories;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.eng.lgpd.dtos.ClientDTO;
import com.eng.lgpd.models.Client;

public interface ClientRepository extends JpaRepository<Client, Long> {
    Optional<ClientDTO> findByEmail(String email);
	Optional<ClientDTO> findByPhone(String phone);
}
