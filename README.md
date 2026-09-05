
# Aplicação Web — Fisio4Life

Sistema web desenvolvido para gerenciamento de uma clínica de fisioterapia, com foco no cadastro e gerenciamento de informações da clínica, fisioterapeutas e demais recursos relacionados ao atendimento.

A aplicação é composta por um **Front-end desenvolvido com tecnologias nativas da Web** e um **Back-end desenvolvido em Java utilizando Spring Boot**, com comunicação através de uma API REST.

---

## 🚀 Tecnologias utilizadas

### Front-end

* HTML5
* CSS3
* JavaScript Vanilla
* Fetch API
* Manipulação do DOM

O Front-end não utiliza frameworks ou bibliotecas externas (Por enquanto).

### Back-end

* Java
* Spring Boot
* Spring Web
* JDBC / JdbcTemplate
* API REST

### Banco de dados

* H2 Database

---

## 🏗️ Arquitetura

A aplicação segue uma arquitetura dividida em duas partes principais:

```text
┌──────────────────────────┐
│        FRONT-END         │
│                          │
│ HTML5                    │
│ CSS3                     │
│ JavaScript               │
└────────────┬─────────────┘
             │
             │ HTTP / JSON
             ▼
┌──────────────────────────┐
│         BACK-END         │
│                          │
│ Java                     │
│ Spring Boot              │
│ API REST                 │
│ JdbcTemplate             │
└────────────┬─────────────┘
             │
             ▼
┌──────────────────────────┐
│        BANCO H2          │
└──────────────────────────┘
```

O Front-end realiza requisições HTTP para a API disponibilizada pelo Back-end. Os dados são enviados e recebidos no formato JSON.

---

## 📁 Estrutura do projeto

### Front-end

```text
frontend/
├── imgs/
├── cadastro_clinica.html
├── cadastro_fisioterapeuta.html
├── fisioterapeutas.html
└── style.css
```

O JavaScript é implementado diretamente dentro do arquivo `index.html`, utilizando JavaScript puro.

### Back-end

```text
backend/
└── projeto-individual-fisio4life/
    ├── src/
    │   └── main/
    │       ├── java/
    │       │   └── ...
    │       └── resources/
    │           ├── application.properties
    │           └── schema.sql
    └── pom.xml
```

---

## ⚙️ Funcionalidades

Entre as principais funcionalidades da aplicação estão:

* Cadastro de clínicas;
* Consulta de clínicas cadastradas;
* Cadastro de fisioterapeutas;
* Consulta de fisioterapeutas;
* Gerenciamento de endereços;
* Validação dos dados enviados pelo usuário;
* Comunicação entre Front-end e Back-end através de API REST;
* Persistência de dados no banco de dados;
* Retorno de mensagens de sucesso e erro para o usuário.

Novas funcionalidades serão adicionadas posteriormente conforme a evolução do sistema.

---

## 🔌 Comunicação com a API

O Front-end utiliza a função `fetch()` do JavaScript para realizar as requisições para o Back-end.

Exemplo:

```javascript
fetch('http://localhost:8080/clinicas', {
    method: 'POST',
    headers: {
        'Content-Type': 'application/json'
    },
    body: JSON.stringify(dados)
})
```

As informações são enviadas para os endpoints disponibilizados pela API.

### Exemplo de endpoint

```text
POST /clinicas
```

Exemplo de requisição:

```json
{
    "nome_unidade": "Fisio4Life Mooca",
    "capacidade_fisioterapeutas": 10,
    "capacidade_pacientes": 100,
    "tipo_unidade": "Matriz",
    "ativa": true,
    "dt_abertura": "2007-05-10",
    "endereco": {
        "rua": "Rua exemplo",
        "numero": "100",
        "bairro": "Mooca",
        "cidade": "São Paulo",
        "cep": 03100000,
        "complemento": "Sala 10"
    }
}
```

---

## 🛠️ Pré-requisitos

Para executar o projeto, é necessário possuir instalado:

* Java JDK 21 ou superior;
* Maven;
* Git;
* Navegador Web.

---

## ▶️ Executando o Back-end

Clone o repositório:

```bash
git clone <URL_DO_REPOSITORIO>
```

Acesse a pasta do Back-end:

```bash
cd backend/projeto-individual-fisio4life
```

Execute a aplicação utilizando o Maven:

### Windows

```bash
mvnw.cmd spring-boot:run
```

### Linux / macOS

```bash
./mvnw spring-boot:run
```

O servidor será iniciado, por padrão, em:

```text
http://localhost:8080
```

---

## 🌐 Executando o Front-end

Após iniciar o Back-end, abra o arquivo:

```text
frontend/cadastro_clinica.html
```

em um navegador.

O Front-end realizará as requisições para:

```text
http://localhost:8080
```

É necessário que o Back-end esteja em execução para que as operações que dependem da API funcionem corretamente.

---

## 📊 Banco de dados

O projeto utiliza o **H2 Database** para armazenamento dos dados durante o desenvolvimento.

As tabelas são criadas conforme o script SQL configurado no projeto.

Entre as principais entidades estão:

```text
Clinica
Endereco
Fisioterapeuta
```

O relacionamento entre as entidades permite centralizar as informações necessárias para o gerenciamento da clínica.

---

## 🔒 Validação

A aplicação possui validações tanto no Front-end quanto no Back-end.

### Front-end

São realizadas validações para evitar o envio de informações inválidas ou incompletas.

### Back-end

O Spring Boot realiza a validação dos dados recebidos pela API antes de realizar a persistência no banco de dados.

Essa abordagem evita que dados inválidos sejam armazenados mesmo que a validação do Front-end seja ignorada.

---

## 📡 API REST

A comunicação entre as camadas utiliza o padrão REST.

```text
Front-end
    │
    │ HTTP Request
    ▼
Controller
    │
    ▼
Service
    │
    ▼
Use Case
    │
    ▼
Repository / JdbcTemplate
    │
    ▼
Database
```

As respostas da API são retornadas utilizando códigos HTTP apropriados, como:

```text
200 OK
201 Created
400 Bad Request
404 Not Found
500 Internal Server Error
```

---

## 🎨 Interface

A interface utiliza uma abordagem simples e responsiva, utilizando exclusivamente:

* HTML5 para estrutura;
* CSS3 para estilização;
* JavaScript para comportamento e integração com a API.

Não são utilizados frameworks como React, Angular, Vue ou bibliotecas externas de JavaScript.

---

## 🔮 Próximas evoluções

O sistema irá futuramente receber novas funcionalidades, como:

* Sistema de autenticação;
* Controle de usuários e permissões;
* Agendamento de consultas;
* Gerenciamento de pacientes;
* Agenda individual dos fisioterapeutas;
* Controle de disponibilidade;
* Histórico de atendimentos;
* Dashboard administrativo;
* Relatórios;
* Notificações de agendamento;
* Integração com serviços externos.

---

## 👨‍💻 Projeto

Projeto desenvolvido como parte do **Projeto Individual de Programação Web**, aplicando conceitos de desenvolvimento Front-end, Back-end, APIs REST, banco de dados e integração entre sistemas.

---

## 📄 Licença

Este projeto possui finalidade acadêmica e educacional.
