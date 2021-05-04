/*NOME: CARLOS HENRIQUE SILVA DE OLIVEIRA BUENO
  MATRICULA: 11911BCC005*/

import java.text.SimpleDateFormat;
import javax.swing.*;
import javax.swing.JOptionPane;

public class Item {
    private String dma;
    private char tipo;
    private String historico;
    private float valor;

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

    public void setDma() {
        SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
        this.dma = formatter.format(System.currentTimeMillis()).substring(0, 10);
    }

    public void setTipo(char tipo) throws Exception {
        if(tipo != 'D' && tipo != 'C')
            throw new Exception("Tipo de Lancamento Invalido! O tipo deve ser D ou C");
        else this.tipo = tipo;
    }
    
    private void setHistorico(String historico) throws Exception {
        if(historico == null || historico.length() == 0)
            throw new Exception("Historico Vazio/Invalido!");
        else this.historico = historico;
    }
    
    public void setValor(float valor) throws Exception {
        if(valor <= 0)
            throw new Exception("Valor Invalido (<=0)");
        else this.valor = valor;
    }

    public Item(char tipo, String historico, float valor) throws Exception {
        this.setTipo(tipo);
        this.setHistorico(historico);
        this.setValor(valor);
        this.setDma();
    }

    @Override
    public String toString() {
        return "DD/MM/AAAA TIPO VALOR (R$) HISTORICO\n" +
        dma + " " + tipo + "    R$" + valor + "      " + historico;
    }

    public static void main(String[] args) throws Exception {
        try{
            Item i1 = new Item('D', "Arroz", 22.5f);
            System.out.println(i1);

            //Item i2 =  new Item('A', "pgto", 15.35f);
            //Item i2 = new Item('C', "pgto", 0);
            Item i2 = new Item('C', "", 15.35f);
            System.out.println(i2);
        }
        catch (Exception e){
            JOptionPane.showMessageDialog(null, e);
        }
    }

    
}
