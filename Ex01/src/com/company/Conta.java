package com.company;

public class Conta {
    static int cont = 1;
    private int nroConta;
    private Cliente cliente;
    private float saldo;

    public Conta(Cliente cliente){
        this.nroConta = cont;
        cont++;
        this.cliente = cliente;
        this.saldo =0;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public float getSaldo() {
        return saldo;
    }

    public int getNroConta() {
        return nroConta;
    }

    public void depositar(float valor){
        saldo += valor;
    }

    public void sacar(float valor){
        if(valor < saldo)
            saldo -= valor;
        else System.out.println("Saldo Insuficiente");
    }

    @Override
    public String toString() {
        return "Conta [" +
                "nroConta=" + nroConta +
                ", cliente=" + cliente +
                ", saldo=" + saldo +
                ']';
    }
}
