package negocio.estoque;

import java.util.ArrayList;
import java.util.StringTokenizer;

import dados.Gravavel;
import negocio.fornecedor.Fornecedor;
import negocio.produto.Produto;

public class Estoque implements Gravavel {
    static final String SEPARADOR = "#";

    private int id;
    private String nomeFornecedor;
    private String produto;

    public int getId() {
        return id;
    }
    
    public void setId(int id) {
        this.id = id;
    }

    public String getNomeFornecedor() {
        return nomeFornecedor;
    }

    public void setNomeFornecedor(String nomeFornecedor) {
        this.nomeFornecedor = nomeFornecedor;
    }

    public String getProduto() {
        return produto;
    }

    public void setProduto(String produto) {
        this.produto = produto;
    }

    @Override
    public String getRegistro(){
        StringBuffer reg = new StringBuffer();
        reg.append(this.getId());
        reg.append(SEPARADOR);
        reg.append(this.getNomeFornecedor());
        reg.append(SEPARADOR);
        reg.append(this.getProduto());
        reg.append("\n");

        return reg.toString();
    }

    @Override
    public void setRegistro(String reg){
        StringTokenizer st = new StringTokenizer(reg,SEPARADOR);
		this.setId(Integer.parseInt(st.nextToken()));
		this.setNomeFornecedor(st.nextToken());
		this.setProduto(st.nextToken());
    }




    @Override
    public String toString() {
        return "Estoque [id=" + id + ", nomeFornecedor=" + nomeFornecedor + ", produto=" + produto + "]";
    }

}

