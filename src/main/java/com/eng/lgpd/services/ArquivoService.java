package com.eng.lgpd.services;

import com.eng.lgpd.models.Arquivo;
import org.springframework.web.multipart.MultipartFile;

public interface ArquivoService {
    Arquivo saveArquivo(MultipartFile file) throws Exception;

}
