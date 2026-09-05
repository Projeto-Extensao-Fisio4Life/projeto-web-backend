package com.sptech.projeto_individual_fisio4life.usecases;

import com.sptech.projeto_individual_fisio4life.entities.Endereco;
import com.sptech.projeto_individual_fisio4life.repositories.EnderecoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class GetEndereco {

    @Autowired
    private EnderecoRepository enderecoRepository;

    public GetEndereco(EnderecoRepository enderecoRepository) {
        this.enderecoRepository = enderecoRepository;
    }

    public ResponseEntity<Endereco> execute(Integer id){

        try {
            Endereco endereco = enderecoRepository.getEndereco(id);

            return ResponseEntity.status(200).body(endereco);

        } catch (Exception e) {
            return ResponseEntity.status(400).build();
        }

    }
}
