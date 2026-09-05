package com.sptech.projeto_individual_fisio4life.usecases;

import com.sptech.projeto_individual_fisio4life.entities.Clinica;
import com.sptech.projeto_individual_fisio4life.repositories.ClinicaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

@Service
public class CreateClinica {

    @Autowired
    private ClinicaRepository clinicaRepository;

    @Autowired
    private CreateEndereco createEndereco;

    @Autowired
    private DeleteEndereco deleteEndereco;

    public CreateClinica(ClinicaRepository clinicaRepository, CreateEndereco createEndereco, DeleteEndereco deleteEndereco) {
        this.clinicaRepository = clinicaRepository;
        this.createEndereco = createEndereco;
        this.deleteEndereco = deleteEndereco;
    }

    public ResponseEntity<String> execute(Clinica clinica) {

        try {
            Integer id_endereco = createEndereco.execute(clinica.getEndereco());

            if (id_endereco == -1) {
                throw new Exception("Erro ao inserir endereço da clínica");
            }


            Integer linhas_afetadas =  clinicaRepository.create(clinica, id_endereco);

            if (linhas_afetadas == -1) {

                deleteEndereco.execute(id_endereco);

                throw new Exception("Erro ao criar clínica: " + clinica);

            }
            return ResponseEntity.status(201).body(
                    """
                        Clinica criada com sucesso! \n
                        Linhas afetadas:
                    """ + " " + linhas_afetadas
            );

        } catch (Exception e) {
            return ResponseEntity.status(400).body(e.getMessage());
        }
    }


}
