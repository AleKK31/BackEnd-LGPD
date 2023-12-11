package com.eng.lgpd.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import com.eng.lgpd.models.Formulario;
import com.eng.lgpd.models.Respostas;
import com.eng.lgpd.repositories.RespostasRepository;
import com.eng.lgpd.services.RespostasService;

@RestController
@RequestMapping("/respostas")
public class RespostasController {
    
    @Autowired
    private RespostasService respostasService;

    @GetMapping
    public List<Respostas> obterTodasAsRespostas() {
        return respostasService.obterTodasAsRespostas();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Respostas> obterRespostaPorId(@PathVariable Long id) {
        Respostas respostas = respostasService.obterRespostaPorId(id);
        return ResponseEntity.ok().body(respostas);
    }

    @PostMapping
    public Respostas salvarResposta(@RequestBody Respostas resposta) {
        return respostasService.salvarResposta(resposta);
    }
}
