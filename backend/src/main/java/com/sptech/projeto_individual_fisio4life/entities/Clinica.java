package com.sptech.projeto_individual_fisio4life.entities;

import java.util.Date;

public class Clinica {

    private Integer id;


    private String nome_unidade;
    private Integer capacidade_fisioterapeutas;
    private Integer capacidade_pacientes;
    private String tipo_unidade;
    private Boolean ativa;
    private Date dt_abertura;
    private Endereco endereco;
    private Integer endereco_id;

    public Clinica() {
    }



    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Endereco getEndereco() {
        return endereco;
    }

    public void setEndereco(Endereco endereco) {
        this.endereco = endereco;
    }

    public String getNome_unidade() {
        return nome_unidade;
    }

    public void setNome_unidade(String nome_unidade) {
        this.nome_unidade = nome_unidade;
    }

    public Integer getCapacidade_fisioterapeutas() {
        return capacidade_fisioterapeutas;
    }

    public void setCapacidade_fisioterapeutas(Integer capacidade_fisioterapeutas) {
        this.capacidade_fisioterapeutas = capacidade_fisioterapeutas;
    }

    public Integer getCapacidade_pacientes() {
        return capacidade_pacientes;
    }

    public void setCapacidade_pacientes(Integer capacidade_pacientes) {
        this.capacidade_pacientes = capacidade_pacientes;
    }

    public String getTipo_unidade() {
        return tipo_unidade;
    }

    public void setTipo_unidade(String tipo_unidade) {
        this.tipo_unidade = tipo_unidade;
    }

    public Boolean getAtiva() {
        return ativa;
    }

    public void setAtiva(Boolean ativa) {
        this.ativa = ativa;
    }

    public Date getDt_abertura() {
        return dt_abertura;
    }

    public void setDt_abertura(Date dt_abertura) {
        this.dt_abertura = dt_abertura;
    }


    public Integer getEndereco_id() {
        return endereco_id;
    }

    public void setEndereco_id(Integer endereco_id) {
        this.endereco_id = endereco_id;
    }
}
