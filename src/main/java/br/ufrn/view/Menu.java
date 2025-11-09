package br.ufrn.view;

import java.util.Scanner;

public class Menu {
    private final Scanner scanner = new Scanner(System.in);
    private final ViewCustomer viewCustomer;
    private final ViewAccount viewAccount;

    public Menu() {
        this.viewCustomer = new ViewCustomer();
        this.viewAccount = new ViewAccount();
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
            System.out.println("7. Sair");
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
                case 7 -> {
                    System.out.println("Encerrando sistema...");
                    running = false;
                }
                default -> System.out.println("Opção inválida!");
            }
        }
    }
}