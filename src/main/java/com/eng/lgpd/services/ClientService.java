package com.eng.lgpd.services;
import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.hibernate.ObjectNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.eng.lgpd.dtos.ClientDTO;
import com.eng.lgpd.models.Client;
import com.eng.lgpd.repositories.ClientRepository;

@Service
public class ClientService {

    @Autowired
    private ClientRepository clienteRepository;
    
    @Autowired
    private BCryptPasswordEncoder encoder;

    public List<Client> findAll(){
        return clienteRepository.findAll();
    }

    public Client findById(Long id) {
        Optional<Client> obj = clienteRepository.findById(id);
        return obj.orElseThrow(() -> new ObjectNotFoundException("Cliente não encontrado para o ID: " + id, null));
    }

    public Client create(ClientDTO cliente){
        cliente.setId(null);
        cliente.setPassword(encoder.encode(cliente.getPassword()));
		ValidationByTelAndEmail(cliente);
		Client newClient = new Client(cliente);
		return clienteRepository.save(newClient);
    }

    public void delete(Long id){
        clienteRepository.deleteById(id);
    } 

	public Client update(Long id, @Valid ClientDTO objDTO) {
		objDTO.setId(id);
		Client oldObj = findById(id);
		ValidationByTelAndEmail(objDTO);
		oldObj = new Client(objDTO);
		return clienteRepository.save(oldObj);
	}

	private void ValidationByTelAndEmail(ClientDTO objDTO) {
		Optional<ClientDTO> obj = clienteRepository.findByPhone(objDTO.getPhone());
		if (obj.isPresent() && obj.get().getId() != objDTO.getId()) {
			throw new DataIntegrityViolationException("Telefone ja cadastrado!");
		}

		obj = clienteRepository.findByEmail(objDTO.getEmail());

		if (obj.isPresent() && obj.get().getId() != objDTO.getId()) {
			throw new DataIntegrityViolationException("Email ja cadastrado!");
		}
	}
}
