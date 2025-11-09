package br.ufrn.service;

import static br.ufrn.utils.CpfValidator.cpfIsValid;

import java.util.ArrayList;

import br.ufrn.exception.CustomerAlreadyExistsException;
import br.ufrn.exception.InvalidCpfException;
import br.ufrn.model.Customer;
import br.ufrn.repository.CustomerRepository;

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

    public Customer findCustomerByCpf(String cpf) {
        for (Customer customer : customerRepository.findAll()) {
            if (customer.getCpf().equals(cpf)) {
                return customer;
            }
        }
        return null;
    }
}
