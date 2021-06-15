/*NOME: CARLOS HENRIQUE SILVA DE OLIVEIRA BUENO
  MATRICULA: 11911BCC005*/

public class CD extends ItemdeEstoque{
    private int nFaixas;

    public int getnFaixas() {
        return nFaixas;
    }

    public void setnFaixas(int nFaixas) throws Exception{
        if(nFaixas <= 0)
            throw new Exception("Numero de Faixas Menor ou Igual a Zero");
        this.nFaixas = nFaixas;
    }

    public CD(String nome, float preco, int qtdEstoque, int estoqueMaximo, int nFaixas) throws Exception {
        super(nome, preco, qtdEstoque, estoqueMaximo);
        this.nFaixas = nFaixas;
    }

    @Override
    public String toString() {
        return super.toString() + ", Numero de Faixas: " + nFaixas;
    }

    
    
}