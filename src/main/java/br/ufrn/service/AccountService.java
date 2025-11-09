package br.ufrn.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import br.ufrn.exception.AccountNotFoundException;
import br.ufrn.exception.InsufficientFundsException;
import br.ufrn.model.Account;
import br.ufrn.model.Customer;
import br.ufrn.repository.IAccountRepository;
import br.ufrn.repository.ICustomerRepository;

public class AccountService {
    private final IAccountRepository accountRepository;
    private final ICustomerRepository customerRepository;

    public AccountService(IAccountRepository accountRepository, ICustomerRepository customerRepository) {
        this.accountRepository = accountRepository;
        this.customerRepository = customerRepository;
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

    public void transfer(String fromAccountNumber, String toAccountNumber, double amount) {
        if (fromAccountNumber == null || toAccountNumber == null) {
            throw new IllegalArgumentException("Números de conta não podem ser nulos.");
        }
        if (fromAccountNumber.equals(toAccountNumber)) {
            throw new IllegalArgumentException("Conta de origem e destino devem ser diferentes.");
        }
        if (amount <= 0) {
            throw new IllegalArgumentException("Valor para transferência deve ser positivo.");
        }

        Account fromAccount = accountRepository.findByAccountNumber(fromAccountNumber);
        if (fromAccount == null) {
            throw new AccountNotFoundException("Conta de origem não encontrada: " + fromAccountNumber);
        }

        Account toAccount = accountRepository.findByAccountNumber(toAccountNumber);
        if (toAccount == null) {
            throw new AccountNotFoundException("Conta de destino não encontrada: " + toAccountNumber);
        }

        if (fromAccount.getBalance() < amount) {
            throw new InsufficientFundsException("Saldo insuficiente para transferência.");
        }

        accountRepository.withdraw(fromAccountNumber, amount);
        accountRepository.addBalance(toAccountNumber, amount);
    }

    public ArrayList<Account> findAllOrdenedByBalanceDesc() {
        return accountRepository.findAllOrdenedByBalanceDesc();
    }

    public void applyInterestToSavings(double percent) {
        if (percent < 0) {
            throw new IllegalArgumentException("Taxa de rendimento deve ser não-negativa.");
        }

        if (percent == 0) {
            return;
        }

        ArrayList<Account> all = accountRepository.findAllOrdenedByBalanceDesc();
        for (Account acc : all) {
            String type = acc.getAccountType();
            if (type != null && type.toLowerCase().equals("poupanca")) {
                double interest = acc.getBalance() * percent / 100.0;
                if (interest > 0) {
                    accountRepository.addBalance(acc.getAccountNumber(), interest);
                }
            }
        }
    }

    public String getConsolidationReport() {
        ArrayList<Account> all = accountRepository.findAllOrdenedByBalanceDesc();

        Map<String, Integer> counts = new HashMap<>();
        Map<String, Double> sums = new HashMap<>();

        for (Account acc : all) {
            String type = acc.getAccountType() == null ? "Unknown" : acc.getAccountType();
            counts.put(type, counts.getOrDefault(type, 0) + 1);
            sums.put(type, sums.getOrDefault(type, 0.0) + acc.getBalance());
        }

        int totalAccounts = all.size();
        double totalBalance = 0.0;
        for (double v : sums.values()) {
            totalBalance += v;
        }

        StringBuilder sb = new StringBuilder();
        sb.append("Relatório de Consolidação:\n");
        sb.append("Total de contas cadastradas: ").append(totalAccounts).append("\n\n");
        sb.append("Saldos por tipo de conta:\n");
        for (String type : counts.keySet()) {
            sb.append("Tipo: ").append(type)
                    .append(" | Quantidade: ").append(counts.get(type))
                    .append(" | Saldo total: ").append(String.format("%.2f", sums.get(type)))
                    .append("\n");
        }
        sb.append("\nSaldo total do banco: ").append(String.format("%.2f", totalBalance)).append("\n");

        return sb.toString();
    }
}
