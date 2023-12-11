package com.eng.lgpd.services;

import org.hibernate.ObjectNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

import com.eng.lgpd.models.Respostas;
import com.eng.lgpd.repositories.RespostasRepository;

@Service
public class RespostasService {
    @Autowired
    private RespostasRepository respostaRepository;

    public List<Respostas> obterTodasAsRespostas() {
        return respostaRepository.findAll();
    }

    public Respostas obterRespostaPorId(Long id) {
        Optional<Respostas> obj = respostaRepository.findById(id);
        return obj.orElseThrow(() -> new ObjectNotFoundException("Objeto não encontrado!", null));
    }

    public Respostas salvarResposta(Respostas resposta) {
        return respostaRepository.save(resposta);
    }
}
