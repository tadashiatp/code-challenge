# Code Challenge

Este template utiliza os seguintes componentes:

- [Spring Webflux](https://docs.spring.io/spring/docs/current/spring-framework-reference/web-reactive.html) como framework para a criação da API
- [Spring Boot](https://spring.io/projects/spring-boot) para facilitar a configuração e a criação de aplicações web
- [Spring Data R2DBC](https://docs.spring.io/spring-data/r2dbc/docs/current/reference/html/#reference) para a comunicação com o banco de dados
- [Lombok](https://projectlombok.org/) para a geração automática de código
- [SpringDoc OpenAPI](https://springdoc.org/) para a documentação da API
- [Spring Boot Actuator](https://docs.spring.io/spring-boot/docs/current/reference/html/production-ready-features.html) para a monitoração da aplicação
- [Java 21](https://jdk.java.net/21/) como versão do Java
- [R2DBC PostgreSQL](https://r2dbc.io/drivers/postgresql/) como driver do banco de dados

Também terá a opção de escolher se a aplicação irá utilizar:
- [PostgreSQL](https://www.postgresql.org/) como banco de dados

# Objetivo

Autorizar uma transação com cartão de crédito de acordo com sua classificação.

# Como rodar

A aplicação pode ser executada rodando o seguinte comando, dentro de um container:

docker-compose up --build

Outra possibilidade é executar de forma local para fins de desenvolvimento, pode-se subir o banco de dados e após:

./gradlew bootRun

# Healthcheck

Para verificar a disponibilidade da aplicação, há as seguintes rotas disponíveis:

/actuator/health
/actuator/health/liveness
/actuator/health/readiness

# Documentação

Podemos acessar a documentação através do Swagger:

/swagger-ui.html


# TODO

## Transações simultâneas

A ideia futuramente é testar em larga escala o driver reativo R2DBC, lidando com a concorrência e adicionando a estratégia de Pessimist Locking no registro do banco de dados.
Como o tempo para resposta à transação na máquina é baixo, a intenção é que a retentativa possa ser feita para garantir a consistência de todas transações e evitar possíveis fraudes.