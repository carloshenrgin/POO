package negocio;

import negocio.fornecedor.Fornecedor;

public interface IFornecedor {
	void cadastrar(Fornecedor c) throws Exception;

	public Fornecedor buscar(String cpf) throws Exception;

	public void excluir(String cpf) throws Exception;

	public void atualizar(Fornecedor c) throws Exception;
}
