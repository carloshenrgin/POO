package com.company;

public class Main {

    public static void main(String[] args) {
        /*
        int cont = 0;
        for(int i = 2; cont<=20;){
            if(Primo.ehPrimo(i)){
                System.out.println(i);
                cont++;
            }
            if(i%2 != 0)
                i+=2;
            else i++;
        } */
        Cliente x = new Cliente("Carleta");
        System.out.println(x);

        Conta y = new Conta(x);
        System.out.println(y);

        y.depositar(400);
        System.out.println(y);
        y.sacar(200);
        System.out.println(y);
        y.sacar(300);
        System.out.println(y);
        y.depositar(100);
        System.out.println(y);



    }
}
