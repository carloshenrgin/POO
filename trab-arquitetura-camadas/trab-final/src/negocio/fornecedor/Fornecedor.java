package negocio.fornecedor;

import java.util.StringTokenizer;
import dados.Gravavel;

public class Fornecedor implements Gravavel {
    static final String SEPARADOR = "#";

    private int id;
    private String nome;
    private String cpf;

    public void setNome(String nome){
        this.nome = nome;
    }

    public void setId(int id){
        this.id = id;
    }

    public void setCPF(String cpf){
        this.cpf = cpf;

    }


    public int getId() {
        return id;
    }


    public String getNome() {
        return nome;
    }

    public String getCpf() {
        return cpf;
    }

    @Override
    public String getRegistro(){
        StringBuffer reg = new StringBuffer();
        reg.append(this.getId());
        reg.append(SEPARADOR);
        reg.append(this.getCpf());
        reg.append(SEPARADOR);
        reg.append(this.getNome());
        reg.append("\n");

        return reg.toString();
    }

    @Override
    public void setRegistro(String reg){
        StringTokenizer st = new StringTokenizer(reg,SEPARADOR);
		this.setId(Integer.parseInt(st.nextToken()));
		this.setCPF(st.nextToken());
		this.setNome(st.nextToken());
    }

    @Override
    public String toString() {
        return "Fornecedor [cpf=" + cpf + ", id=" + id + ", nome=" + nome + "]";
    }

    


}
