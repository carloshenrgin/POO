package negocio.caderneta;

import dados.RepositorioGenericoTXT;

public class RepositorioCadernetaTXT extends RepositorioGenericoTXT<Caderneta>{
    @Override
    public Caderneta create() {
        return new Caderneta();   
    }
}
