package com.company;

public class Main {

    public static void main(String[] args) {

        Alunos aluno = new Alunos("Carleta", 70.0f, 65.0f, 80.0f);
        System.out.println(aluno);

        float media = aluno.mediaFinal();
        float quantoPrecisa = aluno.notaFinal();
        System.out.println("Media: " + media + "\nQuanto Falta: " + quantoPrecisa + "\n\n");

        Alunos aluno2 = new Alunos("Carleta Dois", 60.0f, 40.0f, 30.0f);
        System.out.println(aluno2);

        media = aluno2.mediaFinal();
        quantoPrecisa = aluno2.notaFinal();
        System.out.println("Media: " + media + "\nQuanto Falta: " + quantoPrecisa + "\n\n");
    }
}
