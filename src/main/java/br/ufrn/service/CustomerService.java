package br.ufrn.service;

import br.ufrn.model.Customer;

import static br.ufrn.utils.CustomerValidator.cpfIsValid;
import static br.ufrn.utils.CustomerValidator.customerExistsInDatabase;

public class CustomerService {

    private Customer registerCustomer(Customer newCustomer) {
        if (newCustomer == null) {return null;}

        if(cpfIsValid(newCustomer.getCpf()) && !customerExistsInDatabase(newCustomer)) {
            // Logic to save the customer to the database would go here
            return newCustomer; // Simulating successful registration
        }

        return null;
    }

}
