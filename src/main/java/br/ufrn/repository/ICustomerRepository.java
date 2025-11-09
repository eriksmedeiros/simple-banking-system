package br.ufrn.repository;

import java.util.ArrayList;

import br.ufrn.model.Customer;

public interface ICustomerRepository {
    public void save(Customer customer);

    public boolean customerExistsInDatabase(String cpf);

    public Customer findCustomerByCpf(String cpf);

    public ArrayList<Customer> findAll();
}
