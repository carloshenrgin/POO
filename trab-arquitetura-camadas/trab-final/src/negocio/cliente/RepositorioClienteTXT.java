package negocio.cliente;

import dados.RepositorioGenericoTXT;

public class RepositorioClienteTXT extends RepositorioGenericoTXT<Cliente>{

    @Override
    public Cliente create() {
        return new Cliente();   
    }
    
}
