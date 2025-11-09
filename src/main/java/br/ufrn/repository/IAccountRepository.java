package br.ufrn.repository;

import java.util.ArrayList;

import br.ufrn.model.Account;

public interface IAccountRepository {
    public boolean accountExistsInDatabase(String accountNumber);

    public void saveAccount(Account account);

    public void addBalance(String accountNumber, double amount);

    public Account findByAccountNumber(String accountNumber);

    public void withdraw(String accountNumber, double amount);

    public ArrayList<Account> findAllOrdenedByBalanceDesc();

}
