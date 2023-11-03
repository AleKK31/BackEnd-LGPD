package com.eng.lgpd.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.eng.lgpd.repositories.ClientRepository;

@Service
public class DBservice {
	@Autowired
	private ClientRepository clienteRepository;
	
	public void intanciaDB() {
	}
}
