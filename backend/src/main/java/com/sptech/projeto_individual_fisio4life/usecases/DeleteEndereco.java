package com.sptech.projeto_individual_fisio4life.usecases;

import com.sptech.projeto_individual_fisio4life.entities.Endereco;
import com.sptech.projeto_individual_fisio4life.repositories.EnderecoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service

public class DeleteEndereco {

    @Autowired
    private EnderecoRepository enderecoRepository;


    public DeleteEndereco(EnderecoRepository enderecoRepository) {
        this.enderecoRepository = enderecoRepository;
    }

    public ResponseEntity<String> execute(Integer id){

        try {
            Integer linhas_afetadas = enderecoRepository.delete(id);

            if (linhas_afetadas == -1) {
                throw new Exception("Erro ao criar endereço");
            }

            return ResponseEntity.status(204).build();

        } catch (Exception e) {
            return ResponseEntity.status(400).body("Erro ao deletar endereço: " + e.getMessage());
        }
    }

}
