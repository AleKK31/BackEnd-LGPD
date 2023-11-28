package com.eng.lgpd.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.eng.lgpd.models.Formulario;
import com.eng.lgpd.services.FormularioService;

@RestController
@RequestMapping("/api/formulario")
public class FormularioController {

    @Autowired
    private FormularioService formularioService;

    @PostMapping
    public ResponseEntity<Formulario> criarFormulario(@RequestBody Formulario formulario) {
        Formulario novoFormulario = formularioService.criarFormulario(formulario);
        return new ResponseEntity<>(novoFormulario, HttpStatus.CREATED);
    }
}