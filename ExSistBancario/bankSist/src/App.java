public class App {

    public static void main(String[] args) throws Exception {
        Conta c1 = new Conta(1, "Carmo", 0, 900);
        Conta c2 = new Conta(2, "Alba", 0, 1200);

        System.out.println(c1);
        System.out.println(c2);

        c1.depositaValor(502.35);
        System.out.println(c1);
        c1.sacaValor(300.00);
        System.out.println(c1);
        c1.depositaValor(900);
        System.out.println(c1);
        c1.sacaValor(910);
        System.out.println(c1);

        c1.mostraNome();
        c2.mostraNome();

        c1.transfere(c2, 900);
        System.out.println(c1);
        System.out.println(c2);

    }
}
