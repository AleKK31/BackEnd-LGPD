package com.eng.lgpd.controllers;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.eng.lgpd.dtos.AdminDTO;
import com.eng.lgpd.models.Admin;
import com.eng.lgpd.models.Formulario;
import com.eng.lgpd.services.FormularioService;

@RestController
@RequestMapping("/api/formulario")
public class FormularioController {

    @Autowired
    private FormularioService formularioService;

    @GetMapping
    public List<Formulario> findAll() {
        return formularioService.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Formulario> findById(@PathVariable Long id) {
        Formulario formulario = formularioService.findById(id);
        return ResponseEntity.ok().body(formulario);
    }

    
    @PostMapping
    public ResponseEntity<Formulario> criarFormulario(@RequestBody Formulario formulario) {
        Formulario novoFormulario = formularioService.criarFormulario(formulario);
        return new ResponseEntity<>(novoFormulario, HttpStatus.CREATED);
    }
}