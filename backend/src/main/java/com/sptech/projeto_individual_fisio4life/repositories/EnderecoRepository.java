package com.sptech.projeto_individual_fisio4life.repositories;


import com.sptech.projeto_individual_fisio4life.entities.Endereco;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.http.ResponseEntity;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Repository;

import java.sql.PreparedStatement;
import java.sql.Statement;

@Repository
public class EnderecoRepository {

    @Autowired
    private final JdbcTemplate jdbcTemplate;

    public EnderecoRepository(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public Endereco getEndereco(Integer id){
        try {
            String sql = "SELECT * FROM Endereco WHERE id = ?";

            return jdbcTemplate.queryForObject(sql, Endereco.class, id);

        } catch (DataAccessException e) {
            return null;
        }
    }

    public Integer create(Endereco endereco) {
        try {
            String sql = """
                        INSERT INTO Endereco (rua, numero, bairro, cidade, cep, complemento) VALUES
                        (?, ?, ?, ?, ?, ?);
                    """;

            KeyHolder keyHolder = new GeneratedKeyHolder();

            int linhas_afetadas = jdbcTemplate.update(
                    con -> {
                        PreparedStatement ps = con.prepareStatement(
                                sql,
                                Statement.RETURN_GENERATED_KEYS
                        );
                        ps.setString(1, endereco.getRua());
                        ps.setString(2, endereco.getNumero());
                        ps.setString(3, endereco.getBairro());
                        ps.setString(4, endereco.getCidade());
                        ps.setString(5, endereco.getCep());
                        ps.setString(6, endereco.getComplemento());

                        return ps;
                    }, keyHolder);

            System.out.println("Linhas afetadas: " + linhas_afetadas);

            if (linhas_afetadas == 1) {
                System.out.println(
                        """
                           Endereço criado com sucesso! \n
                           Linhas afetadas:
                        """ + " " + linhas_afetadas
                );
                return keyHolder.getKey().intValue();
            }
            throw new Exception();
        } catch (Exception e) {
            System.out.println("Erro ao inserir no banco de dados: " + e.getMessage());
            return -1;
        }
    }

    public Integer delete(Integer id) {
        if (id == null) {
            return -1;
        }
        try {
            String sql = """
                    DELETE FROM Endereco WHERE id = ?;
                    """;
            return jdbcTemplate.update(sql, id);

        } catch (Exception e) {
            System.out.println("Erro ao deletar endereço: " + id);
            return -1;
        }
    }

}
