package com.sptech.projeto_individual_fisio4life.usecases;

import com.sptech.projeto_individual_fisio4life.entities.Fisioterapeuta;
import com.sptech.projeto_individual_fisio4life.repositories.FisioterapeutaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GetAllFisioterapeuta {

    @Autowired
    private FisioterapeutaRepository fisioterapeutaRepository;

    public GetAllFisioterapeuta(FisioterapeutaRepository fisioterapeutaRepository) {
        this.fisioterapeutaRepository = fisioterapeutaRepository;
    }

    public ResponseEntity<List<Fisioterapeuta>> execute(){
        List<Fisioterapeuta> fisioterapeutas = fisioterapeutaRepository.getAll();

        if (fisioterapeutas == null) {
            return ResponseEntity.status(400).build();
        }
        if (fisioterapeutas.size() == 0) {
            return ResponseEntity.status(204).build();
        }

        return ResponseEntity.status(200).body(fisioterapeutas);
    }
}
