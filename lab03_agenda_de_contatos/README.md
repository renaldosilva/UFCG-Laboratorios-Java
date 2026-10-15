# 📇 Sistema Agenda de Contatos

**Laboratório 3** da disciplina de Programação 2.

## 🎯 Sobre o Projeto
O sistema **Agenda de Contatos** foi desenvolvido para permitir o cadastro e a visualização de contatos pessoais. Cada contato é representado por:
1. Nome e sobrenome.
2. Até 3 telefones.
3. Um telefone prioritário (principal).
4. Um número de contato via WhatsApp (zap).

A agenda comporta até **100 contatos**, cada um identificado por sua posição (de 1 a 100) na lista.

O foco técnico deste projeto é a composição entre objetos (Agenda e Contato), a implementação do método `equals`, a introdução a testes de unidade com **JUnit** e o tratamento de erros com exceções.

## ⚙️ Funcionalidades

- **Cadastrar Contato:** Cadastra um contato em uma posição válida (1 a 100). Se a posição já estiver ocupada, o contato existente é substituído. Posições inválidas abortam a operação e exibem a mensagem `POSIÇÃO INVÁLIDA`.
- **Listar Contatos:** Exibe todos os contatos cadastrados com sua posição e nome completo.
- **Exibir Contato:** Exibe os detalhes de um contato (nome completo, telefone prioritário e zap) a partir da sua posição na lista.
- **Telefones Preferidos:** Lista o telefone prioritário de cada contato.
- **Zaps:** Lista o número de WhatsApp de cada contato (ou `Não tem`, quando não houver).
- **Menu Interativo:** Interface via linha de comando com tratamento de opções inválidas.

### 🌟 Funcionalidades Bônus
- [ ] Tratamento de entradas inválidas: `NullPointerException` para argumentos nulos e `IllegalArgumentException` para strings vazias ou compostas apenas por espaços no construtor de `Contato`.
- [ ] Testes JUnit para as exceções lançadas.
- [ ] Telefone com DDD, número, código de país e tipo (`CELULAR`, `TRABALHO`, `CASA`).
- [ ] Nível de amizade nos contatos (de 1 a 5: distante, colega, amigo, amigão, irmão).
- [ ] Consulta de contatos por nome e por contato.
- [ ] Consulta por nível de amizade, contagem por nível e média de amizade da agenda.

## 🧠 Conceitos de OO Exercitados
- Composição entre objetos (a `Agenda` possui um array de `Contato`) e uso de delegação.
- Implementação do método `equals` (contatos iguais têm o mesmo nome e sobrenome; agendas iguais têm os mesmos contatos nas mesmas posições).
- Sobrescrita do método `toString()` para representação textual dos objetos.
- Separação de responsabilidades: nenhuma classe além da principal imprime com `System.out`.
- Testes de unidade com **JUnit 5** (`@Test`, `@BeforeEach` e asserções), explorando valores limite (posições 0, 1, 100 e 101).
- Tratamento de erros com exceções (`NullPointerException` e `IllegalArgumentException`).
- Documentação formal de código utilizando **Javadoc**.

## 🚀 Como Executar

1. Clone o repositório principal.
2. Navegue até a pasta deste laboratório: `cd lab03_agenda_contatos`
3. Importe o projeto na sua IDE (Eclipse ou IntelliJ), marcando a pasta `src` como código de produção e a pasta `testes` como código de teste.
4. Adicione a biblioteca **JUnit 5** ao *build path* do projeto.
5. Execute a classe `MainAgenda.java` (contém o método `main` com o menu da agenda).
6. Para rodar os testes, clique com o botão direito na pasta `testes` e selecione **Run as > JUnit Test**.
