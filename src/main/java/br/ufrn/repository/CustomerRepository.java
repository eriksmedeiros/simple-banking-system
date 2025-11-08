package br.ufrn.repository;

import br.ufrn.model.Account;
import br.ufrn.model.Customer;

import java.util.ArrayList;

public class CustomerRepository {
    private final ArrayList<Customer> customerArrayList;

    public CustomerRepository() {
        this.customerArrayList = new ArrayList<>();
    }

    public void save(Customer customer) {
        this.customerArrayList.add(customer);
    }

    public boolean customerExistsInDatabase(String cpf) {
        for (Customer customer : customerArrayList) {
            if (customer.getCpf().equals(cpf)) {
                return true;
            }
        }
        return false;
    }

    public ArrayList<Customer> findAll() {
        return customerArrayList;
    }
}