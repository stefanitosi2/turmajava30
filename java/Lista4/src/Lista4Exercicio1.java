import java.util.Scanner;

public class Lista4Exercicio1 {

	public static void main(String[] args) {


		Scanner leia = new Scanner(System.in);
		CodigoExercicio1 cliente1 = new CodigoExercicio1();
		
		System.out.print("Digite o nome do cliente: ");
		cliente1.nome = leia.next();
		System.out.print("Digite o código do cliente: ");
		cliente1.codigoCliente = leia.nextInt();
		System.out.print("Digite o ano de nascimento do cliente: ");
		cliente1.anoNascimento = leia.nextInt();
		
		System.out.println("Nome: "+cliente1.nome);
		System.out.println("Código: "+cliente1.codigoCliente);
		cliente1.idadeCliente();
	}

}
