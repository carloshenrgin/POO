/*NOME: CARLOS HENRIQUE SILVA DE OLIVEIRA BUENO
  MATRICULA: 11911BCC005*/

public class Livro extends ItemdeEstoque{
    private String autor;

    public String getAutor() {
        return autor;
    }

    public void setAutor(String autor) throws Exception{
        if(autor == null || autor.length() == 0)
            throw new Exception("Autor Invalido");
        this.autor = autor;
    }

    public Livro(String nome, float preco, int qtdEstoque, int estoqueMaximo, String autor) throws Exception {
        super(nome, preco, qtdEstoque, estoqueMaximo);
        this.setAutor(autor);
    }

    @Override
    public String toString() {
        return super.toString() + ", Autor: " + autor;
    }

}