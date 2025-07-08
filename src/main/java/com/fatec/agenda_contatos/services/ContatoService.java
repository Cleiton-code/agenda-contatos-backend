package com.fatec.agenda_contatos.services;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fatec.agenda_contatos.dtos.ContatoRequest;
import com.fatec.agenda_contatos.dtos.ContatoResponse;
import com.fatec.agenda_contatos.entities.Contato;
import com.fatec.agenda_contatos.mappers.ContatoMapper;
import com.fatec.agenda_contatos.repositories.ContatoRepository;

import jakarta.persistence.EntityNotFoundException;

@Service
public class ContatoService {

    @Autowired
    private ContatoRepository repository;

    public List<ContatoResponse> getAllContato() {
        return repository.findAll().stream().map(p -> ContatoMapper.toDTO(p)).collect(Collectors.toList());
    }

    public ContatoResponse getContatoById(Long id){
        Contato contato = repository.findById(id).orElseThrow(
            () -> new EntityNotFoundException("Produto não cadastrado")
        );

        return ContatoMapper.toDTO(contato);
    }

    public ContatoResponse save(ContatoRequest contato){
        Contato newContato = repository.save(ContatoMapper.toEntity(contato));
        return ContatoMapper.toDTO(newContato);
    }

        public void update(ContatoRequest contato, Long id){
        Contato aux = repository.getReferenceById(id);

        aux.setCategoria(contato.categoria());
        aux.setDataNascimento(contato.dataNascimento());
        aux.setEmail(contato.email());
        aux.setEndereco(contato.endereco());
        aux.setFavorito(contato.favorito());
        aux.setNome(contato.nome());
        aux.setNotas(contato.notas());
        aux.setSobrenome(contato.sobrenome());
        aux.setRedesSociais(contato.redesSociais());
        aux.setTelefone(contato.telefone());

        repository.save(aux);
    }

    public void delete (Long id){
        if (repository.existsById(id)) {

            repository.deleteById(id);
            
        }else{
            throw new EntityNotFoundException("Produto não cadastrado");
        }
    }
    
}
