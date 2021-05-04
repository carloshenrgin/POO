/*NOME: CARLOS HENRIQUE SILVA DE OLIVEIRA BUENO
  MATRICULA: 11911BCC005*/
  
public class Cliente {
    private int id;
    private String nome;

    private static int cont = 0;

    private void setNome(String nome) throws Exception{
        if(nome == null || nome.length() == 0)
            throw new Exception("Nome Invalido");
        else this.nome = nome;
    }

    public int getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }

    public Cliente(String nome) throws Exception {
        this.setNome(nome);
        this.id = ++cont;
    }

    @Override
    public String toString() {
        return "Cliente [id=" + id + ", nome=" + nome + "]";
    }
    
    public static void main(String[] args) throws Exception {
        try{
            Cliente c1 = new Cliente("seu nome");
            System.out.println(c1);
    
            Cliente c2 = new Cliente("");
            System.out.println(c2);
        }
        catch(Exception e){
            System.out.println(e);
        }

    }
    
}
