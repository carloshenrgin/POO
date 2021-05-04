/*NOME: CARLOS HENRIQUE SILVA DE OLIVEIRA BUENO
  MATRICULA: 11911BCC005*/

import java.util.Scanner;

public class Principal {
    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);
        Caderneta[] caderninho = new Caderneta[10];
        int indexCaderneta = 0;

        while(true){
            System.out.println("Escolha uma das opcoes a seguir:");
            System.out.println("[1] Cadastrar cliente");
            System.out.println("[2] Criar item na caderneta");
            System.out.println("[3] Listar itens de uma caderneta");
            System.out.println("[4] Sair do programa\n");

            int input = sc.nextInt();
            if(input == 1){
                try{
                    System.out.print("Digite o nome do cliente a ser cadastrado: ");
                    String nome = sc.next();
                    Cliente c = new Cliente(nome);
                    caderninho[indexCaderneta] = new Caderneta(c);
                    indexCaderneta++;
                }
                catch(Exception e){
                    System.out.println(e);
                }
            }
            else if(input == 2){
                if(indexCaderneta == 0)
                    System.out.println("Nenhuma caderneta criada ainda\nImpossivel adicionar");
                else{
                    try{
                        System.out.println("Selecione uma caderneta para adicionar um item:");
                        for(int i = 0; i < indexCaderneta; i++){
                            System.out.println("[" + (i+1) + "]" + " " + caderninho[i].getCl().getNome());
                        }
                        System.out.println();
                        int sel = sc.nextInt();
                        if(sel-1 >= indexCaderneta)
                            System.out.println("Caderneta Invalida");
                        else{
                            System.out.print("Digite o tipo do item (C ou D): ");
                            char tipo = sc.next().charAt(0);
                            System.out.print("Digite o historico do item: ");
                            String historico = sc.next();
                            System.out.print("Digite o valor do item (>= 0): ");
                            float valor = sc.nextFloat();
                            
                            caderninho[sel-1].adicione(tipo, historico, valor);
                        }

                    }
                    catch(Exception e){
                        System.out.println(e);
                    }

                }
            }
            else if(input == 3){
                if(indexCaderneta == 0)
                    System.out.println("Nenhuma caderneta criada ainda\nImpossivel listar");
                else{
                    try{
                        System.out.println("Selecione uma caderneta para listar:");
                        for(int i = 0; i < indexCaderneta; i++){
                            System.out.println("[" + (i+1) + "]" + " " + caderninho[i].getCl().getNome());
                        }
                        System.out.println();
                        int sel = sc.nextInt();
                        if(sel-1 >= indexCaderneta)
                            System.out.println("Caderneta Invalida");
                        else{
                            Item itens[] = caderninho[sel-1].listar();
                            for(int i = 0; i < caderninho[sel-1].getIndex(); i++){
                                System.out.println("[" + (i+1) + "] -------------\n" +itens[i]);
                            }
                            System.out.println("\nSaldo: " + caderninho[sel-1].calculaSaldo());
                        }

                    }
                    catch(Exception e){
                        System.out.println(e);
                    }

                }
            }
            else if(input == 4)
                break;
            else System.out.println("Input Invalido\n");
        }





        sc.close();
    }
}
