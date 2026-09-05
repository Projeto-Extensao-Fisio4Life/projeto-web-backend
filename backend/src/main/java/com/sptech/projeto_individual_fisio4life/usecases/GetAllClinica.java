package com.sptech.projeto_individual_fisio4life.usecases;

import com.sptech.projeto_individual_fisio4life.entities.Clinica;
import com.sptech.projeto_individual_fisio4life.repositories.ClinicaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GetAllClinica {

    @Autowired
    private ClinicaRepository clinicaRepository;

    public GetAllClinica(ClinicaRepository clinicaRepository) {this.clinicaRepository = clinicaRepository;}

    public ResponseEntity<List<Clinica>> execute(){

        try {
            List<Clinica> clinicas = clinicaRepository.getAll();

            if (clinicas == null) {
                throw new Exception("Erro ao listar clínicas: " + null);
            }

            if (clinicas.isEmpty()) {
                return ResponseEntity.status(200).body(clinicas);
            }

            return ResponseEntity.status(200).body(clinicas);
        } catch (Exception e) {
            return ResponseEntity.status(400).build();
        }
    }

}
