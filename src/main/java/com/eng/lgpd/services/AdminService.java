package com.eng.lgpd.services;
import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.hibernate.ObjectNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.eng.lgpd.dtos.AdminDTO;
import com.eng.lgpd.models.Admin;
import com.eng.lgpd.repositories.AdminRepository;

@Service
public class AdminService {

    @Autowired
    private AdminRepository adminRepository;
    
    @Autowired
    private BCryptPasswordEncoder encoder;

    public List<Admin> findAll(){
        return adminRepository.findAll();
    }

    public Admin findById(Long id) {
        Optional<Admin> obj = adminRepository.findById(id);
        return obj.orElseThrow(() -> new ObjectNotFoundException("Admine não encontrado para o ID: " + id, null));
    }

    public Admin create(AdminDTO admin){
        admin.setId(null);
        admin.setPassword(encoder.encode(admin.getPassword()));
		ValidationByTelAndEmail(admin);
		Admin newAdmin = new Admin(admin);
		return adminRepository.save(newAdmin);
    }

    public void delete(Long id){
        adminRepository.deleteById(id);
    } 

	public Admin update(Long id, @Valid AdminDTO objDTO) {
		objDTO.setId(id);
		Admin oldObj = findById(id);
		ValidationByTelAndEmail(objDTO);
		oldObj = new Admin(objDTO);
		return adminRepository.save(oldObj);
	}

	private void ValidationByTelAndEmail(AdminDTO objDTO) {
		Optional<AdminDTO> obj = adminRepository.findByPhone(objDTO.getPhone());
		if (obj.isPresent() && obj.get().getId() != objDTO.getId()) {
			throw new DataIntegrityViolationException("Telefone ja cadastrado!");
		}

		obj = adminRepository.findByEmail(objDTO.getEmail());

		if (obj.isPresent() && obj.get().getId() != objDTO.getId()) {
			throw new DataIntegrityViolationException("Email ja cadastrado!");
		}
	}
}
