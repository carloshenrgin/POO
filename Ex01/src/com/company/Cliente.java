package com.company;

public class Cliente {
    static int cont = 1;

    private int id;
    private String nome;

    public Cliente(String nome) {
        this.id = Cliente.cont;
        Cliente.cont++;
        this.setNome(nome);
    }

    public int getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }


    private void setNome(String nome) {
        if(nome.length() > 0 && nome != null)
            this.nome = nome;
    }

    public String toString() {
        return "Cliente [id=" + id + ", nome=" + nome + "]";
    }


}
