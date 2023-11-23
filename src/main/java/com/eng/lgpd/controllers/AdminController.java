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

import com.eng.lgpd.dtos.AdminDTO;
import com.eng.lgpd.models.Admin;
import com.eng.lgpd.services.AdminService;

@RestController
@RequestMapping("/api/admins")

public class AdminController {
    
    @Autowired
    private AdminService adminService; 

    @GetMapping
	public ResponseEntity<List<AdminDTO>> findAll(){
		List<Admin> list = adminService.findAll();
		List<AdminDTO> listDTO = list.stream().map(obj -> new AdminDTO(obj)).collect(Collectors.toList());
		return ResponseEntity.ok().body(listDTO);
	}

    @GetMapping("/{id}")
    public ResponseEntity<AdminDTO> findById(@PathVariable Long id){
    	Admin admin = adminService.findById(id);
		return ResponseEntity.ok().body(new AdminDTO(admin));
    }

    @PostMapping("")
    public ResponseEntity<AdminDTO> create(@RequestBody AdminDTO Admin){
        Admin newAdmin = adminService.create(Admin);
		URI uri = ServletUriComponentsBuilder
				.fromCurrentContextPath()
				.path("/{id}")
				.buildAndExpand(newAdmin.getId())
				.toUri();
		return ResponseEntity.created(uri).build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<AdminDTO> delete(@PathVariable Long id){
        adminService.delete(id);
        return ResponseEntity.noContent().build();
    }

    @PutMapping("/{id}")
    public ResponseEntity<Admin> update(@RequestBody AdminDTO Admin, @PathVariable Long id){
		return ResponseEntity.ok().body(adminService.update(id, Admin));
    }
}
