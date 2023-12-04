package com.eng.lgpd.services;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.eng.lgpd.enums.Profiles;
import com.eng.lgpd.models.Client;
import com.eng.lgpd.repositories.ClientRepository;
import com.eng.lgpd.repositories.FormularioRepository;
import com.eng.lgpd.models.Admin;
import com.eng.lgpd.repositories.AdminRepository;
import com.eng.lgpd.models.Arquivo;
import com.eng.lgpd.repositories.ArquivoRepository;

@Service
public class DBservice {
	@Autowired
	private ClientRepository clienteRepository;
	@Autowired
	private AdminRepository adminRepository;
	@Autowired	
	private ArquivoRepository arquivoRepository;
	@Autowired
	private FormularioRepository formularioRepository;
	@Autowired
	private BCryptPasswordEncoder encoder;
	
	public void instanciaDB() {
		
//		Admin adm = new Admin(null, "Vinicisu", "vi1@gmail.com", encoder.encode("12345"), "44984559911");
		
//		adminRepository.save(adm);
	}
}
