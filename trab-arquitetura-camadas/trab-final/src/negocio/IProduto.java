package negocio;

import negocio.produto.Produto;

public interface IProduto {
	void cadastrarProduto(Produto p) throws Exception;

	public Produto buscarProduto(String codigo) throws Exception;
	
	public void excluirProduto(String p) throws Exception;
	
	public void atualizarProduto(Produto p) throws Exception;
}
