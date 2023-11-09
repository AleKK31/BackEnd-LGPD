package com.eng.lgpd.controllers;

import java.net.URI;
import java.util.List;

import com.eng.lgpd.models.Client;
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

import com.eng.lgpd.services.ClientService;

@RestController
@RequestMapping("/api/clientes")

public class ClientController {
    
    @Autowired
    private ClientService clienteService;

    @GetMapping
    public List<Client> findAll(){
        return clienteService.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Client> findById(@PathVariable Long id){
        Client cliente = clienteService.findById(id);
		return ResponseEntity.ok().body(new Client(cliente));
    }

    @PostMapping("")
    public ResponseEntity<Client> create(@RequestBody Client cliente){
        Client newcliente = clienteService.create(cliente);
		URI uri = ServletUriComponentsBuilder
				.fromCurrentContextPath()
				.path("/{id}")
				.buildAndExpand(newcliente.getId())
				.toUri();
		return ResponseEntity.created(uri).build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Client> delete(@PathVariable Long id){
        clienteService.delete(id);
        return ResponseEntity.noContent().build();
    }

    @PutMapping("/{id}")
    public ResponseEntity<Client> update(@RequestBody Client cliente, @PathVariable Long id){
        Client obj = clienteService.update(id, cliente); 
		return ResponseEntity.ok().body(new Client(obj));
    }
}
