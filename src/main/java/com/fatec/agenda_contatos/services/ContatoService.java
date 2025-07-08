package com.fatec.agenda_contatos.services;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fatec.agenda_contatos.dtos.ContatoResponse;
import com.fatec.agenda_contatos.mappers.ContatoMapper;
import com.fatec.agenda_contatos.repositories.ContatoRepository;

@Service
public class ContatoService {

    @Autowired
    private ContatoRepository repository;

    public List<ContatoResponse> getAllContato() {
        return repository.findAll().stream().map(p -> ContatoMapper.toDTO(p)).collect(Collectors.toList());
    }



    
}
