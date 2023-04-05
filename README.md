# API de estudo

## Como rodar
É necessário ter instalado o Java 17. Caso não tenha, pode utilizar o [sdkman](https://sdkman.io/):
```bash
sdk install java 17-open
```
Para rodar o projeto:
```bash
mvn clean install
mvn spring-boot:run
```

## Rotas

| Método | Rota              |
|:-------|:------------------|
| GET    | /api/produto/     |
| GET    | /api/produto/:id  |
| POST   | /api/produto/     |
| PUT    | /api/produto/:id  |
| DELETE | /api/produto/:id  |
