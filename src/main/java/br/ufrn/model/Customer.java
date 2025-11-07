package br.ufrn.model;

import java.time.LocalDate;

public class Customer {
    private static Long idCounter = 0L;
    private Long Id;
    private String name;
    private String cpf;
    private LocalDate birthDate;

    public Customer(String name, String cpf, String email, LocalDate birthDate) {
        this.Id = generateId();
        this.name = name;
        this.cpf = cpf;
        this.birthDate = birthDate;
    }

    public Long getId() {
        return Id;
    }

    public void setId(Long id) {
        Id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public LocalDate getbirthDate() {
        return birthDate;
    }

    public void setbirthDate(LocalDate birthDate) {
        this.birthDate = birthDate;
    }

    public Long generateId() {
        return ++idCounter;
    }

    @Override
    public String toString() {
        return "Cliente{" +
                "Nome ='" + name + '\'' +
                ", CPF='" + cpf + '\'' +
                ", Data de Nascimento=" + birthDate +
                '}';
    }
}
