/*NOME: CARLOS HENRIQUE SILVA DE OLIVEIRA BUENO
  MATRICULA: 11911BCC005*/

import java.util.ArrayList;

import javax.swing.JOptionPane;

public class Empresa {
    public static void main(String[] args) throws Exception {
        ArrayList <ItemdeEstoque> produtos = new ArrayList<ItemdeEstoque>();
        try{
            produtos.add((Livro) new Livro("O Nome do Vento", 49.9f, 26, 30, "Patrick Rothfuss"));
            produtos.add((CD) new CD("Musicas para Churrasco vol. 1", 27.5f, 18, 25, 10));
            produtos.add((DVD) new DVD("O Segredos dos Animais", 13.5f, 7, 30, 1.5f));
            produtos.add((DVD) new DVD("Ta Dando Onda", 24.9f, 3, 30, 1.4f));
            produtos.add((Livro) new Livro("Guerra dos Tronos", 65.4f, 44, 50, "George R R Martin"));
            produtos.add((CD) new CD("Pagode do Pericao", 32.9f, 22, 45, 10));
        }
        catch (Exception e){
            JOptionPane.showMessageDialog(null, e);
        }
        
        for(int i = 0; i < produtos.size(); i++){
            System.out.println(produtos.get(i));
        }
        System.out.println();

        try{
            produtos.get(0).elevarEstoque(3);
            produtos.get(3).elevarEstoque(14);
            produtos.get(4).baixarEstoque(20);
            produtos.get(5).baixarEstoque(3);
            // Os dois abaixo geram exception
            produtos.get(1).elevarEstoque(10);
            produtos.get(2).baixarEstoque(10);

        }
        catch(Exception e){
            JOptionPane.showMessageDialog(null, e);
        }
        finally{
            for(int i = 0; i < produtos.size(); i++){
                System.out.println(produtos.get(i));
            }
            System.out.println();

            int qtdTotal = 0;
            float valorInvestido = 0;
            for(int i = 0; i < produtos.size(); i++){
                qtdTotal += produtos.get(i).getQtdEstoque();
                valorInvestido += produtos.get(i).getQtdEstoque()*produtos.get(i).getPreco();
            }

            System.out.println("Quantidade em Estoque: " + qtdTotal);
            System.out.println("Valor Investido: " + valorInvestido);
        }


        
    }
}