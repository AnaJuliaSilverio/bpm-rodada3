package org.example;

public class Pessoa {
    private int id;
    private String nome;

    public int getId() {
        return id;
    }

    public Pessoa() {

    }

    public Pessoa(int id, String nome) {
        this.id = id;
        this.nome = nome;
    }

    public boolean valido() {
        return this.id > 0 && !this.nome.isEmpty();
    }
}
