package br.ufrn.view;

import java.util.Scanner;

import br.ufrn.exception.AccountNotFoundException;
import br.ufrn.exception.InsufficientFundsException;
import br.ufrn.model.Account;
import br.ufrn.service.AccountService;

public class ViewAccount {
    private final Scanner scanner = new Scanner(System.in);
    private final AccountService accountService;

    public ViewAccount(AccountService accountService) {
        this.accountService = accountService;
    }

    protected void registerAccount() {
        try {
            System.out.println("CPF do cliente: ");
            String cpf = scanner.nextLine();
            System.out.println("Tipo de conta (e.g. Corrente/Poupanca): ");
            String accountType = scanner.nextLine();

            String accountNumber = accountService.registerAccount(cpf, accountType);

            System.out.println("Conta cadastrada com sucesso. Número: " + accountNumber);
        } catch (Exception e) {
            System.out.println("Erro inesperado: " + e.getMessage());
        }
    }

    protected void deposit() {
        try {
            System.out.println("Número da conta: ");
            String accountNumber = scanner.nextLine();

            System.out.println("Valor para depósito: ");
            double amount = Double.parseDouble(scanner.nextLine());

            accountService.deposit(accountNumber, amount);
            System.out.println("Depósito realizado com sucesso.");
        } catch (AccountNotFoundException | IllegalArgumentException e) {
            System.out.println("Operação inválida: " + e.getMessage());
        } catch (Exception e) {
            System.out.println("Erro inesperado: " + e.getMessage());
        }
    }

    protected void withdraw() {
        try {
            System.out.println("Número da conta: ");
            String accountNumber = scanner.nextLine();

            System.out.println("Valor para saque: ");
            double amount = Double.parseDouble(scanner.nextLine());

            accountService.withdraw(accountNumber, amount);
            System.out.println("Saque realizado com sucesso.");
        } catch (AccountNotFoundException | IllegalArgumentException | InsufficientFundsException e) {
            System.out.println("Operação inválida: " + e.getMessage());
        } catch (Exception e) {
            System.out.println("Erro inesperado: " + e.getMessage());
        }
    }

    protected void listAllAccounts() {
        System.out.println("Lista de Contas (ordenadas por saldo - decrescente):");
        for (Account acc : accountService.findAllOrdenedByBalanceDesc()) {
            System.out.println("Tipo: " + acc.getAccountType() + " | Nome: " + acc.getCustomer().getName()
                    + " | CPF: " + acc.getCustomer().getCpf() + " | Número: " + acc.getAccountNumber()
                    + " | Saldo: " + acc.getBalance());
        }
    }
}
