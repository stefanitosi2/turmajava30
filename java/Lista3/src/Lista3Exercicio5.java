import java.util.Scanner;

public class Lista3Exercicio5 {

	public static void main(String[] args) {
		Scanner leia = new Scanner (System.in);
		//Crie um programa que leia um n�mero do teclado at� que encontre um n�mero igual a zero. 
		//No final, mostre a soma dos n�meros digitados.(DO...WHILE)
		
		int numero, soma=0;
		
		
		
		
		do
		{
			System.out.println("Digite o numero: ");
			numero= leia.nextInt();
			soma+=numero;
			
		}
		while (numero !=0);
		
			System.out.println("soma � : "+ soma);
			
		

	}

}
