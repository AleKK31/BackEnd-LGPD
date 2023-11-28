package com.eng.lgpd.controllers;

import java.net.URI;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.eng.lgpd.dtos.ClientDTO;
import com.eng.lgpd.models.Client;
import com.eng.lgpd.services.ClientService;

@RestController
@RequestMapping("/api/clientes")

public class ClientController {
    
    @Autowired
    private ClientService clienteService; 

    @GetMapping
	public ResponseEntity<List<ClientDTO>> findAll(){
		List<Client> list = clienteService.findAll();
		List<ClientDTO> listDTO = list.stream().map(obj -> new ClientDTO(obj)).collect(Collectors.toList());
		return ResponseEntity.ok().body(listDTO);
	}

    @GetMapping("/{id}")
    public ResponseEntity<ClientDTO> findById(@PathVariable Long id){
    	Client cliente = clienteService.findById(id);
		return ResponseEntity.ok().body(new ClientDTO(cliente));
    }

    @PostMapping("")
    public ResponseEntity<ClientDTO> create(@RequestBody ClientDTO cliente){
        Client newcliente = clienteService.create(cliente);
		URI uri = ServletUriComponentsBuilder
				.fromCurrentContextPath()
				.path("/{id}")
				.buildAndExpand(newcliente.getId())
				.toUri();
		return ResponseEntity.created(uri).build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<ClientDTO> delete(@PathVariable Long id){
        clienteService.delete(id);
        return ResponseEntity.noContent().build();
    }

    @PutMapping("/{id}")
    public ResponseEntity<Client> update(@RequestBody ClientDTO cliente, @PathVariable Long id){
		return ResponseEntity.ok().body(clienteService.update(id, cliente));
    }
}
