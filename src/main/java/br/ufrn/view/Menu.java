package br.ufrn.view;

import java.util.Scanner;

import br.ufrn.repository.AccountRepositoryImpls;
import br.ufrn.repository.CustomerRepositoryImpls;
import br.ufrn.repository.IAccountRepository;
import br.ufrn.repository.ICustomerRepository;
import br.ufrn.service.AccountService;
import br.ufrn.service.CustomerService;

public class Menu {
    private final Scanner scanner = new Scanner(System.in);
    private final ViewCustomer viewCustomer;
    private final ViewAccount viewAccount;

    public Menu() {
        ICustomerRepository customerRepository = new CustomerRepositoryImpls();
        IAccountRepository accountRepository = new AccountRepositoryImpls();

        CustomerService customerService = new CustomerService(customerRepository);
        AccountService accountService = new AccountService(accountRepository, customerRepository);

        this.viewCustomer = new ViewCustomer(customerService);
        this.viewAccount = new ViewAccount(accountService);
    }

    public void displayMainMenu() {
        System.out.println("=== Sistema de Banco Simples ===");
        boolean running = true;
        while (running) {
            System.out.println("\n1. Cadastrar novo cliente");
            System.out.println("2. Listar todos os clientes");
            System.out.println("3. Cadastrar conta");
            System.out.println("4. Depositar");
            System.out.println("5. Sacar");
            System.out.println("6. Listar todas as contas");
            System.out.println("7. Consultar saldo");
            System.out.println("8. Transferir entre contas");
            System.out.println("9. Aplicar rendimento nas poupanças");
            System.out.println("10. Relatório de consolidação");
            System.out.println("0. Sair");
            System.out.print("Escolha uma opção: ");
            int option = scanner.nextInt();
            scanner.nextLine();

            switch (option) {
                case 1 -> viewCustomer.registerCustomer();
                case 2 -> viewCustomer.listAllCustomers();
                case 3 -> viewAccount.registerAccount();
                case 4 -> viewAccount.deposit();
                case 5 -> viewAccount.withdraw();
                case 6 -> viewAccount.listAllAccounts();
                case 7 -> viewAccount.checkBalance();
                case 8 -> viewAccount.transfer();
                case 9 -> viewAccount.applyInterest();
                case 10 -> viewAccount.consolidationReport();
                case 0 -> {
                    System.out.println("Encerrando sistema...");
                    running = false;
                }
                default -> System.out.println("Opção inválida!");
            }
        }
    }
}