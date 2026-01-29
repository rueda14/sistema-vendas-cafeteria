# Sistema de Vendas para Cafeteria  
## Aplicação Java Desktop com Arquitetura MVC

Este repositório contém uma aplicação **Java Desktop** desenvolvida como projeto acadêmico, com o objetivo de implementar um sistema completo de gerenciamento para uma cafeteria. O projeto simula cenários reais de operação, envolvendo controle administrativo, gerenciamento de produtos, funcionários e registro de vendas, integrando interface gráfica, regras de negócio e persistência em banco de dados relacional.

O sistema foi projetado com foco em **organização de código**, **separação de responsabilidades** e **aplicação prática dos conceitos estudados** ao longo da graduação, servindo tanto como exercício acadêmico quanto como material de portfólio.

---

## Visão Geral do Sistema

A aplicação permite que uma cafeteria controle seus dados operacionais por meio de uma interface gráfica intuitiva. Desde o primeiro acesso, o sistema garante que apenas usuários autorizados possam realizar operações sensíveis, como configurações administrativas e exclusão de dados.

O fluxo do sistema contempla desde o cadastro inicial de um administrador até a realização de vendas, passando por processos intermediários como cadastro, edição, pesquisa e validação de informações.

---

## Funcionalidades Implementadas

### Controle de Acesso e Administração
- Cadastro inicial de administrador no primeiro acesso ao sistema  
- Autenticação de administrador para acesso a funcionalidades restritas  
- Validação de credenciais antes de ações críticas  

### Gerenciamento de Cadastros
- Cadastro, edição e pesquisa de produtos  
- Cadastro, edição e pesquisa de categorias  
- Cadastro, edição e pesquisa de funcionários  
- Geração automática de identificadores (ID)  

### Operações de Venda
- Seleção de produtos e funcionários  
- Definição dinâmica de quantidades  
- Cálculo automático de preço unitário, subtotal e valor total  
- Confirmação ou cancelamento da venda  
- Remoção de itens antes da finalização  

### Pesquisa e Consulta de Dados
- Pesquisa dinâmica de produtos, funcionários e vendas  
- Filtragem em tempo real por nome ou identificador  
- Visualização detalhada dos registros  

### Manutenção e Segurança de Dados
- Reset seletivo de tabelas do banco de dados  
- Confirmação explícita antes de exclusões  
- Restrição de operações sensíveis ao administrador  

---

## Arquitetura da Aplicação

O projeto segue o padrão **MVC (Model–View–Controller)**, promovendo uma separação clara entre dados, regras de negócio e interface gráfica.

### Model
Responsável por representar as entidades do sistema e seus atributos, refletindo diretamente a estrutura do banco de dados. Inclui classes como produtos, categorias, funcionários, vendas e itens de venda.

### Controller
Camada responsável pela comunicação com o banco de dados e pela aplicação das regras de negócio. Utiliza o padrão **DAO (Data Access Object)** para encapsular operações de persistência e manter o código organizado e reutilizável.

### View
Camada de apresentação composta por interfaces gráficas desenvolvidas com **Java Swing**, utilizando o NetBeans GUI Builder. Todas as telas são isoladas da lógica de negócio, garantindo maior manutenibilidade.

Essa arquitetura facilita futuras evoluções do sistema, como a substituição da interface gráfica ou migração para outra tecnologia.

---

## Banco de Dados

A aplicação utiliza um banco de dados relacional estruturado para garantir consistência e integridade das informações. O modelo contempla tabelas para administradores, funcionários, categorias, produtos, vendas e itens de venda.

O banco de dados foi projetado com:
- Chaves primárias para identificação única dos registros  
- Chaves estrangeiras para garantir relacionamentos corretos  
- Integridade referencial entre vendas, produtos e funcionários  

## Script SQL – Criação do Banco de Dados

A seguir está o script SQL utilizado para a criação das tabelas do banco de dados do sistema.

### Tabela de Funcionários

CREATE TABLE tb_funcionarios (
    id SERIAL PRIMARY KEY,
    nome VARCHAR(120) NOT NULL,
    email VARCHAR(100) NOT NULL,
    senha VARCHAR(32) NOT NULL
);

### Tabela de Administrador

CREATE TABLE tb_admin (
    id SERIAL PRIMARY KEY,
    nome VARCHAR(120) NOT NULL,
    email VARCHAR(100) NOT NULL,
    senha VARCHAR(32) NOT NULL
);

### Tabela de Categoria

CREATE TABLE tb_categorias (
    id SERIAL PRIMARY KEY,
    nome VARCHAR(50) NOT NULL
);

### Tabela de Produtos

CREATE TABLE tb_produtos (
    id SERIAL PRIMARY KEY,
    nome VARCHAR(100) NOT NULL,
    preco NUMERIC(6,2) NOT NULL,
    descricao TEXT,
    id_categoria INT NOT NULL,
    FOREIGN KEY (id_categoria) REFERENCES tb_categorias(id)
);

### Tabela de Vendas

CREATE TABLE tb_vendas (
    id SERIAL PRIMARY KEY,
    id_funcionario INT NOT NULL,
    data_venda TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    valor_total NUMERIC(10,2),
    FOREIGN KEY (id_funcionario) REFERENCES tb_funcionarios(id)
);


### Tabela de Itens de Venda

CREATE TABLE tb_itens_vendas (
    id SERIAL PRIMARY KEY,
    id_venda INT NOT NULL,
    id_produto INT NOT NULL,
    quantidade INT NOT NULL,
    preco_unitario NUMERIC(10,2) NOT NULL,
    FOREIGN KEY (id_venda) REFERENCES tb_vendas(id),
    FOREIGN KEY (id_produto) REFERENCES tb_produtos(id)
);


## Tecnologias Utilizadas

- Java  
- Java Swing (Interface Gráfica)  
- JDBC  
- Apache Ant  
- NetBeans  
- Banco de dados relacional (PostgreSQL ou compatível)  

---

## Execução do Projeto

Para executar a aplicação, é necessário clonar o repositório, abrir o projeto no NetBeans, configurar o banco de dados utilizando o script SQL fornecido e ajustar as credenciais de conexão na classe responsável pelo acesso ao banco. Após essa configuração, o sistema pode ser executado diretamente pelo ambiente de desenvolvimento.

---

## Documentação Técnica

O projeto possui um **Relatório Técnico detalhado**, que documenta:
- Estrutura do projeto  
- Interfaces gráficas da aplicação  
- Fluxos completos de uso  
- Regras de negócio  
- Script SQL  
- Modelo físico do banco de dados  

Esse relatório foi utilizado como base para validação funcional e organização do sistema.

---

## Autores

**Diego Rueda**  
**Nicole Inoue**  

Projeto desenvolvido para fins acadêmicos e educacionais.

---

## Considerações Finais

Este projeto foi desenvolvido com o objetivo de consolidar conhecimentos em programação orientada a objetos, desenvolvimento de aplicações desktop em Java, arquitetura MVC, modelagem de banco de dados e integração entre interface gráfica e persistência de dados. O sistema pode servir como base para estudos futuros, refatorações ou expansão para novas arquiteturas e tecnologias.
