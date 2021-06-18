package negocio.fornecedor;
import java.util.ArrayList;
import java.util.Iterator;
import dados.CadastroGenerico;
import dados.Gravavel;
import dados.RepositorioGenericoTXT;

public class FornecedorDAO extends CadastroGenerico<negocio.fornecedor.Fornecedor> {
    static private int cont;

    public int getNextId() {
		return ++cont;
	}

    @Override
	public Fornecedor busca(String chave) throws Exception {
		for (int i = 0; i < this.lista.size(); i++) {
			Fornecedor c = lista.get(i);
			if (c.getCpf().equals(chave)){
				return c;
			}
		}
		throw new Exception("Fornecedor com chave "+chave+" nao encontrado!");
	}

    @Override
	public int buscaPosicao(Fornecedor t) throws Exception {
		for (int i = 0; i < this.lista.size(); i++) {
			Fornecedor c = lista.get(i);
			if (c == t){
				return i;
			}
		}
		throw new Exception("Fornecedor com "+t.getCpf()+" nao encontrado!");
	}

    public FornecedorDAO() {
		RepositorioGenericoTXT<Fornecedor> r = new RepositorioFornecedorTXT();
		r.setNomeArquivo("FORNECEDOR.TXT");
		this.setRepo(r);
	}

    @Override
	public ArrayList<Fornecedor> recuperar() throws Exception {
		ArrayList <Fornecedor> l = super.recuperar();
		cont = l.get(l.size()-1).getId();
		return l;
		
	}

	// TODO função atualizar


}
