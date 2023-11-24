package com.eng.lgpd.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.eng.lgpd.models.Formulario;
import com.eng.lgpd.repositories.FormularioRepository;


@Service
public class FormularioService {

    @Autowired
    private FormularioRepository formularioRepository;

    public Formulario criarFormulario(Formulario formulario) {
        return formularioRepository.save(formulario);
    }
}