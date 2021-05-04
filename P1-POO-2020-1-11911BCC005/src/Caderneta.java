/*NOME: CARLOS HENRIQUE SILVA DE OLIVEIRA BUENO
  MATRICULA: 11911BCC005*/

public class Caderneta {
    private int id;
    private Cliente cl;
    private Item[] itens;
    private int contItem = 0;

    private static int contId = 0;

    public Caderneta(Cliente cl) throws Exception {
        this.setCliente(cl);
        this.id = ++contId;
        this.itens = new Item[10];
    }

    private void setCliente(Cliente cl) throws Exception{
        if(cl == null)
            throw new Exception("Cliente Invalido");
        else this.cl = cl;
    }

    public int getId() {
        return id;
    }

    public Cliente getCl() {
        return cl;
    }

    public int getIndex(){
        return contItem;
    }

    public void adicione(char tipo, String historico, float valor) throws Exception{
        if(this.contItem >= 10)
            throw new Exception("Quantidade Maxima de Itens Atingida");
        else{
            Item item = new Item(tipo, historico, valor);
            this.itens[this.contItem] = item;
            this.contItem++;
        }
    }

    public Item[] listar(){
        return this.itens;
    }

    public float calculaSaldo(){
        float saldo = 0;
        for(int i = 0; i < this.contItem; i++){
            if(this.itens[i].getTipo() == 'C')
                saldo += this.itens[i].getValor();
            else if(this.itens[i].getTipo() == 'D')
                saldo -= this.itens[i].getValor();
        }

        return saldo;
    }

    public static void main(String[] args) throws Exception {
        Cliente c1 = null;
        Caderneta cad = null;
        try{
            c1 = new Cliente("nome");
        }
        catch(Exception e){
            System.out.println(e);
        }

        try{
            cad = new Caderneta(c1);
        }
        catch(Exception e){
            System.out.println(e);
        }

        try{
            cad.adicione('D', "Qualquer", 20);
        }
        catch(Exception e){
            System.out.println(e);
        }

        try{
            String temp = "Qualquer";
            for(int i = 0; i < 10; i++){
                cad.adicione('C', "Qualquer" + String.valueOf(i), 10);
            }
        }
        catch(Exception e){
            System.out.println(e);
        }

        System.out.println("Saldo: " + cad.calculaSaldo());
        Item[] it = cad.listar();

        for(int i = 0; i < 10; i++){
            System.out.println("Item " + (i+1) + " " +it[i]);
        }

        Cliente c2 = null;
        Caderneta cad2 = null;
        try{
            c2 = new Cliente("");
        }
        catch(Exception e){
            System.out.println(e);
        }

        try{
            cad2 = new Caderneta(c2);
        }
        catch(Exception e){
            System.out.println(e);
        }

    }


    
}
