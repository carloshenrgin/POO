package negocio.fornecedor;

import dados.RepositorioGenericoTXT;

public class RepositorioFornecedorTXT extends RepositorioGenericoTXT<Fornecedor>{

    @Override
    public Fornecedor create() {
        return new Fornecedor();   
    }
    
}
