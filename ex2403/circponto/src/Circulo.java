public class Circulo {
    Ponto centro;
    double raio;
    String nome;

    public Ponto getCentro() {
        return centro;
    }

    private void setCentro(Ponto centro) {
        this.centro = centro;
    }

    public double getRaio() {
        return raio;
    }

    private void setRaio(double raio) {
        this.raio = raio;
    }

    public String getNome() {
        return nome;
    }

    private void setNome(String nome) {
        if(nome.length() > 0 && nome != null)
            this.nome = nome;
    }

    public Circulo(Ponto centro, double raio, String nome) {
        this.setCentro(centro);
        this.setNome(nome);
        this.setRaio(raio);
    }

    public double calcDiam(){
        return 2*this.raio;
    }

    public double calcArea(){
        return Math.PI*this.raio*this.raio;
    }

    public double calcPerim(){
        return Math.PI*this.raio*2;
    }

    @Override
    public String toString() {
        return "Circulo [centro=" + centro + ", nome=" + nome + ", raio=" + raio + "]";
    }

    

    

    
}
