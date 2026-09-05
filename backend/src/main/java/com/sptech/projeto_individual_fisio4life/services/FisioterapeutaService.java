package com.sptech.projeto_individual_fisio4life.services;

import com.sptech.projeto_individual_fisio4life.entities.Fisioterapeuta;
import com.sptech.projeto_individual_fisio4life.usecases.CreateFisioterapeuta;
import com.sptech.projeto_individual_fisio4life.usecases.GetAllFisioterapeuta;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FisioterapeutaService {

    @Autowired
    private GetAllFisioterapeuta getAllFisioterapeuta;

    @Autowired
    private CreateFisioterapeuta createFisioterapeuta;

    public ResponseEntity<List<Fisioterapeuta>> getAll(){
        return getAllFisioterapeuta.execute();
    }

    public ResponseEntity<String> create(Fisioterapeuta fisioterapeuta){
        return createFisioterapeuta.execute(fisioterapeuta);
    }

}
