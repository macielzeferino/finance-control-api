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

### Variáveis de Ambiente
1. Crie um arquivo `.env` na raiz do projeto com as seguintes variáveis:
```properties
POSTGRES_USER=seu_usuario
POSTGRES_PASSWORD=sua_senha
POSTGRES_DB=investments_database
```

2. Clone o repositório:
```bash
git clone https://github.com/seu-usuario/financecontrol.git
cd financecontrol
```

3. Configure o banco de dados PostgreSQL usando Docker:
```bash
docker compose up -d
```

### Configuração do Banco de Dados
O projeto utiliza PostgreSQL como banco de dados, configurado através do Docker Compose. As configurações do banco estão definidas nos seguintes arquivos:

- `.env`: Contém as variáveis de ambiente para configuração do banco
- `docker-compose.yml`: Configuração do container Docker do PostgreSQL
- `application.properties`: Configurações de conexão do Spring Boot com o banco


## Arquivos de Configuração

### application.properties
```properties
spring.application.name=Finance Control Api
spring.datasource.url=jdbc:postgresql://localhost:5432/${POSTGRES_DB}
spring.datasource.username=${POSTGRES_USER}
spring.datasource.password=${POSTGRES_PASSWORD}
spring.datasource.driver-class-name=org.postgresql.Driver
spring.jpa.properties.hibernate.dialect=org.hibernate.dialect.PostgreSQLDialect
spring.jpa.hibernate.ddl-auto=create
spring.jpa.show-sql=true
```

### docker-compose.yml
```yaml
services:
  postgres:
    image: bitnami/postgresql:latest
    container_name: investments_control
    ports:
      - '5432:5432'
    env_file:
      - .env
    environment:
      - POSTGRESQL_USERNAME=${POSTGRES_USER}
      - POSTGRESQL_PASSWORD=${POSTGRES_PASSWORD}
      - POSTGRESQL_DATABASE=${POSTGRES_DB}
    volumes:
      - investments_database:/bitnami/postgresql
volumes:
  investments_database:
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
├── .env                    # Arquivo de variáveis de ambiente
└── docker-compose.yml      # Configuração do Docker
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
**Maciel Zeferino** - [Linkedin](https://www.linkedin.com/in/macielzeferino/)