public class Pessoa {
    int id;
    String nome;

    static int cont = 0;
    
    public Pessoa(String nome){
        this.setId();
        this.setNome(nome);
    }
    
    private void setId(){
        this.id = ++cont;
    }

    public void setNome(String nome){
        if(nome == null || nome.length() == 0)
            throw new IllegalArgumentException("Nome Invalido!");
        this.nome = nome;
    }   
    
    
    public String getNome() {
        return nome;
    }
    
    public int getId() {
        return id;
    }
}
