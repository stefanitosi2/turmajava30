import java.util.Scanner;

public class Lista4Exercicio2 {

	public static void main(String[] args) {
		Scanner ler = new Scanner(System.in);
		CodigoExercicio2 exemplo1 = new CodigoExercicio2();
		
		
		System.out.print("Digite a quantidade de passageiros: ");
		exemplo1.quantidadePassageiros = ler.nextInt();
		System.out.println("Digite o numero de funcionarios presente no avião: ");
		exemplo1.quantidadeFuncionarios = ler.nextInt();
		
		
		exemplo1.totalPessoas();


	}

}
