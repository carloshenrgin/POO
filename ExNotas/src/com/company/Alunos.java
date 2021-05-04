package com.company;

public class Alunos {
    public int contador = 1;
    private int matricula;
    private String nome;
    private float prova1, prova2;
    private float trab;

    public Alunos(String nome, float prova1, float prova2, float trab) {
        setNome(nome);
        this.matricula = contador;
        contador++;
        setProva1(prova1);
        setProva2(prova2);
        setTrab(trab);
    }

    public int getMatricula() {
        return matricula;
    }

    public String getNome() {
        return nome;
    }

    public float getProva1() {
        return prova1;
    }

    public float getProva2() {
        return prova2;
    }

    public float getTrab() {
        return trab;
    }

    public void setNome(String nome) {
        if(nome.length() >0 && nome != null)
            this.nome = nome;
        else System.out.println("Nome Invalido\n");
    }

    public void setProva1(float prova1) {
        if(prova1 >= 0 && prova1 <= 100)
            this.prova1 = prova1;
    }

    public void setProva2(float prova2) {
        if(prova2 >= 0 && prova2 <= 100)
            this.prova2 = prova2;
    }

    public void setTrab(float trab) {
        if(trab >= 0 && trab <= 100)
            this.trab = trab;
    }

    public float mediaFinal(){
        return (((prova1+prova2)*2.5f + trab*2.0f)/7.0f);
    }

    public float notaFinal(){
        float media = mediaFinal();
        if(media < 45f)
            return 60-media;
        else return 0;
    }

    @Override
    public String toString() {
        return "Alunos{" +
                ", matricula=" + matricula +
                ", nome='" + nome + '\'' +
                ", prova1=" + prova1 +
                ", prova2=" + prova2 +
                ", trab=" + trab +
                '}';
    }
}