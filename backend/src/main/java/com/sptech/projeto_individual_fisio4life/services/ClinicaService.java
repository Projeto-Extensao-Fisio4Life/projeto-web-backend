package com.sptech.projeto_individual_fisio4life.services;

import com.sptech.projeto_individual_fisio4life.entities.Clinica;
import com.sptech.projeto_individual_fisio4life.usecases.CreateClinica;
import com.sptech.projeto_individual_fisio4life.usecases.GetAllClinica;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ClinicaService {


    @Autowired
    private final GetAllClinica getAllClinica;
    private final CreateClinica createClinica;

    public ClinicaService(GetAllClinica getAllClinica, CreateClinica createClinica) {
        this.getAllClinica = getAllClinica;
        this.createClinica = createClinica;
    }

    public ResponseEntity<List<Clinica>> getAll(){
        return getAllClinica.execute();
    }

    public ResponseEntity<String> create(Clinica clinica){

        return createClinica.execute(clinica);

    }

}
