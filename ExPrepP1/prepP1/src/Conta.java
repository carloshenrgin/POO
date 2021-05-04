//import java.util.InputMismatchException;
import java.util.Scanner;

public class Conta {
    int nroConta;
    Pessoa cliente;
    Lancamento[] lanc = new Lancamento[10];
    int contLanc = 0;

    static int contConta = 0;


    public Conta(Pessoa cliente){
        this.cliente = cliente;
        this.nroConta = ++contConta;
    }

    public void adicione(char tipo, String historico, float valor){
        if(this.contLanc >= 10)
            throw new IndexOutOfBoundsException("Limite de Lancamentos Atingido!");
        else{
            lanc[this.contLanc] = new Lancamento(tipo, historico, valor);
            this.contLanc++;
        }
    }

    public void listar(){
        for(int i = 0; i < this.contLanc; i++)
            System.out.println(this.lanc[i] + "\n");
    }

    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);
        Conta acc = null;

        try{
            Pessoa cliente = new Pessoa("Bruno");
            acc = new Conta(cliente);
            acc.adicione('D', "Salario", 1295.8f);
            acc.adicione('D', "Salario", 1295.8f);
            acc.adicione('C', "Batida de Carro", 5500.43f);
            acc.adicione('D', "Salario", 1295.8f);
            acc.adicione('C', "Dentista", 200f);
            acc.adicione('C', "Cirurgia", 3240);
            acc.adicione('D', "Salario", 1295.8f);
            acc.adicione('D', "Salario", 1295.8f);
            acc.adicione('D', "Venda da Bicicleta", 400);
            acc.adicione('C', "Aposta no Poker", 250);
            acc.adicione('C', "Carro Novo", 21584.96f);
            acc.adicione('D', "Salario Atrasado", 1295.8f);
        }
        catch (Exception e){
            System.out.println(e.getMessage()+ "\n");
        }
        finally{
            acc.listar();
            sc.close();
        }
    }
    

}
