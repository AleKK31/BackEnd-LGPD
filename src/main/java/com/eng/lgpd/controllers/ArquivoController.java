package com.eng.lgpd.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import com.eng.lgpd.models.Arquivo;
import com.eng.lgpd.services.ArquivoService;

import java.io.IOException;

@RestController
@RequestMapping(value = "/api/upload", produces = {"application/json"})
@CrossOrigin("*")

public class ArquivoController {

    @Autowired
    private ArquivoService arquivoService;

    @PostMapping("/arquivo")
    public ResponseEntity<String> saveDoc(@RequestParam("file") MultipartFile file) {
        try {
            Arquivo arquivoSalvo = arquivoService.salvarArquivo(file);
            return new ResponseEntity<>("Arquivo carregado com sucesso. ID: " + arquivoSalvo.getId(), HttpStatus.OK);
        } catch (IOException e) {
            e.printStackTrace();
            return new ResponseEntity<>("Erro ao salvar o arquivo.", HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/arquivo/{id}")
    public ResponseEntity<?> getArquivo(@PathVariable Long id) {
        Arquivo arquivo = arquivoService.buscarArquivo(id);
        if (arquivo != null) {
            return new ResponseEntity<>(arquivo, HttpStatus.OK);
        } else {
            return new ResponseEntity<>("Arquivo não encontrado.", HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/arquivo/{id}")
    public ResponseEntity<String> deleteArquivo(@PathVariable Long id) {
        try {
            arquivoService.excluirArquivo(id);
            return new ResponseEntity<>("Arquivo excluído com sucesso.", HttpStatus.OK);
        } catch (Exception e) {
            e.printStackTrace();
            return new ResponseEntity<>("Erro ao excluir o arquivo.", HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
