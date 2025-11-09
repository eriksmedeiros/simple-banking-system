package br.ufrn.repository;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;

import br.ufrn.model.Account;

public class AccountRepositoryImpls implements IAccountRepository {
    private final HashMap<String, Account> accountMap;

    public AccountRepositoryImpls() {
        this.accountMap = new HashMap<>();
    }

    @Override
    public void saveAccount(Account account) {
        this.accountMap.put(account.getAccountNumber(), account);
    }

    @Override
    public boolean accountExistsInDatabase(String accountNumber) {
        return accountMap.containsKey(accountNumber);
    }

    @Override
    public void addBalance(String accountNumber, double amount) {
        Account account = accountMap.get(accountNumber);
        if (account != null) {
            account.setBalance(account.getBalance() + amount);
        }
    }

    @Override
    public Account findByAccountNumber(String accountNumber) {
        return accountMap.get(accountNumber);
    }

    @Override
    public void withdraw(String accountNumber, double amount) {
        Account account = accountMap.get(accountNumber);
        if (account != null) {
            account.setBalance(account.getBalance() - amount);
        }
    }

    @Override
    public ArrayList<Account> findAllOrdenedByBalanceDesc() {
        ArrayList<Account> list = new ArrayList<>(accountMap.values());
        list.sort(Comparator.comparing(Account::getBalance).reversed());
        return list;
    }
}
