package negocio.caderneta;

import java.util.ArrayList;
import java.util.StringTokenizer;

import dados.Gravavel;
import negocio.cliente.Cliente;
import negocio.produto.Produto;

public class Caderneta implements Gravavel {
    static final String SEPARADOR = "#";

    private int id;
    private String nomeCliente;
    private String produtos;

    public int getId() {
        return id;
    }
    
    public void setId(int id) {
        this.id = id;
    }

    public String getNomeCliente() {
        return nomeCliente;
    }

    public void setNomeCliente(String nomeCliente) {
        this.nomeCliente = nomeCliente;
    }

    public String getProdutos() {
        return produtos;
    }

    public void setProdutos(String produtos) {
        this.produtos = produtos;
    }

    @Override
    public String getRegistro(){
        StringBuffer reg = new StringBuffer();
        reg.append(this.getId());
        reg.append(SEPARADOR);
        reg.append(this.getNomeCliente());
        reg.append(SEPARADOR);
        reg.append(this.getProdutos());
        reg.append("\n");

        return reg.toString();
    }

    @Override
    public void setRegistro(String reg){
        StringTokenizer st = new StringTokenizer(reg,SEPARADOR);
		this.setId(Integer.parseInt(st.nextToken()));
		this.setNomeCliente(st.nextToken());
		this.setProdutos(st.nextToken());
    }




    @Override
    public String toString() {
        return "Caderneta [id=" + id + ", nomeCliente=" + nomeCliente + ", produtos=" + produtos + "]";
    }

}

