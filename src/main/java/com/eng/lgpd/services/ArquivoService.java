package com.eng.lgpd.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.eng.lgpd.models.Arquivo;
import com.eng.lgpd.repositories.ArquivoRepository;

import java.io.IOException;

@Service
public class ArquivoService {
    
    @Autowired
    private ArquivoRepository arquivoRepository;

    public Arquivo salvarArquivo(MultipartFile file) throws IOException {
        Arquivo novoArquivo = new Arquivo();
        novoArquivo.setNome(file.getOriginalFilename());
        novoArquivo.setDados(file.getBytes());
        return arquivoRepository.save(novoArquivo);
    }

    public Arquivo buscarArquivo(Long id) {
        return arquivoRepository.findById(id).orElse(null);
    }

    public void excluirArquivo(Long id) {
        arquivoRepository.deleteById(id);
    }

}
