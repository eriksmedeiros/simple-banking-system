package br.ufrn.view;

import java.util.Scanner;

public class Menu {
    private final Scanner scanner = new Scanner(System.in);
    private final ViewCustomer viewCustomer;

    public Menu() {
        this.viewCustomer = new ViewCustomer();
    }

    public void displayMainMenu() {
        System.out.println("=== Sistema de Cadastro de Clientes ===");
        boolean running = true;
        while (running) {
            System.out.println("\n1. Cadastrar novo cliente");
            System.out.println("2. Listar todos os clientes");
            System.out.println("3. Sair");
            System.out.print("Escolha uma opção: ");
            int option = scanner.nextInt();
            scanner.nextLine();

            switch (option) {
                case 1 -> viewCustomer.registerCustomer();
                case 2 -> viewCustomer.listAllCustomers();
                case 3 -> {
                    System.out.println("Encerrando sistema...");
                    running = false;
                }
                default -> System.out.println("Opção inválida!");
            }
        }
    }
}