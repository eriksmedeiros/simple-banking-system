package br.ufrn.service;

import br.ufrn.exception.CustomerAlreadyExistsException;
import br.ufrn.exception.InvalidCpfException;
import br.ufrn.model.Customer;
import br.ufrn.repository.CustomerRepository;

import java.util.ArrayList;

import static br.ufrn.utils.CpfValidator.cpfIsValid;

public class CustomerService {

    private final CustomerRepository customerRepository;

    public CustomerService() {
        this.customerRepository = new CustomerRepository();
    }

    public void registerCustomer(Customer newCustomer) {
        if (newCustomer == null) {
            throw new IllegalArgumentException("Cliente nulo não pode ser cadastrado!");
        }

        if (!cpfIsValid(newCustomer.getCpf())) {
            throw new InvalidCpfException("CPF inválido!");
        }

        if (customerRepository.customerExistsInDatabase(newCustomer.getCpf())) {
            throw new CustomerAlreadyExistsException("Cliente com esse CPF já cadastrado!");
        }

        customerRepository.save(newCustomer);
    }

    public ArrayList<Customer> findAllCustomers() {
        return customerRepository.findAll();
    }
}
