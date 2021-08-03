import java.util.Scanner;

public class Lista2Exercicio1 {

	public static void main(String[] args) {
		Scanner leia = new Scanner (System.in);
		
		int numero1, numero2, numero3;
		
		System.out.printf("Digite o valor de numero 1: ");
		numero1 = leia.nextInt();
		
		System.out.printf("Digite o valor de numero 2: ");
		numero2 = leia.nextInt();
		
		System.out.printf("Digite o valor de numero 3: ");
		numero3 = leia.nextInt();
		
		if(numero1 > numero2)
		{
			System.out.printf("Numero 1 é maior que numero 2 e numero 3");
			
		}
		else if(numero2 > numero3)
		{
			System.out.printf("Numero 2 é maior que numero 1 e numero 3");
		}
		else
		{
			System.out.printf("Numero 3 é maior que numero 1 e numero 2");
		
		}
		
		
		
		

	}

}
