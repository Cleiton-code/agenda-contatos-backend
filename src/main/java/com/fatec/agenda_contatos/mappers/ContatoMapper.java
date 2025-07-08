package com.fatec.agenda_contatos.mappers;

import com.fatec.agenda_contatos.dtos.ContatoRequest;
import com.fatec.agenda_contatos.dtos.ContatoResponse;
import com.fatec.agenda_contatos.entities.Contato;

public class ContatoMapper {
    public static ContatoResponse toDTO(Contato contato){
        return new ContatoResponse(
            contato.getId(),
            contato.getNome(),
            contato.getSobrenome(),
            contato.getDataNascimento(),
            contato.getTelefone(),
            contato.getEmail(),
            contato.getEndereco(),
            contato.getCategoria(),
            contato.getFavorito(),
            contato.getNotas(),
            contato.getRedesSociais()

        );
    }

    public static Contato toEntity(ContatoRequest contatoRequest){
        Contato contato = new Contato();
        contato.setNome(contatoRequest.nome());
        contato.setSobrenome(contatoRequest.sobrenome());
        contato.setDataNascimento(contatoRequest.dataNascimento());
        contato.setTelefone(contatoRequest.telefone());
        contato.setEmail(contatoRequest.email());
        contato.setEndereco(contatoRequest.endereco());
        contato.setCategoria(contatoRequest.categoria());
        contato.setFavorito(contatoRequest.favorito());
        contato.setNotas(contatoRequest.notas());
        contato.setRedesSociais(contatoRequest.redesSociais());
    
    
    return contato;
    }

}
