# 💰 Sistema Bancário Simples

Um projeto Java que simula operações básicas de um sistema bancário para a disciplina de **Boas Práticas de Programação** do **Bacharelado em Tecnologia da Informação** da **UFRN**.

---

## 🏦 Visão Geral

Este sistema permite o **cadastro de clientes e contas**, **depósitos**, **saques** e **transferências** entre contas, com foco em **arquitetura modular e boas práticas de orientação a objetos**.

A interação acontece por interface de linha de comando (CLI) que permite realizar operações bancárias simuladas, sem uso de banco de dados — todas as informações são mantidas em memória.

---

## ⚙️ Funcionalidades

✅ Cadastro de clientes

✅ Criação de contas bancárias

✅ Depósitos e saques

✅ Transferência entre contas

✅ Listagem de clientes e contas

✅ Exibição de saldo e extrato

✅ Validação de entrada e mensagens de erro amigáveis

---

## 🧩 Estrutura do Projeto

```
simple-banking-system/
├── src/
│   └── main/
│       └── java/
│           └── br/
│               └── ufrn/
│                   ├── exception/       
│                   ├── model/           
│                   ├── repository/      
│                   ├── service/         
│                   ├── utils/           
│                   ├── view/            
│                   └── Main.java        # Classe principal para iniciar a aplicação
│
├── .gitignore                
├── CONTRIBUTING.md           
├── pom.xml                   
└── README.md                 
```

---

## 🧰 Requisitos

* **Java 17+**
* **Maven 3.8+**

---

## 🚀 Execução

### 1. Clone o repositório

```bash
git clone https://github.com/seu-usuario/simple-banking-system.git
cd simple-banking-system
```
### 2. Execute a aplicação

1. Abra o projeto no **IntelliJ IDEA**, **Eclipse** ou **VS Code**.
2. Localize o arquivo principal:

   ```
   src/main/java/br/com/ufrn/Main.java
   ```
3. Clique com o botão direito no arquivo e selecione **Run 'Main'** (ou equivalente na sua IDE).
4. A aplicação será iniciada e exibirá a saída no console integrado da IDE.



---

## 💻 Como Usar

Ao iniciar o programa, você verá um menu interativo no terminal:

```
=== Sistema Bancário Simples ===
1. Cadastrar novo cliente
2. Listar todos os clientes
3. Cadastrar conta
4. Depositar
5. Sacar
6. Listar todas as contas
7. Consultar saldo
8. Transferir entre contas
9. Aplicar rendimento nas poupanças
10. Relatório de consolidação
0. Sair
Escolha uma opção: 
```

Basta escolher uma opção e seguir as instruções exibidas.

---

## 🤝 Contribuindo
Para manter a organização do projeto, siga o fluxo de contribuição abaixo:

Sempre puxe as atualizações mais recentes da branch principal:

```bash
git checkout main
git pull origin main
```

Crie uma nova branch de funcionalidade (feature) a partir da main:

```bash
git checkout -b nome-da-sua-tarefa
```

Após concluir suas alterações e testar, faça o commit e envie sua branch para o repositório remoto:

```bash
git add .
git commit -m "feat: descreva sua alteração"
git push origin nome-da-sua-tarefa
```

Abra um **Pull Request (PR)** da sua branch para a branch **main**.

---

## ✨ Autores

Desenvolvido por:

**Alesandro Silva** 👨‍💻 [@Aerttyz](https://github.com/Aerttyz)

**Erik Medeiros** 👨‍💻 [@erikmedeiros](https://github.com/erikmedeiros)

**Dagson Gabriel** 👨‍💻 [@Dags0n](https://github.com/Dags0n)


