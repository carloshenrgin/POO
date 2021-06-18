package negocio.produto;

import java.util.StringTokenizer;

import dados.Gravavel;

public class Produto implements Gravavel{
    static final String SEPARADOR = "#";
	
	private String descricao;
	private String codigo;
	private int id;

    public String getDescricao() {
		return descricao;
	}

    public void setDescricao(String nome) {
		this.descricao = nome;
	}

    public String getCodigo() {
		return codigo;
	}

    public void setCodigo(String codigo) {
		this.codigo = codigo;
	}

    public int getId() {
		return id;
	}

    public void setId(int id) {
		this.id = id;
	}

    @Override
	public String getRegistro() {
		
		StringBuffer reg = new StringBuffer();
		reg.append(this.getId());
		reg.append(SEPARADOR);
		reg.append(this.getCodigo());
		reg.append(SEPARADOR);
		reg.append(this.getDescricao());
		reg.append("\n");
		
		return reg.toString();
	}

    @Override
	public void setRegistro(String reg) {
		StringTokenizer st = new StringTokenizer(reg,SEPARADOR);
		this.setId(Integer.parseInt(st.nextToken()));
		this.setCodigo(st.nextToken());
		this.setDescricao(st.nextToken());
	}

    @Override
	public String toString() {
		return "Cliente [id=" + id +", cpf=" + codigo + ", nome=" + descricao +  "]";
	}
}
