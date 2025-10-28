# frameworks_java_Fiap

## 🧩 Visão Geral  
Este projeto tem por objetivo demonstrar o uso de **Hibernate ORM** em conjunto com **Jakarta Persistence (JPA)** para trabalhar com mapeamento objeto-relacional, transações e consultas usando **JPQL (Java Persistence Query Language)**.  
O foco está no contexto de frameworks Java voltados para persistência de dados — ideal para estudos ou como base de um módulo backend.

## ⚙️ Tecnologias Utilizadas  
- Java (versão conforme projeto)  
- Jakarta Persistence (JPA)  
- Hibernate ORM como provedor de persistência  
- Maven como sistema de build (arquivo `pom.xml` incluído)  
- Estrutura de projeto seguindo padrão Maven (`src/main/java`, etc)  
- (Banco de dados usado — *você pode especificar: H2, PostgreSQL, MySQL, etc.*)

## 📁 Estrutura do Projeto  
/
├── .idea/ # configuração de IDE (opcional)
├── src/
│ └── main/
│ ├── java/ # pacotes Java do projeto
│ └── resources/ # recursos como persistence.xml, etc.
├── pom.xml # definições do Maven
└── .gitignore


## 🍃 Funcionalidades e Conceitos Aplicados  
- Mapeamento de entidades com anotações JPA (`@Entity`, `@Table`, `@Id`, `@GeneratedValue`, etc.)  
- Configuração de provedor de persistência (Hibernate) no `persistence.xml` ou via `application.properties` (se aplicável)  
- Gerenciamento de transações utilizando `EntityManager` e `EntityTransaction`  
- Consultas com JPQL (ex.: `SELECT`, `UPDATE`, `DELETE`) para manipulação dos dados  
- Exemplo de uso: _(adicione ou substitua pelos exemplos reais destacados no seu código)_  
  ```java
  String jpql = "SELECT e FROM Employee e WHERE e.department = :dept";
  List<Employee> list = em.createQuery(jpql, Employee.class)
                          .setParameter("dept", "TI")
                          .getResultList();

## 🚀 Como Executar

Clone este repositório:

git clone https://github.com/felipesandrade-code/frameworks_java_Fiap.git


## Acesse a pasta do projeto:

cd frameworks_java_Fiap


Configure o banco de dados e credenciais (arquivo persistence.xml ou equivalente).

Compile e rode o projeto:

mvn clean install
mvn exec:java            # ou o comando que você usar para iniciar a aplicação

## 🧾 Considerações Finais

Este repositório serve tanto como base de aprendizado quanto como template para projetos de persistência com JPA/Hibernate. Sinta-se à vontade para adaptar, extender ou integrar em projetos maiores.

# ✍️ Autor

Felipe Silveira Andrade
📧 (feandrade.work@gmail.com)
📌 Estudante de Análise e Desenvolvimento de Sistemas — FIAP
