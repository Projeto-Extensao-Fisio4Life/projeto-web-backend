package com.sptech.projeto_individual_fisio4life.usecases;

import com.sptech.projeto_individual_fisio4life.entities.Fisioterapeuta;
import com.sptech.projeto_individual_fisio4life.repositories.FisioterapeutaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class CreateFisioterapeuta {

    @Autowired
    private FisioterapeutaRepository fisioterapeutaRepository;

    @Autowired
    private CreateEndereco createEndereco;

    @Autowired
    private DeleteEndereco deleteEndereco;

    public CreateFisioterapeuta(FisioterapeutaRepository fisioterapeutaRepository, CreateEndereco createEndereco, DeleteEndereco deleteEndereco) {
        this.fisioterapeutaRepository = fisioterapeutaRepository;
        this.createEndereco = createEndereco;
        this.deleteEndereco = deleteEndereco;
    }

    public ResponseEntity<String> execute(Fisioterapeuta fisioterapeuta){

        Integer id_endereco = createEndereco.execute(fisioterapeuta.getEndereco());

        if (id_endereco == -1) {
            return ResponseEntity.status(400).build();
        }


        Integer linhas_afetadas = fisioterapeutaRepository.create(fisioterapeuta, id_endereco);

        if (linhas_afetadas == 1) {
            return ResponseEntity.status(201).body("Fisioterapeuta criado com sucesso!");
        }

        int retry = 5;
        for (int i = 0; i < retry; i++) {
            ResponseEntity<String> resposta_delete = deleteEndereco.execute(id_endereco);
            if (resposta_delete.getStatusCode().equals(HttpStatus.NO_CONTENT)) {
                break;
            }
            if (i == 4) {
                return ResponseEntity.status(400).body("Erro ao criar fisioterapeuta e ao deletar o endereço!");
            }
        }

        return ResponseEntity.status(400).body("Erro ao criar fisioterapeuta!");

    }

}
