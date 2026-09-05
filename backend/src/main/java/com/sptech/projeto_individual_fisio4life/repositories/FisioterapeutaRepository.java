package com.sptech.projeto_individual_fisio4life.repositories;

import com.sptech.projeto_individual_fisio4life.entities.Clinica;
import com.sptech.projeto_individual_fisio4life.entities.Endereco;
import com.sptech.projeto_individual_fisio4life.entities.Fisioterapeuta;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;
@Repository
public class FisioterapeutaRepository {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    public FisioterapeutaRepository(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }


    public List<Fisioterapeuta> getAll(){

        String sql = """
            SELECT
                f.id AS fisioterapeuta_id,
                f.nome,
                f.cpf,
                f.data_nascimento,
                f.sexo,
                f.especialidade,
                f.clinica_id,
                f.ativo,
                f.endereco_id AS fk_endereco,
        
                e.id AS endereco_id,
                e.rua,
                e.numero,
                e.bairro,
                e.cidade,
                e.cep,
                e.complemento,
                
                c.nome_unidade,
                c.ativa,
                c.capacidade_fisioterapeutas,
                c.capacidade_pacientes,
                c.dt_abertura,
                c.tipo_unidade
            FROM Fisioterapeuta AS f
            JOIN Endereco AS e ON f.endereco_id = e.id
            JOIN Clinica AS c ON c.id = f.clinica_id;
    """;
        try {
            return jdbcTemplate.query(sql, (rs, rowNum) -> {
                Fisioterapeuta fisioterapeuta = new Fisioterapeuta();

                fisioterapeuta.setNome(rs.getString("nome"));
                fisioterapeuta.setCpf(rs.getString("cpf"));
                fisioterapeuta.setData_nascimento(rs.getObject("data_nascimento", Date.class));
                fisioterapeuta.setAtivo(rs.getObject("ativo", Boolean.class));
                fisioterapeuta.setSexo(rs.getString("sexo"));
                fisioterapeuta.setEspecialidade(rs.getString("especialidade"));
                fisioterapeuta.setClinica_id(rs.getInt("clinica_id"));

                Endereco endereco = new Endereco();


                endereco.setRua(rs.getString("rua"));
                endereco.setNumero(rs.getString("numero"));
                endereco.setBairro(rs.getString("bairro"));
                endereco.setCidade(rs.getString("cidade"));
                endereco.setCep(rs.getString("cep"));
                endereco.setComplemento(rs.getString("complemento"));

                fisioterapeuta.setEndereco(endereco);

                Clinica clinica = new Clinica();

                clinica.setNome_unidade(rs.getString("nome_unidade"));
                clinica.setAtiva(rs.getObject("ativa", Boolean.class));
                clinica.setCapacidade_fisioterapeutas(rs.getInt("capacidade_fisioterapeutas"));
                clinica.setCapacidade_pacientes(rs.getInt("capacidade_pacientes"));
                clinica.setDt_abertura(rs.getObject("dt_abertura", Date.class));
                clinica.setTipo_unidade(rs.getString("tipo_unidade"));

                fisioterapeuta.setClinica(clinica);

                return fisioterapeuta;
            });
        } catch (Exception e){
            System.out.println("Erro ao listar fisioterapeutas: " + e.getMessage());
            return null;
        }
    }

    public Integer create(Fisioterapeuta fisioterapeuta, Integer id_endereco){
        String sql = """
                    INSERT INTO Fisioterapeuta (nome, cpf, data_nascimento, sexo, especialidade, clinica_id, ativo, endereco_id) VALUES
                    (?, ?, ?, ?, ?, ?, ?, ?)
                """;
        try {
            return jdbcTemplate.update(
                    sql,
                    fisioterapeuta.getNome(),
                    fisioterapeuta.getCpf(),
                    fisioterapeuta.getData_nascimento(),
                    fisioterapeuta.getSexo(),
                    fisioterapeuta.getEspecialidade(),
                    fisioterapeuta.getClinica_id(),
                    fisioterapeuta.getAtivo(),
                    id_endereco
            );
        } catch (Exception e) {
            System.out.println("Erro ao inserir fisioterapeuta: " + e.getMessage());
            return -1;
        }

    }
}
