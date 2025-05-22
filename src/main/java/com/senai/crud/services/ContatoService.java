package com.senai.crud.services;


import com.senai.crud.dtos.ContatoDto;
import com.senai.crud.models.ContatoModel;
import com.senai.crud.repositories.ContatoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ContatoService {

    @Autowired
    ContatoRepository repository;

    public List<ContatoDto> obterContatos(){

        List<ContatoModel> listaContatos = repository.findAll();

        List<ContatoDto> lista =  new ArrayList<>();

        for (ContatoModel contato : listaContatos){
            ContatoDto contatoDto =  new ContatoDto();

            contatoDto.setId(contato.getId());
            contatoDto.setNome(contato.getNome());
            contatoDto.setSigla(contato.getSigla());

            lista.add(contatoDto);
        }
        return lista;
    }

    public Boolean adicionar(ContatoDto contatoDto){

        ContatoModel contatoModel = new ContatoModel();

        contatoModel.setNome(contatoDto.getNome());
        contatoModel.setSigla(contatoDto.getSigla());

        repository.save(contatoModel);

        return true;

    }











}
