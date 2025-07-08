package com.fatec.agenda_contatos.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fatec.agenda_contatos.dtos.ContatoRequest;
import com.fatec.agenda_contatos.dtos.ContatoResponse;
import com.fatec.agenda_contatos.services.ContatoService;

@RestController
@RequestMapping("contatos")
public class ContatoController {
    
    @Autowired
    private ContatoService service;

    @GetMapping
    public ResponseEntity<List<ContatoResponse>> getContatos(){
        return ResponseEntity.ok(service.getAllContato());
    }

    @GetMapping("{id}")
    public ResponseEntity<ContatoResponse> getContato(@PathVariable Long id){
        return ResponseEntity.ok(service.getContatoById(id));
    }

    @PostMapping()
    public ResponseEntity<ContatoResponse> saveContato(@Validated @RequestBody ContatoRequest contato){
        ContatoResponse newContato = service.save(contato);
        return ResponseEntity.created(null).body(newContato);
    }

    @PutMapping("{id}")
    public ResponseEntity<Void>updateContato(@PathVariable Long id, @Validated @RequestBody ContatoRequest contato){
        service.update(contato, id);

        return ResponseEntity.ok().build();
    }

    @DeleteMapping("{id}")
    public ResponseEntity<Void> deleteContato(@PathVariable Long id){
        service.delete(id);

        return ResponseEntity.noContent().build();
    }


}
