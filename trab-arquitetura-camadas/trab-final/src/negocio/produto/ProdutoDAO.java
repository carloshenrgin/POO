package negocio.produto;
import java.util.ArrayList;
import java.util.Iterator;

import dados.CadastroGenerico;
import dados.Gravavel;
import dados.RepositorioGenericoTXT;

public class ProdutoDAO extends CadastroGenerico<negocio.produto.Produto> {
	
	static private int cont;
	
	public int getNextId() {
		return ++cont;
	}

	@Override
	public Produto busca(String chave) throws Exception {
		for (int i = 0; i < this.lista.size(); i++) {
			Produto c = lista.get(i);
			if (c.getCodigo().equals(chave)){
				return c;
			}
		}
		throw new Exception("Produto com chave "+chave+" nao encontrado!");
	}

	@Override
	public int buscaPosicao(Produto t) throws Exception {
		for (int i = 0; i < this.lista.size(); i++) {
			Produto c = lista.get(i);
			if (c == t){
				return i;
			}
		}
		throw new Exception("Produto com "+ t.getCodigo()+" nao encontrado!");
	}


	public ProdutoDAO() {
		RepositorioGenericoTXT<Produto> r = new RepositorioProdutoTXT();
		r.setNomeArquivo("PRODUTO.TXT");
		this.setRepo(r);
	}
	
	

	@Override
	public ArrayList<Produto> recuperar() throws Exception {
		ArrayList <Produto> l = super.recuperar();
		cont = l.get(l.size()-1).getId();
		return l;
		
	}
	
	
	
}