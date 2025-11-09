package br.ufrn.repository;

import java.util.ArrayList;

import br.ufrn.model.Customer;

public class CustomerRepository {
    private static final ArrayList<Customer> customerArrayList = new ArrayList<>();

    public CustomerRepository() {
    }

    public void save(Customer customer) {
        customerArrayList.add(customer);
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

    public Customer findCustomerByCpf(String cpf) {
        for (Customer customer : customerArrayList) {
            if (customer.getCpf().equals(cpf)) {
                return customer;
            }
        }
        return null;
    }
}