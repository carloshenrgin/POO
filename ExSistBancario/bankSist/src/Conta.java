public class Conta {
    private int numConta;
    private String nomeDono;
    private double saldo;
    private double lim;
    
    public int getNumConta() {
        return numConta;
    }
    private void setNumConta(int numConta) {
        this.numConta = numConta;
    }
    public String getNomeDono() {
        return nomeDono;
    }
    private void setNomeDono(String nomeDono) {
        if(nomeDono.length() > 0 && nomeDono != null)
            this.nomeDono = nomeDono;
    }
    public double getSaldo() {
        return saldo;
    }
    private void setSaldo(float saldo) {
        if(saldo >= 0)
            this.saldo = saldo;
    }
    public double getLim() {
        return lim;
    }
    private void setLim(float lim) {
        if(lim >= 0)
            this.lim = lim;
    }

    public Conta(int numConta, String nomeDono, float saldo, float lim) {
        setNumConta((numConta));
        setNomeDono(nomeDono);
        setLim(lim);
        setSaldo(saldo);
    }

    public boolean sacaValor(double valor){
        if(valor >= 0 && valor <= this.lim && valor <= this.saldo){
            this.saldo -= valor;
            return true;
        }

        return false;
    }

    public void depositaValor(double valor){
        if(valor >= 0)
            this.saldo += valor;
    }

    public void mostraNome(){
        System.out.println("Nome do Dono: "+this.nomeDono);
    }

    public boolean transfere(Conta destino, double valor){
        if(this.sacaValor(valor) == false)
            return false;

        destino.depositaValor(valor);
        return true;
    }

    
    @Override
    public String toString() {
        return "Conta [lim=" + lim + ", nomeDono=" + nomeDono + ", numConta=" + numConta + ", saldo=" + saldo + "]";
    }

    

    
}
