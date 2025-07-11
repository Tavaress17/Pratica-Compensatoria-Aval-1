# Prática Compensatória - Avaliação 1

Este projeto é uma API GraphQL construída com Spring Boot, MongoDB e GraphQL Java. A entidade utilizada e escolhida é `Classroom`.

## Tecnologias Utilizadas
- **Java 17+**
- **Spring Boot**
- **Spring Data MongoDB**
- **Spring GraphQL**
- **MongoDB**

## Funcionalidades
- **Listar todas as salas de aula**
- **Buscar sala de aula por ID**
- **Criar nova sala de aula**
- **Atualizar dados de uma sala de aula**
- **Remover sala de aula**

## Estrutura do Projeto
```
├── src/
│   ├── main/
│   │   ├── java/com/ifsp/luan/classroom/
│   │   │   ├── ClassroomApplication.java
│   │   │   ├── controller/ClassroomGraphQLController.java
│   │   │   ├── model/Classroom.java
│   │   │   ├── repository/ClassroomRepository.java
│   │   │   └── service/ClassroomService.java
│   │   └── resources/
│   │       ├── application.properties
│   │       └── graphql/schema.graphqls
├── pom.xml
```

## Como Executar o Projeto

1. **Pré-requisitos:**
   - Java 17 ou superior
   - MongoDB em execução (localhost:27017 por padrão)

2. **Configuração:**
   - Configure o acesso ao MongoDB no arquivo `src/main/resources/application.properties` se necessário.

3. **Build e Execução:**
   - No terminal, execute:
     ```powershell
     ./mvnw spring-boot:run
     ```
   - Ou, se preferir, utilize sua IDE para rodar a classe `ClassroomApplication`.

4. **Acessando o Playground GraphQL:**
   - Após iniciar, acesse o endpoint GraphQL geralmente disponível em `http://localhost:8080/graphql`.

## Exemplo de Queries e Mutations

### Listar todas as salas
```graphql
query {
  classrooms {
    id
    description
    block
    floor
    capacity
    observation
  }
}
```

### Buscar sala por ID
```graphql
query {
  classroom(id: "<ID_DA_SALA>") {
    id
    description
    block
    floor
    capacity
    observation
  }
}
```

### Criar nova sala
```graphql
mutation {
  createClassroom(
    description: "Sala 101"
    block: "A"
    floor: "1"
    capacity: 40
    observation: "Sala equipada com projetor"
  ) {
    id
    description
  }
}
```

### Atualizar sala
```graphql
mutation {
  updateClassroom(
    id: "<ID_DA_SALA>"
    description: "Sala 102"
    capacity: 45
  ) {
    id
    description
    capacity
  }
}
```

### Remover sala
```graphql
mutation {
  deleteClassroom(id: "<ID_DA_SALA>")
}
```

## Estrutura do Modelo `Classroom`
- **id**: Identificador único da sala
- **description**: Descrição da sala
- **block**: Bloco onde a sala está localizada
- **floor**: Andar
- **capacity**: Capacidade de pessoas
- **observation**: Observações adicionais

#### *Este projeto foi desenvolvido para fins acadêmicos.*