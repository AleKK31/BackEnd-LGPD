package com.eng.lgpd.controllers;

import java.net.URI;
import java.util.List;

import com.eng.lgpd.models.Admin;
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

import com.eng.lgpd.services.AdminService;

@RestController
@RequestMapping("/api/administradores")

public class AdminController {
    
    @Autowired
    private AdminService administradorService;

    @GetMapping
    public List<Admin> findAll(){
        return administradorService.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Admin> findById(@PathVariable Long id){
        Admin administrador = administradorService.findById(id);
		return ResponseEntity.ok().body(new Admin(administrador));
    }

    @PostMapping("")
    public ResponseEntity<Admin> create(@RequestBody Admin administrador){
        Admin newadministrador = administradorService.create(administrador);
		URI uri = ServletUriComponentsBuilder
				.fromCurrentContextPath()
				.path("/{id}")
				.buildAndExpand(newadministrador.getId())
				.toUri();
		return ResponseEntity.created(uri).build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Admin> delete(@PathVariable Long id){
        administradorService.delete(id);
        return ResponseEntity.noContent().build();
    }

    @PutMapping("/{id}")
    public ResponseEntity<Admin> update(@RequestBody Admin administrador, @PathVariable Long id){
        Admin obj = administradorService.update(id, administrador); 
		return ResponseEntity.ok().body(new Admin(obj));
    }
}
