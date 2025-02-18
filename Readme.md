# Finance Control API

Uma API REST para controle de investimentos financeiros desenvolvida com Spring Boot.

## Tecnologias Utilizadas

- Java 21
- Spring Boot
- Spring Data JPA
- PostgreSQL
- Docker
- Lombok

## Pré-requisitos

- Java 21 ou superior
- Docker e Docker Compose
- Maven

## Configuração do Ambiente

1. Clone o repositório:
```bash
git clone https://github.com/seu-usuario/financecontrol.git
cd financecontrol
```

2. Configure o banco de dados PostgreSQL usando Docker:
```bash
docker-compose up -d
```

##  Como Executar

1. Compile o projeto:
```bash
mvn clean install
```

2. Execute a aplicação:
```bash
mvn spring-boot:run
```

A API estará disponível em `http://localhost:8080`

##  Endpoints da API

### Investimentos

#### Criar um novo investimento
```http
POST /investments
```
Body:
```json
{
    "investmentName": "Tesouro Direto",
    "investmentAmount": 1000.00
}
```

#### Listar todos os investimentos
```http
GET /investments
```

#### Buscar investimento por ID
```http
GET /investments/{investmentId}
```

#### Atualizar investimento
```http
PUT /investments/{investmentId}
```
Body:
```json
{
    "investmentName": "Novo Nome",
    "investmentAmount": 2000.00
}
```

#### Deletar investimento
```http
DELETE /investments/{investmentId}
```

## Estrutura do Projeto

```
src/
├── main/
│   ├── java/
│   │   └── com/
│   │       └── macielzeferino/
│   │           └── financecontrol/
│   │               ├── controller/
│   │               │   ├── InvestmentController.java
│   │               │   ├── CreateInvestmentDto.java
│   │               │   └── UpdateInvestmentDto.java
│   │               ├── entity/
│   │               │   └── Investment.java
│   │               ├── repository/
│   │               │   └── InvestmentRepository.java
│   │               └── service/
│   │                   └── InvestmentService.java
│   └── resources/
│       └── application.properties
```

##  Modelo de Dados

### Investment

| Campo              | Tipo      | Descrição                           |
|-------------------|-----------|-------------------------------------|
| investmentId      | UUID      | Identificador único do investimento |
| investmentName    | String    | Nome do investimento                |
| investmentAmount  | Double    | Valor do investimento               |
| creationTimestamp | Instant   | Data de criação                     |
| updatedTimestamp  | Instant   | Data da última atualização          |



## Licença

Este projeto está sob a licença MIT. Veja o arquivo [LICENSE](LICENSE) para mais detalhes.

##  Autor

* **Seu Nome** - [Maciel Zeferino](https://github.com/macielzeferino)