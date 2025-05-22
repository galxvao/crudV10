package com.senai.crud.dtos;

import com.senai.crud.models.ContatoModel;

public class ContatoDto {

    private Long id;
    private String nome;
    private String sigla;

    public ContatoDto() {
    }

    public ContatoDto(ContatoModel model){
        this.id = model.getId();
        this.nome = model.getNome();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getSigla() {
        return sigla;
    }

    public void setSigla(String sigla) {
        this.sigla = sigla;
    }
}
