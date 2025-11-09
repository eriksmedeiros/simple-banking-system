package br.ufrn.model;

public class Account {
    private Customer customer;
    private double balance;
    private String accountNumber;
    private String accountType;

    public Account(Customer customer, String accountType, String accountNumber) {
        this.customer = customer;
        this.balance = 0.0;
        this.accountNumber = accountNumber;
        this.accountType = accountType;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    public String getAccountNumber() {
        return accountNumber;
    }

    public void setAccountNumber(String accountNumber) {
        this.accountNumber = accountNumber;
    }

    public String getAccountType() {
        return accountType;
    }

    public void setAccountType(String accountType) {
        this.accountType = accountType;
    }
}
