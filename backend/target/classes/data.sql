INSERT INTO endereco (rua, numero, bairro, cidade, cep, complemento) VALUES
('Rua das Acácias', '125', 'Centro', 'Osasco', '06016-040', 'Sala 201'),
('Avenida dos Autonomistas', '1840', 'Centro', 'Osasco', '06020-010', 'Conjunto 305'),
('Rua Antônio Agú', '456', 'Centro', 'Osasco', '06093-006', 'Sala 12'),
('Rua Dona Primitiva Vianco', '789', 'Centro', 'Osasco', '06016-040', '2º andar'),
('Avenida Hilário Pereira de Souza', '320', 'Centro', 'Osasco', '06010-020', 'Sala 104'),
('Rua José Cianciarullo', '87', 'Bela Vista', 'Osasco', '06070-120', 'Casa'),
('Rua Pedro Fioretti', '540', 'Centro', 'Osasco', '06010-050', 'Sala 8'),
('Rua Salem Bechara', '210', 'Centro', 'Osasco', '06018-180', 'Conjunto 10'),
('Avenida dos Remédios', '1500', 'Vila dos Remédios', 'Osasco', '06298-010', 'Sala 3'),
('Rua Narciso Sturlini', '95', 'Centro', 'Osasco', '06018-090', 'Térreo');


INSERT INTO clinica (nome_unidade, capacidade_fisioterapeutas, capacidade_pacientes, tipo_unidade, cnpj, ativa, dt_abertura, endereco_id) VALUES
('Fisio4Life Osasco', 10, 100, 'MATRIZ', '12345678000190', TRUE, '2020-03-15', 1),
('Movimento Fisioterapia', 8, 80, 'FILIAL', '23456789000181', TRUE, '2021-06-20', 2),
('Reabilitar Fisioterapia', 12, 120, 'FILIAL', '34567890000172', TRUE, '2019-09-10', 3),
('Equilíbrio Fisioterapia', 6, 60, 'FILIAL', '45678901000163', TRUE, '2022-01-25', 4),
('Vida em Movimento', 15, 150, 'MATRIZ', '56789012000154', TRUE, '2018-11-05', 5),
('Fisio Saúde Osasco', 7, 70, 'FILIAL', '67890123000145', TRUE, '2023-04-18', 6),
('Espaço Reabilitar', 9, 90, 'FILIAL', '78901234000136', TRUE, '2020-08-12', 7),
('Centro Integrado de Fisioterapia', 20, 200, 'MATRIZ', '89012345000127', TRUE, '2017-05-30', 8),
('Fisio Performance', 10, 100, 'FILIAL', '90123456000118', TRUE, '2022-10-07', 9),
('Clínica Movimento e Saúde', 8, 80, 'FILIAL', '01234567000109', TRUE, '2024-02-14', 10);

INSERT INTO Fisioterapeuta (nome, cpf, data_nascimento, sexo, especialidade, clinica_id, ativo, endereco_id) VALUES
  ('Carlos Eduardo Martins', '12345678901', '1988-05-14', 'Masculino', 'Fisioterapia Ortopédica', 1, TRUE, 1),
  ('Mariana Alves Costa', '23456789012', '1992-08-27', 'Feminino', 'Fisioterapia Esportiva', 1, TRUE, 2),
  ('Rafael Henrique Souza', '34567890123', '1985-11-03', 'Masculino', 'Fisioterapia Traumato-Ortopédica', 2, TRUE, 3),
  ('Juliana Ferreira Lima', '45678901234', '1995-02-19', 'Feminino', 'Fisioterapia Neurológica', 2, TRUE, 4),
  ('Gabriel Santos Oliveira', '56789012345', '1990-07-08', 'Masculino', 'Fisioterapia Esportiva', 3, TRUE, 5),
  ('Camila Rodrigues Mendes', '67890123456', '1987-12-21', 'Feminino', 'Fisioterapia Ortopédica', 3, TRUE, 6),
  ('Lucas Almeida Ribeiro', '78901234567', '1993-04-30', 'Masculino', 'Fisioterapia Traumato-Ortopédica', 4, TRUE, 7),
  ('Beatriz Martins Silva', '89012345678', '1991-09-16', 'Feminino', 'Fisioterapia Esportiva', 4, TRUE, 8),
  ('Felipe Augusto Rocha', '90123456789', '1989-01-25', 'Masculino', 'Fisioterapia Ortopédica', 5, TRUE, 9),
  ('Ana Clara Barbosa', '01234567890', '1996-06-11', 'Feminino', 'Fisioterapia Neurológica', 5, TRUE, 10);