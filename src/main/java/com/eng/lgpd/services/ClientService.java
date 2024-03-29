package com.eng.lgpd.services;
import java.util.List;
import java.util.Optional;

import org.hibernate.ObjectNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

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

    public Client findById(Long id){
		Optional<Client> obj = clienteRepository.findById(id);
		return obj.orElseThrow(() -> new ObjectNotFoundException("Objeto não encontrado!", null));
    }

    public Client create(Client cliente){
        cliente.setId(null);
        cliente.setPassword(encoder.encode(cliente.getPassword()));
		ValidationByTelAndEmail(cliente);
		return clienteRepository.save(cliente);
    }

    public void delete(Long id){
        clienteRepository.deleteById(id);
    } 

    public Client update(Long id, Client cliente){
        cliente.setId(id);
		Client oldcliente = findById(id);
		ValidationByTelAndEmail(cliente);
		oldcliente = new Client(cliente);
		return clienteRepository.save(oldcliente);
    }

    private void ValidationByTelAndEmail(Client cliente) {
		Optional<Client> obj = clienteRepository.findByPhone(cliente.getPhone());
		if (obj.isPresent() && obj.get().getId() != cliente.getId()) {
			throw new DataIntegrityViolationException("Telefone ja cadastrado!");
		}

		obj = clienteRepository.findByEmail(cliente.getEmail());

		if (obj.isPresent() && obj.get().getId() != cliente.getId()) {
			throw new DataIntegrityViolationException("Email ja cadastrado!");
		}
	}
}
