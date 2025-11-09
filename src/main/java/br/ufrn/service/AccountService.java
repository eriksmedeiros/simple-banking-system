package br.ufrn.service;

import java.util.ArrayList;

import br.ufrn.exception.AccountNotFoundException;
import br.ufrn.exception.InsufficientFundsException;
import br.ufrn.model.Account;
import br.ufrn.model.Customer;
import br.ufrn.repository.AccountRepository;
import br.ufrn.repository.CustomerRepository;

public class AccountService {
    private final AccountRepository accountRepository;
    private final CustomerRepository customerRepository;

    public AccountService() {
        this.accountRepository = new AccountRepository();
        this.customerRepository = new CustomerRepository();
    }

    public String registerAccount(String cpf, String accountType) {
        Customer customer = customerRepository.findCustomerByCpf(cpf);
        if (customer == null) {
            throw new IllegalArgumentException("Cliente com CPF informado não existe!");
        }

        String accountNumber = String.valueOf(System.currentTimeMillis());
        while (accountRepository.accountExistsInDatabase(accountNumber)) {
            accountNumber = String.valueOf(System.currentTimeMillis());
        }

        Account account = new Account(customer, accountType, accountNumber);
        accountRepository.saveAccount(account);
        return accountNumber;
    }

    public void deposit(String accountNumber, double amount) {
        if (amount <= 0) {
            throw new IllegalArgumentException("Valor para depósito deve ser positivo.");
        }
        Account account = accountRepository.findByAccountNumber(accountNumber);
        if (account == null) {
            throw new AccountNotFoundException("Conta não encontrada: " + accountNumber);
        }
        accountRepository.addBalance(accountNumber, amount);
    }

    public void withdraw(String accountNumber, double amount) {
        if (amount <= 0) {
            throw new IllegalArgumentException("Valor para saque deve ser positivo.");
        }
        Account account = accountRepository.findByAccountNumber(accountNumber);
        if (account == null) {
            throw new AccountNotFoundException("Conta não encontrada: " + accountNumber);
        }
        if (account.getBalance() < amount) {
            throw new InsufficientFundsException("Saldo insuficiente para saque.");
        }
        accountRepository.withdraw(accountNumber, amount);
    }

    public ArrayList<Account> findAllOrdenedByBalanceDesc() {
        return accountRepository.findAllOrdenedByBalanceDesc();
    }
}
