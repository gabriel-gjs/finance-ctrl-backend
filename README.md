# FINANCE CTRL API

Projeto de uma API DE Controle Financeiro 🤑.

## 🛠 Tecnologias

- Spring Boot
- Java
- Docker
- PostgreSQL

## Instalação

> Começaramos clonando o projeto e acessando a pasta do projeto:
```
git clone https://github.com/gabriel-gjs/finance-ctrl.git && cd finance-ctrl
```
>Criando o ambiente do projeto local:
- Copie abaixo e cole na nas "environment variables" da IDE e execute a aplicação
```
DATABASE_PASSWORD=pgpassword;DATABASE_USERNAME=pguser;JWT_SECRET=my-secret;SPRING_PROFILES_ACTIVE=dev;DATABASE_URL=jdbc:postgresql://localhost:5432/finance-ctrl
```


>Criando o ambiente do projeto via Docker:
```
docker-compose -f .docker/docker-compose.yml up -d --build
```