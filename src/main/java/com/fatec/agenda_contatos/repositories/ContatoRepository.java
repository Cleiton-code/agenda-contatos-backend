package com.fatec.agenda_contatos.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.fatec.agenda_contatos.entities.Contato;

public interface ContatoRepository extends JpaRepository<Contato, Long>{
    
}
