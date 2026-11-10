# 🏦 Banco Console

Sistema bancário em Java que roda no terminal. Permite criar contas correntes e poupança, fazer saques, depósitos e transferências, e consultar o extrato completo ou de um período.

Projeto criado para praticar **Programação Orientada a Objetos** (herança, polimorfismo, encapsulamento) e regras de negócio de um sistema bancário.

## 📸 Demonstração

```
===== BANCO CONSOLE =====
1 - Criar conta
2 - Sacar
3 - Depositar
4 - Buscar conta
5 - Extrato
6 - Transferir
7 - Extrato por período
0 - Sair
Escolha uma opção:
```


## ✨ Funcionalidades

- Criação de contas (**Corrente** ou **Poupança**)
- Saque
- Depósito
- Busca de conta
- Extrato com todas as transações da conta
- Transferência entre contas
- Extrato filtrado por período

## 🛠️ Tecnologias

- Java 21
- Java Time API (`LocalDate`/`LocalDateTime`) para o filtro por período

## 🚀 Como rodar

**Pré-requisito:** Java 21 ou superior (`java -version` para conferir).

```bash
git clone https://github.com/medeiirosdev-coder/banco-console.git
cd banco-console
```

**Pela IDE (IntelliJ / Eclipse / VS Code):** abra a pasta do projeto e execute a classe `Main`.

**Pelo terminal:**

```bash
# Linux / macOS / Git Bash
javac -d out $(find src -name "*.java")
java -cp out Main
```

```powershell
# Windows (PowerShell)
javac -d out (Get-ChildItem -Recurse src -Filter *.java).FullName
java -cp out Main
```

## 📁 Estrutura

```
src/
 ├── application/     # Interação com o usuário (menu e leitura de dados)
 ├── entities/        # Modelos do domínio: contas e transações
 ├── exceptions/      # Exceções de regra de negócio (ex.: saldo insuficiente)
 ├── repository/      # Armazenamento e busca das contas
 ├── services/        # Regras de negócio: saque, depósito, transferência, extrato
 └── Main.java        # Ponto de entrada da aplicação
```

## 🧠 Decisões técnicas e aprendizados

- Código organizado em camadas (`application` → `services` → `repository`), separando interface, regra de negócio e armazenamento
- Exceções personalizadas em `exceptions` para tratar erros de regra de negócio
- Classe abstrata de conta com `ContaCorrente` e `ContaPoupanca` herdando dela
- Cada operação gera uma transação registrada no histórico da conta
- Uso de `switch` com *arrow syntax* (Java 14+) no menu
- Validações de saldo insuficiente e conta inexistente

> Ajuste essa lista com o que você realmente implementou e aprendeu.

## 🗺️ Próximos passos

- [ ] Persistência em arquivo ou banco de dados
- [ ] Testes unitários com JUnit
- [ ] Rendimento automático da poupança

## 👤 Autor

**André Medeiros Gomes**
[GitHub](https://github.com/medeiirosdev-coder) · [LinkedIn](#)