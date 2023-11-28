package com.eng.lgpd.controllers;

import com.eng.lgpd.ResponseData;
import com.eng.lgpd.models.Arquivo;
import com.eng.lgpd.services.ArquivoService;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

@RestController
public class ArquivoController {
    
    private ArquivoService arquivoService;

    public ArquivoController(ArquivoService arquivoService) {
        this.arquivoService = arquivoService;
    }

    @PostMapping("/upload")
    public ResponseData uploadFile(@RequestParam("file")MultipartFile file) throws Exception {
        Arquivo arquivo = null;
        String downloadURL = "";
        arquivo = arquivoService.saveArquivo(file);
        downloadURL = ServletUriComponentsBuilder.fromCurrentContextPath().path("/download").path(arquivo.getId()).toUriString();

        return new ResponseData(arquivo.getFileName(), downloadURL, file.getContentType(), file.getSize());
    }
}