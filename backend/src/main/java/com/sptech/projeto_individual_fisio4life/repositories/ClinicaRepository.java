package com.sptech.projeto_individual_fisio4life.repositories;

import com.sptech.projeto_individual_fisio4life.entities.Clinica;
import com.sptech.projeto_individual_fisio4life.entities.Endereco;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.http.ResponseEntity;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class ClinicaRepository {
    @Autowired
    private final JdbcTemplate jdbcTemplate;

    public ClinicaRepository(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public List<Clinica> getAll (){
        String sql = """
            SELECT
                c.id AS clinica_id,
                c.nome_unidade,
                c.capacidade_fisioterapeutas,
                c.capacidade_pacientes,
                c.tipo_unidade,
                c.ativa,
                c.dt_abertura,
        
                e.id AS endereco_id,
                e.rua,
                e.numero,
                e.bairro,
                e.cidade,
                e.cep,
                e.complemento
        
            FROM Clinica c
            JOIN Endereco e ON c.endereco_id = e.id
            """;

        try {
            return jdbcTemplate.query(sql, (rs, rowNum) -> {

                Endereco endereco = new Endereco();

                endereco.setId(rs.getInt("endereco_id"));
                endereco.setRua(rs.getString("rua"));
                endereco.setNumero(rs.getString("numero"));
                endereco.setBairro(rs.getString("bairro"));
                endereco.setCidade(rs.getString("cidade"));
                endereco.setCep(rs.getString("cep"));
                endereco.setComplemento(rs.getString("complemento"));

                Clinica clinica = new Clinica();

                clinica.setId(rs.getInt("clinica_id"));
                clinica.setNome_unidade(rs.getString("nome_unidade"));
                clinica.setCapacidade_fisioterapeutas(
                        rs.getInt("capacidade_fisioterapeutas")
                );
                clinica.setCapacidade_pacientes(
                        rs.getInt("capacidade_pacientes")
                );
                clinica.setEndereco_id(rs.getInt("endereco_id"));
                clinica.setTipo_unidade(rs.getString("tipo_unidade"));
                clinica.setAtiva(rs.getBoolean("ativa"));
                clinica.setDt_abertura(rs.getDate("dt_abertura"));

                clinica.setEndereco(endereco);

                return clinica;
            });
        } catch (Exception e) {
            System.out.println("Erro ao buscar clinicas: " + e.getMessage());
            return null;
        }
    }

    public Integer create(Clinica clinica, Integer id_endereco){

        try {
            String sql =  """
                    INSERT INTO Clinica (nome_unidade, capacidade_fisioterapeutas, capacidade_pacientes, tipo_unidade, ativa, dt_abertura, endereco_id) VALUES
                    (?, ?, ?, ?, ?, ?, ?);
                """;

            int linhas_afetadas = jdbcTemplate.update(
                    sql,
                    clinica.getNome_unidade(),
                    clinica.getCapacidade_fisioterapeutas(),
                    clinica.getCapacidade_pacientes(),
                    clinica.getTipo_unidade(),
                    clinica.getAtiva(),
                    clinica.getDt_abertura(),
                    id_endereco
            );
            System.out.println("Linhas afetadas: " + linhas_afetadas);
            if (linhas_afetadas == 1) {
                return linhas_afetadas;
            } else {
                throw new Exception();
            }
        } catch (Exception e) {
            System.out.println("Erro ao inserir no banco de dados: " + e.getMessage());
            return -1;
        }
    }

    public Integer delete(Integer id){
        if (id == null) {
            return -1;
        }

        try {
            String sql = """
                    DELETE FROM Clinica WHERE id = ?;
                    """;
            return jdbcTemplate.update(sql, id);

        } catch (Exception e){
            System.out.println("Erro ao deletar clínica: " + id);
            return -1;
        }
    }

}
