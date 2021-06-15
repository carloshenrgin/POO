/*NOME: CARLOS HENRIQUE SILVA DE OLIVEIRA BUENO
  MATRICULA: 11911BCC005*/

public class ItemdeEstoque {
    private int id;
    private String nome;
    private float preco;
    private int qtdEstoque;
    private int estoqueMaximo;
    private static int cont = 0;

    private void setId() {
        this.id = ++cont;
    }

    public void setNome(String nome) throws Exception{
        if(nome == null || nome.length() == 0)
            throw new Exception ("Nome Invalido");
        this.nome = nome;
    }

    public void setPreco(float preco) throws Exception{
        if(preco <= 0)
            throw new Exception("Preco Menor ou Igual a Zero");
        this.preco = preco;
    }

    public void setQtdEstoque(int qtdEstoque) throws Exception{
        if(qtdEstoque < 0 || qtdEstoque > this.estoqueMaximo)
            throw new Exception("Quantidade Negativa ou Excede o Limite de Estoque");
        this.qtdEstoque = qtdEstoque;
    }

    public void setEstoqueMaximo(int estoqueMaximo) throws Exception{
        if(estoqueMaximo < 0)
            throw new Exception("Quantidade de Estoque Menor que Zero");
        this.estoqueMaximo = estoqueMaximo;
    }

    

    public ItemdeEstoque(String nome, float preco, int qtdEstoque, int estoqueMaximo) throws Exception {
        this.setId();
        this.setEstoqueMaximo(estoqueMaximo);
        this.setQtdEstoque(qtdEstoque);
        this.setNome(nome);
        this.setPreco(preco);

    }


    public int getId() {
        return id;
    }
    
    public String getNome() {
        return nome;
    }
    
    public float getPreco() {
        return preco;
    }

    public int getQtdEstoque() {
        return qtdEstoque;
    }
    
    public int getEstoqueMaximo() {
        return estoqueMaximo;
    }

    @Override
    public String toString() {
        return "Item -> ID: " + id + ", Nome: " + nome + ", Preco: " + preco + ", Quantidade em Estoque: " + qtdEstoque + ", Estoque Maximo: " + estoqueMaximo;
    }

    public void baixarEstoque(int quantidade) throws EstoqueBaixoException{
        if(quantidade > this.qtdEstoque)
            throw new EstoqueBaixoException("Quantidade " + this.qtdEstoque + " em estoque insuficiente para atender demanda de " + quantidade);
        this.qtdEstoque -= quantidade;
    }

    public void elevarEstoque(int quantidade) throws EstoqueElevadoException{
        if(this.qtdEstoque + quantidade > this.estoqueMaximo)
            throw new EstoqueElevadoException();
        this.qtdEstoque += quantidade;
    }

    

}

