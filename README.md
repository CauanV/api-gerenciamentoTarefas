# Gerenciador de Tarefas com Spring Boot

Este é um projeto simples para fins de aprendizado. O objetivo principal foi compreender o funcionamento de:

- Autenticação com JWT
- Cadastro e login de usuários
- Comunicação entre frontend HTML simples e backend Spring Boot
- Criação e listagem de tarefas associadas ao usuário autenticado

## Tecnologias utilizadas

- Java 17
- Spring Boot
- Spring Security
- JPA + MySQL
- HTML + JavaScript (puro)

## Observações

Este projeto **não possui testes automatizados**, **tratamento avançado de exceções**, nem **validações robustas**. Foco principal: aprendizado prático.

## Como executar o projeto

### Pré-requisitos
- Java 17+
- Maven
- MySQL

### Configuração do banco de dados

1. Crie um banco de dados no MySQL com o nome `todo_db`.
2. No arquivo `src/main/resources/application.properties`, insira suas credenciais do banco:

```properties
spring.datasource.url=jdbc:mysql://localhost:3306/todo_db
spring.datasource.username=seu_usuario
spring.datasource.password=sua_senha

spring.jpa.hibernate.ddl-auto=update
spring.jpa.show-sql=true
spring.jpa.properties.hibernate.dialect=org.hibernate.dialect.MySQL8Dialect
```