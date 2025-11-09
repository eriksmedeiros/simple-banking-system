package br.ufrn.repository;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;

import br.ufrn.model.Account;

public class AccountRepository {
    private HashMap<String, Account> accountMap;

    public AccountRepository() {
        this.accountMap = new HashMap<>();
    }

    public void saveAccount(Account account) {
        this.accountMap.put(account.getAccountNumber(), account);
    }

    public boolean accountExistsInDatabase(String accountNumber) {
        return accountMap.containsKey(accountNumber);
    }

    public void addBalance(String accountNumber, double amount) {
        Account account = accountMap.get(accountNumber);
        if (account != null) {
            account.setBalance(account.getBalance() + amount);
        }
    }

    public Account findByAccountNumber(String accountNumber) {
        return accountMap.get(accountNumber);
    }

    public void withdraw(String accountNumber, double amount) {
        Account account = accountMap.get(accountNumber);
        if (account != null) {
            account.setBalance(account.getBalance() - amount);
        }
    }

    public ArrayList<Account> findAllOrdenedByBalanceDesc() {
        ArrayList<Account> list = new ArrayList<>(accountMap.values());
        list.sort(Comparator.comparing(Account::getBalance).reversed());
        return list;
    }
}
