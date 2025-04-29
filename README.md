# 📘 Documentação da API Backend – Sistema de Gestão de Vagas

Este projeto é a API backend que serve o frontend disponível em:  
🔗 [https://github.com/ttkwesley/front-app-teste](https://github.com/ttkwesley/front-app-teste)

## 🧰 Tecnologias Utilizadas

| Ferramenta        | Versão       |
|-------------------|--------------|
| Java              | 17           |
| Spring Boot       | 3.4.5        |
| PostgreSQL        | (via DBeaver)|
| Postman           | (para testes de endpoints) |
| Porta da aplicação| `8081`       |

---

## ✅ Requisitos Funcionais

### 🔐 Autenticação e Autorização
- Sistema de login com autenticação segura.
- Permissões por tipo de usuário (admin/candidato).
- JWT Token para controle de sessões.

### 💼 Cadastro de Vagas
- Administradores podem:
  - Criar novas vagas (`POST /vagas/cadastrar`)
  - Atualizar vagas existentes (`POST /vagas/editar/{id}`)
  - Deletar vagas (`POST /vagas/remover/{id}`) 
  - Listar todas as vagas (`GET /vagas/listar`)

### 📅 Candidatura a Vagas
- Candidatos podem:
  - Ver todas as vagas abertas.
  - Candidatar-se a uma vaga (`POST /candidaturas`)
  - Receber confirmação de candidatura.
- Sistema envia notificações (simuladas) quando usuario recebe um feedback sobre a vaga e para o adm quando um usuario se candidata a vaga do mesmo.

### 🎯 Painel do Candidato
- Funcionalidade para:
  - Listar candidaturas realizadas (`GET /candidaturas/listar/{idUsuario}`)
  - Exibir status da candidatura e feedbacks do RH ou responsável pela vaga.

### 🎯 Painel do Adm 
- Funcionalidade para:
  - Ver candidaturas que foram realizadas nas vagas criadas(`GET /candidaturas/listar/{idUsuario}`)
  - Gerar status da candidatura e feedbacks para o candidato.
  - Remover / Criar / Atualizar vagas.


---

## 🔌 Endpoints principais (exemplos)

| Método | Endpoint                        | Descrição                          |
|--------|----------------------------------|-------------------------------------|
| POST   | `/auth/login`                   | Autenticação do usuário             |
| POST   | `/user/cadastro`                | Criar Usuario (Todos user sao criados como padrao, é necessario dar permissao de adm via banco de dados)             |


---

## 🔧 Como rodar a aplicação localmente

1. Clone o repositório:
   ```bash
   git clone https://github.com/ttkwesley/front-app-teste.git
   ```
2. Importe o projeto no seu IDE (ex: IntelliJ, VS Code).
3. Certifique-se de que o PostgreSQL está rodando.
4. Configure o `application.properties` com suas credenciais de banco de dados.
5. Execute a aplicação (classe `Application.java`).
6. Suba o front end , localizado em 🔗 [https://github.com/ttkwesley/front-app-teste](https://github.com/ttkwesley/front-app-teste)
7. Use o comando ng s para subir o front e poder utilizar a aplicacao de forma web integrada com a api :) 
---

## 🥪 Testes

- Testes de integração podem ser realizados com o **Postman**.
- Requisições devem conter o `Authorization: Bearer <token>` após login.
- O token pode ser adquirido como resposta ao efetuar login

---


