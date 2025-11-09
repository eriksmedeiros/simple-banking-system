package br.ufrn.repository;

import br.ufrn.model.Account;
import br.ufrn.model.Customer;

import java.util.ArrayList;

public class BankRepository {
    private final ArrayList<Account> accountArrayList;

    public BankRepository() {
        this.accountArrayList = new ArrayList<>();
    }

    public void saveAccount(Account account) {
        this.accountArrayList.add(account);
    }
}
