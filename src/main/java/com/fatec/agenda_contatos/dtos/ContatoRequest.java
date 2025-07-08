package com.fatec.agenda_contatos.dtos;

public record ContatoRequest(
    String nome,
    String sobrenome,
    String dataNascimento,
    String telefone,
    String email,
    String endereco,
    String categoria,
    Boolean favorito,
    String notas,
    String redesSociais
) {
    
}
