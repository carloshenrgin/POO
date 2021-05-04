import java.util.Scanner;

public class App {
        public static void main(String[] args){
            int x, y;
            double raio;
            short i = 0;
            String nome;
            Scanner scan = new Scanner(System.in);

            while(true){
                System.out.println("Insira a classe a ser utilizada:\n"+
                "[1] Ponto\n"+
                "[2] Circulo\n"+
                "[3] Sair");
                i = scan.nextShort();
                if(i == 1){
                    System.out.println("Insira as coordenadas do primeiro ponto");
                    x = scan.nextInt();
                    y = scan.nextInt();
            
                    Ponto p1 = new Ponto(x, y);
                    
                    System.out.println("Insira as coordenadas do segundo ponto");
                    x = scan.nextInt();
                    y = scan.nextInt();
            
                    Ponto p2 = new Ponto(x, y);
            
                    System.out.println("Distancia entre o ponto ("
                            + p1.x +", " + p1.y + ") e o ponto ("
                            + p2.x + ", " + p2.y + "): "
                            + p1.dist(p2.x, p2.y));
                }
                else if(i == 2){
                    System.out.println("Insira as coordenadas do centro do circulo");
                    x = scan.nextInt();
                    y = scan.nextInt();
                    System.out.println("Insira o valor do raio do circulo");
                    raio = scan.nextDouble();
                    System.out.print("Insira o nome (?) do circulo\n");
                    scan.nextLine();

                    nome = scan.nextLine();

                    Ponto p = new Ponto(x,y);
                    Circulo c = new Circulo(p, raio, nome);

                    System.out.println(c);

                    System.out.println("Diametro do circulo: " + c.calcDiam() +
                    "\nArea do circulo: " + c.calcArea() +
                    "\nPerimetro do circulo: " + c.calcPerim());
                }
                else if(i == 3) break;
                
            }

            scan.close();
        }

}
