# API de Gerenciamento de Cursos 📚

Esta é uma API RESTful desenvolvida com **Spring Boot**, projetada para gerenciar cursos, estudantes e inscrições. É ideal para aprendizado e pode ser utilizada como um projeto de portfólio.

---

## 🛠️ Funcionalidades
- **Gerenciar Cursos**:
  - Criar, listar, atualizar e deletar cursos.
- **Gerenciar Estudantes**:
  - Criar, listar, atualizar e deletar estudantes.
- **Gerenciar Inscrições**:
  - Inscrever estudantes em cursos.
  - Listar inscrições por estudante ou curso.

---

## 🗂️ Estrutura do Banco de Dados
O banco de dados é composto por três tabelas principais:

### 1. Tabela `curso`
Armazena informações sobre os cursos disponíveis.  
**Colunas**:
- `id` (PK) - Identificador único.
- `nome` - Nome do curso.
- `descricao` - Descrição do curso.
- `carga_horaria` - Carga horária do curso (em horas).
- `data_criacao` - Data de criação do curso.

### 2. Tabela `estudante`
Armazena informações dos estudantes cadastrados.  
**Colunas**:
- `id` (PK) - Identificador único.
- `nome` - Nome do estudante.
- `email` - E-mail do estudante.
- `data_nascimento` - Data de nascimento.
- `data_cadastro` - Data de cadastro no sistema.

### 3. Tabela `inscricao`
Relaciona cursos e estudantes (muitos-para-muitos).  
**Colunas**:
- `id` (PK) - Identificador único.
- `curso_id` (FK) - Referência à tabela `curso`.
- `estudante_id` (FK) - Referência à tabela `estudante`.
- `data_inscricao` - Data da inscrição.

---

## 🚀 Tecnologias Utilizadas
- **Java 21**  
- **Spring Boot 3**  
  - Spring Web
  - Spring Data JPA
  - Bean Validation
- **Banco de Dados**: MySQL  
- **Lombok**  
- **Ferramentas de Desenvolvimento**: Spring Boot DevTools  

---

## 📂 Estrutura do Projeto
```plaintext
src/
├── main/
│   ├── java/com/projeto/todo_list/
│   │   ├── controller/    # Camada Controller
│   │   ├── service/       # Camada Service
│   │   ├── repository/    # Camada Repository
│   │   ├── model/         # Entidades (Curso, Estudante, Inscricao)
│   │   └── dto/           # DTOs para transferência de dados
│   └── resources/
│       ├── application.properties  # Configurações do Spring
├── test/                  # Testes unitários e de integração
