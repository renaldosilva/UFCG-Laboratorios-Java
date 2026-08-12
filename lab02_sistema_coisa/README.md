# 📚 Sistema COISA (Controle Institucional da Situação Acadêmica)

**Laboratório 2** da disciplina de Programação 2.

## 🎯 Sobre o Projeto
O sistema **COISA** foi desenvolvido para auxiliar o estudante universitário a gerenciar quatro aspectos fundamentais de sua vida acadêmica:
1. O espaço ocupado nas contas dos laboratórios de computação.
2. O desempenho e horas de estudo nas disciplinas.
3. As finanças e histórico de lanches nas cantinas da universidade.
4. O monitoramento de sua saúde física e mental.

O foco técnico deste projeto é a introdução ao design de software, encapsulamento, ocultação de informação e a interação entre múltiplos objetos autônomos.

## ⚙️ Funcionalidades

- **Conta de Laboratório:** Monitora o uso de armazenamento em MB (megabytes) e alerta quando a cota limite é atingida.
- **Disciplina:** Registra horas de estudo, cadastra até 4 notas e calcula a aprovação (média >= 7.0).
- **Conta na Cantina:** Registra gastos com lanches e pagamentos abatendo o débito ativo.
- **Saúde:** Avalia o status geral do aluno combinando o estado da saúde física e mental (boa ou fraca).

### 🌟 Funcionalidades Bônus (Opcionais Implementadas)
- [ ] Cálculo de média ponderada com array de pesos.
- [ ] Histórico detalhado dos últimos 5 lanches na cantina.
- [ ] Inclusão de emojis para refletir o humor atual no status de saúde.
- [ ] Suporte a múltiplos alunos simultaneamente.
- [ ] Interface via Linha de Comando (CLI).

## 🧠 Conceitos de OO Exercitados
- Criação de Classes Básicas e Construtores.
- Encapsulamento de estado (Atributos privados).
- Métodos acessadores e modificadores.
- Sobrescrita do método `toString()` para representação textual dos objetos.
- Documentação formal de código utilizando **Javadoc**.

## 🚀 Como Executar

1. Clone o repositório principal.
2. Navegue até a pasta deste laboratório: `cd lab02_sistema_coisa`
3. Importe a pasta `src` na sua IDE (Eclipse ou IntelliJ).
4. Execute a classe `Coisa.java` (contém o método `main` com o script de testes validadores).