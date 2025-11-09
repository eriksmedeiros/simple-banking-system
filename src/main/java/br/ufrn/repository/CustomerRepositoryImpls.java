package br.ufrn.repository;

import java.util.ArrayList;

import br.ufrn.model.Customer;

public class CustomerRepositoryImpls implements ICustomerRepository {
    private static final ArrayList<Customer> customerArrayList = new ArrayList<>();

    public CustomerRepositoryImpls() {
    }

    @Override
    public void save(Customer customer) {
        customerArrayList.add(customer);
    }

    @Override
    public boolean customerExistsInDatabase(String cpf) {
        for (Customer customer : customerArrayList) {
            if (customer.getCpf().equals(cpf)) {
                return true;
            }
        }
        return false;
    }

    @Override
    public ArrayList<Customer> findAll() {
        return customerArrayList;
    }

    @Override
    public Customer findCustomerByCpf(String cpf) {
        for (Customer customer : customerArrayList) {
            if (customer.getCpf().equals(cpf)) {
                return customer;
            }
        }
        return null;
    }
}