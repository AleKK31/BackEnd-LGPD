package com.eng.lgpd.services;

import com.eng.lgpd.models.Arquivo;
import com.eng.lgpd.repositories.ArquivoRepository;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import org.springframework.web.multipart.MultipartFile;

@Service
public class ArquivoServiceImpl implements ArquivoService{

    private ArquivoRepository arquivoRepository;

    public ArquivoServiceImpl(ArquivoRepository arquivoRepository) {
        this.arquivoRepository = arquivoRepository;
    }

    @Override
    public Arquivo saveArquivo(MultipartFile file) throws Exception{
        String fileName = StringUtils.cleanPath(file.getOriginalFilename());
        try {
            if(fileName.contains("..")) {
                throw new Exception("Filename contains invalid path sequence" + fileName);
            }

            Arquivo arquivo = new Arquivo(fileName, file.getContentType(), file.getBytes());
            return arquivoRepository.save(arquivo);
        } catch (Exception e) {
            throw new Exception("Could not save File: " + fileName);
        }
    }
}
