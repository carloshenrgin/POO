import java.text.SimpleDateFormat;
import java.util.InputMismatchException;

public class Lancamento {
    String dma;
    char tipo;
    String historico;
    float valor;

    
    private void setDma() {
        SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
        this.dma = formatter.format(System.currentTimeMillis()).substring(0, 10);

        /*if(dma == null || dma.length() != 10 || dma.charAt(2) != '/' || dma.charAt(5) != '/' ||
            Character.getNumericValue(dma.charAt(0)) == -1 || Character.getNumericValue(dma.charAt(1)) == -1 ||
            Character.getNumericValue(dma.charAt(3)) == -1 || Character.getNumericValue(dma.charAt(4)) == -1 ||
            Character.getNumericValue(dma.charAt(6)) == -1 || Character.getNumericValue(dma.charAt(7)) == -1 ||
            Character.getNumericValue(dma.charAt(8)) == -1 || Character.getNumericValue(dma.charAt(9)) == -1)
            throw new InputMismatchException("Formato de Data Invalido! A data deve ser do formato dd/mm/aaaa");
        else{
            int dia = 10*Character.getNumericValue(dma.charAt(0)) + Character.getNumericValue(dma.charAt(1));
            int mes = 10*Character.getNumericValue(dma.charAt(3)) + Character.getNumericValue(dma.charAt(4));
            int ano = (1000*Character.getNumericValue(dma.charAt(6)) + 100*Character.getNumericValue(dma.charAt(7)) 
                + 10*Character.getNumericValue(dma.charAt(8)) + Character.getNumericValue(dma.charAt(9)));
    
    
            if(!(dia > 0 &&  mes > 0 && ano > 0 && ((dia <= 31 && (mes == 1 || mes == 3 || mes == 5 || mes == 7 || mes == 8 || mes == 10 || mes == 12)) ||
                (dia <= 30 && (mes == 4 || mes == 6 || mes == 9 || mes == 11)) || (dia <= 28 && mes == 2))))
                throw new IllegalArgumentException("Data Invalida!");
    
            else this.dma = dma;
        }*/
    }
    
    
    
    private void setTipo(char tipo) {
        if(tipo != 'D' && tipo != 'C')
            throw new InputMismatchException("Tipo de Lancamento Invalido! O tipo deve ser D ou C");
        else this.tipo = tipo;
    }

    
    
    private void setHistorico(String historico) {
        if(historico == null || historico.length() == 0)
            throw new IllegalArgumentException("Historico Vazio/Invalido!");
        else this.historico = historico;
    }
    
    
    
    public void setValor(float valor) {
        if(valor < 0)
            throw new IllegalArgumentException("Valor Invalido!");
        else this.valor = valor;
    }
    
    
    
    public String getDma() {
        return dma;
    }
    
    public char getTipo() {
        return tipo;
    }
    
    public String getHistorico() {
        return historico;
    }
    
    public float getValor() {
        return valor;
    }



    public Lancamento(char tipo, String historico, float valor) {
        this.setDma();
        this.setTipo(tipo);
        this.setHistorico(historico);
        this.setValor(valor);
    }



    @Override
    public String toString() {
        return "DD/MM/AAAA TIPO VALOR (R$) HISTORICO\n" +
               dma + " " + tipo + "    R$" + valor + "      " + historico;
    }

    

}
