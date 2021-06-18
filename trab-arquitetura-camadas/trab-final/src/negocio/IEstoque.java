package negocio;

import negocio.estoque.Estoque;

public interface IEstoque {
    void cadastrarEstoque(Estoque e);

    public Estoque buscarForn(String fornecedor);

    public Estoque buscarProd(String produto);

    public void excluirEstoque(Estoque e);

    public void atualizarEstoque(Estoque e);
}
