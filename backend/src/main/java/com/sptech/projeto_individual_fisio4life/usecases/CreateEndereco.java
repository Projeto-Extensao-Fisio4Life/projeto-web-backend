package com.sptech.projeto_individual_fisio4life.usecases;

import com.sptech.projeto_individual_fisio4life.entities.Endereco;
import com.sptech.projeto_individual_fisio4life.repositories.EnderecoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class CreateEndereco {


    @Autowired
    private EnderecoRepository enderecoRepository;


    public CreateEndereco(EnderecoRepository enderecoRepository) {
        this.enderecoRepository = enderecoRepository;
    }

    public Integer execute(Endereco endereco){

        try {
            Integer id_endereco = enderecoRepository.create(endereco);

            if (id_endereco == -1) {
                throw new Exception("Erro ao criar endereço");
            }

            return id_endereco;

        } catch (Exception e) {
            return -1;
        }
    }


}
