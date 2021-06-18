package negocio.estoque;

import dados.CadastroGenerico;
import java.util.ArrayList;
import java.util.Iterator;
import dados.CadastroGenerico;
import dados.Gravavel;
import dados.RepositorioGenericoTXT;

public class EstoqueDAO extends CadastroGenerico<negocio.estoque.Estoque>{
    static private int cont;

    public int getNextId() {
		return ++cont;
	}

    @Override
    public Estoque busca(String chave) throws Exception{
        for (int i = 0; i < this.lista.size(); i++) {
			Estoque c = lista.get(i);
			if (c.getNomeFornecedor().equals(chave)){
				return c;
			}
		}
		throw new Exception("Cliente com nome "+chave+" nao encontrado!");
    }

    @Override
	public int buscaPosicao(Estoque t) throws Exception {
		for (int i = 0; i < this.lista.size(); i++) {
			Estoque c = lista.get(i);
			if (c == t){
				return i;
			}
		}
		throw new Exception("Estoque pertencente a "+t.getNomeFornecedor()+" nao encontrada!");
	}

    public EstoqueDAO() {
		RepositorioGenericoTXT<Estoque> r = new RepositorioEstoqueTXT();
		r.setNomeArquivo("ESTOQUE.TXT");
		this.setRepo(r);
	}

}
