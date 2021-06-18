package negocio.estoque;

import dados.RepositorioGenericoTXT;

public class RepositorioEstoqueTXT extends RepositorioGenericoTXT<Estoque>{
    @Override
    public Estoque create() {
        return new Estoque();   
    }
}
