# Sistema de Cadastro de Clientes - Java Swing

Este projeto é uma aplicação desktop simples desenvolvida em Java utilizando Swing. Ele possui um sistema de login, uma tela inicial com botão de navegação e um módulo de cadastro de clientes com validação de dados. Os dados inseridos podem ser visualizados em forma de tabela e exportados para um arquivo `.txt`.

## 🧠 Funcionalidades

- **Login com validação simples**
- **Tela inicial com opção de cadastro**
- **Cadastro de clientes com validação de campos**
- **Visualização dos dados cadastrados em formato de tabela**
- **Geração de arquivo `.txt` com os dados do cliente**
- **Edição de aluno (Atualizar)**
- **Exclusão de aluno**
- **CRUD Completo**

## 🖥️ Telas do Sistema

- **Tela de Login**
- **Tela Inicial (Home)**
- **Formulário de Cadastro de Cliente**
- **Tabela de Visualização dos Dados do Cliente**

## 📁 Estrutura dos Arquivos

- `loginSistema.java`: Tela inicial com login.
- `homeInterface.java`: Tela principal com botão de acesso ao cadastro.
- `CadastroClientes.java`: Formulário com validações para o cadastro.
- `clientesTable.java`: Exibição dos dados do cliente cadastrado e geração do arquivo `.txt`.
- `Cliente.java`: Classe modelo com os atributos do cliente.
- `BancoClientes.java`: Classe para conseguir atualizar um cliente existente

## 📋 Validações Implementadas

- **Código:** Apenas números.
- **Nome:** Apenas letras.
- **Endereço, Bairro, Cidade:** Campo obrigatório.
- **Estado:** Deve ser selecionado.
- **Telefone e CEP:** Apenas números.
- **Observações:** Campo opcional (preenchido como "SEM OBSERVAÇÕES" se vazio).

## 📂 Geração de Arquivo

O botão "Gerar Arquivo" na tela de visualização cria um arquivo chamado `dados_aluno.txt` na pasta **Downloads** do sistema operacional, contendo os dados do cliente formatados.

## 🧪 Como Executar

1. Clone ou baixe o repositório.
2. Abra o projeto em uma IDE como IntelliJ IDEA ou Eclipse.
3. Certifique-se de que todos os arquivos `.java` estejam no mesmo pacote.
4. Execute o arquivo `loginSistema.java`.

## ✅ Credenciais para Teste

- **Usuário:** Henrick
- **Senha:** 12345

## 📌 Requisitos

- Java JDK 8 ou superior
- IDE compatível com Java Swing (Eclipse, IntelliJ IDEA, etc.)

## 🛠️ Melhorias Futuras

- Conexão com banco de dados para persistência real dos dados
- Criptografia de senhas
- Sistema de múltiplos usuários
- Validações mais robustas com máscaras de campos
- Estilização aprimorada das interfaces

---

Desenvolvido com 💻 por **Henrick de Lima Borba**  