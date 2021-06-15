/*NOME: CARLOS HENRIQUE SILVA DE OLIVEIRA BUENO
  MATRICULA: 11911BCC005*/

public class DVD extends ItemdeEstoque{
    private float duracao;

    public float getDuracao() {
        return duracao;
    }

    public void setDuracao(float duracao) throws Exception{
        if(duracao <= 0)
            throw new Exception("Duracao Menor ou Igual a Zero");
        this.duracao = duracao;
    }

    public DVD(String nome, float preco, int qtdEstoque, int estoqueMaximo, float duracao) throws Exception {
        super(nome, preco, qtdEstoque, estoqueMaximo);
        this.duracao = duracao;
    }

    @Override
    public String toString() {
        return super.toString() + ", Duracao da Faixa: " + duracao;
    }
    
}