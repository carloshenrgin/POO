package negocio;

import negocio.estoque.Estoque;

public interface IEstoque {
    void cadastrarEstoque(Estoque e) throws Exception;

    public Estoque buscarEstoque(String fornecedor) throws Exception;

    public void excluirEstoque(String fornecedor) throws Exception;

    public void atualizarEstoque(Estoque e) throws Exception;
}
