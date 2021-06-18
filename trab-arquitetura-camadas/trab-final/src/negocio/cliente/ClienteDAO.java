package negocio.cliente;
import java.util.ArrayList;
import java.util.Iterator;
import dados.CadastroGenerico;
import dados.Gravavel;
import dados.RepositorioGenericoTXT;

public class ClienteDAO extends CadastroGenerico<negocio.cliente.Cliente> {
    static private int cont;

    public int getNextId() {
		return ++cont;
	}

    @Override
	public Cliente busca(String chave) throws Exception {
		for (int i = 0; i < this.lista.size(); i++) {
			Cliente c = lista.get(i);
			if (c.getCpf().equals(chave)){
				return c;
			}
		}
		throw new Exception("Cliente com chave "+chave+" nao encontrado!");
	}

    @Override
	public int buscaPosicao(Cliente t) throws Exception {
		for (int i = 0; i < this.lista.size(); i++) {
			Cliente c = lista.get(i);
			if (c == t){
				return i;
			}
		}
		throw new Exception("Cliente com "+t.getCpf()+" nao encontrado!");
	}

    public ClienteDAO() {
		RepositorioGenericoTXT<Cliente> r = new RepositorioClienteTXT();
		r.setNomeArquivo("CLIENTE.TXT");
		this.setRepo(r);
	}

    @Override
	public ArrayList<Cliente> recuperar() throws Exception {
		ArrayList <Cliente> l = super.recuperar();
		cont = l.get(l.size()-1).getId();
		return l;
		
	}





}
