package negocio.produto;

import dados.RepositorioGenericoTXT;

public class RepositorioProdutoTXT extends RepositorioGenericoTXT <Produto> {

	@Override
	public Produto create() {
		return new Produto();
	}

}