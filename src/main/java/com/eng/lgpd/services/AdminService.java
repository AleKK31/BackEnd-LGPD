package com.eng.lgpd.services;
import java.util.List;
import java.util.Optional;

import org.hibernate.ObjectNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.eng.lgpd.models.Admin;
import com.eng.lgpd.repositories.AdminRepository;

@Service
public class AdminService {

    @Autowired
    private AdminRepository administradorRepository;
    
    @Autowired
    private BCryptPasswordEncoder encoder;

    public List<Admin> findAll(){
        return administradorRepository.findAll();
    }

    public Admin findById(Long id){
		Optional<Admin> obj = administradorRepository.findById(id);
		return obj.orElseThrow(() -> new ObjectNotFoundException("Objeto não encontrado!", null));
    }

    public Admin create(Admin administrador){
        administrador.setId(null);
        administrador.setPassword(encoder.encode(administrador.getPassword()));
		ValidationByTelAndEmail(administrador);
		return administradorRepository.save(administrador);
    }

    public void delete(Long id){
        administradorRepository.deleteById(id);
    } 

    public Admin update(Long id, Admin administrador){
        administrador.setId(id);
	    Admin oldadministrador = findById(id);
		ValidationByTelAndEmail(administrador);
		oldadministrador = new Admin(administrador);
		return administradorRepository.save(oldadministrador);
    }

    private void ValidationByTelAndEmail(Admin administrador) {
		Optional<Admin> obj = administradorRepository.findByPhone(administrador.getPhone());
		if (obj.isPresent() && obj.get().getId() != administrador.getId()) {
			throw new DataIntegrityViolationException("Telefone ja cadastrado!");
		}

		obj = administradorRepository.findByEmail(administrador.getEmail());

		if (obj.isPresent() && obj.get().getId() != administrador.getId()) {
			throw new DataIntegrityViolationException("Email ja cadastrado!");
		}
	}
}
