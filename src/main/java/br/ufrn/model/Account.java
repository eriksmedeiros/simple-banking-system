package br.ufrn.model;

public class Account {
    private Customer customer;

    public Account(Customer customer) {
        this.customer = customer;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void getCustomer(Customer customer) {
        this.customer = customer;
    }
}
