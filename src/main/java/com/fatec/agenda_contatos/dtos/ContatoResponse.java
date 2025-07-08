package com.fatec.agenda_contatos.dtos;

public record ContatoResponse(    
    Long id,
    String nome,
    String sobrenome,
    String dataNascimento,
    String telefone,
    String email,
    String endereco,
    String categoria,
    Boolean favorito,
    String notas,
    String redesSociais) {
    
}
