package com.senai.crud.controllers;

import com.senai.crud.dtos.ContatoDto;
import com.senai.crud.dtos.ProdutoDto;
import com.senai.crud.services.ContatoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/contato")
public class ContatoController {

    @Autowired
    ContatoService service;


    @PostMapping
    public String adicionar (@ModelAttribute ("contatoDto") ContatoDto contatoDto ) {

        boolean retorno = service.adicionar(contatoDto);


        if (retorno){
            return "redirect:/contatolista";
        }

        return "redirect:/contatocadastro?erro";
    }

    @PostMapping("/{id}")
    public String atualizar(@ModelAttribute("contatoDto") ContatoDto contatoDto, @PathVariable Long id){

        boolean retorno = false;

        retorno = service.atualizar(id, contatoDto);

        if(retorno) {
            return "redirect:/contatolista";
        }

        return "redirect:/contatoatualizar/" + id.toString() + "?erro";
    }





}






