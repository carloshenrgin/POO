package apresentacao;

import java.util.Scanner;

import negocio.IFachadaSistema;
import negocio.Sistema;
import negocio.fornecedor.Fornecedor;

public class Principal {
	public static void main(String[] args) {
		Scanner tecl = new Scanner(System.in);
		IFachadaSistema fc = null;
		try {
			fc = Sistema.getFachada();
			while (true) {
				System.out.println("Informe seu NOME:");
				String nome = tecl.nextLine();

				if (nome.equalsIgnoreCase("fim"))
					break;
				System.out.println("Informe seu CPF:");
				String cpf = tecl.nextLine();

				Fornecedor c = new Fornecedor();
				c.setCPF(cpf);
				c.setNome(nome);
				try {
					fc.cadastrar(c);
					System.out.println("Fornecedor " + c.getNome() + " cadastrado com sucesso!!");
				} catch (Exception e) {
					
					System.out.println(e.getMessage());
				}

			}
		} catch (Exception e) {
			
			System.out.println(e.getMessage());
		}
		tecl.close();
		System.out.println("FIM DO PROGRAMA");
	}

}
