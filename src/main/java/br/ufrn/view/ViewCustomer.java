package br.ufrn.view;

import java.util.Scanner;

import br.ufrn.model.Customer;
import br.ufrn.service.CustomerService;

public class ViewCustomer {
    private final Scanner scanner = new Scanner(System.in);
    private final CustomerService customerService;

    public ViewCustomer(CustomerService customerService) {
        this.customerService = customerService;
    }

    protected void registerCustomer() {
        try {
            System.out.println("Nome: ");
            String name = scanner.nextLine();

            System.out.println("CPF (11 dígitos): ");
            String cpf = scanner.nextLine();

            Customer newCustomer = new Customer(name, cpf);
            customerService.registerCustomer(newCustomer);

            System.out.println("Cliente cadastrado com sucesso: " + newCustomer.toString());
        } catch (Exception e) {
            System.out.println("Erro inesperado: " + e.getMessage());
        }
    }

    protected void listAllCustomers() {
        System.out.println("Lista de Clientes:");
        for (Customer customer : customerService.findAllCustomers()) {
            System.out.println(customer.toString());
        }
    }
}
