package com.senai.crud.services;


import com.senai.crud.dtos.CategoriaDto;
import com.senai.crud.dtos.ContatoDto;
import com.senai.crud.models.CategoriaModel;
import com.senai.crud.models.ContatoModel;
import com.senai.crud.models.ProdutoModel;
import com.senai.crud.repositories.ContatoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

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

    public boolean atualizar (Long id, ContatoDto contatoDto){

        Optional<ContatoModel> contatoOptional = repository.findById(id);

        if (contatoOptional.isPresent()){
            contatoOptional.get().setId(contatoDto.getId());
            contatoOptional.get().setNome(contatoDto.getNome());
            contatoOptional.get().setSigla(contatoDto.getSigla());

            repository.save(contatoOptional.get());
            return true;
        }
        return false;
    }

    public boolean remover(Long id){
        Optional<ContatoModel> contatoOptional = repository.findById(id);

        if(contatoOptional.isPresent()){
            repository.delete(contatoOptional.get());
            return true;
        }

        return false;
    }








}
