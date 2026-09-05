package com.sptech.projeto_individual_fisio4life.controllers;

import com.sptech.projeto_individual_fisio4life.entities.Clinica;
import com.sptech.projeto_individual_fisio4life.services.ClinicaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/clinicas")
@CrossOrigin(origins = "http://127.0.0.1:5500/")
public class ClinicaController {

    @Autowired
    private final ClinicaService clinicaService;

    public ClinicaController(ClinicaService service) {
        this.clinicaService = service;
    }

    @GetMapping()
    public ResponseEntity<List<Clinica>> getAll (){
        return clinicaService.getAll();
    }


    @PostMapping()
    public ResponseEntity<String> create(@RequestBody Clinica clinica){
        try {
            if (clinica.getNome_unidade() == null || clinica.getNome_unidade().isBlank()) {
                throw new IllegalArgumentException("O nome da unidade é obrigatório.");
            }

            if (clinica.getCapacidade_fisioterapeutas() == null || clinica.getCapacidade_fisioterapeutas() <= 0) {
                throw new IllegalArgumentException("A capacidade de fisioterapeutas deve ser maior que 0.");
            }

            if (clinica.getCapacidade_pacientes() == null || clinica.getCapacidade_pacientes() <= 0) {
                throw new IllegalArgumentException("A capacidade de pacientes deve ser maior que 0.");
            }

            if (clinica.getTipo_unidade() == null || clinica.getTipo_unidade().isBlank()) {
                throw new IllegalArgumentException("O tipo da unidade é obrigatório.");
            }

            if (clinica.getAtiva() == null) {
                throw new IllegalArgumentException("O campo ativa deve ser informado.");
            }

            if (clinica.getDt_abertura() == null) {
                throw new IllegalArgumentException("A data de abertura é obrigatória.");
            }

            if (clinica.getEndereco() == null) {
                throw new IllegalArgumentException("O endereço é obrigatório.");
            }
            if (clinica.getEndereco().getRua() == null ||
                    clinica.getEndereco().getRua().isBlank()) {

                throw new IllegalArgumentException("A rua é obrigatória.");
            }

            if (clinica.getEndereco().getNumero() == null ||
                    clinica.getEndereco().getNumero().isBlank()) {

                throw new IllegalArgumentException("O número é obrigatório.");
            }

            if (clinica.getEndereco().getBairro() == null ||
                    clinica.getEndereco().getBairro().isBlank()) {

                throw new IllegalArgumentException("O bairro é obrigatório.");
            }

            if (clinica.getEndereco().getCidade() == null ||
                    clinica.getEndereco().getCidade().isBlank()) {

                throw new IllegalArgumentException("A cidade é obrigatória.");
            }

            if (clinica.getEndereco().getCep() == null) {

                throw new IllegalArgumentException("O CEP é obrigatório.");
            }

            if (clinica.getEndereco().getCep().length() != 8) {

                throw new IllegalArgumentException("O CEP deve conter 8 dígitos.");

            }



            return clinicaService.create(clinica);

        } catch (Exception e) {
            return ResponseEntity.status(400).build();
        }



    }
}
