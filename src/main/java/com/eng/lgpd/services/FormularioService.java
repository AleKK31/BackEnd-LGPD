package com.eng.lgpd.services;

import java.util.List;
import java.util.Optional;


import org.hibernate.ObjectNotFoundException;
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

    public List<Formulario> findAll() {
        return formularioRepository.findAll();
    }

    public Formulario findById(Long id) {
        Optional<Formulario> obj = formularioRepository.findById(id);
        return obj.orElseThrow(() -> new ObjectNotFoundException("Objeto não encontrado!", null));
    }

}