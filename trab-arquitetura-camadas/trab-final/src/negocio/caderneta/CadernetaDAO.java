package negocio.caderneta;

import dados.CadastroGenerico;
import java.util.ArrayList;
import java.util.Iterator;
import dados.CadastroGenerico;
import dados.Gravavel;
import dados.RepositorioGenericoTXT;

public class CadernetaDAO extends CadastroGenerico<negocio.caderneta.Caderneta>{
    static private int cont;

    public int getNextId() {
		return ++cont;
	}

    @Override
    public Caderneta busca(String chave) throws Exception{
        for (int i = 0; i < this.lista.size(); i++) {
			Caderneta c = lista.get(i);
			if (c.getNomeCliente().equals(chave)){
				return c;
			}
		}
		throw new Exception("Cliente com nome "+chave+" nao encontrado!");
    }

    @Override
	public int buscaPosicao(Caderneta t) throws Exception {
		for (int i = 0; i < this.lista.size(); i++) {
			Caderneta c = lista.get(i);
			if (c == t){
				return i;
			}
		}
		throw new Exception("Caderneta pertencente a "+t.getNomeCliente()+" nao encontrada!");
	}

    public CadernetaDAO() {
		RepositorioGenericoTXT<Caderneta> r = new RepositorioCadernetaTXT();
		r.setNomeArquivo("CADERNETA.TXT");
		this.setRepo(r);
	}

}
