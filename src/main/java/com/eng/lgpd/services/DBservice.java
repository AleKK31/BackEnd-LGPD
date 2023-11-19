package com.eng.lgpd.services;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.eng.lgpd.enums.Profiles;
import com.eng.lgpd.models.Client;
import com.eng.lgpd.repositories.ClientRepository;
import com.eng.lgpd.models.Arquivo;
import com.eng.lgpd.repositories.ArquivoRepository;

@Service
public class DBservice {
	@Autowired
	private ClientRepository clienteRepository;
	private ArquivoRepository arquivoRepository;
	
	@Autowired
	private BCryptPasswordEncoder encoder;
	
	public void intanciaDB() {
		

	}
}
