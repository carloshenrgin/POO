import java.util.Scanner;

public class Forca{
    boolean alfabeto[] = new boolean[26];
    String palavra;
    String acerto[];
    int tam;
    int erros;
    
    public int getTam(){
        return tam;
    }

    public String getPalavra() {
        return palavra;
    }

    public String[] getAcerto(){
        return acerto;
    }

    public int getErros(){
        return erros;
    }

    private void setTamanho(int tam){
        this.tam = tam;
    }

    private void setPalavra(String palavra){
        // isso garante que a palavra da forca nao vai ter caracteres invalidos
        boolean flag = false;
        char temp[] = new char[this.tam];
        palavra.getChars(0, this.tam, temp, 0);
 
        for(int i = 0; i < this.tam; i++){
            if(Character.isLetter(temp[i]) == false)
                flag = true;
        }

        if(flag == false){
            // guarda a palavra a ser acessada e chama o setter dos acertos
            this.palavra = palavra;
            this.iniAcerto();
        }
    }

    private void iniAcerto(){
        // define quantas casas acerto tem
        this.acerto = new String[this.tam];
        // inicializa as posições de acerto com espaço como pedido
        for(int i = 0; i < this.tam; i++)
            acerto[i] = " ";
    }

    private void setAlf(){
        for(int i = 0; i < this.tam; i++){
            this.alfabeto[i] = false;
        }
    }

    private void setErros(){
        this.erros = 0;
    }

    private boolean verificaOcorrencia(char letra){
        boolean flag = false;
        for(int i = 0; i < this.tam; i ++){
            if(this.palavra.charAt(i) == letra)
                flag = true;
        }
        return flag;
    }

    private void attAcerto(char letra){
        for(int i = 0; i < this.tam; i++){
            if(this.palavra.charAt(i) == letra){
                this.acerto[i] = String.valueOf(letra);
            }
        }
    }

    private void attErro(){
        this.erros++;
    }

    private boolean sinalizaFim(){
        boolean flag = false;
        char temp[] = new char[this.tam];
        for(int i = 0; i < this.tam; i++){
            temp[i] = this.acerto[i].charAt(0);
        }

        String comp = new String(temp);
        if(this.palavra.equals(comp))
            flag = true;
        
        return flag;
    }

    public Forca(String palavra) {
        // define o tamanho da palavra pq precisa
        this.setTamanho(palavra.length());
        // define a palavra
        this.setPalavra(palavra);
        // chama o setter das letras tentadas 
        this.setAlf();
        // setter de erro
        this.setErros();
    }

    public int tentativa(char letra){
        if(this.erros == 6)
            return -2; // qtd max de erros
        //verifica se o caracter passado é uma letra
        //verifica se a letra ja foi tentada
        if(Character.isLetter(letra)){
            this.alfabeto[Character.toLowerCase(letra) - 97] = true;
            if(this.verificaOcorrencia(letra)){
                this.attAcerto(letra);
                if(this.sinalizaFim())
                    return 1; // 1 indica sucesso
            }
            else{
                this.attErro();
                return 0; // 0 indica erro
            }
        }

        return -1; // caracter invalido ou letra ja tentada
    }

    public void bonequinho(int erros){
        switch(erros){
            case 0:
                System.out.println(" |--------- ");
                System.out.println(" |        | ");
                System.out.println(" |          ");
                System.out.println(" |          ");
                System.out.println(" |          ");
                System.out.println(" |          ");
                System.out.println(" |          ");
            break;
            case 1:
                System.out.println(" |--------- ");
                System.out.println(" |        | ");
                System.out.println(" |        O ");
                System.out.println(" |          ");
                System.out.println(" |          ");
                System.out.println(" |          ");
                System.out.println(" |          ");
            break;
            case 2:
                System.out.println(" |--------- ");
                System.out.println(" |        | ");
                System.out.println(" |        O ");
                System.out.println(" |        | ");
                System.out.println(" |          ");
                System.out.println(" |          ");
                System.out.println(" |          ");
            break;
            case 3:
                System.out.println(" |--------- ");
                System.out.println(" |        | ");
                System.out.println(" |        O ");
                System.out.println(" |        |\\");
                System.out.println(" |          ");
                System.out.println(" |          ");
                System.out.println(" |          ");
            break;
            case 4:
                System.out.println(" |--------- ");
                System.out.println(" |        | ");
                System.out.println(" |        O ");
                System.out.println(" |       /|\\");
                System.out.println(" |          ");
                System.out.println(" |          ");
                System.out.println(" |          ");
            break;
            case 5:
                System.out.println(" |--------- ");
                System.out.println(" |        | ");
                System.out.println(" |        O ");
                System.out.println(" |       /|\\");
                System.out.println(" |       /  ");
                System.out.println(" |          ");
                System.out.println(" |          ");
            break;
            case 6:
                System.out.println(" |--------- ");
                System.out.println(" |        | ");
                System.out.println(" |        O ");
                System.out.println(" |       /|\\");
                System.out.println(" |       / \\");
                System.out.println(" |          ");
                System.out.println(" |          ");
            break;

        }
    }




    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);
        Forca forca = new Forca("retrato");
        while(forca.getErros() != 6){
            System.out.println("Digite a letra que deseja tentar: ");
            String letra = sc.next();
            int flag = forca.tentativa(letra.charAt(0));
            if(flag >= 0){
                forca.bonequinho(forca.getErros());
                String out[] = new String[forca.getTam()];
                for(int i = 0; i < forca.getTam(); i++){
                    System.out.print(out[i]);
                    System.out.println();
                }
                if(flag == 0)
                    System.out.println("Voce errou!");
                else System.out.println("Voce acertou!");
            }
            else System.out.println("Caractere Invalido!");
            
            
        }

        System.out.println("Fim de jogo!");

        sc.close();
    }


    
}